package com.example.jhon.punto3;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.jhon.punto3.Adapters.ViewPagerAdapter;
import com.example.jhon.punto3.Fragments.QueryCitiesFragment;
import com.example.jhon.punto3.Fragments.WifiStateFragment;
import com.example.jhon.punto3.Models.Cities;
import com.example.jhon.punto3.Net.SyncGetXml;
import com.example.jhon.punto3.interfaces.OnFragmentWifiListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnFragmentWifiListener, SyncGetXml.OnSyncListener{

    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;
    List<Fragment> dataFragment;
    List<Cities> data;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.pager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Punto 3");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        QueryCitiesFragment fragment1 = new QueryCitiesFragment();
        WifiStateFragment fragment2 = new WifiStateFragment();
        dataFragment = new ArrayList<>();
        dataFragment.add(fragment2);
        dataFragment.add(fragment1);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(),dataFragment);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    @Override
    public void onWifiStateChange(boolean state) {
        WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        if (state){
            wifiManager.setWifiEnabled(true);
        }
        else {
            wifiManager.setWifiEnabled(false);
        }
    }

    @Override
    public void OnPrepareConection(int state) {

    }

    @Override
    public void OnFinishedConection(int state, List<Cities> cities, String e) {
        Log.i("asdf","asdf");
    }
}
