package com.spongzi.api;

import com.spongzi.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DemoApi {

    @Resource
    private DemoService demoService;

    @GetMapping("/query/{id}")
    public Long queryById(@PathVariable Long id) {
        return demoService.queryById(id);
    }
}
