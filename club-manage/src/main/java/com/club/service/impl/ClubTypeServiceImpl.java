package com.club.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.club.common.result.Result;
import com.club.entity.ClubType;
import com.club.mapper.ClubTypeMapper;
import com.club.service.ClubTypeService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ClubTypeServiceImpl extends ServiceImpl<ClubTypeMapper, ClubType> implements ClubTypeService {
    @Resource
    private ClubTypeMapper clubTypeMapper;

    @Override
    public Result<?> listAll() {
        List<ClubType> list = baseMapper.selectList(null);
        return Result.success(list);
    }

    @Override
    public Result<?> addType(ClubType clubType) {
        int insert = clubTypeMapper.insert(clubType);
        return insert > 0 ? Result.success() : Result.fail(500,"新增分类失败");
    }

    @Override
    public Result<?> updateType(ClubType clubType) {
        int update = clubTypeMapper.updateById(clubType);
        return update > 0 ? Result.success() : Result.fail(500,"修改分类失败");
    }

    @Override
    public Result<?> deleteType(Long id) {
        int del = clubTypeMapper.deleteById(id);
        return del > 0 ? Result.success() : Result.fail(500,"删除分类失败");
    }

    @Override
    public Result<?> getByIdInfo(Long id) {
        ClubType type = clubTypeMapper.selectById(id);
        return Result.success(type);
    }
}