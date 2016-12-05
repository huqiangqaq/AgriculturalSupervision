package agricultural.nxt.agriculturalsupervision.Util;

import android.graphics.Bitmap;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.BitmapCallback;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.callback.StringCallback;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by huqiang on 2016/11/25 15:30.
 */

public class OkhttpHelper {
    private static OkhttpHelper helper;
    public static synchronized OkhttpHelper getInstance(){
        if (helper ==null){
            helper = new OkhttpHelper();
        }
        return helper;
    }

    /**
     *
     * @param url
     * @param cacheKey  // 设置当前请求的缓存key,建议每个不同功能的请求设置一个
     * @param callBack
     * @param tag   //多个请求时的标记
     */
    public void Get(String url, String cacheKey, final MyCallBack callBack, final int tag){
        OkGo.get(url)
                .tag(this)  // 请求的 tag, 主要用于取消对应的请求
                .cacheKey(cacheKey)
                .cacheMode(CacheMode.DEFAULT)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                            callBack.onSuccess(s,tag);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        try {
                            callBack.onFailed(response.body().string(),tag);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        super.onError(call, response, e);
                    }
                });
    }

    /**
     * 请求BitMap对象
     * @param bitmapUrl
     * @param callBack
     */

    public void GetImage(String bitmapUrl, final MyCallBack callBack){
        OkGo.get(bitmapUrl)
                .tag(this)
                .execute(new BitmapCallback() {
                    @Override
                    public void onSuccess(Bitmap bitmap, Call call, Response response) {
                        callBack.onSuccess(bitmap);
                    }
                });

    }

    /**
     * 请求文件下载
     * @param FileUrl
     * @param callBack
     * @param tag
     */
    public void Download(String FileUrl, final MyCallBack callBack, final int tag){
        OkGo.get(FileUrl)
                .execute(new FileCallback() {
                    @Override
                    public void onSuccess(File file, Call call, Response response) {
                        callBack.onFielDownload(file,tag);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        try {
                            callBack.onFailed(response.body().string(),tag);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        super.onError(call, response, e);
                    }

                    @Override
                    public void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        callBack.onProgress(currentSize,totalSize,progress,networkSpeed);
                        super.downloadProgress(currentSize, totalSize, progress, networkSpeed);
                    }
                });
    }

    /**
     *
     * @param url
     * @param param
     * @param callBack
     * @param tag
     */
    public void PostString(String url, String param, final MyCallBack callBack, final int tag){
        OkGo.post(url)
                .tag(this)
                .upString(param)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        callBack.onSuccess(s,tag);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        try {
                            callBack.onFailed(response.body().string(),tag);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        super.onError(call, response, e);
                    }
                });
    }

    /**
     *
     * @param url
     * @param json
     * @param callBack
     * @param tag
     */
    public void PostJson(String url, JSONObject json, final MyCallBack callBack, final int tag){
        OkGo.post(url)
                .upJson(json.toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        callBack.onSuccess(s,tag);
                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        callBack.onProgress(currentSize,totalSize,progress,networkSpeed);
                        super.upProgress(currentSize, totalSize, progress, networkSpeed);
                    }
                });
    }

    /**
     *
     * @param url
     * @param map
     * @param callBack
     * @param tag
     */

    public void Post(String url, Map<String,String> map, final MyCallBack callBack, final int tag){
        OkGo.post(url)
                .tag(this)
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        callBack.onSuccess(s,tag);
                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        callBack.onProgress(currentSize,totalSize,progress,networkSpeed);
                        super.upProgress(currentSize, totalSize, progress, networkSpeed);
                    }
                });
    }

    /**
     * 上传单个文件
     * @param fileUrl
     * @param params
     * @param fileName
     * @param filePath
     * @param callBack
     * @param tag
     */

    public void PostFileSingle(String fileUrl, Map<String,String> params, String fileName, String filePath, final MyCallBack callBack, final int tag){
            OkGo.post(fileUrl)
                    .tag(this)
                    .params(params)
                    .params(fileName,new File(filePath))
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            callBack.onSuccess(s,tag);
                        }
                    });
    }


    /**
     * 一个key传多个文件
     * @param fileUrl
     * @param params
     * @param key
     * @param files
     * @param callBack
     * @param tag
     */

    public void PostFiles(String fileUrl, Map<String,String> params, String key, List<File> files, final MyCallBack callBack, final int tag){
        OkGo.post(fileUrl)
                .tag(this)
                .params(params)
                .addFileParams(key,files)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        callBack.onSuccess(s,tag);
                    }
                });
    }







    interface MyCallBack{
        void onSuccess(String response,int tag);
        void onFailed(String error,int tag);
        void onSuccess(Bitmap bitmap);
        void onFielDownload(File file,int tag);
        void onProgress(long currentSize,long totalSize,float progress,long networkSpeed);
    }

}
