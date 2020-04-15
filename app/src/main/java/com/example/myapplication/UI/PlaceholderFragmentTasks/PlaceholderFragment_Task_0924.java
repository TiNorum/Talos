package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;
import com.rengwuxian.materialedittext.MaterialEditText;

public class PlaceholderFragment_Task_0924 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0924 newInstance(int index) {
        PlaceholderFragment_Task_0924 fragment = new PlaceholderFragment_Task_0924();
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

    private Button btnAnswer;
    private TextView tAnswer;
    private MaterialEditText fileSyzeEdit;
    private MaterialEditText numericOfMinuts;
    private MaterialEditText numericMultiple;
    private RadioButton recordingTime;
    private RadioButton fileSyze;
    private RadioButton integer;
    private RadioButton multiple;
    private EditText frequency;
    private EditText permission;
    private EditText numberOfChannels;
    private RadioGroup groop1;
    private RadioGroup groop2;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0924, container, false);
        // находим кнопку с которой работает
        btnAnswer = root.findViewById(R.id.task0924_btn_answer);
        btnAnswer.setOnClickListener(oclBtn);

        numberOfChannels = root.findViewById(R.id.task0924_edittext_numberOfChannels);

        frequency = root.findViewById(R.id.task0924_edittext_frequency);
        permission = root.findViewById(R.id.task0924_edittext_permission);

        numericOfMinuts = (MaterialEditText) root.findViewById(R.id.task0924_edittext_numericOfMinuts);
        fileSyzeEdit = (MaterialEditText) root.findViewById(R.id.task0924_edittext_fileSyze);


        groop1 = root.findViewById(R.id.task0924_rg_choice_recordingTime_fileSyze);
        groop1.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.task0924_rbtn_recordingTime) {
                numericOfMinuts.setVisibility(View.VISIBLE);
            } else {
                numericOfMinuts.setVisibility(View.GONE);
            }
            if (checkedId == R.id.task0924_rbtn_fileSyze) {
                fileSyzeEdit.setVisibility(View.VISIBLE);
            } else {
                fileSyzeEdit.setVisibility(View.GONE);
            }
        });
        recordingTime = root.findViewById(R.id.task0924_rbtn_recordingTime);
        fileSyze = root.findViewById(R.id.task0924_rbtn_fileSyze);

        numericMultiple = (MaterialEditText) root.findViewById(R.id.task0924_edittext_numericMultiple);
         fileSyzeEdit.setVisibility(View.GONE);
            }
        });

        numericMultiple = (MaterialEditText) root.findViewById(R.id.task0924_edittext_numericMultiple);

        integer = root.findViewById(R.id.task0924_rbtn_integer);
        multiple = root.findViewById(R.id.task0924_rbtn_multiple);

        groop2 = root.findViewById(R.id.task0924_rg_choice_integer_multiple);
        groop2.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.task0924_rbtn_multiple) {
                numericMultiple.setVisibility(View.VISIBLE);
            } else {

                numericMultiple.setVisibility(View.GONE);
            }
        });
        integer = root.findViewById(R.id.task0924_rbtn_integer);
        multiple = root.findViewById(R.id.task0924_rbtn_multiple);
        tAnswer = root.findViewById(R.id.task0924_textview_answer);
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


            //answertext.setVisibility(View.VISIBLE);
        }

        private String getData() {
            String data = "100"  + Constants.NEXT_LINE + "24"  + Constants.NEXT_LINE;


            data += numberOfChannels.getText().toString() + Constants.NEXT_LINE;
            data += frequency.getText().toString() + Constants.NEXT_LINE;
            data += permission.getText().toString() + Constants.NEXT_LINE;

            if (fileSyze.isChecked()) {
                data += "1" + Constants.NEXT_LINE;
                data += fileSyzeEdit.getText().toString() + Constants.NEXT_LINE;
            }
            else {
                data += "0" + Constants.NEXT_LINE;
                data += numericOfMinuts.getText().toString() + Constants.NEXT_LINE;
            }
            if (multiple.isChecked())
                data += numericMultiple.getText().toString() + Constants.NEXT_LINE;
            else
                data += "0" + Constants.NEXT_LINE;

            return data;
        }


        private boolean checkData() {

            if (numberOfChannels.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите количество каналов!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }
            int c = Integer.parseInt(numberOfChannels.getText().toString());
            if (!(c ==1 ||c ==2 || c ==4 || c ==8)) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите количество каналов (1, 2, 4, 8)!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }
            if (frequency.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите частоту дискретизации!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }
            if (permission.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите разрешение звукозаписи!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }
            if (!fileSyze.isChecked() && !recordingTime.isChecked()) {
                Toast toast = Toast.makeText(getContext(),
                        "Выберите известный параметор!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                
                return true;
            }
            if (fileSyzeEdit.getText().toString().isEmpty() && fileSyze.isChecked()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите размер файла (Мбайт)!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }

            if (numericOfMinuts.getText().toString().isEmpty() && recordingTime.isChecked()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите количество минут!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }
            if (!(integer.isChecked() || multiple.isChecked())) {
                Toast toast = Toast.makeText(getContext(),
                        "Выберите чему будет кратен ответ!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }
            if (numericMultiple.getText().toString().isEmpty() && multiple.isChecked()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите число!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }
            return false;
        }
    };
}



