package com.lanou.olddriver.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lanou.olddriver.R;
import com.lanou.olddriver.adapter.MyGuidePagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class GuideActivity extends AppCompatActivity {

    ViewPager guideVp;
    List<ImageView> guideList;
    MyGuidePagerAdapter guideAdapter;
    private Button button;
    private ViewPager vp;
    private ArrayList<ImageView> list;
    private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        
        initView();
    }

    private void initView() {


        ll= (LinearLayout) findViewById(R.id.guid_ll);
        button = (Button) findViewById(R.id.guid_btn);
        vp = (ViewPager) findViewById(R.id.guid_vp);
        list = new ArrayList<ImageView>();
        ImageView guideOne = new ImageView(this);

        guideOne.setScaleX(0.8f);
        guideOne.setScaleY(0.8f);
        guideOne.setImageResource(R.drawable.olddriver);
        ImageView guideTwo = new ImageView(this);
        guideTwo.setImageResource(R.drawable.splash_sologan);
        ImageView guideThree = new ImageView(this);
        guideThree.setImageResource(R.drawable.guide_three);
        guideThree.setScaleX(0.8f);
        guideThree.setScaleY(0.8f);
        list.add(guideOne);
        list.add(guideTwo);
        list.add(guideThree);
        guideAdapter = new MyGuidePagerAdapter(list);
        vp.setAdapter(guideAdapter);

        //6.0版本用add  一下版本用set
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                if (arg0 == list.size() - 1) {
                    ll.setVisibility(View.VISIBLE);
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                            //下面的跳转到6、7天作业的效果
//							Intent intent = new Intent(GuideActivity.this, MainActivity1.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }else{
                    ll.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });

    }
}
