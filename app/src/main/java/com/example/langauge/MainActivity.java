package com.example.langauge;



import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public  class MainActivity extends AppCompatActivity implements Numbers.OnFragmentInteractionListener,Family.OnFragmentInteractionListener,Colors.OnFragmentInteractionListener,Phrases.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("NUMBER"));
        tabLayout.addTab(tabLayout.newTab().setText("FAMILY"));
        tabLayout.addTab(tabLayout.newTab().setText("COLORS"));
        tabLayout.addTab(tabLayout.newTab().setText("PHRASES"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = (ViewPager)findViewById(R.id.viewpagerid);
        final PagerAdapter adapter = new PagerAdapter(this,getSupportFragmentManager(),/*tabLayout.getTabCount()*/4);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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





    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
