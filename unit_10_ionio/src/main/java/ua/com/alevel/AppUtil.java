package ua.com.alevel;

public enum AppUtil {

    FILE_NAME("test.txt"),
    DIR_NAME("test"),
    DIRS_NAME("test/test1/test2"),
    STUDENT_NAME("student.txt");

    private final String path;

    AppUtil(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
