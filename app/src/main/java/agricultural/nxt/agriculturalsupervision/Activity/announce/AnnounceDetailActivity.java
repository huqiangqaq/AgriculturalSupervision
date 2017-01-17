package agricultural.nxt.agriculturalsupervision.Activity.announce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.google.gson.Gson;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.AnnounceDetail;
import butterknife.BindView;

public class AnnounceDetailActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.vctitle)
    TextView vctitle;
    @BindView(R.id.vccontent)
    TextView vccontent;
    @BindView(R.id.ilevel)
    TextView ilevel;
    @BindView(R.id.ijuniorvisit)
    TextView ijuniorvisit;
    @BindView(R.id.dtcloseddate)
    TextView dtcloseddate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("通知公告详情");
        toolBar.setLeftButtonIcon(ContextCompat.getDrawable(this, R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());
        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        showLoadingDialog(R.string.loading);
        OkhttpHelper.Get(Constants.ANNOUNCEMENT_DETAIL + id, new OkhttpHelper.GetCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                dismissLoadingDialog();
                AnnounceDetail detail = new Gson().fromJson(response, AnnounceDetail.class);
                vctitle.setText(detail.getVctitle());
                vccontent.setText(detail.getVccontent());
                dtcloseddate.setText(detail.getDtcloseddate());
                if ("0".equals(detail.getIlevel())) {
                    ilevel.setText("一般");
                } else if ("1".equals(detail.getIlevel())) {
                    ilevel.setText("重要");
                } else if ("2".equals(detail.getIlevel())) {
                    ilevel.setText("紧急重要");
                }
                if ("0".equals(detail.getIjuniorvisit())){
                    ijuniorvisit.setText("不可见");
                }else if ("1".equals(detail.getIjuniorvisit())){
                    ijuniorvisit.setText("可见");
                }

            }

            @Override
            public void onFailed(String error, int tag) {

            }
        }, 1);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_announce_detail;
    }
}
