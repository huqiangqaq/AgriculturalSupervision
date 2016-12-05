package com.nxt.zyl.data.volley.toolbox;

import com.nxt.zyl.data.volley.AuthFailureError;
import com.nxt.zyl.data.volley.DefaultRetryPolicy;
import com.nxt.zyl.data.volley.Request;
import com.nxt.zyl.data.volley.Response.Listener;
import com.nxt.zyl.data.volley.Response.LoadingListener;
import com.nxt.zyl.data.volley.Response.ErrorListener;

import java.io.File;
import java.util.HashMap;
import java.util.Map;



public class DownloadRequest extends StringRequest {

    public DownloadRequest(String url, Listener<String> listener, ErrorListener errorListener,
                           LoadingListener loadingListener) {
        super(Request.Method.GET, url, listener, errorListener, loadingListener);
        // 下载文件大，失败可能性比较大，所以加大retry次数
        setRetryPolicy(
                new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        // 关闭gzip
        setShouldGzip(false);
    }

    private String target;
    private boolean isResume;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public boolean isResume() {
        return isResume;
    }

    public void setResume(boolean isResume) {
        this.isResume = isResume;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        File file = new File(target);
        final long fileLen = file.length();
        if (isResume && fileLen > 0) {
            Map<String, String> headers = new HashMap<>();
            headers.put("Range", "bytes=" + fileLen + "-");
            return headers;
        }
        return super.getHeaders();
    }


    /**
     * 停止下载
     * stopDownload
     *
     * @since 3.5
     */
    public void stopDownload() {
        cancel();
    }
}
