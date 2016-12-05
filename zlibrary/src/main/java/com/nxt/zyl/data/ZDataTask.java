package com.nxt.zyl.data;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.nxt.zyl.data.volley.AuthFailureError;
import com.nxt.zyl.data.volley.NetworkResponse;
import com.nxt.zyl.data.volley.Request;
import com.nxt.zyl.data.volley.RequestQueue;
import com.nxt.zyl.data.volley.Response;
import com.nxt.zyl.data.volley.VolleyError;
import com.nxt.zyl.data.volley.VolleyLog;
import com.nxt.zyl.data.volley.toolbox.DownloadRequest;
import com.nxt.zyl.data.volley.toolbox.HttpCallback;
import com.nxt.zyl.data.volley.toolbox.HttpHeaderParser;
import com.nxt.zyl.data.volley.toolbox.JsonObjectRequest;
import com.nxt.zyl.data.volley.toolbox.MultiPartRequest;
import com.nxt.zyl.data.volley.toolbox.RequestInfo;
import com.nxt.zyl.data.volley.toolbox.StringRequest;
import com.nxt.zyl.data.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;



/**
 * 网络请求工具类
 *
 * @author koneloong koneloong@gmail.com
 *         Created on 2015/8/30 13:12..
 * @version 1.0
 * @since 1.0
 */
public class ZDataTask {
    private static ZDataTask mZDataTask;
    private RequestQueue mRequestQueue;
    private RequestQueue mDownloadRequestQueue;
    private Context mContext;

    private ZDataTask(Context context) {
        this.mContext = context;
        mRequestQueue = Volley.newNoCacheRequestQueue(context);
        mDownloadRequestQueue = Volley.newNoCacheRequestQueue(mContext);
    }


    public static synchronized ZDataTask getInstance(Context context) {
        if (mZDataTask == null)
            mZDataTask = new ZDataTask(context);
        return mZDataTask;
    }

    /**
     * 取消网络请求
     *
     * @since 1.0
     */
    public void stop() {
        if (mRequestQueue != null) {
            mRequestQueue.stop();
            mRequestQueue = null;
        }
    }

    /**
     * get请求
     *
     * @param url          请求地址
     * @param paramsMap    请求参数
     * @param headersMap   HttpHeader
     * @param httpCallback 实现回调接口的对象
     * @since 1.0
     */
    public void get(String url, Map<String, String> paramsMap,
                    Map<String, String> headersMap, HttpCallback httpCallback) {
        get(new RequestInfo(url, paramsMap, headersMap), httpCallback);
    }

    /**
     * get请求
     *
     * @param requestInfo  {@link com.nxt.zyl.data.volley.toolbox.RequestInfo}请求参数封装对象
     * @param httpCallback 实现回调接口的对象
     * @since 1.0
     */
    public void get(RequestInfo requestInfo, HttpCallback httpCallback) {
        sendRequest(Request.Method.GET, requestInfo, httpCallback);
    }

    /**
     * post请求
     *
     * @param url          请求地址
     * @param paramsMap    请求参数
     * @param headersMap   HttpHeader
     * @param httpCallback 实现回调接口的对象
     * @since 1.0
     */
    public void post(String url, Map<String, String> paramsMap, Map<String, String> headersMap,
                     HttpCallback httpCallback) {
        post(new RequestInfo(url, paramsMap, headersMap), httpCallback);
    }

    /**
     * post请求
     *
     * @param requestInfo  {@link com.nxt.zyl.data.volley.toolbox.RequestInfo}请求参数封装对象
     * @param httpCallback 实现回调接口的对象
     * @since 1.0
     */
    private void post(RequestInfo requestInfo, HttpCallback httpCallback) {
        sendRequest(Request.Method.POST, requestInfo, httpCallback);
    }

