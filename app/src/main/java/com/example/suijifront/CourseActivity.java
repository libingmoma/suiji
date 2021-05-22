package com.example.suijifront;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CourseActivity extends AppCompatActivity {

    private Button courseTableCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        courseTableCheck=(Button) findViewById(R.id.courseTableCheck);
        courseTableCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CourseActivity.this,CsTableActivity.class);
                startActivity(intent);
            }
        });
    }
}