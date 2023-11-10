package com.itheima.springproject.controller;

import com.itheima.springproject.pojo.Address;
import com.itheima.springproject.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class responseController {
    @RequestMapping("resultHello")
    public Result resultHello() {
        return Result.success("hello world");
    }
    @RequestMapping("getAddr")
    public Address getAddr() {
        Address addr = new Address();
        addr.setCity("北京市");
        addr.setProvince("北京");
        return addr;
    }
    @RequestMapping("getResultAddr")
    public Result getResultAddr() {
        Address addr = new Address();
        addr.setCity("北京市");
        addr.setProvince("北京");
        return Result.success(addr);
    }
    @RequestMapping("getAddrList")
    public List<Address> getAddrList() {
        List<Address> list = new ArrayList<>();
        Address addr1 = new Address();
        addr1.setCity("北京市");
        addr1.setProvince("北京");

        Address addr2 = new Address();
        addr2.setCity("辽宁");
        addr2.setProvince("丹东");

        Address addr3 = new Address();
        addr3.setCity("辽宁");
        addr3.setProvince("阜新");

        Collections.addAll(list, addr1, addr2, addr3);
        return list;
    }
    @RequestMapping("getResultAddrList")
    public Result getResultAddrList() {
        List<Address> list = new ArrayList<>();
        Address addr1 = new Address();
        addr1.setCity("北京市");
        addr1.setProvince("北京");

        Address addr2 = new Address();
        addr2.setCity("辽宁");
        addr2.setProvince("丹东");

        Address addr3 = new Address();
        addr3.setCity("辽宁");
        addr3.setProvince("阜新");

        Collections.addAll(list, addr1, addr2, addr3);
        return Result.success(list);
    }
}
