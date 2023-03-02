package com.FacilityManagement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class ClassRoom extends Room {
    @Column(name = "tables")
    private int tables;

    public int getTables() {
        return tables;
    }

    public void setTables(int num) {
        this.tables = num;
    }
}
