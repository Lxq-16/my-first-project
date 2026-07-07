package com.club.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.club.common.result.Result;
import com.club.entity.Club;
import com.club.service.ClubService;
import com.club.vo.ClubQueryVo;
import com.club.vo.ClubTypeVo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/api/club") // 加/api 匹配前端代理
public class ClubController {

    @Resource
    private ClubService clubService;

    // 分页查询社团（单字段/多表联合查询）
    @PostMapping("/page")
    public Result<IPage<ClubTypeVo>> page(@RequestBody ClubQueryVo queryVo) {
        Page<ClubTypeVo> page = new Page<>(queryVo.getCurrent(), queryVo.getSize());
        IPage<ClubTypeVo> pageData = clubService.getClubPage(page, queryVo);
        return Result.success(pageData);
    }

    // 新增社团
    @PostMapping("/add")
    public Result<?> add(@RequestBody Club club) {
        return clubService.addClub(club);
    }

    // 修改社团
    @PutMapping("/update")
    public Result<?> update(@RequestBody Club club) {
        return clubService.updateClub(club);
    }

    // 删除社团
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        return clubService.deleteClub(id);
    }

    // 社团审核
    @PutMapping("/audit/{id}/{status}")
    public Result<?> audit(@PathVariable Long id, @PathVariable Integer status) {
        return clubService.audit(id, status);
    }

    // 社团详情
    @GetMapping("/{id}")
    public Result<?> getInfo(@PathVariable Long id) {
        return clubService.getClubInfo(id);
    }
}