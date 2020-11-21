package com.github.grant.admin.entity;

import com.github.grant.admin.utils.Convert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author kqyu
 * 20/11/2020 5:48 下午
 * 描述：
 */
@Mapper
public interface UserConvert extends Convert<User, UserDTO> {
    UserConvert aConvert = Mappers.getMapper(UserConvert.class);

}
