package com.xxp.zcoder.miaomusic.adapter.holder;

import android.view.View;
import android.widget.TextView;

import com.xxp.zcoder.miaomusic.R;
import com.xxp.zcoder.miaomusic.adapter.MultiRVAdapter;
import com.xxp.zcoder.miaomusic.entity.MultiInfo;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/15
 * Description :
 */

public class TypeOneViewHolder extends TypeAbstractViewHolder<MultiInfo> {
    TextView mTvItemOneTitle;
    TextView mTvItemOneDes;
    View mView;

    public TypeOneViewHolder(final MultiRVAdapter.OnItemClickListener onItemClickListener, View itemView) {
        super(onItemClickListener,itemView);
        mTvItemOneTitle = (TextView) itemView.findViewById(R.id.tv_item_one_title);
        mTvItemOneDes = (TextView) itemView.findViewById(R.id.tv_item_one_des);
        mView = itemView.findViewById(R.id.v_item_one_bg);
    }

    @Override
    public void bindHolder(MultiInfo model) {
        mTvItemOneTitle.setText(model.getTitleOne());
        mTvItemOneDes.setText(model.getDesOne());
    }
}
