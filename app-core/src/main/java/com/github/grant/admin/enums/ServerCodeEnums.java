package com.github.grant.admin.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * @author kqyu
 * 19/11/2020 5:53 下午
 * 描述：服务代码
 */
@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ServerCodeEnums {
    SUCCESS("200", "成功"),
    FAIL("500", "服务异常");

    String code;
    String message;

}
