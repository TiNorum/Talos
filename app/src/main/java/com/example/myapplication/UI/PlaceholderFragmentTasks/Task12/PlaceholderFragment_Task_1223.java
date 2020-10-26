package com.example.myapplication.UI.PlaceholderFragmentTasks.Task12;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.Instruments.ShowToast;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_Task_1223 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_1223 newInstance(int index) {
        // юзает фрагмент
        PlaceholderFragment_Task_1223 fragment = new PlaceholderFragment_Task_1223();
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

    private Button button_answer;
    private TextView text_answer;
    private EditText number;
    private EditText number1;
    private EditText number2;
    private EditText number3;
    private EditText number4;
    private EditText number5;
    private EditText number6;
    private EditText number7;
    private EditText number8;
    private EditText quantity;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_1442, container, false);


        // находим кнопку с которой работает
        button_answer = root.findViewById(R.id.task1442_btn_answer);
        button_answer.setOnClickListener(oclBtn);

        number = root.findViewById(R.id.edittext_number);
        number1 = root.findViewById(R.id.edittext_number1);
        number2 = root.findViewById(R.id.edittext_number2);
        number3 = root.findViewById(R.id.edittext_number3);
        number4 = root.findViewById(R.id.edittext_number4);
        number5 = root.findViewById(R.id.edittext_number5);
        number6 = root.findViewById(R.id.edittext_number6);
        number7 = root.findViewById(R.id.edittext_number7);
        number8 = root.findViewById(R.id.edittext_number8);
        quantity = root.findViewById(R.id.edittext_quantity);

        text_answer = root.findViewById(R.id.task1442_textview_answer);
        return root;
    }

    private View.OnClickListener oclBtn = new View.OnClickListener() {
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

            text_answer.setVisibility(View.VISIBLE);
        }

        private String getData() {
            String data = "100" + Constants.NEXT_LINE + "42" + Constants.NEXT_LINE;
            data += number.getText().toString() + Constants.NEXT_LINE;
            data += quantity.getText().toString() + Constants.NEXT_LINE;
            data += number1.getText().toString() + Constants.NEXT_LINE;
            data += number2.getText().toString() + Constants.NEXT_LINE;
            data += number3.getText().toString() + Constants.NEXT_LINE;
            data += number4.getText().toString() + Constants.NEXT_LINE;
            data += number5.getText().toString() + Constants.NEXT_LINE;
            data += number6.getText().toString() + Constants.NEXT_LINE;
            data += number7.getText().toString() + Constants.NEXT_LINE;
            data += number8.getText().toString();

            return data;
        }

        private boolean checkData() {
            if (number.getText().toString().isEmpty() || Integer.parseInt(number.getText().toString()) == 0) {
                ShowToast.showToast(getContext(), "Введите из каких цифр состоит строка!");
                return true;
            }

            if (quantity.getText().toString().isEmpty() || Integer.parseInt(quantity.getText().toString()) == 0) {
                ShowToast.showToast(getContext(), "Введите количество этих цифр!");
                return true;
            }

            if (number1.getText().toString().isEmpty() || number2.getText().toString().isEmpty() || number3.getText().toString().isEmpty() ||
                    number4.getText().toString().isEmpty() || number5.getText().toString().isEmpty() || number6.getText().toString().isEmpty() ||
                    number7.getText().toString().isEmpty() || number8.getText().toString().isEmpty()) {

                ShowToast.showToast(getContext(), "Заполните все параметры!");

                return true;
            }

            if (Integer.parseInt(number1.getText().toString()) == 0 || Integer.parseInt(number2.getText().toString()) == 0 || Integer.parseInt(number3.getText().toString()) == 0 ||
                    Integer.parseInt(number4.getText().toString()) == 0 || Integer.parseInt(number5.getText().toString()) == 0 || Integer.parseInt(number6.getText().toString()) == 0 ||
                    Integer.parseInt(number7.getText().toString()) == 0 || Integer.parseInt(number8.getText().toString()) == 0) {
                ShowToast.showToast(getContext(), "Параметры не должны равняться 0!");

                return true;
            }

            return false;
        }
    };


}

