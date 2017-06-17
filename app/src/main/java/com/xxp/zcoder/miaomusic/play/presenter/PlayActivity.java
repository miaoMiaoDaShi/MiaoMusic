package com.xxp.zcoder.miaomusic.play.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.xxp.zcoder.miaomusic.R;
import com.xxp.zcoder.miaomusic.play.model.PlayModelImpl;
import com.xxp.zcoder.miaomusic.play.view.PlayDeletegate;
import com.xxp.zcoder.mvp.presenter.ActivityPresenter;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public class PlayActivity extends ActivityPresenter<PlayDeletegate, PlayModelImpl> implements View.OnClickListener {
    @Override
    public Class<PlayDeletegate> getDelegateClass() {
        return PlayDeletegate.class;
    }

    @Override
    public Class<PlayModelImpl> getModelClass() {
        return PlayModelImpl.class;
    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, PlayActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        getAppDelegate()
                .setOnClickListener(this, R.id.iv_like, R.id.iv_exit, R.id.iv_mode, R.id.iv_next,
                        R.id.iv_play, R.id.iv_prev);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_like:
                doLike();
                break;
            case R.id.iv_exit:
                finish();
                break;
            case R.id.iv_mode:
                changePlayMode();
                break;
            case R.id.iv_next:
                next();
                break;
            case R.id.iv_play:
                play();
                break;
            case R.id.iv_prev:
                previous();
                break;
        }
    }

    /**
     * 上一曲
     */
    private void previous() {

    }

    /**
     * 播放与暂停
     */
    private void play() {

    }

    /**
     * 下一曲
     */
    private void next() {

    }


    /**
     * 切换播放循环
     */
    private void changePlayMode() {

    }

    /**
     * 添加到喜欢
     */
    private void doLike() {
        //如果存在.则将其移除
    }
}
