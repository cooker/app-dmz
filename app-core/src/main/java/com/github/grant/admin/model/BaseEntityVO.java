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
public class BaseEntityVO implements Serializable {

    private static final long serialVersionUID = -5759214123316526286L;

    private String id;
}
