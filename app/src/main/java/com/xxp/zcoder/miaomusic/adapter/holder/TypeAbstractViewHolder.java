package com.xxp.zcoder.miaomusic.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import com.xxp.zcoder.miaomusic.adapter.MultiRVAdapter;

public abstract class TypeAbstractViewHolder<T> extends RecyclerView.ViewHolder {
    private View mRootView;
    private SparseArray<View> mViews;
    private MultiRVAdapter.OnItemClickListener mOnclick;

    public TypeAbstractViewHolder(final MultiRVAdapter.OnItemClickListener onItemClickListener, View itemView) {
        super(itemView);
        mOnclick = onItemClickListener;
        mRootView = itemView;
        mViews = new SparseArray<>();

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    mOnclick.onClick(getAdapterPosition());
                    mOnclick.onLongClick(getAdapterPosition());
                }
            }
        });

    }

    public <V extends View> V getView(int id) {
        V view = (V) mViews.get(id);
        if (view == null) {
            view = (V) mRootView.findViewById(id);
            mViews.put(id, view);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener, int... ids) {
        if (ids != null) {
            for (int id : ids) {
                getView(id).setOnClickListener(onClickListener);
            }
        }
    }

    public void setText(int id, String content) {
        ((TextView) getView(id)).setText(content);
    }


    public void setVisible(int id, boolean isShow) {
        getView(id).setVisibility(isShow ? View.VISIBLE : View.INVISIBLE);
    }

    public abstract void bindHolder(T model);

    protected View getRootView() {
        return mRootView;
    }

    public void setmRootView(View mRootView) {
        this.mRootView = mRootView;
    }
}