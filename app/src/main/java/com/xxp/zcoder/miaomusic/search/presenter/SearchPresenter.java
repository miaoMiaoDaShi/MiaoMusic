package com.xxp.zcoder.miaomusic.search.presenter;

import com.xxp.zcoder.miaomusic.search.model.SearchModelImpl;
import com.xxp.zcoder.miaomusic.search.view.SearchDeletegate;
import com.xxp.zcoder.mvp.presenter.FragmentPresenter;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public class SearchPresenter extends FragmentPresenter<SearchDeletegate, SearchModelImpl> {
    @Override
    public Class<SearchDeletegate> getDelegateClass() {
        return SearchDeletegate.class;
    }

    @Override
    public Class<SearchModelImpl> getModelClass() {
        return SearchModelImpl.class;
    }
}
