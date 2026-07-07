package com.club.vo;

import lombok.Data;

@Data
public class ClubQueryVo {
    private String clubName;
    private Integer typeId;
    private Integer status;
    private Long current;
    private Long size;
    private String typeName;
    private Long managerId;
}