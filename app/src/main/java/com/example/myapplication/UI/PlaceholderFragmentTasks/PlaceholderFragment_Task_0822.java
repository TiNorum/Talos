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
        number = root.findViewById(R.id.edittext_number);

        min = root.findViewById(R.id.radiobutton_min);
        max = root.findViewById(R.id.radiobutton_max);


        string_.put(R.id.button_while,"<font color='#FFA600'>while():<br>&nbsp;&nbsp;&nbsp;&nbsp;</font></p>");
        string_.put(R.id.button_if,"<font color='#0088FE'>if():<br>&nbsp;&nbsp;&nbsp;&nbsp;</font>");
        string_.put(R.id.button_else,"<font color='#0088FE'>else:<br>&nbsp;&nbsp;&nbsp;&nbsp;</font>");
        string_.put(R.id.button_else_if,"<font color='#0088FE'>elif():<br>&nbsp;&nbsp;&nbsp;&nbsp;</font>");
        string_.put(R.id.button_print,"<font color='#71FF00'>print()</font>");
        string_.put(R.id.button_input,"<font color='#71FF00'>int(input())</font>");

        text_answer = root.findViewById(R.id.text_answer);
        return root;
    }

    private View.OnClickListener code_button_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            code.setText(Html.fromHtml(Html.toHtml(code.getText()) + (string_.get(v.getId()))));
            code.setSelection(code.getText().length());
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

