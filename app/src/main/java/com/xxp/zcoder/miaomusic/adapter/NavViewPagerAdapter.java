package com.xxp.zcoder.miaomusic.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.xxp.zcoder.miaomusic.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public class NavViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mPages;
    private Context mContext;

    public NavViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mPages = new ArrayList<>();
        mContext = context;
    }

    @Override
    public int getCount() {
        return mPages.size();
    }

    @Override
    public Fragment getItem(int i) {
        return mPages.get(i);
    }

    public void addFragment(Fragment fragment) {
        mPages.add(fragment);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getStringArray(R.array.nav_title)[position];
    }
}
