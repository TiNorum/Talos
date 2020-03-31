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

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

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
                            Log.d(LOG_TAG, "Отправлено сообщение на сервер");
                        } catch (Exception e) {
                            throw e;
                        }

                        String answer = "";

                        try {
                            answer = inFromServer.readLine();
                            Log.d(LOG_TAG, answer + "сообщение с сервера");

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
                                        startActivity(new Intent(SignUp.this, Activity_Main.class));
                                        finish();
                                    }
                                },
                                e -> {
                                    Log.e(LOG_TAG, e.getMessage());
                                    return;

                                });
            }
        });
    }



    private String getData() {

        return "101" + "\n\r" + login.getText().toString() + "\n\r" + password.getText().toString() +"\n\r"+ email.getText().toString();

    }
}
