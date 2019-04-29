package com.example.demo22.service;

import com.example.demo22.pojo.SysLabel;

import java.util.List;
import java.util.Map;
/**
 * 标签管理服务接口
 * @author chenbilang
 */
public interface LabelService {
    List<SysLabel> list(Map<String, Object> map);
    int add(SysLabel sysLabel);
    void deleteById(long id) throws InterruptedException;
    int update(SysLabel sysLabel);
    SysLabel getById(long id);
}
