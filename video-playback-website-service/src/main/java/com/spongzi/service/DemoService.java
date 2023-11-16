package com.spongzi.service;

import com.spongzi.dao.DemoDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DemoService {

    @Resource
    private DemoDao demoDao;

    public Long queryById(Long id) {
        return demoDao.queryById(id);
    }

}
