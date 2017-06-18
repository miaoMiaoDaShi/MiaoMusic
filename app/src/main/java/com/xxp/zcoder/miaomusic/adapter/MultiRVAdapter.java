package com.xxp.zcoder.miaomusic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.xxp.zcoder.miaomusic.R;
import com.xxp.zcoder.miaomusic.adapter.holder.TypeAbstractViewHolder;
import com.xxp.zcoder.miaomusic.adapter.holder.TypeFiveViewHolder;
import com.xxp.zcoder.miaomusic.adapter.holder.TypeFourViewHolder;
import com.xxp.zcoder.miaomusic.adapter.holder.TypeOneViewHolder;
import com.xxp.zcoder.miaomusic.adapter.holder.TypeSixViewHolder;
import com.xxp.zcoder.miaomusic.adapter.holder.TypeThreeViewHolder;
import com.xxp.zcoder.miaomusic.adapter.holder.TypeTwoViewHolder;
import com.xxp.zcoder.miaomusic.entity.HomeInfo;
import com.xxp.zcoder.miaomusic.entity.MultiInfo;

import java.util.List;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/15
 * Description :
 */

public class MultiRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<MultiInfo> mMultiInfos;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private OnItemClickListener mOnClickListener;

    public MultiRVAdapter(List<MultiInfo> mHMultiInfo, Context mContext) {
        this.mMultiInfos = mHMultiInfo;
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case MultiInfo.TYPE_ONE:
                return new TypeOneViewHolder(mOnClickListener, mLayoutInflater
                        .inflate(R.layout.item_one, viewGroup, false));
            case MultiInfo.TYPE_TWO:
                return new TypeTwoViewHolder(mOnClickListener, mLayoutInflater
                        .inflate(R.layout.item_two, viewGroup, false));
            case MultiInfo.TYPE_THREE:
                return new TypeThreeViewHolder(mOnClickListener, mLayoutInflater
                        .inflate(R.layout.item_three, viewGroup, false));
            case MultiInfo.TYPE_four:
                return new TypeFourViewHolder(mOnClickListener, mLayoutInflater
                        .inflate(R.layout.item_four, viewGroup, false));
            case MultiInfo.TYPE_five:
                return new TypeFiveViewHolder(mOnClickListener, mLayoutInflater
                        .inflate(R.layout.item_five, viewGroup, false));
            case MultiInfo.TYPE_six:
                return new TypeSixViewHolder(mOnClickListener, mLayoutInflater
                        .inflate(R.layout.item_six, viewGroup, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((TypeAbstractViewHolder) viewHolder).bindHolder(mMultiInfos.get(i));
    }

    @Override
    public int getItemCount() {
        return mMultiInfos.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mMultiInfos.get(position).getType();
    }

    public interface OnItemClickListener {
        void onClick(int position);

        void onLongClick(int position);
    }

    public void setOnClickListener(OnItemClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }
}
