package ua.com.alevel;

import java.io.File;

public class IoNioMain {
    public static void main(String[] args) {
//        new NioTest().test();
//        new IoTest().test();
//        new RWTest().test();
//        new SerialTest().test();

        //Operating system name
        System.out.println("Your OS name -> " + System.getProperty("os.name"));

        //Operating system version
        System.out.println("Your OS version -> " + System.getProperty("os.version"));

        //Operating system architecture
        System.out.println("Your OS Architecture -> " + System.getProperty("os.arch"));

        //JRE version number
        System.out.println(System.getProperty("java.version"));

        //Installation directory for Java Runtime Environment (JRE)
        System.out.println(System.getProperty("java.home"));

        //User account name
        System.out.println(System.getProperty("user.name"));

        if (System.getProperty("os.name").equals("Mac OS X")) {
            File file = new File("/Users/" + System.getProperty("user.name") + "/");
            System.out.println("file = " + file.getAbsolutePath());
            File[] files = file.listFiles();
            for (File file1 : files) {
                System.out.println("file1 = " + file1);
            }
        }
    }
}