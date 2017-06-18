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

public class TypeFourViewHolder extends TypeAbstractViewHolder<MultiInfo> {

    TextView mTvItemFourTitle;
    ImageView mIvItemFourImage;

    public TypeFourViewHolder(final MultiRVAdapter.OnItemClickListener onItemClickListener, View itemView) {
        super(onItemClickListener,itemView);
        mTvItemFourTitle = (TextView) itemView.findViewById(R.id.tv_item_four_title);
        mIvItemFourImage = (ImageView) itemView.findViewById(R.id.iv_item_four_image);
    }

    @Override
    public void bindHolder(MultiInfo model) {
        mTvItemFourTitle.setText(model.getTitleOne());
        Glide.with(itemView).load(model.getImageUrl()).into(mIvItemFourImage);
    }
}
