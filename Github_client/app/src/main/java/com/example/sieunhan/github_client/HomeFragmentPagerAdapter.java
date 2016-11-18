package com.example.sieunhan.github_client;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.sieunhan.github_client.fragment.RepoFragment;

/**
 * Created by Admin on 11/18/2016.
 */

class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 5;
    private String titles[] = new String[] { "News", "Repositories", "Stars", "Followers", "Following" };
    public HomeFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public int getCount() {
        return PAGE_COUNT; // number of pages for a ViewPager
    }
    @Override
    public Fragment getItem(int page) {
// returns an instance of Fragment corresponding to the specified page
        switch (page) {
            case 0: return new RepoFragment();
            case 1: return new RepoFragment();
            case 2: return new RepoFragment();
        }
        return new RepoFragment();
    }
    @Override
    public CharSequence getPageTitle(int page) {
// returns a tab title corresponding to the specified page
        return titles[page];
    }
}
