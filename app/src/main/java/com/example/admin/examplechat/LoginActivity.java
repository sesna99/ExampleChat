package com.example.admin.examplechat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by admin on 2017-08-26.
 */

public class LoginActivity extends AppCompatActivity {
    private EditText user_name_et;
    private Button login_btn;
    private String imei;
    private String user_name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_name_et = (EditText) findViewById(R.id.user_name_et);
        login_btn = (Button) findViewById(R.id.login_btn);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_name = user_name_et.getText().toString();
                if(user_name.trim().equals("")) {
                    new AlertDialog.Builder(LoginActivity.this)
                            .setMessage("이름을 입력해주세요!")
                            .setPositiveButton("확인", null)
                            .show();
                }
                else {
                    Util.getInstance().setUserName(user_name_et.getText().toString());
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
            }
        });

        TelephonyManager mgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        try{
            imei = mgr.getDeviceId();
            Util.getInstance().setImei(imei);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
