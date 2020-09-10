package com.kalu.gadsleaderboard.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabPagerAdapter extends FragmentPagerAdapter {
    ArrayList<String> kTitles=new ArrayList<>();
    List<Fragment> kFragments=new ArrayList<>();

    public TabPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public void addFragment(String title,Fragment fragment){
        kTitles.add(title);
        kFragments.add(fragment);

    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment frag=kFragments.get(position);
        return frag;
    }

    @Override
    public int getCount() {
        return kFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return kTitles.get(position);
    }
}
