package com.example.mine.chatapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private int numberOfTabs;
    private String userid;
    public ViewPagerAdapter(FragmentManager fm,int numberOfTabs,String userid) {
        super(fm);
        this.numberOfTabs=numberOfTabs;
        this.userid=userid;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return AllUserChatFragmet.newInstance(userid);
            case 1:
                return new PostsFragmet().newInstance(userid);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.numberOfTabs;
    }
}
