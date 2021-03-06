package com.example.myapplication.UI.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.ClientLauncher.Client;
import com.example.myapplication.ClientLauncher.ClientManager;
import com.example.myapplication.Instruments.Constants;
import com.example.myapplication.Instruments.ShowToast;
import com.example.myapplication.R;

import java.net.UnknownHostException;


public class ProfileFragment extends Fragment {

    private Button btn_save;
    private EditText name;
    private EditText school_class;
    private EditText id_vk;
    private EditText id_inst;
    private EditText about;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_redact, container, false);

        name = view.findViewById(R.id.name);
        school_class = view.findViewById(R.id.class_);
        id_vk = view.findViewById(R.id.vk);
        id_inst = view.findViewById(R.id.inst);
        about = view.findViewById(R.id.about);
        btn_save = view.findViewById(R.id.save);

        btn_save.setOnClickListener(v -> {
            String data = "104" + Constants.NEXT_LINE + "TNorum" + Constants.NEXT_LINE + name.getText().toString() + Constants.NEXT_LINE;

            data += school_class.getText().toString() + Constants.NEXT_LINE;

            data += id_vk.getText() + Constants.NEXT_LINE;
            data += id_inst.getText() + Constants.NEXT_LINE;
            data += about.getText() + Constants.NEXT_LINE;

            try {
                String answer = ClientManager.send_server(data);
                if (answer.equals("400"))
                    ShowToast.showToast(getContext(), "Сохранено!");
                else
                    ShowToast.showToast(getContext(), "Ошибка!");

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return view;
    }




}
