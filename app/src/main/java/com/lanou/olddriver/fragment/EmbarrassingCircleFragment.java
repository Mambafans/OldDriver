package com.lanou.olddriver.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.lanou.olddriver.R;
import com.lanou.olddriver.adapter.EmbarrassingPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/7/23.
 */
public class EmbarrassingCircleFragment extends BaseFragment implements View.OnClickListener {
    private Button btn_next_door;
    private Button btn_have_powder;
    private Button btn_video;
    private Button btn_topic;
    private Button current_button;
    private ViewPager embarrassing_circle_vp;
    private List<BaseFragment> embarrassing_circle_list;
    private EmbarrassingPagerAdapter adapter;

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.frag_embarrassing_circle, null);
        btn_next_door = (Button) view.findViewById(R.id.embarrassing_circle_btn_next);
        btn_have_powder = (Button) view.findViewById(R.id.embarrassing_circle_btn_have_powder);
        btn_video = (Button) view.findViewById(R.id.embarrassing_circle_btn_video_circle);
        btn_topic = (Button) view.findViewById(R.id.embarrassing_circle_btn_topic);
        current_button = btn_next_door;
        setCurrentIndicator(current_button);
        embarrassing_circle_vp = (ViewPager) view.findViewById(R.id.embarrassing_circle_vp);
        embarrassing_circle_list = new ArrayList<>();
        adapter = new EmbarrassingPagerAdapter(getChildFragmentManager(), embarrassing_circle_list, getActivity());
        setListData();
        embarrassing_circle_vp.setAdapter(adapter);
        btn_next_door.setOnClickListener(this);
        btn_have_powder.setOnClickListener(this);
        btn_video.setOnClickListener(this);
        btn_topic.setOnClickListener(this);
        return view;
    }


    private void setListData() {
        NextDoorFragment nextDoorFrag = new NextDoorFragment();
        HavePowderFragment havePowderFrag = new HavePowderFragment();
        CircleVideoFragment circleVideoFrag = new CircleVideoFragment();
        TopicFragment topicFrag = new TopicFragment();
        embarrassing_circle_list.add(nextDoorFrag);
        embarrassing_circle_list.add(havePowderFrag);
        embarrassing_circle_list.add(circleVideoFrag);
        embarrassing_circle_list.add(topicFrag);
    }

    @Override
    public void setData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.embarrassing_circle_btn_next:
                break;
            case R.id.embarrassing_circle_btn_have_powder:
                break;
            case R.id.embarrassing_circle_btn_video_circle:
                break;
            case R.id.embarrassing_circle_btn_topic:
                break;
        }
        setCurrentIndicator((Button) v);
    }

    private void setCurrentIndicator(Button button) {
        current_button.setTextColor(getResources().getColor(R.color.lightWhite));
        current_button.setTextSize(14);
        current_button = button;
        current_button.setTextColor(getResources().getColor(R.color.white));
        current_button.setTextSize(18);
    }
}
