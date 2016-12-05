package com.nxt.zyl.data.volley.toolbox;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class RequestInfo {

    private String url;
    private Map<String, String> params = new HashMap<>();
    private Map<String, String> headers = new HashMap<>();
    private Map<String, File> fileParams = new HashMap<>();

    public RequestInfo() {
    }

    public RequestInfo(String url, Map<String, String> params, Map<String, String> headers) {
        this.url = url;
        if (params != null)
            this.params.putAll(params);
        if (headers != null)
            this.headers.putAll(headers);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params.putAll(params);
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers.putAll(headers);
    }

    public Map<String, File> getFileParams() {
        return fileParams;
    }

    public void setFileParams(Map<String, File> fileParams) {
        this.fileParams.putAll(fileParams);
    }

    public void putAllParams(Map<String, Object> objectParams) {
        if (params != null) {
            for (String key : objectParams.keySet()) {
                Object value = objectParams.get(key);
                if (value instanceof String) {
                    params.put(key, (String) value);
                } else if (value instanceof File) {
                    fileParams.put(key, (File) value);
                }
            }
        }
    }
}
