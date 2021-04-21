package com.example.suijifront;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Button;
import android.widget.Button;
import android.content.Intent;

public class MessageLogInActivity extends AppCompatActivity {
    private Button login4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_log_in);
        login4=(Button) findViewById(R.id.login4);
        login4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageLogInActivity.this, JitangActivity.class);
                startActivity(intent);
            }
        });
    }
}