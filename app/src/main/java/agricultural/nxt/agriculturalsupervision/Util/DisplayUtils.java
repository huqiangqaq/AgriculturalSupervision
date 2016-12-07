package agricultural.nxt.agriculturalsupervision.Util;

import android.content.Context;
import android.util.TypedValue;

/**dp，sp转换成px的工具类
 * Created by huqiang on 2016/12/7 10:59.
 */

public class DisplayUtils {
    /**
     * 将px值转换成dpi或者dp值，保持尺寸不变
     * @param content
     * @param pxValus
     * @return
     */
    public static int px2dip(Context content, float pxValus) {
        final float scale = content.getResources().getDisplayMetrics().density;
        return (int) (pxValus / scale + 0.5f);
    }

    /**
     * 将dip和dp转化成px,保证尺寸大小不变
     * @param content
     * @param pxValus
     * @return
     */
    public static int dip2px(Context content, float pxValus) {
        final float scale = content.getResources().getDisplayMetrics().density;
        return (int) (pxValus / scale + 0.5f);
    }

    /**
     * 将px转化成sp,保证文字大小不变。
     * @param content
     * @param pxValus
     * @return
     */
    public static int px2sp(Context content, float pxValus) {
        final float fontScale = content.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValus / fontScale + 0.5f);
    }

    /**
     * 将sp转化成px,保证文字大小不变。
     * @param content
     * @param pxValus
     * @return
     */
    public static int sp2px(Context content, float pxValus) {
        final float fontScale = content.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValus / fontScale + 0.5f);
    }

    /**
     * dp2px
     * @param dp
     * @return
     */
    protected int dp2px(Context context,int dp){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,context.getResources().getDisplayMetrics());
    }

    /**
     * sp2px
     * @param sp
     * @return
     */
    protected int sp2px(Context context,int sp){
        return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,sp,context.getResources().getDisplayMetrics());
    }
}
