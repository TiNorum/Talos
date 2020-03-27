package com.example.myapplication.UI.auth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Activities.Activity_Main;
import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.R;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicReference;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SignIn extends AppCompatActivity {
    private static final String LOG_TAG = "SOCKET";  //AppCompatActivity.class.getSimpleName();
    private Button btnSignIn;
    private TextView tvRegister;
    private MaterialEditText login;
    private MaterialEditText password;
    private TextView warning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_window);


        btnSignIn = findViewById(R.id.btnSignIn);
        tvRegister = findViewById(R.id.tv_register);
        login = findViewById(R.id.sign_in_login);
        password = findViewById(R.id.sign_in_password);
        warning = findViewById(R.id.signIn_warning_notification);


        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SignIn.this, SignUp.class));
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();

            }
        });

    }

    private void signIn() {
        if (login.getText().toString().isEmpty()) {
            warning.setText("Введите логин!");
            warning.setVisibility(View.VISIBLE);
            return;
        }
        if (password.getText().toString().isEmpty()) {
            warning.setText("Введите пароль!");
            warning.setVisibility(View.VISIBLE);

            return;
        }

        if ((login.getText().length() < 4 && login.getText().length() > 20) || password.getText().length() < 6) {
            warning.setText("Неправильный логин или пароль!");
            warning.setVisibility(View.VISIBLE);
            return;
        }


        Single.fromCallable(() -> {
            try {
                Log.d(LOG_TAG, "Установка соединения");
                Socket mSocket = new Socket(Constants.HOST, Constants.PORT);
                Log.d(LOG_TAG, "Соединение установленно");
                if (mSocket.isClosed()) {
                    throw new Exception("Ошибка отправки данных. " +
                            "Сокет не создан или закрыт ");
                }

                BufferedReader inFromServer =
                        new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
                DataOutputStream outToServer =
                        new DataOutputStream(mSocket.getOutputStream());

                String data = getData();

                Log.d(LOG_TAG, "Идет отправка сообщения на сервер...");
                try {
                    outToServer.writeBytes(data);
                    outToServer.flush();
                    Log.d(LOG_TAG, data +" Отправлено сообщение на сервер");
                } catch (Exception e) {
                    throw e;
                }

                String answer = "";

                try {
                    answer = inFromServer.readLine();
                    Log.d(LOG_TAG, answer + " сообщение с сервера");

                } catch (Exception e) {
                    throw e;
                }

                mSocket.close();

                if (answer.isEmpty())
                    throw new Exception("Ошибка получения данных. ");

                return answer;
            } catch (Exception ex) {
                throw ex;
            }

        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(text ->
                        {
                            if (text.equals("103")) {
                                startActivity(new Intent(SignIn.this, Activity_Main.class));
                                finish();
                            }
                        },
                        e -> {
                            Log.e(LOG_TAG, e.getMessage());
                             return;

                        });
    }

    private String getData() {

        return "102" + " " + login.getText().toString() + " " + password.getText().toString();

    }


}
