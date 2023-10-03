package ua.com.alevel.records;

public final record BlaRecord(String s, Integer i, Long l, String s1) {

    public void test() {
        System.out.println("BlaRecord.test");
    }
}
