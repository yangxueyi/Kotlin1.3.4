package com.yxy.kotlin26;

import android.app.Application;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;

/**
 * Created by YangXueYi
 * Time : jajaying on 2019/11/29 11:42
 */
public class MyAppli extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //非wifi情况下，主动下载x5内核
        QbSdk.setDownloadWithoutWifi(true);
        //初始化X5内核
        QbSdk.initX5Environment(this, new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {
                //x5内核初始化完成回调接口，此接口回调并表示已经加载起来了x5，有可能特殊情况下x5内核加载失败，切换到系统内核。
            }
            @Override
            public void onViewInitFinished(boolean b) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.e("@@","加载内核是否成功:"+b);
            }
        });
    }
}
