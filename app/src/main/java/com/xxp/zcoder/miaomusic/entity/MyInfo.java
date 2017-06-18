package com.xxp.zcoder.miaomusic.entity;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/15
 * Description :
 */

public class MyInfo {
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
    public static final int TYPE_four = 4;
    public static final int TYPE_five = 3;
    private int type;

    /*******TYPE_ONE*******/
    //头像
    private String photoUrl;
    // 昵称
    private String name;
    /**********TYPE_TWO********/
    //累计听歌
    private String titleOne;
    //值
    private String desOne;
    //缓存
    private String titleTwo;
    //值
    private String desTwo;
    /**********TYPE_THREE********/
    //标题
    private String title;
    //值
    private String des;
    /**********TYPE_four********/


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitleOne() {
        return titleOne;
    }

    public void setTitleOne(String titleOne) {
        this.titleOne = titleOne;
    }

    public String getDesOne() {
        return desOne;
    }

    public void setDesOne(String desOne) {
        this.desOne = desOne;
    }

    public String getTitleTwo() {
        return titleTwo;
    }

    public void setTitleTwo(String titleTwo) {
        this.titleTwo = titleTwo;
    }

    public String getDesTwo() {
        return desTwo;
    }

    public void setDesTwo(String desTwo) {
        this.desTwo = desTwo;
    }

    public String getTitle() {
        return title;
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
}
