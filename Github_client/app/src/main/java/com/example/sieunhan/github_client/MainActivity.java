package com.example.sieunhan.github_client;


import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;



import com.example.sieunhan.github_client.fragment.BookmarkFragment;
import com.example.sieunhan.github_client.fragment.GistsFragment;
import com.example.sieunhan.github_client.fragment.IssueFragment;
import com.example.sieunhan.github_client.fragment.RepoFragment;
import com.example.sieunhan.github_client.fragment.ReportFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.R.id.toggle;


/**
 * Created by Sieu Nhan on 11/14/2016.
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ActionBarDrawerToggle toggle;
    TextView userNameTV;
    ImageView avatar;
    Bundle extras;
    String newstring;

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

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(toggle);

        avatar = (ImageView) findViewById(R.id.avatar);
        userNameTV = (TextView) findViewById(R.id.user_name);

        extras = getIntent().getExtras();
        newstring = extras.getString("user_name");
        System.out.println(newstring);

        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.m_search:
                return true;
            default:
                super.onOptionsItemSelected(item);
        }
        return toggle != null && toggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.nav_gists) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new GistsFragment()).commit();
        } else if (id == R.id.nav_issue) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new IssueFragment()).commit();
        } else if (id == R.id.nav_bookmarks) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new BookmarkFragment()).commit();
        } else if (id == R.id.nav_report) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new ReportFragment()).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.navigation_drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (toggle != null)
            toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (toggle != null)
            toggle.onConfigurationChanged(newConfig);
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


