package agricultural.nxt.agriculturalsupervision.Activity.sales;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.nxt.zyl.util.ZPreferenceUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.Menu;
import butterknife.BindView;
import butterknife.OnClick;



public class MenuSaleActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.rl_product_seed)
    RelativeLayout rl_product_seed;
    @BindView(R.id.rl_product_pesticide)
    RelativeLayout rl_product_pesticide;
    @BindView(R.id.rl_product_fertilizer)
    RelativeLayout rl_product_fertilizer;
    private String id;
    private Map<String, Boolean> map = new HashMap<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("农资产品销售");
        toolBar.setLeftButtonIcon(ContextCompat.getDrawable(this,R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());
        id = ZPreferenceUtils.getPrefString("农资产品销售", "");
        Map<String, String> idMap = new HashMap<>();
        idMap.put("id", id);
        showLoadingDialog(R.string.loading);
        OkhttpHelper.Post(Constants.GETMENULIST, idMap, new OkhttpHelper.PostCallBack() {
            @Override
            public void onSuccess(String response, int tag) {

                getMenu(response);

            }

            @Override
            public void onFailed(String error, int tag) {

            }

            @Override
            public void onProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

            }
        }, 1);
    }

    private void getMenu(String response) {
        Menu menu = new Gson().fromJson(response, Menu.class);
        dismissLoadingDialog();
        List<Menu.MenuListBean> list = menu.getMenuList();
        map.put("种子销售", false);
        map.put("农药销售", false);
        map.put("化肥销售", false);
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i).getName();
            if (name.contains("种子销售")) {
                map.put("种子销售", true);
            } else if (name.contains("农药销售")) {
                map.put("农药销售", true);
            } else if (name.contains("化肥销售")) {
                map.put("化肥销售", true);
            }
        }
        if (map.get("种子销售")) {
            rl_product_seed.setVisibility(View.VISIBLE);
        }
        if (map.get("农药销售")) {
            rl_product_pesticide.setVisibility(View.VISIBLE);
        }
        if (map.get("化肥销售")) {
            rl_product_fertilizer.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 种子销售
     */
    @OnClick(R.id.rl_product_seed)
    void recode() {
        SaleActivity.actionStart(this);
    }

    /**
     * 农药销售
     */
    @OnClick(R.id.rl_product_pesticide)
    void pesticide() {
        SalePesticideActivity.actionStart(this);
    }

    /**
     * 化肥销售
     */
    @OnClick(R.id.rl_product_fertilizer)
    void fertilizer() {
        SaleFerActivity.actionStart(this);
    }

    public static void actionStart(Context context){
        context.startActivity(new Intent(context,MenuSaleActivity.class));
    }
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_menu_sale;
    }
}
