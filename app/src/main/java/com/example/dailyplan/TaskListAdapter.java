package com.example.dailyplan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskViewHolder> {

    private final LayoutInflater mInflater;
    private List<Task> mTasks;

    TaskListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    class TaskViewHolder extends RecyclerView.ViewHolder {
        private final TextView taskItemView;

        TaskViewHolder(View itemView) {
            super(itemView);
            taskItemView = itemView.findViewById(R.id.recyclerTitle);
        }
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        if (mTasks != null) {
            Task current = mTasks.get(position);
            holder.taskItemView.setText(current.getTask());
        } else {
            holder.taskItemView.setText("No task");
        }
    }

    void setTasks(List<Task> tasks) {
        mTasks = tasks;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mTasks != null) {
            return mTasks.size();
        } else return 0;
    }

    public Task getTaskAtPosition(int position) {
        return mTasks.get(position);
    }
}
