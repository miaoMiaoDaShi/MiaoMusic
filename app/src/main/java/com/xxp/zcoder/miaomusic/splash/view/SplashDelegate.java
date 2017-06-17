package com.xxp.zcoder.miaomusic.splash.view;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.xxp.zcoder.miaomusic.R;
import com.xxp.zcoder.mvp.view.AppDelegate;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public class SplashDelegate extends AppDelegate {
    @Override
    public void initView() {}


    //设置splash的背景
    public void setSplashImage(Bitmap bitmap) {
        ImageView ivSplashImage = (getView(R.id.ivSplashImage));
        ivSplashImage.setImageBitmap(bitmap);
    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.activity_splash;
    }
}
