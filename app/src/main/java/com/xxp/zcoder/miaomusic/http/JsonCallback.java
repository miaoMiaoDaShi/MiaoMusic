package com.xxp.zcoder.miaomusic.http;


import com.google.gson.Gson;
import com.xxp.zcoder.miaomusic.entity.SplashInfo;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public abstract class JsonCallback<C> extends Callback<C> {

    private Class<C> mClass;

    public JsonCallback(Class<C> cClass) {
        mClass = cClass;
    }

    @Override
    public C parseNetworkResponse(Response response, int i) throws Exception {
        String json = response.body().string();
        Gson gson = new Gson();
        return gson.fromJson(json, mClass);
    }

}
