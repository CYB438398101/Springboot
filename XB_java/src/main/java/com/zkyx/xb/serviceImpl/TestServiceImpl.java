package com.zkyx.xb.serviceImpl;

import com.zkyx.xb.dao.TestDao;
import com.zkyx.xb.model.Test;
import com.zkyx.xb.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("testServer")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public List<Test> getALLTest() {
        return testDao.getAllTest();
    }
}
