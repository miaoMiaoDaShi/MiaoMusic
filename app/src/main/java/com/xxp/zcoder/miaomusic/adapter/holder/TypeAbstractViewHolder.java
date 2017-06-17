package com.xxp.zcoder.miaomusic.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class TypeAbstractViewHolder<T> extends RecyclerView.ViewHolder {

    public TypeAbstractViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(T model);
}