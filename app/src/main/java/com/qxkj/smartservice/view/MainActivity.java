package com.qxkj.smartservice.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.qxkj.smartservice.R;
import com.qxkj.smartservice.base.BaseActivity;
import com.qxkj.smartservice.fragment.AgencyFragment;
import com.qxkj.smartservice.fragment.FlightFragment;
import com.qxkj.smartservice.fragment.MessageFragment;
import com.qxkj.smartservice.fragment.StatisticsFragment;
import com.qxkj.smartservice.widget.CustomToolbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.tablayout)
    VerticalTabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    List<String> mTitle;
    List<Fragment> mFragment;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void businessLogic(Bundle savedInstanceState) {
        CustomToolbar toolbar = getToolbar();
        setToolbarShow(View.VISIBLE);
        toolbar.setMainTitle(Color.WHITE,"我的代办（99999999）");
        ImageView iv1=new ImageView(this);
        View.OnClickListener listener1= v -> Toast.makeText(MainActivity.this,"点击了搜索按钮",Toast.LENGTH_SHORT).show();
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        lp.setMargins(0, 0, 20, 0);
        iv1.setLayoutParams(lp);
        toolbar.addRightChildView(iv1,R.mipmap.icon_query,listener1);
        ImageView iv2=new ImageView(this);
        View.OnClickListener listener2= v -> Toast.makeText(MainActivity.this,"测试按钮",Toast.LENGTH_SHORT).show();
        toolbar.addRightChildView(iv2,R.mipmap.placement,listener2);

        mTabLayout.setTabAdapter(new TabAdapter() {
            List<String> titles;
            List<Integer> srcs;
            {
                titles = new ArrayList<>();
                titles.add("代办");
                titles.add("航班");
                titles.add("统计");
                titles.add("消息");
                Collections.addAll(titles);
                srcs = new ArrayList<>();
                srcs.add(R.mipmap.backlog_normal);
                srcs.add(R.mipmap.dynamics_normal);
                srcs.add(R.mipmap.statistics_normal);
                srcs.add(R.mipmap.news_normal);
                Collections.addAll(srcs);
            }
            @Override
            public int getCount() {
                return titles.size();
            }

            @Override
            public TabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public QTabView.TabIcon getIcon(int position) {
                return new QTabView.TabIcon.Builder().setIcon(srcs.get(position),srcs.get(position)).build();
            }

            @Override
            public QTabView.TabTitle getTitle(int position) {
                return new QTabView.TabTitle.Builder()
                        .setContent(titles.get(position))
                        .setTextColor(Color.WHITE, Color.BLACK)
                        .build();
            }

            @Override
            public int getBackground(int position) {
                return 0;
            }
        });
//
//
//        mTitle = new ArrayList<>();
//        mTitle.add("代办");
//        mTitle.add("航班");
//        mTitle.add("统计");
//        mTitle.add("消息");
        mFragment = new ArrayList<>();
        mFragment.add(new AgencyFragment());
        mFragment.add(new FlightFragment());
        mFragment.add(new StatisticsFragment());
        mFragment.add(new MessageFragment());
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "";
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
//        mTabLayout.removeAllTabs();
//        int []srcs={R.mipmap.backlog_normal,R.mipmap.dynamics_normal,R.mipmap.statistics_normal,R.mipmap.news_normal};
//        for (int i = 0; i < 4; i++) {
//            TabLayout.Tab tt = mTabLayout.newTab();
//            tt.setText(mTitle.get(i));
//            tt.setIcon(getResources().getDrawable(srcs[i]));
//            mTabLayout.addTab(tt, i);
//        }
    }
}
