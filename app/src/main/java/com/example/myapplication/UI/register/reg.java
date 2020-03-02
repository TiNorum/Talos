package com.example.myapplication.UI.register;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Activities.Activity_Main;
import com.example.myapplication.Activities.Activity_Number_1;
import com.example.myapplication.R;
import com.google.android.material.snackbar.Snackbar;
import com.rengwuxian.materialedittext.MaterialEditText;

public class reg extends AppCompatActivity {
    private Button btnSignIn;
    private Button btnRegister;
    private RelativeLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_app_window);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnRegister = findViewById(R.id.btnRegister);
        root = findViewById(R.id.root_register__element);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegisterWindow();
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignInWindow();
            }
        });

    }

    private void showSignInWindow() {
        final AlertDialog.Builder dialog =new AlertDialog.Builder(this);
        dialog.setTitle("Вход");
        dialog.setMessage("Введите логин и пароль:");

        LayoutInflater inflater = LayoutInflater.from(this);
        View registerWindow = inflater.inflate(R.layout.sign_in_window,null);
        dialog.setView(registerWindow);


        final MaterialEditText email = registerWindow.findViewById(R.id.email_field);
        final MaterialEditText login = registerWindow.findViewById(R.id.login_field);
        MaterialEditText password = registerWindow.findViewById(R.id.password_field);

        dialog.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
            }
        });

        dialog.setPositiveButton("Войти", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

                if(TextUtils.isEmpty(login.getText().toString()))
                {
                    Snackbar.make(root,"Введите login.",Snackbar.LENGTH_LONG).show();

                    return;
                }
                if(TextUtils.isEmpty(login.getText().toString()))
                {
                    Snackbar.make(root,"Введите password.",Snackbar.LENGTH_LONG).show();

                    return;
                }
                //перех на новую сцену
                startActivity(new Intent(reg.this, Activity_Main.class));
                finish();

            }
        });
        dialog.show();
    }

    private void showRegisterWindow() {
        final AlertDialog.Builder dialog =new AlertDialog.Builder(this);
        dialog.setTitle("Регистрация");
        dialog.setMessage("Введите все данные для регистрации");

        LayoutInflater inflater = LayoutInflater.from(this);
        View registerWindow = inflater.inflate(R.layout.register_window,null);
        dialog.setView(registerWindow);


        final MaterialEditText email = registerWindow.findViewById(R.id.email_field);
        final MaterialEditText login = registerWindow.findViewById(R.id.login_field);
        final MaterialEditText password = registerWindow.findViewById(R.id.password_field);

        dialog.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
            }
        });

        dialog.setPositiveButton("Зарегистрироваться", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
               if(TextUtils.isEmpty(email.getText().toString()))
                {
                    Snackbar.make(root,"Введите email.",Snackbar.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(login.getText().toString()))
                {
                    Snackbar.make(root,"Введите login.",Snackbar.LENGTH_LONG).show();

                    return;
                }
                if(TextUtils.isEmpty(login.getText().toString()))
                {
                    Snackbar.make(root,"Введите password.",Snackbar.LENGTH_LONG).show();

                    return;
                }

                //Регистрация

            }
        });
        dialog.show();
    }
}
