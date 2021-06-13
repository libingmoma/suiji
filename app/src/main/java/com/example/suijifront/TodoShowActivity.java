package com.example.suijifront;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TodoShowActivity extends AppCompatActivity {

    private Button todo_j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_show);

        todo_j=(Button)findViewById(R.id.todo_j);
        todo_j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TodoShowActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }
}