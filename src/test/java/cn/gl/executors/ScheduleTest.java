package cn.gl.executors;

import org.junit.Test;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduleTest {
    /**
     * 测试 ScheduledExecutorService#scheduleAtFixedRate​(Runnable command, long initialDelay, long period, TimeUnit unit)
     */
    @Test
    public void test1() throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable runnable = () -> {
            System.out.println("Boob");
        };
        scheduledExecutorService.scheduleAtFixedRate(runnable, 3, 2, TimeUnit.SECONDS);
//        TimeUnit.SECONDS.sleep(10);

    }

    @Test
    public void test2(){
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Boob");
            }
        };
        timer.schedule(timerTask, 2, 5);
    }
}
