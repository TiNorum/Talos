package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;

public class PlaceholderFragment_Task_0923 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0923 newInstance(int index) {
        PlaceholderFragment_Task_0923 fragment = new PlaceholderFragment_Task_0923();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    private EditText numberOfSeconds1;
    private EditText numberOfTimes1;
    private EditText numberOfTimes2;
    private EditText numberOfSeconds2;
    private TextView answertext;
    private Button btOtvet;
    private RadioButton higher1;
    private RadioButton below1;
    private RadioButton higher2;
    private RadioButton below2;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0923, container, false);

        numberOfSeconds1 = root.findViewById(R.id.task0923_edittext_second1);
        numberOfTimes1 = root.findViewById(R.id.task0923_edittext_numberOfTimes1);
        numberOfTimes2 = root.findViewById(R.id.task0923_edittext_numberOfTimes2);
        numberOfSeconds2 = root.findViewById(R.id.task0923_edittext_second2);
        answertext = root.findViewById(R.id.task0923_textview_answer);
        btOtvet = root.findViewById(R.id.task0923_btn_answer);
        btOtvet.setOnClickListener(oclBtn);

        higher1 = root.findViewById(R.id.task0923_rbtn_higher1);
        below1 = root.findViewById(R.id.task0923_rbtn_below1);

        higher2 = root.findViewById(R.id.task0923_rbtn_higher2);
        below2 = root.findViewById(R.id.task0923_rbtn_below2);

        return root;
    }


    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            if (checkData()) return;

            String data = getData();

            Toast toast = Toast.makeText(getContext(),
                    data, Toast.LENGTH_SHORT);
            toast.show();
            //отправка на сервер
            //*****************
            //*****************
            ///////////////////


            answertext.setVisibility(View.VISIBLE);
        }

        private String getData() {
            String data = "100" + "\n\r" + "23" + "\n\r";

            data += numberOfSeconds1.getText().toString() + "\n\r";
            data += numberOfTimes1.getText().toString() + "\n\r";

            if (higher1.isChecked()){
                data += "2" + "\n\r";
            } else
                data += "1" + "\n\r";
            data += numberOfTimes2.getText().toString() + "\n\r";

            if (higher2.isChecked()){
                data += "2" + "\n\r";
            } else
                data += "1" + "\n\r";

            data += numberOfSeconds2.getText().toString() + "\n\r";

            return data;
        }

        private boolean checkData() {
            if (numberOfSeconds1.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите время, за которое был передан файл!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }

            if (numberOfTimes1.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите разрешение повторной оцифрации!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }

            if (!(higher1.isChecked() || below1.isChecked())) {
                Toast toast = Toast.makeText(getContext(),
                        "Выберите в какую сторону была произведена оцифрация!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }

            if (numberOfTimes2.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите частоту, повторной дискретизации!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }


            if (!(higher2.isChecked() || below2.isChecked())) {
                Toast toast = Toast.makeText(getContext(),
                        "Выберите в какую сторону была произведена дискретизации!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }
            if (numberOfSeconds2.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите время, за которое был передан файл!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }
            return false;
        }
    };
}



