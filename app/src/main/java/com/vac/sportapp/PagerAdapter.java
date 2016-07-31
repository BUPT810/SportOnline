package com.vac.sportapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by vac on 2016/7/13.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT=4;
    private FirstFragment firstFragment = null;
    private SecondFragment secondFragment = null;
    private ThirdFragment thirdFragment = null;
    private ForthFragment forthFragment = null;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        thirdFragment = new ThirdFragment();
        forthFragment = new ForthFragment();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case MainActivity.FIRST_PAGE:
                fragment = firstFragment;
                break;
            case MainActivity.SECOND_PAGE:
                fragment = secondFragment;
                break;
            case MainActivity.THIRD_PAGE:
                fragment = thirdFragment;
                break;
            case MainActivity.FORTH_PAGE:
                fragment = forthFragment;
                break;
            default:break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
