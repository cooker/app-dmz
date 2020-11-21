package com.github.grant.admin.extand;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.github.grant.admin.utils.DateUtils;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * @author kqyu
 * 20/11/2020 4:53 下午
 * 描述：
 */
public class MybatisMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", Date.class, DateUtils.getInstance().now()); // 起始版本 3.3.0(推荐使用)
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", Date.class, DateUtils.getInstance().now()); // 起始版本 3.3.0(推荐使用)
    }
}
