package com.example.myapplication.UI.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.Activities.Tasks.Activity_task;
import com.example.myapplication.R;

import java.util.HashMap;
import java.util.Map;

public class TaskFragment extends Fragment {


    private Map<Integer, String[]> tab_titles = new HashMap<Integer, String[]>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_task, container, false);


        tab_titles.put(R.id.buttonType1, new String[]{"Мин/Макс", "Поиск 0/1", "Решить уравнение","1"});
        root.findViewById(R.id.buttonType1).setOnClickListener(oclBtn);

        tab_titles.put(R.id.buttonType2, new String[]{"Таблица истинности без пропусков", "Таблица истинности с пропусками","2"});
        root.findViewById(R.id.buttonType2).setOnClickListener(oclBtn);

        tab_titles.put(R.id.buttonType3, new String[] {"Type1", "Type2","3"});
        root.findViewById(R.id.buttonType3).setOnClickListener(oclBtn);

        tab_titles.put(R.id.buttonType4, new String[] {"Type1", "Type2","Type3","Type4","4"});
        root.findViewById(R.id.buttonType4).setOnClickListener(oclBtn);

        tab_titles.put(R.id.buttonType5, new String[] {"Кодовое слово для одной буквы", "Сумма всех", "Отличия с ошибкой","5"});
        root.findViewById(R.id.buttonType5).setOnClickListener(oclBtn);

        tab_titles.put(R.id.buttonType6, new String[] {"Алгоритм двоичной записи", "Автомат", "Калькулятор","6"});
        root.findViewById(R.id.buttonType6).setOnClickListener(oclBtn);

        tab_titles.put(R.id.buttonType7, new String[] {"", "","","7"});
        root.findViewById(R.id.buttonType7).setOnClickListener(oclBtn);

        tab_titles.put(R.id.buttonType8, new String[] {"Укажите число, которое будет напечатано в ответ", "При каком введенном числе","8"});
        root.findViewById(R.id.buttonType8).setOnClickListener(oclBtn);

        tab_titles.put(R.id.buttonType9, new String[] {"Передача файла", "Звук", "Изображение общий объём", "Изображение преобразование","9"});
        root.findViewById(R.id.buttonType9).setOnClickListener(oclBtn);

        tab_titles.put(R.id.buttonType10, new String[] {"Список слов", "Комбинаторика 1", "Комбинаторика 2","10"});
        root.findViewById(R.id.buttonType10).setOnClickListener(oclBtn);

        tab_titles.put(R.id.buttonType12, new String[] {"2 IP (узла)", "IP и Сеть", "IP и Маска","12"});
        root.findViewById(R.id.buttonType12).setOnClickListener(oclBtn);

        tab_titles.put(R.id.buttonType13, new String[] {"Task13","13"});
        root.findViewById(R.id.buttonType13).setOnClickListener(oclBtn);

        tab_titles.put(R.id.buttonType14, new String[] {"Укажите число, которое будет напечатано в ответ", "При каком введенном числе","14"});
        root.findViewById(R.id.buttonType14).setOnClickListener(oclBtn);

        tab_titles.put(R.id.buttonType15, new String[] {"Граф","15"});
        root.findViewById(R.id.buttonType15).setOnClickListener(oclBtn);



        return root;
    }




    // обработка события нажатия
    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


                    Intent intent = new Intent(getContext(), Activity_task.class);

                    intent.putExtra("tab_titles", tab_titles.get(v.getId()));
                    intent.putExtra("index", Integer.parseInt(tab_titles.get(v.getId())[tab_titles.get(v.getId()).length-1]));
                    startActivity(intent);


        }
    };
}
