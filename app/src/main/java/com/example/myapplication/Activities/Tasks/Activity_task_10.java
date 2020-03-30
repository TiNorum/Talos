package com.example.myapplication.Activities.Tasks;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.SectionsPagerAdapter;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_1027;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_1031;
import com.google.android.material.tabs.TabLayout;

public class Activity_task_10 extends AppCompatActivity {
    private static final Fragment[] fragments = {PlaceholderFragment_Task_1027.newInstance(0), PlaceholderFragment_Task_1031.newInstance(0)};
    private static final String[] tab_titles = {"Список слов", "Комбинаторика 1", "Комбинаторика 2"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(),fragments, tab_titles);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }
}
