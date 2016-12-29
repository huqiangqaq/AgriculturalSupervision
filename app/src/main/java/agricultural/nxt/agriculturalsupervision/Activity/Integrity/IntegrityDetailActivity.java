package agricultural.nxt.agriculturalsupervision.Activity.Integrity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.IntegrityDetail;
import butterknife.BindView;

public class IntegrityDetailActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.dtarosedate)
    TextView dtarosedate;
    @BindView(R.id.vcillegalcomp)
    TextView vcillegalcomp;
    @BindView(R.id.iproducttype)
    TextView iproducttype;
    @BindView(R.id.vcillegalprod)
    TextView vcillegalprod;
    @BindView(R.id.vcdesc)
    TextView vcdesc;
    @BindView(R.id.vcpunishment)
    TextView vcpunishment;
    @BindView(R.id.checkerName)
    TextView checkerName;
    @BindView(R.id.dtcheckdate)
    TextView dtcheckdate;
    @BindView(R.id.icheckstatus)
    TextView icheckstatus;
    @BindView(R.id.remark)
    TextView remark;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("诚信详情");
        toolBar.setLeftButtonIcon(getResources().getDrawable(R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        showLoadingDialog(R.string.loading);
        OkhttpHelper.Get(Constants.INTEGRITY_DETAIL + id, new OkhttpHelper.GetCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                dismissLoadingDialog();
                IntegrityDetail detail = new Gson().fromJson(response,IntegrityDetail.class);
                dtarosedate.setText(detail.getDtarosedate());
                vcillegalcomp.setText(detail.getVcillegalcomp());
                if ("0".equalsIgnoreCase(detail.getIproducttype())){
                    iproducttype.setText("种子");
                }else if ("1".equalsIgnoreCase(detail.getIproducttype())){
                    iproducttype.setText("化肥");
                }else if ("2".equalsIgnoreCase(detail.getIproducttype())){
                    iproducttype.setText("农药");
                }
                vcillegalprod.setText(detail.getVcillegalprod());
                vcdesc.setText(detail.getVcdesc());
                vcpunishment.setText(detail.getVcpunishment());
                checkerName.setText(detail.getCheckerName());
                dtcheckdate.setText(detail.getDtcheckdate());
                icheckstatus.setText(detail.getIcheckstatus());
                remark.setText(detail.getRemarks2());
            }

            @Override
            public void onFailed(String error, int tag) {

            }
        },1);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_integrity_detail;
    }
}
