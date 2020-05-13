package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.Instruments.ShowToast;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_Task_0720 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0720 newInstance(int index) {
        PlaceholderFragment_Task_0720 fragment = new PlaceholderFragment_Task_0720();
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


    private MaterialEditText ratio;
    private MaterialEditText row;
    private MaterialEditText col;
    Table table;
    private Button button_answer;
    private TextView text_answer;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0720, container, false);

        table = new Table(root.findViewById(R.id.task0720_table));

        ratio = root.findViewById(R.id.task0720_edittext_ratio);


        col = root.findViewById(R.id.task0720_count_col);
        row = root.findViewById(R.id.task0720_count_row);


        col.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (row.getText().toString().isEmpty()) return;
                table.setSize(Integer.parseInt(row.getText().toString()), Integer.parseInt(s.toString()));
            }
        });

        row.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (col.getText().toString().isEmpty()) return;
                table.setSize(Integer.parseInt(s.toString()), Integer.parseInt(col.getText().toString()));
            }
        });

        text_answer = root.findViewById(R.id.task0720_text_answer);

        button_answer = root.findViewById(R.id.task0720_btn_answer);
        button_answer.setOnClickListener(oclBtn);

        return root;
    }


    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (checkData()) return;

            String data = getData();
            ShowToast.showToast(getContext(), data);
        }

        private boolean checkData() {

            if (ratio.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите отношение ячеек!");
                return true;
            }

            String str =ratio.getText().toString(),
                    prev_char = str.charAt(0)+"";

            for (int i = 1; i < str.length(); i++) {
                if((str.charAt(i)+ "").contains("1234567890") && prev_char.contains(":") || str.charAt(str.length()-1) == i)
                {
                    ShowToast.showToast(getContext(), "Введите отношение ячеек!\n Пример: 1:2:2");
                    return true;
                }
            }

            if (col.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите конечную точку!");
                return true;
            }

            if (row.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите количество строк!");
                return true;
            }

            return false;
        }


        private String getData() {

            String data = "100" + Constants.NEXT_LINE + 20 + Constants.NEXT_LINE;
            data += ratio.getText().toString() + Constants.NEXT_LINE;
            data += table.sizeRow + "\\" + table.sizeCol + Constants.NEXT_LINE;
            data += table.toString();

            return data;
        }
    };


    class Table {

        final private String chars = "ABCDEFGHIKLMNOP";
        final private String numbers = "123456789";

        final private TableLayout tableLayout;
        int sizeRow,sizeCol;

        private ArrayList<Row> rows = new ArrayList<Row>();


        public Table(TableLayout tableLayout) {
            this.tableLayout = tableLayout;
        }


        //Задаем количество дорог
        public void setSize(int row,int col) {

            this.sizeCol = col;
            this.sizeRow = row;
            tableLayout.removeAllViews();
            rows.clear();
            createRow();

        }


        private void createRow() {

            for (int i = 0; i <= sizeRow; i++) {
                rows.add(new Row(i, sizeCol));
                tableLayout.addView(rows.get(i).getRow());
            }

        }


        public TableLayout getTable() {
            return tableLayout;
        }

        @NonNull
        @Override
        public String toString() {
            String s = "";

            for (Row row : rows) {
                if (row.index == 0) continue;

                s += row.toString();
            }
            return s;
        }

        class Row {

            TableRow tableRow; //view  где находняться элементы

            int index, //номер строки
                    size; // колличество элементов в строчке

            ArrayList<View> views = new ArrayList<View>();// массив с элементами строки

            // задаем ширину, высоту и вес для элементов строки
            TableRow.LayoutParams params_row = new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);


            Row(int index, int size) {

                this.index = index;
                this.size = size;

                tableRow = new TableRow(getContext());
                createRow();
            }

            //создаем строку
            private void createRow() {
                // Создаем первую строку с одними буквами
                if (index == 0) {

                    views.add(createTextView("", Color.rgb(238, 238, 238)));
                    tableRow.addView(views.get(0));

                    for (int i = 1; i <= size; i++) {
                        views.add(createTextView("" + chars.charAt(i - 1), Color.rgb(238, 238, 238)));
                        tableRow.addView(views.get(i));

                    }
                }
                // Создаем последующие строчки
                else {

                    for (int i = 0; i <= size; i++) {

                        if (i == 0) {
                            views.add(createTextView("" + numbers.charAt(index - 1), Color.rgb(238, 238, 238)));
                            tableRow.addView(views.get(i));
                            continue;
                        }

                        views.add(createEditTextView(Color.rgb(255, 255, 255)));
                        tableRow.addView(views.get(i));

                    }
                }
            }


            TableRow getRow() {
                return tableRow;
            }

            @NonNull
            @Override
            public String toString() {

                String s = "";
                for (int i = 0; i < views.size(); i++) {
                    if (i == 0)
                        continue;

                    EditText editText = (EditText) views.get(i);

                    if (editText.getText().toString().isEmpty())
                        s += '0';
                    else
                        s += editText.getText().toString();

                    if (i != views.size() - 1)
                        s += "\\";
                }

                return s + Constants.NEXT_LINE;
            }

            private TextView createTextView(String text, int color) {
                TextView textView = new TextView(getContext());
                textView.setText(text);//Задаем текст
                textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);// Выравнивем по центру текст
                textView.setBackgroundColor(color);// Задаем цвет
                textView.setLayoutParams(params_row);

                return textView;
            }

            private EditText createEditTextView(int color) {
                EditText editText = new EditText(getContext());
                editText.setPadding(0, 0, 0, 0);// Убираем отступы
                editText.setBackgroundColor(color);// Задаем цвет
                editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);// Выравниваем текст по центру
                editText.setSingleLine(true);// Только одна строка
                editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});// Задаем максимальное количество символов
                editText.setLayoutParams(params_row);

                return editText;
            }

        }
    }



}


