package com.club.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.club.common.result.Result;
import com.club.entity.Club;
import com.club.mapper.ClubMapper;
import com.club.service.ClubService;
import com.club.vo.ClubQueryVo;
import com.club.vo.ClubTypeVo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class ClubServiceImpl extends ServiceImpl<ClubMapper, Club> implements ClubService {

    @Resource
    private ClubMapper clubMapper;

    @Override
    public Result<?> pageList(ClubQueryVo queryVo) {
        Page<ClubTypeVo> page = new Page<>(queryVo.getCurrent(), queryVo.getSize());
        IPage<ClubTypeVo> pageData = clubMapper.selectClubWithTypePage(page, queryVo);
        return Result.success(pageData);
    }

    // 实现接口强制要求的getClubPage方法，消除第一个报错
    @Override
    public IPage<ClubTypeVo> getClubPage(Page<ClubTypeVo> page, ClubQueryVo queryVo) {
        return clubMapper.selectClubWithTypePage(page, queryVo);
    }

    @Override
    public Result<?> addClub(Club club) {
        int insert = clubMapper.insert(club);
        return insert > 0 ? Result.success() : Result.fail(500, "新增社团失败");
    }

    @Override
    public Result<?> updateClub(Club club) {
        int update = clubMapper.updateById(club);
        return update > 0 ? Result.success() : Result.fail(500, "修改社团失败");
    }

    @Override
    public Result<?> deleteClub(Long id) {
        int delete = clubMapper.deleteById(id);
        return delete > 0 ? Result.success() : Result.fail(500, "删除社团失败");
    }

    @Override
    public Result<?> audit(Long id, Integer status) {
        Club club = new Club();
        // 修复第二个报错：实体只有setId，没有setClubId
        club.setId(id);
        club.setStatus(status);
        int update = clubMapper.updateById(club);
        return update > 0 ? Result.success() : Result.fail(500, "审核操作失败");
    }

    @Override
    public Result<?> getClubInfo(Long id) {
        Club club = clubMapper.selectById(id);
        return Result.success(club);
    }
}