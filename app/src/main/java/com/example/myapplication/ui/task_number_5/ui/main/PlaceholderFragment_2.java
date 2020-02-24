package com.example.myapplication.ui.task_number_5.ui.main;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
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

import com.example.myapplication.R;
import com.example.myapplication.ui.PageViewModel;

import java.util.ArrayList;

public class PlaceholderFragment_2 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_2 newInstance(int index) {
        PlaceholderFragment_2 fragment = new PlaceholderFragment_2();
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


    private EditText countCharecter;
    private EditText UnkwonCode;
    private Button btOtvet;
    private TextView tvOtvet;
    private ArrayList<NewElements> listCode = new ArrayList<NewElements>();

    public View root;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_task_0513, container, false);
        btOtvet = root.findViewById(R.id.bOtvet_task13);
        btOtvet.setOnClickListener(oclBtn);
        tvOtvet = root.findViewById(R.id.textView2_task13);
        countCharecter = root.findViewById(R.id.editText1_task13);
        countCharecter.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

                // Прописываем то, что надо выполнить после изменения текст
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    tvOtvet.setVisibility(View.INVISIBLE);

                    int countNums = Integer.parseInt(s.toString());

                    if (countNums == 0 || countNums < listCode.size()) {
                        for (int i = countNums; i < listCode.size(); ) {
                            listCode.get(i).remove();
                            listCode.remove(i);

                        }
                    }
//                 //                    }
                    if (listCode.size() < countNums) {
                        for (; listCode.size() != countNums; ) {

                            listCode.add(new NewElements());

                        }


                    }
                } catch (Exception e) {

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
            switch (v.getId()) {
                case R.id.bOtvet_task13:
                    boolean check = true;
                    for (NewElements i : listCode) {
                        if (i.toString() == null)
                            check = false;
                    }
                    if (check && !countCharecter.getText().toString().isEmpty())
                        tvOtvet.setVisibility(View.VISIBLE);
                    else {
                        Toast toast = Toast.makeText(getContext(),
                                "Заполните  поля!", Toast.LENGTH_SHORT);
                        toast.show();
                    }

            }

        }
    };

    private class NewElements {
        public LinearLayout linearLH = (LinearLayout) root.findViewById(R.id.linear_code_task13);
        public LinearLayout linearLV = new LinearLayout(root.getContext());
        public EditText symbol = new EditText(root.getContext());
        public EditText code = new EditText(root.getContext());


        public NewElements() {
            final float scale = getResources().getDisplayMetrics().density;

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) (84 * scale + 0.5f), (int) (40 * scale + 0.5f), 1f);
            params.setMargins(0, (int) (10 * scale + 0.5f), (int) (25 * scale + 0.5f), 0);
            symbol.setLayoutParams(params);
            symbol.setInputType(InputType.TYPE_CLASS_TEXT);
            code.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(5)});
            symbol.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(1)});
            params.setMargins((int) (25 * scale + 0.5f), (int) (10 * scale + 0.5f), 0, 0);
            code.setLayoutParams(params);

            linearLV.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));

            code.setHint("Код");
            symbol.setHint("Буква");
            code.setInputType(InputType.TYPE_CLASS_NUMBER );
            linearLV.addView(symbol);
            linearLV.addView(code);
            linearLH.addView(linearLV);
        }


        @NonNull
        @Override
        public String toString() {
            if (symbol.getText().toString().length() > 0)
                return symbol.getText() + " " + code.getText();
            else
                return null;
        }

        public void remove() {
            linearLV.removeAllViews();
            linearLH.removeView(linearLV);
        }

    }
}