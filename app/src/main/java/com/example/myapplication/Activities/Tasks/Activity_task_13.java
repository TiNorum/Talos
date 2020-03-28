package com.example.myapplication.Activities.Tasks;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.rengwuxian.materialedittext.MaterialEditText;

public class Activity_task_13 extends AppCompatActivity {

    private MaterialEditText countSymbolInPass;
    private MaterialEditText countSymbol;
    private MaterialEditText countUsers;
    private MaterialEditText countAllByte;
    private MaterialEditText addInf;


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
                Toast toast = Toast.makeText(context,
                        "Введите колиество символов в пароле!", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            }

            if (countSymbolInPass.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(context,
                        "Введите колиество используемых символов!", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            }

            if (countUsers.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(context,
                        "Введите колиество пользователей!", Toast.LENGTH_SHORT);
                toast.show();
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