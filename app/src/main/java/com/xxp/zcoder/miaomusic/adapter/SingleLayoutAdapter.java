package com.xxp.zcoder.miaomusic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/17
 * Description :
 */

public abstract class SingleLayoutAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<T> mDatas;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private OnClickListener mOnClickListener;


    public SingleLayoutAdapter(List<T> mDatas, Context mContext) {
        this.mDatas = mDatas;
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(mLayoutInflater.inflate(getLayoutId(), viewGroup, false));
    }

    protected abstract int getLayoutId();

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        bindMyViewHolder((ViewHolder) viewHolder, i);
    }

    protected abstract void bindMyViewHolder(ViewHolder viewHolder, int i);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    protected class ViewHolder extends RecyclerView.ViewHolder {
        View mRootView;
        SparseArray<View> mViews;

        public ViewHolder(View itemView) {
            super(itemView);
            mRootView = itemView;
            mViews = new SparseArray<>();
            bindListener();
        }

        private void bindListener() {
            mRootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnClickListener != null) {
                        mOnClickListener.onClick(getAdapterPosition());
                        mOnClickListener.onLongClick(getAdapterPosition());
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


        public void setText(int id, String content) {
            ((TextView) getView(id)).setText(content);
        }


        public void setVisible(int id, boolean isShow) {
            getView(id).setVisibility(isShow ? View.VISIBLE : View.INVISIBLE);
        }
    }

    public interface OnClickListener {
        void onClick(int position);

        void onLongClick(int position);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }
}
