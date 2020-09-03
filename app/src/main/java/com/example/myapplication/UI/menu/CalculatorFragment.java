package com.example.myapplication.UI.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import java.math.BigInteger;

public class CalculatorFragment extends Fragment {


    Spinner first_num_spinner;
    Spinner second_num_spinner;
    Spinner answer_spinner;
    TextView first_num_tv;
    TextView second_num_tv;
    TextView answer_tv;
    Button action;
    LinearLayout linearLayout;
    private TextView id_selection_tv;
    private Spinner id_selection_spinner;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_calculator, container, false);

        linearLayout = root.findViewById(R.id.linlayout_calc_second_num);

        root.findViewById(R.id.button_calc_0).setOnClickListener(oclBtn);
        root.findViewById(R.id.button_calc_1).setOnClickListener(oclBtn);
        root.findViewById(R.id.button_calc_2).setOnClickListener(oclBtn);
        root.findViewById(R.id.button_calc_3).setOnClickListener(oclBtn);
        root.findViewById(R.id.button_calc_4).setOnClickListener(oclBtn);
        root.findViewById(R.id.button_calc_5).setOnClickListener(oclBtn);
        root.findViewById(R.id.button_calc_7).setOnClickListener(oclBtn);
        root.findViewById(R.id.button_calc_6).setOnClickListener(oclBtn);
        root.findViewById(R.id.button_calc_8).setOnClickListener(oclBtn);
        root.findViewById(R.id.button_calc_9).setOnClickListener(oclBtn);
        root.findViewById(R.id.button_calc_A).setOnClickListener(oclBtn);
        root.findViewById(R.id.button_calc_B).setOnClickListener(oclBtn);
        root.findViewById(R.id.button_calc_C).setOnClickListener(oclBtn);
        root.findViewById(R.id.button_calc_D).setOnClickListener(oclBtn);
        root.findViewById(R.id.button_calc_E).setOnClickListener(oclBtn);
        root.findViewById(R.id.button_calc_F).setOnClickListener(oclBtn);
        root.findViewById(R.id.button_calc_c).setOnClickListener(button_listener);

        root.findViewById(R.id.button_calc_plus).setOnClickListener(button_listener);
        root.findViewById(R.id.button_calc_minus).setOnClickListener(button_listener);
        root.findViewById(R.id.button_calc_equally).setOnClickListener(button_listener);


        first_num_tv = root.findViewById(R.id.textview_first_num);
        first_num_tv.setOnClickListener(textview_listener);

        first_num_spinner = root.findViewById(R.id.spinner_calc_first_num);
        second_num_spinner = root.findViewById(R.id.spinner_calc_second_num);
        answer_spinner = root.findViewById(R.id.spinner_calc_answer);

        first_num_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                first_num_tv.setText("0");
                calculation();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        second_num_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                second_num_tv.setText("0");
                calculation();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        answer_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calculation();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        second_num_tv = root.findViewById(R.id.textview_second_num);
        second_num_tv.setOnClickListener(textview_listener);
        answer_tv = root.findViewById(R.id.textview_calc_answer);

        id_selection_spinner = first_num_spinner;
        id_selection_tv = first_num_tv;
        action = root.findViewById(R.id.button_calc_equally);
        return root;
    }

    private String converter(String first_num, int cc_first, int cc_answer) {
        StringBuilder stringBuilder = new StringBuilder(first_num);

        while (true) {
            if ( stringBuilder.length() > 0 && stringBuilder.charAt(0) == '0')
                stringBuilder.deleteCharAt(0);
            else
                break;
        }

        if (stringBuilder.length() == 0)
            stringBuilder.append('0');

        BigInteger num = new BigInteger(stringBuilder.toString(), cc_first);

        return num.toString(cc_answer);
    }

    private void calculation() {
        switch (action.getId()) {
            case R.id.button_calc_plus:
                answer_tv.setText(converter(Integer.parseInt(converter(first_num_tv.getText().toString(), first_num_spinner.getSelectedItemPosition() + 2, 10))
                        + Integer.parseInt(converter(second_num_tv.getText().toString(), second_num_spinner.getSelectedItemPosition() + 2, 10)) + "", 10, answer_spinner.getSelectedItemPosition() + 2));
                break;
            case R.id.button_calc_minus:
                answer_tv.setText(converter(Integer.parseInt(converter(first_num_tv.getText().toString(), first_num_spinner.getSelectedItemPosition() + 2, 10))
                        - Integer.parseInt(converter(second_num_tv.getText().toString(), second_num_spinner.getSelectedItemPosition() + 2, 10)) + "", 10, answer_spinner.getSelectedItemPosition() + 2));
                break;
            case R.id.button_calc_equally:
                answer_tv.setText(converter(first_num_tv.getText().toString(), first_num_spinner.getSelectedItemPosition() + 2, answer_spinner.getSelectedItemPosition() + 2));
                break;
        }
    }


    private View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (id_selection_spinner.getSelectedItemPosition() + 2 < Integer.parseInt(converter(((Button) v).getText().toString(), 16, 10)))
                return;


            id_selection_tv.setText(converter(id_selection_tv.getText().toString() + ((Button) v).getText(), id_selection_spinner.getSelectedItemPosition() + 2, id_selection_spinner.getSelectedItemPosition() + 2));

            calculation();

        }
    };


    private View.OnClickListener button_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.button_calc_minus:
                    linearLayout.setVisibility(View.VISIBLE);
                    break;
                case R.id.button_calc_plus:
                    linearLayout.setVisibility(View.VISIBLE);

                    break;
                case R.id.button_calc_equally:
                    linearLayout.setVisibility(View.GONE);
                    second_num_tv.setText("");
                    break;
                case R.id.button_calc_c:
                    StringBuilder stringBuilder = new StringBuilder(id_selection_tv.getText());
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                    id_selection_tv.setText(stringBuilder);

                    if (id_selection_tv.getText().toString().isEmpty())
                        id_selection_tv.setText("0");

                    calculation();
                    return;
            }

            action = (Button) v;
            calculation();

        }
    };

    private View.OnClickListener textview_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            id_selection_tv = (TextView) v;
            calculation();

        }
    };
}
