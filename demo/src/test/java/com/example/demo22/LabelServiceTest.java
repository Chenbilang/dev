package com.example.demo22;


import com.example.demo22.Util.SpringUtil;
import com.example.demo22.annotation.AnnotaionTest;
import com.example.demo22.pojo.SysLabel;
import com.example.demo22.service.LabelService;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class LabelServiceTest {
	@Autowired
	private LabelService labelService;

	@Resource
	private RedisTemplate redisTemplate;
	@Autowired
	private AnnotaionTest annotaionTest;

	@Test
	public void TestLabelList() {

		Map<String ,Object> params=new HashMap<String ,Object>();
		params.put("pageNo",1);
		params.put("pageSize",2);
		List list = labelService.list(params);
		for (Object sysLabel:list) {
			System.out.println(sysLabel.toString());
		}

	}

	@Test
	public void TestLabelAdd() {

		SysLabel sysLabel=new SysLabel();
		sysLabel.setName("标签1");
		sysLabel.setWeight(1);
		int i= labelService.add(sysLabel);
		System.out.println(i);

	}
	@Test
	public void TestLabelUpdate() {

		SysLabel sysLabel=new SysLabel();
		sysLabel.setId(22L);
		sysLabel.setName("标签2");
		sysLabel.setWeight(2);
		int i= labelService.update(sysLabel);
		System.out.println(i);

	}
	@Test
	public void TestRedisString() {

		SysLabel sysLabel=labelService.getById(33L);

		String key="sysLabel33";
		redisTemplate.opsForValue().set(key,sysLabel);
		SysLabel label= (SysLabel) redisTemplate.opsForValue().get(key);

		System.out.println(label.getId());;

	}
	@Test
	public void TestRedisHash() {


		Map<String ,Object> params=new HashMap<String ,Object>();
		params.put("pageNo",1);
		params.put("pageSize",3);
		List<SysLabel> list = labelService.list(params);
//		redisTemplate.opsForValue().set(key,sysLabel);
//		SysLabel label= (SysLabel) redisTemplate.opsForValue().get(key);
		for (SysLabel s : list) {
			redisTemplate.opsForHash().put("syslabel_1_3","id",s.getId());
			redisTemplate.opsForHash().put("syslabel_1_3","name",s.getName());
			redisTemplate.opsForHash().put("syslabel_1_3","weight",s.getWeight());
		}
		for (SysLabel s : list) {

			System.out.println(redisTemplate.opsForHash().get("syslabel_1_3","name"));
		}
//		System.out.println(label.getId());;

	}
	@Test
	public void TestRedisStringList() {


		Map<String ,Object> params=new HashMap<String ,Object>();
		params.put("pageNo",1);
		params.put("pageSize",3);
		String key="syslabel_1_4";
		List<SysLabel> list = labelService.list(params);

		redisTemplate.opsForValue().set(key,list);
		System.out.println(redisTemplate.opsForValue().get(key));
		List<SysLabel> list1= (List<SysLabel>) redisTemplate.opsForValue().get(key);
		for(SysLabel sysLabel:list1){
			System.out.println(sysLabel);
		}
//		System.out.println(label.getId());;

	}
	@Test
	public void TestRedisList() {


		String pageNoAndSize=1+"_"+10;

		redisTemplate.opsForList().leftPush("labelist",pageNoAndSize);

	}

	@Test
	public void TestRocketmq(){
		annotaionTest.Test();

	}
	@Test
	public void TestSpringUtil(){
		LabelService labelService= (LabelService) SpringUtil.getBean("labelService");
		SysLabel label=labelService.getById(52);
		System.out.println(label);
	}


}
