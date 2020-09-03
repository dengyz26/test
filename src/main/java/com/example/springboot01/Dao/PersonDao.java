package com.example.springboot01.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot01.pojo.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonDao extends BaseMapper<Person> {

}
