package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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
public class PlaceholderFragment_Task_0617 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0617 newInstance(int index) {
        PlaceholderFragment_Task_0617 fragment = new PlaceholderFragment_Task_0617();
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


    private EditText firstCommand;
    private EditText secondCommand;
    private EditText thirdCommand;
    private MaterialEditText countCommands;
    private MaterialEditText firstNumber;
    private MaterialEditText secondNumber;
    private RadioButton twoCmd;
    private RadioButton threeCmd;
    private RadioGroup cmd;


    private Button bAnswer;
    private TextView tAnswer;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0617, container, false);

        firstCommand = root.findViewById(R.id.task0617_edittext_first_command);
        secondCommand = root.findViewById(R.id.task0617_edittext_second_command);
        thirdCommand = root.findViewById(R.id.task0617_edittext_third_command);

        countCommands = root.findViewById(R.id.task0617_edittext_count_commands);

        firstNumber = root.findViewById(R.id.task0617_edittext_first_number);
        secondNumber = root.findViewById(R.id.task0617_edittext_second_number);

        cmd = root.findViewById(R.id.task0617_rg_count_command);
        cmd.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.task0617_rbtn_three_command) {
                thirdCommand.setVisibility(View.VISIBLE);
                root.findViewById(R.id.task0617_text_third_command).setVisibility(View.VISIBLE);
            } else {

                thirdCommand.setVisibility(View.GONE);
                root.findViewById(R.id.task0617_text_third_command).setVisibility(View.GONE);

            }

        });

        tAnswer = root.findViewById(R.id.task0617_text_answer);
        threeCmd = root.findViewById(R.id.task0617_rbtn_three_command);
        twoCmd = root.findViewById(R.id.task0617_rbtn_two_command);


        bAnswer = root.findViewById(R.id.task0617_btn_answer);
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
            if (firstCommand.getText().toString().isEmpty() || secondCommand.getText().toString().isEmpty() || (thirdCommand.getVisibility()==View.VISIBLE && thirdCommand.getText().toString().isEmpty())) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите действия с командами!", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            }

            if (countCommands.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите количество команд!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);

                toast.show();
                return true;
            }

            if (firstNumber.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите исходное число!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }

            if (secondCommand.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите конечное число!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }

            if (!threeCmd.isChecked() && !twoCmd.isChecked()) {
                Toast toast = Toast.makeText(getContext(),
                        "Выберите количество команд!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }

            return false;
        }


        private String getData() {
            String data = "100" + "\n\r" + "17" + "\n\r";

            if (twoCmd.isChecked())
                data += '0' + "\n\r";
            else
                data += '1' + "\n\r";

            data += firstCommand.getText().toString() + '\\';
            data += secondCommand.getText().toString();


            if (thirdCommand.getVisibility() == View.VISIBLE)
                data += '\\' + secondCommand.getText().toString();
            data += "\n\r";

            data += countCommands.getText().toString() + "\n\r";
            data += firstNumber.getText().toString() + "\n\r";
            data += secondNumber.getText().toString() + "\n\r";

            return data;
        }
    };
}