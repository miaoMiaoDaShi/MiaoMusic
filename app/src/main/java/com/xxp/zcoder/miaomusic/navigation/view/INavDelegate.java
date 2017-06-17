package com.xxp.zcoder.miaomusic.navigation.view;

import com.xxp.zcoder.miaomusic.entity.MusicInfo;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public interface INavDelegate {
    //导航装载
    void setUpViewPager();

    //暂停时
    void setPause();

    //停止时
    void setStop();

    //播放时
    void setPlay();

    //更新状态信息
    void updateMusic(MusicInfo musicInfo);


}
