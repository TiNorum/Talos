package com.example.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Activities.Tasks.Activity_task_01;
import com.example.myapplication.Activities.Tasks.Activity_task_02;
import com.example.myapplication.Activities.Tasks.Activity_task_12;
import com.example.myapplication.R;
import com.example.myapplication.Activities.Tasks.Activity_task_05;
import com.example.myapplication.Activities.Tasks.Activity_task_06;


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
        to_task_5 = findViewById(R.id.buttonType5);
        to_task_5.setOnClickListener(oclBtn);
        to_task_6 = findViewById(R.id.buttonType6);
        to_task_6.setOnClickListener(oclBtn);
        to_task_12 = findViewById(R.id.buttonType12);
        to_task_12.setOnClickListener(oclBtn);

    }
    // обработка события нажатия
    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                // вызываем наш Activity конкретного задания
                case R.id.buttonType1:
                    Intent intent1 = new Intent(Activity_Main.this, Activity_task_01.class);
                    startActivity(intent1);
                    break;
                case R.id.buttonType2:
                    Intent intent2 = new Intent(Activity_Main.this, Activity_task_02.class);
                    startActivity(intent2);
                    break;
                case R.id.buttonType3:
                    Intent intent3 = new Intent(Activity_Main.this, Activity_task_02.class);
                    startActivity(intent3);
                    break;
                case R.id.buttonType4:
                    Intent intent4 = new Intent(Activity_Main.this, Activity_task_02.class);
                    startActivity(intent4);
                    break;
                case R.id.buttonType5:
                    Intent intent5 = new Intent(Activity_Main.this, Activity_task_05.class);
                    startActivity(intent5);
                    break;
                case R.id.buttonType6:
                    Intent intent6 = new Intent(Activity_Main.this, Activity_task_06.class);
                    startActivity(intent6);
                    break;
                case R.id.buttonType12:
                    Intent intent12 = new Intent(Activity_Main.this, Activity_task_12.class);
                    startActivity(intent12);
                    break;
            }

        }
    };
}
