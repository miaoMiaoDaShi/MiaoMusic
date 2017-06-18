package com.xxp.zcoder.miaomusic.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xxp.zcoder.miaomusic.R;
import com.xxp.zcoder.miaomusic.adapter.MultiRVAdapter;
import com.xxp.zcoder.miaomusic.entity.MultiInfo;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/15
 * Description :
 */

public class TypeSixViewHolder extends TypeAbstractViewHolder<MultiInfo> {

    TextView mTvItemSixTitle;
    TextView mTvItemSixDes;
    ImageView mIvItemSixImage;

    public TypeSixViewHolder(final MultiRVAdapter.OnItemClickListener onItemClickListener, View itemView) {
        super(onItemClickListener,itemView);
        mTvItemSixTitle = (TextView) itemView.findViewById(R.id.tv_item_six_title);
        mTvItemSixDes = (TextView) itemView.findViewById(R.id.tv_item_six_des);
        mIvItemSixImage = (ImageView) itemView.findViewById(R.id.iv_item_six_image);
    }

    @Override
    public void bindHolder(MultiInfo model) {
        mTvItemSixTitle.setText(model.getTitleOne());
        mTvItemSixDes.setText(model.getDesOne());
        Glide.with(itemView).load(model.getImageUrl()).into(mIvItemSixImage);
    }
}
