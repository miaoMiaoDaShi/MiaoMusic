package com.xxp.zcoder.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xxp.zcoder.mvp.base.BaseFragment;
import com.xxp.zcoder.mvp.model.IModel;
import com.xxp.zcoder.mvp.view.IDelegate;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public abstract class FragmentPresenter<V extends IDelegate,M extends IModel> extends BaseFragment implements AppPresenter<V,M> {
    private V mDelegate;
    private M mModel;

    public FragmentPresenter() {
        createDelegate();
        createModel();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDelegate.onCreate(inflater, container, savedInstanceState);
        mDelegate.initView();
        bindEvenListener();
        return mDelegate.getRootView();
    }

    protected void bindEvenListener() {

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        createDelegate();
        createModel();
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

    @Override
    public M getModel() {
        return mModel;
    }

    @Override
    public V getAppDelegate() {
        return mDelegate;
    }

}
