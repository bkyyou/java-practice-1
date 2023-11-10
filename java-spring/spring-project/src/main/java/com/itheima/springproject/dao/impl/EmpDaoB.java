package com.itheima.springproject.dao.impl;

import com.itheima.springproject.dao.EmpDao;
import com.itheima.springproject.pojo.Emp;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmpDaoB implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        List<Emp> list = new ArrayList<>();
        list.add(new Emp("ls", 10));
        return list;
    }
}
