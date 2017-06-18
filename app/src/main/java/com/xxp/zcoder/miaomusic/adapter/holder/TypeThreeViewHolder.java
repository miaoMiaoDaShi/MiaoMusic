package com.xxp.zcoder.miaomusic.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xxp.zcoder.miaomusic.R;
import com.xxp.zcoder.miaomusic.adapter.MultiRVAdapter;
import com.xxp.zcoder.miaomusic.entity.HomeInfo;
import com.xxp.zcoder.miaomusic.entity.MultiInfo;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/15
 * Description :
 */

public class TypeThreeViewHolder extends TypeAbstractViewHolder<MultiInfo> {

    TextView mTvItemThreeTitle;
    TextView mTvItemThreeDes;

    public TypeThreeViewHolder(final MultiRVAdapter.OnItemClickListener onItemClickListener, View itemView) {
        super(onItemClickListener,itemView);
        mTvItemThreeTitle = (TextView) itemView.findViewById(R.id.tv_item_three_title);
        mTvItemThreeDes = (TextView) itemView.findViewById(R.id.tv_three_des);
    }

    @Override
    public void bindHolder(MultiInfo model) {
        mTvItemThreeTitle.setText(model.getTitleOne());
        mTvItemThreeDes.setText(model.getDesOne());
    }
}
