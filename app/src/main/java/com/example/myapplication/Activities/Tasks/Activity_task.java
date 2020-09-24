package com.example.myapplication.Activities.Tasks;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0101;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0102;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0103;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.SectionsPagerAdapter;

import java.util.ArrayList;

public class Activity_task extends AppCompatActivity {

    private Fragment[] fragments;
    private Parcelable[] parcelables;

    private String[] tab_titles;

    private TextView type_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // вывставляю layout для отображения
        setContentView(R.layout.activity_tasks);

        Bundle arguments = getIntent().getExtras();
        tab_titles = arguments.getStringArray("tab_titles");
        int index = arguments.getInt("index");

        // объявляем адаптер для того, чтобы отображать наш view_pager
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), tab_titles, index-1);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


        // заменяем имя в app:bar
        type_name = findViewById(R.id.textview_task_all);
        type_name.setText("  Задание №" + index);
    }
}