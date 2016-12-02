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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(toggle);


    }


//    private class GetContacts extends AsyncTask<Void, Void, Void> {
//        private String TAG;
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            Toast.makeText(MainActivity.this,"Json Data is downloading",Toast.LENGTH_LONG).show();
//        }
//
//        @Override
//        protected Void doInBackground(Void... arg0) {
//            HttpHandler sh = new HttpHandler();
//            // Making a request to url and getting response
//            String url = "https://api.github.com/users/avengerpb/repos";
//            String jsonStr = sh.makeServiceCall(url);
//
//            Log.e(TAG, "Response from url: " + jsonStr);
//            if (jsonStr != null) {
//                try {
//                    JSONObject jsonObj = new JSONObject();
//
//                    // Getting JSON Array node
//                    JSONArray repos = jsonObj.getJSONArray("repos");
//
//                    // looping through All Contacts
//                    for (int i = 0; i < repos.length(); i++) {
//                        JSONObject r = repos.getJSONObject(i);
//                        String name = r.getString("name");
//                        String description = r.getString("description");
////                        String email = r.getString("email");
//                        String language = r.getString("language");
//                        int forks_count = r.getInt("forks_count");
//                        int watchers = r.getInt("watchers");
//
//                        // Phone node is JSON Object
////                        JSONObject phone = r.getJSONObject("phone");
////                        String mobile = phone.getString("mobile");
////                        String home = phone.getString("home");
////                        String office = phone.getString("office");
//
//                        // tmp hash map for single contact
//                        HashMap<String, String> repo = new HashMap<>();
//
//                        // adding each child node to HashMap key => value
//                        repo.put("name", name);
//                        repo.put("description", name);
////                        contact.put("email", email);
//                        repo.put("language", language);
//
//                        // adding contact to contact list
//                        repoList.add(repo);
//                    }
//                } catch (final JSONException e) {
//                    Log.e(TAG, "Json parsing error: " + e.getMessage());
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(getApplicationContext(),
//                                    "Json parsing error: " + e.getMessage(),
//                                    Toast.LENGTH_LONG).show();
//                        }
//                    });
//
//                }
//
//            } else {
//                Log.e(TAG, "Couldn't get json from server.");
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getApplicationContext(),
//                                "Couldn't get json from server. Check LogCat for possible errors!",
//                                Toast.LENGTH_LONG).show();
//                    }
//                });
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void result) {
//            super.onPostExecute(result);
//            ListAdapter adapter = new SimpleAdapter(MainActivity.this, repoList,
//                    R.layout.repositories, new String[]{ "name","description","language"},
//                    new int[]{R.id.name, R.id.description,R.id.language});
//            lv.setAdapter(adapter);
//        }
//    }

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
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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


