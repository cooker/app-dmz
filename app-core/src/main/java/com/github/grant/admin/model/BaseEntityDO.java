package com.github.grant.admin.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * ZoomGrant 2020/11/21 11:23
 */
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntityDO implements Serializable {

    private static final long serialVersionUID = -3224585245386904940L;

    Long id;
}
