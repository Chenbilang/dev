package com.cbl.aa.biz.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.cbl.aa.biz.QunaeBiz;
import com.cbl.aa.biz.SpotBiz;
import com.cbl.aa.biz.YjBiz;
import com.cbl.aa.dao.QunaeDao;
import com.cbl.aa.dao.SpotDao;
import com.cbl.aa.dao.YjDao;
import com.cbl.aa.entity.Avg;
import com.cbl.aa.entity.Chart;
import com.cbl.aa.entity.Qunae;
import com.cbl.aa.entity.Spot;
import com.cbl.aa.entity.Yj;

public class IQunaeBiz extends IBaseBiz<Qunae> implements QunaeBiz{

	private QunaeDao qunaeDao;

	public void setQunaeDao(QunaeDao qunaeDao) {
		this.qunaeDao = qunaeDao;
		super.setBaseDao(this.qunaeDao);
	}

	@Override
	public List<Avg> findAvgOneByGroup(Serializable one, Serializable group) {
		List<Avg> list2=new ArrayList<Avg>();
		List<Object[]> list = qunaeDao.findAvgOneByGroup(one, group);
		for (Object[] objects : list) {
			Avg chart=new Avg((String)objects[0], (Double)objects[1]);
			list2.add(chart);
		}
		return list2;
	
	}

	
	
}
