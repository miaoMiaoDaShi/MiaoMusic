package com.xxp.zcoder.miaomusic.utlis;

import android.app.Application;
import android.os.Environment;

import com.xxp.zcoder.miaomusic.R;
import com.xxp.zcoder.miaomusic.ZcoderApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public class FileUtlis {
    public static final String APPNAME = ZcoderApp.getContext().getString(R.string.app_name);
    public static final String APPDIR =
            Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "奇创喵喵"
                    + File.separator + APPNAME;

    public static String getAppdirPath() {
        return mkdirs(APPDIR);
    }

    public static String getMusicDir() {
        String dir = getAppdirPath() + "/Music/";
        return mkdirs(dir);
    }

    public static String getSplashDir() {
        String dir = getAppdirPath() + "/splash/";
        return mkdirs(dir);
    }

    private static String mkdirs(String dir) {
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
        return dir;
    }
    public static void saveLrcFile(String path, String content) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            bw.write(content);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
