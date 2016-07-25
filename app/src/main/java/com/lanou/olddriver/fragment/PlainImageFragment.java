package com.lanou.olddriver.fragment;

import android.view.View;
import android.widget.TextView;

/**
 * Created by user on 2016/7/24.
 */
public class PlainImageFragment extends BaseFragment {
    @Override
    public View initView() {
        TextView tv = new TextView(getActivity());
        tv.setText(getContext().getClass().getName());
        return tv;
    }

    @Override
    public void setData() {

    }
}
