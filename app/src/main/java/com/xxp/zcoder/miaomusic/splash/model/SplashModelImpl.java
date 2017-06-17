package com.xxp.zcoder.miaomusic.splash.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.xxp.zcoder.miaomusic.entity.SplashInfo;
import com.xxp.zcoder.miaomusic.http.HttpCallback;
import com.xxp.zcoder.miaomusic.http.HttpClient;
import com.xxp.zcoder.miaomusic.utlis.FileUtlis;

import java.io.File;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public class SplashModelImpl implements ISplashModel {

    private static final String SPLASH_IMAGE_NAME = "bg_splash.jpg";

    @Override
    public void getSplashJson(HttpCallback<SplashInfo> httpCallBack) {
        HttpClient.loadSplashJson(HttpClient.SPLASH_URL, httpCallBack);
    }

    @Override
    public void downloadImage(String url, HttpCallback<File> httpCallBack) {
        HttpClient.downloadFile(url, FileUtlis.getSplashDir(), SPLASH_IMAGE_NAME, httpCallBack);
    }

    @Override
    public Bitmap getBitmap(String path) {
        Bitmap splahBitmap = BitmapFactory.decodeFile(path + File.separator + SPLASH_IMAGE_NAME);
        return splahBitmap;
    }
}
