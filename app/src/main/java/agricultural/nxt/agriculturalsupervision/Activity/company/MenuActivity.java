package agricultural.nxt.agriculturalsupervision.Activity.company;

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

public class MenuActivity extends BaseActivity {
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
        toolBar.setTitle("企业管理");
        toolBar.setLeftButtonIcon(ContextCompat.getDrawable(this,R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());
        id = ZPreferenceUtils.getPrefString("企业管理", "");
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
        map.put("企业备案审核", false);
        map.put("企业备案", false);
        map.put("企业备案列表", false);
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i).getName();
            if (name.equalsIgnoreCase("企业备案审核")) {
                map.put("企业备案审核", true);
            } else if (name.equalsIgnoreCase("企业备案")) {
                map.put("企业备案", true);
            } else if (name.equalsIgnoreCase("企业备案列表")) {
                map.put("企业备案列表", true);
            }
        }
        if (map.get("企业备案")) {
            rl_product_seed.setVisibility(View.VISIBLE);
        }
        if (map.get("企业备案审核")) {
            rl_product_pesticide.setVisibility(View.VISIBLE);
        }
        if (map.get("企业备案列表")) {
            rl_product_fertilizer.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.rl_product_seed)
    void companyMsg() {
        CompanyActivity.actionStart(this);
    }

    @OnClick(R.id.rl_product_pesticide)
    void companyCheck() {
        CompanyViewActivity.actionStart(this, false, Constants.COMPANY_VIEW);
    }

    @OnClick(R.id.rl_product_fertilizer)
    void companyView() {
        CompanyViewActivity.actionStart(this, true, Constants.COMPANY_VIEWFORCHECK);
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_menu;
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MenuActivity.class);
        context.startActivity(intent);
    }
}
