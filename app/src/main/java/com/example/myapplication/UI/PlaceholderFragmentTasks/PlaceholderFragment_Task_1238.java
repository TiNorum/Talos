package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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
public class PlaceholderFragment_Task_1238 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_1238 newInstance(int index) {
        PlaceholderFragment_Task_1238 fragment = new PlaceholderFragment_Task_1238();
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


    private MaterialEditText firstIP;
    private MaterialEditText secondIP;
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
        View root = inflater.inflate(R.layout.fragment_task_1238, container, false);


        firstIP = root.findViewById(R.id.task1238_edittext_first_IP);
        secondIP = root.findViewById(R.id.task1238_edittext_second_IP);

        firstByte = root.findViewById(R.id.task1238_rbtn_first_byte);
        secondByte = root.findViewById(R.id.task1238_rbtn_second_byte);
        thirdByte = root.findViewById(R.id.task1238_rbtn_third_byte);
        fourthByte = root.findViewById(R.id.task1238_rbtn_fourth_byte);

        max = root.findViewById(R.id.task1238_rbtn_max);
        min = root.findViewById(R.id.task1238_rbtn_min);

        tAnswer = root.findViewById(R.id.task1238_text_answer);

        bAnswer = root.findViewById(R.id.task1238_btn_answer);
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
            if (firstIP.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите IP!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }

            if (secondIP.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите IP!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }


            if (!firstByte.isChecked() && !secondByte.isChecked() && !thirdByte.isChecked() && !fourthByte.isChecked()) {
                Toast toast = Toast.makeText(getContext(),
                        "Выберите байт маски!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }


            if (!max.isChecked() && !min.isChecked()) {
                Toast toast = Toast.makeText(getContext(),
                        "Выберите наибольший/наименьший байт!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }

            return false;
        }


        private String getData() {
            String data = "100" + "\n\r" + "38" + "\n\r";


            data += firstIP.getText().toString() + "\n\r";
            data += secondIP.getText().toString() + "\n\r";


            if (firstByte.isChecked())
                data += '1' + "\n\r";
            else if (secondByte.isChecked())
                data += '2' + "\n\r";
            else if (thirdByte.isChecked())
                data += '3' + "\n\r";
            else
                data += '4' + "\n\r";

            if (min.isChecked())
                data += '0' + "\n\r";
            else
                data += '1' + "\n\r";

            return data;
        }
    };
}