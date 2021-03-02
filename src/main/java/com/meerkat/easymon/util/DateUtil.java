package com.meerkat.easymon.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * author : yjs
 * createTime : 2018/8/7
 * description :
 * version : 1.0
 */
public class DateUtil {
    /**
     * 获得当天零时零分零秒
     *
     * @return
     */
    public static Date getZeroDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();

    }

    /**
     * * @return 返回字符串格式yyyyMMddHHmmssSSS（17位）
     *      
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}
