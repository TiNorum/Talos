package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Instruments.ShowToast;
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


    private TextView answertext;
    private Button answerButton;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0615, container, false);

        num1 = root.findViewById(R.id.task0615_edittext_biuld_num);
        num2 = root.findViewById(R.id.task0615_editext_answer_num);
        answerButton = root.findViewById(R.id.task0615_btn_answer);

        answerButton.setOnClickListener(oclBtn);

        answertext = root.findViewById(R.id.task0615_text_answer);
        return root;
    }

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (checkData()) return;

            String data = getData();

            answertext.setText(data);
            answertext.setVisibility(View.VISIBLE);

        }

        private boolean checkData() {
            if (num1.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Укажите такое наименьшее число (N или R)");
                return true;
            }

            if (num2.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Укажите число в ответе!");
                return true;
            }

            return false;
        }

        private String getData() {
            String data = "100" + "\n\r" + "15" + "\n\r";

            data += num1.getText().toString() + "\n\r";
            data += num2.getText().toString();

            return data;
        }
    };
}