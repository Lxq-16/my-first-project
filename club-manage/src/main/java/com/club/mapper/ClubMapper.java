package com.club.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.club.entity.Club;
import com.club.vo.ClubQueryVo;
import com.club.vo.ClubTypeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClubMapper extends BaseMapper<Club> {
    IPage<ClubTypeVo> selectClubWithTypePage(Page<ClubTypeVo> page, @Param("query") ClubQueryVo query);
}