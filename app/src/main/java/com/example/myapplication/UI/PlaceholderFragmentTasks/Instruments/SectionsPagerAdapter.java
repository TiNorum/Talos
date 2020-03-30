package com.example.myapplication.UI.PlaceholderFragmentTasks.Instruments;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private String[] TAB_TITLES;
    private final Context mContext;
    private final Fragment[] fragments;

    public SectionsPagerAdapter(Context context, FragmentManager fm,Fragment[] fragment, String[] tab_tittles) {
        super(fm);
        fragments = fragment;
        mContext = context;
        TAB_TITLES = tab_tittles;
    }

    @Override
    public Fragment getItem(int position) {

        return fragments[position];
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return TAB_TITLES[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}