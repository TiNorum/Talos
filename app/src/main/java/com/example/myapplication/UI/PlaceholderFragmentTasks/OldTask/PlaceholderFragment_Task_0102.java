package com.example.myapplication.UI.PlaceholderFragmentTasks.OldTask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.ClientLauncher.ClientManager;
import com.example.myapplication.Instruments.ShowToast;
import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.PageViewModel;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.net.UnknownHostException;

public class PlaceholderFragment_Task_0102 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_0102 newInstance(int index) {
        PlaceholderFragment_Task_0102 fragment = new PlaceholderFragment_Task_0102();
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
    MaterialEditText number;
    MaterialEditText cc;
    RadioButton zero;
    RadioButton one;


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_0102, container, false);

//        zero = root.findViewById(R.id.task0102_rbtn_zero);
//        one = root.findViewById(R.id.task0102_rbtn_one);
//        cc = (MaterialEditText) root.findViewById(R.id.task0102_edittext_cc);
//        number = (MaterialEditText) root.findViewById(R.id.task0102_edittext_number);
//
//        btnAnswer = root.findViewById(R.id.task0102_btn_answer);
//        btnAnswer.setOnClickListener(oclBtn);
//
//
//        tAnswer = root.findViewById(R.id.task0102_txt_answer);


        return root;
    }

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            final String LOG_TAG = "SOCKET";

         if (checkData()) return;

            //отправка на сервер
            //*****************
            //*****************

            try {
                String answer = ClientManager.send_server(getData());
                tAnswer.setText(answer);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tAnswer.setVisibility(View.VISIBLE);

        }

        private String getData() {
            String data = "103" + "\n\r" + "2" + "\n\r";

            data += number.getText().toString() + "\n\r";

            data += cc.getText().toString() + "\n\r";

            if (zero.isChecked())
                data += '0';
            else
                data += '1' ;


            return data;
        }

        private boolean checkData() {
            if (number.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите число!");
                return true;
            }

            if (cc.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите систему счисления!");
                return true;
            }

            int c = Integer.parseInt(cc.getText().toString());

            if(!(c>1 && c<=16))
            {
                ShowToast.showToast(getContext(), "Введите систему счисления (2-10 и 16)");
                return true;
            }

            if (!(zero.isChecked() || one.isChecked())) {
                ShowToast.showToast(getContext(), "Выберите что нужно найти единицы/нули!");
                return true;
            }


            return false;
        }
    };
}