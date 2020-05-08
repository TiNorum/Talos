package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
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
public class PlaceholderFragment_Task_1239 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_1239 newInstance(int index) {
        PlaceholderFragment_Task_1239 fragment = new PlaceholderFragment_Task_1239();
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
    private MaterialEditText address;
    private RadioButton firstByte;
    private RadioButton secondByte;
    private RadioButton thirdByte;
    private RadioButton fourthByte;
    private RadioButton max;
    private RadioButton min;


    private Button bAnswer;
    private TextView tAnswer;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_1239, container, false);


        IP = root.findViewById(R.id.task1239_edittext_IP);
        address = root.findViewById(R.id.task1239_edittext_address);

        firstByte = root.findViewById(R.id.task1239_rbtn_first_byte);
        secondByte = root.findViewById(R.id.task1239_rbtn_second_byte);
        thirdByte = root.findViewById(R.id.task1239_rbtn_third_byte);
        fourthByte = root.findViewById(R.id.task1239_rbtn_fourth_byte);

        max = root.findViewById(R.id.task1239_rbtn_max);
        min = root.findViewById(R.id.task1239_rbtn_min);

        tAnswer = root.findViewById(R.id.task1239_text_answer);

        bAnswer = root.findViewById(R.id.task1239_btn_answer);
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

            if (Check_Input.Cheсk_IP(IP.getText().toString())) {
                ShowToast.showToast(getContext(), "Неправильный IP!");
                return true;
            }
            if (address.getText().toString().isEmpty()) {

                ShowToast.showToast(getContext(), "Введите адрес сети!");
                return true;
            }
            if (Check_Input.Cheсk_IP(address.getText().toString())) {
                ShowToast.showToast(getContext(), "Неправильный адрес!");
                return true;
            }

            if (!firstByte.isChecked() && !secondByte.isChecked() && !thirdByte.isChecked() && !fourthByte.isChecked()) {
                ShowToast.showToast(getContext(), "Выберите байт маски!");
                return true;
            }


            if (!max.isChecked() && !min.isChecked()) {
                ShowToast.showToast(getContext(), "Выберите наибольший/наименьший байт!");
                return true;
            }

            return false;
        }


        private String getData() {
            String data = "100" + "\n\r" + "39" + "\n\r";


            data += IP.getText().toString() + "\n\r";
            data += address.getText().toString() + "\n\r";


            if (firstByte.isChecked())
                data += '1' + "\n\r";
            else if (secondByte.isChecked())
                data += '2' + "\n\r";
            else if (thirdByte.isChecked())
                data += '3' + "\n\r";
            else
                data += '4' + "\n\r";

            if (min.isChecked())
                data += '0';
            else
                data += '1';

            return data;
        }
    };
}