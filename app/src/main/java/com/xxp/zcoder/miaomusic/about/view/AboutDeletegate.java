package com.xxp.zcoder.miaomusic.about.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.xxp.zcoder.miaomusic.R;
import com.xxp.zcoder.miaomusic.adapter.SingleLayoutAdapter;
import com.xxp.zcoder.miaomusic.entity.SettingInfo;
import com.xxp.zcoder.mvp.view.AppDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public class AboutDeletegate extends AppDelegate {
    @Override
    public void initView() {
        TextView tvTitle = getView(R.id.tv_toolbar);
        tvTitle.setText("关于");
    }

    public SingleLayoutAdapter setUpRecyclerView(SingleLayoutAdapter.OnClickListener onClickListener) {
        RecyclerView recyclerView = getView(R.id.rv_about);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(),
                LinearLayoutManager.VERTICAL, false));
        final List<SettingInfo> settingInfos = getdatas();
        SingleLayoutAdapter<SettingInfo> adapter = new SingleLayoutAdapter<SettingInfo>(settingInfos,
                getActivity()) {
            @Override
            protected int getLayoutId() {
                return R.layout.item_setting;
            }

            @Override
            protected void bindMyViewHolder(ViewHolder viewHolder, int i) {
                viewHolder.setText(R.id.tv_item_setting, settingInfos.get(i).getTitle());
                viewHolder.setText(R.id.tv_item_setting_des, settingInfos.get(i).getDes());
                viewHolder.setVisible(R.id.iv_item_setting_more, settingInfos.get(i).isShowMoreIc() ?
                        true : false);
            }

        };
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(onClickListener);
        return adapter;
    }

    private List<SettingInfo> getdatas() {
        List<SettingInfo> settingInfos = new ArrayList<>();
        SettingInfo version = new SettingInfo("版本更新", "获取中...", false);
        SettingInfo history = new SettingInfo("历史更新", "", true);
        SettingInfo introduce = new SettingInfo("功能介绍", "", true);
        SettingInfo star = new SettingInfo("Github", "为我star", false);
        SettingInfo email = new SettingInfo("Email", getActivity().getString(R.string.email),
                false);
        settingInfos.add(version);
        settingInfos.add(history);
        settingInfos.add(introduce);
        settingInfos.add(star);
        settingInfos.add(email);

        return settingInfos;
    }


    @Override
    protected int getRootLayoutId() {
        return R.layout.activity_about;
    }
}
