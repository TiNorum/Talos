package com.example.myapplication.UI.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Activities.Activity_Main;
import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;



public class SignUp extends AppCompatActivity {

    String LOG_TAG = "SOCKET";

    private Button btnRegister;
    private MaterialEditText email;
    private MaterialEditText login;
    private MaterialEditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_window);

        btnRegister = findViewById(R.id.btnRegistration);
        email = findViewById(R.id.registration_mail);
        login = findViewById(R.id.registration_login);
        password = findViewById(R.id.registration_password);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }



    private String getData() {

        return "101" + "\n\r" + login.getText().toString() + "\n\r" + password.getText().toString() +"\n\r"+ email.getText().toString();

    }
}
