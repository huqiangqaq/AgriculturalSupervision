package agricultural.nxt.agriculturalsupervision.Activity.intercourse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.RelativeLayout;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class IntercourseMenuActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.rl_product_seed)
    RelativeLayout rl_product_seed;
    @BindView(R.id.rl_product_pesticide)
    RelativeLayout rl_product_pesticide;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("企业管理");
        toolBar.setLeftButtonIcon(ContextCompat.getDrawable(this,R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_intercourse_menu;
    }

    @OnClick(R.id.rl_product_seed) void client(){
        ClientActivity.actionStart(this);
    }
    @OnClick(R.id.rl_product_pesticide) void supplier(){
        supplierActivity.actionStart(this);
    }

    public static void ActionStart(Context context){
        context.startActivity(new Intent(context,IntercourseMenuActivity.class));
    }
}
