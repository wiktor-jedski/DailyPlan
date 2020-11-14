package com.example.dailyplan;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks")
public class Task {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @NonNull
    @ColumnInfo(name = "task")
    private String mTask;

    @NonNull
    @ColumnInfo(name = "priority")
    private String mPriority;

    @Ignore
    public Task(@NonNull int id, @NonNull String task, @NonNull String priority) {
        this.id = id;
        this.mTask = task;
        this.mPriority = priority;
    }

    public Task(@NonNull String task, @NonNull String priority) {
        this.mTask = task;
        this.mPriority = priority;
    }

    public String getTask() {return this.mTask;}
    public String getPriority() {return this.mPriority;}
    public int getId() {return this.id;}

    public void setId(int id) {this.id = id;}
    public void setTask(String task) {this.mTask = task;}
    public void setPriority(String priority) {this.mPriority = priority;}
}
