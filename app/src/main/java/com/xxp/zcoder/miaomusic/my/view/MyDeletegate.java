package com.xxp.zcoder.miaomusic.my.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xxp.zcoder.miaomusic.R;
import com.xxp.zcoder.miaomusic.ZcoderApp;
import com.xxp.zcoder.miaomusic.adapter.MultiRVAdapter;
import com.xxp.zcoder.miaomusic.entity.MultiInfo;
import com.xxp.zcoder.miaomusic.entity.MyInfo;
import com.xxp.zcoder.mvp.view.AppDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public class MyDeletegate extends AppDelegate {

    @Override
    public void initView() {

    }

    public MultiRVAdapter setUpRecyclerView(MultiRVAdapter.OnItemClickListener onItemClickListener) {
        RecyclerView recyclerView = getView(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(ZcoderApp.getContext(),
                LinearLayoutManager.VERTICAL, false));
        List<MultiInfo> multiInfos = getDatas();
        MultiRVAdapter adapter = new MultiRVAdapter(multiInfos, this.getActivity());
        recyclerView.setAdapter(adapter);

        adapter.setOnClickListener(onItemClickListener);
        return adapter;
    }


    @Override
    protected int getRootLayoutId() {
        return R.layout.fragment_recycler_view;
    }

    public List<MultiInfo> getDatas() {
        List<MultiInfo> datas = new ArrayList<>();

        MultiInfo multiInfoA = new MultiInfo(4);
        multiInfoA.setImageUrl("http://yangyan-1252246683.cosgz.myqcloud.com/yangyan/image/banner_1_20170507.png");
        multiInfoA.setTitleOne("1340751953@qq.com");


        MultiInfo multiInfoB = new MultiInfo(2);
        multiInfoB.setTitleOne("本地歌曲");
        multiInfoB.setDesOne("109");


        MultiInfo multiInfoD = new MultiInfo(1);
        multiInfoD.setTitleOne("最近播放");
        multiInfoD.setDesOne("100");

        MultiInfo multiInfoE = new MultiInfo("我的歌单", "更多");

        MultiInfo multiInfoF = new MultiInfo();
        multiInfoF.setType(5);
        multiInfoF.setTitleOne("成全-刘若英");
        multiInfoF.setTitleTwo("凡人歌-郭金腾");
        multiInfoF.setTitleThree("Layee-pianoboy");

        MultiInfo multiInfoC = new MultiInfo(2);
        multiInfoC.setTitleOne("关于");
        multiInfoC.setDesOne("");

        MultiInfo multiInfoH = new MultiInfo(2);
        multiInfoH.setTitleOne("设置");
        multiInfoH.setDesOne("");

        datas.add(multiInfoA);
        datas.add(multiInfoB);
        datas.add(multiInfoD);
        datas.add(multiInfoE);
        datas.add(multiInfoF);
        datas.add(multiInfoH);
        datas.add(multiInfoC);
        return datas;
    }
}
