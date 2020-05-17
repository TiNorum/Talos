package com.example.myapplication.Activities.Tasks;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Instruments.ShowToast;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.CanvasView;
import com.rengwuxian.materialedittext.MaterialEditText;

public class Activity_task_15 extends AppCompatActivity {


    CanvasView canvasView;
    AlertDialog.Builder ad;
    MaterialEditText start_point;
    MaterialEditText end_point;
    MaterialEditText skip_point;

    private Button bAnswer;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_task_1544);

        ad = new AlertDialog.Builder(this);

        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.alert_dialog_task44, null);
        ad.setView(view);

        end_point = view.findViewById(R.id.task44_edittext_end);
        start_point = view.findViewById(R.id.task44_edittext_start);
        skip_point = view.findViewById(R.id.task44_edittext_skip);

         dialog = ad.create();
        canvasView = findViewById(R.id.task1544_graph);

        bAnswer = findViewById(R.id.task1544_btn_answer);
        bAnswer.setOnClickListener(oclBtn);

        findViewById(R.id.task1544_btn_choose).setOnClickListener(onClickListener_Dialog);
        view.findViewById(R.id.task44_btn_close).setOnClickListener(onClickListener_Dialog);

    }


    View.OnClickListener onClickListener_Dialog = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.task44_btn_close:
                    dialog.dismiss();
                    return;
                case R.id.task1544_btn_choose:
                    dialog.show();
                    return;

                }
            }
        };


    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            if (canvasView.isEmpty()) {
                ShowToast.showToast(getApplicationContext(), "Нарисуйте граф!");
                return;
            }

            String data = getData();
            ShowToast.showToast(getApplicationContext(), data);

        }


        private String getData() {
            String data = "100" + "\n\r" + "44" + "\n\r";

            data += canvasView.toString();

            return data;
        }
    };
}