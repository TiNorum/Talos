package com.example.myapplication.UI.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.ClientLauncher.ClientManager;
import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.Instruments.ShowToast;
import com.example.myapplication.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.math.BigInteger;
import java.net.UnknownHostException;

public class CalculatorFragment extends Fragment {


    Spinner action;
    MaterialEditText first_num_et;
    MaterialEditText second_num_et;
    TextView first_num_tv;
    TextView second_num_tv;
    Spinner first_num_spinner;
    Spinner second_num_spinner;
    Button button_answer;
    private int id_action;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_calculator, container, false);

        button_answer = root.findViewById(R.id.btn_answer);
        button_answer.setOnClickListener(oclBtn);

        action = root.findViewById(R.id.spinner_action);
        action.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                id_action = i;
                switch (i) {
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

        first_num_et = root.findViewById(R.id.edittext_first_num);
        second_num_et = root.findViewById(R.id.edittext_second_num);

        first_num_tv = root.findViewById(R.id.textview_first_num);
        second_num_tv = root.findViewById(R.id.textview_second_num);

        first_num_spinner = root.findViewById(R.id.spinner_cc_in);
        second_num_spinner = root.findViewById(R.id.spinner_cc_out);

        return root;
    }

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (first_num_et.getText().toString().isEmpty() || (second_num_et.getText().toString().isEmpty() && id_action != 2))
                return;


            int first_max = 0,second_max =0, temp;

            for (int i = 0; i < first_num_et.getText().toString().length(); i++) {
                temp = Integer.parseInt("" + first_num_et.getText().toString().charAt(i));

                if (temp > first_max)
                    first_max = temp;
            }

            if (first_num_spinner.getSelectedItemPosition() + 2 <= first_max) {
                ShowToast.showToast(getContext(), "Неправильная исходная система счисления!");
                return;
            }

            BigInteger num = new BigInteger(first_num_et.getText().toString(), first_num_spinner.getSelectedItemPosition() + 2);
            BigInteger num_second = null;

            if (!second_num_et.getText().toString().isEmpty()) {
                 num_second = new BigInteger(second_num_et.getText().toString(), second_num_spinner.getSelectedItemPosition() + 2);
                for (int i = 0; i < first_num_et.getText().toString().length(); i++) {
                    temp = Integer.parseInt("" + first_num_et.getText().toString().charAt(i));

                    if (temp > second_max)
                        second_max = temp;
                }

                if (first_num_spinner.getSelectedItemPosition() + 2 <= second_max) {
                    ShowToast.showToast(getContext(), "Неправильная исходная система счисления!");
                    return;
                }
            }


            switch (id_action) {
                case 0:
                    ShowToast.showToast(getContext(), "" + (Integer.parseInt(num.toString(10)) + Integer.parseInt(num_second.toString(10))));
                    break;
                case 1:
                    ShowToast.showToast(getContext(), "" + (Integer.parseInt(num.toString(10)) + Integer.parseInt(num_second.toString(10))));
                    break;
                case 2:

                    ShowToast.showToast(getContext(), num.toString(second_num_spinner.getSelectedItemPosition() + 2));
                    break;
            }

        }
    };
}
