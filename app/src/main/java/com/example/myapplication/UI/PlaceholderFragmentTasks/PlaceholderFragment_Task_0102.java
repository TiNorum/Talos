package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
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

import com.example.myapplication.Instruments.ShowTost;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_Task_0102 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0102 newInstance(int index) {
        PlaceholderFragment_Task_0102 fragment = new PlaceholderFragment_Task_0102();
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


    Button btnAnswer;
    TextView tAnswer;
    MaterialEditText number;
    MaterialEditText cc;
    RadioButton zero;
    RadioButton one;


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0102, container, false);

        zero = root.findViewById(R.id.task0102_rbtn_zero);
        one = root.findViewById(R.id.task0102_rbtn_one);
        cc = (MaterialEditText) root.findViewById(R.id.task0102_edittext_cc);
        number = (MaterialEditText) root.findViewById(R.id.task0102_edittext_number);

        btnAnswer = root.findViewById(R.id.task0102_btn_answer);
        btnAnswer.setOnClickListener(oclBtn);


        tAnswer = root.findViewById(R.id.task0102_txt_answer);


        return root;
    }

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if( checkData()) return;

            String data = getData();
            Toast toast = Toast.makeText(getContext(),
                    data, Toast.LENGTH_SHORT);
            toast.show();

            tAnswer.setVisibility(View.VISIBLE);
            tAnswer.setText(data);

        }

        private String getData() {
            String data = "100" + "\n\r" + "2" + "\n\r";

            data += number.getText().toString() + "\n\r";

            data += cc.getText().toString() + "\n\r";

            if (zero.isChecked())
                data += '0';
            else
                data += '1' ;


            return data;
        }

        private boolean checkData() {
            if (number.getText().toString().isEmpty()) {
                ShowTost.showTost(getContext(), "Введите число!");
                return true;
            }

            if (cc.getText().toString().isEmpty()) {
                ShowTost.showTost(getContext(), "Введите систему счисления!");
                return true;
            }

            int c = Integer.parseInt(cc.getText().toString());

            if(!(c>1 && c<=16))
            {
                ShowTost.showTost(getContext(), "Введите систему счисления (2-10 и 16)");
                return true;
            }

            if (!(zero.isChecked() || one.isChecked())) {
                ShowTost.showTost(getContext(), "Выберите что нужно найти единицы/нули!");
                return true;
            }


            return false;
        }
    };
}