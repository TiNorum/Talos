package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.CanvasView;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */

public class PlaceholderFragment_Task_0307 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    float density;
    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0307 newInstance(int index) {
        PlaceholderFragment_Task_0307 fragment = new PlaceholderFragment_Task_0307();
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


    FrameLayout frameLayout;
    private Button bAnswer;
    private TextView tAnswer;
    CanvasView canvasView;
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0307, container, false);
        canvasView = root.findViewById(R.id.task0307_graph);


        //density = getContext().getResources().getDisplayMetrics().density;



        tAnswer = root.findViewById(R.id.task0307_text_answer);

        bAnswer = root.findViewById(R.id.task0307_btn_answer);
        bAnswer.setOnClickListener(oclBtn);


        return root;
    }



    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {



        }

        private boolean checkData() {

            return false;
        }


        private String getData() {

            String data = "100" + Constants.NEXT_LINE + 8 + Constants.NEXT_LINE;



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
//                LayoutInflater inflater = LayoutInflater.from(context);
//                View view = inflater.inflate(idFromListItem, parent, true);
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


