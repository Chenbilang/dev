package com.example.demo22.service.impl;


import com.example.demo22.constants.CommonConstant;
import com.example.demo22.dao.LabelMapper;
import com.example.demo22.pojo.SysLabel;
import com.example.demo22.service.LabelService;
import com.github.pagehelper.PageHelper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.logging.Logger;

/**
 * 标签管理服务接口实现类
 * @author chenbilang
 */
@Service("labelService")
public class LabelServieImpl implements LabelService {

    @Autowired
    private LabelMapper labelMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public List<SysLabel> list(Map<String, Object> param) {
        String key= CommonConstant.REIDS_KEY+"_"+param.get("pageNo")+"_"+param.get("pageSize");
        List<SysLabel> list=new ArrayList<SysLabel>();
        list= (List<SysLabel>) redisTemplate.opsForValue().get(key);
        if(list==null){
            String pageNoAndSize=param.get("pageNo")+"_"+param.get("pageSize");
            PageHelper.startPage((int)param.get("pageNo"),(int)param.get("pageSize"));
            list= labelMapper.selectByMap(param);
            redisTemplate.opsForValue().set(key,list);
            redisTemplate.opsForSet().add("labelset",param.get("pageNo")+"_"+param.get("pageSize"));
        }

        return list;
    }

    @Override
    public int add(SysLabel sysLabel) {
//        Set keys = redisTemplate.keys(CommonConstant.REIDS_KEY + "_*_*");
//        if(keys!=null){
//            redisTemplate.delete(keys);
//        }
        return labelMapper.insertSelective(sysLabel);
    }

    @Override
    @Async("asyncPoolTaskExecutor")
    public void deleteById(long id) throws InterruptedException {
//        Set keys = redisTemplate.keys(CommonConstant.REIDS_KEY + "_*_*");
//        if(keys!=null){
//            redisTemplate.delete(keys);
//        }

        Thread.sleep(5000);

        org.slf4j.Logger log= LoggerFactory.getLogger("Label");
        log.info("异步方法内部线程名称：{}!", Thread.currentThread().getName());
        labelMapper.deleteupdateByPrimaryKey(id);
    }

    @Override
    public int update(SysLabel sysLabel) {
//        Set keys = redisTemplate.keys(CommonConstant.REIDS_KEY + "_*_*");
//        if(keys!=null){
//            redisTemplate.delete(keys);
//        }
        return labelMapper.updateByPrimaryKey(sysLabel);
    }

    @Override
    public SysLabel getById(long id) {
        return labelMapper.selectByPrimaryKey(id);
    }


}
