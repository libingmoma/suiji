package com.example.suijifront;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MessageLogInActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipe_refresh;
    final OkHttpClient client = new OkHttpClient();
    private String             str;
    private String             str2;
    private String             str3;
    private Gson gson = new Gson();
    private EditText phoneNumber;
    private Button getVerification;
    private Button login4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_log_in);
        login4=(Button) findViewById(R.id.login4);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        getVerification = (Button) findViewById(R.id.getVerification);

        login4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //postMessage();
                Intent intent = new Intent(MessageLogInActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        getVerification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = phoneNumber.getText().toString();

                getVer(phone);
            }
        });


    }

    public void getVer(String phone){
        Log.i("phone",phone);
        String phone2 = "http://47.100.4.109:5555/student/register_or_login/send_auth_code?phone=" + phone;
        Log.i("phone2",phone2);
        final Request request = new Request.Builder()
                .get()
                .tag(this)
                .url(phone2)
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        //Log.i("后端数据","打印GET响应的数据：" + response.body().string());
                        str2 = response.body().string();
                    } else {
                        throw new IOException("Unexpected code " + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                MessageLogInActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //Log.i("POSTPOSTPOST",str2);
                        Log.i("后端数据","打印GET响应的数据：" + str2);
                    }
                });
            }
        }).start();

    }



    public void postMessage(){
        RequestBody body = new FormBody.Builder()
                .add("code", "123")
                .build();

        final Request request = new Request.Builder()
                .url("http://47.100.4.109:5555/student/register_or_login/verify_auth_code")
                .post(body)
                .build();


        new Thread(new Runnable() {
            @Override
            public void run() {
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        //Log.i("后端数据","打印GET响应的数据：" + response.body().string());
                        str3 = response.body().string();
                    } else {
                        throw new IOException("Unexpected code " + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                MessageLogInActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //Log.i("POSTPOSTPOST",str2);
                        Log.i("后端数据","打印GET响应的数据：" + str3);
                    }
                });
            }
        }).start();
    }
}
