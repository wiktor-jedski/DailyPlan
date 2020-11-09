package com.example.dailyplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewTaskActivity extends AppCompatActivity {

    private EditText mEditTitle;
    private EditText mEditPriority;
    public static final String EXTRA_TITLE = "com.example.android.dailyplan.TITLE";
    public static final String EXTRA_PRIORITY = "com.example.android.dailyplan.PRIORITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        mEditTitle = findViewById(R.id.titleEditText);
        mEditPriority = findViewById(R.id.priorityEditText);

        Button button = findViewById(R.id.buttonSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditPriority.getText()) || TextUtils.isEmpty(mEditPriority.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String title = mEditTitle.getText().toString();
                    String priority = mEditPriority.getText().toString();
                    replyIntent.putExtra(EXTRA_TITLE, title);
                    replyIntent.putExtra(EXTRA_PRIORITY, priority);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }

    // implement spinner
}
