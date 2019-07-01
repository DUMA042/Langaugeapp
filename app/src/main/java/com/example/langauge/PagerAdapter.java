package com.example.langauge;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;


public class PagerAdapter extends FragmentStatePagerAdapter {
    private Context context ;
    private int numberTabs ;
    public PagerAdapter (Context context ,FragmentManager fm,int numberTabs) {
        super(fm);
        this.context=context;
        this.numberTabs=numberTabs;
    }
    @Override
    public Fragment getItem(int i) {
        if (i==0){
            return new Numbers() ;
        }
        else if (i==1){
            return new Family() ;
        }
        else  if (i==2){
            return new Colors();
        }
        else if (i==3) {
            return new Phrases();
        }
        else
            return null ;


    }


    @Override
    public int getCount() {
        return numberTabs;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0){
            return context.getString(R.string.category_numbers);
        }
        else if (position==1){
            return context.getString(R.string.category_family);
        }
        else  if (position==2){
            return context.getString(R.string.category_colors);
        }
        else if (position==3)
        {  return context.getString(R.string.category_phrases);}
        else
            return null ;

    }
}
