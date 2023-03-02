package com.FacilityManagement;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;

@Entity
@Table(name = "room")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Room {
    // note: attributes should be the same order in the database
    // (if not using @column)
    @Id
    @Column(name = "courseid")
    private String courseid; // courseid - primary key in the Room table

    @Column(name = "coursename")
    private String coursename;

    @Column(name = "dtype", insertable = false, updatable = false) // dtype: default
    private String dtype; // dtype: the default attribute for sub-types

    @Column(name = "category")
    private String category;

    @Column(name = "slots")
    private String slots;

    @Column(name = "startdate")
    private String startdate;

    @Column(name = "enddate")
    private String enddate;

    @Column(name = "starttime")
    private String starttime;

    @Column(name = "endtime")
    private String endtime;

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String name) {
        this.courseid = name;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getSlots() {
        return slots;
    }

    public void setSlots(String slots) {
        this.slots = slots;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

}
