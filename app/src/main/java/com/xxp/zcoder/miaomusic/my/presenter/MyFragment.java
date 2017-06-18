package com.xxp.zcoder.miaomusic.my.presenter;

import com.xxp.zcoder.miaomusic.adapter.MultiRVAdapter;
import com.xxp.zcoder.miaomusic.my.model.MyModelImpl;
import com.xxp.zcoder.miaomusic.my.view.MyDeletegate;
import com.xxp.zcoder.mvp.presenter.FragmentPresenter;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public class MyFragment extends FragmentPresenter<MyDeletegate, MyModelImpl> implements MultiRVAdapter.OnItemClickListener {

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        getAppDelegate().setUpRecyclerView(this);
    }

    @Override
    public Class<MyDeletegate> getDelegateClass() {
        return MyDeletegate.class;
    }

    @Override
    public Class<MyModelImpl> getModelClass() {
        return MyModelImpl.class;
    }

    @Override
    public void onClick(int position) {

    }

    @Override
    public void onLongClick(int position) {

    }
}
