package agricultural.nxt.agriculturalsupervision.base;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.TouchDelegate;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;

import com.nxt.zyl.ui.widget.AVLoadingIndicatorView;

import java.util.Calendar;

import agricultural.nxt.agriculturalsupervision.Application.MyApplication;
import agricultural.nxt.agriculturalsupervision.Util.AppManager;
import butterknife.ButterKnife;

/**
 * Created by huqiang on 2016/11/14 8:56.
 */

public abstract class BaseActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    protected InputMethodManager inputMethodManager;
    protected ProgressDialog loadingDialog;
    protected MyApplication application;
    protected static Calendar calendar = Calendar.getInstance();
    protected AVLoadingIndicatorView loadingIndicatorView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        AppManager.getAppManager().addActivity(this);
        application = MyApplication.getInstance();
        ButterKnife.bind(this);
        initView();
    }


    /**
     * 初始化组件
     */
    protected abstract void initView();


    /**
     * 初始化界面
     */
    protected abstract int getLayoutResId();

    /**
     * 显示或隐藏输入法
     */
    protected void toggleInput() {
        if (getWindow().getAttributes().softInputMode
                == WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED) {
            if (inputMethodManager == null)
                inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    protected void showtimedialog() {
        DatePickerDialog dialog = new DatePickerDialog(this, this, calendar
                .get(Calendar.YEAR), calendar
                .get(Calendar.MONTH), calendar
                .get(Calendar.DAY_OF_MONTH));

        dialog.show();
    }

    /**
     * 显示进度对话框
     *
     * @param message {@link String} 消息文本
     */
    protected void showLoadingDialog(int message) {
        if (loadingDialog == null) {
            loadingDialog = new ProgressDialog(this);
        }
        loadingDialog.setMessage(getString(message));
        loadingDialog.setCancelable(false);
        loadingDialog.show();
    }

    /**
     * 取消进度对话框
     */
    protected void dismissLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing())
            loadingDialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }

    public void showloading() {
        loadingIndicatorView = new AVLoadingIndicatorView(this);
        loadingIndicatorView.setVisibility(View.VISIBLE);
    }

    public void dismissloading() {
        if (loadingIndicatorView != null)
            loadingIndicatorView.setVisibility(View.GONE);
    }

    /**
     * 提升点击范围
     *
     * @param view
     * @param expandTouchWidth
     */
    public void setTouchDelegate(final View view, final int expandTouchWidth) {
        final View parentView = (View) view.getParent();
        parentView.post(new Runnable() {
            @Override
            public void run() {
                final Rect rect = new Rect();
                view.getHitRect(rect);
                rect.top -= expandTouchWidth;
                rect.bottom += expandTouchWidth;
                rect.left -= expandTouchWidth;
                rect.right += expandTouchWidth;
                TouchDelegate touchDelegate = new TouchDelegate(rect, view);
                parentView.setTouchDelegate(touchDelegate);
            }
        });
    }
}
