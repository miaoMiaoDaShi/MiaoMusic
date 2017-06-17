package com.xxp.zcoder.miaomusic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xxp.zcoder.miaomusic.R;
import com.xxp.zcoder.miaomusic.adapter.holder.TypeAbstractViewHolder;
import com.xxp.zcoder.miaomusic.adapter.holder.TypeOneViewHolder;
import com.xxp.zcoder.miaomusic.adapter.holder.TypeThreeViewHolder;
import com.xxp.zcoder.miaomusic.adapter.holder.TypeTwoViewHolder;
import com.xxp.zcoder.miaomusic.entity.HomeInfo;

import java.util.List;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/15
 * Description :
 */

public class HomeRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<HomeInfo> mHomeInfos;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public HomeRVAdapter(List<HomeInfo> mHomeInfo, Context mContext) {
        this.mHomeInfos = mHomeInfo;
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case HomeInfo.TYPE_ONE:
                return new TypeOneViewHolder(mLayoutInflater
                        .inflate(R.layout.item_title, viewGroup, false));
            case HomeInfo.TYPE_TWO:
                return new TypeTwoViewHolder(mLayoutInflater
                        .inflate(R.layout.item_song_list, viewGroup, false));
            case HomeInfo.TYPE_THREE:
                return new TypeThreeViewHolder(mLayoutInflater
                        .inflate(R.layout.item_song_list_grid, viewGroup, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((TypeAbstractViewHolder) viewHolder).bindHolder(mHomeInfos.get(i));
    }

    @Override
    public int getItemCount() {
        return mHomeInfos.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mHomeInfos.get(position).getType();
    }

}
