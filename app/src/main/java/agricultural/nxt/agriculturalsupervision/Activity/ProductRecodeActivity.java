package agricultural.nxt.agriculturalsupervision.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.nxt.zyl.util.ZPreferenceUtils;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class ProductRecodeActivity extends BaseActivity{
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.rl_product_seed)
    RelativeLayout rl_product_seed;
    @BindView(R.id.rl_product_pesticide)
    RelativeLayout rl_batch_pesticide;
    @BindView(R.id.rl_product_fertilizer)
    RelativeLayout rl_product_fertilizer;
    private static final String cacheKey = "ProductRecodeActivity";
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
        String id = ZPreferenceUtils.getPrefString("产品备案","");

    }

    /**
     * 种子备案
     */
    @OnClick(R.id.rl_product_seed) void recode(){
        RecodeActivity.actionStart(this);
    }

    /**
     * 农药备案
     */
    @OnClick(R.id.rl_product_pesticide) void batch(){

    }

    /**
     * 化肥备案
     */
    @OnClick(R.id.rl_product_fertilizer) void security(){

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
