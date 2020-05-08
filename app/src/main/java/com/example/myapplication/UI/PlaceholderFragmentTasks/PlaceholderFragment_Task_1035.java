package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
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
public class PlaceholderFragment_Task_1035 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_1035 newInstance(int index) {
        PlaceholderFragment_Task_1035 fragment = new PlaceholderFragment_Task_1035();
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


    private MaterialEditText symbols;
    private MaterialEditText countSymbol;
    private MaterialEditText countSymbolInWord;
    private ListItem items;
    private Button bAnswer;
    private TextView tAnswer;
    private LinearLayout list;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_1035, container, false);


        countSymbol = root.findViewById(R.id.task1035_edittext_count_symbols);
        countSymbol.addTextChangedListener(new TextWatcher() {
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

                if (items == null)
                    items = new ListItem(Integer.parseInt(s.toString()), getContext());
                else {
                    items = null;
                    list.removeAllViews();
                    items = new ListItem(Integer.parseInt(s.toString()), getContext());
                }

            }
        });


        countSymbolInWord = root.findViewById(R.id.task1035_edittext_count_symbols_in_word);
        symbols = root.findViewById(R.id.task1035_edittext_symbols);
        list = root.findViewById(R.id.task1035_list);

        tAnswer = root.findViewById(R.id.task1035_text_answer);


        bAnswer = root.findViewById(R.id.task1035_btn_answer);
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


            if (countSymbolInWord.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(),"Введите количество букв в слове!");
                return true;
            }

            if (symbols.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(),"Введите  буквы!");
                return true;
            }

            if (countSymbol.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(),"Введите количество ограниченных символов!");
                return true;
            }

            if (items.isEmpty()) {

                ShowToast.showToast(getContext(),"Укажите ограниченные символы!");
                return true;
            }


            return false;
        }





        private String getData() {

            String data = "100" + Constants.NEXT_LINE + 35 + Constants.NEXT_LINE;

            data += countSymbolInWord.getText().toString() + Constants.NEXT_LINE;
            data += symbols.getText().toString() + Constants.NEXT_LINE;
            data += countSymbol.getText().toString() + Constants.NEXT_LINE;
            data += items.toString();
            return data;
        }
    };


    public class ListItem {
        private int itemCount;
        private ArrayList<item> listItem = new ArrayList<item>();

        public ListItem(int n, Context context) {
            itemCount = n;

            for (int i = 0; i < 0; i++) {

            }
            for (int i = 1; i <= itemCount; i++) {
//                LayoutInflater inflater = LayoutInflater.from(context);
//                View view = inflater.inflate(idFromListItem, parent, true);
                listItem.add(new item(i));
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
                number = view.findViewById(R.id.task10_fragment_text_number);
                number.setText(String.valueOf(i));
                list.addView(view);

            }


        }

        public boolean isEmpty() {
            for (item i : listItem)
                if (i.word.getText().toString().isEmpty()) return true;

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
                    s += i.word.getText().toString();

            }
            return s;
        }
    }

}


