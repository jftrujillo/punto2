package com.example.jhon.punto3.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by jhon on 10/09/16.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> data;
    private String tabTitles[] = new String[] { "Wifi", "Ciudades"};


    public ViewPagerAdapter(FragmentManager fm, List<Fragment> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }


}
