package com.example.prachi.project;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Map;

public class Page1Activity extends AppCompatActivity {
    private ViewPager viewPager;
    private Page2Activity myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myadapter = new Page2Activity(this);
        viewPager.setAdapter(myadapter);
        Toast.makeText(Page1Activity.this, "Slide To Continue!", Toast.LENGTH_SHORT).show();
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            boolean lastPageChange = false;
            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int lastIdx = myadapter.getCount() - 1;

                if(lastPageChange && position == lastIdx) {
                    // next
                    Log.e("tag","callledddddd");

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                int lastIdx = myadapter.getCount() - 1;

                int curItem = viewPager.getCurrentItem();
                if(curItem==lastIdx /*&& lastPos==lastIdx*/  && state==1) {
                    lastPageChange = true;
                    Log.e("tag","page scroll state >>>> ");
                    startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                    finish();
                } else {
                    lastPageChange = false;
                }
            }
        });
    }

    }

