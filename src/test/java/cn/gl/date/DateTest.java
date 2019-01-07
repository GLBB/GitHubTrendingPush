package cn.gl.date;

import org.junit.Test;

import java.util.Date;

public class DateTest {

    /**
     * 获得 前三天的 date 对象
     */
    @Test
    public void test(){
        Date today = new Date();
        System.out.println(today);
        long time = today.getTime();

//        1000 * 60 * 60 * 24 * 3  three day millisecond

        System.out.println(time);
        long threeDayBefore = time - 1000 * 60 * 60 * 24 * 2;
        Date threeDayBeforeDate = new Date(threeDayBefore);
        System.out.println(threeDayBeforeDate);
    }
}
