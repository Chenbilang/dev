package com.cbl.aa.biz;
import java.io.Serializable;
import java.util.List;

import com.cbl.aa.entity.Yj;


/**
 * 景点业务逻辑接口
 * @author Administrator
 *
 */
public interface YjBiz extends BaseBiz<Yj>{
	List getByOne(String name,String param);

}

