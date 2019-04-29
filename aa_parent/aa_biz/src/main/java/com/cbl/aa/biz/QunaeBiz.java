package com.cbl.aa.biz;
import java.io.Serializable;
import java.util.List;

import com.cbl.aa.entity.Avg;
import com.cbl.aa.entity.Chart;
import com.cbl.aa.entity.Qunae;
import com.cbl.aa.entity.Yj;


/**
 * 景点业务逻辑接口
 * @author Administrator
 *
 */
public interface QunaeBiz extends BaseBiz<Qunae>{
	public List<Avg> findAvgOneByGroup(Serializable one,Serializable group);
}

