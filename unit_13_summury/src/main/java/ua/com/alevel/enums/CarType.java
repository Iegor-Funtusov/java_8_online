package ua.com.alevel.enums;

public enum CarType {

    AUDI("Audi", 10), BMW("BMW", 56);

    private final String shortName;
    private final Integer number;

    CarType(String shortName, Integer number) {
        this.shortName = shortName;
        this.number = number;
    }

    public String getShortName() {
        return shortName;
    }

    public Integer getNumber() {
        return number;
    }

    //    public final static String AUDI = "AUDI";
//    public final static String BMW = "BMW";
}
