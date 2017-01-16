package agricultural.nxt.agriculturalsupervision.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.Widget.NiceSpinner;
import agricultural.nxt.agriculturalsupervision.adapter.AnnounceAdapter;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import butterknife.BindView;

public class AnnounceActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.line_shaixuan)
    LinearLayout ll_shaixuan;
    @BindView(R.id.sp_status)
    NiceSpinner sp_status;

    @BindView(R.id.fab)
    FloatingActionButton fab;
    private static final String TAG = "lzx";

    /**
     * 服务器端一共多少条数据
     */
    private static final int TOTAL_COUNTER = 64;

    /**
     * 每一页展示多少条数据
     */
    private static final int REQUEST_COUNT = 10;

    /**
     * 已经获取到多少条数据了
     */
    private static int mCurrentCounter = 0;

    private AnnounceAdapter mDataAdapter = null;

    private boolean isRefresh = false;
    private List<String> dataset = new LinkedList<>(Arrays.asList("全部", "有效", "无效"));

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("通知公告");
        toolBar.setLeftButtonIcon(ContextCompat.getDrawable(this, R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> {
            if (ll_shaixuan.getVisibility() == View.VISIBLE) {
                ll_shaixuan.setVisibility(View.GONE);

            } else {
                finish();
            }

        });
    }

    @Override
    protected int getLayoutResId() {
        return 0;
    }


}
