package com.xxp.zcoder.miaomusic.adapter.holder;

import android.view.View;
import android.widget.TextView;

import com.xxp.zcoder.miaomusic.R;
import com.xxp.zcoder.miaomusic.entity.HomeInfo;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/15
 * Description :
 */

public class TypeOneViewHolder extends TypeAbstractViewHolder<HomeInfo> {
    TextView mTvTitle;

    public TypeOneViewHolder(View itemView) {
        super(itemView);
        mTvTitle = (TextView) itemView.findViewById(R.id.tv_item_title);
    }

    @Override
    public void bindHolder(HomeInfo model) {
        mTvTitle.setText(model.getTitle());
    }
}
