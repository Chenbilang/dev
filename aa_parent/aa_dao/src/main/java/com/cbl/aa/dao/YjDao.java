package com.cbl.aa.dao;
import java.io.Serializable;
import java.util.List;

import com.cbl.aa.entity.Yj;

public interface YjDao extends BaseDao<Yj>{

	public List findByOne(String name,String param);
}
