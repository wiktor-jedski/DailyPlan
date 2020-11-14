package com.example.dailyplan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

public class MainActivity extends AppCompatActivity {

    MaterialCalendarView calendarView;
    private TaskViewModel mTaskViewModel;
    public static final int NEW_TASK_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = findViewById(R.id.calendar);

        // just adding a comment to check how git works
        mTaskViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(TaskViewModel.class);

        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                // start DayActivity with appropriate date
            }
        });

        FloatingActionButton fabAdd = findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewTaskActivity.class);
                startActivityForResult(intent, NEW_TASK_ACTIVITY_REQUEST_CODE);
            }
        });

        FloatingActionButton fabBrowse = findViewById(R.id.fab_browse);
        fabBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListTaskActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_TASK_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Task task = new Task(data.getStringExtra(NewTaskActivity.EXTRA_TITLE), data.getStringExtra(NewTaskActivity.EXTRA_PRIORITY));
            mTaskViewModel.insertTask(task);
        } else {
            Toast.makeText(getApplicationContext(), "empty task", Toast.LENGTH_SHORT).show();
        }
    }
}
