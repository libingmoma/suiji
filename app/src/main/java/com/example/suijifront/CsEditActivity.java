package com.example.suijifront;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CsEditActivity extends AppCompatActivity {
    private ImageView edit_back;
    private Button preserve_btn_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_edit);

        edit_back=(ImageView)findViewById(R.id.edit_back);
        edit_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CsEditActivity.this,CsTableActivity.class);
                startActivity(intent);
            }
        });

        preserve_btn_edit=(Button)findViewById(R.id.preserve_btn_edit);
        preserve_btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CsEditActivity.this,CsTableActivity.class);
                startActivity(intent);
            }
        });
    }
}