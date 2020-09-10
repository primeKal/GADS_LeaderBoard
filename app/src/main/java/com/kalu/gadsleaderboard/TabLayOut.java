package com.kalu.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.kalu.gadsleaderboard.Adapters.TabPagerAdapter;

import java.util.ArrayList;

public class TabLayOut extends AppCompatActivity {

    ViewPager kViewPager;
    TabLayout kTabLayout;
    Toolbar kToolbar;
    Button kSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_lay_out);
        kTabLayout=findViewById(R.id.tab_layout);
        kViewPager=findViewById(R.id.view_pager);
        kToolbar=findViewById(R.id.toolbarsubmitactivity);
        kSubmitButton=findViewById(R.id.toolbar_Button);
        kSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SubmitActivity.class));
            }
        });



        ArrayList<String> tabtitles=new ArrayList<>();
        tabtitles.add("Skill");
        tabtitles.add("Hours");
        preparetheviewpager(tabtitles,kViewPager);
        kTabLayout.setupWithViewPager(kViewPager);
    }

    private void preparetheviewpager(ArrayList<String> tabtitles, ViewPager viewPager) {
        TabPagerAdapter myadapter=new TabPagerAdapter(getSupportFragmentManager());
        myadapter.addFragment("Hours",new SecondFragment());
       myadapter.addFragment("Skill",new FirstFragment());

        kViewPager.setAdapter(myadapter);
    }
}
