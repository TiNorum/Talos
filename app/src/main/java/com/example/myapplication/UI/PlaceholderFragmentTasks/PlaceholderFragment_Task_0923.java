package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
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

import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;

public class PlaceholderFragment_Task_0923 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0923 newInstance(int index) {
        PlaceholderFragment_Task_0923 fragment = new PlaceholderFragment_Task_0923();
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
    private TextView answertext;
    private Button btOtvet;
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0923, container, false);

        text1 = root.findViewById(R.id.editText1_task23);
        text2 = root.findViewById(R.id.editText2_task23);
        text3 = root.findViewById(R.id.editText3_task23);
        text4 = root.findViewById(R.id.editText4_task23);
        answertext = root.findViewById(R.id.answertext_task23);
        btOtvet = root.findViewById(R.id.buttonAnswer_task23);
        btOtvet.setOnClickListener(oclBtn);
        return root;
    }

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonAnswer_task23:
                    boolean check = true;

                    if (!text1.getText().toString().isEmpty() && !text2.getText().toString().isEmpty() && !text3.getText().toString().isEmpty() && !text4.getText().toString().isEmpty())
                        answertext.setVisibility(View.VISIBLE);
                    else {
                        Toast toast = Toast.makeText(getContext(),
                                "Заполните все поля!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    break;
            }
        }
    };
}



