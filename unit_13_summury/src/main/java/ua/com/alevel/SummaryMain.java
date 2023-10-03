package ua.com.alevel;

import ua.com.alevel.enums.CarType;
import ua.com.alevel.test.A;

public class SummaryMain {
    public static void main(String[] args) {
        System.out.println(CarType.AUDI);
        System.out.println(CarType.AUDI.getShortName());
        System.out.println(CarType.AUDI.getNumber());

//        A.AA aa = new A.AA();
    }
}