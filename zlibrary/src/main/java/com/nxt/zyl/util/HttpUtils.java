package com.nxt.zyl.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpUtils {

    private static String oriJson2;
    private static String result = "";
    static String oriJson;

    public HttpUtils() {
    }

    public static String jsonPost(String url, String json) {


        try {
            HttpClient hc = new DefaultHttpClient();
            HttpPost hp = new HttpPost(url);

            hp.setEntity(new StringEntity(json));
            HttpResponse hr = hc.execute(hp);
            int code = hr.getStatusLine().getStatusCode();
            Log.i("code", code + "");
            if (code == 200) {
                result = EntityUtils.toString(hr.getEntity());

            }
            if (hc != null) {
                hc.getConnectionManager().shutdown();
            }
        } catch (Exception e) {

            e.printStackTrace();

        }
        return result;
    }

    public static String getOriginalJSON(String path) {

        if (path == null) {
            return null;
        }
        URL url;
        try {
            url = new URL(path);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(6000);
            conn.setReadTimeout(5 * 1000);
            conn.connect();
            InputStream inStream = conn.getInputStream();
            int code = conn.getResponseCode();
            //System.out.println("get00000000000000code"+code);
            if (code != 200) {

                return null;
            }
            byte[] data = StreamTool.read(inStream);
            oriJson = new String(data);
            return oriJson;
        } catch (Exception e) {

            return null;
        }
    }

    public static String getJsonContent(String url_path) {

        try {
            URL url = new URL(url_path);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setConnectTimeout(3000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            int code = connection.getResponseCode();
            if (code == 200) {
                return changeInputStream(connection.getInputStream());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    private static String changeInputStream(InputStream inputStream) {
        // TODO Auto-generated method stub
        String jsonString = "";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int len = 0;
        byte[] data = new byte[1024];
        try {
            while ((len = inputStream.read(data)) != -1) {
                outputStream.write(data, 0, len);
            }
            jsonString = new String(outputStream.toByteArray());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonString;
    }

    public static String post(String url, Map<String, String> params, Map<String, File> files)
           {
        String BOUNDARY = java.util.UUID.randomUUID().toString();
        String PREFIX = "--", LINEND = "\r\n";
        String MULTIPART_FROM_DATA = "multipart/form-data";
        String CHARSET = "UTF-8";


               URL uri = null;
               try {
                   uri = new URL(url);
                   HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
                   conn.setReadTimeout(10 * 1000); // 缓存的最长时间
                   conn.setDoInput(true);// 允许输入
                   conn.setDoOutput(true);// 允许输出
                   conn.setUseCaches(false); // 不允许使用缓存
                   conn.setRequestMethod("POST");
                   conn.setRequestProperty("connection", "keep-alive");
                   conn.setRequestProperty("Charsert", "UTF-8");
                   conn.setRequestProperty("Content-Type", MULTIPART_FROM_DATA + ";boundary=" + BOUNDARY);


                   // 首先组拼文本类型的参数
                   StringBuilder sb = new StringBuilder();
                   for (Map.Entry<String, String> entry : params.entrySet()) {
                       sb.append(PREFIX);
                       sb.append(BOUNDARY);
                       sb.append(LINEND);
                       sb.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"" + LINEND);
                       sb.append("Content-Type: text/plain; charset=" + CHARSET + LINEND);
                       sb.append("Content-Transfer-Encoding: 8bit" + LINEND);
                       sb.append(LINEND);
                       sb.append(entry.getValue());
                       sb.append(LINEND);
                   }


                   DataOutputStream outStream = new DataOutputStream(conn.getOutputStream());
                   outStream.write(sb.toString().getBytes());
                   // 发送文件数据
                   if (files != null)
                       for (Map.Entry<String, File> file : files.entrySet()) {
                           StringBuilder sb1 = new StringBuilder();
                           sb1.append(PREFIX);
                           sb1.append(BOUNDARY);
                           sb1.append(LINEND);
                           System.out.println("file---->"+file.getValue()+"file name"+file.getValue().getName());
                            sb1.append("Content-Disposition: form-data; name=\"uploadfile\"; filename=\""
                                   + file.getValue().getName() + "\"" + LINEND);
                           sb1.append("Content-Type: application/octet-stream; charset=" + CHARSET + LINEND);
                           sb1.append(LINEND);
                           outStream.write(sb1.toString().getBytes());


                           InputStream is = new FileInputStream(file.getValue());
                           byte[] buffer = new byte[1024];
                           int len = 0;
                           while ((len = is.read(buffer)) != -1) {
                               outStream.write(buffer, 0, len);
                           }


                           is.close();
                           outStream.write(LINEND.getBytes());
                       }


                   // 请求结束标志
                   byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINEND).getBytes();
                   outStream.write(end_data);
                   outStream.flush();
                   // 得到响应码
                   int res = conn.getResponseCode();
                   System.out.println("res--------->"+res);
                   InputStream in = conn.getInputStream();
                   StringBuilder sb2 = new StringBuilder();
                   if (res == 200) {
                       int ch;
                       while ((ch = in.read()) != -1) {
                           sb2.append((char) ch);
                       }
                   }
                   outStream.close();
                   conn.disconnect();
                   return sb2.toString();
               } catch (Exception e) {
                   e.printStackTrace();
               }
return null;
    }
    public static Bitmap getPic(String url_path) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(url_path);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setConnectTimeout(3000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            int code = connection.getResponseCode();
            if (code == 200) {
                InputStream inputStream = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
                // System.out.println("=============="+bitmap.getWidth()+","+bitmap.getHeight());
                return bitmap;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return bitmap;
    }

    public static InputStream getPic2(String url_path) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(url_path);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setConnectTimeout(3000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            int code = connection.getResponseCode();
            if (code == 200) {
                InputStream inputStream = connection.getInputStream();

                // System.out.println("=============="+bitmap.getWidth()+","+bitmap.getHeight());
                return inputStream;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    public static Bitmap getImg(String path,Map<String, String> params) throws Exception {

        StringBuilder url = new StringBuilder(path);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            url.append(entry.getValue());
        }
        Log.e("DEBUG", "code url--------->" + url);

        HttpURLConnection conn = (HttpURLConnection) new URL(url.toString()).openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");

        InputStream is = conn.getInputStream();
        Bitmap bitmap = BitmapFactory.decodeStream(is);
        int code = conn.getResponseCode();
        if (code == 200) {

            Log.e("DEBUG", "链接成功");
        }

        Log.e("DEBUG", "result---------------!" + bitmap);
        return bitmap;
    }

    public static Uri getImageUrl2(String imagepath, File cachefile)
            throws Exception {
        File localfile = new File(cachefile, MD5.getMD5(imagepath)
                + imagepath.substring(imagepath.lastIndexOf(".")));
        if (localfile.exists()) {
            return Uri.fromFile(localfile);
        }
        URL url = new URL(imagepath);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setReadTimeout(3000);
        conn.setRequestMethod("GET");
        int code = conn.getResponseCode();
        if (code == 200) {
            FileOutputStream outStream = new FileOutputStream(localfile);
            InputStream inStream = conn.getInputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            inStream.close();
            outStream.close();
            return Uri.fromFile(localfile);
        }

        return null;
    }

    public static String post2(String url, Map<String, String> params, Map<String, File> files)
            throws IOException {
        String BOUNDARY = java.util.UUID.randomUUID().toString();
        String PREFIX = "--", LINEND = "\r\n";
        String MULTIPART_FROM_DATA = "multipart/form-data";
        String CHARSET = "UTF-8";


        URL uri = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
        conn.setReadTimeout(10 * 1000); // 缓存的最长时间
        conn.setDoInput(true);// 允许输入
        conn.setDoOutput(true);// 允许输出
        conn.setUseCaches(false); // 不允许使用缓存
        conn.setRequestMethod("POST");
        conn.setRequestProperty("connection", "keep-alive");
        conn.setRequestProperty("Charsert", "UTF-8");
        conn.setRequestProperty("Content-Type", MULTIPART_FROM_DATA + ";boundary=" + BOUNDARY);


        // 首先组拼文本类型的参数
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(PREFIX);
            sb.append(BOUNDARY);
            sb.append(LINEND);
            sb.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"" + LINEND);
            sb.append("Content-Type: text/plain; charset=" + CHARSET + LINEND);
            sb.append("Content-Transfer-Encoding: 8bit" + LINEND);
            sb.append(LINEND);
            sb.append(entry.getValue());
            sb.append(LINEND);
        }


        DataOutputStream outStream = new DataOutputStream(conn.getOutputStream());
        outStream.write(sb.toString().getBytes());
        // 发送文件数据
        if (files != null)
            for (Map.Entry<String, File> file : files.entrySet()) {
                StringBuilder sb1 = new StringBuilder();
                sb1.append(PREFIX);
                sb1.append(BOUNDARY);
                sb1.append(LINEND);
                sb1.append("Content-Disposition: form-data; name=\"uploadfile\"; filename=\""
                        + file.getValue().getName() + "\"" + LINEND);
                sb1.append("Content-Type: application/octet-stream; charset=" + CHARSET + LINEND);
                sb1.append(LINEND);
                outStream.write(sb1.toString().getBytes());


                InputStream is = new FileInputStream(file.getValue());
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = is.read(buffer)) != -1) {
                    outStream.write(buffer, 0, len);
                }


                is.close();
                outStream.write(LINEND.getBytes());
            }


        // 请求结束标志
        byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINEND).getBytes();
        outStream.write(end_data);
        outStream.flush();
        // 得到响应码
        int res = conn.getResponseCode();
        InputStream in = conn.getInputStream();
        StringBuilder sb2 = new StringBuilder();
        if (res == 200) {
            int ch;
            while ((ch = in.read()) != -1) {
                sb2.append((char) ch);
            }
        }
        outStream.close();
        conn.disconnect();
        return sb2.toString();
    }
}


