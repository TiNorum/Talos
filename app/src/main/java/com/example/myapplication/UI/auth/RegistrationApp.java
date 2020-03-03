package com.example.myapplication.UI.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.rengwuxian.materialedittext.MaterialEditText;

public class RegistrationApp extends AppCompatActivity {


    private Button btnRegister;
    private MaterialEditText email;
    private MaterialEditText login;
    private MaterialEditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_window);

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
}
