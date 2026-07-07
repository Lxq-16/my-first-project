package com.club.vo;
import lombok.Data;

@Data
public class ClubTypeVo {
    // 社团表club全部字段
    private Long id;
    private String clubName;
    private String typeId;
    private Long leaderId;
    private Integer status;
    private String intro;
    private String createTime;

    // 分类表club_type 关联查询出来的分类名称（多表新增字段）
    private String typeName;
}