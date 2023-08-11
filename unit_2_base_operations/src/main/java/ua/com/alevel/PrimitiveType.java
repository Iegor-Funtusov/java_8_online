package ua.com.alevel;

import java.math.BigDecimal;
import java.math.BigInteger;

public class PrimitiveType {

    public void test() {
        byte bMax = Byte.MAX_VALUE;
        byte bMin = Byte.MIN_VALUE;

        short sMax = Short.MAX_VALUE;
        short sMin = Short.MIN_VALUE;

        int iMax = Integer.MAX_VALUE;
        int iMin = Integer.MIN_VALUE;

        long lMax = Long.MAX_VALUE;
        long lMin = Long.MIN_VALUE;

        System.out.println("bMin = " + bMin);
        System.out.println("bMax = " + bMax);
        System.out.println("sMin = " + sMin);
        System.out.println("sMax = " + sMax);
        System.out.println("iMin = " + iMin);
        System.out.println("iMax = " + iMax);
        System.out.println("lMin = " + lMin);
        System.out.println("lMax = " + lMax);

        float fMin = Float.MIN_VALUE;
        float fMax = Float.MAX_VALUE;

        double dMin = Double.MIN_VALUE;
        double dMax = Double.MAX_VALUE;

        System.out.println("fMin = " + fMin);
        System.out.println("fMax = " + fMax);
        System.out.println("dMin = " + dMin);
        System.out.println("dMax = " + dMax);

        System.out.println(2.0 - 1.1);

        System.out.println(iMax + 1);
        BigInteger maxInt = new BigInteger(String.valueOf(Integer.MAX_VALUE));
        BigInteger one = new BigInteger("1");
        BigInteger resInt = maxInt.add(one);
        System.out.println("resInt = " + resInt);

        BigDecimal left = new BigDecimal("2.0");
        BigDecimal right = new BigDecimal("1.1");
        BigDecimal sub = left.subtract(right);
        System.out.println("sub = " + sub);

        char cChar100 = 100;
        char cChar49 = '1';

        System.out.println("cChar100 = " + (byte)cChar100);
        System.out.println("cChar100 = " + cChar100);

        System.out.println("cChar49 = " + (byte)cChar49);
        System.out.println("cChar49 = " + cChar49);

        boolean b = true;
        System.out.println("b = " + b);
        System.out.println("b = " + !b);

        int a = 101;
        int mod = a % 2;
        System.out.println("mod = " + mod);

        int a1 = 567567;
        System.out.println("a1 = " + (a1 >> 2));

        int aa = 1000 / 4;
        System.out.println("aa = " + aa);
        System.out.println("aa = " + (1000 >> 2));

        System.out.println("aa = " + Integer.toBinaryString(250));
        System.out.println("aa = " + Integer.toBinaryString(1000));

        System.out.println((1 & 2) >> (1 | 78));
    }
}
