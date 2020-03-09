package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_Task_0103 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0103 newInstance(int index) {
        PlaceholderFragment_Task_0103 fragment = new PlaceholderFragment_Task_0103();
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


    Button button;
    TextView tAnswer;
    EditText editText;


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0103,container, false);

        button = root.findViewById(R.id.button3);
        button.setOnClickListener(oclBtn);

        tAnswer = root.findViewById(R.id.textView3);
        editText = root.findViewById(R.id.editText2);


        return root;
    }

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //нажатия на кнопку "SET"
                case R.id.button3:
                            if (editText.getText().toString().length() != 0) {
                                tAnswer.setVisibility(View.VISIBLE);
                            } else {
                                Toast toast = Toast.makeText(getContext(),
                                        "Введите пример!", Toast.LENGTH_SHORT);
                                toast.show();
                            }
                    break;

            }
        }
    };
}