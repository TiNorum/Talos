package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_Task_0102 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0102 newInstance(int index) {
        PlaceholderFragment_Task_0102 fragment = new PlaceholderFragment_Task_0102();
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


    Button btnAnswer;
    TextView tAnswer;
    MaterialEditText number;
    MaterialEditText cc;
    RadioGroup rg;


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0102, container, false);

        btnAnswer = root.findViewById(R.id.task0102_btn_answer);
        btnAnswer.setOnClickListener(oclBtn);

        cc =(MaterialEditText) root.findViewById(R.id.task0102_edittext_cc);
        number =(MaterialEditText) root.findViewById(R.id.task0102_edittext_number);



        tAnswer = root.findViewById(R.id.task0102_txt_answer);


        return root;
    }

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                                if (number.getText().toString().length() != 0) {
                        if (cc.getText().toString().length() != 0) {
                                tAnswer.setVisibility(View.VISIBLE);

                        } else {
                            Toast toast = Toast.makeText(getContext(),
                                    "Введите систему счисления!", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    } else {
                        Toast toast = Toast.makeText(getContext(),
                                "Введите число!", Toast.LENGTH_SHORT);
                        toast.show();
                    }

        }
    };
}