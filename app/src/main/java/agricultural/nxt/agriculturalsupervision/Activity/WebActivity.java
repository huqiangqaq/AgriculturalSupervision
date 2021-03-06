package agricultural.nxt.agriculturalsupervision.Activity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;

import com.nxt.zyl.util.CommonUtils;
import com.nxt.zyl.util.ZToastUtils;

import java.lang.ref.WeakReference;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import butterknife.BindView;

public class WebActivity extends BaseActivity {
    private String loadUrl = null;
    @BindView(R.id.webview)
    WebView webView;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
//    @BindView(R.id.appbarlayout)
//    AppBarLayout appBarLayout;
    private PreviewHandler handler = new PreviewHandler(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        toolBar.setTitle("农药标签");
        toolBar.setLeftButtonOnClickLinster(v -> {
            if (webView.canGoBack()) {
                webView.goBack();
            } else {
                WebActivity.super.onBackPressed();
            }
        });
        loadUrl = getIntent().getStringExtra("label");
        initWebView();
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        swipeRefreshLayout.setOnRefreshListener(() -> webView.reload());
        swipeRefreshLayout.post(() -> {
            swipeRefreshLayout.setRefreshing(true);
            handler.sendEmptyMessageDelayed(0, 500);
        });

//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (verticalOffset>=0){
//                    swipeRefreshLayout.setEnabled(true);
//                }else {
//                    swipeRefreshLayout.setEnabled(false);
//                }
//            }
//        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_web;
    }

    private void initWebView() {
        /**
         * 初始化webview设置
         */
        if (Build.VERSION.SDK_INT >= 19) {
            /*对系统API在19以上的版本作了兼容。因为4.4以上系统在onPageFinished时再恢复图片加载时,如果存在多张图片引用的是相同的src时，会只有一个image标签得到加载，因而对于这样的系统我们就先直接加载。*/
            webView.getSettings().setLoadsImagesAutomatically(true);
        } else {
            webView.getSettings().setLoadsImagesAutomatically(false);
        }
        /**
         * 添加进度条
         */
        final ProgressBar progressbar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
        progressbar.setLayoutParams(new AbsoluteLayout.LayoutParams(AbsoluteLayout.LayoutParams.MATCH_PARENT, 6, 0, 0));
        webView.addView(progressbar);
        WebSettings mWebSettings = webView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        mWebSettings.setSupportZoom(true);
        mWebSettings.setAllowFileAccess(true);
        mWebSettings.setBuiltInZoomControls(true);
        mWebSettings.setUseWideViewPort(true);
        mWebSettings.setLoadWithOverviewMode(true);
        mWebSettings.setBuiltInZoomControls(true);
        mWebSettings.setLayoutAlgorithm(
                WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWebSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        mWebSettings.setDomStorageEnabled(true);
        webView.setInitialScale(25);//
        webView.requestFocus();

        webView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    progressbar.setVisibility(View.GONE);
                } else {
                    if (progressbar.getVisibility() == View.GONE)
                        progressbar.setVisibility(View.VISIBLE);
                    progressbar.setProgress(newProgress);
                }
            }
        });

    }

    private void viewInfo() {
        if (CommonUtils.isNetWorkConnected(WebActivity.this)) {
            setWebViewConfig();
            return;
        }
        ZToastUtils.showShort(this, "网络连接错误");
    }

    private void setWebViewConfig() {
        webView.loadUrl(loadUrl);
        webView.setWebViewClient(new WebViewClient() {
            //设置在webview中点击打开的新网页在当前页面显示，而不跳转到浏览器中
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                view.loadUrl(loadUrl);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(false);
                }
                if (!webView.getSettings().getLoadsImagesAutomatically()) {
                    webView.getSettings().setLoadsImagesAutomatically(true);
                }
            }
        });
    }

    //我们需要重写回退按钮的时间,当用户点击回退按钮：
    //1.webView.canGoBack()判断网页是否能后退,可以则goback()
    //2.如果不可以连续点击两次退出App,否则弹出提示Toast

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    private static class PreviewHandler extends Handler {
        private WeakReference<WebActivity> ref;

        PreviewHandler(WebActivity webActivity) {
            ref = new WeakReference<>(webActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            final WebActivity activity = ref.get();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            activity.viewInfo();
            super.handleMessage(msg);
        }
    }
}
