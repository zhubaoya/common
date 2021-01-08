package com.superjson.common.util;

import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;

/**
 * 创 建 人： zhubaoya
 * 创建时间：  2020-12-24 16:47:49
 * 描   述：  时间处理工具
 */
public class DateUtil {

    public static  FastDateFormat ISO_TIME_STAMP = FastDateFormat.getInstance("yyyyMMddHHmmss");

    public static String formatDate(Date date,String format){
         return FastDateFormat.getInstance(format).format(date);
    }
}
