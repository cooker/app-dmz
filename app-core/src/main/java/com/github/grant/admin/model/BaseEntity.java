package com.github.grant.admin.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kqyu
 * 20/11/2020 3:32 下午
 * 描述：
 */
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -6542030760880268688L;

    @TableId(value = "id", type = IdType.AUTO)
    Long id;

    /**
     * 创建人
     */
    String ceator;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    Date createTime;

    /**
     * 创建人
     */
    String updator;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.UPDATE)
    Date updateTime;

    /**
     * 删除状态 0-正常 1-删除
     */
    Boolean validFlag;

    /**
     * 锁定状态 0-正常 1-删除
     */
    Boolean lockFlag;
}
