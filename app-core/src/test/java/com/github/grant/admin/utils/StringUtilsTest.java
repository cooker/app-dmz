package com.github.grant.admin.utils;

import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @author kqyu
 * 20/11/2020 2:56 下午
 * 描述：
 */
public class StringUtilsTest {

    @Test
    public void hasChinese(){
        Assert.isTrue(StringUtils.hasChineseByBlock("我"));
    }
}
