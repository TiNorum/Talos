package com.example.myapplication.UI.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.Activities.Activity_Main;
import com.example.myapplication.ClientLauncher.ClientManager;
import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.Instruments.ShowToast;
import com.example.myapplication.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


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
                signUp();
            }
        });
    }

    private void signUp() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String answer = null;
                try {
                    answer = ClientManager.send_server(getData());

                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                switch (answer)
                {
                    case "110":
                        startActivity(new Intent(SignUp.this, Activity_Main.class));
                        finish();
                        break;
                    case "910":
                        ShowToast.showToast(SignUp.this,"Пользователь с таким логином уже существует");
                        break;
                    case "911":
                        ShowToast.showToast(SignUp.this,"Пользователь с такой почтой уже существует");
                        break;
                    default:
                        return;
                }
            }
        }).start();

    }

    private String getData() {

        return "100" + "\n\r" + login.getText().toString() + "\n\r" + password.getText().toString() +"\n\r"+ email.getText().toString();

    }
}
