package agricultural.nxt.agriculturalsupervision.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.nxt.zyl.util.ZToastUtils;

import java.util.ArrayList;
import java.util.List;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.adapter.IntegritySearchAdapter;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.IntegritySearch;
import butterknife.BindView;

public class IntegritySearchActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.et_search)
    EditText et_search;
    @BindView(R.id.lv_result)
    RecyclerView lv_result;
    private List<IntegritySearch> results = new ArrayList<>();
    private IntegritySearchAdapter resultAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("查诚信");
        toolBar.setLeftButtonIcon(getResources().getDrawable(R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initData();
        lv_result.setLayoutManager(new LinearLayoutManager(this));
        lv_result.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        lv_result.setItemAnimator(new DefaultItemAnimator());
        resultAdapter = new IntegritySearchAdapter(results);
        resultAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        lv_result.setAdapter(resultAdapter);
        lv_result.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int position) {
                ZToastUtils.showShort(IntegritySearchActivity.this, ""+position);
            }
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_integrity_search;
    }

    public static void actionStart(Context context){
        Intent intent = new Intent(context,IntegritySearchActivity.class);
        context.startActivity(intent);
    }
    private void initData() {
        results.add(new IntegritySearch(1,20161209,"西瓜","江西省种子公司"));
        results.add(new IntegritySearch(2,20161209,"苹果","南昌县"));
        results.add(new IntegritySearch(3,20161209,"菠萝","江西省种子工程有限公司"));
        results.add(new IntegritySearch(3,20161209,"菠萝","江西省种子工程有限公司"));
        results.add(new IntegritySearch(4,20161209,"菠萝","江西省种子工程有限公司"));
    }

}