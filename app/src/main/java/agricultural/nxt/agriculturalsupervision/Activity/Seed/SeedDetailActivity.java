package agricultural.nxt.agriculturalsupervision.Activity.Seed;

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
import agricultural.nxt.agriculturalsupervision.entity.SeedDetail;
import butterknife.BindView;

public class SeedDetailActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.vcvarietyname)
    TextView vcvarietyname;
    @BindView(R.id.vccategory)
    TextView vccategory;
    @BindView(R.id.vcproductionunit)
    TextView vcproductionunit;
    @BindView(R.id.vcbusinesslicense)
    TextView vcbusinesslicense;
    @BindView(R.id.vcquarantineno)
    TextView vcquarantineno;
    @BindView(R.id.btransgene)
    TextView btransgene;
    @BindView(R.id.vcuniquecode)
    TextView vcuniquecode;
    @BindView(R.id.vcappraisal)
    TextView vcappraisal;
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
        OkhttpHelper.Get(Constants.SEED_RECODE_DETAIL + id, new OkhttpHelper.GetCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                dismissLoadingDialog();
                SeedDetail detail = new Gson().fromJson(response,SeedDetail.class);
                vcvarietyname.setText(detail.getVcvarietyname());
                vccategory.setText(detail.getVccategory());
                vcproductionunit.setText(detail.getVcproductionunit());
                vcbusinesslicense.setText(null==detail.getVcbusinesslicense()?"":detail.getVcbusinesslicense());
                vcquarantineno.setText(null==detail.getVcquarantineno()?"":detail.getVcquarantineno());
                btransgene.setText("0".equalsIgnoreCase(detail.getBtransgene())?"非转基因":"转基因");
                vcuniquecode.setText(null==detail.getVcuniquecode()?"":detail.getVcuniquecode());
                vcappraisal.setText(null==detail.getVcappraisal()?"":detail.getVcappraisal());

            }

            @Override
            public void onFailed(String error, int tag) {

            }
        },1);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_seed_detail;
    }
}
