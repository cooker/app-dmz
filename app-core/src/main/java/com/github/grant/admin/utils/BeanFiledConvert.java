package com.github.grant.admin.utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Pattern;

import org.springframework.cglib.core.Converter;
import org.springframework.util.NumberUtils;

/**
 * @author kqyu
 * 17/11/2020 2:29 下午
 * 描述：
 */
class BeanFiledConvert implements Converter {

    Pattern pattern = Pattern.compile("^[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])\\s+(20|21|22|23|[0-1]\\d):[0-5]\\d:[0-5]\\d$");


    public static BeanFiledConvert INSTANCE = new BeanFiledConvert();

    @Override
    public Object convert(Object value, Class targetClass, Object context) {
        //相同类型
        if (value == null || value.getClass().isAssignableFrom(targetClass)){
            return value;
        }

        if (String.class.isAssignableFrom(targetClass)) {
            if (value instanceof BigDecimal) {
                return ((BigDecimal)value).toPlainString();
            }
            return Objects.toString(value, null);
        }

        if (Number.class.isAssignableFrom(targetClass)){
            return toNumber(value, targetClass);
        }

        if (Boolean.class.isAssignableFrom(targetClass)) {
            String t = Objects.toString(value);
            return "n".equalsIgnoreCase(t) || "no".equalsIgnoreCase(t) || "0".equalsIgnoreCase(t) || "false".equalsIgnoreCase(t)
                    ? Boolean.FALSE : Boolean.TRUE;
        }

        if (Date.class.isAssignableFrom(targetClass)) {
            if (value instanceof Long || long.class.isAssignableFrom(value.getClass())) {
                return new Date((Long)value);
            }
            if (value instanceof String) {
                if (pattern.matcher((CharSequence) value).matches()){
                    LocalDateTime time = LocalDateTime.parse((CharSequence) value, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
                }
            }
        }

        return null;
    }


    private Object toNumber(Object value, Class targetClass){
        if (value instanceof String) {
            return NumberUtils.parseNumber((String)value, targetClass);
        }

        return null;
    }
}
