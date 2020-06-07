package com.waruna.officetaskmanager.data.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "inquiry")
public class Inquiry {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "inquiry_id")
    private int inquiryID;

    @ColumnInfo(name = "total_time")
    private int totalTime;

    private int finish;

    @ColumnInfo(name = "inquiry_details")
    private String inquiryDetails;

    private String date;


    public Inquiry(int inquiryID, int totalTime, int finish, String inquiryDetails, String date) {
        this.inquiryID = inquiryID;
        this.totalTime = totalTime;
        this.finish = finish;
        this.inquiryDetails = inquiryDetails;
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getInquiryID() {
        return inquiryID;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public int getFinish() {
        return finish;
    }

    public String getInquiryDetails() {
        return inquiryDetails;
    }

    public String getDate() {
        return date;
    }
}
