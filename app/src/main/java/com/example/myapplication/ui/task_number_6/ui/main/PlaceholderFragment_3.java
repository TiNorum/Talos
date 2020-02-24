package com.example.myapplication.ui.task_number_6.ui.main;

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
import com.example.myapplication.ui.PageViewModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_3 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_3 newInstance(int index) {
        PlaceholderFragment_3 fragment = new PlaceholderFragment_3();
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


    private EditText text1;
    private EditText text2;
    private EditText text3;
    private EditText text4;
    private EditText text5;
    private CheckBox checkBox1;
    private CheckBox checkBox2;

    private Button btOtvet;
    private TextView answertext;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0617, container, false);

        text1 = root.findViewById(R.id.editText1_task17);
        text2 = root.findViewById(R.id.editText2_task17);
        text3 = root.findViewById(R.id.editText3_task17);
        text4 = root.findViewById(R.id.editText4_task17);
        text5 = root.findViewById(R.id.editText5_task17);
        answertext = root.findViewById(R.id.answertext_task17);
        checkBox1 = root.findViewById(R.id.checkBox1_task17);
        checkBox1.setOnClickListener(oclBtn);
        checkBox2 = root.findViewById(R.id.checkBox2_task17);
        checkBox2.setOnClickListener(oclBtn);
        btOtvet = root.findViewById(R.id.buttonAnswer_task17);
        btOtvet.setOnClickListener(oclBtn);
        return root;
    }

    boolean check1=false;
    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonAnswer_task17:
                    boolean check = true;

                    if (!text1.getText().toString().isEmpty() && !text2.getText().toString().isEmpty() && !text3.getText().toString().isEmpty() && !text4.getText().toString().isEmpty() & !text5.getText().toString().isEmpty() && check1)
                        answertext.setVisibility(View.VISIBLE);
                    else {
                        Toast toast = Toast.makeText(getContext(),
                                "Заполните все поля!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    break;
                case R.id.checkBox1_task17:
                    checkBox1.setChecked(true);
                    checkBox2.setChecked(false);
                    checkBox2.setClickable(true);
                    checkBox1.setClickable(false);
                    answertext.setVisibility(View.INVISIBLE);
                    check1 = true;
                    break;
                case R.id.checkBox2_task17:
                    checkBox2.setChecked(true);
                    checkBox2.setClickable(false);
                    checkBox1.setChecked(false);
                    checkBox1.setClickable(true);
                    answertext.setVisibility(View.INVISIBLE);
                    check1 = true;
                    break;
            }
        }
    };
}