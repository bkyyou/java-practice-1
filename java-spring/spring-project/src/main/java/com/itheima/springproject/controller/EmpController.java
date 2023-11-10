package com.itheima.springproject.controller;

import com.itheima.springproject.pojo.Emp;
import com.itheima.springproject.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("getEmp")
    public List<Emp> getEmp() {
        return empService.listEmp();
    }
}
