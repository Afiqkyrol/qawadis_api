package com.cerouno.qawadis_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "VW_TABLE_CODE")
public class VwTableCode {

    @Id
    @Column(name = "table_code_id")
    private String tableCodeId;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "table_description")
    private String tableDescription;

    public VwTableCode() {
    }

    public VwTableCode(String tableCodeId, String tableName, String tableDescription) {
        this.tableCodeId = tableCodeId;
        this.tableName = tableName;
        this.tableDescription = tableDescription;
    }

    public String getTableCodeId() {
        return tableCodeId;
    }

    public void setTableCodeId(String tableCodeId) {
        this.tableCodeId = tableCodeId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableDescription() {
        return tableDescription;
    }

    public void setTableDescription(String tableDescription) {
        this.tableDescription = tableDescription;
    }
}
