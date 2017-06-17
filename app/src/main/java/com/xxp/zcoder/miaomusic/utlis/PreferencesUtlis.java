package com.xxp.zcoder.miaomusic.utlis;

import android.content.Context;
import android.content.SharedPreferences;

import com.xxp.zcoder.miaomusic.ZcoderApp;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public class PreferencesUtlis {
    private static SharedPreferences mSharedPreferences;
    private static SharedPreferences.Editor mEdit;

    public static void init(Context context) {
        mSharedPreferences =
                context.getSharedPreferences("ZcoderMusic", Context.MODE_PRIVATE);
        mEdit = mSharedPreferences.edit();
    }

    public static void putInt(String key, int value) {
        mEdit.putInt(key, value).apply();
    }

    public static void putString(String key, String value) {
        mEdit.putString(key, value).apply();
    }

    public static void putBoolean(String key, Boolean value) {
        mEdit.putBoolean(key, value).apply();
    }

    public static int getInt(String key, int def) {
        return mSharedPreferences.getInt(key, def);
    }

    public static String getString(String key, String def) {
        return mSharedPreferences.getString(key, def);
    }

    public static Boolean getBoolean(String key, Boolean def) {
        return mSharedPreferences.getBoolean(key, def);
    }
}
