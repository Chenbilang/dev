package com.cbl.aa.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.alibaba.fastjson.JSON;
import com.cbl.aa.biz.SpotBiz;
import com.cbl.aa.entity.Menu;
import com.cbl.aa.entity.Spot;
import com.cbl.aa.entity.Tree;


/**
 * 景点Action 
 * @author Administrator
 *
 */
public class SpotAction extends BaseAction<Spot> {

	private SpotBiz spotBiz;

	public void setSpotBiz(SpotBiz spotBiz) {
		this.spotBiz = spotBiz;
		super.setBaseBiz(this.spotBiz);
	}
	
	private String stratTime;
	private String endTime;
	
	public void setStratTime(String stratTime) {
		this.stratTime = stratTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * 得到某一个属性的所有项
	 */
	public void getGroupOne(){
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(model.getClass());
		// 使用离线查询可以在web层就设置条件
		detachedCriteria=getDetachedCriteria(model,detachedCriteria);
		List<Object[]> list = (List<Object[]>) spotBiz.getGroupOne(detachedCriteria,getGroup());
		List<Map<String, Object>> list2=new ArrayList<Map<String, Object>>();
		int i=1;
		for (Object[] object : list) {
			Map<String, Object> mapData = new HashMap<String, Object>();
			mapData.put("id",object[0]);
			mapData.put(getGroup(),object[1]);
			list2.add(mapData);
		}   
		String responseString = JSON.toJSONString(list2);
		write(responseString);
	}
	public void getGroupByTime(){
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(model.getClass());
		// 使用离线查询可以在web层就设置条件
		detachedCriteria=getDetachedCriteria(model,detachedCriteria);
		List<String> list = (List<String>) spotBiz.getGroupBytime(detachedCriteria,getGroup());
		List<Map<String, Object>> list2=new ArrayList<Map<String, Object>>();
		int i=1;
		for (String string : list) {
			Map<String, Object> mapData = new HashMap<String, Object>();
			mapData.put("id",i);
			mapData.put(getGroup(),string);
			list2.add(mapData);
			i++;
		}   
		String responseString = JSON.toJSONString(list2);
		write(responseString);
	}
	public void getOrderByOne(){
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(model.getClass());
		// 使用离线查询可以在web层就设置条件
		detachedCriteria=getDetachedCriteria(model,detachedCriteria);
		List<Spot> list = spotBiz.getOrderByOne(detachedCriteria,getGroup());
		List<Map<String, Object>> list2=new ArrayList<Map<String, Object>>();
		for (Spot s : list) {
			Map<String, Object> mapData = new HashMap<String, Object>();
			mapData.put("name",s.getSpot());
			mapData.put("value",s.getSpot_ct());
			list2.add(mapData);
		}
		String responseString = JSON.toJSONString(list2);
		write(responseString);
	}
	/**
	 * 通过编辑查询对象
	 */
	public void get() {
		model = spotBiz.get(model.getId());
		//转换为json时将date类格式化
		String jsonString = JSON.toJSONStringWithDateFormat(model,"yyyy-MM-dd");
        /*  System.out.println(jsonString);*/
		Map<String, Object> map = JSON.parseObject(jsonString);
		//存储key加上前缀后的值
		Map<String, Object> dataMap = new HashMap<String, Object>();
		for(String key : map.keySet()){
			//if里面有对象（对象用map组装）
			if(map.get(key) instanceof Map){
				//key值进行拼接
				//将对象提取出来
				Map<String,Object> m2 = (Map<String,Object>)map.get(key);
				for(String key2 : m2.keySet()){
					dataMap.put(key + "." + key2, m2.get(key2));
				}
			}else{
				dataMap.put(key,map.get(key));
			}
		}
		String jsonStringAfter = JSON.toJSONString(dataMap);
		/*System.out.println(jsonStringAfter);*/
		write(jsonStringAfter);
	}
	/**
	 * 删除
	 * 
	 * @param jsonString
	 */
	public void delete() {

		try {
			spotBiz.delete(model.getId());
			ajaxReturn(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			ajaxReturn(false, "删除失败");
		}
	}
	public DetachedCriteria getDetachedCriteria(Spot spot,DetachedCriteria detachedCriteria){
		if(spot!=null){
			if(null != spot.getCity() && spot.getCity().trim().length()>0){
				detachedCriteria.add(Restrictions.like("city", spot.getCity(), MatchMode.ANYWHERE));
			}
			if(null != spot.getB_city() && spot.getB_city().trim().length()>0){
				detachedCriteria.add(Restrictions.like("B_city", spot.getB_city(), MatchMode.ANYWHERE));
			}
			if(null != spot.getProvince() && spot.getProvince().trim().length()>0){
				detachedCriteria.add(Restrictions.like("province", spot.getProvince(), MatchMode.ANYWHERE));
			}
			if(null != spot.getSpot() && spot.getSpot().trim().length()>0){
				detachedCriteria.add(Restrictions.like("spot", spot.getSpot(), MatchMode.ANYWHERE));
			}
			if(null != spot.getSpot_time() && spot.getSpot_time().trim().length()>0){
				detachedCriteria.add(Restrictions.eq("spot_time",spot.getSpot_time()));
			}
			

		}
		
		return detachedCriteria;
	}
}
