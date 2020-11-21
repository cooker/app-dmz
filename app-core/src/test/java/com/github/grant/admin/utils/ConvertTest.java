package com.github.grant.admin.utils;

import com.github.grant.admin.entity.User;
import com.github.grant.admin.entity.UserConvert;
import com.github.grant.admin.entity.UserDTO;
import org.junit.Test;

/**
 * @author kqyu
 * 20/11/2020 5:20 下午
 * 描述：
 */
public class ConvertTest {


    @Test
    public void sa(){
        User user = new User();
        user.setName("111");
        user.setQq("ccc");
        UserDTO userDTO = UserConvert.aConvert.toTarget(user);
        System.out.println(userDTO);
    }


}
