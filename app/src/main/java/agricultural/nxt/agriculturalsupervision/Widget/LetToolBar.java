package agricultural.nxt.agriculturalsupervision.Widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import agricultural.nxt.agriculturalsupervision.R;

/**
 * Created by huqiang on 2016/11/15 13:49.
 */

public class LetToolBar extends Toolbar {
    //添加布局必不可少的工具
    private LayoutInflater inflater;
    //标题
    private TextView mTextTitle;
    //左边按钮
    private ImageView mLeftButton;
    private RelativeLayout rl_left;
    //右边按钮
    private ImageView mRightButton;
    private View mView;
    public LetToolBar(Context context) {
        this(context,null);
    }

    public LetToolBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LetToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        setContentInsetsRelative(10,10);
        if (attrs!=null){
            TintTypedArray array = TintTypedArray.obtainStyledAttributes(getContext(),attrs,R.styleable.LetToolBar,
                    defStyleAttr,0);
            Drawable leftIcon = array.getDrawable(R.styleable.LetToolBar_leftButtonIcon);
            if (leftIcon !=null){
                setLeftButtonIcon(leftIcon);
            }
            Drawable rightIcon = array.getDrawable(R.styleable.LetToolBar_rightButtonIcon);
            if (rightIcon !=null){
                setRightButtonIcon(rightIcon);
            }
            int color = array.getColor(R.styleable.LetToolBar_titleTextColor,0);
                setTitleTextColor(color);
            int size = array.getDimensionPixelSize(R.styleable.LetToolBar_titleTextSize,(int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
            setTitleSzie(size);
            array.recycle();
        }
    }

    @Override
    public void setTitle(@StringRes int resId) {
        setTitle(getContext().getText(resId));
    }

    @Override
    public void setTitle(CharSequence title) {
        initView();
        if (mTextTitle != null) {
            mTextTitle.setText(title);
            showTitleView();
        }
    }

    @Override
    public void setTitleTextColor(@ColorInt int color) {
        initView();
        if (mTextTitle !=null){
            mTextTitle.setTextColor(color);
        }
    }


    //设置标题文字大小
    private void setTitleSzie(float szie){
        mTextTitle.setTextSize(szie);
    }
    //设置标题文字颜色
    private void setmTittleColor(int resID){
        if (mTextTitle!=null){
            mTextTitle.setTextColor(resID);
        }
    }
    //隐藏标题
    public void hideTittleView() {
        if (mTextTitle != null)
            mTextTitle.setVisibility(GONE);
        mLeftButton.setVisibility(GONE);
        mRightButton.setVisibility(GONE);
    }
    //显示标题
    private void showTitleView() {
        if (mTextTitle != null)
            mTextTitle.setVisibility(VISIBLE);
    }

    public void setRightButtonIcon(Drawable rightIcon) {
        if (mRightButton!=null){
            mRightButton.setImageDrawable(rightIcon);
            mRightButton.setVisibility(VISIBLE);
        }
    }

    public void setLeftButtonIcon(Drawable leftIcon) {
        if (mLeftButton!=null){
            mLeftButton.setImageDrawable(leftIcon);
            mLeftButton.setVisibility(VISIBLE);
        }
    }

    //设置右侧按钮监听事件
    public void setRightButtonOnClickLinster(OnClickListener linster) {
        mRightButton.setOnClickListener(linster);
    }


    //设置左侧按钮监听事件
    public void setLeftButtonOnClickLinster(OnClickListener linster) {
        rl_left.setOnClickListener(linster);
    }

    private void initView() {
        if (mView==null){
            inflater = LayoutInflater.from(getContext());
            mView = inflater.inflate(R.layout.toolbar,null);

            rl_left = (RelativeLayout) mView.findViewById(R.id.rl_left);
            mTextTitle = (TextView) mView.findViewById(R.id.toolbar_tittle);
            mLeftButton = (ImageView) mView.findViewById(R.id.toolbar_leftbutton);
            mRightButton = (ImageView) mView.findViewById(R.id.toolbar_rightbutton);
            LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
            addView(mView,lp);
        }
    }
}
