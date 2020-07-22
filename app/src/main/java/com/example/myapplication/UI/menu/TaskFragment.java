package com.example.myapplication.UI.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Activities.Activity_Main;
import com.example.myapplication.Activities.Tasks.Activity_task_01;
import com.example.myapplication.Activities.Tasks.Activity_task_02;
import com.example.myapplication.Activities.Tasks.Activity_task_03;
import com.example.myapplication.Activities.Tasks.Activity_task_04;
import com.example.myapplication.Activities.Tasks.Activity_task_05;
import com.example.myapplication.Activities.Tasks.Activity_task_06;
import com.example.myapplication.Activities.Tasks.Activity_task_07;
import com.example.myapplication.Activities.Tasks.Activity_task_08;
import com.example.myapplication.Activities.Tasks.Activity_task_09;
import com.example.myapplication.Activities.Tasks.Activity_task_10;
import com.example.myapplication.Activities.Tasks.Activity_task_12;
import com.example.myapplication.Activities.Tasks.Activity_task_13;
import com.example.myapplication.Activities.Tasks.Activity_task_14;
import com.example.myapplication.Activities.Tasks.Activity_task_15;
import com.example.myapplication.R;

public class TaskFragment extends Fragment {

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
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_task, container, false);

        to_task_1 = root.findViewById(R.id.buttonType1);
        to_task_1.setOnClickListener(oclBtn);

        to_task_2 = root.findViewById(R.id.buttonType2);
        to_task_2.setOnClickListener(oclBtn);

        to_task_3 = root.findViewById(R.id.buttonType3);
        to_task_3.setOnClickListener(oclBtn);

        to_task_4 = root.findViewById(R.id.buttonType4);
        to_task_4.setOnClickListener(oclBtn);

        to_task_5 = root.findViewById(R.id.buttonType5);
        to_task_5.setOnClickListener(oclBtn);

        to_task_6 = root.findViewById(R.id.buttonType6);
        to_task_6.setOnClickListener(oclBtn);

        to_task_7 = root.findViewById(R.id.buttonType7);
        to_task_7.setOnClickListener(oclBtn);

        to_task_8 = root.findViewById(R.id.buttonType8);
        to_task_8.setOnClickListener(oclBtn);

        to_task_9 = root.findViewById(R.id.buttonType9);
        to_task_9.setOnClickListener(oclBtn);

        to_task_10 = root.findViewById(R.id.buttonType10);
        to_task_10.setOnClickListener(oclBtn);

        to_task_12 = root.findViewById(R.id.buttonType12);
        to_task_12.setOnClickListener(oclBtn);

        to_task_13 = root.findViewById(R.id.buttonType13);
        to_task_13.setOnClickListener(oclBtn);

        to_task_14 = root.findViewById(R.id.buttonType14);
        to_task_14.setOnClickListener(oclBtn);

        to_task_15 = root.findViewById(R.id.buttonType15);
        to_task_15.setOnClickListener(oclBtn);

        return root;
    }


    // обработка события нажатия
    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                // вызываем наш Activity конкретного задания
                case R.id.buttonType1:
                    startActivity(new Intent(getContext(), Activity_task_01.class));
                    break;
                case R.id.buttonType2:
                    startActivity(new Intent(getContext(), Activity_task_02.class));
                    break;
                case R.id.buttonType3:
                    Intent intent3 = new Intent(getContext(), Activity_task_03.class);
                    startActivity(intent3);
                    break;
                case R.id.buttonType4:
                    startActivity(new Intent(getContext(), Activity_task_04.class));
                    break;
                case R.id.buttonType5:
                    startActivity(new Intent(getContext(), Activity_task_05.class));
                    break;
                case R.id.buttonType6:
                    startActivity(new Intent(getContext(), Activity_task_06.class));
                    break;
                case R.id.buttonType7:
                    startActivity(new Intent(getContext(), Activity_task_07.class));
                    break;
                case R.id.buttonType8:
                    startActivity(new Intent(getContext(), Activity_task_08.class));
                    break;
                case R.id.buttonType9:
                    startActivity(new Intent(getContext(), Activity_task_09.class));
                    break;
                case R.id.buttonType10:
                    startActivity(new Intent(getContext(), Activity_task_10.class));
                    break;
                case R.id.buttonType12:
                    startActivity(new Intent(getContext(), Activity_task_12.class));
                    break;
                case R.id.buttonType13:
                    startActivity(new Intent(getContext(), Activity_task_13.class));
                    break;
                case R.id.buttonType14:
                    startActivity(new Intent(getContext(), Activity_task_14.class));
                    break;
                case R.id.buttonType15:
                    startActivity(new Intent(getContext(), Activity_task_15.class));
                    break;
            }
        }
    };
}
