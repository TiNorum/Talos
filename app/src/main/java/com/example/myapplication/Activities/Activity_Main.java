package com.example.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


import com.example.myapplication.Activities.Tasks.*;
import com.example.myapplication.R;

public class Activity_Main extends AppCompatActivity {
    Button to_task_1;
    Button to_task_2;
    Button to_task_3;
    Button to_task_4;
    Button to_task_5;
    Button to_task_6;
    Button to_task_7;
    Button to_task_8;
    Button to_task_9;
    Button to_task_10;
    Button to_task_11;
    Button to_task_12;
    Button to_task_13;
    Button to_task_14;
    Button to_task_15;
    Button to_task_16;
    Button to_task_17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // super - обращение к родительскому классу AppCompatActivity
        super.onCreate(savedInstanceState);
        // выставляем отображение нашего лэйаута
        setContentView(R.layout.activity_main);

        // ищем кнопку с именем из всего списка и задаём ей событий Click
        to_task_1 = findViewById(R.id.buttonType1);
        to_task_1.setOnClickListener(oclBtn);

        to_task_2 = findViewById(R.id.buttonType2);
        to_task_2.setOnClickListener(oclBtn);

        to_task_3 = findViewById(R.id.buttonType3);
        to_task_3.setOnClickListener(oclBtn);

        to_task_4 = findViewById(R.id.buttonType4);
        to_task_4.setOnClickListener(oclBtn);

        to_task_5 = findViewById(R.id.buttonType5);
        to_task_5.setOnClickListener(oclBtn);

        to_task_6 = findViewById(R.id.buttonType6);
        to_task_6.setOnClickListener(oclBtn);

        to_task_7 = findViewById(R.id.buttonType7);
        to_task_7.setOnClickListener(oclBtn);

        to_task_8 = findViewById(R.id.buttonType8);
        to_task_8.setOnClickListener(oclBtn);

        to_task_9 = findViewById(R.id.buttonType9);
        to_task_9.setOnClickListener(oclBtn);

        to_task_10 = findViewById(R.id.buttonType10);
        to_task_10.setOnClickListener(oclBtn);

        to_task_12 = findViewById(R.id.buttonType12);
        to_task_12.setOnClickListener(oclBtn);

        to_task_13 = findViewById(R.id.buttonType13);
        to_task_13.setOnClickListener(oclBtn);

        to_task_14 = findViewById(R.id.buttonType14);
        to_task_14.setOnClickListener(oclBtn);
      
        to_task_15 = findViewById(R.id.buttonType15);
        to_task_15.setOnClickListener(oclBtn);
    }

    // обработка события нажатия
    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                // вызываем наш Activity конкретного задания
                case R.id.buttonType1:
                    startActivity(new Intent(Activity_Main.this, Activity_task_01.class));
                    break;
                case R.id.buttonType2:
                    startActivity(new Intent(Activity_Main.this, Activity_task_02.class));
                    break;
                case R.id.buttonType3:
                    Intent intent3 = new Intent(Activity_Main.this, Activity_task_03.class);
                    startActivity(intent3);
                    break;
                case R.id.buttonType4:
                    startActivity(new Intent(Activity_Main.this, Activity_task_04.class));
                    break;
                case R.id.buttonType5:
                    startActivity(new Intent(Activity_Main.this, Activity_task_05.class));
                    break;
                case R.id.buttonType6:
                    startActivity(new Intent(Activity_Main.this, Activity_task_06.class));
                    break;
                case R.id.buttonType7:
                    startActivity(new Intent(Activity_Main.this, Activity_task_07.class));
                    break;
                case R.id.buttonType8:
                    startActivity(new Intent(Activity_Main.this, Activity_task_08.class));
                    break;
                case R.id.buttonType9:
                    startActivity(new Intent(Activity_Main.this, Activity_task_09.class));
                    break;
                case R.id.buttonType10:
                    startActivity(new Intent(Activity_Main.this, Activity_task_10.class));
                    break;
                case R.id.buttonType12:
                    startActivity(new Intent(Activity_Main.this, Activity_task_12.class));
                    break;
                case R.id.buttonType13:
                    startActivity(new Intent(Activity_Main.this, Activity_task_13.class));
                    break;
                case R.id.buttonType14:
                    startActivity(new Intent(Activity_Main.this, Activity_task_14.class));
                    break;
                case R.id.buttonType15:
                    startActivity(new Intent(Activity_Main.this, Activity_task_15.class));
                    break;
            }
        }
    };
}
