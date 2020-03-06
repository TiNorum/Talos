package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_Task_0610 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0610 newInstance(int index) {
        PlaceholderFragment_Task_0610 fragment = new PlaceholderFragment_Task_0610();
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

    private EditText num1;
    private EditText num2;
    private TextView answertext;
    private Button answerbutton;
    private CheckBox chek1;
    private CheckBox chek2;
    private CheckBox chek3;
    private CheckBox chek4;
    private CheckBox chek5;
    private CheckBox chek6;
    private CheckBox chek7;
    private CheckBox chek8;
    private CheckBox chek9;
    private CheckBox chek10;


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0616, container, false);

        chek1 = root.findViewById(R.id.checkBox_task16);
        chek1.setOnClickListener(oclBtn);
        chek2 = root.findViewById(R.id.checkBox2_task16);
        chek2.setOnClickListener(oclBtn);
        chek3 = root.findViewById(R.id.checkBox3_task16);
        chek3.setOnClickListener(oclBtn);
        chek4 = root.findViewById(R.id.checkBox4_task16);
        chek4.setOnClickListener(oclBtn);
        chek5 = root.findViewById(R.id.checkBox5_task16);
        chek5.setOnClickListener(oclBtn);
        chek6 = root.findViewById(R.id.checkBox6_task16);
        chek6.setOnClickListener(oclBtn);
        chek7 = root.findViewById(R.id.checkBox7_task16);
        chek7.setOnClickListener(oclBtn);
        chek8 = root.findViewById(R.id.checkBox8_task16);
        chek8.setOnClickListener(oclBtn);
        chek9 = root.findViewById(R.id.checkBox9_task16);
        chek9.setOnClickListener(oclBtn);
        chek10 = root.findViewById(R.id.checkBox10_task16);
        chek10.setOnClickListener(oclBtn);

        answerbutton = root.findViewById(R.id.answerButton_task16);
        answerbutton.setOnClickListener(oclBtn);
        answertext = root.findViewById(R.id.answerText_task16);
        num1 = root.findViewById(R.id.editText1_task16);
        num1 = root.findViewById(R.id.editText2_task16);


        return root;
    }

    boolean check1,check2,check3,check4,check5;

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.answerButton_task16:
                    boolean check = true;

                    if (!num1.getText().toString().isEmpty() && check1 && check2 && check3 & check4 && check5)
                        answertext.setVisibility(View.VISIBLE);
                    else {
                        Toast toast = Toast.makeText(getContext(),
                                "Заполните все поля!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    break;
                case R.id.checkBox_task16:
                    chek1.setChecked(true);
                    chek2.setChecked(false);
                    chek2.setClickable(true);
                    chek1.setClickable(false);
                    answertext.setVisibility(View.INVISIBLE);
                    check1 =true;
                    break;
                case R.id.checkBox2_task16:
                   chek2.setChecked(true);
                   chek2.setClickable(false);
                   chek1.setChecked(false);
                    chek1.setClickable(true);
                    answertext.setVisibility(View.INVISIBLE);
                    check1= true;
                    break;
                case R.id.checkBox3_task16:
                    chek3.setChecked(true);
                    chek4.setChecked(false);
                    chek3.setClickable(false);
                    chek4.setClickable(true);
                    answertext.setVisibility(View.INVISIBLE);
                    check2 = true;
                    break;
                case R.id.checkBox4_task16:
                    chek4.setChecked(true);
                    chek3.setChecked(false);
                    chek4.setClickable(false);
                    chek3.setClickable(true);
                    answertext.setVisibility(View.INVISIBLE);
                    check2 = true;
                    break;
                case R.id.checkBox5_task16:
                    chek5.setChecked(true);
                    chek6.setChecked(false);
                    chek5.setClickable(false);
                    chek6.setClickable(true);
                    answertext.setVisibility(View.INVISIBLE);
                    check3 = true;
                    break;
                case R.id.checkBox6_task16:
                    chek6.setChecked(true);
                    chek5.setChecked(false);
                    chek6.setClickable(false);
                    chek5.setClickable(true);
                    answertext.setVisibility(View.INVISIBLE);
                    check3 = true;
                    break;
                case R.id.checkBox7_task16:
                    chek7.setChecked(true);
                    chek8.setChecked(false);
                    chek7.setClickable(false);
                    chek8.setClickable(true);
                    answertext.setVisibility(View.INVISIBLE);
                    check4 = true;
                    break;
                case R.id.checkBox8_task16:
                    chek8.setChecked(true);
                    chek7.setChecked(false);
                    chek8.setClickable(false);
                    chek7.setClickable(true);
                    answertext.setVisibility(View.INVISIBLE);
                    check4 = true;
                    break;
                case R.id.checkBox9_task16:
                    chek9.setChecked(true);
                    chek10.setChecked(false);
                    chek9.setClickable(false);
                    chek10.setClickable(true);
                    answertext.setVisibility(View.INVISIBLE);
                    check5 = true;
                    break;
                case R.id.checkBox10_task16:
                    chek10.setChecked(true);
                    chek9.setChecked(false);
                    chek10.setClickable(false);
                    chek9.setClickable(true);
                    answertext.setVisibility(View.INVISIBLE);
                    check5 = true;
                    break;
            }

        }
    };
}