package com.example.dailyplan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
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

import org.threeten.bp.LocalDate;

import java.util.List;
import java.util.Observer;

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
        //Observer<>

        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                // start DayActivity with appropriate date
                // if selected change to 1
                // get the database
                // check if there is a Task with Task.date = date
                /*for (int i = 0; ; ) {
                }
                if not, start NewTaskActivity and pass date as extra
                if yes, edit this activity*/
                //toast date
                Toast.makeText(MainActivity.this, date.getDate().toString() , Toast.LENGTH_SHORT).show();
            }
        });

        // FAB that starts NewTaskActivity in bottom right
        FloatingActionButton fabAdd = findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewTaskActivity.class);
                startActivityForResult(intent, NEW_TASK_ACTIVITY_REQUEST_CODE);
            }
        });

        // FAB that starts browsing activity
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

        String created = data.getStringExtra(NewTaskActivity.EXTRA_CREATE_DATE);
        if (requestCode == NEW_TASK_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Task task = new Task(data.getStringExtra(NewTaskActivity.EXTRA_TITLE), data.getStringExtra(NewTaskActivity.EXTRA_PRIORITY), LocalDate.parse(created), null);
            mTaskViewModel.insertTask(task);
            Toast.makeText(MainActivity.this, "Added task with date: " + created, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "empty task", Toast.LENGTH_SHORT).show();
        }
    }
}
