package ua.com.alevel;

import ua.com.alevel.factory.JdbcFactory;

public class SqlJoinMain {
    public static void main(String[] args) {
        JdbcFactory.getInstance().initDB(SqlJoinMain.class);
        new TestJdbc().test();
    }
}