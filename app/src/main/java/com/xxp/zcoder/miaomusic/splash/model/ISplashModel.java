package com.xxp.zcoder.miaomusic.splash.model;

import android.graphics.Bitmap;

import com.xxp.zcoder.miaomusic.entity.SplashInfo;
import com.xxp.zcoder.miaomusic.http.HttpCallback;
import com.xxp.zcoder.mvp.model.IModel;

import java.io.File;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public interface ISplashModel extends IModel {
    //加载splash  json信息
    void getSplashJson(HttpCallback<SplashInfo> httpCallBack);
    //下载图片
    void downloadImage(String String,HttpCallback<File> httpCallBack);
    //获取图片
    Bitmap getBitmap(String path);
}
