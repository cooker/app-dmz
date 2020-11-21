package com.github.grant.admin.utils;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.beans.BeanMap;

/**
 * @author kqyu
 * 17/11/2020 3:54 下午
 * 描述：
 */
public class BeanUtils {
    private static Map<String, BeanCopier> cacheMap = new ConcurrentHashMap<>();

    public static void copy(Object src, Object target){
        String key = nodeName(src, target);
        if (cacheMap.containsKey(key)){
            cacheMap.get(key).copy(src, target, BeanFiledConvert.INSTANCE);
        }else {
            BeanCopier beanCopier = BeanCopier.create(src.getClass(), target.getClass(), true);
            cacheMap.put(key, beanCopier);
            beanCopier.copy(src, target, BeanFiledConvert.INSTANCE);
        }
    }

    public static Map toMap(Object obj){
        if (obj == null) {
            return Collections.emptyMap();
        }
        BeanMap beanMap = BeanMap.create(obj);
        return (Map) beanMap.keySet().stream()
                .filter(k->beanMap.get(k) != null)
                .collect(Collectors.toMap(
                       k->k, k->beanMap.get(k)
                ));
    }

    private static String nodeName(Object src, Object target) {
        return src.getClass().getName() + target.getClass().getName();
    }
}
