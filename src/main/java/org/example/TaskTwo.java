package org.example;

public class TaskTwo {
    private int n;
    private int current = 1;
    private final Object lock = new Object();

    public TaskTwo(int n) {
        this.n = n;
    }

    public void fizz() {
        while (true) {
            synchronized (lock) {
                if (current > n) return;
                if(current % 3 == 0 && current % 5 != 0) {
                    System.out.println("Fizz");
                    current++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void buzz() {
        while (true) {
            synchronized (lock) {
                if (current > n) return;
                if (current % 5 == 0 && current % 3 != 0) {
                    System.out.println("buzz");
                    current++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void fizzbuzz() {
        while (true) {
            synchronized (lock) {
                if (current > n) return;
                if (current % 3 == 0 && current % 5 == 0) {
                    System.out.println("fizzBuzz");
                    current++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void number() {
        while (true) {
            synchronized (lock) {
                if (current > n) return;
                if (current % 3 != 0 && current % 5 != 0) {
                    System.out.println(current);
                    current++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

//    public void print() {
//        while (true) {
//            synchronized (lock) {
//                if(current > n) return;
//                if(current % 3 == 0 && current % 5 == 0) {
//                    System.out.println("fizzBuzz");
//                } else if (current % 3 == 0) {
//                    System.out.println("fizz");
//                } else if (current % 5 == 0) {
//                    System.out.println("buzz");
//                } else {
//                    System.out.println(current);
//                }
//                current++;
//                lock.notifyAll();
//            }
//        }
//
//    }
}
