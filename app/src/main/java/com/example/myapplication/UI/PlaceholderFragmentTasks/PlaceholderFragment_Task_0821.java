package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Instruments.Check_Input;
import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_Task_0821 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0821 newInstance(int index) {
        // юзает фрагмент
        PlaceholderFragment_Task_0821 fragment = new PlaceholderFragment_Task_0821();
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
        String dispStr = "I'm the first line\nI'm the second line";

    }

    private Button btnAnswer;
    private Button btnWhile;
    private Button btnIf;
    private Button btnIfElse;
    private Button btnElse;
    private Button btnPrint;
    private Button btnInput;
    private TextView tAnswer;
    private EditText kod;

    private static String strr = "";
    private  static int Cursor = 0;
    private boolean flagButton= false;
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0821, container, false);

        // находим кнопку с которой работает
        btnAnswer = root.findViewById(R.id.task0821_btn_answer);
        btnAnswer.setOnClickListener(oclBtn);

       btnWhile = root.findViewById(R.id.task0821_btn_while);
        btnWhile.setOnClickListener(oclBtnWhile);

        btnIf = root.findViewById(R.id.task0821_btn_if);
        btnIf.setOnClickListener(oclBtnIf);

        btnIfElse = root.findViewById(R.id.task0821_btn_ifelse);
        btnIfElse.setOnClickListener(oclBtnIfElse);

        btnElse = root.findViewById(R.id.task0821_btn_else);
        btnElse.setOnClickListener(oclBtnElse);

        btnPrint = root.findViewById(R.id.task0821_btn_print);
        btnPrint.setOnClickListener(oclBtnPrint);

        btnInput = root.findViewById(R.id.task0821_btn_input);
        btnInput.setOnClickListener(oclBtnInput);

        kod = root.findViewById(R.id.task0821_edittext_code);

        kod.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable s) {

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    String tmp = kod.getText().toString();

                    if (!strr.equals(tmp)) {
                        strr = tmp;
                        String stroka = Check_Input.ColorEditTask8(tmp);
                        if ( !flagButton) //   false false
                            Cursor = kod.getSelectionStart();
                        flagButton = false;
                        kod.setText(Html.fromHtml(stroka));
                    }

                    kod.setSelection(Cursor);
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    Cursor = kod.getText().length();
                    kod.setSelection(Cursor);
                }
            }
        });
        tAnswer = root.findViewById(R.id.task0821_textview_answer);

        return root;
    }


    View.OnClickListener oclBtnWhile = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        flagButton = true;
        String tmp = kod.getText().toString();
        String str = tmp.substring(0,Cursor) + "while :";
        str += tmp.substring(Cursor,tmp.length());
        Cursor +=6;
        kod.setText(str);
        }
    };
    View.OnClickListener oclBtnIf = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            flagButton = true;
            String tmp = kod.getText().toString();
            String str = tmp.substring(0,Cursor) + "if :";
            str += tmp.substring(Cursor,tmp.length());
            Cursor +=3;
            kod.setText(str);
        }
    };
    View.OnClickListener oclBtnIfElse = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            flagButton = true;
            String tmp = kod.getText().toString();
            String str = tmp.substring(0,Cursor) + "elif :";
            str += tmp.substring(Cursor,tmp.length());
            Cursor +=5;
            kod.setText(str);
        }
    };
    View.OnClickListener oclBtnElse = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            flagButton = true;
            String tmp = kod.getText().toString();
            String str = tmp.substring(0,Cursor) + "else :";
            str += tmp.substring(Cursor,tmp.length());
            Cursor +=5;
            kod.setText(str);
        }
    };
    View.OnClickListener oclBtnPrint = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            flagButton = true;
            String tmp = kod.getText().toString();
            String str = tmp.substring(0,Cursor) + "print()";
            str += tmp.substring(Cursor,tmp.length());
            Cursor +=6;
            kod.setText(str);
        }
    };
    View.OnClickListener oclBtnInput = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            flagButton = true;
            String tmp = kod.getText().toString();
            String str = tmp.substring(0,Cursor) + "int(input())";
            str += tmp.substring(Cursor,tmp.length());
            Cursor +=10;
            kod.setText(str);
        }
    };
    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (checkData()) return;

            String data = getData();

            Toast toast = Toast.makeText(getContext(),
                    data, Toast.LENGTH_SHORT);
            toast.show();
            //отправка на сервер
            //*****************
            //*****************
            ///////////////////
            tAnswer.setVisibility(View.VISIBLE);
        }

        private String getData() {
            String data = "100" + Constants.NEXT_LINE + "21" + Constants.NEXT_LINE;
            data += kod.getText().toString();

            return data;
        }

        private boolean checkData() {
            if (kod.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите Код программы!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }

            String answer = Check_Input.CheckString(kod.getText().toString(),8);
            if(!answer.isEmpty())
            {
                Toast toast = Toast.makeText(getContext(),
                        answer, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }
            return false;
        }
    };


}

