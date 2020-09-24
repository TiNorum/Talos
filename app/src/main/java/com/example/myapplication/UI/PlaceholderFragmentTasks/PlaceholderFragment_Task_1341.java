package com.example.myapplication.UI.PlaceholderFragmentTasks;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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
public class PlaceholderFragment_Task_1341 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment_Task_1341 newInstance(int index) {
        // юзает фрагмент
        PlaceholderFragment_Task_1341 fragment = new PlaceholderFragment_Task_1341();
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


    private MaterialEditText countSymbolInPass;
    private MaterialEditText countSymbol;
    private MaterialEditText countUsers;
    private MaterialEditText countAllByte;
    private MaterialEditText addInf;
    private TextView type_name;


    private Button bAnswer;
    private TextView tAnswer;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_task_1341, container, false);
        countSymbolInPass = root.findViewById(R.id.task1341_count_symbol_in_password);
        countSymbol = root.findViewById(R.id.task1341_count_symbol);
        countUsers = root.findViewById(R.id.task1341_count_users);
        countAllByte = root.findViewById(R.id.task1341_count_all_byte);
        addInf = root.findViewById(R.id.task1341_add_inf);

        tAnswer = root.findViewById(R.id.task1341_text_answer);
        bAnswer = root.findViewById(R.id.button_answer);
        bAnswer.setOnClickListener(oclBtn);


        return root;
    }

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (checkData(v.getContext())) return;

            String data = getData();

            tAnswer.setVisibility(View.VISIBLE);
            tAnswer.setText(data);
        }

        private boolean checkData(Context context) {
            if (countSymbol.getText().toString().isEmpty() || !(Integer.parseInt(countSymbol.getText().toString()) > 0)) {
                ShowToast.showToast(getContext(), "Введите количество символов в пароле.");
                return true;
            }

            if (countSymbolInPass.getText().toString().isEmpty() || !(Integer.parseInt(countSymbolInPass.getText().toString()) > 0)) {
                ;
                ShowToast.showToast(getContext(), "Введите количество используемых символов.");

                return true;
            }

            if (countUsers.getText().toString().isEmpty() || !(Integer.parseInt(countUsers.getText().toString()) > 0)) {
                ShowToast.showToast(getContext(), "Введите количество пользователей.");

                return true;
            }

            if (countAllByte.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите количество байтов, которые потребовались для ВСЕХ пользователей. Если значение неизвестно, то напишите X.");
                return true;
            }

            if (addInf.getText().toString().isEmpty()) {
                ShowToast.showToast(getContext(), "Введите количетсво дополнительных сведений для одного пользователя. Если значение неизвестно, то напишите X.");
                return true;
            }
            return false;
        }

        private String getData() {
            String data = "100" + "\n\r" + "41" + "\n\r";


            data += countSymbol.getText().toString() + "\n\r";
            data += countSymbolInPass.getText().toString() + "\n\r";
            data += countUsers.getText().toString() + "\n\r";

            if (addInf.getText().toString().isEmpty())
                data += 'x' + "\n\r";
            else
                data += addInf.getText().toString() + "\n\r";

            if (countAllByte.getText().toString().isEmpty())
                data += 'x' + "\n\r";
            else
                data += countAllByte.getText().toString();


            return data;
        }

    };


}

