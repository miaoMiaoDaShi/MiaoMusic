package com.xxp.zcoder.mvp.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public abstract class AppDelegate implements IDelegate {
    protected View mRootView;
    protected SparseArray<View> mViews;

    @Override
    public void onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViews = new SparseArray<>();
        mRootView = inflater.inflate(getRootLayoutId(), container, false);
    }


    protected abstract int getRootLayoutId();

    @Override
    public View getRootView() {
        return mRootView;
    }

    public <V extends View> V getView(int id) {
        V view = (V) mViews.get(id);
        if (view == null) {
            view = (V) mRootView.findViewById(id);
            mViews.put(id, view);
        }

        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener, int... ids) {
        if (ids != null) {
            for (int id : ids) {
                getView(id).setOnClickListener(onClickListener);
            }
        }
    }

    public <T extends Activity> T getActivity() {
        return (T) mRootView.getContext();
    }
}
