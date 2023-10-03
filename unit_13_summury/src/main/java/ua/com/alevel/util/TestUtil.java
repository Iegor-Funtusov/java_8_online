package ua.com.alevel.util;

public final class TestUtil {

    public final static String S1 = "S1";
    public final static String S2 = "S2";

    public final static String S3 = "Entity not found by id";

    public final static String AUDI = "AUDI";
    public final static String BMW = "BMW";

    public String carDetails = "car.details";

    static String ss;

    static {
        ss = "";
    }

    private static TestUtil instance;

    private TestUtil() {

    }

    public static TestUtil getInstance() {
        if (instance == null) {
            instance = new TestUtil();
        }

        int i = 10;

        return instance;
    }
}
