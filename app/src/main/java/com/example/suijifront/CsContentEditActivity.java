package com.example.suijifront;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CsContentEditActivity extends AppCompatActivity {

    private ImageView cs_content_edit_back;
    private Button add_pic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_content_edit);

        cs_content_edit_back=(ImageView) findViewById(R.id.cs_content_edit_back);
        cs_content_edit_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CsContentEditActivity.this, CsContentActivity.class);
                startActivity(intent);
            }
        });

        add_pic=(Button) findViewById(R.id.add_pic);
        add_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CsContentEditActivity.this, PicAddActivity.class);
                startActivity(intent);
            }
        });
    }
}