package com.zkyx.xb.dao;

import com.zkyx.xb.model.Test;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface TestDao {
    public List<Test> getAllTest();
}
