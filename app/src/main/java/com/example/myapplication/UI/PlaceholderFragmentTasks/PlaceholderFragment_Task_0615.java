package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
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
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_Task_0615 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0615 newInstance(int index) {
        PlaceholderFragment_Task_0615 fragment = new PlaceholderFragment_Task_0615();
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
    private EditText num3;
    private EditText num4;

    private TextView answertext;
    private Button answerButton;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0615, container, false);

        num3 = root.findViewById(R.id.task0615_edittext_biuld_num);
        num4 = root.findViewById(R.id.task0615_editext_answer_num);
        answerButton = root.findViewById(R.id.task0615_btn_answer);

       answerButton.setOnClickListener(oclBtn);

        return root;
    }

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if( checkData()) return;

            String data = getData();

            answertext.setText(data);
            answertext.setVisibility(View.VISIBLE);

        }

        private boolean checkData() {
            if (num1.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите число!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }

            if (num2.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите новое число!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }

            if (num3.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите  число!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }
            if (num4.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите число!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }

            return false;
        }

        private String getData () {
            String data = "100" + "\n\r" + "15" + "\n\r";

            data += num1.getText().toString() + "\n\r";
            data += num2.getText().toString() + "\n\r";
            data += num3.getText().toString() + "\n\r";
            data += num4.getText().toString();

            return data;
        }
    };
}