package com.xxp.zcoder.miaomusic.utlis;

import android.text.TextUtils;

import java.lang.reflect.Method;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/17
 * Description :
 */

public class SystemUtlis {
    public static boolean isFlyme() {
        String flymeFlag = getSystemProperty("ro.build.display.id");
        return !TextUtils.isEmpty(flymeFlag) && flymeFlag.toLowerCase().contains("flyme");
    }
    private static String getSystemProperty(String key) {
        try {
            Class<?> classType = Class.forName("android.os.SystemProperties");
            Method getMethod = classType.getDeclaredMethod("get", String.class);
            return (String) getMethod.invoke(classType, key);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

}
