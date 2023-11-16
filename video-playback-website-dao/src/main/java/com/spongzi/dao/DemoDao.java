package com.spongzi.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoDao {

    Long queryById(Long id);
}
