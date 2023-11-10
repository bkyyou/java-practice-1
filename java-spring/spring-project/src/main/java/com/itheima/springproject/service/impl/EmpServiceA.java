package com.itheima.springproject.service.impl;

import com.itheima.springproject.dao.EmpDao;
import com.itheima.springproject.pojo.Emp;
import com.itheima.springproject.service.EmpService;
import jakarta.annotation.Resource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class EmpServiceA implements EmpService {
//    @Autowired
//    @Qualifier("empDaoA")
//    private EmpDao empDao;
    @Resource(name = "empDaoB")
    private EmpDao empDao;
    @Override
    public List<Emp> listEmp() {
        List<Emp> listEmp = empDao.listEmp().stream().map(new Function<Emp, Emp>() {
            @Override
            public Emp apply(Emp emp) {
                emp.setAge(emp.getAge() + 1);
                return emp;
            }
        }).collect(Collectors.toList());
        System.out.println(listEmp);
        return listEmp;
    }
}
