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

import agricultural.nxt.agriculturalsupervision.Constants;
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
     * @param callBack
     * @param tag   //多个请求时的标记
     */
    public static void Get(String url, final GetCallBack callBack, final int tag){
        OkGo.get(url)
                .tag(tag)  // 请求的 tag, 主要用于取消对应的请求
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

    public static void GetImage(String bitmapUrl, final BitmapCallBack callBack,int tag){
        OkGo.get(bitmapUrl)
                .tag(tag)
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
    public static void Download(String FileUrl, final FileCallBack callBack, final int tag){
        OkGo.get(FileUrl)
                .execute(new FileCallback() {
                    @Override
                    public void onSuccess(File file, Call call, Response response) {
//                        callBack.onFielDownload(file,tag);
                        try {
                            callBack.onSuccess(response.body().string(),tag);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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
    public static void PostString(String url, String param, final PostCallBack callBack, final int tag){
        OkGo.post(url)
                .tag(tag)
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
    public static void PostJson(String url, JSONObject json, final PostCallBack callBack, final int tag){
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

    public static void Post(String url, Map<String,String> map, final PostCallBack callBack, final int tag){
        OkGo.post(url)
                .tag(tag)
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

    public static void PostFileSingle(String fileUrl, Map<String,String> params, String fileName, String filePath, final PostCallBack callBack, final int tag){
            OkGo.post(fileUrl)
                    .tag(tag)
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

    public static void PostFiles(String fileUrl, Map<String,String> params, String key, List<File> files, final PostCallBack callBack, final int tag){
        OkGo.post(fileUrl)
                .tag(tag)
                .params(params)
                .addFileParams(key,files)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        callBack.onSuccess(s,tag);
                    }
                });
    }


    public interface GetCallBack{
        void onSuccess(String response,int tag);
        void onFailed(String error,int tag);


    }
    public interface PostCallBack{
        void onSuccess(String response,int tag);
        void onFailed(String error,int tag);
        void onProgress(long currentSize,long totalSize,float progress,long networkSpeed);
        }

    public interface BitmapCallBack{
        void onSuccess(Bitmap bitmap);
    }

    public interface FileCallBack{
        void onSuccess(String response,int tag);
        void onFailed(String error,int tag);
        void onProgress(long currentSize,long totalSize,float progress,long networkSpeed);
    }

    //异步post请求
    public static void post(Map<String, String> params,Object obj,final GetCallBack back,final int tag,final Object listen){

        OkGo.post(Constants.BASE_URL)
                .tag(obj)
                .cacheKey(params.get("service"))
                .params(params,true)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {


                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                    }



                    @Override
                    public void onCacheSuccess(String s, Call call) {
                        super.onCacheSuccess(s, call);

                    }

                    @Override
                    public void onCacheError(Call call, Exception e) {
                        super.onCacheError(call, e);
                    }
                });
    }

}
