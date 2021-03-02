package com.meerkat.easymon.util;

import java.util.UUID;


public class IdUtil {

    /**
     * Description:通过uuid生成唯一的记录id
     *
     * @return 生成的id
     * @Version 1.0 2016-8-24下午8:40:48
     */
    public static String createUUIDId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }

    /**
     * 生成64位流水号
     * @return
     */
    public static String generateBusNo() {
        // 15位数字数组
        int[] number = new int[15];
        // 循环变量
        int i = 0;
        StringBuffer bussinessNo = new StringBuffer(64);
        bussinessNo.append(DateUtil.getStringDate());
        bussinessNo.append(createUUIDId());
        // 生成15位随机数算法
        for (i = 0; i < number.length; i++) {
            if (number[i] == 0) {
                // 产生0-10之间的随机小数，强制转换成正数
                number[i] = (int) (Math.random() * 10);
            }
            bussinessNo.append(number[i]);
        }
        return bussinessNo.toString();
    }

    /**
     * 生成32位请求流水
     * @return
     */
    public static String generateRequestId() {
        StringBuffer requestId = new StringBuffer(32);
        requestId.append("easymon01"); //6 位
        requestId.append(DateUtil.getStringDate()); // 17位
        // 生成9位随机数算法
        int[] number = new int[9];
        for (int i = 0; i < number.length; i++) {
            if (number[i] == 0) {
                // 产生0-10之间的随机小数，强制转换成正数
                number[i] = (int) (Math.random() * 10);
            }
            requestId.append(number[i]);
        }
        return requestId.toString();
    }
}
