package com.example.suijifront;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ContentShowActivity extends AppCompatActivity {

    private ImageView cs_content_show_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_show);

        cs_content_show_back=(ImageView) findViewById(R.id.cs_content_show_back);
        cs_content_show_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ContentShowActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

