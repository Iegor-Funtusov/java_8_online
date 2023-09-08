package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringTest {

    public void test() {
//        for (int i = 0; i < 1_000; i++) {
//            String s = "vfdfsd";
//        }
        String s1 = "test";
        String s2 = "test";
        s1 = "test1";
        String s3 = new String(""); // not use!!!!


        char[] charArray = s1.toCharArray();

        String upperCase = s1.toUpperCase();
        System.out.println("upperCase = " + upperCase);
        String lowerCase = s1.toLowerCase();
        System.out.println("lowerCase = " + lowerCase);

        String email = "  bla@mail.com  ";
        System.out.println("email = " + email);
        email = email.trim();
        System.out.println("email = " + email);

        s1 = "   \n    ";
        System.out.println("isEmpty: " + !s1.isEmpty());
        System.out.println("is not Blank: " + !s1.isBlank()              );
        System.out.println("is not Blank: " + StringUtils.isNotBlank(s1) );


        s1 = "Hello world1";
        int o = s1.indexOf("u");
        System.out.println("o = " + o);

        boolean wo = s1.contains("wo");
        System.out.println("wo = " + wo);

        String text = "Hello World. Bad World";
        String[] split = text.split("\\.");
        for (String s : split) {
            System.out.println("s = " + s);
        }

        text = "Hello World.Bad World";
        System.out.println("text = " + text);
        text = text.replaceAll("\\.", ". ");
        System.out.println("text = " + text);

        text = "Hello World. Bad Worlddd";
        text = text.substring(0, text.length() - 2);
        System.out.println("text = " + text);

        System.out.println("startsWith: " + text.startsWith("He"));
        System.out.println("endsWith: " + text.endsWith("ld"));


        StringBuilder sql = new StringBuilder("select * from students ");
        sql.append(" where age in (");
        for (int i = 0; i < 5; i++) {
            if (i == 4) {
                sql.append(i);
            } else {
                sql.append(i).append(", ");
            }
        }
        sql.append(");");

        System.out.println("sql = " + sql);
    }
}
