package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;

public class PlaceholderFragment_Task_0925 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0925 newInstance(int index) {
        PlaceholderFragment_Task_0925 fragment = new PlaceholderFragment_Task_0925();
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

    private EditText numberOfColorsFile;
    private EditText numberOfColorsFormat;
    private EditText fileChange;
    private TextView answertext;
    private Button btOtvet;
    private RadioButton decrease;
    private RadioButton increase;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0925, container, false);

        numberOfColorsFile = root.findViewById(R.id.task0925_edittext_numberOfColorsFile);
        numberOfColorsFormat = root.findViewById(R.id.task0925_edittext_numberOfColorsFormat);
        fileChange = root.findViewById(R.id.task0925_edittext_fileChange);
        answertext = root.findViewById(R.id.task0925_textview_answer);
        btOtvet = root.findViewById(R.id.task0925_btn_answer);
        btOtvet.setOnClickListener(oclBtn);

        decrease = root.findViewById(R.id.task0925_rbtn_decrease);
        increase = root.findViewById(R.id.task0925_rbtn_increase);

        return root;
    }


    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            if (checkData()) return;

            String data = getData();

            Toast toast = Toast.makeText(getContext(),
                    data, Toast.LENGTH_SHORT);
            toast.show();
            //отправка на сервер
            //*****************
            //*****************
            ///////////////////


            //answertext.setVisibility(View.VISIBLE);
        }

        private String getData() {
            String data = "100" + Constants.NEXT_LINE + "24" + Constants.NEXT_LINE;

            data += numberOfColorsFile.getText().toString() + Constants.NEXT_LINE;
            data += numberOfColorsFormat.getText().toString() + Constants.NEXT_LINE;

            if (decrease.isChecked()){
                data += "1" + Constants.NEXT_LINE;
            } else
                data += "2" + Constants.NEXT_LINE;
            data += fileChange.getText().toString() + Constants.NEXT_LINE;

            return data;
        }

        private boolean checkData() {
            if (numberOfColorsFile.getText().toString().isEmpty() || Integer.valueOf(numberOfColorsFile.getText().toString()) == 0) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите количество цветов графического файла!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }
            if (numberOfColorsFormat.getText().toString().isEmpty()  || Integer.valueOf(numberOfColorsFormat.getText().toString()) == 0) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите количество цветов формата!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return true;
            }
            if (!(decrease.isChecked() || increase.isChecked())) {
                Toast toast = Toast.makeText(getContext(),
                        "Укажите как изменится файл!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }
            if (fileChange.getText().toString().isEmpty()  || Integer.valueOf(fileChange.getText().toString()) == 0) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите на сколько изменился файл (Кбайт)!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return true;
            }
            return false;
        }
    };
}



