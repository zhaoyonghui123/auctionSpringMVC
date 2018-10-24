package com.iotek.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDateUtil {
    public static String getTime(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//���Է�����޸����ڸ�ʽ
        String time = dateFormat.format(now);
        return time;
    }
}