package com.example.suijifront;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CsContentActivity extends AppCompatActivity {

    private ImageView cs_content_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_content);

        cs_content_back=(ImageView) findViewById(R.id.cs_content_back);
        cs_content_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CsContentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}