package com.example.qlsv.qlsv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

import com.dd.CircularProgressButton;
import com.example.qlsv.qlsv.api.LoginApi;


public class LoginActivity extends AppCompatActivity {

    private AppCompatEditText edtMSSV, edtPassWord;
    private CircularProgressButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final LoginApi exc = new LoginApi();


        edtMSSV = (AppCompatEditText) findViewById(R.id.edtUser);
        edtPassWord = (AppCompatEditText) findViewById(R.id.edtPassWord);

        btnLogin = (CircularProgressButton) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLogin.setIndeterminateProgressMode(true);
                btnLogin.setProgress(50);
            }
        });
    }


    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
