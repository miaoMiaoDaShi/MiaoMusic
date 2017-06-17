package com.xxp.zcoder.miaomusic.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xxp.zcoder.miaomusic.R;
import com.xxp.zcoder.miaomusic.entity.HomeInfo;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/15
 * Description :
 */

public class TypeTwoViewHolder extends TypeAbstractViewHolder<HomeInfo> {
    TextView mTvSongOne;
    TextView mTvSongTwo;
    TextView mTvSongThree;
    ImageView mIvSongsImage;

    public TypeTwoViewHolder(View itemView) {
        super(itemView);
        mTvSongOne = (TextView) itemView.findViewById(R.id.tvItemSongListOne);
        mTvSongTwo = (TextView) itemView.findViewById(R.id.tvItemSongListTwo);
        mTvSongThree = (TextView) itemView.findViewById(R.id.tvItemSongListThree);
        mIvSongsImage = (ImageView) itemView.findViewById(R.id.ivItemSongList);

    }

    @Override
    public void bindHolder(HomeInfo model) {
        Glide.with(itemView.getContext()).load(model.getImageUrl()).into(mIvSongsImage);
        mTvSongOne.setText(model.getSongOneTitle());
        mTvSongTwo.setText(model.getSongTwoTitle());
        mTvSongThree.setText(model.getSongThreeTitle());
    }
}
