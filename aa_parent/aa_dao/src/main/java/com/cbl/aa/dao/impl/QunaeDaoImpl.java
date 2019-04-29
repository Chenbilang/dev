package com.cbl.aa.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.cbl.aa.dao.QunaeDao;
import com.cbl.aa.dao.SpotDao;
import com.cbl.aa.dao.YjDao;
import com.cbl.aa.entity.Emp;
import com.cbl.aa.entity.Qunae;
import com.cbl.aa.entity.Spot;
import com.cbl.aa.entity.Yj;

public class QunaeDaoImpl extends BaseDaoImpl<Qunae> implements QunaeDao{ 


	@Override
	public List<Object[]> findAvgOneByGroup(Serializable one, Serializable group) {
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Qunae.class);
		detachedCriteria.setProjection(Projections.projectionList().add(Projections.groupProperty((String) group)).add(Projections.avg((String) one)));
		return (List<Object[]>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
	}
	
	
}
