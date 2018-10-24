package com.iotek.util;

/**
 * Created by Administrator on 2018/7/27.
 */
public class StringUtil {
    public static boolean isNotEmpty(String str){
        if(null!=str&&str.trim()!=""){
            return true;
        }
        return false;
    }
}
