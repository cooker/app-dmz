package com.github.grant.admin.extand;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kqyu
 * 20/11/2020 4:55 下午
 * 描述：
 */
@Configuration
public class MybatisExtendConfig {

    @Bean
    @ConditionalOnClass(MetaObjectHandler.class)
    public MybatisMetaObjectHandler mybatisMetaObjectHandler(){
        return new MybatisMetaObjectHandler();
    }
}
