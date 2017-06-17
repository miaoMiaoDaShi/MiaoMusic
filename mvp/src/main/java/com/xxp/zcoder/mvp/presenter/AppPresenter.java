package com.xxp.zcoder.mvp.presenter;

import android.app.Activity;

import com.xxp.zcoder.mvp.model.IModel;
import com.xxp.zcoder.mvp.view.IDelegate;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public interface AppPresenter<V extends IDelegate,M extends IModel> {

    V getAppDelegate();

    void createDelegate();

    Class<V> getDelegateClass();

    M getModel();

    void createModel();

    Class<M> getModelClass();

}
