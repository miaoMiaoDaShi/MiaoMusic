package com.xxp.zcoder.miaomusic.enumeration;

import android.content.Intent;

import com.xxp.zcoder.miaomusic.ZcoderApp;
import com.xxp.zcoder.miaomusic.service.PlayService;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/17
 * Description :
 */

public enum PlayMode {
    RANDOM("random") {
        @Override
        protected void sort() {
            Intent intent = new Intent(PlayService.ACTION_PLAY_MODE);
            intent.setClass(ZcoderApp.getContext(), PlayService.class);
            ZcoderApp.getContext().startService(intent);
        }
    },
    SINGLE_LOOP("single_loop") {
        @Override
        protected void sort() {

        }
    },
    LIST_LOOP("list_loop") {
        @Override
        protected void sort() {

        }
    };

    PlayMode(String mode) {

    }

    protected abstract void sort();
}
