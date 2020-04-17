package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
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

import com.example.myapplication.Instruments.Check_Input;
import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_Task_1442 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_1442 newInstance(int index) {
        // юзает фрагмент
        PlaceholderFragment_Task_1442 fragment = new PlaceholderFragment_Task_1442();
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
    private EditText number;
    private EditText quantity;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_1442, container, false);

        // находим кнопку с которой работает
        btnAnswer = root.findViewById(R.id.task1442_btn_answer);
        btnAnswer.setOnClickListener(oclBtn);

        number = root.findViewById(R.id.task1442_edittext_number);
        quantity = root.findViewById(R.id.task1442_edittext_quantity);


        tAnswer = root.findViewById(R.id.task1442_textview_answer);
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

            tAnswer.setVisibility(View.VISIBLE);
        }

        private String getData() {
            String data = "100" + Constants.NEXT_LINE + "42" + Constants.NEXT_LINE;
            data += number.getText().toString() + Constants.NEXT_LINE;
            data += quantity.getText().toString() + Constants.NEXT_LINE;

            return data;
        }

        private boolean checkData() {
            if (number.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите из каких цифр состоит строка!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }
            if (quantity.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите количество этих цифр!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }

            return false;
        }
    };


}

