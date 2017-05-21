package com.example.qlsv.qlsv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;

import com.example.qlsv.qlsv.api.Login;

public class LoginActivity extends AppCompatActivity {

    private AppCompatEditText edtMSSV, edtPassWord;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Login exc = new Login();
        edtMSSV = (AppCompatEditText) findViewById(R.id.edtUser);
        edtPassWord = (AppCompatEditText) findViewById(R.id.edtPassWord);

        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exc.Login(LoginActivity.this,edtMSSV.getText().toString() ,edtPassWord.getText().toString() );
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