    /**
     * post 请求，json格式传输
     *
     * @param url          请求地址
     * @param paramsMap    请求参数
     * @param headersMap   请求头
     * @param httpCallback 回调接口
     * @since 1.0
     */
    public void postJson(String url, Map<String, String> paramsMap,
                         Map<String, String> headersMap, HttpCallback httpCallback) throws JSONException {
        postJson(new RequestInfo(url, paramsMap, headersMap), httpCallback);
    }

    /**
     * post 请求，json格式传输
     *
     * @param requestInfo  {@link com.nxt.zyl.data.volley.toolbox.RequestInfo}请求参数封装对象
     * @param httpCallback 实现回调接口的对象
     * @since 1.0
     */
    private void postJson(RequestInfo requestInfo, HttpCallback httpCallback) throws JSONException {
        sendJsonRequest(Request.Method.POST, requestInfo, httpCallback);
    }

    /**
     * delete请求
     *
     * @param url          请求地址
     * @param paramsMap    请求参数
     * @param headersMap   HttpHeader
     * @param httpCallback 实现回调接口的对象
     * @since 1.0
     */
    public void delete(String url, Map<String, String> paramsMap, Map<String, String> headersMap,
                       HttpCallback httpCallback) {
        delete(new RequestInfo(url, paramsMap, headersMap), httpCallback);
    }

    /**
     * delete请求
     *
     * @param requestInfo  {@link com.nxt.zyl.data.volley.toolbox.RequestInfo}请求参数封装对象
     * @param httpCallback 实现回调接口的对象
     * @since 1.0
     */
    private void delete(RequestInfo requestInfo, HttpCallback httpCallback) {
        sendRequest(Request.Method.DELETE, requestInfo, httpCallback);
    }

    /**
     * put 请求
     *
     * @param url          请求地址
     * @param paramsMap    请求参数
     * @param headersMap   HttpHeader
     * @param httpCallback 实现回调接口的对象
     * @since 1.0
     */
    public void put(String url, Map<String, String> paramsMap, Map<String, String> headersMap,
                    HttpCallback httpCallback) {
        put(new RequestInfo(url, paramsMap, headersMap), httpCallback);
    }

    /**
     * put 请求
     *
     * @param requestInfo  {@link com.nxt.zyl.data.volley.toolbox.RequestInfo}请求参数封装对象
     * @param httpCallback 实现回调接口的对象
     * @since 1.0
     */
    public void put(RequestInfo requestInfo, HttpCallback httpCallback) {
        sendRequest(Request.Method.PUT, requestInfo, httpCallback);
    }

    /**
     * upload 请求
     *
     * @param url          请求地址
     * @param paramsMap    请求参数
     * @param headersMap   HttpHeader
     * @param httpCallback 实现回调接口的对象
     * @since 1.0
     */
    public void upload(String url, Map<String, Object> paramsMap, Map<String, String> headersMap,
                       HttpCallback httpCallback) {
        RequestInfo requestInfo = new RequestInfo();
        requestInfo.setUrl(url);
        requestInfo.setHeaders(headersMap);
        requestInfo.putAllParams(paramsMap);
        upload(requestInfo, httpCallback);
    }

    /**
     * 处理上传请求
     *
     * @param requestInfo  {@link com.nxt.zyl.data.volley.toolbox.RequestInfo}请求参数封装对象
     * @param httpCallback 实现回调接口的对象
     * @since 1.0
     */
    public void upload(final RequestInfo requestInfo, final HttpCallback httpCallback) {
        final String url = requestInfo.getUrl();
        if (TextUtils.isEmpty(url)) {
            if (httpCallback != null) {
                httpCallback.onRequestStart();
                httpCallback.onRequestError(new Exception("url can not be empty!"));
                httpCallback.onRequestFinish();
            }
            return;
        }
        final Map<String, String> paramsMap = requestInfo.getParams();
        final Map<String, File> fileParams = requestInfo.getFileParams();
        VolleyLog.d("upload->%s\t,file->%s\t,form->%s", url, fileParams, paramsMap);
        if (httpCallback != null) {
            httpCallback.onRequestStart();
        }
        MultiPartRequest<String> request = new MultiPartRequest<String>(Request.Method.POST, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        if (httpCallback != null) {
                            httpCallback.onRequestResult(response);
                            httpCallback.onRequestFinish();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (httpCallback != null) {
                    httpCallback.onRequestError(error);
                    httpCallback.onRequestFinish();
                }
            }
        }, new Response.LoadingListener() {

            @Override
            public void onLoading(long count, long current) {
                if (httpCallback != null) {
                    httpCallback.onRequestLoading(count, current);
                }
            }
        }) {
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String parsed;
                try {
                    parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
                } catch (UnsupportedEncodingException e) {
                    parsed = new String(response.data);
                } catch (NullPointerException e) {
                    parsed = "";
                }
                return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
            }

