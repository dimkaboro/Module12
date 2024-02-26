package org.example;

import java.util.concurrent.TimeUnit;

public class TaskOne implements Runnable {
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (true) {
            long theTimeIs = System.currentTimeMillis() - startTime;
            System.out.println("The result is " + TimeUnit.MILLISECONDS.toSeconds(startTime));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class TaskTwo implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("5 sec have passed ");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}


