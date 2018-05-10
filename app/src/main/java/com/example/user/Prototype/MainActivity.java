package com.example.user.Prototype;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    FloatingActionButton fab;
    AppBarLayout appBarLayout;
    DrawerLayout drawer;
    Toolbar searchToolbar;
    ViewPager viewPager;
    TabLayout tabLayout;

    private boolean isSearch = false;
    private FragementComment f_comment;
    private FragmentMemo f_memo;
    private FragmentPosts f_posts;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initComponent();
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (viewPager != null) {
            setupViewPager(viewPager);
        }

        initAction();

       // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public void onBackPressed() {
        doExitApp();
    }

    private long exitTime = 0;

    public void doExitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, R.string.press_again_exit_app, Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(isSearch ? R.menu.menu_search_toolbar : R.menu.main, menu);

        if (isSearch) {
            //Toast.makeText(getApplicationContext(), "Search " + isSearch, Toast.LENGTH_SHORT).show();
            final SearchView search = (SearchView) menu.findItem(R.id.action_search).getActionView();
            search.setIconified(false);
            search.setQueryHint("검색어를 입력하세요.");

            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    /*switch (viewPager.getCurrentItem()) {
                        case 0:
                          //  f_number.mAdapter.getFilter().filter(s);
                            break;
                        case 1:
                          //  f_check.mAdapter.getFilter().filter(s);
                            break;
                        case 2:
                          //  f_event.mAdapter.getFilter().filter(s);
                            break;
                    }*/
                    return true;
                }
            });
            search.setOnCloseListener(new SearchView.OnCloseListener() {
                @Override
                public boolean onClose() {
                    closeSearch();
                    return true;
                }
            });
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_search: {
                isSearch = true;
                searchToolbar.setVisibility(View.VISIBLE);
                prepareActionBar(searchToolbar);
                ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
                drawer.addDrawerListener(toggle);
                toggle.syncState();

                return true;
            }
            case android.R.id.home:
                closeSearch();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void prepareActionBar(Toolbar toolbar){
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        supportInvalidateOptionsMenu();

    }


    private void initComponent() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        searchToolbar = (Toolbar) findViewById(R.id.toolbar_search);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initAction() {

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setElevation(1);
        setupTabIcons();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                closeSearch();
                viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        //fab.setImageResource(R.drawable.ic_add_friend);
                        break;
                    case 1:
                       // fab.setImageResource(R.drawable.ic_create);
                        break;
                    case 2:
                        //fab.setImageResource(R.drawable.ic_add_group);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        viewPager.setCurrentItem(1);
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_contacts_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_directions_car_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_event_black_24dp);
    }

    private void closeSearch() {
        if (isSearch) {
            isSearch = false;
            if (viewPager.getCurrentItem() == 0) {
                //f_message.mAdapter.getFilter().filter("");
            } else {
                //f_contact.mAdapter.getFilter().filter("");
            }
            searchToolbar.setVisibility(View.GONE);
            supportInvalidateOptionsMenu();
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());

        if (f_comment == null) {
            f_comment = new FragementComment();
        }

        if (f_memo == null) {
            f_memo = new FragmentMemo();
        }

        if (f_posts == null) {
            f_posts = new FragmentPosts();
        }

        adapter.addFragment(f_memo, getString(R.string.tab_memo));
        adapter.addFragment(f_posts, getString(R.string.tab_posts));
        adapter.addFragment(f_comment, getString(R.string.tab_comment));

        viewPager.setAdapter(adapter);
    }



}

