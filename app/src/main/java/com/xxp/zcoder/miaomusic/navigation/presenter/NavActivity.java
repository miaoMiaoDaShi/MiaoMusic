package com.xxp.zcoder.miaomusic.navigation.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.xxp.zcoder.miaomusic.R;
import com.xxp.zcoder.miaomusic.activity.MvpActivity;
import com.xxp.zcoder.miaomusic.entity.MusicInfo;
import com.xxp.zcoder.miaomusic.navigation.model.NavModel;
import com.xxp.zcoder.miaomusic.navigation.view.NavDelegate;
import com.xxp.zcoder.miaomusic.play.presenter.PlayActivity;
import com.xxp.zcoder.miaomusic.service.PlayService;

import java.io.Serializable;

public class NavActivity extends MvpActivity<NavDelegate, NavModel> implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (Build.VERSION.SDK_INT >= 21) {
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
//            getWindow().setNavigationBarColor(Color.TRANSPARENT);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }

    }


    @Override
    public Class<NavDelegate> getDelegateClass() {
        return NavDelegate.class;
    }

    @Override
    public Class<NavModel> getModelClass() {
        return NavModel.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        getAppDelegate().setOnClickListener(this, R.id.flPlayBar);
    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, NavActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.flPlayBar:
                PlayActivity.startAction(this);
                break;
        }
    }
}
