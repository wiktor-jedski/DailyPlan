package com.example.dailyplan;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface TaskDao {

    @Insert
    void insertTask(Task task);

    @Query("DELETE FROM tasks")
    void deleteAll();

    @Query("SELECT * FROM tasks ORDER BY id ASC")
    LiveData<List<Task>> getAllTasks();

    @Query("SELECT * FROM tasks WHERE id = :id")
    LiveData<Task> loadTaskById(int id);

    @Delete
    void deleteTask(Task task);
}
