package com.example.myapplication.Activities.Tasks;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.SectionsPagerAdapter;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0821;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0822;
import com.google.android.material.tabs.TabLayout;

public class Activity_task_08 extends AppCompatActivity {


    private static final Fragment[] fragments = {PlaceholderFragment_Task_0821.newInstance(0), PlaceholderFragment_Task_0822.newInstance(1)};
    private static final String[] tab_titles = {"Укажите число, которое будет напечатано в ответ", "При каком введенном числе"};

    private TextView type_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // вывставляю layout для отображения
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        // объявляем адаптер для того, чтобы отображать наш view_pager
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(),fragments, tab_titles);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        // заменяем имя в app:bar
        type_name = findViewById(R.id.textview_task_all);
        type_name.setText("  Задание №8");
    }
}

