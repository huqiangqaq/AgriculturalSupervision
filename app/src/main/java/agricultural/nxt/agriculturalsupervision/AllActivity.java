package agricultural.nxt.agriculturalsupervision;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.nxt.zyl.util.ZToastUtils;

import java.util.ArrayList;

import agricultural.nxt.agriculturalsupervision.Activity.ProductRecodeActivity;
import agricultural.nxt.agriculturalsupervision.Activity.ProductSoldActivity;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.Widget.MyGridView;
import agricultural.nxt.agriculturalsupervision.adapter.GridAdapter;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import butterknife.BindView;

public class AllActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.gridview)
    MyGridView gridView;
    private GridAdapter adapter;
    private ArrayList<String> menus = new ArrayList<>();
    private ArrayList<Integer> ids = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("全部");
        toolBar.setLeftButtonIcon(getResources().getDrawable(R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        menus = getIntent().getStringArrayListExtra("menu");
        ids = getIntent().getIntegerArrayListExtra("ids");
        adapter = new GridAdapter(this,menus,ids);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_all;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            StartAction(menus,position);
    }

    /**
     * 根据模块进行跳转
     * @param menus
     * @param position
     */
    private void StartAction(ArrayList<String> menus,int position) {
        String content = menus.get(position);
        if ("产品备案".equalsIgnoreCase(content)) {
            ProductRecodeActivity.actionStart(this);
        } else if ("农资产品销售".equalsIgnoreCase(content)){
            ProductSoldActivity.actionStart(this);
        } else if ("往来管理".equalsIgnoreCase(content)){
            ZToastUtils.showShort(this,content);
        }else if ("农资产品购进".equalsIgnoreCase(content)){
            ZToastUtils.showShort(this,content);
        }else if ("企业管理".equalsIgnoreCase(content)){
            ZToastUtils.showShort(this,content);
        }else if ("农药库管理".equalsIgnoreCase(content)){
            ZToastUtils.showShort(this,content);
        }else if ("电子处方".equalsIgnoreCase(content)){
            ZToastUtils.showShort(this,content);
        }else if ("销售员管理".equalsIgnoreCase(content)){
            ZToastUtils.showShort(this,content);
        }
    }
}
