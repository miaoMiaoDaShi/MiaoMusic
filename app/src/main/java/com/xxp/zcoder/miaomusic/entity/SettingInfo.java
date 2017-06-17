package com.xxp.zcoder.miaomusic.entity;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/17
 * Description :
 */

public class SettingInfo {
    //左边的竖条的颜色
    private int leftColor;
    //标题
    private String title;
    //描述
    private String des;
    //是否显示右面的图标
    private boolean showMoreIc;

    public SettingInfo() {
    }

    public SettingInfo(String title, String des, boolean showMoreIc) {
        this.title = title;
        this.des = des;
        this.showMoreIc = showMoreIc;
    }

    public String getTitle() {
        return title;
    }

    public int getLeftColor() {
        return leftColor;
    }

    public void setLeftColor(int leftColor) {
        this.leftColor = leftColor;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public boolean isShowMoreIc() {
        return showMoreIc;
    }

    public void setShowMoreIc(boolean showMoreIc) {
        this.showMoreIc = showMoreIc;
    }

    @Override
    public String toString() {
        return "SettingInfo{" +
                "title='" + title + '\'' +
                ", des='" + des + '\'' +
                ", showMoreIc=" + showMoreIc +
                '}';
    }
}
