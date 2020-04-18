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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
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
public class PlaceholderFragment_Task_1027 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_1027 newInstance(int index) {
        PlaceholderFragment_Task_1027 fragment = new PlaceholderFragment_Task_1027();
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
    private MaterialEditText countSymbol;
    private MaterialEditText countSymbolInWord;
    private Spinner spinner;
    private ListItem l;
    private Button bAnswer;
    private TextView tAnswer;
    private LinearLayout list;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_1027, container, false);


        countSymbol = root.findViewById(R.id.task1027_edittext_count_symbols);
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

                if (l == null)
                    l = new ListItem(Integer.parseInt(s.toString()), getContext());
                else {
                    l = null;
                    list.removeAllViews();
                    l = new ListItem(Integer.parseInt(s.toString()), getContext());
                }

            }
        });


        countSymbolInWord = root.findViewById(R.id.task1027_edittext_count_symbols_in_word);
        countSymbolInWord.addTextChangedListener(new TextWatcher() {
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

        list = root.findViewById(R.id.task1027_list);
        spinner = root.findViewById(R.id.task1027_spinner);
        spinner.setOnItemSelectedListener(onItemSelectedListener);
        tAnswer = root.findViewById(R.id.task1027_text_answer);

        text1 = root.findViewById(R.id.task1027_edittext_text1);
        text2 = root.findViewById(R.id.task1027_edittext_text2);

        bAnswer = root.findViewById(R.id.task1027_btn_answer);
        bAnswer.setOnClickListener(oclBtn);


        return root;
    }

    AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (id == 0) {
                text1.setText("");
                text2.setText("");
                text1.setHint("Введите первое слово");
                text2.setHint("Введите второе слово");
                text1.setVisibility(View.VISIBLE);
                text2.setVisibility(View.VISIBLE);

                return;
            }

            if (id == 1) {
                text1.setText("");
                text2.setText("");
                text1.setHint("Введите номер искомого слова");
                text1.setVisibility(View.VISIBLE);
                text2.setVisibility(View.GONE);

                return;

            }

            if (id == 2) {
                text1.setText("");
                text2.setText("");
                text1.setHint("Введите искомое слово");
                text1.setVisibility(View.VISIBLE);
                text2.setVisibility(View.GONE);

                return;

            }
            if (id == 3) {
                text1.setText("");
                text2.setText("");
                text1.setHint("Введите букву");
                text1.setVisibility(View.VISIBLE);
                text2.setVisibility(View.GONE);

                return;

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
            if (countSymbol.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите количество символов!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }

            if (countSymbolInWord.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите количество букв в слове!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }
            if (l.isEmpty()) {
                Toast toast = Toast.makeText(getContext(),
                        "Введите слова!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return true;
            }

            if (spinner.getSelectedItemId() == 0) {
                if (text1.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(getContext(),
                            "Введите первое слово!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return true;
                }

                if (text2.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(getContext(),
                            "Введите второе слово!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return true;
                }
            } else {
                if (text1.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(getContext(),
                            "Введите искомое слово!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return true;
                }
            }
            return false;
        }


        private String getData() {

            String data = "100" + Constants.NEXT_LINE + (27 + spinner.getSelectedItemId()) + Constants.NEXT_LINE;

            data += countSymbol.getText().toString() + Constants.NEXT_LINE;
            data += countSymbolInWord.getText().toString() + Constants.NEXT_LINE;
            data += l.toString()+Constants.NEXT_LINE;

            data += text1.getText().toString();

            if (spinner.getSelectedItemId() == 0) {

                data += Constants.NEXT_LINE + text2.getText().toString();
            }

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


