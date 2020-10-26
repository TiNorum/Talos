package com.example.myapplication.UI.PlaceholderFragmentTasks.Task13;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.Instruments.ShowToast;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.CanvasView;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment_Task_1325 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_1325 newInstance(int index) {
        // юзает фрагмент
        PlaceholderFragment_Task_1325 fragment = new PlaceholderFragment_Task_1325();
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



    CanvasView canvasView;
    AlertDialog.Builder ad;
    MaterialEditText start_point;
    MaterialEditText end_point;
    MaterialEditText skip_point;

    private Button bAnswer;
    Dialog dialog;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_task_1544, container, false);


        ad = new AlertDialog.Builder(getContext());

        LayoutInflater inflater1 = LayoutInflater.from(getContext());
        View view = inflater1.inflate(R.layout.alert_dialog_task44, null);
        ad.setView(view);

        end_point = view.findViewById(R.id.task44_edittext_end);
        start_point = view.findViewById(R.id.task44_edittext_start);
        skip_point = view.findViewById(R.id.task44_edittext_skip);

        dialog = ad.create();
        canvasView = root.findViewById(R.id.task1544_graph);

        bAnswer = root.findViewById(R.id.task1544_btn_answer);
        bAnswer.setOnClickListener(oclBtn);

        root.findViewById(R.id.task1544_btn_choose).setOnClickListener(onClickListener_Dialog);
        view.findViewById(R.id.task44_btn_close).setOnClickListener(onClickListener_Dialog);
        return root;
    }


    View.OnClickListener onClickListener_Dialog = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.task44_btn_close:
                    dialog.dismiss();
                    return;
                case R.id.task1544_btn_choose:
                    dialog.show();
                    return;

            }
        }
    };


    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(checkData()) return;


            String data = getData();
            ShowToast.showToast(getContext(), data);

        }

        private boolean checkData() {
            String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String s2 = "1234567890";



            if (start_point.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите начальную точку!");
                return true;
            }

            if (end_point.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите конечную точку!");
                return true;
            }

            if (canvasView.isEmpty()) {
                ShowToast.showToast(getContext(), "Нарисуйте граф!");
                return true;
            }

            return false;
        }

        private String getData() {
            String data = "103" + "\n\r" + "44" + "\n\r";

            data += canvasView.toString();
            data += start_point.getText().toString() + Constants.NEXT_LINE;
            data += end_point.getText().toString();

            if(!skip_point.getText().toString().isEmpty())
                data +=Constants.NEXT_LINE + skip_point.getText().toString();


            return data;
        }
    };


}

