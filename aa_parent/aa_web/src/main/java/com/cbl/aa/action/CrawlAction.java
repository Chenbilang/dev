package com.cbl.aa.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.bind.v2.runtime.Name;

public class CrawlAction extends ActionSupport{

	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	public void start(){
		System.out.println(name);
		String path=null;
		String executePath=null;
		if(name!="qunae"){
		    path="F:\\PycharmProjects\\travel";
		    if(name=="spot"){
		    	executePath = path+"\\spot_start.py";
		    }else {
		    	executePath = path+"\\yj_start.py";
			}
		}else{
			path="F:\\PycharmProjects\\qunae";
			executePath = path+"\\start.py";
		}
		//执行命令Arr
		String[] cmdArr = new String[]{"python",executePath};
		//参数分别为： 执行命令；执行此脚本的路径
		try {
			Process process = Runtime.getRuntime().exec(cmdArr,null,new File(path));
			Map<String, Object> rtn = new HashMap<String, Object>();
			rtn.put("success", true);
			rtn.put("message", "成功执行，正在爬取");
			
			write(JSON.toJSONString(rtn));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void write(String jsonString) {
		try {
			// 响应对象
			HttpServletResponse response = ServletActionContext.getResponse();
			// 设置编码
			response.setContentType("text/html;charset=utf-8");
			// 输出给页面
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
