package com.example.myapplication.Activities.Tasks;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.SectionsPagerAdapter;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0204;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0205;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_task_02 extends AppCompatActivity {


    private static final Fragment[] fragments = {PlaceholderFragment_Task_0204.newInstance(0), PlaceholderFragment_Task_0205.newInstance(1)};
    private static final String[] tab_titles = {"Таблица истинности без пропусков", "Таблица истинности с пропусками"};

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
        type_name.setText("  Задание №2");
    }
}