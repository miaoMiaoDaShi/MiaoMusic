package com.xxp.zcoder.miaomusic.http;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description : 网络访问状态监听
 */

public interface HttpCallback<T> {
    void onSuccess(T data);
    void onError(Exception e);
    void onDone();
}
