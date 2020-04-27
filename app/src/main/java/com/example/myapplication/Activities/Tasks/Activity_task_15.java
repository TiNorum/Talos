package com.example.myapplication.Activities.Tasks;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Instruments.ShowTost;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.CanvasView;
import com.rengwuxian.materialedittext.MaterialEditText;

public class Activity_task_15 extends AppCompatActivity {


    CanvasView canvasView;


    private Button bAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_task_1544);


        canvasView = findViewById(R.id.task1544_graph);

        bAnswer = findViewById(R.id.task1544_btn_answer);
        bAnswer.setOnClickListener(oclBtn);

        // заменяем имя в app:bar
        //type_name = findViewById(R.id.textview_task_all);
        //type_name.setText("  Задание №13");

    }

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            if (canvasView.isEmpty()) {
                ShowTost.showTost(getApplicationContext(), "Нарисуйте граф!");

                return;
            }


            String data = getData();


            Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
            return;
        }


        private String getData() {
            String data = "100" + "\n\r" + "44" + "\n\r";

            data += canvasView.toString();

            return data;
        }
    };
}