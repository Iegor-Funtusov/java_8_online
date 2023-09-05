package ua.com.alevel;

import java.util.Random;

public class CustomThread extends Thread {

    public CustomThread(int i) {
        super("Thread: " + i);
    }

    @Override
    public void run() {
        System.out.println("CustomThread.run " + Thread.currentThread().getName());
        int i = new Random().nextInt(2);
        int ch = new Random().nextInt(91);
        System.out.println("i = " + i);
        try {
            print1(i);
            print2(ch);
        } catch (ArithmeticException e) {
            System.out.println("e 1 = " + e.getMessage());
        } catch (LatinoException e) {
            System.out.println("e 2 = " + e.getMessage());
        }
    }

    private void print1(int i) throws ArithmeticException {
        System.out.println(10 / i);
    }

    private void print2(int ch) {
        if (ch >= 65) {
            System.out.println("ch = " + (char)ch);
        } else {
            throw new LatinoException("it's not character");
        }
    }
}
