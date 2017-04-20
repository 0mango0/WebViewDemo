package com.li.webviews.webviewdemo;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by Lee on 2017/4/17.
 */

public class Web1Activity extends AppCompatActivity {


    private WebView webView;
    String url = "https://www.baidu.com";
   // String url = "file:///android_asset/demo2-241.html";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_01);
        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl(url);
    }
}
