package com.xxp.zcoder.mvp.base;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.xxp.zcoder.mvp.R;
import com.xxp.zcoder.mvp.listener.RequestPermisListener;
import com.xxp.zcoder.mvp.utlis.ActivityManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public abstract class BaseActivity extends AppCompatActivity {
    private static RequestPermisListener mListener;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityManager.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.removeActivity(this);
    }


    /**
     * 权限的申请
     *
     * @param permis
     * @param listener
     */
    public static void requestPermission(String permis[], RequestPermisListener listener) {
        mListener = listener;
        List<String> permissions = new ArrayList<>();
        Activity activity = ActivityManager.getTopActivitys();
        for (int i = 0; i < permis.length; i++) {
            if (ContextCompat.checkSelfPermission(activity, permis[i]) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(permis[i]);
            }
        }
        if (!permissions.isEmpty()) {
            ActivityCompat.requestPermissions(activity, permissions.toArray(new String[permissions.size()]), 1);
        } else {
            listener.onGranted();
        }
    }

    /**
     * 权限申请结果的处理
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    List<String> denidePermission = new ArrayList<>();
                    for (int i = 0; i < grantResults.length; i++) {
                        int grantResult = grantResults[i];
                        String permission = permissions[i];
                        if (grantResult == PackageManager.PERMISSION_DENIED) {
                            denidePermission.add(permission);
                        }
                    }

                    if (denidePermission.isEmpty()) {
                        mListener.onGranted();
                    } else {
                        mListener.onDenide(denidePermission);
                    }
                }

                break;
        }
    }


}
