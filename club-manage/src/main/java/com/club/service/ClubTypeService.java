package com.club.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.club.common.result.Result;
import com.club.entity.ClubType;

public interface ClubTypeService extends IService<ClubType> {
    Result<?> listAll();
    Result<?> addType(ClubType clubType);
    Result<?> updateType(ClubType clubType);
    Result<?> deleteType(Long id);
    Result<?> getByIdInfo(Long id);
}