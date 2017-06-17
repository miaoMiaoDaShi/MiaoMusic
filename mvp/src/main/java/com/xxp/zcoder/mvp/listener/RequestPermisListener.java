package com.xxp.zcoder.mvp.listener;

import java.util.List;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description : 请求权限的监听
 */

public interface RequestPermisListener {
    void onGranted();
    void onDenide(List<String> permissions);
}
