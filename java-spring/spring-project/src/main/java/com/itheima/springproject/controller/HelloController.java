package com.itheima.springproject.controller;

import com.itheima.springproject.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "hello world";
    }
    @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println(name + "," + age);
        return "ok";
    }
    @RequestMapping("/simpleParam2")
    public String simpleParam2(String name, Integer age) {
        System.out.println(name + "," + age);
        return "ok";
    }
    @RequestMapping("/simpleParam3")
    public String simpleParam3(@RequestParam(name="name", required = false )String username, Integer age) {
        System.out.println(username + "," + age);
        return "ok";
    }
    @RequestMapping("/simplePojo")
    public String simplePojo(User user) {
        System.out.println(user);
        System.out.println(user.getName() + "," + user.getAge());
        return "ok";
    }
    @RequestMapping("/complexPojo")
    public String complexPojo(User user) {
        System.out.println(user);
        System.out.println(user.getAddress());
        return "ok";
    }
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "ok";
    }
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        System.out.println("listParam");
        return "ok";
    }
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime time) {
        System.out.println(time);
        System.out.println("dateParam");
        return "ok";
    }
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        System.out.println(user);
        System.out.println("user");
        return "ok";
    }
    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable String id) {
        System.out.println(id);
        System.out.println("path");
        return "ok";
    }
}
