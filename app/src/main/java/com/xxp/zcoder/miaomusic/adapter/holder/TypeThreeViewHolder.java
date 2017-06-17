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

public class TypeThreeViewHolder extends TypeAbstractViewHolder<HomeInfo> {
    ImageView mTvAlbumImageA;
    ImageView mTvAlbumImageB;
    ImageView mTvAlbumImageC;

    TextView mTvAlbumTitleA;
    TextView mTvAlbumTitleB;
    TextView mTvAlbumTitleC;
    TextView mTvAlbumDesA;
    TextView mTvAlbumDesB;
    TextView mTvAlbumDesC;


    public TypeThreeViewHolder(View itemView) {
        super(itemView);
        mTvAlbumImageA = (ImageView) itemView.findViewById(R.id.iv_item_list_grid_a);
        mTvAlbumImageB = (ImageView) itemView.findViewById(R.id.iv_item_list_grid_b);
        mTvAlbumImageC = (ImageView) itemView.findViewById(R.id.iv_item_list_grid_c);

        mTvAlbumTitleA = (TextView) itemView.findViewById(R.id.tv_item_list_grid_title_a);
        mTvAlbumTitleB = (TextView) itemView.findViewById(R.id.tv_item_list_grid_title_b);
        mTvAlbumTitleC = (TextView) itemView.findViewById(R.id.tv_item_list_grid_title_c);

        mTvAlbumDesA = (TextView) itemView.findViewById(R.id.tv_item_list_grid_des_a);
        mTvAlbumDesB = (TextView) itemView.findViewById(R.id.tv_item_list_grid_des_b);
        mTvAlbumDesC = (TextView) itemView.findViewById(R.id.tv_item_list_grid_des_c);

    }

    @Override
    public void bindHolder(HomeInfo model) {
        Glide.with(itemView.getContext()).load(model.getImageUrl()).into(mTvAlbumImageA);
        Glide.with(itemView.getContext()).load(model.getImageUrl()).into(mTvAlbumImageB);
        Glide.with(itemView.getContext()).load(model.getImageUrl()).into(mTvAlbumImageC);

        mTvAlbumTitleA.setText(model.getAlbumOneTitle());
        mTvAlbumTitleB.setText(model.getAlbumTwoTitle());
        mTvAlbumTitleC.setText(model.getAlbumThreeTitle());

        mTvAlbumDesA.setText(model.getAlbumOnedes());
        mTvAlbumDesB.setText(model.getAlbumTwodes());
        mTvAlbumDesC.setText(model.getAlbumThreedes());
    }
}
