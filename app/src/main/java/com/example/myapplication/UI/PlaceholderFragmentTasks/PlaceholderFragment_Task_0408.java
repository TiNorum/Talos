package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
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
public class PlaceholderFragment_Task_0408 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0408 newInstance(int index) {
        PlaceholderFragment_Task_0408 fragment = new PlaceholderFragment_Task_0408();
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


    private MaterialEditText countMask;
    private MaterialEditText countFile;
    private MaterialEditText countFileInGroup;
    private ListItem files;
    private ListItem groupfile;
    private ListItem masks;
    private Button bAnswer;
    private TextView tAnswer;
    private LinearLayout listFile;
    private LinearLayout listGroup;
    private LinearLayout listMask;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0408, container, false);


        countFile = root.findViewById(R.id.task0408_edittext_count_file);
        countFile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.toString().isEmpty()) {
                    listFile.removeAllViews();
                    return;
                }

                if (files == null)
                    files = new ListItem(Integer.parseInt(s.toString()), getContext(), listFile);
                else {
                    files = null;
                    listFile.removeAllViews();
                    files = new ListItem(Integer.parseInt(s.toString()), getContext(), listFile);
                }

            }
        });


        countFileInGroup = root.findViewById(R.id.task0408_edittext_count_file_in_group);
        countFileInGroup.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    listGroup.removeAllViews();
                    return;
                }

                if (groupfile == null)
                    groupfile = new ListItem(Integer.parseInt(s.toString()), getContext(), listGroup);
                else {
                    groupfile = null;
                    listGroup.removeAllViews();
                    groupfile = new ListItem(Integer.parseInt(s.toString()), getContext(), listGroup);
                }

            }
        });

        countMask = root.findViewById(R.id.task0408_edittext_count_mask);
        countMask.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    listMask.removeAllViews();
                    return;
                }

                if (masks == null)
                    masks = new ListItem(Integer.parseInt(s.toString()), getContext(), listMask);
                else {
                    masks = null;
                    listMask.removeAllViews();
                    masks = new ListItem(Integer.parseInt(s.toString()), getContext(), listMask);
                }
            }
        });

        listFile = root.findViewById(R.id.task0408_list_all_file);
        listGroup = root.findViewById(R.id.task0408_list_group_file);
        listMask = root.findViewById(R.id.task0408_list_mask);


        tAnswer = root.findViewById(R.id.task0408_text_answer);

        bAnswer = root.findViewById(R.id.task0408_btn_answer);
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
            if (countFile.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите количество символов!");
                return true;
            }

            if (countFileInGroup.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите количество букв в слове!");
                return true;
            }
            if (countMask.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите количество масок!");
                return true;
            }
            if (files.isEmpty()) {
                ShowToast.showToast(getContext(), "Введите назвайния файлов!");
                return true;
            }

            if (groupfile.isEmpty()) {
                ShowToast.showToast(getContext(), "Введите группу файлов!");
                return true;
            }
            if (masks.isEmpty()) {
                ShowToast.showToast(getContext(), "Введите маски!");
                return true;
            }
            return false;
        }


        private String getData() {

            String data = "100" + Constants.NEXT_LINE + 8 + Constants.NEXT_LINE;

            data += countFile.getText().toString() + Constants.NEXT_LINE;
            data += countFileInGroup.getText().toString() + Constants.NEXT_LINE;

            data += files.toString() + Constants.NEXT_LINE;
            data += groupfile.toString() + Constants.NEXT_LINE;
            data += masks.toString();

            return data;
        }
    };


    public class ListItem {
        private int itemCount;
        private ArrayList<item> listItem = new ArrayList<item>();

        public ListItem(int n, Context context, LinearLayout list) {
            itemCount = n;

            for (int i = 0; i < 0; i++) {

            }
            for (int i = 1; i <= itemCount; i++) {
                listItem.add(new item(i, list));
            }
        }

        public class item {
            public TextView number;
            public EditText word;
            public int idFromListItem;

            public item(int i, LinearLayout linearLayout) {
                idFromListItem = R.layout.task10_fragment_list;

                LayoutInflater inflater = LayoutInflater.from(getContext());
                View view = inflater.inflate(idFromListItem, linearLayout, false);

                word = view.findViewById(R.id.task10_fragment_edittext_word);
                number = view.findViewById(R.id.task10_fragment_text_number);
                number.setText(String.valueOf(i));
                linearLayout.addView(view);
            }


        }

        public boolean isEmpty() {
            for (item i : listItem)
                if (i.word.getText().toString().isEmpty()) return true;


            return false;
        }

        public boolean setLength(int n) {
            for (item i : listItem)
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
    }

}


