package agricultural.nxt.agriculturalsupervision.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.nxt.zyl.util.ZToastUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import agricultural.nxt.agriculturalsupervision.Activity.Integrity.IntegrityDetailActivity;
import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.adapter.IntegritySearchAdapter;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.Integrity;
import butterknife.BindView;

public class IntegritySearchActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.et_search)
    EditText et_search;
    @BindView(R.id.iv_search)
    ImageView iv_search;
    @BindView(R.id.lv_result)
    RecyclerView lv_result;
    private List<Integrity.ListBean> results = new ArrayList<>();
    private IntegritySearchAdapter resultAdapter;
    private String vcillegalcomp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("查诚信");
        toolBar.setLeftButtonIcon(getResources().getDrawable(R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());

        //点击键盘搜索
        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    search();
                }
                return false;
            }
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_integrity_search;
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, IntegritySearchActivity.class);
        context.startActivity(intent);
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("pageNo", "1");
        map.put("pageSize", "30");
        map.put("vcillegalcomp", vcillegalcomp);
        OkhttpHelper.Post(Constants.INTEGRITY_SEARCH, map, new OkhttpHelper.PostCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                dismissLoadingDialog();
                final Integrity integrity = new Gson().fromJson(response, Integrity.class);
                results = integrity.getList();
                if (results == null || results.isEmpty()) {
                    ZToastUtils.showShort(IntegritySearchActivity.this, "没有查到相关记录！");
                    return;
                }
                lv_result.setLayoutManager(new LinearLayoutManager(IntegritySearchActivity.this));
                lv_result.addItemDecoration(new DividerItemDecoration(IntegritySearchActivity.this, DividerItemDecoration.VERTICAL));
                lv_result.setItemAnimator(new DefaultItemAnimator());
                resultAdapter = new IntegritySearchAdapter(results);
                resultAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
                lv_result.setAdapter(resultAdapter);
                lv_result.addOnItemTouchListener(new OnItemClickListener() {
                    @Override
                    public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int position) {
                        Intent intent = new Intent(IntegritySearchActivity.this, IntegrityDetailActivity.class);
                        intent.putExtra("id", results.get(position).getId());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailed(String error, int tag) {

            }

            @Override
            public void onProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

            }
        }, 1);
    }


    private void search() {
        showLoadingDialog(R.string.searching);
        vcillegalcomp = et_search.getText().toString().trim();
        if (TextUtils.isEmpty(vcillegalcomp)) {
            ZToastUtils.showShort(IntegritySearchActivity.this, "请先填写搜索内容");
            return;
        }
        initData();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
