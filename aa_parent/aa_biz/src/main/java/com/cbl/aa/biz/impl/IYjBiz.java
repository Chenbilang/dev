package com.cbl.aa.biz.impl;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSON;
import org.hibernate.criterion.DetachedCriteria;

import com.cbl.aa.biz.SpotBiz;
import com.cbl.aa.biz.YjBiz;
import com.cbl.aa.dao.SpotDao;
import com.cbl.aa.dao.YjDao;
import com.cbl.aa.entity.Spot;
import com.cbl.aa.entity.Yj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IYjBiz extends IBaseBiz<Yj> implements YjBiz{

	private final Logger logger= LoggerFactory.getLogger(IYjBiz.class);
	private YjDao yjDao;

	public void setYjDao(YjDao yjDao) {
		this.yjDao = yjDao;
		super.setBaseDao(this.yjDao);
	}
	@Override
	public List getByOne(String name, String param) {
		List<Yj> list=yjDao.findByOne(name, param);
		String jsonList=JSON.toJSONString(list);
		logger.info("function[{}],message[{}]",Thread.currentThread().getStackTrace()[1],jsonList);
		return list;
	}
}
