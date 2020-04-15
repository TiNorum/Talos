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

import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;

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
    private TableItem firstTableItem;
    private TableItem secondItemItem;
    private Button bAnswer;
    private TextView tAnswer;
    private LinearLayout firstTable;
    private LinearLayout secondTable;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0410, container, false);

        firstTable = root.findViewById(R.id.task0410_table_1);
        secondTable = root.findViewById(R.id.task0410_table_2);

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
                    for (TableItem.item item : firstTableItem.listItem)
                        firstTable.removeView(item.view);
                    return;
                }

                if (firstTableItem == null)
                    firstTableItem = new TableItem(Integer.parseInt(s.toString()), getContext(), firstTable);
                else {
                    for (TableItem.item item : firstTableItem.listItem)
                        firstTable.removeView(item.view);

                    firstTableItem = null;

                    firstTableItem = new TableItem(Integer.parseInt(s.toString()), getContext(), firstTable);
                }

            }
        });


        countRowSecond= root.findViewById(R.id.task0410_edittext_count_row_second_table);
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
                    for (TableItem.item item : secondItemItem.listItem)
                        secondTable.removeView(item.view);
                    secondTable.setVisibility(View.GONE);
                    return;
                }
                secondTable.setVisibility(View.VISIBLE);
                if (secondItemItem == null)
                    secondItemItem = new TableItem(Integer.parseInt(s.toString()), getContext(), secondTable);
                else {

                    for (TableItem.item item : secondItemItem.listItem)
                        secondTable.removeView(item.view);

                    secondItemItem = null;
                    secondItemItem = new TableItem(Integer.parseInt(s.toString()), getContext(), secondTable);
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

//            if (checkData()) return;

            String data = getData();

            tAnswer.setVisibility(View.VISIBLE);
            tAnswer.setText(data);

        }

//        private boolean checkData() {
//            if (countFile.getText().toString().isEmpty()) {
//                Toast toast = Toast.makeText(getContext(),
//                        "Введите количество символов!", Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.CENTER, 0, 0);
//                toast.show();
//                return true;
//            }
//
//            if (countMask.getText().toString().isEmpty()) {
//                Toast toast = Toast.makeText(getContext(),
//                        "Введите количество масок!", Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.CENTER, 0, 0);
//                toast.show();
//                return true;
//            }
//
//            if (files.isEmpty()) {
//                Toast toast = Toast.makeText(getContext(),
//                        "Введите назвайния файлов!", Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.CENTER, 0, 0);
//                toast.show();
//                return true;
//            }
//
//            if (masks.isEmpty()) {
//                Toast toast = Toast.makeText(getContext(),
//                        "Введите маски!", Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.CENTER, 0, 0);
//                toast.show();
//                return true;
//            }
//            return false;
//        }


        private String getData() {

            String data = "100" + Constants.NEXT_LINE + 10 + Constants.NEXT_LINE;

//            data += countFile.getText().toString() + Constants.NEXT_LINE;
//
//            data += files.toString() + Constants.NEXT_LINE;
//            data += masks.toString();

            return data;
        }
    };


    public class TableItem {
        private int itemCount;
        public ArrayList<item> listItem = new ArrayList<item>();

        public TableItem(int n, Context context, LinearLayout list) {
            itemCount = n;

            for (int i = 0; i < 0; i++) {

            }
            for (int i = 1; i <= itemCount; i++) {
                listItem.add(new item(i, list));
            }
        }

        public class item {

            public EditText id;
            public EditText name;
            public EditText sex;
            public int idFromListItem;
            View view;

            public item(int i, LinearLayout linearLayout) {
                idFromListItem = R.layout.task_0410_fragment_table;

                LayoutInflater inflater = LayoutInflater.from(getContext());
                view = inflater.inflate(idFromListItem, linearLayout, false);

                id = view.findViewById(R.id.task0408_edittext_table_1);
                id = view.findViewById(R.id.task0408_edittext_table_2);
                id = view.findViewById(R.id.task0408_edittext_table_3);

                linearLayout.addView(view);
            }


        }

        public boolean isEmpty() {
            for (item i : listItem) {
                if (i.id.getText().toString().isEmpty() || i.name.getText().toString().isEmpty() || i.sex.getText().toString().isEmpty())
                    return true;

            }
            return false;
        }

        @NonNull
        @Override
        public String toString() {
            String s = "";
//            for (item i : listItem) {
//
//                if (i != listItem.get(itemCount - 1))
//                    s += i.word.getText().toString() + "\\";
//                else
//                    s += i.word.getText().toString() + Constants.NEXT_LINE;
//
//            }
            return s;
        }
    }

}


