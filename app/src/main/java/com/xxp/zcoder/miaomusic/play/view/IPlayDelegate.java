package com.xxp.zcoder.miaomusic.play.view;

import com.xxp.zcoder.miaomusic.entity.MusicInfo;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public interface IPlayDelegate {

    //暂停时
    void setPause();

    //停止时
    void setStop();

    //播放时
    void setPlay();

    //更新状态信息
    void updateMusic(MusicInfo musicInfo);

}
