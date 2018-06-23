package com.demo.controller;

import annotation.DataType;
import annotation.ResponseType;
import com.demo.domain.D;
import com.demo.domain.DR;
import com.demo.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//访问：http://localhost:8080/swagger-ui.html 查看生成api文档
@RequestMapping("swagger")
@Controller
public class TestController {

    @ApiOperation(value = "测试api doc 生成-get", notes = "生成api")
    @GetMapping("/user")
    @ResponseBody
    public String getName() {
        System.out.println("getName()");
        return "user1";
    }

    @ApiOperation(value = "wsagger-添加用户", notes = "添加")
    @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    @PostMapping("/")
    @ResponseBody
//    自定义注解
    @DataType(name = {"data","dr"}, type = {D.class,DR.class})
    @ResponseType(name = "data", type = DR.class)
    public User<DR> addUser(@RequestBody User<D<DR>> user) {
        System.out.println(user);
        return null;
    }

}
