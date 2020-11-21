package com.github.grant.admin.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * @author kqyu
 * 19/11/2020 4:07 下午
 * 描述：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 8655382145736298898L;

    String code;
    String message;
    T body;
}
