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

public class TypeTwoViewHolder extends TypeAbstractViewHolder<MultiInfo> {
    View mViwe;
    TextView mTvItemTwoTitle;
    TextView mTvItemTwoDes;

    public TypeTwoViewHolder(final MultiRVAdapter.OnItemClickListener onItemClickListener, View itemView) {
        super(onItemClickListener,itemView);
        mTvItemTwoTitle = (TextView) itemView.findViewById(R.id.tv_item_two_title);
        mTvItemTwoDes = (TextView) itemView.findViewById(R.id.tv_item_two_des);
        mViwe = itemView.findViewById(R.id.v_item_two);

    }

    @Override
    public void bindHolder(MultiInfo model) {
        mTvItemTwoTitle.setText(model.getTitleOne());
        mTvItemTwoDes.setText(model.getDesOne());
    }
}
