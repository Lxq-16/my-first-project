package com.club.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.club.entity.Club;
import com.club.vo.ClubQueryVo;
import com.club.vo.ClubTypeVo;
import com.club.common.result.Result;

public interface ClubService extends IService<Club> {
    // 原有旧方法全部保留不动
    Result<?> pageList(ClubQueryVo queryVo);
    Result<?> addClub(Club club);
    Result<?> updateClub(Club club);
    Result<?> deleteClub(Long id);
    Result<?> audit(Long id, Integer status);
    Result<?> getClubInfo(Long id);

    // 新增：新多表分页查询方法
    IPage<ClubTypeVo> getClubPage(Page<ClubTypeVo> page, ClubQueryVo queryVo);
}