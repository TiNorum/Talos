package com.example.myapplication.UI.menu;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.Instruments.ShowToast;
import com.example.myapplication.R;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.text.AttributedString;
import java.util.List;

public class CalculatorFragment extends Fragment {


    private int first_num_cc,
            second_num_cc,
            answer_num_cc;

    private StringBuilder first_num,
            second_num,
            answer_num;

    private TextView first_num_tv,
            second_num_tv,
            answer_tv,
            solution;


    private Button action;
    private LinearLayout linearLayout, linearLayout_calc, linearLayout_btn;
    private TextView id_selection_tv;
    private Spinner id_selection_spinner;
    String[] lower_index = {"₀", "₁", "₂", "₃", "₄", "₅", "₆", "₇", "₈", "₉", "₁₀", "₁₁", "₁₂", "₁₃", "₁₄", "₁₅", "₁₆"};
    String[] upper_index = {"⁰", "¹", "²", "³", "⁴", "⁵", "⁶", "⁷", "⁸", "⁹", "¹⁰", "¹¹", "¹²", "¹³", "¹⁴", "¹⁵", "¹⁶"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_calculator, container, false);

        linearLayout = root.findViewById(R.id.linlayout_calc_second_num);
        linearLayout_calc = root.findViewById(R.id.linearLayout_calc);
        linearLayout_btn = root.findViewById(R.id.solution_linearLayout);

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

        root.findViewById(R.id.calc_button).setOnClickListener(layout_listener);
        root.findViewById(R.id.detailed_solution_button).setOnClickListener(layout_listener);


        solution = root.findViewById(R.id.solution);
        first_num_tv = root.findViewById(R.id.textview_first_num);
        first_num_tv.setOnClickListener(textview_listener);


        Spinner first_num_spinner = root.findViewById(R.id.spinner_calc_first_num);
        Spinner second_num_spinner = root.findViewById(R.id.spinner_calc_second_num);
        Spinner answer_spinner = root.findViewById(R.id.spinner_calc_answer);



        first_num = new StringBuilder("0");
        second_num = new StringBuilder("0");
        second_num_cc = 2;
        try {
            Field popup = Spinner.class.getDeclaredField("mPopup");
            popup.setAccessible(true);

            // Get private mPopup member variable and try cast to ListPopupWindow
            android.widget.ListPopupWindow popupWindow = (android.widget.ListPopupWindow) popup.get(first_num_spinner);

            // Set popupWindow height to 500px
            popupWindow.setHeight(500);
        }
        catch (NoClassDefFoundError | ClassCastException | NoSuchFieldException | IllegalAccessException e) {
            // silently fail...
        }
        first_num_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                first_num_tv.setText("0");
                first_num_cc = position + 2;
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
                second_num_cc = position + 2;
                calculation();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        answer_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                answer_num_cc = position + 2;
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


    private void calculation() {

        BigInteger first = new BigInteger(first_num.toString(), first_num_cc);
        BigInteger second = new BigInteger(second_num.toString(), second_num_cc);

        switch (action.getId()) {
            case R.id.button_calc_plus:
                answer_num = new StringBuilder(first.add(second).toString(answer_num_cc));
                break;
            case R.id.button_calc_minus:
                answer_num = new StringBuilder(first.add(second.negate()).toString(answer_num_cc));
                break;
            case R.id.button_calc_equally:
                answer_num = new StringBuilder(first.toString(answer_num_cc));
                break;
        }

        answer_tv.setText(answer_num);

    }

    private StringBuilder detailed_solution() {

        StringBuilder stringBuilder = new StringBuilder("Пример:\n\n");

        stringBuilder.append(first_num + lower_index[first_num_cc] + " -> X" + lower_index[answer_num_cc]);

        if (first_num_cc != 10) {
            stringBuilder.append("\n1. Переводим число " + first_num + lower_index[first_num_cc] + " в " + "10-ую систему счисления:\n\n");
            stringBuilder.append("\t" + first_num + lower_index[first_num_cc] + " = ");

            for (int i = 1; i <= first_num.length(); i++) {
                stringBuilder.append(first_num.charAt(i - 1) + "*" + first_num_cc + upper_index[first_num.length() - i]);
                if (i != first_num.length())
                    stringBuilder.append(" + ");
            }

            stringBuilder.append(" = " + answer_num + lower_index[answer_num_cc]);
            stringBuilder.append("\n\n2. Переводим число" + first_num + lower_index[first_num_cc] + " в " + answer_num_cc + "-ую систему счисления:\n\n");


        } else if (first_num_cc == 10) {
            stringBuilder.append("\n Переводим число" + first_num + lower_index[first_num_cc] + " в " + answer_num_cc + "-ую систему счисления:\n\n");
        }


        int num = Integer.parseInt(new BigInteger(first_num.toString(), first_num_cc).toString(10));


        while (num > 0) {
            stringBuilder.append("\t" + num + " / 2 = " + num / 2 + ", \tОстаток " + num % 2 + "\n");
            num /= 2;
        }

        stringBuilder.append("\n\nОтвет: " + first_num + lower_index[first_num_cc] + " -> " + answer_num + lower_index[answer_num_cc]);


        return stringBuilder;
    }

    private View.OnClickListener layout_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.calc_button:
                    linearLayout_btn.setVisibility(View.GONE);
                    linearLayout_calc.setVisibility(View.VISIBLE);
                    break;
                case R.id.detailed_solution_button:

                    if (R.id.button_calc_equally != action.getId() || first_num_cc == answer_num_cc)
                        break;

                    linearLayout_btn.setVisibility(View.VISIBLE);
                    linearLayout_calc.setVisibility(View.GONE);
                    solution.setText(detailed_solution());

            }
        }
    };

    private View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (id_selection_spinner.getSelectedItemPosition() + 2 <= Integer.parseInt(new BigInteger(((Button) v).getText().toString(), 16).toString(10))) {
                ShowToast.showToast(getContext(), "Неправильная система счисления!\n Цифры в числе не должны быть больше или равняться  системе счисления.");
                return;
            }


            StringBuilder stringBuilder = new StringBuilder(id_selection_tv.getText());


            for (int i = 0; i < stringBuilder.length(); i++) {
                if (stringBuilder.charAt(i) == '0')
                    stringBuilder.deleteCharAt(i);
                else
                    break;
            }

            stringBuilder.append(((Button) v).getText());

            int cc = id_selection_tv == first_num_tv ? first_num_cc : second_num_cc;

            if (1048575 <= Integer.parseInt(new BigInteger(stringBuilder.toString(), cc).toString(10))) {
                ShowToast.showToast(getContext(), "Число не должно быть больше " + new BigInteger("1048575", 10).toString(cc));

                return;
            }


            if (id_selection_tv.equals(first_num_tv)) {
                first_num = stringBuilder;
            } else
                second_num = stringBuilder;


            id_selection_tv.setText(stringBuilder);

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


                    if (stringBuilder.length() == 0) {
                        stringBuilder.append('0');
                    }

                    if (id_selection_tv.equals(first_num_tv)) {
                        first_num = stringBuilder;
                    } else
                        second_num = stringBuilder;

                    id_selection_tv.setText(stringBuilder);

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
