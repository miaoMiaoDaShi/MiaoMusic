package com.xxp.zcoder.miaomusic.utlis;

import android.content.Context;
import android.widget.Toast;

import com.xxp.zcoder.miaomusic.ZcoderApp;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public class ToastUtlis {
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    public static void showToast(String content) {
        Toast.makeText(mContext, content, Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(String content) {
        Toast.makeText(mContext, content, Toast.LENGTH_LONG).show();
    }
}
