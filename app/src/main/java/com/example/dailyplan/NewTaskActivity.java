package com.example.dailyplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import org.threeten.bp.LocalDate;

public class NewTaskActivity extends AppCompatActivity {

    private EditText mEditTitle;
    private EditText mEditPriority;
    private int priority = 0;
    private int clicked = 0;
    public static final String EXTRA_TITLE = "com.example.android.dailyplan.TITLE";
    public static final String EXTRA_PRIORITY = "com.example.android.dailyplan.PRIORITY";
    public static final String EXTRA_CREATE_DATE = "com.example.android.dailyplan.CREATE_DATE";
    private ImageButton button_A;
    private ImageButton button_B;
    private ImageButton button_C;
    private ImageButton button_D;
    private ImageButton button_E;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        mEditTitle = findViewById(R.id.titleEditText);
        //mEditPriority = findViewById(R.id.priorityEditText);

        // find priority buttons
        button_A = findViewById(R.id.buttonA);
        button_B = findViewById(R.id.buttonB);
        button_C = findViewById(R.id.buttonC);
        button_D = findViewById(R.id.buttonD);
        button_E = findViewById(R.id.buttonE);

        // implement save button
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
                    LocalDate current = LocalDate.now();
                    replyIntent.putExtra(EXTRA_TITLE, title);
                    replyIntent.putExtra(EXTRA_PRIORITY, priority);
                    replyIntent.putExtra(EXTRA_CREATE_DATE, current);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });

    }

    public void onPriorityButtonClick(View view) {
        Log.i("buttons", Integer.toString(view.getId()));
        restoreDefaultButtons();
        setImageButtonPriority(view);
    }

    public void restoreDefaultButtons() {
        button_A.setImageDrawable(getDrawable(R.drawable.ic_priority_a));
        button_B.setImageDrawable(getDrawable(R.drawable.ic_priority_b));
        button_C.setImageDrawable(getDrawable(R.drawable.ic_priority_c));
        button_D.setImageDrawable(getDrawable(R.drawable.ic_priority_d));
        button_E.setImageDrawable(getDrawable(R.drawable.ic_priority_e));
    }

    public void setImageButtonPriority(View view) {
        if (view == button_A) {
            button_A.setImageDrawable(getDrawable(R.drawable.ic_priority_a_clicked));
        }
        else if (view == button_B) {
            button_B.setImageDrawable(getDrawable(R.drawable.ic_priority_b_clicked));
        }
        else if (view == button_C) {
            button_C.setImageDrawable(getDrawable(R.drawable.ic_priority_c_clicked));
        }
        else if (view == button_D) {
            button_D.setImageDrawable(getDrawable(R.drawable.ic_priority_d_clicked));
        }
        else {
            button_E.setImageDrawable(getDrawable(R.drawable.ic_priority_e_clicked));
        }
    }
}

