package com.xxp.zcoder.miaomusic.splash.presenter;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;

import com.xxp.zcoder.miaomusic.R;
import com.xxp.zcoder.miaomusic.navigation.presenter.NavActivity;
import com.xxp.zcoder.miaomusic.activity.MvpActivity;
import com.xxp.zcoder.miaomusic.entity.SplashInfo;
import com.xxp.zcoder.miaomusic.http.HttpCallback;
import com.xxp.zcoder.miaomusic.splash.model.SplashModelImpl;
import com.xxp.zcoder.miaomusic.splash.view.SplashDelegate;
import com.xxp.zcoder.miaomusic.utlis.FileUtlis;
import com.xxp.zcoder.miaomusic.utlis.PreferencesUtlis;
import com.xxp.zcoder.miaomusic.utlis.ToastUtlis;
import com.xxp.zcoder.mvp.base.BaseActivity;
import com.xxp.zcoder.mvp.listener.RequestPermisListener;

import java.io.File;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends MvpActivity<SplashDelegate, SplashModelImpl> {

    private static final String TAG = "SplashActivity";
    private static final String IMAGE_URL =
            "http://cn.bing.com%s_720x1280.jpg";
    private Timer mTimer;
    private final long DELAYED = 5000;
    //计时器计时是否完成
    private boolean mIsDone;

    //权限提示框是否在显示状态
    private boolean mIsShow;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startTimer();
        showSplah();
    }

    /**
     * 显示启动图
     */
    private void showSplah() {
        //检查权限
        int status = ContextCompat
                .checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (PackageManager.PERMISSION_GRANTED != status) {
            mIsShow = true;
            requestPermission();
        } else {
            loadLocalImage();
            loadInfoFormNet();
        }
    }

    private void requestPermission() {
        BaseActivity.requestPermission(
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                new RequestPermisListener() {
                    @Override
                    public void onGranted() {
                        mIsShow = false;
                        //假如计时器完毕,则直接跳到mainActivity
                        if (mIsDone) {
                            goMain();
                        }
                        loadLocalImage();
                        loadInfoFormNet();
                    }

                    @Override
                    public void onDenide(List<String> permissions) {
                        ToastUtlis.showLongToast("拒绝sd卡读取权限,软件将无法使用!");
                    }
                }
        );
    }

    /**
     * 获取网络上的每日的图片json信息
     */
    private void loadInfoFormNet() {
        Log.i(TAG, "loadInfoFormNet: ");
        getModel().getSplashJson(new HttpCallback<SplashInfo>() {
            @Override
            public void onSuccess(SplashInfo data) {
                Log.i(TAG, "onSuccess: "+data.toString());
                String netHsh = data.getImages().get(0).getHsh();
                String localHsh = PreferencesUtlis.getString("hsh", "");
                //通过比较hash值,判断是需要下载新的图片
                if (!TextUtils.equals(localHsh, netHsh)) {
                    String url = String.format(IMAGE_URL, data.getImages().get(0).getUrlbase());
                    Log.i(TAG, "onSuccess: 下载地址" + url);
                    downloadImage(url, netHsh);
                }
            }

            @Override
            public void onError(Exception e) {
                Log.e(TAG, "onError: ",e );
                ToastUtlis.showToast("阿欧!获取今日图片信息出错!");
            }

            @Override
            public void onDone() {
                Log.i(TAG, "onDone: ");
            }
        });
    }

    /**
     * 加载本地
     */
    private void loadLocalImage() {
        //尝试拿SD卡里的上次下载的image
        Bitmap splashBitmap = getModel().getBitmap(FileUtlis.getSplashDir());
        //如果为空,使用app默认的图片
        if (splashBitmap == null) {
            splashBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg_splash);
        }
        splashBitmap = Bitmap.createBitmap(splashBitmap, 0, 0, 720, 1100);
        //设置显示
        getAppDelegate()
                .setSplashImage(splashBitmap);
    }

    /**
     * 下载图片
     *
     * @param url 路径
     * @param hsh 传入hash
     */
    private void downloadImage(String url, final String hsh) {
        getModel()
                .downloadImage(
                        url
                        ,
                        new HttpCallback<File>() {
                            @Override
                            public void onSuccess(File data) {
                            }

                            @Override
                            public void onError(Exception e) {
                                ToastUtlis.showToast("下载今日图片出错!");
                            }

                            @Override
                            public void onDone() {
                                PreferencesUtlis.putString("hsh", hsh);
                            }
                        });
    }

    /**
     * 开启定时器
     */
    private void startTimer() {
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {

                mIsDone = true;

                if (!mIsShow) {
                    goMain();
                }
            }
        }, DELAYED);
    }

    /**
     * 到mainActivity
     */
    private void goMain() {
        NavActivity.startAction(this);
        finish();
    }

    @Override
    public Class getDelegateClass() {
        return SplashDelegate.class;
    }

    @Override
    public Class<SplashModelImpl> getModelClass() {
        return SplashModelImpl.class;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTimer.cancel();
        mTimer = null;
    }
}
