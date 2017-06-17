package com.xxp.zcoder.mvp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description : 视图层代理接口
 */

public interface IDelegate {
    //创建视图
    void onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    //获得跟view
    View getRootView();


    void initView();

}
