package com.example.myapplication.UI.PlaceholderFragmentTasks.Task12;

import android.os.Bundle;
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
import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.Instruments.ShowToast;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;

import java.util.HashMap;
import java.util.Map;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_Task_1224 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_1224 newInstance(int index) {
        // юзает фрагмент
        PlaceholderFragment_Task_1224 fragment = new PlaceholderFragment_Task_1224();
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

    private Button button_answer;
    private Button begin;
    private Button end;
    private Button soFarFound;
    private Button orFound;
    private Button ifThereIs;
    private Button thenReplace;
    private Button otherwiseReplace;
    private Button endIf;
    private Button endForNow;
    private TextView text_answer;
    private EditText code;
    private EditText string_numbers;
    private Map<Integer, String> string_ = new HashMap<Integer, String>();

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_1443, container, false);

        string_numbers = root.findViewById(R.id.edittext_count_numbers);


        // находим кнопку с которой работает
        button_answer = root.findViewById(R.id.button_answer);
        button_answer.setOnClickListener(oclBtn);

        soFarFound = root.findViewById(R.id.button_soFarFound);
        soFarFound.setOnClickListener(ocl_btn_code);

        orFound = root.findViewById(R.id.button_orFound);
        orFound.setOnClickListener(ocl_btn_code);

        ifThereIs = root.findViewById(R.id.button_ifThereIs);
        ifThereIs.setOnClickListener(ocl_btn_code);

        thenReplace = root.findViewById(R.id.button_thenReplace);
        thenReplace.setOnClickListener(ocl_btn_code);

        otherwiseReplace = root.findViewById(R.id.button_otherwiseReplace);
        otherwiseReplace.setOnClickListener(ocl_btn_code);

        endIf = root.findViewById(R.id.button_endIf);
        endIf.setOnClickListener(ocl_btn_code);

        endForNow = root.findViewById(R.id.button_endForNow);
        endForNow.setOnClickListener(ocl_btn_code);

        begin = root.findViewById(R.id.button_begin);
        begin.setOnClickListener(ocl_btn_code);

        end = root.findViewById(R.id.button_end);
        end.setOnClickListener(ocl_btn_code);

        code = root.findViewById(R.id.task1443_edittext_code);

        text_answer = root.findViewById(R.id.textview_answer);

        string_.put(R.id.button_soFarFound, "\nПОКА нашлось ()");
        string_.put(R.id.button_ifThereIs, "\nЕСЛИ нашлось ()");
        string_.put(R.id.button_orFound, "ИЛИ нашлось ()");
        string_.put(R.id.button_thenReplace, "ТО заменить (,)");
        string_.put(R.id.button_otherwiseReplace, "ИНАЧЕ заменить (,)");
        string_.put(R.id.button_endIf, "КОНЕЦ если");
        string_.put(R.id.button_endForNow, "КОНЕЦ пока");
        string_.put(R.id.button_begin, "НАЧАЛО\n");
        string_.put(R.id.button_end, "\nКОНЕЦ");

        return root;
    }


    View.OnClickListener ocl_btn_code = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            StringBuilder stringBuilder = new StringBuilder(""+code.getText());

            if (code.length() + string_.get(v.getId()).length() < 200) {
                int curPos = code.getSelectionStart();
                stringBuilder.insert(curPos,string_.get(v.getId()));

                code.setText(stringBuilder);
                code.setSelection(curPos + string_.get(v.getId()).length());
            }
        }
    };


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
            text_answer.setVisibility(View.VISIBLE);
        }

        private String getData() {
            String data = "100" + Constants.NEXT_LINE + "43" + Constants.NEXT_LINE;

            data += string_numbers.getText().toString() + Constants.NEXT_LINE;

            data += code.getText().toString();
            return data;
        }

        private boolean checkData() {
            if (string_numbers.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите количество цифр!");
                return true;
            }

            if (code.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите Код программы!");
                return true;
            }

            String answer = Check_Input.CheckString(code.getText().toString(), 14);
            if (!answer.isEmpty()) {
                ShowToast.showToast(getContext(), answer);
                return true;
            }
            return false;
        }
    };

}

