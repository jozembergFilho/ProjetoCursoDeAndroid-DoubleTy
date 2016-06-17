package com.example.berg.doublety;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.berg.doublety.fragments.Fragment01;
import com.example.berg.doublety.fragments.Fragment02;
import com.example.berg.doublety.fragments.Fragment03;

public class ManualActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        tabLayout = (TabLayout)findViewById(R.id.tab);
        toolbar = (Toolbar)findViewById(R.id.toolbarManual);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Instruções");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SelectionPagerAdapter sp = new SelectionPagerAdapter(getSupportFragmentManager());
        tabLayout.addTab(tabLayout.newTab().setText(sp.getTitulos()[0]));
        tabLayout.addTab(tabLayout.newTab().setText(sp.getTitulos()[1]));
        tabLayout.addTab(tabLayout.newTab().setText(sp.getTitulos()[2]));

        viewPager.setAdapter(sp);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            //finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class SelectionPagerAdapter extends FragmentStatePagerAdapter{

        private String [] titulos = new String[]{"O que é?","Conteúdos","Pontuação"};


        public SelectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            if(position == 0){
                fragment = new Fragment01();
            }
            else if(position == 1){
                fragment = new Fragment02();
            }
            else{
                fragment = new Fragment03();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("id",position);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return titulos.length;
        }
        public String [] getTitulos(){
            return titulos;
        }
    }
}
