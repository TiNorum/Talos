package com.example.myapplication.ui.task_number_2;

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

import com.example.myapplication.R;
import com.example.myapplication.ui.PageViewModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private int row=4, col=4;
    private  TableLayout table;
    private PageViewModel pageViewModel;
    private Button bSet;
    private Button bR;
    private View root;
    private TextView tvO;
    private TextView tvCol;
    private TextView tvRow;
    private EditText equation;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
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
         root = inflater.inflate(R.layout.fragment_task_5, container, false);


        bSet = root.findViewById(R.id.bSet);
        bSet.setOnClickListener(oclBtn);

        bR = root.findViewById(R.id.bR);
        bR.setOnClickListener(oclBtn);

        table = root.findViewById(R.id.table);

        tvO = root.findViewById(R.id.tvO);

        tvRow = root.findViewById(R.id.editTextRow);
        equation = root.findViewById(R.id.equation);



        equation.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30),new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                StringBuilder sbText = new StringBuilder(source);

                String text = sbText.toString();
                text=text.toLowerCase();

                char[] newText = new char[50];

                newText = text.toCharArray();

                String blockCharacterSet = "#^|$%*!@/'\":;,?{}!$'`;,?×÷<{}€£¥ 1234567890абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
                for(int i=0;i<text.length();i++)
                {
                      if ((blockCharacterSet.contains(""+newText[i])))
                      {
                          return "";
                      }
                }
                return  text;
            }




        }});

        /*equation.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable s) {
                // Прописываем то, что надо выполнить после изменения текста

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });*/
        return root;
    }



    //обработчик нажатий
    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //нажатия на кнопку "SET"e
                case R.id.bSet:
                    //очищаем таблицу
                    row =Integer.parseInt(tvRow.getText().toString());

                    String temp = equation.getText().toString();
                    equation.setText(temp);
                    col =fff(temp)+1;

                    tvO.setVisibility(View.INVISIBLE);
                    table.removeAllViews();
                    //создаем новую таблицу
                    CreateTable();

                    bR.setVisibility(View.VISIBLE);
                    break;

                //нажатия на кнопку "Решить"
                case R.id.bR:

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
    public void  CreateTable()
    {

        final float scale = getResources().getDisplayMetrics().density;
        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);
        params.setMargins((int) (0.5 * scale + 0.5f), (int) (0.5 * scale + 0.5f), (int) (0.5 * scale + 0.5f), (int) (0.5 * scale + 0.5f));





        //создаем строку
        for(int i=0;i<row;i++) {
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
            if(textView.getText()=="1")
            textView.setText("0");
            else
                textView.setText("1");



        }
    };

    // подсчитываем количество различных переменных
    //дать нормальное название функции
    public int fff(String s)
    {
        String ch="";
        int count=0;
        for(byte i=0;i<s.length();i++)
        {
            String characterSet = "abcdefghijklmnopqrstuvwxyz";
            if(characterSet.contains(""+ s.charAt(i)))
            {
                if(!(ch.contains("" + s.charAt(i))))
                {
                    ch+=s.charAt(i);
                }
            }
        }
        return ch.length();
    }
}