package com.xxp.zcoder.miaomusic;

import android.app.Application;
import android.content.Context;

import com.xxp.zcoder.miaomusic.utlis.PreferencesUtlis;
import com.xxp.zcoder.miaomusic.utlis.ToastUtlis;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public class ZcoderApp extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        PreferencesUtlis.init(this);
        ToastUtlis.init(this);
    }

    public static Context getContext() {
        return mContext;
    }
}
