package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.content.Context;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;

import static android.text.InputType.TYPE_CLASS_NUMBER;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_Task_0410 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0410 newInstance(int index) {
        PlaceholderFragment_Task_0410 fragment = new PlaceholderFragment_Task_0410();
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


    private MaterialEditText countRowFirst;
    private MaterialEditText countRowSecond;
    private MaterialEditText findName;
    private TableItem firstTableItem;
    private TableItem secondTableItem;
    private Button bAnswer;
    private TextView tAnswer;
    private LinearLayout firstTable;
    private LinearLayout secondTable;
    private RadioGroup radioGroup;
    private RadioButton rb_1;
    private RadioButton rb_2;
    private RadioButton rb_3;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0410, container, false);

        firstTable = root.findViewById(R.id.task0410_table_1);
        secondTable = root.findViewById(R.id.task0410_table_2);
        findName = root.findViewById(R.id.task0410_edittext_name);
        radioGroup = root.findViewById(R.id.task0410_rg);
        rb_1 = root.findViewById(R.id.task0410_rb_1);
        rb_2 = root.findViewById(R.id.task0410_rb_2);
        rb_3 = root.findViewById(R.id.task0410_rb_3);

        countRowFirst = root.findViewById(R.id.task0410_edittext_count_row_first_table);
        countRowFirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.toString().isEmpty()) {

                    if (firstTableItem == null) return;

                    for (TableItem.item item : firstTableItem.listItem)
                        firstTable.removeView(item.view);

                    firstTable.setVisibility(View.GONE);

                    return;
                }
                if (Integer.parseInt(s.toString()) > 15) return;

                
                firstTable.setVisibility(View.VISIBLE);

                if (firstTableItem == null)
                    firstTableItem = new TableItem(Integer.parseInt(s.toString()), getContext(), firstTable, 3);
                else {
                    for (TableItem.item item : firstTableItem.listItem)
                        firstTable.removeView(item.view);

                    firstTableItem = null;

                    firstTableItem = new TableItem(Integer.parseInt(s.toString()), getContext(), firstTable, 3);
                }

            }
        });


        countRowSecond = root.findViewById(R.id.task0410_edittext_count_row_second_table);
        countRowSecond.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.toString().isEmpty()) {

                    if (secondTableItem == null) return;

                    for (TableItem.item item : secondTableItem.listItem)
                        secondTable.removeView(item.view);

                    secondTable.setVisibility(View.GONE);

                    return;
                }
                if (Integer.parseInt(s.toString()) > 15) return;

                secondTable.setVisibility(View.VISIBLE);

                if (secondTableItem == null)
                    secondTableItem = new TableItem(Integer.parseInt(s.toString()), getContext(), secondTable, 2);
                else {

                    for (TableItem.item item : secondTableItem.listItem)
                        secondTable.removeView(item.view);

                    secondTableItem = null;
                    secondTableItem = new TableItem(Integer.parseInt(s.toString()), getContext(), secondTable, 2);
                }

            }
        });

        tAnswer = root.findViewById(R.id.task0410_text_answer);

        bAnswer = root.findViewById(R.id.task0410_btn_answer);
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
            if (countRowFirst.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите количество строк в первой таблице!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return true;
            }

            if (countRowSecond.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите количество строк во второй таблице!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return true;
            }

            if (firstTableItem.isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Заполнице первую таблицу!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return true;
            }

            if (secondTableItem.isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Заполните вторую таблицу!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return true;
            }
            if (radioGroup.getCheckedRadioButtonId() == -1) {
                Toast toast = Toast.makeText(getContext(),
                        "Выберите родственника!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return true;
            }

            if (findName.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите имя!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return true;
            }
            return false;
        }


        private String getData() {

            String data = "100" + Constants.NEXT_LINE + 10 + Constants.NEXT_LINE;

            data += countRowFirst.getText().toString() + Constants.NEXT_LINE;
            data += countRowSecond.getText().toString() + Constants.NEXT_LINE;
            data += firstTableItem.toString();
            data += secondTableItem.toString();
            data += rb_1.isChecked() ? 1 :
                    rb_2.isChecked() ? 2 :
                            rb_3.isChecked() ? 3 : 4;

            data += Constants.NEXT_LINE + findName.getText().toString();
            return data;
        }
    };


    public class TableItem {
        private int itemCount;
        public ArrayList<item> listItem = new ArrayList<item>();
        int count_col;

        public TableItem(int n, Context context, LinearLayout list, int col) {
            itemCount = n;
            count_col = col;
            for (int i = 0; i < 0; i++) {

            }
            for (int i = 1; i <= itemCount; i++) {
                listItem.add(new item(list, col));
            }
        }

        public class item {

            public EditText col_1;
            public EditText col_2;
            public EditText col_3;
            public int idFromListItem;
            View view;


            public item(LinearLayout linearLayout, int col) {
                idFromListItem = R.layout.task_0410_fragment_table;


                LayoutInflater inflater = LayoutInflater.from(getContext());
                view = inflater.inflate(idFromListItem, linearLayout, false);

                col_1 = view.findViewById(R.id.task04_edittext_table_1);
                col_2 = view.findViewById(R.id.task04_edittext_table_2);

                col_3 = view.findViewById(R.id.task04_edittext_table_3);
                if (col == 2) {
                    col_2.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
                    col_2.setInputType(TYPE_CLASS_NUMBER);
                    col_3.setVisibility(View.GONE);
                }

                linearLayout.addView(view);
            }


        }

        public boolean isEmpty() {
            for (item i : listItem) {
                if (i.col_1.getText().toString().isEmpty() || i.col_2.getText().toString().isEmpty() || (i.col_3.getText().toString().isEmpty() && count_col == 3))
                    return true;

            }
            return false;
        }

        @NonNull
        @Override
        public String toString() {
            String s = "";
            for (item i : listItem) {

                s += i.col_1.getText().toString() + "\\";
                s += i.col_2.getText().toString();
                if (count_col == 3)
                    s += "\\" + i.col_3.getText().toString() + Constants.NEXT_LINE;
                else
                    s += Constants.NEXT_LINE;
            }


            return s;
        }
    }

}


