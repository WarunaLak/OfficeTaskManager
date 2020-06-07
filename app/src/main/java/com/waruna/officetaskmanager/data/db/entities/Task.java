package com.waruna.officetaskmanager.data.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task")
public class Task {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "task_id")
    private int taskID;

    @ColumnInfo(name = "total_time")
    private int totalTime;

    private int progress;

    private int status;

    @ColumnInfo(name = "task_details")
    private String taskDetails;

    @ColumnInfo(name = "s_date")
    private String sDate;

    @ColumnInfo(name = "e_date")
    private String eDate;

    public Task(int taskID, int totalTime, int progress, int status, String taskDetails, String sDate, String eDate) {
        this.taskID = taskID;
        this.totalTime = totalTime;
        this.progress = progress;
        this.status = status;
        this.taskDetails = taskDetails;
        this.sDate = sDate;
        this.eDate = eDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getTaskID() {
        return taskID;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public int getProgress() {
        return progress;
    }

    public int getStatus() {
        return status;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    public String getsDate() {
        return sDate;
    }

    public String geteDate() {
        return eDate;
    }

}
