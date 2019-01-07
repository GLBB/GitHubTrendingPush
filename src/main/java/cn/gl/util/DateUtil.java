package cn.gl.util;

import java.util.Date;

public class DateUtil {

    /**
     * 返回 3 天以前的 Date 对象
     * @return
     */
    public static Date threeDayBefore(){
        Date today = new Date();
        long todayMillis = today.getTime();
        long twoDayMillis = 1000 * 60 * 60 * 24 * 2;
        long threeDayMillis = todayMillis - twoDayMillis;
        Date threeDay = new Date(threeDayMillis);
        return threeDay;
    }
}
