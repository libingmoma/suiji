package com.example.suijifront;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CsEditActivity extends AppCompatActivity {
    private ImageView edit_back;
    private Button btn_revise;
    private Button btn_del;
    private DatabaseHelper databaseHelper = new DatabaseHelper
            (this, "database.db", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_edit);
        Intent intent = getIntent();
        final Course seeCourse = (Course) intent.getSerializableExtra("seeCourse");
        final TextView seeCourseName = (TextView) findViewById(R.id.see_course_name);
        final TextView seeDay = (TextView) findViewById(R.id.see_week);
        final TextView seeStart = (TextView) findViewById(R.id.see_classes_begin);
        final TextView seeEnd = (TextView) findViewById(R.id.see_classes_ends);
        final TextView seeTeacher = (TextView) findViewById(R.id.see_teacher_name);
        final TextView seeClassRoom = (TextView) findViewById(R.id.see_class_room);
//        seeCourseName.setText(seeCourse.getCourseName());
//        seeDay.setText(String.valueOf(seeCourse.getDay()));
//        seeStart.setText(String.valueOf(seeCourse.getClassStart()));
//        seeEnd.setText(String.valueOf(seeCourse.getClassEnd()));
//        seeTeacher.setText(seeCourse.getTeacher());
//        seeClassRoom.setText(seeCourse.getClassRoom());

        edit_back=(ImageView)findViewById(R.id.edit_back);
        edit_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CsEditActivity.this,CsTableActivity.class);
                startActivity(intent);
            }
        });

        btn_revise=(Button)findViewById(R.id.btn_revise);
        btn_revise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CsEditActivity.this,ReviseActivity.class);
                startActivity(intent);

            }
        });

        btn_del=(Button)findViewById(R.id.btn_del);
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CsEditActivity.this,CsTableActivity.class);
                startActivity(intent);

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("SeeCourseActivity", "修改的返回来了");
    }
}