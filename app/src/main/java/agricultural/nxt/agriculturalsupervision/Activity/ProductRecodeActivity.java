package agricultural.nxt.agriculturalsupervision.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class ProductRecodeActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.rl_product_recode)
    RelativeLayout rl_product_recode;
    @BindView(R.id.rl_batch_code)
    RelativeLayout rl_batch_code;
    @BindView(R.id.rl_security_code)
    RelativeLayout rl_security_code;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("产品备案");
        toolBar.setLeftButtonIcon(getResources().getDrawable(R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 产品备案
     * @return
     */
    @OnClick(R.id.rl_product_recode) void recode(){

    }

    /**
     * 批次码打印
     * @return
     */
    @OnClick(R.id.rl_batch_code) void batch(){

    }

    /**
     * 防伪码打印
     * @return
     */
    @OnClick(R.id.rl_security_code) void security(){

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_product_recode;
    }
    public static void actionStart(Context context){
        Intent intent = new Intent(context,ProductRecodeActivity.class);
        context.startActivity(intent);
    }
}
