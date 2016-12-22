package agricultural.nxt.agriculturalsupervision.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class ProductRecodeActivity extends BaseActivity{
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.rl_product_seed)
    RelativeLayout rl_product_seed;
    @BindView(R.id.rl_product_pesticide)
    RelativeLayout rl_product_pesticide;
    @BindView(R.id.rl_product_fertilizer)
    RelativeLayout rl_product_fertilizer;
    private static final String cacheKey = "ProductRecodeActivity";
    private String id;
    private Map<String,Boolean> map = new HashMap<>();
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
        id = ZPreferenceUtils.getPrefString("产品备案","");
        Map<String,String> idMap = new HashMap<>();
        idMap.put("id",id);
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
        },1);
    }

    private void getMenu(String response) {
        Menu menu = new Gson().fromJson(response,Menu.class);
        dismissLoadingDialog();
        List<Menu.MenuListBean> list = menu.getMenuList();
        map.put("种子备案",false);
        map.put("农药备案",false);
        map.put("化肥备案",false);
        for (int i=0;i<list.size();i++){
            String name = list.get(i).getName();
            if (TextUtils.equals("种子备案",name)){
                map.put("种子备案",true);
            }else if (TextUtils.equals("农药备案",name)){
                map.put("农药备案",true);
            }else if (TextUtils.equals("化肥备案",name)){
                map.put("化肥备案",true);
            }
        }
        if (map.get("种子备案")){
            rl_product_seed.setVisibility(View.VISIBLE);
        }
        if (map.get("农药备案")){
            rl_product_pesticide.setVisibility(View.VISIBLE);
        }
        if (map.get("化肥备案")){
            rl_product_fertilizer.setVisibility(View.VISIBLE);
        }
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
