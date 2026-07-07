package com.club.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.club.common.jwt.JwtUtil;
import com.club.common.result.Result;
import com.club.common.result.ResultCode;
import com.club.entity.SysUser;
import com.club.mapper.UserMapper;
import com.club.service.UserService;
import com.club.vo.LoginVo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import com.club.common.exception.BusinessException;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements UserService {
    @Resource
    private JwtUtil jwtUtil;

    // 手动new，不依赖容器Bean，统一加密匹配规则
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public Result<?> login(LoginVo loginVo) {
        SysUser user = getUserByUsername(loginVo.getUsername());
        if(user == null){
            throw new BusinessException(ResultCode.FAIL, "账号不存在");
        }
        boolean match = encoder.matches(loginVo.getPassword(), user.getPassword());
        if(!match){
            throw new BusinessException(ResultCode.FAIL, "密码错误");
        }
        String token = jwtUtil.generateToken(user.getId().toString(), user.getRoleId().toString());
        Map<String,Object> map = new HashMap<>();
        map.put("token", token);
        return Result.success(map);
    }

    @Override
    public SysUser getUserByUsername(String username) {
        return baseMapper.selectOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername,username));
    }
}