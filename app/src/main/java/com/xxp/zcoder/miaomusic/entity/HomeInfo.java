package com.xxp.zcoder.miaomusic.entity;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/15
 * Description :
 */

public class HomeInfo {
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
    private int type;

    //标题
    private String title;
    //专辑图片
    private String imageUrl;
    //歌曲一
    private String songOneTitle;
    //歌曲二
    private String songTwoTitle;
    //歌曲三
    private String songThreeTitle;

    //专辑一
    private String albumOneTitle;
    private String albumOnedes;
    //专辑二
    private String albumTwoTitle;
    private String albumTwodes;
    //专辑三
    private String albumThreeTitle;
    private String albumThreedes;


    public HomeInfo(int type, String title) {
        this.type = type;
        this.title = title;
    }

    public HomeInfo(int type) {
        this.type = type;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public HomeInfo() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSongOneTitle() {
        return songOneTitle;
    }

    public void setSongOneTitle(String songOneTitle) {
        this.songOneTitle = songOneTitle;
    }

    public String getSongTwoTitle() {
        return songTwoTitle;
    }

    public void setSongTwoTitle(String songTwoTitle) {
        this.songTwoTitle = songTwoTitle;
    }

    public String getSongThreeTitle() {
        return songThreeTitle;
    }

    public void setSongThreeTitle(String songThreeTitle) {
        this.songThreeTitle = songThreeTitle;
    }

    public String getAlbumOneTitle() {
        return albumOneTitle;
    }

    public void setAlbumOneTitle(String albumOneTitle) {
        this.albumOneTitle = albumOneTitle;
    }

    public String getAlbumOnedes() {
        return albumOnedes;
    }

    public void setAlbumOnedes(String albumOnedes) {
        this.albumOnedes = albumOnedes;
    }

    public String getAlbumTwoTitle() {
        return albumTwoTitle;
    }

    public void setAlbumTwoTitle(String albumTwoTitle) {
        this.albumTwoTitle = albumTwoTitle;
    }

    public String getAlbumTwodes() {
        return albumTwodes;
    }

    public void setAlbumTwodes(String albumTwodes) {
        this.albumTwodes = albumTwodes;
    }

    public String getAlbumThreeTitle() {
        return albumThreeTitle;
    }

    public void setAlbumThreeTitle(String albumThreeTitle) {
        this.albumThreeTitle = albumThreeTitle;
    }

    public String getAlbumThreedes() {
        return albumThreedes;
    }

    public void setAlbumThreedes(String albumThreedes) {
        this.albumThreedes = albumThreedes;
    }

    @Override
    public String toString() {
        return "HomeInfo{" +
                "title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", songOneTitle='" + songOneTitle + '\'' +
                ", songTwoTitle='" + songTwoTitle + '\'' +
                ", songThreeTitle='" + songThreeTitle + '\'' +
                '}';
    }
}
