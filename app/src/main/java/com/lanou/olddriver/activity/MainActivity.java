package com.lanou.olddriver.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.lanou.olddriver.R;
import com.lanou.olddriver.fragment.EmbarrassingCircleFragment;
import com.lanou.olddriver.fragment.EmbarrassingThingsFragment;
import com.lanou.olddriver.fragment.LiveFragment;
import com.lanou.olddriver.fragment.MeFragment;
import com.lanou.olddriver.fragment.SmallPagerFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RadioButton rb_embarrassing_things;
    private RadioButton rb_circle;
    private RadioButton rb_live;
    private RadioButton rb_small_pager;
    private RadioButton rb_me;
    private FragmentManager supportFragmentManager;
    private FragmentTransaction fragmentTransaction;
    private EmbarrassingThingsFragment embarrassingThingsFrag;
    private EmbarrassingCircleFragment embarrassingCircleFrag;
    private LiveFragment liveFrag;
    private SmallPagerFragment smallPagerFrag;
    private MeFragment meFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //拿到管理者实例
        supportFragmentManager = getSupportFragmentManager();
        initView();
    }

    private void initView() {
        rb_embarrassing_things = (RadioButton) findViewById(R.id.main_rb_embarrassing_things);
        rb_circle = (RadioButton) findViewById(R.id.main_rb_circle);
        rb_live = (RadioButton) findViewById(R.id.main_rb_live);
        rb_small_pager = (RadioButton) findViewById(R.id.main_rb_small_pager);
        rb_me = (RadioButton) findViewById(R.id.main_rb_me);
        //绑定监听事件
        rb_embarrassing_things.setOnClickListener(this);
        rb_circle.setOnClickListener(this);
        rb_live.setOnClickListener(this);
        rb_small_pager.setOnClickListener(this);
        rb_me.setOnClickListener(this);
        //进入页面显示第一个糗事布局
        setClick(1);
    }

    @Override
    public void onClick(View view) {
        resetRadioButton();
        int position = 0;
        switch (view.getId()){
            case R.id.main_rb_embarrassing_things:
                rb_embarrassing_things.setSelected(true);
                position = 1;
                break;
            case R.id.main_rb_circle:
                rb_circle.setSelected(true);
                position =2;
                break;
            case R.id.main_rb_live:
                rb_live.setSelected(true);
                position=3;
                break;
            case R.id.main_rb_small_pager:
                rb_small_pager.setSelected(true);
                position=4;
                break;
            case R.id.main_rb_me:
                rb_me.setSelected(true);
                position = 5;
                break;
        }
        //通过setClick()传入不同的position,切换fragment的显示
        setClick(position);
    }

    private void setClick(int position) {
        fragmentTransaction = supportFragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);
        switch (position) {
            case 1:
                if (embarrassingThingsFrag == null) {
                    embarrassingThingsFrag = new EmbarrassingThingsFragment();
                    fragmentTransaction.add(R.id.main_frame_layout, embarrassingThingsFrag);
                } else {
                    fragmentTransaction.show(embarrassingThingsFrag);
                }
                break;
            case 2:
                if (embarrassingCircleFrag == null) {
                    embarrassingCircleFrag = new EmbarrassingCircleFragment();
                    fragmentTransaction.add(R.id.main_frame_layout, embarrassingCircleFrag);
                } else {
                    fragmentTransaction.show(embarrassingCircleFrag);
                }
                break;
            case 3:
                if (liveFrag == null) {
                    liveFrag = new LiveFragment();
                    fragmentTransaction.add(R.id.main_frame_layout, liveFrag);
                } else {
                    fragmentTransaction.show(liveFrag);
                }
                break;
            case 4:
                if (smallPagerFrag == null) {
                    smallPagerFrag = new SmallPagerFragment();
                    fragmentTransaction.add(R.id.main_frame_layout, smallPagerFrag);
                } else {
                    fragmentTransaction.show(smallPagerFrag);
                }
                break;
            case 5:
                if (meFrag == null) {
                    meFrag = new MeFragment();
                    fragmentTransaction.add(R.id.main_frame_layout, meFrag);
                } else {
                    fragmentTransaction.show(meFrag);
                }
                break;
        }
        //提交事务
        fragmentTransaction.commit();
    }
    /**
     * 隐藏已经存在的所有fragment
     *
     * @param fragmentTransaction
     */
    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if (embarrassingThingsFrag != null) {
            fragmentTransaction.hide(embarrassingThingsFrag);
        }
        if (embarrassingCircleFrag != null) {
            fragmentTransaction.hide(embarrassingCircleFrag);
        }
        if (liveFrag != null) {
            fragmentTransaction.hide(liveFrag);
        }
        if (smallPagerFrag != null) {
            fragmentTransaction.hide(smallPagerFrag);
        }
        if (meFrag != null) {
            fragmentTransaction.hide(meFrag);
        }
    }

    /**
     * 重置RadioButton的属性
     */
    private void resetRadioButton(){
        rb_embarrassing_things.setSelected(false);
        rb_circle.setSelected(false);
        rb_live.setSelected(false);
        rb_small_pager.setSelected(false);
        rb_me.setSelected(false);
    }
}
