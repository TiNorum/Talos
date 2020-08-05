package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.KeyEvent;
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
import com.example.myapplication.Instruments.ShowToast;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;

import java.util.HashMap;
import java.util.Map;

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

    private Button button_while;
    private Button button_if;
    private Button button_elif;
    private Button button_else;
    private Button button_print;
    private Button button_input;
    private EditText number;
    private RadioButton min;
    private RadioButton max;
    private TextView text_answer;
    private Button button_answer;

    private EditText code;


    Map<Integer,String> string_ = new HashMap<Integer, String>();
    Map<Integer, Integer> span_color = new HashMap<Integer, Integer>();


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0822, container, false);

        // находим кнопку с которой работает
        button_answer = root.findViewById(R.id.button_answer);
        button_answer.setOnClickListener(oclBtn);

        button_while = root.findViewById(R.id.button_while);
        button_while.setOnClickListener(code_button_listener);

        button_if = root.findViewById(R.id.button_if);
        button_if.setOnClickListener(code_button_listener);

        button_elif = root.findViewById(R.id.button_else_if);
        button_elif.setOnClickListener(code_button_listener);

        button_else = root.findViewById(R.id.button_else);
        button_else.setOnClickListener(code_button_listener);

        button_print = root.findViewById(R.id.button_print);
        button_print.setOnClickListener(code_button_listener);

        button_input = root.findViewById(R.id.button_input);
        button_input.setOnClickListener(code_button_listener);

        code = root.findViewById(R.id.edittext_code);
        code.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if (i == 66 && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {

                    int position = code.getSelectionEnd();
                    StringBuffer string = new StringBuffer(code.getText().toString());
                    StringBuilder s = new StringBuilder("");

                    for (int index = string.length() - 1; index >= 0 && string.charAt(index) != '\n'; index--) {
                        s.append(string.charAt(index));
                    }


                    if (s.length() < 4) return false;

                    s.reverse();

                    int counter_space = 0;

                    for (int index = 0; index < s.length() && s.charAt(index) == ' '; index++) {
                        counter_space++;
                    }

                    ShowToast.showToast(getContext(), "" + counter_space);
                    Editable str = code.getText();


                    code.setText(str.insert(position, "\n"));
                    position++;


                    while (counter_space / 4 > 0) {
                        str.insert(position, "    ");
                        position += 4;
                        counter_space-=4;
                    }


                    s.trimToSize();

                    if (s.charAt(s.length() - 1) == ':') {
                        str.insert(position, "    ");
                        position += 4;
                    }

                    if(str.length()> 200) return false;

                    code.setText(str);
                    code.setSelection(position);

                    return true;

                }

                return false;
            }
        });

        number = root.findViewById(R.id.edittext_number);

        min = root.findViewById(R.id.radiobutton_min);
        max = root.findViewById(R.id.radiobutton_max);


        string_.put(R.id.button_while, "while():");
        span_color.put(R.id.button_while, Color.rgb(0, 136, 254));

        string_.put(R.id.button_if, "if():");
        span_color.put(R.id.button_if, Color.rgb(0, 136, 254));

        string_.put(R.id.button_else, "else:");
        span_color.put(R.id.button_else, Color.rgb(0, 136, 254));

        string_.put(R.id.button_else_if, "elif():");
        span_color.put(R.id.button_else_if, Color.rgb(0, 136, 254));

        string_.put(R.id.button_print, "print()");
        span_color.put(R.id.button_print, Color.rgb(113, 255, 0));

        string_.put(R.id.button_input, "int(input())");
        span_color.put(R.id.button_input, Color.rgb(113, 255, 0));

        text_answer = root.findViewById(R.id.text_answer);
        return root;
    }

    private View.OnClickListener code_button_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SpannableStringBuilder stringBuilder = new SpannableStringBuilder(code.getText());

            int pos = code.getSelectionEnd() + string_.get(v.getId()).length();

            stringBuilder.insert(code.getSelectionStart(), string_.get(v.getId()));
            stringBuilder.setSpan(new ForegroundColorSpan(span_color.get(v.getId())),code.getSelectionStart(),code.getSelectionStart() + string_.get(v.getId()).length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


            code.setText(stringBuilder);
            code.setSelection(pos);
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

            text_answer.setVisibility(View.VISIBLE);
        }

        private String getData() {
            String data = "100" + Constants.NEXT_LINE + "22" + Constants.NEXT_LINE;

            data += number.getText().toString() + Constants.NEXT_LINE;

            if (min.isChecked())
                data += "0" + Constants.NEXT_LINE;
            else
                data += "1" + Constants.NEXT_LINE;

            data += code.getText().toString();
            return data;
        }

        private boolean checkData() {
            if (number.getText().toString().isEmpty() || Integer.valueOf(number.getText().toString()) == 0) {
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
            if (code.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите Код программы!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }

            String answer = Check_Input.CheckString(code.getText().toString(),8);
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

