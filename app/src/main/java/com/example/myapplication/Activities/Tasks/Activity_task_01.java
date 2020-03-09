package com.example.myapplication.Activities.Tasks;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0101;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0102;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0103;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.SectionsPagerAdapter;

public class Activity_task_01 extends AppCompatActivity {

    private static final Fragment[] fragments = {PlaceholderFragment_Task_0101.newInstance(0), PlaceholderFragment_Task_0102.newInstance(1), PlaceholderFragment_Task_0103.newInstance(2)};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // вывставляю layout для отображения
        setContentView(R.layout.activity_tasks);
        // объявляем адаптер для того, чтобы отображать наш view_pager
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(),fragments);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }
}