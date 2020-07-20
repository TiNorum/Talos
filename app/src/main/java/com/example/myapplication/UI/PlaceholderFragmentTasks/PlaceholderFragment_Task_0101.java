package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Activities.Activity_Main;
import com.example.myapplication.ClientLauncher.ClientManager;
import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.Instruments.ShowToast;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;
import com.example.myapplication.UI.auth.SignIn;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;



public class PlaceholderFragment_Task_0101 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0101 newInstance(int index) {
        // юзает фрагмент
        PlaceholderFragment_Task_0101 fragment = new PlaceholderFragment_Task_0101();
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
    private MaterialEditText countZero;
    private MaterialEditText countOne;
    private MaterialEditText cc;
    private CheckBox zero;
    private CheckBox one;
    private RadioButton max;
    private RadioButton min;



    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0101, container, false);

        // находим кнопку с которой работает
        btnAnswer = root.findViewById(R.id.task0101_btn_answer);
        btnAnswer.setOnClickListener(oclBtn);

        countOne = (MaterialEditText) root.findViewById(R.id.task0101_edittext_count_values_one);
        countZero = (MaterialEditText) root.findViewById(R.id.task0101_edittext_count_values_zero);
        cc = (MaterialEditText) root.findViewById(R.id.task0101_edittext_cc);

        zero = root.findViewById(R.id.checkBox_task0101_null);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (zero.isChecked())
                    countZero.setVisibility(View.VISIBLE);
                else
                    countZero.setVisibility(View.GONE);
            }
        });
        one = root.findViewById(R.id.checkBox_task0101_one);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (one.isChecked())
                    countOne.setVisibility(View.VISIBLE);
                else
                    countOne.setVisibility(View.GONE);
            }
        });

        max = root.findViewById(R.id.task0101_rbtn_max_number);
        min = root.findViewById(R.id.task0101_rbtn_min_number);

        tAnswer = root.findViewById(R.id.task0101_textview_answer);
        return root;
    }


    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final String LOG_TAG = "SOCKET";

            if (checkData()) return;


            //отправка на сервер
            //*****************
            //*****************
            try {
                String answer = ClientManager.send_server(getData());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            tAnswer.setVisibility(View.VISIBLE);


        }

        private String getData() {
            String data = "100" + Constants.NEXT_LINE + "1" + Constants.NEXT_LINE;

            if (one.isChecked() && zero.isChecked()) {
                data += "2" + Constants.NEXT_LINE;
            } else if (one.isChecked()) {
                data += "1" + Constants.NEXT_LINE;
            } else {
                data += "0" + Constants.NEXT_LINE;
            }

            if (one.isChecked())
                data += countOne.getText().toString() + Constants.NEXT_LINE;
            else
                data += "0" + Constants.NEXT_LINE;

            if (zero.isChecked())
                data += countZero.getText().toString() + Constants.NEXT_LINE;
            else
                data += "0" + Constants.NEXT_LINE;


            data += cc.getText().toString() + Constants.NEXT_LINE;


            if (min.isChecked())
                data += "0";
            else
                data += "1";

            return data;
        }

        private boolean checkData() {
            if (countZero.getText().toString().isEmpty() && zero.isChecked()) {
                ShowToast.showToast(getContext(), "Введите количество нулей!");
                return true;
            }

            if (countOne.getText().toString().isEmpty() && one.isChecked()) {
                ShowToast.showToast(getContext(), "Введите количество единиц!");
                return true;
            }

            if (countOne.getText().toString().isEmpty() == false && countZero.getText().toString().isEmpty() == false && Integer.parseInt(countOne.getText().toString()) != 0 && Integer.parseInt(countZero.getText().toString()) != 0) {
                ShowToast.showToast(getContext(), "Введите количество единиц и нулей отличное от 0!");
                return true;
            }

            if (cc.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите систему счисления!");
                return true;
            }
            int c = Integer.parseInt(cc.getText().toString());
            if(!(c>1 && c<11 || c==16))
            {
                ShowToast.showToast(getContext(), "Введите систему счисления (2-10 и 16)");
                return true;
            }


            if (!(zero.isChecked() || one.isChecked())) {
                ShowToast.showToast(getContext(), "Выберите что содержит двоичная запись числа!");
                return true;
            }

            if (!(max.isChecked() || min.isChecked())) {
                ShowToast.showToast(getContext(), "Выберите максимальное/минимальное число!");
                return true;
            }

            return false;
        }
    };


}