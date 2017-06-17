package com.xxp.zcoder.mvp.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xxp.zcoder.mvp.base.BaseActivity;
import com.xxp.zcoder.mvp.model.IModel;
import com.xxp.zcoder.mvp.view.IDelegate;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public abstract class ActivityPresenter<V extends IDelegate, M extends IModel> extends BaseActivity implements
        AppPresenter<V, M> {
    private V mDelegate;
    private M mModel;

    public ActivityPresenter() {
        createDelegate();
        createModel();
    }

    protected void bindEvenListener() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mDelegate.onCreate(getLayoutInflater(), null, savedInstanceState);
        setContentView(mDelegate.getRootView());
        mDelegate.initView();
        bindEvenListener();

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (mDelegate == null) {
            createDelegate();
        }
        if (mModel == null) {
            createModel();
        }
    }

    @Override
    public V getAppDelegate() {
        return mDelegate;
    }

    @Override
    public M getModel() {
        return mModel;
    }

    @Override
    public void createDelegate() {
        try {
            mDelegate = getDelegateClass().newInstance();
        } catch (java.lang.InstantiationException e) {
            new RuntimeException("create delegate");
        } catch (IllegalAccessException e) {
            new RuntimeException("create delegate");
        }
    }

    @Override
    public void createModel() {
        try {
            mModel = getModelClass().newInstance();
        } catch (java.lang.InstantiationException e) {
            new RuntimeException("create model");
        } catch (IllegalAccessException e) {
            new RuntimeException("create model");
        }
    }

}
