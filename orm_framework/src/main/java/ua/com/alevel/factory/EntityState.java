package ua.com.alevel.factory;

import java.util.Set;

public class EntityState {

    private String tableName;
    private Set<ColumnState> columnStateSet;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Set<ColumnState> getColumnStateSet() {
        return columnStateSet;
    }

    public void setColumnStateSet(Set<ColumnState> columnStateSet) {
        this.columnStateSet = columnStateSet;
    }

    @Override
    public String toString() {
        return "EntityState{" +
                "tableName='" + tableName + '\'' +
                ", columnStateSet=" + columnStateSet +
                '}';
    }
}
