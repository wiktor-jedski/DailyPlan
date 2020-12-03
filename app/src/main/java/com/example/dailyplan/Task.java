package com.example.dailyplan;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import org.threeten.bp.LocalDate;

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

    // implement Created Date (?)
    @NonNull
    @ColumnInfo(name = "created_date")
    private LocalDate mCreatedDate;

    // implement Planned Date
    @ColumnInfo(name = "planned_date")
    private LocalDate mPlannedDate;

    @Ignore
    public Task(@NonNull int id, @NonNull String task, @NonNull String priority, @NonNull LocalDate createdDate, LocalDate plannedDate) {
        this.id = id;
        this.mTask = task;
        this.mPriority = priority;
        this.mCreatedDate = createdDate;
        this.mPlannedDate = plannedDate;
    }

    public Task(@NonNull String task, @NonNull String priority, @NonNull LocalDate createdDate, LocalDate plannedDate) {
        this.mTask = task;
        this.mPriority = priority;
        this.mCreatedDate = createdDate;
        this.mPlannedDate = plannedDate;
    }

    public String getTask() {return this.mTask;}
    public String getPriority() {return this.mPriority;}
    public LocalDate getCreatedDate() {return this.mCreatedDate;}
    public LocalDate getPlannedDate() {return this.mPlannedDate;}
    public int getId() {return this.id;}

    public void setId(int id) {this.id = id;}
    public void setTask(String task) {this.mTask = task;}
    public void setPriority(String priority) {this.mPriority = priority;}
    public void setCreatedDate(LocalDate date) {this.mCreatedDate = date;}
    public void setPlannedDate(LocalDate date) {this.mPlannedDate = date;}
}
