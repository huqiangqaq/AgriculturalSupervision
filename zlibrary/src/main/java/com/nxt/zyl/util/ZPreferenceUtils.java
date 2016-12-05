package com.nxt.zyl.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * 首选项工具类,在Application类的onCreate()方法中进行初始化
 *
 * @author koneloong koneloong@gmail.com
 *         Created on 2015/8/5 11:34.
 * @version 1.0
 * @since 1.0
 */
public class ZPreferenceUtils {
    private static SharedPreferences mSharedPreferences;

    /**
     * @since 1.0
     */
    public static void init(Context context) {
        if (mSharedPreferences == null) {
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
    }

    /**
     * @since 1.0
     */
    public static String getPrefString(final String key, final String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

    /**
     * @since 1.0
     */
    public static void setPrefString(final String key, final String value) {
        mSharedPreferences.edit().putString(key, value).apply();
    }

    /**
     * @since 1.0
     */
    public static boolean getPrefBoolean(final String key, final boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }

    /**
     * @since 1.0
     */
    public static boolean hasKey(final String key) {
        return mSharedPreferences.contains(key);
    }

    /**
     * @since 1.0
     */
    public static void setPrefBoolean(final String key, final boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).apply();
    }

    /**
     * @since 1.0
     */
    public static void setPrefInt(final String key, final int value) {
        mSharedPreferences.edit().putInt(key, value).apply();
    }

    /**
     * @since 1.0
     */
    public static int getPrefInt(final String key, final int defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }

    /**
     * @since 1.0
     */
    public static void setPrefFloat(final String key, final float value) {
        mSharedPreferences.edit().putFloat(key, value).apply();
    }

    /**
     * @since 1.0
     */
    public static float getPrefFloat(final String key, final float defaultValue) {
        return mSharedPreferences.getFloat(key, defaultValue);
    }

    /**
     * @since 1.0
     */
    public static void setSettingLong(final String key, final long value) {
        mSharedPreferences.edit().putLong(key, value).apply();
    }

    /**
     * @since 1.0
     */
    public static long getPrefLong(final String key, final long defaultValue) {
        return mSharedPreferences.getLong(key, defaultValue);
    }

    public static void clearPreference(Context context) {
        mSharedPreferences.edit().clear().apply();
    }
}
