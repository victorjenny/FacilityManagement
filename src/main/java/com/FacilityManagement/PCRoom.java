package com.FacilityManagement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class PCRoom extends Room {
    @Column(name = "pc")
    private int pc;

    public int getPc() {
        return pc;
    }

    public void setPc(int num) {
        this.pc = num;
    }
}
