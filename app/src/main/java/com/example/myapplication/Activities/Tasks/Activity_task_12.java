package com.example.myapplication.Activities.Tasks;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.SectionsPagerAdapter;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_1238;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_1239;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_1240;

import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;



public class Activity_task_12 extends AppCompatActivity {

    private static final Fragment[] fragments = {PlaceholderFragment_Task_1238.newInstance(0), PlaceholderFragment_Task_1239.newInstance(1), PlaceholderFragment_Task_1240.newInstance(2)};
    private static final String[] tab_titles = {"2 IP (узла)", "IP и Сеть", "IP и Маска"};


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