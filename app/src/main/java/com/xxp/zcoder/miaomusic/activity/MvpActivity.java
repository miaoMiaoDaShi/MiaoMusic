package com.xxp.zcoder.miaomusic.activity;

import com.xxp.zcoder.mvp.model.IModel;
import com.xxp.zcoder.mvp.presenter.ActivityPresenter;
import com.xxp.zcoder.mvp.view.IDelegate;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public abstract class MvpActivity<V extends IDelegate,M extends IModel> extends ActivityPresenter<V,M> {
}
