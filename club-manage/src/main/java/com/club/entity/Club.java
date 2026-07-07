package com.club.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("club")
public class Club {

    // 主键 club_id 自增
    @TableId(value = "club_id", type = IdType.AUTO)
    private Long id;

    // 社团名称 club_name
    private String clubName;

    // 社团分类 club_type → 数据库是INT，改成Integer
    @TableField("club_type")
    private Integer typeId;

    // 社长ID manager_id
    @TableField("manager_id")
    private Long leaderId;



    // 社团状态：0待审核 1正常 2驳回
    private Integer status;

    // 社团简介 club_desc
    @TableField("club_desc")
    private String intro;

    // 创建时间，新增自动填充
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    // 更新时间，新增&修改自动填充
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    // 删掉了@TableLogic注解，不再做逻辑删除
    private Integer isDeleted;
}