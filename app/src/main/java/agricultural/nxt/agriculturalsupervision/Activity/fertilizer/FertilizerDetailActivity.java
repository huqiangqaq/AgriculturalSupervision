package agricultural.nxt.agriculturalsupervision.Activity.fertilizer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.FertilizerDetail;
import butterknife.BindView;

public class FertilizerDetailActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.vcfertilizename)
    TextView vcfertilizename;
    @BindView(R.id.vcnetcontent)
    TextView vcnetcontent;
    @BindView(R.id.vcproductunit)
    TextView vcproductunit;
    @BindView(R.id.vcdescription)
    TextView vcdescription;
    @BindView(R.id.vcgrantno)
    TextView vcgrantno;
    @BindView(R.id.vcplaceoforigin)
    TextView vcplaceoforigin;
    @BindView(R.id.vcinstructions)
    TextView vcinstructions;
    @BindView(R.id.vcstandards)
    TextView vcstandards;
    @BindView(R.id.vcbrand)
    TextView vcbrand;
    @BindView(R.id.vcspec)
    TextView vcspec;
    @BindView(R.id.vcuniquecode)
    TextView vcuniquecode;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("化肥备案详情");
        toolBar.setLeftButtonIcon(getResources().getDrawable(R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());
        getData();
    }
    private void getData() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        showLoadingDialog(R.string.loading);
        OkhttpHelper.Get(Constants.FERTILIZER_DETAIL + id, new OkhttpHelper.GetCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                dismissLoadingDialog();
                FertilizerDetail detail = new Gson().fromJson(response,FertilizerDetail.class);
                vcfertilizename.setText(detail.getVcfertilizename());
                vcnetcontent.setText(detail.getVcnetcontent());
                vcproductunit.setText(detail.getVcproductunit());
                vcdescription.setText(detail.getVcdescription());
                vcgrantno.setText(detail.getVcgrantno());
                vcplaceoforigin.setText(detail.getVcplaceoforigin());
                vcinstructions.setText(detail.getVcinstructions());
                vcstandards.setText(detail.getVcstandards());
                vcbrand.setText(detail.getVcbrand());
                vcspec.setText(null==detail.getVcspec()?"":detail.getVcspec());
                vcuniquecode.setText(null==detail.getVcuniquecode()?"":detail.getVcuniquecode());
            }

            @Override
            public void onFailed(String error, int tag) {

            }
        },1);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_fertilizer_detail;
    }
}
