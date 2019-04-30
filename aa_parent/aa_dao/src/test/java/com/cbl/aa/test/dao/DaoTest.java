package com.cbl.aa.test.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cbl.aa.dao.QunaeDao;
import com.cbl.aa.dao.SpotDao;
import com.cbl.aa.dao.YjDao;
import com.cbl.aa.entity.Qunae;
import com.cbl.aa.entity.Spot;
import com.cbl.aa.entity.Yj;

public class DaoTest {
	
	@Test
	public void testDep(){
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext_dao.xml","classpath:applicationContext_datasource.xml"});
		SpotDao spotDao=(SpotDao) ac.getBean("spotDao");
		Spot spot=spotDao.findById(1L);
		System.out.println(spot);
		DetachedCriteria detachedCriteria=DetachedCriteria
				.forClass(spot.getClass());
		Integer findCount = spotDao.findCount(detachedCriteria);
		System.out.println(findCount);
	}
	@Test
	public void testYj(){
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext_dao.xml","classpath:applicationContext_datasource.xml"});
		YjDao yjDao=(YjDao) ac.getBean("yjDao");
		List list = yjDao.findByOne("city", "千岛湖");
		for (Object object : list) {
			Yj yj=(Yj)object;
			System.out.println(object.toString());
			System.out.println(yj.toString());
		}
		
	}
	@Test
	public void testYjGroup(){
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext_dao.xml","classpath:applicationContext_datasource.xml"});
		QunaeDao qunaeDao=(QunaeDao) ac.getBean("qunaeDao");
		List<Object[]> Object = qunaeDao.findAvgOneByGroup("price", "city");
		for (Object[] yj : Object) {            
			System.out.println(yj[0]);
			System.out.println(yj[1]);
		}
		
	}
	@Test
	public void testQunaeOrder(){
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext_dao.xml","classpath:applicationContext_datasource.xml"});
		QunaeDao qunaeDao=(QunaeDao) ac.getBean("qunaeDao");
		DetachedCriteria detachedCriteria=DetachedCriteria
				.forClass(Qunae.class);
		List<Qunae> list = qunaeDao.getOrderByOne(detachedCriteria, "num");
		for (Qunae qunae : list) {
            
			System.out.println(qunae);
			
		}
		
	}
	@Test
	public void testPython() {
		//python脚本的路径
		String path="F:\\PycharmProjects\\travel";
		String executePath = path+"\\spot_start.py";
		
		//执行命令Arr
		String[] cmdArr = new String[]{"python",executePath};
		//参数分别为： 执行命令；执行此脚本的路径
		try {
			Process process = Runtime.getRuntime().exec(cmdArr,null,new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
