package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_Task_0101 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0101 newInstance(int index) {
        // юзает фрагмент
        PlaceholderFragment_Task_0101 fragment = new PlaceholderFragment_Task_0101();
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


    Button btnAnswer;
    TextView tAnswer;

    MaterialEditText countZeroOrNum;
    MaterialEditText cc;
    RadioGroup rgChoiceZeroOrNum;
    RadioGroup rgChoiceMaxorMin;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0101, container, false);

      // находим кнопку с которой работает
        btnAnswer = root.findViewById(R.id.task0101_btn_answer);
        btnAnswer.setOnClickListener(oclBtn);

        countZeroOrNum = (MaterialEditText) root.findViewById(R.id.task0101_edittext_count_values_one_or_zero);
        cc = (MaterialEditText) root.findViewById(R.id.task0101_edittext_count_values_one_or_zero);

//        rgChoiceMaxorMin = root.findViewById(R.id.task0101_rg_choice_min_max);
//        rgChoiceZeroOrNum = root.findViewById(R.id.task0101_edittext_count_values_one_or_zero);
        tAnswer = root.findViewById(R.id.task0101_textview_answer);


        return root;
    }

//    RadioGroup.OnCheckedChangeListener rgListener = new RadioGroup.OnCheckedChangeListener()
//    {
//
//        @Override
//        public void onCheckedChanged(RadioGroup group, int checkedId) {
//            switch ()
//        }
//    }

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.task0101_btn_answer:

                    if (countZeroOrNum.getText().toString().length() != 0) {
                        if (cc.getText().toString().length() != 0) {

                                tAnswer.setVisibility(View.VISIBLE);


                        } else {
                            Toast toast = Toast.makeText(getContext(),
                                    "Введите систему счисления!", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    } else {
                        Toast toast = Toast.makeText(getContext(),
                                "Введите количество нулей/единиц!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    break;

            }
        }
    };
}