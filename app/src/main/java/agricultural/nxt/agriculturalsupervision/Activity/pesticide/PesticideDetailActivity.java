package agricultural.nxt.agriculturalsupervision.Activity.pesticide;

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
import agricultural.nxt.agriculturalsupervision.entity.PesticideDetail;
import butterknife.BindView;

public class PesticideDetailActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.vcpesticidename)
    TextView vcpesticidename;
    @BindView(R.id.vcproductunit)
    TextView vcproductunit;
    @BindView(R.id.vcdescription)
    TextView vcdescription;
    @BindView(R.id.vcgrantno)
    TextView vcgrantno;
    @BindView(R.id.vcinstructions)
    TextView vcinstructions;
    @BindView(R.id.vcstandards)
    TextView vcstandards;
    @BindView(R.id.icheckstatus)
    TextView icheckstatus;
    @BindView(R.id.vcorgname)
    TextView vcorgname;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("农药备案详情");
        toolBar.setLeftButtonIcon(ContextCompat.getDrawable(this,R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());
        getData();
    }
    private void getData() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        showLoadingDialog(R.string.loading);
        OkhttpHelper.Get(Constants.PESTICIDE_DETAIL + id, new OkhttpHelper.GetCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                dismissLoadingDialog();
                PesticideDetail detail = new Gson().fromJson(response,PesticideDetail.class);
                vcpesticidename.setText(detail.getVcpesticidename());
                vcproductunit.setText(detail.getVcproductunit());
                vcdescription.setText(detail.getVcdescription());
                vcgrantno.setText(detail.getVcgrantno());
                vcinstructions.setText(detail.getVcinstructions());
                vcstandards.setText(detail.getVcstandards());
                String status = detail.getIcheckstatus();
                if ("-1".equalsIgnoreCase(status)) {
                    icheckstatus.setText("待审核");
                } else if ("0".equalsIgnoreCase(status)) {
                    icheckstatus.setText("审核未通过");
                } else if ("1".equalsIgnoreCase(status)) {
                    icheckstatus.setText("审核通过");
                }
                vcorgname.setText(detail.getOwner().getVcorgname());


            }

            @Override
            public void onFailed(String error, int tag) {

            }
        },1);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_pesticide_detail;
    }
}
