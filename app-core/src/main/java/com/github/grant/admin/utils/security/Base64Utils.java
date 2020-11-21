package com.github.grant.admin.utils.security;

import com.github.grant.admin.contants.Contants;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * ZoomGrant 2020/11/21 11:46
 */
public class Base64Utils {

    public static String encode(String str) {

        return new BASE64Encoder().encode(str.getBytes(Contants.CHARSET_UTF_8));
    }

    public static byte[] decode(String str) throws IOException {

        return new BASE64Decoder().decodeBuffer(str);
    }


    public static void main(String[] args) {
        System.out.println(encode("sasa"));
    }

}
