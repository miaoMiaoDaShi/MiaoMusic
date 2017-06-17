package com.xxp.zcoder.miaomusic.classify.presenter;

import com.xxp.zcoder.miaomusic.classify.model.ClassifyModelImpl;
import com.xxp.zcoder.miaomusic.classify.view.ClassifyDeletegate;
import com.xxp.zcoder.mvp.presenter.FragmentPresenter;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public class ClassifyFragment extends FragmentPresenter<ClassifyDeletegate, ClassifyModelImpl> {
    @Override
    public Class<ClassifyDeletegate> getDelegateClass() {
        return ClassifyDeletegate.class;
    }

    @Override
    public Class<ClassifyModelImpl> getModelClass() {
        return ClassifyModelImpl.class;
    }
}
