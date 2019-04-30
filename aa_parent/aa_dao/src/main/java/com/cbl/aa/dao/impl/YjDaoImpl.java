package com.cbl.aa.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.cbl.aa.dao.SpotDao;
import com.cbl.aa.dao.YjDao;
import com.cbl.aa.entity.Emp;
import com.cbl.aa.entity.Spot;
import com.cbl.aa.entity.Yj;

public class YjDaoImpl extends BaseDaoImpl<Yj> implements YjDao{ 

	@Override
	public List findByOne(String name,String param) {
		return (List) this.getHibernateTemplate().find("from Yj where "+name+"=?", param);
	}

	
}
