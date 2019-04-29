package com.example.demo22.contorller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo22.Response.DefaultResponse;
import com.example.demo22.pojo.SysLabel;
import com.example.demo22.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 标签管理api接口
 * @author chenbilang
 */
@RestController
//@RequestMapping("api")
@RequestMapping("/label")
@EnableAsync
public class LabelContorller {

    @Autowired
    private LabelService labelService;
    @GetMapping("")
    public Object list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5")int rows , ModelMap params){
        params.put("pageNo",page);
        params.put("pageSize",rows);
        List list=labelService.list(params);
        String jsonString2 = JSON.toJSONString(list);
        return  jsonString2;

    }
    @PostMapping("")
    public Object add(@RequestBody JSONObject jsonObject) {
        //jsonObject
        SysLabel sysLabel=JSON.toJavaObject(jsonObject,SysLabel.class);
        Map<String,Object> rtn=new HashMap<>();
        try {
            labelService.add(sysLabel);

            rtn.put("success", true);
            rtn.put("message", "新增成功");
            return rtn;
        }catch (Exception e){
            rtn.put("success", false);
            rtn.put("message", "新增失败");
            return rtn;
        }

    }
    @DeleteMapping("/{id}")
    public Object delete(@PathVariable(value = "id") long id, Model model) throws IOException, InterruptedException {

            labelService.deleteById(id);
            System.out.println("执行完毕");
            return DefaultResponse.toResponse("删除成功");

    }

    @PatchMapping("")
    public Object update(@RequestBody  SysLabel sysLabel)  {
        try{
//            SysLabel sysLabel=JSON.toJavaObject(jsonObject,SysLabel.class);
            labelService.update(sysLabel);
            return DefaultResponse.toResponse("更改成功");
        }catch (Exception e){
            return DefaultResponse.toResponse("更改失败");
        }
    }
    @GetMapping ("/edit")
    public String edit(long id,Model model)  {
        SysLabel label=labelService.getById(id);
        String labelString=JSON.toJSONString(label);
        return labelString;
    }


}
