package com.example.suijifront;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PicAddActivity extends AppCompatActivity {

    private ImageView pic_add_back;
    private ImageView img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_add);

        pic_add_back=(ImageView) findViewById(R.id.pic_add_back);
        pic_add_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PicAddActivity.this, CsContentEditActivity.class);
                startActivity(intent);
            }
        });

        img2=(ImageView) findViewById(R.id.img2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PicAddActivity.this, ContentShowActivity.class);
                startActivity(intent);
            }
        });

    }
}