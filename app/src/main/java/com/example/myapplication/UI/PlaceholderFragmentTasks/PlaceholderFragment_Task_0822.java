package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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
public class PlaceholderFragment_Task_0822 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0822 newInstance(int index) {
        // юзает фрагмент
        PlaceholderFragment_Task_0822 fragment = new PlaceholderFragment_Task_0822();
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
    private EditText number;
    private RadioButton min;
    private RadioButton max;
    private TextView tAnswer;
    private EditText kod;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0822, container, false);

        // находим кнопку с которой работает
        btnAnswer = root.findViewById(R.id.task0822_btn_answer);
        btnAnswer.setOnClickListener(oclBtn);

        btnWhile = root.findViewById(R.id.task0822_btn_while);
        btnWhile.setOnClickListener(oclBtnWhile);

        btnIf = root.findViewById(R.id.task0822_btn_if);
        btnIf.setOnClickListener(oclBtnIf);

        btnIfElse = root.findViewById(R.id.task0822_btn_ifelse);
        btnIfElse.setOnClickListener(oclBtnIfElse);

        btnElse = root.findViewById(R.id.task0822_btn_else);
        btnElse.setOnClickListener(oclBtnElse);

        btnPrint = root.findViewById(R.id.task0822_btn_print);
        btnPrint.setOnClickListener(oclBtnPrint);

        btnInput = root.findViewById(R.id.task0822_btn_input);
        btnInput.setOnClickListener(oclBtnInput);

        kod = root.findViewById(R.id.task0822_edittext_code);
        number = root.findViewById(R.id.task0822_edittext_number);

        min = root.findViewById(R.id.task0822_rbtn_min_number);
        max = root.findViewById(R.id.task0822_rbtn_max_number);

        tAnswer = root.findViewById(R.id.task0822_textview_answer);
        return root;
    }
    public static String ColorEdit(String str)
    {
       // str = "while(n<5)\nif 8 >8\nelse print(\"kek\")\nwhile(true)";
        String strTmp =str;
        int index;
        ArrayList<Integer> indexMas = new ArrayList<>();
        int i = 0,count;
        while (true)
        {
            count = indexMas.size();
            index = strTmp.indexOf("while");
            if(index != -1)
                indexMas.add(index);
            if(count == indexMas.size())
                break;
            strTmp = strTmp.substring(indexMas.get(i) + 5,strTmp.length());
            i++;
        }
        for (int j = 1; j < indexMas.size(); j++) {
            indexMas.set(j,indexMas.get(j)+5);
        }
        //String html = "<font color='#FFA600'>while()</font>";
        String html = str.substring(0,indexMas.get(0));
        for (i = 0; i < indexMas.size(); i++) {
             html += "<font color='#FFA600'>while</font>";
             html += str.substring(indexMas.get(i)+5,indexMas.get(i+1));
             if(i+2 == indexMas.size())
             {
                 html += "<font color='#FFA600'>while</font>";
                 html += str.substring(indexMas.get(i+1) + 5, str.length());
                 break;
             }
        }

        return html;
    }

    View.OnClickListener oclBtnWhile = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            kod.setText(kod.getText() + "while()");
            kod.setSelection(kod.length()-1);
//            String stroka = ColorEdit(kod.getText().toString());
  //          kod.setText(Html.fromHtml(stroka));
        }
    };
    View.OnClickListener oclBtnIf = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            kod.setText(kod.getText() + "if");
            kod.setSelection(kod.length());
        }
    };
    View.OnClickListener oclBtnIfElse = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            kod.setText(kod.getText() + "elif");
            kod.setSelection(kod.length());
        }
    };
    View.OnClickListener oclBtnElse = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            kod.setText(kod.getText() + "else");
            kod.setSelection(kod.length());
        }
    };
    View.OnClickListener oclBtnPrint = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            kod.setText(kod.getText() + "print()");
            kod.setSelection(kod.length()-1);
        }
    };
    View.OnClickListener oclBtnInput = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            kod.setText(kod.getText() + "int(input())");
            kod.setSelection(kod.length()-2);
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
            String data = "100" + Constants.NEXT_LINE + "22" + Constants.NEXT_LINE;

            data += number.getText().toString() + Constants.NEXT_LINE;

            if (min.isChecked())
                data += "0" + Constants.NEXT_LINE;
            else
                data += "1" + Constants.NEXT_LINE;

            data += kod.getText().toString();
            return data;
        }

        private boolean checkData() {
            if (number.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите число, которое будет напечатано!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }
            if (!(min.isChecked() || max.isChecked())) {
                Toast toast = Toast.makeText(getContext(),
                        "Укажите каким должно быть число d!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }
            if (kod.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите Код программы!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }

            String answer = Check_Input.CheckString(kod.getText().toString());
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

