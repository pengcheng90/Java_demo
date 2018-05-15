package com.demo.controller;

import com.demo.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

//访问：http://localhost:8080/swagger-ui.html 查看生成api文档
@RequestMapping("swagger")
@RestController
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
    public String addUser(@RequestBody User user) {
        System.out.println(user);
        return "getTest";
    }

}
