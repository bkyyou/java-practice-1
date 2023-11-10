package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest // springboot 整个单元测试的注解
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testListUser() {
        List<User> userlist = userMapper.list();
        userlist.stream().forEach(val -> {
            System.out.println(val);
        });
    }

    @Test
    public void testDeleteEmp() {
        int d = empMapper.deleteEmp(8);
        System.out.println(d);
    }

    @Test
    public void testInsertEmp() {
        Emp emp = new Emp();
        emp.setUsername("testInsert2");
        emp.setName("测试插入2");
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setEntrydate(LocalDate.of(2023, 1, 1));
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setDeptId(1);
        emp.setImage("1.jpg");
        Integer i = empMapper.InsertEmp(emp);
        System.out.println(i);
        System.out.println(emp.getId());
    }

    @Test
    public void testUpdateEmp() {
        Emp emp = new Emp();
        emp.setId(10);
        emp.setUsername("testInsert6");
        emp.setName("测试插入6");
//        emp.setCreateTime(LocalDateTime.now());
//        emp.setUpdateTime(LocalDateTime.now());
//        emp.setEntrydate(LocalDate.of(2023, 1, 1));
//        emp.setGender((short) 1);
//        emp.setJob((short) 1);
//        emp.setDeptId(1);
//        emp.setImage("1.jpg");
        Integer i = empMapper.updateEmp(emp);
        System.out.println(i);
        System.out.println(emp.getId());
    }

    @Test
    public void selectEmp() {
        Emp emp = empMapper.selectEmp(10);
        System.out.println(emp);
    }

    @Test
    public void selectConEmp() {
//        List<Emp> empList = empMapper.selectConEmp("测试", (short) 1, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 11, 11));
        List<Emp> empList = empMapper.selectConEmp("孙", null, null, null);
        System.out.println(empList.size());
        empList.stream().forEach(emp -> System.out.println(emp));
    }

    @Test
    public void deleteEmp() {
//        List<Integer> empIdList = new ArrayList<>();
//        Collections.addAll(empIdList, 12, 14);
//        System.out.println(empIdList);
        List<Integer> empIdList = Arrays.asList(15, 16);
        empMapper.deleteXmlEmp(empIdList);
    }
}
