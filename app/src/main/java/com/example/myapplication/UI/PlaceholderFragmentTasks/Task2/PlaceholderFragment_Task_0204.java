package com.example.myapplication.UI.PlaceholderFragmentTasks.Task2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.Instruments.ShowToast;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_Task_0204 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private int row = 4, col = 4;
    private TableLayout table;
    private PageViewModel pageViewModel;
    private Button button_answer;
    private View root;
    private TextView text_answer;
    private TextView textView_count_row;
    private EditText equation;
    private ArrayList<TextView> table_fragments = new ArrayList<TextView>();

    public static PlaceholderFragment_Task_0204 newInstance(int index) {
        PlaceholderFragment_Task_0204 fragment = new PlaceholderFragment_Task_0204();
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
        root = inflater.inflate(R.layout.fragment_task_0204, container, false);



        button_answer = root.findViewById(R.id.btn_answer);
        button_answer.setOnClickListener(oclBtn);

        table = root.findViewById(R.id.table);

        text_answer = root.findViewById(R.id.textView_answer);

        equation = root.findViewById(R.id.edittext_equation);

        textView_count_row = root.findViewById(R.id.edittext_count_row);
        equation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().isEmpty()) create_table();
            }
        });

        textView_count_row.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().isEmpty()) create_table();
            }
        });

        // фильтр ввода уравнения
        return root;
    }


    //обработчик нажатий
    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (checkData()) return;

            String data = getData();

            text_answer.setText(data);

            text_answer.setVisibility(View.VISIBLE);
        }

        private String getData() {
            String data = "100" + Constants.NEXT_LINE + "4" + Constants.NEXT_LINE;

            data += textView_count_row.getText().toString() + Constants.NEXT_LINE;
            data += col + Constants.NEXT_LINE;
            data += equation.getText().toString() + Constants.NEXT_LINE;

            data += table_fragments.remove(0).getText().toString();
            for(TextView tv : table_fragments)
            {
                data += '\\' + tv.getText().toString() ;

            }

            return data;
        }

        private boolean checkData() {
            if (textView_count_row.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите количество строчек!");
                return true;
            }

            if (equation.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите уравнение!");
                return true;
            }

            return false;
        }
    };

    private void create_table()
    {

        if(textView_count_row.getText().toString().isEmpty()  || equation.toString().isEmpty())
            return;


        col = Check_Input.CountOfDifferentSymbols(equation.getText().toString()) + 1;
        row = Integer.parseInt(textView_count_row.getText().toString());
        table.removeAllViews();
        table_fragments.clear();


        final float scale = getResources().getDisplayMetrics().density;
        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);
        params.setMargins((int) (0.5 * scale + 0.5f), (int) (0.5 * scale + 0.5f), (int) (0.5 * scale + 0.5f), (int) (0.5 * scale + 0.5f));

        //создаем строку
        for (int i = 0; i < row; i++) {
            TableRow tr = new TableRow(root.getContext());

            //создаем поле ввода
            for (int j = 0; j < col; j++) {
                TextView textView = new TextView(getContext());
                textView.setBackgroundColor(ContextCompat.getColor(root.getContext(), R.color.BackgroundTableText));
                textView.setText("0");
                textView.setGravity(Gravity.CENTER);
                textView.setLayoutParams(params);
                textView.setOnClickListener(oclBtnTextTable);
                tr.addView(textView);
                table_fragments.add(textView);
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