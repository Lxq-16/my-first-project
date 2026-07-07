package com.club.entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("club_type")
public class ClubType {
    @TableId(type = IdType.AUTO)
    private Long id;
    // 分类名称
    private String typeName;
    // 分类描述
    private String typeDesc;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @TableLogic
    private Integer isDeleted;
}