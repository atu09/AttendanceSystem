package com.attendance.system.custom_classes;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Atirek Pothiwala on 23-02-2016.
 */
public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    public static class FragmentHolder {

        public FragmentHolder(Fragment fragment, String title) {
            this.fragment = fragment;
            this.title = title;
        }

        public Fragment fragment;
        public String title;
    }

    private ArrayList<FragmentHolder> fragments = new ArrayList<>();

    public void addFragments(FragmentHolder fragmentHolder) {
        this.fragments.add(fragmentHolder);
    }

    public FragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position).fragment;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).title;
    }


    public void setPageTitle(int position, String text) {
        fragments.get(position).title = text;
    }

}
