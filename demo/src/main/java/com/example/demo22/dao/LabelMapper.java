package com.example.demo22.dao;

import com.example.demo22.pojo.SysLabel;

import java.util.List;
import java.util.Map;

public interface LabelMapper {
    List<SysLabel> selectByMap(Map<String, Object> param);
    SysLabel selectByPrimaryKey(Long id);
    int deleteupdateByPrimaryKey(Long id);
    int insertSelective(SysLabel record);
    int updateByPrimaryKey(SysLabel record);
}
