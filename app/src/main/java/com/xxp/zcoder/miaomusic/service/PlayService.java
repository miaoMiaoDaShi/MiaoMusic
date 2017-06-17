package com.xxp.zcoder.miaomusic.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import com.xxp.zcoder.miaomusic.entity.MusicInfo;
import com.xxp.zcoder.miaomusic.enumeration.PlayMode;

import java.util.ArrayList;
import java.util.List;

public class PlayService extends Service implements MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnBufferingUpdateListener {

    private static final String TAG = "PlayService";
    //恢复上次的
    public static final String ACTION_RECOVER = "action_recover";
    //播放
    public static final String ACTION_PLAY_PAUSE = "action_play_pause";
    //上一首
    public static final String ACTION_PREVIOUS = "action_previous";
    //下一首
    public static final String ACTION_NEXT = "action_next";
    //停止
    public static final String ACTION_STOP = "action_stop";
    //传入单曲
    public static final String ACTION_SONG = "action_song";
    //传入列表
    public static final String ACTION_SONGS = "action_songs";
    //播放模式
    public static final String ACTION_PLAY_MODE = "action_play_mode";
    //修改播放列表
    public static final String KEY_PLAY_MODE = "key_play_mode";
    //恢复的歌曲
    public static final String KEY_RECOVER = "key_recover";
    //传入单曲
    public static final String KEY_SONG = "KEY_song";
    //传入列表
    public static final String KEY_SONGS = "KEY_songs";
    private PlayMode mPlayMode;
    private List<MusicInfo> mMusicInfos;
    private MediaPlayer mMediaPlayer;

    //当前的position
    private int mPosition = 0;
    //当前播放的音乐
    private MusicInfo mCurrentSong;

    //加载完就播放
    private boolean isAutoPlay;


    @Override
    public void onCreate() {
        super.onCreate();
        mMusicInfos = new ArrayList<>();
        mMediaPlayer = new MediaPlayer();
        //完成监听
        mMediaPlayer.setOnCompletionListener(this);
        //异步准备监听
        mMediaPlayer.setOnPreparedListener(this);
        //缓冲监听
        mMediaPlayer.setOnBufferingUpdateListener(this);

        mPlayMode = PlayMode.LIST_LOOP;

    }

    public static void startCommand(Context context, String action) {
        Intent intent = new Intent(context, PlayService.class);
        intent.setAction(action);
        context.startService(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getAction();
        isAutoPlay = false;
        switch (action) {
            case ACTION_RECOVER:
                recover(intent);
                break;
            case ACTION_PREVIOUS:
                isAutoPlay = true;
                previous();
                break;
            case ACTION_SONGS:
                songListModify(intent);
                break;
            case ACTION_SONG:
                isAutoPlay = true;
                play(intent.getIntExtra(KEY_SONG, 0));
                break;
            case ACTION_NEXT:
                isAutoPlay = true;
                next();
                break;
            case ACTION_PLAY_PAUSE:
                playOrPause();
                break;
            case ACTION_STOP:
                stop();
                break;
            case ACTION_PLAY_MODE:
                mPlayMode = (PlayMode) intent.getSerializableExtra(KEY_PLAY_MODE);
                break;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 根据索引播放歌曲
     *
     * @param position
     */
    private void play(int position) {
        mPosition = position;
        play(mMusicInfos.get(position));
    }

    /**
     * 列表更改
     *
     * @param intent
     */
    private void songListModify(Intent intent) {
        List<MusicInfo> musicInfos = (List<MusicInfo>) intent.getSerializableExtra(KEY_SONGS);
        if (musicInfos != null) {
            mMusicInfos = musicInfos;
        }
    }

    private void playOrPause() {
        if (mMediaPlayer.isPlaying()) {
            pause();
        } else {
            play();
        }
    }

    /**
     * 停止播放
     */
    private void stop() {
        mMediaPlayer.stop();
    }

    /**
     * 暂停播放
     */
    private void pause() {
        mMediaPlayer.pause();
    }

    /**
     * 播放
     */
    private void play() {
        mMediaPlayer.start();
    }

    /**
     * 下一曲
     */
    private void next() {
        play(getNextPosition());
    }

    private int getNextPosition() {
        int position = 0;
        switch (mPlayMode) {
            case RANDOM:
                position = (int) (Math.random() * mMusicInfos.size());
                break;
            case LIST_LOOP:
                position = mPosition == mMusicInfos.size() ? 0 : ++mPosition;
                break;
            case SINGLE_LOOP:
                position = mPosition;
                break;
        }
        return position;
    }


    private int getPreviousPosition() {
        int position = 0;
        switch (mPlayMode) {
            case RANDOM:
                position = (int) (Math.random() * mMusicInfos.size());
                break;
            case LIST_LOOP:
                position = mPosition < 0 ? mMusicInfos.size() - 1 : --mPosition;
                break;
            case SINGLE_LOOP:
                position = mPosition;
                break;
        }
        return position;
    }

    /**
     * 上一曲
     */
    private void previous() {
        play(getPreviousPosition());
    }

    /**
     * 恢复上一次的歌曲
     */
    private void recover(Intent intent) {
        MusicInfo musicInfo = (MusicInfo) intent.getSerializableExtra(KEY_RECOVER);
        if (mMusicInfos.contains(musicInfo)) {
            for (int i = 0; i < mMusicInfos.size(); i++) {
                if (musicInfo.equals(mMusicInfos.get(i))) {
                    mPosition = i;
                }
            }
        } else {
            if (musicInfo != null) {
                play(musicInfo);
            }
        }


        Log.i(TAG, "recover: ");
    }

    private void play(MusicInfo musicInfo) {
        mCurrentSong = musicInfo;
        try {
            mMediaPlayer.reset();
            mMediaPlayer.setDataSource(musicInfo.getPath());
            mMediaPlayer.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        int position = (int) mCurrentSong.getCurrentPosition();
        if (position != 0) {
            mp.seekTo(position);
        }

        if (isAutoPlay) {
            mp.start();
        }
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMediaPlayer.stop();
        mMediaPlayer.release();
    }
}
