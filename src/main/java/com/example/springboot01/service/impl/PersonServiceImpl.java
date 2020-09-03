package com.example.springboot01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot01.Dao.PersonDao;
import com.example.springboot01.pojo.Person;
import com.example.springboot01.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends ServiceImpl<PersonDao, Person> implements PersonService {
}
