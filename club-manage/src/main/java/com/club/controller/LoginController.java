package com.club.controller;

import com.club.common.result.Result;
import com.club.service.UserService;
import com.club.vo.LoginVo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
@CrossOrigin // 允许跨域，解决前端本地开发跨域报错
public class LoginController {

    @Resource
    private UserService userService;

    // 完整接口路径：/api/login
    @PostMapping("/login")
    public Result<?> login(@RequestBody LoginVo loginVo){
        return userService.login(loginVo);
    }
}