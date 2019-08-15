package com.wz.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 表对象公有字段
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BaseEntity {

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime created = LocalDateTime.now();
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime updated = LocalDateTime.now();
}
