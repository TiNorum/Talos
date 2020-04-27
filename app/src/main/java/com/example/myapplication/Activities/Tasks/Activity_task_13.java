package com.example.myapplication.Activities.Tasks;

import android.content.Context;
import android.os.Bundle;

import com.example.myapplication.Instruments.ShowTost;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.rengwuxian.materialedittext.MaterialEditText;

public class Activity_task_13 extends AppCompatActivity {


    private static final String[] tab_titles = {"Передача файла", "Звук", "Изображение общий объём", "Изображение преобразование"};
    private MaterialEditText countSymbolInPass;
    private MaterialEditText countSymbol;
    private MaterialEditText countUsers;
    private MaterialEditText countAllByte;
    private MaterialEditText addInf;
    private TextView type_name;


    private Button bAnswer;
    private TextView tAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_task_1341);

        countSymbolInPass = findViewById(R.id.task1341_count_symbol_in_password);
        countSymbol = findViewById(R.id.task1341_count_symbol);
        countUsers = findViewById(R.id.task1341_count_users);
        countAllByte = findViewById(R.id.task1341_count_all_byte);
        addInf = findViewById(R.id.task1341_add_inf);

        tAnswer = findViewById(R.id.task1341_text_answer);
        bAnswer = findViewById(R.id.task1341_btn_answer);
        bAnswer.setOnClickListener(oclBtn);

        // заменяем имя в app:bar
        //type_name = findViewById(R.id.textview_task_all);
        //type_name.setText("  Задание №13");

    }

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (checkData(v.getContext())) return;

            String data = getData();

            tAnswer.setVisibility(View.VISIBLE);
            tAnswer.setText(data);
        }

        private boolean checkData(Context context) {
            if (countSymbol.getText().toString().isEmpty()) {
                ShowTost.showTost(getApplicationContext(), "Введите количество символов в пароле.");
                return true;
            }

            if (countSymbolInPass.getText().toString().isEmpty()) {;
                ShowTost.showTost(getApplicationContext(), "Введите количество используемых символов.");

                return true;
            }

            if (countUsers.getText().toString().isEmpty()) {
                ShowTost.showTost(getApplicationContext(), "Введите количество пользователей.");

                return true;
            }

            if (countAllByte.getText().toString().isEmpty()) {
                ShowTost.showTost(getApplicationContext(), "Введите количество байтов, которые потребовались для ВСЕХ пользователей. Если значение неизвестно, то напишите X.");
                return true;
            }

            if (addInf.getText().toString().isEmpty()) {
                ShowTost.showTost(getApplicationContext(), "Введите количетсво дополнительных сведений для одного пользователя. Если значение неизвестно, то напишите X.");
                return true;
            }
            return false;
        }


        private String getData() {
            String data = "100" + "\n\r" + "41" + "\n\r";


            data += countSymbol.getText().toString() + "\n\r";
            data += countSymbolInPass.getText().toString() + "\n\r";
            data += countUsers.getText().toString() + "\n\r";

            if (addInf.getText().toString().isEmpty())
                data += 'x' + "\n\r";
            else
                data += addInf.getText().toString() + "\n\r";

            if (countAllByte.getText().toString().isEmpty())
                data += 'x' + "\n\r";
            else
                data += countAllByte.getText().toString();


            return data;
        }
    };
}