package com.github.grant.admin.utils;

import java.util.Date;
import java.util.Map;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kqyu
 * 17/11/2020 4:40 下午
 * 描述：
 */
public class DateUtils {

    public static final String FORMAT_DATE_22 = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String FORMAT_DATE_16 = "yyyy-MM-dd HH:mm";

    public static final String FORMAT_DATE_10 = "yyyy-MM-dd";

    public static final String FORMAT_DATE_7 = "yyyy-MM";

    public static final String FORMAT_DATE_4 = "yyyy";

    public static final String FORMAT_TIME_8 = "HH:mm:ss";

    public static final String FORMAT_TIME_5 = "HH:mm";

    static ZoneId ZONE_ID = ZoneId.of("Asia/Shanghai");

    private static final DateTimeFormatter[] FORMATTER = new DateTimeFormatter[] {
            DateTimeFormatter.ofPattern(FORMAT_DATE_22).withZone(ZONE_ID),
            DateTimeFormatter.ofPattern(DEFAULT_FORMAT).withZone(ZONE_ID),
            DateTimeFormatter.ofPattern(FORMAT_DATE_16).withZone(ZONE_ID),
            DateTimeFormatter.ofPattern(FORMAT_DATE_10).withZone(ZONE_ID),
            DateTimeFormatter.ofPattern(FORMAT_DATE_7).withZone(ZONE_ID),
            DateTimeFormatter.ofPattern(FORMAT_DATE_4).withZone(ZONE_ID),
            DateTimeFormatter.ofPattern(FORMAT_TIME_8).withZone(ZONE_ID),
            DateTimeFormatter.ofPattern(FORMAT_TIME_5).withZone(ZONE_ID),
            DateTimeFormatter.ofPattern("E").withZone(ZONE_ID),
//            DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒").withZone(ZONE_ID),
//            DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分").withZone(ZONE_ID),
//            DateTimeFormatter.ofPattern("yyyy年MM月dd日").withZone(ZONE_ID),
//            DateTimeFormatter.ofPattern("yyyy年MM月").withZone(ZONE_ID),
//            DateTimeFormatter.ofPattern("yyyy年").withZone(ZONE_ID),
//            DateTimeFormatter.ofPattern("HH时mm分ss秒").withZone(ZONE_ID),
//            DateTimeFormatter.ofPattern("HH时mm分").withZone(ZONE_ID)
    };

    private final Map<String, DateTimeFormatter> cache = new ConcurrentHashMap<>();

    static DateUtils instance = new DateUtils();

    public static DateUtils getInstance(){
        return instance;
    }

    private DateUtils(){
        cache.put(FORMAT_DATE_22, FORMATTER[0]);
        cache.put(DEFAULT_FORMAT, FORMATTER[1]);
        cache.put(FORMAT_DATE_16, FORMATTER[2]);
        cache.put(FORMAT_DATE_10, FORMATTER[3]);
        cache.put(FORMAT_DATE_7, FORMATTER[4]);
        cache.put(FORMAT_DATE_4, FORMATTER[5]);
        cache.put(FORMAT_TIME_8, FORMATTER[6]);
        cache.put(FORMAT_TIME_5, FORMATTER[7]);
    }

    private DateTimeFormatter getFormatter(String pattern){
        DateTimeFormatter zhFormatter = null;
        if (cache.containsKey(pattern)){
            zhFormatter = cache.get(pattern);
        }else {
            zhFormatter = DateTimeFormatter.ofPattern(pattern).withZone(ZONE_ID);
            cache.put(pattern, zhFormatter);
        }
        return zhFormatter;
    }

    public String format(Date date, String pattern) {
        DateTimeFormatter zhFormatter = getFormatter(pattern);
        ZonedDateTime zdt = ZonedDateTime.ofInstant(date.toInstant(), ZONE_ID);
        return zhFormatter.format(zdt);
    }

    public Date parse(String date, String pattern) {
        DateTimeFormatter zhFormatter = getFormatter(pattern);
        return Date.from(ZonedDateTime.parse(date, zhFormatter).toInstant());
    }


    public String format(Date date) {
        DateTimeFormatter zhFormatter = getFormatter(DEFAULT_FORMAT);
        ZonedDateTime zdt = ZonedDateTime.ofInstant(date.toInstant(), ZONE_ID);
        return zhFormatter.format(zdt);
    }

    public Date parse(String date) {
        DateTimeFormatter zhFormatter = getFormatter(DEFAULT_FORMAT);
        return Date.from(ZonedDateTime.parse(date, zhFormatter).toInstant());
    }

    public String getWeekday(Date date){
        DateTimeFormatter zhFormatter = getFormatter("E");
        ZonedDateTime zdt = ZonedDateTime.ofInstant(date.toInstant(), ZONE_ID);
        return zhFormatter.format(zdt);
    }

    public String getWeekday(){
        DateTimeFormatter zhFormatter = getFormatter("E");
        ZonedDateTime zdt = ZonedDateTime.now();
        return zhFormatter.format(zdt);
    }

    public Date now(){
        return new Date();
    }


}
