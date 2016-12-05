/**
 * Copyright (C) 2013-2014 EaseMob Technologies. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nxt.zyl.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;


public class CommonUtils {

    /**
     * 检测网络是否可用
     *
     * @param context 上下文对象
     * @return boolean
     */
    public static boolean isNetWorkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }

        return false;
    }

    /**
     * 检测Sdcard是否存在
     *
     * @return boolean
     */
    public static boolean isExitsSdcard() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }


    static String getStrng(Context context, int resId) {
        return context.getResources().getString(resId);
    }


    public static String getTopActivity(Context context) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningTaskInfo> runningTaskInfos = manager.getRunningTasks(1);

        if (runningTaskInfos != null)
            return runningTaskInfos.get(0).topActivity.getClassName();
        else
            return "";
    }

    /**
     * 判断是否是手机号
     *
     * @param mobiles String 字符串
     * @return true，是手机号；false，不是手机号
     */
    public static boolean isMobileNO(String mobiles) {
        return Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-3,5-9])|(17[6,7]))\\d{8}$").matcher(mobiles).matches();
    }

    /**
     * 判断是否是数字
     *
     * @param str String 字符串
     * @return true, 是数字；false，不是数字
     */
    public static boolean isNumeric(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }


    /**
     * 将指定的字符串用MD5加密
     *
     * @param originstr String 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String ecodeByMD5(String originstr) {
        String result = null;
        char hexDigits[] = {//用来将字节转换成 16 进制表示的字符
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (originstr != null) {
            try {
                //返回实现指定摘要算法的 MessageDigest 对象
                MessageDigest md = MessageDigest.getInstance("MD5");
                //使用utf-8编码将originstr字符串编码并保存到source字节数组
                byte[] source = originstr.getBytes("utf-8");
                //使用指定的 byte 数组更新摘要
                md.update(source);
                //通过执行诸如填充之类的最终操作完成哈希计算，结果是一个128位的长整数
                byte[] tmp = md.digest();
                //用16进制数表示需要32位
                char[] str = new char[32];
                for (int i = 0, j = 0; i < 16; i++) {
                    //j表示转换结果中对应的字符位置
                    //从第一个字节开始，对 MD5 的每一个字节
                    //转换成 16 进制字符
                    byte b = tmp[i];
                    //取字节中高 4 位的数字转换
                    //无符号右移运算符>>> ，它总是在左边补0
                    //0x代表它后面的是十六进制的数字. f转换成十进制就是15
                    str[j++] = hexDigits[b >>> 4 & 0xf];
                    // 取字节中低 4 位的数字转换
                    str[j++] = hexDigits[b & 0xf];
                }
                result = new String(str);//结果转换成字符串用于返回
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 随机生成6为短信验证码
     *
     * @return String
     */
    public static String getRandomPSMSValidateCode() {
        Random rd = new Random();
        String n = "";
        int getNum;
        do {
            getNum = Math.abs(rd.nextInt()) % 10 + 48;//产生数字0-9的随机数
            //getNum = Math.abs(rd.nextInt())%26 + 97;//产生字母a-z的随机数
            char num1 = (char) getNum;
            String dn = Character.toString(num1);
            n += dn;
        } while (n.length() < 6);
      //  LogUtils.d("随机的6位密码是：" + n);
        return n;
    }
}
