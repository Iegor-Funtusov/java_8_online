package ua.com.alevel;

import ua.com.alevel.factory.EntityFactory;
import ua.com.alevel.factory.JdbcFactory;

public class OrmApplication {

    public static void start(Class<?> mainClass) {
        OrmConfig config = new OrmConfig(mainClass);
        JdbcFactory jdbcFactory = JdbcFactory.getInstance();
        jdbcFactory.initDB(mainClass);
        EntityFactory entityFactory = new EntityFactory();
        entityFactory.initEntityStore(config.getScanner());
        entityFactory.buildQuery();
        entityFactory.runQuery(jdbcFactory.getConnection());
    }
}
