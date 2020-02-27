package com.example.myapplication.UI.task_number_2;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Instruments.Check_Input;
import com.example.myapplication.R;
import com.example.myapplication.UI.PageViewModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_2 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private int row = 4, col = 4;
    private TableLayout table;
    private PageViewModel pageViewModel;
    private Button bSet;
    private Button bR;
    private View root;
    private TextView tvO;
    private TextView tvCol;
    private TextView tvRow;
    private EditText equation;

    public static PlaceholderFragment_2 newInstance(int index) {
        PlaceholderFragment_2 fragment = new PlaceholderFragment_2();
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

    @Override


    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_task_6, container, false);


        bSet = root.findViewById(R.id.bSet_type2);
        bSet.setOnClickListener(oclBtn);

        bR = root.findViewById(R.id.bR_type2);
        bR.setOnClickListener(oclBtn);

        table = root.findViewById(R.id.table_type2);

        tvO = root.findViewById(R.id.tvO_type2);

        tvRow = root.findViewById(R.id.editTextRow_type2);
        equation = root.findViewById(R.id.equation_type2);


        equation.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30), new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                StringBuilder sbText = new StringBuilder(source);

                String text = sbText.toString();
                text = text.toLowerCase();

                char[] newText = new char[50];

                newText = text.toCharArray();

                String blockCharacterSet = "#^|$%*!@/'\":;,?{}!$'`;,?×÷<{}€£¥ 1234567890абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
                for (int i = 0; i < text.length(); i++) {
                    if ((blockCharacterSet.contains("" + newText[i]))) {
                        return "";
                    }
                }
                return text;
            }


        }});

        return root;
    }


    //обработчик нажатий
    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //нажатия на кнопку "SET"e
                case R.id.bSet_type2:
                    //очищаем таблицу
                    row = Integer.parseInt(tvRow.getText().toString());

                    String temp = equation.getText().toString();
                    equation.setText(temp);
                    col = Check_Input.CountOfDifferentSymbols(temp) + 1;

                    tvO.setVisibility(View.INVISIBLE);
                    table.removeAllViews();
                    //создаем новую таблицу
                    CreateTable();

                    bR.setVisibility(View.VISIBLE);
                    break;

                //нажатия на кнопку "Решить"
                case R.id.bR_type2:

                    bR.setVisibility(View.INVISIBLE);
                    //*********
                    //реализовать функцию отправки и получения данных с сервера
                    //*********
                    tvO.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };


    //создаем таблицу
    public void CreateTable() {

        final float scale = getResources().getDisplayMetrics().density;
        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);
        params.setMargins((int) (0.5 * scale + 0.5f), (int) (0.5 * scale + 0.5f), (int) (0.5 * scale + 0.5f), (int) (0.5 * scale + 0.5f));

        //создаем строку
        for (int i = 0; i < row; i++) {
            TableRow tr = new TableRow(root.getContext());

            //tr.setBackgroundColor(ContextCompat.getColor(root.getContext(),R.color.BackgroundTableText));

            //создаем поле ввода
            for (int j = 0; j < col; j++) {
                TextView textView = new TextView(getContext());
                textView.setBackgroundColor(ContextCompat.getColor(root.getContext(), R.color.BackgroundTableText));
                textView.setText("0");
                textView.setGravity(Gravity.CENTER);
                textView.setLayoutParams(params);
                textView.setOnClickListener(oclBtnTextTable);
                /* */

                tr.addView(textView);

            }
            table.setPadding((int) (0.5 * scale + 0.5f), (int) (0.5 * scale + 0.5f), (int) (0.5 * scale + 0.5f), (int) (0.5 * scale + 0.5f));
            table.addView(tr);
        }
    }


    View.OnClickListener oclBtnTextTable = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView textView = (TextView) v;
            if (textView.getText() == "1")
                textView.setText("");
            else if (textView.getText() == "0")
                textView.setText("1");
            else
                textView.setText("0");


        }
    };
}