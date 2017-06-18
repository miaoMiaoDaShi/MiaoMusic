package com.xxp.zcoder.miaomusic.entity;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/17
 * Description :
 */

public class MultiInfo {
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
    public static final int TYPE_four = 4;
    public static final int TYPE_five = 5;
    public static final int TYPE_six = 6;
    public static final int TYPE_seven = 7;
    public static final int TYPE_eight = 8;
    private int type = 1;


    private String imageUrl;
    private String titleOne;
    private String titleTwo;
    private String titleThree;
    private String desOne;
    private String desTwo;
    private String desThree;
    private int color;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public MultiInfo() {
    }

    public MultiInfo(int type) {
        this.type = type;
    }

    public MultiInfo(String titleOne, String desOne) {
        this.titleOne = titleOne;
        this.desOne = desOne;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitleOne() {
        return titleOne;
    }

    public void setTitleOne(String titleOne) {
        this.titleOne = titleOne;
    }

    public String getTitleTwo() {
        return titleTwo;
    }

    public void setTitleTwo(String titleTwo) {
        this.titleTwo = titleTwo;
    }

    public String getTitleThree() {
        return titleThree;
    }

    public void setTitleThree(String titleThree) {
        this.titleThree = titleThree;
    }

    public String getDesOne() {
        return desOne;
    }

    public void setDesOne(String desOne) {
        this.desOne = desOne;
    }

    public String getDesTwo() {
        return desTwo;
    }

    public void setDesTwo(String desTwo) {
        this.desTwo = desTwo;
    }

    public String getDesThree() {
        return desThree;
    }

    public void setDesThree(String desThree) {
        this.desThree = desThree;
    }
}