            @Override
            public void cancel() {
                super.cancel();
                if (httpCallback != null) {
                    httpCallback.onRequestCancelled();
                }
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Charset", "UTF-8");
                headers.putAll(requestInfo.getHeaders());
                return headers;
            }

        };

        if (paramsMap != null && paramsMap.size() != 0) {
            for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
                request.addPart(entry.getKey(), entry.getValue());
            }
        }
        if (fileParams != null && fileParams.size() != 0) {
            for (Map.Entry<String, File> entry : fileParams.entrySet()) {
                String key = entry.getKey();
                request.addPart(key, entry.getValue());
            }
        }
        request.setTag(this);
        mRequestQueue.add(request);
    }

    /**
     * 下载请求
     *
     * @since 1.0
     */
    public DownloadRequest download(String url, String target, boolean isResume,
                                    HttpCallback httpResult) {
        RequestInfo requestInfo = new RequestInfo();
        requestInfo.setUrl(url);
        return download(requestInfo, target, isResume, httpResult);
    }

    /**
     * 下载请求
     *
     * @since 1.0
     */
    public DownloadRequest download(final RequestInfo requestInfo, String target, boolean isResume,
                                    final HttpCallback httpResult) {
        final String url = requestInfo.getUrl();
        VolleyLog.d("download->%s", url);
        DownloadRequest request = new DownloadRequest(url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if (httpResult != null) {
                    httpResult.onRequestResult(response);
                    httpResult.onRequestFinish();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (httpResult != null) {
                    httpResult.onRequestError(error);
                    httpResult.onRequestFinish();
                }
            }

        }, new Response.LoadingListener() {

            @Override
            public void onLoading(long count, long current) {
                if (httpResult != null) {
                    httpResult.onRequestLoading(count, current);
                }
            }
        }) {
            @Override
            public void stopDownload() {
                super.stopDownload();
                if (httpResult != null) {
                    httpResult.onRequestCancelled();
                }
            }

            @Override
            public void cancel() {
                super.cancel();
                if (httpResult != null) {
                    httpResult.onRequestCancelled();
                }
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = super.getHeaders();
                if (headers != null) {
                    headers.putAll(requestInfo.getHeaders());
                } else {
                    headers = requestInfo.getHeaders();
                }
                return headers;
            }
        };
        request.setResume(isResume);
        request.setTarget(target);
        if (httpResult != null) {
            httpResult.onRequestStart();
        }
        if (TextUtils.isEmpty(url)) {
            if (httpResult != null) {
                httpResult.onRequestError(new Exception("url can not be empty!"));
                httpResult.onRequestFinish();
            }
            return request;
        }
        if (mDownloadRequestQueue == null) {
            mDownloadRequestQueue = Volley.newNoCacheRequestQueue(mContext);
        }
        mDownloadRequestQueue.add(request);
        return request;

    }

    /**
     * 处理请求
     *
     * @since 1.0
     */
    private void sendRequest(final int method, final RequestInfo requestInfo,
                             final HttpCallback httpCallback) {
        if (mRequestQueue == null)
            mRequestQueue = Volley.newNoCacheRequestQueue(mContext);

        if (httpCallback != null) {
            httpCallback.onRequestStart();
        }

        if (requestInfo == null || TextUtils.isEmpty(requestInfo.getUrl())) {
            if (httpCallback != null) {
                httpCallback.onRequestError(new Exception("url can not be empty"));
                httpCallback.onRequestFinish();
            }
            return;
        }

        final StringRequest stringRequest = new StringRequest(method, requestInfo.getUrl(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (httpCallback != null) {
                            httpCallback.onRequestResult(response);
                            httpCallback.onRequestFinish();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (httpCallback != null) {
                    httpCallback.onRequestError(error);
                    httpCallback.onRequestFinish();
                }
            }
        }, new Response.LoadingListener() {
            @Override
            public void onLoading(long count, long current) {
                if (httpCallback != null) {
                    httpCallback.onRequestLoading(count, current);
                }
            }
        }) {
            @Override
            public void cancel() {
                super.cancel();
                if (httpCallback != null) {
                    httpCallback.onRequestCancelled();
                }
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (method == Method.POST || method == Method.PUT) {
                    VolleyLog.d((method == Method.POST ? "post->%s" : "put->%s"),
                            requestInfo.getUrl() + ",params->" + requestInfo.getParams().toString());
                    return requestInfo.getParams();
                }
                return super.getParams();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return requestInfo.getHeaders().size() > 0 ? requestInfo.getHeaders() : super.getHeaders();
            }
        };
        stringRequest.setTag(this);
        mRequestQueue.add(stringRequest);
    }


    /**
     * 处理请求
     *
     * @since 1.0
     */
    private void sendJsonRequest(final int method, final RequestInfo requestInfo,
                                 final HttpCallback httpCallback) throws JSONException {
        if (mRequestQueue == null)
            mRequestQueue = Volley.newNoCacheRequestQueue(mContext);

        if (httpCallback != null) {
            httpCallback.onRequestStart();
        }

        if (requestInfo == null || TextUtils.isEmpty(requestInfo.getUrl())) {
            if (httpCallback != null) {
                httpCallback.onRequestError(new Exception("url can not be empty"));
                httpCallback.onRequestFinish();
            }
            return;
        }

        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(method, requestInfo.getUrl(),
                new JSONObject(new Gson().toJson(requestInfo.getParams())), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (httpCallback != null) {
                    httpCallback.onRequestResult(response.toString());
                    httpCallback.onRequestFinish();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (httpCallback != null) {
                    httpCallback.onRequestError(error);
                    httpCallback.onRequestFinish();
                }
            }
        }) {
            @Override
            public void cancel() {
                super.cancel();
                if (httpCallback != null) {
                    httpCallback.onRequestCancelled();
                }
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return requestInfo.getHeaders().size() > 0 ? requestInfo.getHeaders() : super.getHeaders();
            }
        };
        jsonObjectRequest.setTag(this);
        System.out.print("jsonObjectRequest----------->"+jsonObjectRequest.toString());
        mRequestQueue.add(jsonObjectRequest);
    }


    /**
     * 取消网络请求
     *
     * @since 1.0
     */
    public void cancelAllRequest() {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(this);
        }
    }

    /**
     * 取消下载请求
     *
     * @since 1.0
     */
    public void quitDownloadQueue() {
        if (mDownloadRequestQueue != null) {
            mDownloadRequestQueue.stop();
            mDownloadRequestQueue = null;
        }
    }

    /**
     * 使用URLEconder编码字符串
     *
     * @since 1.0
     */
    public Map<String, String> urlEncodeMap(Map<String, String> paramsMap) {
        if (paramsMap != null && !paramsMap.isEmpty()) {
            for (String key : paramsMap.keySet()) {
                try {
                    paramsMap.put(key, URLEncoder.encode(paramsMap.get(key), "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return paramsMap;
    }

    public Map<String, String> getHeaders() {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json; charset=UTF-8");
        return headers;
    }

}
