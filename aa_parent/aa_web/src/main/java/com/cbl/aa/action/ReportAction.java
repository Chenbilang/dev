package com.cbl.aa.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.expr.NewArray;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.alibaba.fastjson.JSON;
import com.cbl.aa.biz.QunaeBiz;
import com.cbl.aa.biz.YjBiz;
import com.cbl.aa.entity.Chart;
import com.cbl.aa.entity.Qunae;
import com.cbl.aa.entity.Report;
import com.cbl.aa.entity.Spot;
import com.cbl.aa.entity.Yj;

/**
 * 分析报表
 * @author cbl
 *
 */
public class ReportAction extends BaseAction<Yj>{

	private YjBiz yjBiz;
	
	public void setYjBiz(YjBiz yjBiz) {
		this.yjBiz = yjBiz;
	}
	private QunaeBiz qunaeBiz;
	
//	private String city;
//	public void setCity(String city) {
//		this.city = city;
//	}
	
	public void setQunaeBiz(QunaeBiz qunaeBiz) {
		this.qunaeBiz = qunaeBiz;
	}
	public void getGroupOne(){
		DetachedCriteria detachedCriteria=DetachedCriteria
				.forClass(model.getClass());
		List<Object[]> list = (List<Object[]>) yjBiz.getGroupOne(detachedCriteria,getGroup());
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
	/**
	 * 客流量分析报表
	 */
	public void pflow(){
		
		List list2=yjBiz.getByOne("city", model.getCity());
		Yj yj=new Yj();
		for (Object object : list2) {
			yj=(Yj)object;
		}
		List<Report> list=new ArrayList<Report>();
		Report s12=new Report("1-2月",yj.getSpot_yj_12());
		Report s34=new Report("3-4月",yj.getSpot_yj_34());
		Report s56=new Report("5-6月",yj.getSpot_yj_56());
		Report s78=new Report("7-8月",yj.getSpot_yj_78());
		Report s910=new Report("9-10月",yj.getSpot_yj_910());
		Report s112=new Report("1-12月",yj.getSpot_yj_112());
		list.add(s12);
		list.add(s34);
		list.add(s56);
		list.add(s78);
		list.add(s910);
		list.add(s112);
		String responseString = JSON.toJSONString(list);
		write(responseString);
	}
	/**
	 * 人均花费分析报表
	 */
	public void cost(){
		
		List list2=yjBiz.getByOne("city", model.getCity());
		Yj yj=new Yj();
		for (Object object : list2) {
			yj=(Yj)object;
		}
		List<Chart> list=new ArrayList<Chart>();
		Chart s1=new Chart("1-999",yj.getSpot_yj_hundred());
		Chart s2=new Chart("1k-6k",yj.getSpot_yj_sthousand());
		Chart s3=new Chart("6k-20k",yj.getSpot_yj_mthousand());
		Chart s4=new Chart("20k以上",yj.getSpot_yj_bthousand());
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		String responseString = JSON.toJSONString(list);
		write(responseString);
	}
	/**
	 * 出行时间分析报表
	 */
	public void time(){
		
		List list2=yjBiz.getByOne("city", model.getCity());
		Yj yj=new Yj();
		for (Object object : list2) {
			yj=(Yj)object;
		}
		List<Chart> list=new ArrayList<Chart>();
		Chart s1=new Chart("3天以下",yj.getSpot_yj_daytime());
		Chart s2=new Chart("4-7天",yj.getSpot_yj_weektime());
		Chart s3=new Chart("8-14天",yj.getSpot_yj_twoweektime());
		Chart s4=new Chart("15天以上",yj.getSpot_yj_bigtime());
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		String responseString = JSON.toJSONString(list);
		write(responseString);
	}
	/**
	 * 费用排行
	 */
	public void avg(){
		
		List list=qunaeBiz.findAvgOneByGroup("price", getGroup());
		String responseString = JSON.toJSONString(list);
		write(responseString);
	}
	/**
	 * 销量排行
	 */
	public void num(){
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Qunae.class);
		List<Qunae> list = qunaeBiz.getOrderByOne(detachedCriteria,getGroup());
		List<Chart> list2=new ArrayList<Chart>();
		for (Qunae q : list) {
			Chart chart=new Chart(q.getSpot(), q.getNum());
			list2.add(chart);
		}
		
	    String responseString = JSON.toJSONString(list2);
	    write(responseString);
	}
} 
