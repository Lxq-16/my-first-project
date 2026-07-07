package com.club.entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("club_member")
public class ClubMember {
    @TableId(type = IdType.AUTO)
    private Long id;
    // 社团id
    private Long clubId;
    // 用户id
    private Long userId;
    // 成员角色 0普通成员 1副部长 2部长
    private Integer memberRole;
    // 加入时间
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @TableLogic
    private Integer isDeleted;
}