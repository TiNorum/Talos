package com.example.myapplication.UI.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.rengwuxian.materialedittext.MaterialEditText;

public class CalculatorFragment extends Fragment {


    Spinner action;
    MaterialEditText first_num_et;
    MaterialEditText second_num_et;
    TextView first_num_tv;
    TextView second_num_tv;
    Spinner first_num_spinner;
    Spinner second_num_spinner;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_calculator, container, false);


        action = root.findViewById(R.id.spinner_action);
        action.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        switch (i)
                        {
                            case 0:
                                first_num_et.setVisibility(View.VISIBLE);
                                first_num_et.setHint("Первое слагаемое");
                                second_num_et.setVisibility(View.VISIBLE);
                                second_num_et.setHint("Второе слагаемое");

                                first_num_tv.setVisibility(View.VISIBLE);
                                first_num_tv.setText("Система счисления первого числа:");
                                second_num_tv.setVisibility(View.VISIBLE);
                                second_num_tv.setText("Система счисления второго числа:");

                                return;
                            case 1:
                                first_num_et.setVisibility(View.VISIBLE);
                                first_num_et.setHint("Уменьшаемое");
                                second_num_et.setVisibility(View.VISIBLE);
                                second_num_et.setHint("Вычитаемое");

                                first_num_tv.setVisibility(View.VISIBLE);
                                first_num_tv.setText("Система счисления первого числа:");
                                second_num_tv.setVisibility(View.VISIBLE);
                                second_num_tv.setText("Система счисления второго числа:");
                                return;
                            case 2:
                                first_num_et.setVisibility(View.VISIBLE);
                                first_num_et.setHint("Введите число");
                                second_num_et.setVisibility(View.GONE);


                                first_num_tv.setVisibility(View.VISIBLE);
                                first_num_tv.setText("Система счисления исходного числа");
                                second_num_tv.setVisibility(View.VISIBLE);
                                second_num_tv.setText("Перевести число в");
                                return;
                        }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        first_num_et= root.findViewById(R.id.edittext_first_num);
        second_num_et= root.findViewById(R.id.edittext_second_num);

        first_num_tv= root.findViewById(R.id.textview_first_num);
        second_num_tv = root.findViewById(R.id.textview_second_num);

        first_num_spinner = root.findViewById(R.id.spinner_cc_in);
        first_num_spinner = root.findViewById(R.id.spinner_cc_out);

        return root;
    }
}
