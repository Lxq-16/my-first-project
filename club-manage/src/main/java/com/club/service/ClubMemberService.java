package com.club.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.club.common.result.Result;
import com.club.entity.ClubMember;

public interface ClubMemberService extends IService<ClubMember> {
    Result<?> getMemberByClubId(Long clubId);
    Result<?> addMember(ClubMember member);
    Result<?> updateMember(ClubMember member);
    Result<?> removeMember(Long id);
}