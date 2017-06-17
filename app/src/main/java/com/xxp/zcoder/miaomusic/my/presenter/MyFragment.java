package com.xxp.zcoder.miaomusic.my.presenter;

import com.xxp.zcoder.miaomusic.my.model.MyModelImpl;
import com.xxp.zcoder.miaomusic.my.view.MyDeletegate;
import com.xxp.zcoder.mvp.presenter.FragmentPresenter;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public class MyFragment extends FragmentPresenter<MyDeletegate, MyModelImpl> {
    @Override
    public Class<MyDeletegate> getDelegateClass() {
        return MyDeletegate.class;
    }

    @Override
    public Class<MyModelImpl> getModelClass() {
        return MyModelImpl.class;
    }
}
