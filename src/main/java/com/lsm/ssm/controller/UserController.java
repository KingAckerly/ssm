package com.lsm.ssm.controller;

import com.lsm.ssm.entity.UserEntity;
import com.lsm.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/listUser")
    public String listUser() {
        List<UserEntity> userEntityList = userService.listUser();
        System.out.println(userEntityList);
        return "success";
    }

    @RequestMapping("/saveBatch")
    public String saveBatch() {
        userService.saveBatch();
        return "success";
    }

    @RequestMapping("/testOracle")
    public String testOracle() {
        userService.testOracle();
        return "success";
    }

    @RequestMapping(value = "/testJDBCPagingQuery", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String testJDBCPagingQuery(@RequestParam("pageSizes") Integer pageSizes, @RequestParam("page") Integer page) {
        userService.testJDBCPagingQuery(pageSizes, page);
        return "success";
    }
}
