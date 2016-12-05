package com.nxt.zyl.util;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by huqiang on 2016/12/5 11:16.
 */

public class ZSnackBarUtils {
    private static Snackbar snackbar;

    public static void showShort(View view,CharSequence message){
        if (snackbar==null){
            snackbar = Snackbar.make(view,message,Snackbar.LENGTH_SHORT);
        }else {
            snackbar.setText(message);
        }
        snackbar.show();
    }

    public static void showShort(View view,int resid){
        if (snackbar==null){
            snackbar = Snackbar.make(view,resid,Snackbar.LENGTH_SHORT);
        }else {
            snackbar.setText(resid);
        }
        snackbar.show();
    }

    public static void showLong(View view,CharSequence message){
        if (snackbar==null){
            snackbar = Snackbar.make(view,message,Snackbar.LENGTH_LONG);
        }else {
            snackbar.setText(message);
        }
        snackbar.show();
    }
    public static void showLong(View view,int message){
        if (snackbar==null){
            snackbar = Snackbar.make(view,message,Snackbar.LENGTH_LONG);
        }else {
            snackbar.setText(message);
        }
        snackbar.show();
    }

    public static void show(View view, CharSequence message, int duration) {
        if (null == snackbar) {
            snackbar = Snackbar.make(view,message,duration);
        } else {
            snackbar.setText(message);
        }
        snackbar.show();
    }

    public static void show(View view, int message, int duration) {
        if (null == snackbar) {
            snackbar = Snackbar.make(view,message,duration);
        } else {
            snackbar.setText(message);
        }
        snackbar.show();
    }

    public static void hideToast() {
        if (null != snackbar) {
            snackbar.dismiss();
        }
    }
}
