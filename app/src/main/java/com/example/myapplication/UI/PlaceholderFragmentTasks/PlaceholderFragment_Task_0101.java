package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.ClientLauncher.ClientManager;
import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.Instruments.ShowToast;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;
import com.rengwuxian.materialedittext.MaterialEditText;

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
    private TextView textView_solution;
    private MaterialEditText countZero;
    private MaterialEditText countOne;
    private MaterialEditText cc;
    private CheckBox zero;
    private CheckBox one;
    private RadioButton max;
    private RadioButton min;
    private LinearLayout solution_linear;


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0101, container, false);

        solution_linear = root.findViewById(R.id.linearlayout_solution);
        // находим кнопку с которой работает
        btnAnswer = root.findViewById(R.id.task0101_btn_answer);
        btnAnswer.setOnClickListener(oclBtn);

        countOne =  root.findViewById(R.id.task0101_edittext_count_values_one);
        countZero =  root.findViewById(R.id.task0101_edittext_count_values_zero);
        cc = root.findViewById(R.id.task0101_edittext_cc);

        zero = root.findViewById(R.id.checkBox_task0101_null);
        zero.setOnClickListener(v -> {
            if (zero.isChecked())
                countZero.setVisibility(View.VISIBLE);
            else
                countZero.setVisibility(View.GONE);
        });
        one = root.findViewById(R.id.checkBox_task0101_one);
        one.setOnClickListener(v -> {
            if (one.isChecked())
                countOne.setVisibility(View.VISIBLE);
            else
                countOne.setVisibility(View.GONE);
        });

        max = root.findViewById(R.id.task0101_rbtn_max_number);
        min = root.findViewById(R.id.task0101_rbtn_min_number);

        textView_solution = root.findViewById(R.id.textview_answer);
        return root;
    }


    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            if (checkData()) return;

            try {
                String answer = ClientManager.send_server(getData());
                textView_solution.setText(answer);
                solution_linear.setVisibility(View.VISIBLE);

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        private String getData() {
            String data = "103" + Constants.NEXT_LINE + "1" + Constants.NEXT_LINE;

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
            }else if( zero.isChecked() && Integer.parseInt(countZero.getText().toString()) == 0 ){
                ShowToast.showToast(getContext(), "Введите количество нулей отличное от 0!");

            }

            if (countOne.getText().toString().isEmpty() && one.isChecked()) {
                ShowToast.showToast(getContext(), "Введите количество единиц!");
                return true;
            }else if(one.isChecked() && Integer.parseInt(countOne.getText().toString()) == 0 ){
                ShowToast.showToast(getContext(), "Введите количество единиц отличное от 0!");

            }




            if (cc.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите систему счисления!");
                return true;
            }
            int c = Integer.parseInt(cc.getText().toString());
            if(!(c>2 && c<11 || c==16))
            {
                ShowToast.showToast(getContext(), "Введите систему счисления (3-10 и 16)");
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