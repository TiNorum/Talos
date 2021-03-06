package com.example.myapplication.UI.PlaceholderFragmentTasks.Task4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.Instruments.ShowToast;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;


/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_Task_0409 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0409 newInstance(int index) {
        PlaceholderFragment_Task_0409 fragment = new PlaceholderFragment_Task_0409();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 0;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }


    private EditText count_chars;

    private Button btn_answer;
    private TextView text_answer;
    private LinearLayout linearLayout;
    private ArrayList<MaterialEditText> listCode = new ArrayList<MaterialEditText>();

    public View root;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, final ViewGroup container,
            Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_task_0512, container, false);

        btn_answer = root.findViewById(R.id.btn_answer);
        btn_answer.setOnClickListener(oclBtn);

        linearLayout = root.findViewById(R.id.linear_code);
        text_answer = root.findViewById(R.id.text_answer);
        count_chars = root.findViewById(R.id.edittext_count_chars);

        count_chars.addTextChangedListener(new TextWatcher() {
            @SuppressLint("WrongConstant")
            @Override
            public void afterTextChanged(Editable s) {

                if (s.toString().isEmpty()) return;


                int countNum = Integer.parseInt(s.toString());


                for (int i = listCode.size(); listCode.size() <= countNum; i++) {

                    MaterialEditText editText = new MaterialEditText(getContext());

                    editText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    editText.setFloatingLabel(MaterialEditText.FLOATING_LABEL_HIGHLIGHT);
                    editText.setFloatingLabelText("Буква #" + (i + 1));
                    editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                    editText.setHint("Введите код");
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10), new InputFilter() {
                        @Override
                        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                            StringBuilder s = new StringBuilder(source.toString());

                            for(int i = 0; i<s.toString().length(); i++)
                            {
                                if(s.charAt(i) != '0' && s.charAt(i) != '1')
                                {
                                    s.deleteCharAt(i);
                                    i--;
                                }
                            }

                            return s.toString();
                        }
                    }});

                    linearLayout.addView(editText);
                    listCode.add(editText);

                }

                while (listCode.size() != countNum) {
                    linearLayout.removeView(listCode.get(listCode.size() - 1));
                    listCode.remove(listCode.get(listCode.size() - 1));
                }


            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });


        return root;
    }


    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (checkData()) return;

            String data = getData();

            text_answer.setVisibility(View.VISIBLE);
            text_answer.setText(data);

        }

        private boolean checkData() {

            if (count_chars.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите количество известных букв!");
                return true;
            }

            for (MaterialEditText element : listCode)
                if (element.getText().toString().isEmpty()) {
                    ShowToast.showToast(getContext(), "Введите все коды!");
                    return true;
                }


            return false;
        }


        private String getData() {

            String data = "100" + Constants.NEXT_LINE + 9 + Constants.NEXT_LINE;

            data += count_chars.getText().toString();

            for (EditText editText : listCode)
                data += Constants.NEXT_LINE + listCode.toString();

            return data;
        }

    };


}