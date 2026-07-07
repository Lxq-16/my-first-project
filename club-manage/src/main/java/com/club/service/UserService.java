package com.club.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.club.common.result.Result;
import com.club.entity.SysUser;
import com.club.vo.LoginVo;
public interface UserService extends IService<SysUser> {
    Result<?> login(LoginVo loginVo);
    SysUser getUserByUsername(String username);
}