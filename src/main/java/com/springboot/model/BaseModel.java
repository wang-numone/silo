package com.springboot.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseModel {
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

    /**
     * 修改时间
     */
    private LocalDateTime updateAt;

    /**
     * 删除时间
     */
    private LocalDateTime deleteAt;

    /**
     * 版本
     */
    private Integer version;
}
