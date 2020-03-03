package com.example.myapplication.UI.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Activities.Activity_Main;
import com.example.myapplication.R;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignInApp extends AppCompatActivity {
    private Button btnSignIn;
    private TextView tvRegister;
    private MaterialEditText login;
    private MaterialEditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_app_window);


        btnSignIn = findViewById(R.id.btnSignIn);
        tvRegister = findViewById(R.id.tv_register);
        login = findViewById(R.id.sign_in_login);
        password = findViewById(R.id.sign_in_password);

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SignInApp.this, RegistrationApp.class));
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInApp.this, Activity_Main.class));
                finish();

            }
        });

    }

    private void signIn() {


    }


}
