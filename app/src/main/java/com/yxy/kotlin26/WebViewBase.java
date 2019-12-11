package com.yxy.kotlin26;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;

;

/**
 * Created by YangXueYi
 * Time : jajaying on 2018/6/25 10:04
 */
public class WebViewBase extends WebView {




    public WebViewBase(Context context) {
        this(context, null);
    }

    public WebViewBase(Context context, AttributeSet attrs) {
        super(getFixedContext(context), attrs);
        initSettings();
        requestFocus();
        setSaveEnabled(true);
        // JS调java

    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initSettings() {
        WebSettings webSettings = getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING); //支持内容重新布局
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // http 与 https请求混合模式
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
    }

    //适配android5.1版本的webview
    private static Context getFixedContext(Context context) {
        if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 23) // Android Lollipop 5.0 & 5.1
            return context.createConfigurationContext(new Configuration());
        return context;
    }


    @Override
    public void loadUrl(String url) {
        super.loadUrl(url);
    }


}
