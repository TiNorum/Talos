package com.example.myapplication.ui.task_number_1;

import android.os.Bundle;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
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
import com.example.myapplication.ui.PageViewModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_Task_1 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_1 newInstance(int index) {
        PlaceholderFragment_Task_1 fragment = new PlaceholderFragment_Task_1();
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


    Button button;
    TextView tAnswer;
    TextView textView;
    EditText editText1;
    EditText editText2;
    EditText editText3;


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_1, container, false);

        button = root.findViewById(R.id.button);
        button.setOnClickListener(oclBtn);


        textView = root.findViewById(R.id.textView2);
        textView.setOnClickListener(oclBtn);

        editText1 = root.findViewById(R.id.editText4);
        editText1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editText1.setKeyListener(DigitsKeyListener.getInstance("01234567890.,"));
        editText2 = root.findViewById(R.id.editText);
        editText2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editText2.setKeyListener(DigitsKeyListener.getInstance("01234567890.,"));
        editText3 = root.findViewById(R.id.editText3);
        editText3.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editText3.setKeyListener(DigitsKeyListener.getInstance("01234567890.,"));
        tAnswer = root.findViewById(R.id.tAnswer);


        return root;
    }

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //нажатия на кнопку "SET"e
                case R.id.button:


                    if (editText1.getText().toString().length() != 0) {
                        if (editText2.getText().toString().length() != 0) {
                            if (editText3.getText().toString().length() != 0) {
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
                    } else {
                        Toast toast = Toast.makeText(getContext(),
                                "Введите систему счисления!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    break;

                //нажатия на кнопку "Решить"
                case R.id.textView2:
                    if (textView.getText() == "1")
                        textView.setText("0");
                    else
                        textView.setText("1");
                    break;


            }
        }
    };
}