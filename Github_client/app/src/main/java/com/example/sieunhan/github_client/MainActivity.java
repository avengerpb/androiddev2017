package com.example.sieunhan.github_client;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import com.example.sieunhan.github_client.fragment.RepoFragment;


/**
 * Created by Sieu Nhan on 11/14/2016.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PagerAdapter adapter = new HomeFragmentPagerAdapter(
                getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(5);
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_searching:
                return true;
            default:
                super.onOptionsItemSelected(item);
        }
        return true;
    }

    public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
        private final int PAGE_COUNT = 5;
        private String titles[] = new String[] { "News", "Repositories", "Stars", "Followers", "Following" };
        public HomeFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return PAGE_COUNT;
        }
        @Override
        public Fragment getItem(int page) {
            switch (page) {
                case 0: return new RepoFragment();
                case 1: return new RepoFragment();
                case 2: return new RepoFragment();
            }
            return new RepoFragment();
        }
        @Override
        public CharSequence getPageTitle(int page) {
            return titles[page];
        }
    }

}


