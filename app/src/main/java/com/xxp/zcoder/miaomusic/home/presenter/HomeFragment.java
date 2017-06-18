package com.xxp.zcoder.miaomusic.home.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xxp.zcoder.miaomusic.entity.MusicInfo;
import com.xxp.zcoder.miaomusic.home.model.HomeModelImpl;
import com.xxp.zcoder.miaomusic.home.view.HomeDeletegate;
import com.xxp.zcoder.miaomusic.service.PlayService;
import com.xxp.zcoder.mvp.presenter.FragmentPresenter;

import java.io.Serializable;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public class HomeFragment extends FragmentPresenter<HomeDeletegate, HomeModelImpl> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recover();

    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
    }

    /**
     * 恢复上次推出的歌曲状态
     */
    private void recover() {
        MusicInfo musicInfo = getModel().getLastTimeMusic();
        Intent intent = new Intent(getActivity(), PlayService.class);
        intent.setAction(PlayService.ACTION_RECOVER);
        intent.putExtra(PlayService.KEY_RECOVER, (Serializable) musicInfo);
        getActivity().startService(intent);
    }

    @Override
    public Class<HomeDeletegate> getDelegateClass() {
        return HomeDeletegate.class;
    }

    @Override
    public Class<HomeModelImpl> getModelClass() {
        return HomeModelImpl.class;
    }
}
