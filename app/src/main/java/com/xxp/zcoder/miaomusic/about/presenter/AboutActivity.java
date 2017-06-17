package com.xxp.zcoder.miaomusic.about.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.xxp.zcoder.miaomusic.R;
import com.xxp.zcoder.miaomusic.about.model.AboutModelImpl;
import com.xxp.zcoder.miaomusic.about.view.AboutDeletegate;
import com.xxp.zcoder.miaomusic.adapter.SingleLayoutAdapter;
import com.xxp.zcoder.miaomusic.utlis.ToastUtlis;
import com.xxp.zcoder.mvp.presenter.ActivityPresenter;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public class AboutActivity extends ActivityPresenter<AboutDeletegate, AboutModelImpl> implements SingleLayoutAdapter.OnClickListener, View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SingleLayoutAdapter adapter = getAppDelegate().setUpRecyclerView(this);
    }

    @Override
    public Class<AboutDeletegate> getDelegateClass() {
        return AboutDeletegate.class;
    }

    @Override
    public Class<AboutModelImpl> getModelClass() {
        return AboutModelImpl.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        getAppDelegate().getView(R.id.iv_toolbar).setOnClickListener(this);
    }

    @Override
    public void onClick(int position) {
        ToastUtlis.showToast(position + "");
    }

    @Override
    public void onLongClick(int position) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_toolbar:
                finish();
                break;
        }
    }
}
