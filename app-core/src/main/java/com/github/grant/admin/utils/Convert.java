package com.github.grant.admin.utils;

import org.mapstruct.InheritConfiguration;

import java.util.List;

/**
 * @author kqyu
 * 20/11/2020 5:16 下午
 * 描述：
 */
public interface Convert<S, T> {
    S toSource(T t);
    @InheritConfiguration T toTarget(S s);

    List<S> toSource(List<T> t);
    List<T> toTarget(List<S> s);
}
