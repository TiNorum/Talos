package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.Instruments.ShowToast;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;
import com.rengwuxian.materialedittext.MaterialEditText;


/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_Task_1031 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_1031 newInstance(int index) {
        PlaceholderFragment_Task_1031 fragment = new PlaceholderFragment_Task_1031();
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


    private MaterialEditText text1;
    private MaterialEditText text2;
    private MaterialEditText symbols;
    private MaterialEditText countSymbolInWord;
    private Spinner spinnerFirstChar;
    private Spinner spinnerEndChar;
    private Button bAnswer;
    private TextView tAnswer;
    private String[] chars;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_1031, container, false);


        countSymbolInWord = root.findViewById(R.id.task1031_edittext_count_symbols_in_word);
        symbols = root.findViewById(R.id.task1031_edittext_symbols);

        spinnerFirstChar = root.findViewById(R.id.task1031_spinner_first_char);
        spinnerFirstChar.setOnItemSelectedListener(onItemSelectedListener);

        spinnerEndChar = root.findViewById(R.id.task1031_spinner_last_char);
        spinnerEndChar.setOnItemSelectedListener(onItemSelectedListener);


        tAnswer = root.findViewById(R.id.task1031_text_answer);

        text1 = root.findViewById(R.id.task1031_edittext_first_char);
        text2 = root.findViewById(R.id.task1031_edittext_last_char);

        bAnswer = root.findViewById(R.id.task1031_btn_answer);
        bAnswer.setOnClickListener(oclBtn);


        return root;
    }

    AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (id == 3) {
                if (parent.getId() == R.id.task1031_spinner_first_char) {
                    text1.setVisibility(View.VISIBLE);
                    text1.setText("");

                } else {
                    text2.setVisibility(View.VISIBLE);
                    text2.setText("");
                }
            } else {
                if (parent.getId() == R.id.task1031_spinner_first_char) {
                    text1.setVisibility(View.GONE);
                    text1.setText("");

                } else {
                    text2.setVisibility(View.GONE);
                    text2.setText("");
                }
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (checkData()) return;

            String data = getData();


            tAnswer.setVisibility(View.VISIBLE);
            tAnswer.setText(data);

        }

        private boolean checkData() {
            if (countSymbolInWord.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(),"Введите количество символов!");
                return true;
            }

            if (symbols.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(),"Введите символы!");
                return true;
            }

            if (spinnerFirstChar.getSelectedItemId() == 3 && text1.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(),"Введите букву с которой начинается слово!");
                return true;
            }

            if (spinnerEndChar.getSelectedItemId() == 3 && text2.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(),"Введите букву с которой заканчивается слово!");
                return true;
            }
            return false;
        }



        private String getData() {

            int num;

            if (spinnerFirstChar.getSelectedItemId() == 0 && spinnerEndChar.getSelectedItemId() == 0)
                num = 31;
            else if (spinnerFirstChar.getSelectedItemId() != 0 && spinnerEndChar.getSelectedItemId() == 0)
                num = 32;
            else if (spinnerFirstChar.getSelectedItemId() == 0 && spinnerEndChar.getSelectedItemId() != 0)
                num = 33;
            else
                num = 34;

            String data = "100" + Constants.NEXT_LINE + num + Constants.NEXT_LINE;

            data += countSymbolInWord.getText().toString() + Constants.NEXT_LINE;
            data += symbols.getText().toString() + Constants.NEXT_LINE;

            //ограничение первой буквы
            if (num == 32) {
                if (spinnerFirstChar.getSelectedItemId() == 1)
                    data += '0';// согласная
                else if (spinnerFirstChar.getSelectedItemId() == 2)
                    data += '1';//  гласная
                else
                    data += text1.getText().toString(); // буква/буквы
            }

            //ограничение последней буквы
            if (num == 33) {
                if (spinnerEndChar.getSelectedItemId() == 1)
                    data += '0';// согласная
                else if (spinnerEndChar.getSelectedItemId() == 2)
                    data += '1';//  гласная
                else
                    data += text2.getText().toString(); // буква/буквы
            }

            if (num == 34) {
                if (spinnerFirstChar.getSelectedItemId() == 1)
                    data += '0';// согласная
                else if (spinnerFirstChar.getSelectedItemId() == 2)
                    data += '1';//  гласная
                else
                    data += text1.getText().toString(); // буква/буквы
                data += Constants.NEXT_LINE;

                if (spinnerEndChar.getSelectedItemId() == 1)
                    data += '0';// согласная
                else if (spinnerEndChar.getSelectedItemId() == 2)
                    data += '1';//  гласная
                else
                    data += text2.getText().toString(); // буква/буквы
            }
            return data;
        }
    };


}


