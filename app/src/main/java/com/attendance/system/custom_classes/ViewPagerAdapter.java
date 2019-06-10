package com.attendance.system.custom_classes;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class ViewPagerAdapter extends PagerAdapter {

    public interface AdapterListener {
        View instantiateItem(@NonNull ViewGroup container, int position);

        int getCount();

    }

    public ViewPagerAdapter(AdapterListener listener) {
        this.listener = listener;
    }

    private ViewPagerAdapter.AdapterListener listener;

    @Override
    public int getCount() {
        return listener.getCount();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return listener.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}