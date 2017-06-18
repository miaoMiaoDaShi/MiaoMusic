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

public class TypeFiveViewHolder extends TypeAbstractViewHolder<MultiInfo> {
    TextView mTvItemFiveTitleOne;
    TextView mTvItemFiveTitleTwo;
    TextView mTvItemFiveTitleThree;
    ImageView mTvItemFiveImage;


    public TypeFiveViewHolder(final MultiRVAdapter.OnItemClickListener onItemClickListener, View itemView) {
        super(onItemClickListener,itemView);
        mTvItemFiveTitleOne = (TextView) itemView.findViewById(R.id.tv_item_five_One);
        mTvItemFiveTitleTwo = (TextView) itemView.findViewById(R.id.tv_item_five_Two);
        mTvItemFiveTitleThree = (TextView) itemView.findViewById(R.id.tv_item_five_Three);
        mTvItemFiveImage = (ImageView) itemView.findViewById(R.id.iv_item_five_image);

    }

    @Override
    public void bindHolder(MultiInfo model) {
        mTvItemFiveTitleOne.setText(model.getTitleOne());
        mTvItemFiveTitleTwo.setText(model.getTitleTwo());
        mTvItemFiveTitleThree.setText(model.getTitleThree());
        Glide.with(itemView).load(model.getImageUrl()).into(mTvItemFiveImage);
    }
}
