package com.example.myapplication.Activities.Tasks;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments.SectionsPagerAdapter;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_1238;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_1239;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_1240;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Activity_task_12 extends AppCompatActivity {

    private static final Fragment[] fragments = {PlaceholderFragment_Task_1238.newInstance(0), PlaceholderFragment_Task_1239.newInstance(1), PlaceholderFragment_Task_1240.newInstance(2)};

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