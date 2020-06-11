package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Instruments.ShowToast;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_Task_0616 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0616 newInstance(int index) {
        PlaceholderFragment_Task_0616 fragment = new PlaceholderFragment_Task_0616();
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

    private MaterialEditText numbers;
    private MaterialEditText answernum;
    private TextView tAnswer;
    private Button bAnswer;
    private RadioButton multiplication;
    private RadioButton addition;
    private RadioButton max;
    private RadioButton min;
    private RadioButton odd;
    private RadioButton even;
    private RadioButton increase;
    private RadioButton decrease;
    private RadioButton someNums;
    private RadioButton oneNum;


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0616, container, false);

        multiplication = root.findViewById(R.id.task0616_rbtn_multiplication);
        addition = root.findViewById(R.id.task0616_rbtn_addition);
        max = root.findViewById(R.id.task0616_rbtn_max);
        min = root.findViewById(R.id.task0616_rbtn_min);
        odd = root.findViewById(R.id.task0616_rbtn_odd);
        even = root.findViewById(R.id.task0616_rbtn_even);
        increase = root.findViewById(R.id.task0616_rbtn_increase);
        decrease = root.findViewById(R.id.task0616_rbtn_decrease);
        someNums = root.findViewById(R.id.task0616_rbtn_some_num);
        oneNum = root.findViewById(R.id.task0616_rbtn_one_num);

        bAnswer = root.findViewById(R.id.task0616_btn_answer);
        bAnswer.setOnClickListener(oclBtn);

        tAnswer = root.findViewById(R.id.task0616_text_answer);
        numbers = root.findViewById(R.id.task0616_edittext_numbers);

        answernum = root.findViewById(R.id.task0616_edittext_num_answer);


        return root;
    }


    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (checkData()) return;

            String data = getData();

            tAnswer.setVisibility(View.VISIBLE);
            tAnswer.setText(data);
        }

        private boolean checkData() {
            if (numbers.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите цифры!");
                return true;
            }

            if (answernum.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите число!");
                return true;
            }

            if (!addition.isChecked() && !multiplication.isChecked()) {
                ShowToast.showToast(getContext(), "Выберите умножение/сложение!");
                return true;
            }

            if (!max.isChecked() && !min.isChecked()) {
                ShowToast.showToast(getContext(), "Выберите максимальное/минимально число!");
                return true;
            }

            if (!odd.isChecked() && !even.isChecked()) {
                ShowToast.showToast(getContext(), "Выберите чентное/нечетное!");
                return true;
            }

            if (!increase.isChecked() && !decrease.isChecked()) {
                ShowToast.showToast(getContext(), "Выберите убывание/возрастание!");
                return true;
            }

            if (!someNums.isChecked() && !oneNum.isChecked()) {
                ShowToast.showToast(getContext(), "Выберите количесвто чисел!");
                return true;
            }

            return false;
        }

        private String getData() {
            String data = "100" + "\n\r" + "16" + "\n\r";

            if (multiplication.isChecked())
                data += '0' + "\n\r";
            else
                data += '1' + "\n\r";

            data += numbers.getText().toString() + "\n\r";
            data += answernum.getText().toString() + "\n\r";


            if (min.isChecked())
                data += '0' + "\n\r";
            else
                data += '1' + "\n\r";

            if (decrease.isChecked())
                data += '0' + "\n\r";
            else
                data += '1' + "\n\r";

            if (someNums.isChecked())
                data += '0' + "\n\r";
            else
                data += '1' + "\n\r";

            if (even.isChecked())
                data += '0';
            else
                data += '1';

            return data;
        }


    };
}