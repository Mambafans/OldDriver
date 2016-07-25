package com.lanou.olddriver.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lanou.olddriver.fragment.BaseFragment;

import java.util.List;

/**
 * Created by user on 2016/7/24.
 */
public class EmbarrassingPagerAdapter extends FragmentPagerAdapter {
    List<BaseFragment> embarrassing_list;
    Context context;

    public EmbarrassingPagerAdapter(FragmentManager fm, List<BaseFragment> embarrassing_list, Context context) {
        super(fm);
        this.embarrassing_list = embarrassing_list;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return embarrassing_list.get(position);
    }

    @Override
    public int getCount() {
        return embarrassing_list.size();
    }
}
