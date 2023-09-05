package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExceptionsMain {
    public static void main(String[] args) {
        Throwable throwable;

        Error error;
        Exception exception;

        SQLException sqlException;
        IOException ioException;
        RuntimeException runtimeException;

//        List<CustomThread> threads = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            threads.add(new CustomThread(i));
//        }
//
//        System.out.println("ExceptionsMain.main: " + Thread.currentThread().getName());
//        for (CustomThread thread : threads) {
//            thread.start();
//        }

        try {
//            System.exit(0);
            System.out.println(1 / 0);
        } catch (Error e) {  // absurd!!!!
            System.out.println("e = " + e);
        } finally {
            System.out.println("finally");
        }

        // old style
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            String s = bufferedReader.readLine();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            try {
//                bufferedReader.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }

        // new style
//        try(BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in))) {
//            String s = bufferedReader1.readLine();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("Finish");
    }
}
