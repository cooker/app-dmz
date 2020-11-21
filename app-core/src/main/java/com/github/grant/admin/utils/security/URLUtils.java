package com.github.grant.admin.utils.security;

import com.github.grant.admin.contants.Contants;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * ZoomGrant 2020/11/21 11:52
 */
public class URLUtils {

    public static String encode(String url) throws UnsupportedEncodingException {
        String[] urls = url.split("\\?");
        String temp = URLEncoder.encode(urls[1], Contants.UTF_8);
        temp = temp.replaceAll("\\+", "%20");
        temp = temp.replaceAll("%3D", "=");
        return urls[0] + "?" + temp;
    }

    public static String decode(String url) throws UnsupportedEncodingException {

        return URLDecoder.decode(url, Contants.UTF_8);
    }

}
