package org.example;

public class Main {
    public static void main(String[] args) {
//        Thread timeThread = new Thread(new TaskOne());
//        timeThread.start();
//
//        TaskOne.TaskTwo fiveSec = new TaskOne.TaskTwo();
//        Thread mesFiveSec = new Thread(new TaskOne.TaskTwo());
//        mesFiveSec.start();

        TaskTwo fizzBuzz = new TaskTwo(15);

        Thread threadA = new Thread(fizzBuzz::fizz);
        Thread threadB = new Thread(fizzBuzz::buzz);
        Thread threadC = new Thread(fizzBuzz::fizzbuzz);
        Thread threadD = new Thread(fizzBuzz::number);

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();


        try {
            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}