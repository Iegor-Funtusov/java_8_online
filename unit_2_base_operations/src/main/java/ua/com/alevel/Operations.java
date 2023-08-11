package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Operations
{
    public void circle()
    {
        int i1 = 10;
        System.out.println("i1 = " + (++i1));
        System.out.println("i1 = " + i1);
        int[] ints = new int[10];
        for (int i = 0; i < 10; i++)
        {
            ints[i] = i;
        }
        for (int i = 0; i < ints.length; i++)
        {
            System.out.println("ints = " + ints[i]);
        }
        int start = 0;
        while (start < ints.length)
        {
            System.out.println("ints = " + ints[start]);
            ++start;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String text;
            while ((text = bufferedReader.readLine()) != null)
            {
                System.out.println("text = " + text);
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        System.out.println("finish");
    }

    public void ifSwitch()
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter a number value");
        try {
            int number = Integer.parseInt(bufferedReader.readLine());
            if (number < 10) {
                System.out.println("number < 10");
            } else if (number >= 10 && number < 50) {
                System.out.println("number >= 10 && number < 50");
            } else {
                System.out.println("number >= 50");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            String car = bufferedReader.readLine();
            if (car.equalsIgnoreCase("BMW")) {
                System.out.println("BMW");
            }
            if (car.equalsIgnoreCase("AUDI")) {
                System.out.println("AUDI");
            }
            if (car.equalsIgnoreCase("MAZDA")) {
                System.out.println("MAZDA");
            }

            switch (car) {
                case "BMW": {
                    System.out.println("BMW");
                } break;
                case "AUDI" : {
                    System.out.println("AUDI");
                } break;
                case "MAZDA" : {
                    System.out.println("MAZDA");
                } break;
                default: {
                    System.out.println("Other car");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            String option = bufferedReader.readLine();
//            String navigation = option.equals("Baba Jaga")
//                    ? "left"
//                    : "right";

            String navigation;
            if (option.equals("Baba Jaga"))
            {
                navigation = "left";
            } else
            {
                navigation = "right";
            }

            System.out.println("navigation = " + navigation);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
