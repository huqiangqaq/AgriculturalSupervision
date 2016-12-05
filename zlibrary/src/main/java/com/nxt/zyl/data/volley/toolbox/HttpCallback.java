package com.nxt.zyl.data.volley.toolbox;

public interface HttpCallback {
	void onRequestStart();
	void onRequestFinish();
	void onRequestResult(String string);
	void onRequestError(Exception e);
	void onRequestCancelled();
	void onRequestLoading(long count, long current);
}
