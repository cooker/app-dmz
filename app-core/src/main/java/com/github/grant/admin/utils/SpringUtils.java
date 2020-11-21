package com.github.grant.admin.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

/**
 * @author kqyu
 * 19/11/2020 4:13 下午
 * 描述：
 */
@Component
public class SpringUtils implements ApplicationListener<ApplicationContextEvent> {
    static ApplicationContext context;

    @Override
    public void onApplicationEvent(ApplicationContextEvent applicationContextEvent) {
        context = applicationContextEvent.getApplicationContext();
    }

    public static Object getBean(String className) {
        return context.getBean(className);
    }
    
    public static <T> T getBean(Class<T> clazz){
        return context.getBean(clazz);
    }
}
