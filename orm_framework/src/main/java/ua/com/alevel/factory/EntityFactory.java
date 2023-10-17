package ua.com.alevel.factory;

import org.reflections.Reflections;
import org.reflections.Store;
import org.reflections.scanners.Scanners;
import ua.com.alevel.annotations.Column;
import ua.com.alevel.annotations.Entity;
import ua.com.alevel.annotations.PrimaryKey;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EntityFactory {

    private final Set<EntityState> entityStates = new HashSet<>();
    private final Set<String> querySet = new HashSet<>();

    public void initEntityStore(Reflections scanner) {
        Store store = scanner.getStore();
        store.forEach((k, v) -> {
            if (k.equals(Scanners.TypesAnnotated.name())) {
                v.forEach((key, value) -> {
                    if (key.equals(Entity.class.getName())) {
                        value.forEach(this::buildEntity);
                    }
                });
            }
        });
    }

    private void buildEntity(String entityName) {
        System.out.println("entityName = " + entityName);
        try {
            Class<?> entityClass = Class.forName(entityName);
            Entity entity = entityClass.getAnnotation(Entity.class);
            String tableName = entity.name();
            EntityState entityState = new EntityState();
            entityState.setTableName(tableName);
            Field[] fields = entityClass.getDeclaredFields();
            Set<ColumnState> columnStates = new HashSet<>();
            for (Field field : fields) {
                ColumnState columnState = new ColumnState();
                String columnName;
                if (field.isAnnotationPresent(Column.class)) {
                    Column column = field.getAnnotation(Column.class);
                    columnName = column.name();
                    columnState.setLength(column.length());
                } else {
                    columnName = field.getName();
                    columnState.setLength(255);
                }
                columnState.setId(field.isAnnotationPresent(PrimaryKey.class));
                columnState.setColumnName(columnName);
                columnState.setType(field.getType());
                columnStates.add(columnState);
            }
            entityState.setColumnStateSet(columnStates);
            entityStates.add(entityState);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void buildQuery() {
        entityStates.forEach(es -> {
            Set<ColumnState> states = es
                    .getColumnStateSet()
                    .stream()
                    .sorted((a, b) -> Boolean.compare(b.isId(), a.isId()))
                    .collect(Collectors.toCollection(LinkedHashSet::new));
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("create table ");
            sqlBuilder.append(es.getTableName());
            sqlBuilder.append(" (");
            for (ColumnState state : states) {
                if (state.isId()) {
                    sqlBuilder.append(state.getColumnName());
                    if (state.getType().isAssignableFrom(Long.class)) {
                        sqlBuilder.append(" bigint ");
                    }
                    if (state.getType().isAssignableFrom(Integer.class)) {
                        sqlBuilder.append(" int ");
                    }
                    sqlBuilder.append("auto_increment primary key, ");
                } else {
                    sqlBuilder.append(state.getColumnName());
                    if (state.getType().isAssignableFrom(String.class)) {
                        sqlBuilder.append(" varchar(");
                        sqlBuilder.append(state.getLength());
                        sqlBuilder.append(")");
                    }
                    if (state.getType().isAssignableFrom(Integer.class)) {
                        sqlBuilder.append(" int");
                    }
                    sqlBuilder.append(", ");
                }
            }
            sqlBuilder.append(")");
            String q = sqlBuilder.toString();
            String query = q.replaceAll(", \\)", ")");
//            System.out.println("sqlBuilder = " + sqlBuilder);
            querySet.add(query);
        });
    }

    public void runQuery(Connection connection) {
        for (String query : querySet) {
            System.out.println("query = " + query);
            try(PreparedStatement ps = connection.prepareStatement(query)) {
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("e = " + e);
            }
        }
    }
}
