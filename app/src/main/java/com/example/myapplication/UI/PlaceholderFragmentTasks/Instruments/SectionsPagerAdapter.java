package com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.R;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0101;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0102;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0103;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0204;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0205;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0306;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0307;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0408;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0409;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0410;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0411;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0512;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0513;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0615;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0616;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0617;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0718;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0719;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0720;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0821;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0822;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0923;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0924;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_0925;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_1027;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_1031;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_1035;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_1238;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_1239;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_1240;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_1341;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_1442;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_1443;
import com.example.myapplication.UI.PlaceholderFragmentTasks.PlaceholderFragment_Task_1544;

import java.util.ArrayList;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private String[]  TAB_TITLES;
    private final Context mContext;
    private int index_fragment;
    private final Fragment[][] fragments = {
            {PlaceholderFragment_Task_0101.newInstance(0), PlaceholderFragment_Task_0102.newInstance(1), PlaceholderFragment_Task_0103.newInstance(2)},
            {PlaceholderFragment_Task_0204.newInstance(0), PlaceholderFragment_Task_0205.newInstance(1)},
            {PlaceholderFragment_Task_0306.newInstance(0), PlaceholderFragment_Task_0307.newInstance(1)},
            {PlaceholderFragment_Task_0408.newInstance(0), PlaceholderFragment_Task_0409.newInstance(1), PlaceholderFragment_Task_0410.newInstance(2), PlaceholderFragment_Task_0411.newInstance(3)},
            {PlaceholderFragment_Task_0512.newInstance(0), PlaceholderFragment_Task_0513.newInstance(1)},
            {PlaceholderFragment_Task_0615.newInstance(0), PlaceholderFragment_Task_0616.newInstance(1), PlaceholderFragment_Task_0617.newInstance(2)},
            {PlaceholderFragment_Task_0718.newInstance(0), PlaceholderFragment_Task_0719.newInstance(1), PlaceholderFragment_Task_0720.newInstance(2)},
            {PlaceholderFragment_Task_0821.newInstance(0), PlaceholderFragment_Task_0822.newInstance(1)},
            {PlaceholderFragment_Task_0923.newInstance(0), PlaceholderFragment_Task_0924.newInstance(1), PlaceholderFragment_Task_0925.newInstance(2)},
            {PlaceholderFragment_Task_1027.newInstance(0), PlaceholderFragment_Task_1031.newInstance(1), PlaceholderFragment_Task_1035.newInstance(2)},
            {},
            {PlaceholderFragment_Task_1238.newInstance(0), PlaceholderFragment_Task_1239.newInstance(1), PlaceholderFragment_Task_1240.newInstance(2)},
            {PlaceholderFragment_Task_1341.newInstance(0)},
            {PlaceholderFragment_Task_1442.newInstance(0), PlaceholderFragment_Task_1443.newInstance(1)},
            {PlaceholderFragment_Task_1544.newInstance(0)}};

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