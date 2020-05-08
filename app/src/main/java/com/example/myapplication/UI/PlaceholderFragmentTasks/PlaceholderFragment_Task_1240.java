package com.example.myapplication.UI.PlaceholderFragmentTasks;

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
public class PlaceholderFragment_Task_1240 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_1240 newInstance(int index) {
        PlaceholderFragment_Task_1240 fragment = new PlaceholderFragment_Task_1240();
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


    private MaterialEditText IP;
    private MaterialEditText mask;


    private Button bAnswer;
    private TextView tAnswer;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_1240, container, false);


        IP = root.findViewById(R.id.task1240_edittext_IP);
        mask = root.findViewById(R.id.task1240_edittext_address);

        tAnswer = root.findViewById(R.id.task1240_text_answer);

        bAnswer = root.findViewById(R.id.task1240_btn_answer);
       bAnswer.setOnClickListener(oclBtn);

        return root;
    }


    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (checkData()) return;

            String data = getData();

            tAnswer.setVisibility(View.VISIBLE);
            tAnswer.setText(data);

        }

        private boolean checkData() {
            if (IP.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите IP!");
                return true;
            }
            if(Check_Input.Cheсk_IP(IP.getText().toString()))
            {
                ShowToast.showToast(getContext(), "Неправильный IP!");
                return true;
            }

            if (mask.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите маску сети!");
                return true;
            }

            if(Check_Input.Cheсk_IP(mask.getText().toString()))
            {

                ShowToast.showToast(getContext(), "Неправильный IP!");

                return true;
            }

            return false;
        }


        private String getData() {
            String data = "100" + "\n\r" + "40" + "\n\r";

            data += IP.getText().toString() + "\n\r";
            data += mask.getText().toString();

            return data;
        }
    };
}