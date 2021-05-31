package com.example.suijifront;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.suijifront.ui.course.CourseFragment;

public class CsTableActivity extends AppCompatActivity {

    private ImageView table_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_table);

        table_back=(ImageView) findViewById(R.id.table_back);
        table_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CsTableActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}