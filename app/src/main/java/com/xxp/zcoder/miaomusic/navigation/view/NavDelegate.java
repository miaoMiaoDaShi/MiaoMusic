package com.xxp.zcoder.miaomusic.navigation.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.xxp.zcoder.miaomusic.R;
import com.xxp.zcoder.miaomusic.ZcoderApp;
import com.xxp.zcoder.miaomusic.adapter.NavViewPagerAdapter;
import com.xxp.zcoder.miaomusic.entity.MusicInfo;
import com.xxp.zcoder.miaomusic.home.presenter.HomeFragment;
import com.xxp.zcoder.miaomusic.play.presenter.PlayActivity;
import com.xxp.zcoder.mvp.view.AppDelegate;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public class NavDelegate extends AppDelegate implements INavDelegate {
    private static final String TAG = "NavDelegate";

    @Override
    public void initView() {
        setUpViewPager();
    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void setUpViewPager() {
        Log.i(TAG, "setUpViewPager: ");
        TabLayout tabLayout = getView(R.id.tabs);
        ViewPager viewPager = getView(R.id.vpContent);
        NavViewPagerAdapter adapter = new NavViewPagerAdapter(ZcoderApp.getContext(),
                ((AppCompatActivity) getActivity()).getSupportFragmentManager());

        Fragment fragment = null;

        fragment = new HomeFragment();
        adapter.addFragment(fragment);

        fragment = new HomeFragment();
        adapter.addFragment(fragment);

        fragment = new HomeFragment();
        adapter.addFragment(fragment);

        fragment = new HomeFragment();
        adapter.addFragment(fragment);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public void setPause() {

    }

    @Override
    public void setStop() {

    }

    @Override
    public void setPlay() {

    }

    @Override
    public void updateMusic(MusicInfo musicInfo) {

    }


}
