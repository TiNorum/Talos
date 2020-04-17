package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
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

        kod = root.findViewById(R.id.task0821_edittext_code);;
        tAnswer = root.findViewById(R.id.task0821_textview_answer);
        return root;
    }
    public static String ColorEdit(String str)
    {
        // str = "while(n<5)\nif 8 >8\nelse print(\"kek\")\nwhile(true)";
        String html = "";
        String strTmp =str;
        int index;
        ArrayList<Integer> indexMas = new ArrayList<>();
        int i = 0,count;

        str = str.replace("\n","<br>");
        str = str.replace("elif","<font color='#0088FE'>elif</font>");
        str = str.replace("while","<font color='#FFA600'>while</font>");
        str = str.replace("if","<font color='#0088FE'>if</font>");

        str = str.replace("else","<font color='#0088FE'>else</font>");
        str = str.replace("int(input","<font color='#71FF00'>int(input</font>");
        str = str.replace("print","<font color='#71FF00'>print</font>");
        return str;
    }

    View.OnClickListener oclBtnWhile = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int curPos = kod.getSelectionStart();
            String str  = kod.getText().toString().substring(0,curPos) + "while()";
            str =kod.getText() + str.substring(curPos,str.length());
            String stroka = ColorEdit(str);
            kod.setText(Html.fromHtml(stroka));
            kod.setSelection(curPos + 6);
        }
    };
    View.OnClickListener oclBtnIf = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int curPos = kod.getSelectionStart();
            String str  = kod.getText().toString().substring(0,curPos) + "if";
            str =kod.getText() + str.substring(curPos,str.length());
            String stroka = ColorEdit(str);
            kod.setText(Html.fromHtml(stroka));
            kod.setSelection(curPos + 2);
        }
    };
    View.OnClickListener oclBtnIfElse = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int curPos = kod.getSelectionStart();
            String str  = kod.getText().toString().substring(0,curPos) + "elif";
            str =kod.getText() + str.substring(curPos,str.length());
            String stroka = ColorEdit(str);
            kod.setText(Html.fromHtml(stroka));
            kod.setSelection(curPos + 4);
        }
    };
    View.OnClickListener oclBtnElse = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int curPos = kod.getSelectionStart();
            String str  = kod.getText().toString().substring(0,curPos) + "else";
            str =kod.getText() + str.substring(curPos,str.length());
            String stroka = ColorEdit(str);
            kod.setText(Html.fromHtml(stroka));
            kod.setSelection(curPos + 4);
        }
    };
    View.OnClickListener oclBtnPrint = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int curPos = kod.getSelectionStart();
            String str  = kod.getText().toString().substring(0,curPos) + "print()";
            str =kod.getText() + str.substring(curPos,str.length());
            String stroka = ColorEdit(str);
            kod.setText(Html.fromHtml(stroka));
            kod.setSelection(curPos + 6);
        }
    };
    View.OnClickListener oclBtnInput = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int curPos = kod.getSelectionStart();
            String str  = kod.getText().toString().substring(0,curPos) + "int(input())";
            str =kod.getText() + str.substring(curPos,str.length());
            String stroka = ColorEdit(str);
            kod.setText(Html.fromHtml(stroka));
            kod.setSelection(curPos + 10);
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

