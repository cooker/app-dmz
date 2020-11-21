package com.github.grant.admin.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * @author kqyu
 * 20/11/2020 3:31 下午
 * 描述：
 */
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntityDTO implements Serializable {

    private static final long serialVersionUID = 8915341512567356774L;

    Long id;
}
