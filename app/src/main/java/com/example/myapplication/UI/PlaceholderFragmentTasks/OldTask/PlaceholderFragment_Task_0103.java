package com.example.myapplication.UI.PlaceholderFragmentTasks.OldTask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Instruments.Check_Input;
import com.example.myapplication.Instruments.ShowToast;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_Task_0103 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0103 newInstance(int index) {
        PlaceholderFragment_Task_0103 fragment = new PlaceholderFragment_Task_0103();
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
    private TextView tAnswer;
    private MaterialEditText equation;


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile_redact, container, false);

//        btnAnswer = root.findViewById(R.id.task0103_btn_answer);
//        btnAnswer.setOnClickListener(oclBtn);
//
//        tAnswer = root.findViewById(R.id.task0103_text_answer);
//        equation = root.findViewById(R.id.task0103_edittext_equation);


        return root;
    }

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

                if( checkData()) return;

                String data = getData();

                tAnswer.setText(data);
                tAnswer.setVisibility(View.VISIBLE);

        }

        private boolean checkData() {
            if (equation.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите уравнение!");
                return true;
            }

            if (!Check_Input.Check_Equation_Number2(equation.getText().toString())) {
                ShowToast.showToast(getContext(), "Проверьте уравнение!");
                return true;
            }


            return false;
        }

        private String getData() {
            String data = "100" + "\n\r" + "3" + "\n\r";

            data += equation.getText().toString();

            return data;
        }


    };
}