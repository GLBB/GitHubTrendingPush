package cn.gl.main;


import java.io.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestMainMethod {
    public static void main(String[] args) throws IOException {
        PrintStream fos = new PrintStream("test");
        OutputStream terminal = System.out;
        System.setOut(fos);



        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        Runnable r1 = () -> {
            System.out.println("grab");
        };
        Runnable r2 = () -> {
            System.out.println("delete");
        };

        scheduledExecutorService.scheduleAtFixedRate(r1, 0, 2, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(r2, 0, 6, TimeUnit.SECONDS);
    }
}
