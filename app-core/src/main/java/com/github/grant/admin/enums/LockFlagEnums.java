package com.github.grant.admin.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * @author kqyu
 * 20/11/2020 3:42 下午
 * 描述：
 */
@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum  LockFlagEnums {
    UNLOCK(0, "正常"),
    LOCK(1, "删除");

    int code;
    String name;
}
