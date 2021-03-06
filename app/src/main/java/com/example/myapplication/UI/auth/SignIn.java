package com.example.myapplication.UI.auth;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Activities.Activity_Main;
import com.example.myapplication.ClientLauncher.ClientManager;
import com.example.myapplication.ClientLauncher.DataBase.DBHelper;
import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.Instruments.ShowToast;
import com.example.myapplication.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;


public class SignIn extends AppCompatActivity {
    private static final String LOG_TAG = "SOCKET";  //AppCompatActivity.class.getSimpleName();
    private Button btnSignIn;
    private TextView tvRegister;
    private MaterialEditText login;
    private MaterialEditText password;
    private TextView warning;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_window);
        dbHelper = new DBHelper(this);
        // Проверка данных пользователя, если он вводил данные, то  пропускаем ввод пароля и логина для авторизации - начало

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Cursor cursor = database.query(DBHelper.TABLE_USER, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            int name, password;
            name = cursor.getColumnIndex(DBHelper.KEY_NAME);
            password = cursor.getColumnIndex(DBHelper.KEY_PASSWORD);


            try {
                String answer = ClientManager.send_server("102" + Constants.NEXT_LINE + cursor.getString(name) + Constants.NEXT_LINE + cursor.getString(password));

                if (answer != null && (answer.equals("200") || answer.equals("201") || answer.equals("202"))) {

                    contentValues.put(DBHelper.PERMISSIONS, answer);
                    database.insert(DBHelper.TABLE_USER,null,contentValues);
                    cursor.close();
                    database.close();

                    startActivity(new Intent(SignIn.this, Activity_Main.class));
                    finish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        cursor.close();
        database.close();
        // Проверка данных пользователя, если он вводил данные, то  пропускаем ввод пароля и логина для авторизации - конец


        btnSignIn = findViewById(R.id.btnSignIn);
        tvRegister = findViewById(R.id.tv_register);
        login = findViewById(R.id.sign_in_login);
        password = findViewById(R.id.sign_in_password);
        warning = findViewById(R.id.signIn_warning_notification);

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSignIn.setClickable(false);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();

                        }
                        btnSignIn.setClickable(true);
                    }
                });
                startActivity(new Intent(SignIn.this, SignUp.class));
                finish();
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

                if (answer != null && (answer.equals("200") || answer.equals("201") || answer.equals("202"))) {

                    SQLiteDatabase database = dbHelper.getReadableDatabase();
                    ContentValues contentValues = new ContentValues();

                    contentValues.put(DBHelper.KEY_NAME, login.getText().toString());
                    contentValues.put(DBHelper.KEY_PASSWORD, password.getText().toString());
                    contentValues.put(DBHelper.PERMISSIONS, answer);
                    database.insert(DBHelper.TABLE_USER,null,contentValues);

                    database.close();

                    startActivity(new Intent(SignIn.this, Activity_Main.class));
                    finish();
                }

            }
        }).start();

    }

    private String getData() {
        String send = "102" + Constants.NEXT_LINE + login.getText().toString() + Constants.NEXT_LINE + password.getText().toString();
        return send;
    }


}
