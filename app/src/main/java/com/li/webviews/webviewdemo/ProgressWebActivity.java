package com.li.webviews.webviewdemo;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Lee on 2017/4/20.
 */

public class ProgressWebActivity extends AppCompatActivity {
    private WebView webView;
    private String url = "https://www.baidu.com";
    private Dialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_03);
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);//启用js
        webView.getSettings().setBlockNetworkImage(false);//解决图片不显示
        mDialog = CustomProgressDialog.createLoadingDialog(ProgressWebActivity.this, "正在加载中...");
        mDialog.setCancelable(true);//允许返回
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                view.loadUrl(request.toString());

                return false;
            }

//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//                super.onPageStarted(view, url, favicon);
//
//
//              mDialog.show();//显示
//
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//                mDialog.dismiss();
//                mDialog=null;
//
//            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    mDialog.dismiss();//加载完网页进度条消失
                } else {
                    mDialog.show();////开始加载网页时显示进度条
                    // .setProgress(newProgress);//如果用进度条的话，可以设置进度值
                }
            }
        });


    }
    //设置返回键动作
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_BACK) {
            if(webView.canGoBack()) {//当webview不是处于第一页面时，返回上一个页面
                webView.goBack();
                return true;
            }
            else {//当webview处于第一页面时,直接退出程序活着关闭当前Activity
               // System.exit(0);
                ProgressWebActivity.this.finish();
            }

        }

        return super.onKeyDown(keyCode, event);
    }
}
