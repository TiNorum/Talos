package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
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

import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * A placeholder fragment containing a simple view.
 */
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
    private MaterialEditText countZeroOrNum;
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

        countZeroOrNum = (MaterialEditText) root.findViewById(R.id.task0101_edittext_count_values_one_or_zero);
        cc = (MaterialEditText) root.findViewById(R.id.task0101_edittext_cc);

        zero = root.findViewById(R.id.checkBox_task0101_null);
        one = root.findViewById(R.id.checkBox_task0101_one);

        max = root.findViewById(R.id.task0101_rbtn_max_number);
        min = root.findViewById(R.id.task0101_rbtn_min_number);

        tAnswer = root.findViewById(R.id.task0101_textview_answer);
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
            String data = "100" + "\n\r" + "1" + "\n\r";

            if (one.isChecked() && zero.isChecked()) {
                data += "2" + "\n\r";
            } else if (one.isChecked()) {
                data += "1" + "\n\r";
            } else {
                data += "0" + "\n\r";
            }


            data += countZeroOrNum.getText().toString() + "\n\r";

            data += cc.getText().toString() + "\n\r";


            if (min.isChecked())
                data += "0";
            else
                data += "1";


            return data;
        }

        private boolean checkData() {
            if (countZeroOrNum.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите количество нулей/единиц!", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            }

            if (cc.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите систему счисления!", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            }

            if (!(zero.isChecked() || one.isChecked())) {
                Toast toast = Toast.makeText(getContext(),
                        "Выберите что содержит двоичная запись числа!", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            }

            if (!(max.isChecked() || min.isChecked())) {
                Toast toast = Toast.makeText(getContext(),
                        "Выберите максимальное/минимальное число!", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            }

            return false;
        }
    };


}