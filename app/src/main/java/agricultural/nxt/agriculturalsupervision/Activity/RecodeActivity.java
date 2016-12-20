package agricultural.nxt.agriculturalsupervision.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import com.github.jdsjlzx.recyclerview.LRecyclerView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import butterknife.BindView;

public class RecodeActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.list)
    LRecyclerView mRecyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private static final String TAG = "lzx";

    /**服务器端一共多少条数据*/
    private static final int TOTAL_COUNTER = 64;

    /**每一页展示多少条数据*/
    private static final int REQUEST_COUNT = 10;

    /**已经获取到多少条数据了*/
    private static int mCurrentCounter = 0;
//    @BindView(R.id.sp_isTransgenic)
//    NiceSpinner sp_isTransgenic;
    private List<String> dataset = new LinkedList<>(Arrays.asList("非转基因", "转基因"));
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
//        sp_isTransgenic.attachDataSource(dataset);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_recode;
    }

    public static void actionStart(Context context){
        Intent intent = new Intent(context,RecodeActivity.class);
        context.startActivity(intent);

    }
}
