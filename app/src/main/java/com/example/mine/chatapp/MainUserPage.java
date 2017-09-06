package com.example.mine.chatapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;



public class MainUserPage extends AppCompatActivity {

    private int numberOfTabs;
    private String Uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_user_page_activity);
        //get user id
        Intent intent=getIntent();
        Uid=intent.getStringExtra("Uid");

        //ToolBar
        Toolbar toolbar=(Toolbar) findViewById(R.id.MyToolBar);
        //setSupportActionBar(toolbar);

        //TabLayout
        TabLayout tableLayout=(TabLayout) findViewById(R.id.MainActiTab);
        tableLayout.addTab(tableLayout.newTab().setText("All Users"));
        tableLayout.addTab(tableLayout.newTab().setText("Posts"));
        numberOfTabs=2;

        //ViewPager
        final ViewPager viewPager=(ViewPager) findViewById(R.id.MainActiPager);
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),numberOfTabs,Uid);
        viewPager.setAdapter(viewPagerAdapter);

        //set when change the taps
        tableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }
}
