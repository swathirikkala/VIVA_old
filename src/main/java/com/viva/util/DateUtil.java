package com.viva.util;

import java.text.SimpleDateFormat;
import java.util.Date;
 
public class DateUtil {
    public static String  getSqlDateTime() {
//        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}