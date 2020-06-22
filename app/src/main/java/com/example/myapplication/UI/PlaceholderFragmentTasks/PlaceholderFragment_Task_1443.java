package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Instruments.Check_Input;
import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_Task_1443 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_1443 newInstance(int index) {
        // юзает фрагмент
        PlaceholderFragment_Task_1443 fragment = new PlaceholderFragment_Task_1443();
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
    private Button begin;
    private Button end;
    private Button soFarFound;
    private Button orFound;
    private Button ifThereIs;
    private Button thenReplace;
    private Button otherwiseReplace;
    private Button endIf;
    private Button endForNow;
    private TextView tAnswer;
    private EditText kod;
    private EditText countNumber;
    private EditText countNumberInWord;
    private LinearLayout list;
    private ListItem l;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_1443, container, false);


        countNumber = root.findViewById(R.id.task1443_edittext_count_numbers);
        countNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.toString().isEmpty()) {
                    list.removeAllViews();
                    return;
                }

                if (l == null)
                    l = new PlaceholderFragment_Task_1443.ListItem(Integer.parseInt(s.toString()), getContext());
                else {
                    l = null;
                    list.removeAllViews();
                    l = new PlaceholderFragment_Task_1443.ListItem(Integer.parseInt(s.toString()), getContext());
                }

            }
        });

        countNumberInWord = root.findViewById(R.id.task1443_edittext_count_numbers_in_word);
        countNumberInWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().isEmpty() || l==null) return;;

                l.setLength(Integer.parseInt(s.toString()));

            }
        });
        list = root.findViewById(R.id.task1443_list);
        // находим кнопку с которой работает
        btnAnswer = root.findViewById(R.id.task1443_btn_answer);
        btnAnswer.setOnClickListener(oclBtn);

        soFarFound = root.findViewById(R.id.task1443_btn_soFarFound);
        soFarFound.setOnClickListener(oclBtnSoFarFound);

        orFound = root.findViewById(R.id.task1443_btn_orFound);
        orFound.setOnClickListener(oclBtnOrFound);

        ifThereIs = root.findViewById(R.id.task1443_btn_ifThereIs);
        ifThereIs.setOnClickListener(oclBtnIfThereIs);

        thenReplace = root.findViewById(R.id.task1443_btn_thenReplace);
        thenReplace.setOnClickListener(oclBtnThenReplace);

        otherwiseReplace = root.findViewById(R.id.task1443_btn_otherwiseReplace);
        otherwiseReplace.setOnClickListener(oclBtnOtherwiseReplace);

        endIf = root.findViewById(R.id.task1443_btn_endIf);
        endIf.setOnClickListener(oclBtnEndIf);

        endForNow = root.findViewById(R.id.task1443_btn_endForNow);
        endForNow.setOnClickListener(oclBtnEndForNow);

        begin = root.findViewById(R.id.task1443_btn_begin);
        begin.setOnClickListener(oclBtnBegin);

        end = root.findViewById(R.id.task1443_btn_end);
        end.setOnClickListener(oclBtnEnd);

        kod = root.findViewById(R.id.task1443_edittext_code);

        tAnswer = root.findViewById(R.id.task1443_textview_answer);
        return root;
    }
    private void ToastError()
    {
        Toast toast = Toast.makeText(getContext(),
                "Количество символов должно быть менее 200", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
    private boolean flag = false;
    View.OnClickListener oclBtnSoFarFound = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            flag = false;
            if(kod.length()+15 >200) {
                ToastError();
            }
            else {
                int curPos = kod.getSelectionStart();
                String str = kod.getText().toString();
                kod.setText(kod.getText().toString().substring(0, curPos) + "ПОКА нашлось ()");
                kod.setText(kod.getText() + str.substring(curPos, str.length()));
                kod.setSelection(curPos + 14);
            }
        }
    };
    View.OnClickListener oclBtnBegin = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(kod.length()+6 >200) {
                ToastError();
            }
            else {
                int curPos = kod.getSelectionStart();
                String str = kod.getText().toString();
                kod.setText(kod.getText().toString().substring(0, curPos) + "НАЧАЛО");
                kod.setText(kod.getText() + str.substring(curPos, str.length()));
                kod.setSelection(curPos + 6);
            }
        }
    };
    View.OnClickListener oclBtnEnd = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(kod.length()+5 >200) {
                ToastError();
            }
            else {
                int curPos = kod.getSelectionStart();
                String str = kod.getText().toString();
                kod.setText(kod.getText().toString().substring(0, curPos) + "КОНЕЦ");
                kod.setText(kod.getText() + str.substring(curPos, str.length()));
                kod.setSelection(curPos + 5);
            }
        }
    };
    View.OnClickListener oclBtnOrFound = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(kod.length()+14 >200) {
                ToastError();
            }
            else {
                int curPos = kod.getSelectionStart();
                String str = kod.getText().toString();
                kod.setText(kod.getText().toString().substring(0, curPos) + "ИЛИ нашлось ()");
                kod.setText(kod.getText() + str.substring(curPos, str.length()));
                kod.setSelection(curPos + 13);
            }
        }
    };
    View.OnClickListener oclBtnIfThereIs = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(kod.length()+15 >200) {
                ToastError();
            }
            else {
                int curPos = kod.getSelectionStart();
                String str = kod.getText().toString();
                kod.setText(kod.getText().toString().substring(0, curPos) + "ЕСЛИ нашлось ()");
                kod.setText(kod.getText() + str.substring(curPos, str.length()));
                kod.setSelection(curPos + 14);
            }
        }
    };
    View.OnClickListener oclBtnThenReplace = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(kod.length()+15 >200) {
                ToastError();
            }
            else {
                int curPos = kod.getSelectionStart();
                String str = kod.getText().toString();
                kod.setText(kod.getText().toString().substring(0, curPos) + "ТО заменить (,)");
                kod.setText(kod.getText() + str.substring(curPos, str.length()));
                kod.setSelection(curPos + 13);
            }
        }
    };
    View.OnClickListener oclBtnOtherwiseReplace = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(kod.length()+18 >200) {
                ToastError();
            }
            else {
                int curPos = kod.getSelectionStart();
                String str = kod.getText().toString();
                kod.setText(kod.getText().toString().substring(0, curPos) + "ИНАЧЕ заменить (,)");
                kod.setText(kod.getText() + str.substring(curPos, str.length()));
                kod.setSelection(curPos + 16);
            }
        }
    };
    View.OnClickListener oclBtnEndIf = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(kod.length()+10 >200) {
                ToastError();
            }
            else {
                int curPos = kod.getSelectionStart();
                String str = kod.getText().toString();
                kod.setText(kod.getText().toString().substring(0, curPos) + "КОНЕЦ если");
                kod.setText(kod.getText() + str.substring(curPos, str.length()));
                kod.setSelection(curPos + 10);
            }
        }
    };
    View.OnClickListener oclBtnEndForNow = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(kod.length()+10 >200) {
                ToastError();
            }
            else {
                int curPos = kod.getSelectionStart();
                String str = kod.getText().toString();
                kod.setText(kod.getText().toString().substring(0, curPos) + "КОНЕЦ пока");
                kod.setText(kod.getText() + str.substring(curPos, str.length()));
                kod.setSelection(curPos + 10);
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
            tAnswer.setVisibility(View.VISIBLE);
        }

        private String getData() {
            String data = "100" + Constants.NEXT_LINE + "43" + Constants.NEXT_LINE;

            data += countNumber.getText().toString() + Constants.NEXT_LINE;
            data += countNumberInWord.getText().toString() + Constants.NEXT_LINE;
            data += l.toString();

            data += kod.getText().toString();
            return data;
        }

        private boolean checkData() {
            if (countNumber.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите количество цифр!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }

            if (countNumberInWord.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите количество цифр в строке!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }
            if (l.isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите количества цифр!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }
            if (kod.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите Код программы!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }

            String answer = Check_Input.CheckString(kod.getText().toString(),14);
            if(!answer.isEmpty())
            {
                Toast toast = Toast.makeText(getContext(),
                        answer, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }
            return false;
        }
    };

    public class ListItem {
        private int itemCount;
        private ArrayList<PlaceholderFragment_Task_1443.ListItem.item> listItem = new ArrayList<PlaceholderFragment_Task_1443.ListItem.item>();

        public ListItem(int n, Context context) {
            itemCount = n;

            for (int i = 0; i < 0; i++) {

            }
            for (int i = 1; i <= itemCount; i++) {
//                LayoutInflater inflater = LayoutInflater.from(context);
//                View view = inflater.inflate(idFromListItem, parent, true);
                listItem.add(new PlaceholderFragment_Task_1443.ListItem.item(i));
            }
        }

        public class item {
            public TextView number;
            public EditText word;
            public LinearLayout linearLayout;
            public int idFromListItem;

            public item(int i) {
                idFromListItem = R.layout.task10_fragment_list;

                LayoutInflater inflater = LayoutInflater.from(getContext());
                View view = inflater.inflate(idFromListItem, list, false);

                word = view.findViewById(R.id.task10_fragment_edittext_word);
                InputFilter[] filterArray = new InputFilter[1];
                filterArray[0] = new InputFilter.LengthFilter(3);
                word.setFilters(filterArray);
                number = view.findViewById(R.id.task10_fragment_text_number);
                number.setText(String.valueOf(i));
                list.addView(view);
            }

        }
        public boolean setLength(int n) {
            for (PlaceholderFragment_Task_1443.ListItem.item i : listItem)
                i.word.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(n)});

            return false;
        }
        @NonNull
        @Override
        public String toString() {
            String s = "";
            for (item i : listItem) {

                if (i != listItem.get(itemCount - 1))
                    s += i.word.getText().toString() + "\\";
                else
                    s += i.word.getText().toString() + Constants.NEXT_LINE;

            }
            return s;
        }
        public boolean isEmpty() {
            for (PlaceholderFragment_Task_1443.ListItem.item i : listItem) {
                if (i.word.getText().toString().isEmpty()) return true;
                else if(Integer.valueOf(i.word.getText().toString()) == 0) return true;
            }

            return false;
        }
    }
}

