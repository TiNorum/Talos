package com.example.myapplication.Activities.Tasks;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.SectionsPagerAdapter;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0615;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0616;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0617;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_Task_06 extends AppCompatActivity {

    private static final Fragment[] fragments = {PlaceholderFragment_Task_0615.newInstance(0), PlaceholderFragment_Task_0616.newInstance(1), PlaceholderFragment_Task_0617.newInstance(2)};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(),fragments);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


    }
}