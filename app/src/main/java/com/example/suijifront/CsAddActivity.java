package com.example.suijifront;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CsAddActivity extends AppCompatActivity {
    private ImageView add_back;
    private Button preserve_btn_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_add);
        add_back=(ImageView) findViewById(R.id.add_back);
        add_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CsAddActivity.this, CsTableActivity.class);
                startActivity(intent);
            }
        });

        preserve_btn_add=(Button)findViewById(R.id.preserve_btn_add);
        preserve_btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CsAddActivity.this,CsTableActivity.class);
                startActivity(intent);
            }
        });

    }
}