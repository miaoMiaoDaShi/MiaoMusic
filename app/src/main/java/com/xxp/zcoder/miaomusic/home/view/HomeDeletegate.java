package com.xxp.zcoder.miaomusic.home.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xxp.zcoder.miaomusic.R;
import com.xxp.zcoder.miaomusic.ZcoderApp;
import com.xxp.zcoder.miaomusic.adapter.MultiRVAdapter;
import com.xxp.zcoder.miaomusic.entity.HomeInfo;
import com.xxp.zcoder.miaomusic.entity.MultiInfo;
import com.xxp.zcoder.mvp.view.AppDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public class HomeDeletegate extends AppDelegate {
    @Override
    public void initView() {
        RecyclerView recyclerView = getView(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(ZcoderApp.getContext(),
                LinearLayoutManager.VERTICAL, false));
        List<MultiInfo> multiInfos = getMultiInfos();
        MultiRVAdapter adapter = new MultiRVAdapter(multiInfos, getActivity());
        recyclerView.setAdapter(adapter);
    }

    private List<MultiInfo> getMultiInfos() {
        List<MultiInfo> multiInfos = new ArrayList<>();

        MultiInfo multiInfoA = new MultiInfo("今日推荐歌单(30)", "更多");

        MultiInfo multiInfoB = new MultiInfo();
        multiInfoB.setType(5);
        multiInfoB.setTitleOne("成全-刘若英");
        multiInfoB.setTitleTwo("凡人歌-郭金腾");
        multiInfoB.setTitleThree("Layee-pianoboy");

        MultiInfo multiInfoC = new MultiInfo("其他热门(30)", "更多");

        MultiInfo multiInfoD = new MultiInfo();
        multiInfoD.setType(5);
        multiInfoD.setTitleOne("成全-刘若英");
        multiInfoD.setTitleTwo("凡人歌-郭金腾");
        multiInfoD.setTitleThree("Layee-pianoboy");


        multiInfos.add(multiInfoA);
        multiInfos.add(multiInfoB);
        multiInfos.add(multiInfoC);
        multiInfos.add(multiInfoD);


        return multiInfos;
    }


    @Override
    protected int getRootLayoutId() {
        return R.layout.fragment_recycler_view;
    }
}
