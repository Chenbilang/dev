package com.cbl.aa.biz.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.cbl.aa.biz.SpotBiz;
import com.cbl.aa.biz.YjBiz;
import com.cbl.aa.dao.SpotDao;
import com.cbl.aa.dao.YjDao;
import com.cbl.aa.entity.Spot;
import com.cbl.aa.entity.Yj;

public class IYjBiz extends IBaseBiz<Yj> implements YjBiz{

	private YjDao yjDao;

	public void setYjDao(YjDao yjDao) {
		this.yjDao = yjDao;
		super.setBaseDao(this.yjDao);
	}
	@Override
	public List getByOne(String name, String param) {
		return yjDao.findByOne(name, param);
	}
}
