package com.cbl.aa.dao;
import java.io.Serializable;
import java.util.List;

import com.cbl.aa.entity.Qunae;
import com.cbl.aa.entity.Yj;

public interface QunaeDao extends BaseDao<Qunae>{
	public List<Object[]> findAvgOneByGroup(Serializable one,Serializable group);
}
