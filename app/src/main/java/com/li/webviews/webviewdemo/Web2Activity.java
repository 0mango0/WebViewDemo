package com.li.webviews.webviewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Lee on 2017/4/17.
 */

public class Web2Activity extends AppCompatActivity {


    private WebView webView;
    String url = "https://www.baidu.com";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_02);
        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                view.loadUrl(request.toString());

//                当你点击一个页面中一个链接时会经过shouldOverrideUrlLoading。
//                return true时，你可以自己来处理这个url，webview则不再处理这个url；
//                return false时，webview来处理这个url。
//                通俗的说，
//                当返回true时，你点任何链接都是失效的，需要你自己跳转。
//                return false时webview会自己跳转
//                return super.shouldOverrideUrlLoading(view, url);
//                这个返回的方法会调用父类方法，也就是跳转至手机浏览器，平时写webview一般都在方法里面写 webView.loadUrl(url);
//                然后把这个返回值改成下面的false。(ps：目前测了没感觉有什么区别)
//


                return false;
            }
        });

    }
}
