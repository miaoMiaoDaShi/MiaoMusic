package com.xxp.zcoder.miaomusic.home.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xxp.zcoder.miaomusic.R;
import com.xxp.zcoder.miaomusic.ZcoderApp;
import com.xxp.zcoder.miaomusic.adapter.HomeRVAdapter;
import com.xxp.zcoder.miaomusic.entity.HomeInfo;
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
        List<HomeInfo> homeInfos = getHomeInfos();
        HomeRVAdapter homeRVAdapter = new HomeRVAdapter(homeInfos, getActivity());
        recyclerView.setAdapter(homeRVAdapter);
    }

    private List<HomeInfo> getHomeInfos() {
        List<HomeInfo> homeInfos = new ArrayList<>();

        HomeInfo title1 = new HomeInfo(1, "今日推荐");
        homeInfos.add(title1);

        HomeInfo songs = new HomeInfo(2);
        homeInfos.add(songs);
        songs.setSongOneTitle("成全-刘若英");
        songs.setSongTwoTitle("凡人歌-郭金腾");
        songs.setSongThreeTitle("Layee-pianoboy");

        HomeInfo title2 = new HomeInfo(1, "新碟首发");
        homeInfos.add(title2);

        HomeInfo title3 = new HomeInfo(3);
        title3.setAlbumOneTitle("青春的纪念品");
        title3.setAlbumOnedes("陈直");
        title3.setAlbumTwoTitle("他们都走了");
        title3.setAlbumTwodes("盐池");
        title3.setAlbumThreeTitle("算了");
        title3.setAlbumThreedes("崔啊咋");
        homeInfos.add(title3);

        HomeInfo title4 = new HomeInfo(3);
        title4.setAlbumOneTitle("青春的纪念品");
        title4.setAlbumOnedes("陈直");
        title4.setAlbumThreeTitle("算了");
        title4.setAlbumThreedes("崔啊咋");
        homeInfos.add(title4);

        return homeInfos;
    }


    @Override
    protected int getRootLayoutId() {
        return R.layout.fragment_recycler_view;
    }
}
