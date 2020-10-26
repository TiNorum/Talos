package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.CanvasView;

import androidx.appcompat.app.AppCompatActivity;

public class GraphView extends AppCompatActivity {

    private CanvasView canvasView;

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // вывставляю layout для отображения
        setContentView(R.layout.task_0307_graph);

        Button btnClose = findViewById(R.id.task0307_btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Button btnSave = findViewById(R.id.task0307_btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = "";
                answer += canvasView.toString();

                Intent data = new Intent();
                data.putExtra("GRAPH", answer);

                setResult(2, data);
                finish();
            }
        });
        canvasView = findViewById(R.id.task0307_canvasview);


    }


}