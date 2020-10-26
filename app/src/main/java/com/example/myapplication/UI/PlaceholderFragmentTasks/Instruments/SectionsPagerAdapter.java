package com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.UI.PlaceholderFragmentTasks.Task2.PlaceholderFragment_Task_0203;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task2.PlaceholderFragment_Task_0204;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task1.PlaceholderFragment_Task_0101;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task1.PlaceholderFragment_Task_0102;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task3.PlaceholderFragment_Task_0305;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task3.PlaceholderFragment_Task_0306;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task3.PlaceholderFragment_Task_0307;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task3.PlaceholderFragment_Task_0308;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task4.PlaceholderFragment_Task_0409;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task4.PlaceholderFragment_Task_0410;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task5.PlaceholderFragment_Task_0511;
import com.example.myapplication.UI.PlaceholderFragmentTasks.OldTask.PlaceholderFragment_Task_0616;
import com.example.myapplication.UI.PlaceholderFragmentTasks.OldTask.PlaceholderFragment_Task_0617;
import com.example.myapplication.UI.PlaceholderFragmentTasks.OldTask.PlaceholderFragment_Task_0718;
import com.example.myapplication.UI.PlaceholderFragmentTasks.OldTask.PlaceholderFragment_Task_0719;
import com.example.myapplication.UI.PlaceholderFragmentTasks.OldTask.PlaceholderFragment_Task_0720;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task6.PlaceholderFragment_Task_0612;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task6.PlaceholderFragment_Task_0613;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task7.PlaceholderFragment_Task_0714;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task7.PlaceholderFragment_Task_0715;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task7.PlaceholderFragment_Task_0716;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task8.PlaceholderFragment_Task_0817;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task8.PlaceholderFragment_Task_0818;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task8.PlaceholderFragment_Task_0819;
import com.example.myapplication.UI.PlaceholderFragmentTasks.OldTask.PlaceholderFragment_Task_1238;
import com.example.myapplication.UI.PlaceholderFragmentTasks.OldTask.PlaceholderFragment_Task_1239;
import com.example.myapplication.UI.PlaceholderFragmentTasks.OldTask.PlaceholderFragment_Task_1240;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task11.PlaceholderFragment_Task_1122;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task12.PlaceholderFragment_Task_1223;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task12.PlaceholderFragment_Task_1224;
import com.example.myapplication.UI.PlaceholderFragmentTasks.Task13.PlaceholderFragment_Task_1325;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private String[]  TAB_TITLES;
    private final Context mContext;
    private int index_fragment;
    private final Fragment[][] fragments = {
            {PlaceholderFragment_Task_0101.newInstance(0), PlaceholderFragment_Task_0102.newInstance(1)},
            {PlaceholderFragment_Task_0203.newInstance(0), PlaceholderFragment_Task_0204.newInstance(1)},
            {PlaceholderFragment_Task_0305.newInstance(0), PlaceholderFragment_Task_0306.newInstance(1), PlaceholderFragment_Task_0307.newInstance(2), PlaceholderFragment_Task_0308.newInstance(3)},
            {PlaceholderFragment_Task_0409.newInstance(0), PlaceholderFragment_Task_0410.newInstance(1)},
            {PlaceholderFragment_Task_0511.newInstance(0)},
            {PlaceholderFragment_Task_0612.newInstance(0), PlaceholderFragment_Task_0613.newInstance(1)},
            {PlaceholderFragment_Task_0714.newInstance(0), PlaceholderFragment_Task_0715.newInstance(1), PlaceholderFragment_Task_0716.newInstance(2)},
            {PlaceholderFragment_Task_0817.newInstance(0), PlaceholderFragment_Task_0818.newInstance(1), PlaceholderFragment_Task_0819.newInstance(2)},
            {},
            {},
            {PlaceholderFragment_Task_1122.newInstance(0)},
            {PlaceholderFragment_Task_1223.newInstance(0), PlaceholderFragment_Task_1224.newInstance(1)},
            {PlaceholderFragment_Task_1325.newInstance(0)}};

    public SectionsPagerAdapter(Context context, FragmentManager fm, String[] tab_tittles, int fragment) {
        super(fm);
        index_fragment = fragment;
        mContext = context;
        TAB_TITLES = tab_tittles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[index_fragment][position];
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return TAB_TITLES[position];
    }

    @Override
    public int getCount() {
        return fragments[index_fragment].length;
    }
}