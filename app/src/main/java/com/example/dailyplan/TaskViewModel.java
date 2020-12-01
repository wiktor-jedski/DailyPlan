package com.example.dailyplan;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class TaskViewModel extends AndroidViewModel {

    private TaskRepository mRepository;
    private LiveData<List<Task>> mAllTasks;
    private LiveData<Integer> mTaskCount;

    public TaskViewModel (Application application) {
        super(application);
        mRepository = new TaskRepository(application);
        mAllTasks = mRepository.getAllTasks();
        mTaskCount = mRepository.getTaskCount();
    }

    LiveData<List<Task>> getAllTasks() {return mAllTasks;}
    LiveData<Integer> getTaskCount() {return mTaskCount;}

    public void insertTask(Task task) {mRepository.insertTask(task);}
}
