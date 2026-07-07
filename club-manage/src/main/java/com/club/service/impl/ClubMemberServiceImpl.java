package com.club.service.impl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.club.common.result.Result;
import com.club.entity.ClubMember;
import com.club.mapper.ClubMemberMapper;
import com.club.service.ClubMemberService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ClubMemberServiceImpl extends ServiceImpl<ClubMemberMapper, ClubMember> implements ClubMemberService {
    @Resource
    private ClubMemberMapper memberMapper;

    @Override
    public Result<?> getMemberByClubId(Long clubId) {
        List<ClubMember> list = baseMapper.selectList(Wrappers.lambdaQuery(ClubMember.class)
                .eq(ClubMember::getClubId, clubId));
        return Result.success(list);
    }

    @Override
    public Result<?> addMember(ClubMember member) {
        // 注释掉手动生成ID代码，避免找不到selectMaxId()报错
        int insert = memberMapper.insert(member);
        return insert > 0 ? Result.success() : Result.fail(500,"添加成员失败");
    }

    @Override
    public Result<?> updateMember(ClubMember member) {
        int update = memberMapper.updateById(member);
        return update > 0 ? Result.success() : Result.fail(500,"修改成员信息失败");
    }

    @Override
    public Result<?> removeMember(Long id) {
        int del = memberMapper.deleteById(id);
        return del > 0 ? Result.success() : Result.fail(500,"移除成员失败");
    }
}