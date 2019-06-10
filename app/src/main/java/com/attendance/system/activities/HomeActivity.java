package com.attendance.system.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.attendance.system.R;
import com.attendance.system.custom_classes.FragmentPagerAdapter;
import com.attendance.system.databinding.ActivityHomeBinding;
import com.attendance.system.fragments.ChatFragment;
import com.attendance.system.fragments.SiteFragment;

import atirek.pothiwala.utility.helper.IntentHelper;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    FragmentPagerAdapter fragmentPagerAdapter;
    int selectedIndex = 0;
    boolean doubleBackToExitPressedOnce = false;

    static HomeActivity activity;
    public static HomeActivity getInstance() {
        return activity;
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigationChats:
                    selectedIndex = 0;
                    break;
                case R.id.navigationSites:
                    selectedIndex = 1;
                    break;

            }
            binding.viewPager.setCurrentItem(selectedIndex, false);
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        activity = this;

        binding.bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager());
        fragmentPagerAdapter.addFragments(new FragmentPagerAdapter.FragmentHolder(new ChatFragment(), getString(R.string.chats)));
        fragmentPagerAdapter.addFragments(new FragmentPagerAdapter.FragmentHolder(new SiteFragment(), getString(R.string.sites)));
        binding.viewPager.setOffscreenPageLimit(fragmentPagerAdapter.getCount());
        binding.viewPager.setAdapter(fragmentPagerAdapter);

        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                navigationItemSelectedListener.onNavigationItemSelected(binding.bottomNavigation.getMenu().getItem(i));
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        binding.viewPager.setCurrentItem(selectedIndex);

        binding.btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity, ContactsActivity.class));
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finishAffinity();
            return;
        }
        doubleBackToExitPressedOnce = true;
        IntentHelper.popToast(this, getString(R.string.tapAgainExit));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

}
