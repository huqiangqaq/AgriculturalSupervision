package agricultural.nxt.agriculturalsupervision.Activity.pesticideLib;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.Lib;
import butterknife.BindView;

public class LibDetailActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.registrationNo)
    TextView registrationNo;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.companyName)
    TextView companyName;
    @BindView(R.id.toxicity)
    TextView toxicity;
    @BindView(R.id.compositionAndContent)
    TextView compositionAndContent;
    @BindView(R.id.validity)
    TextView validity;
    @BindView(R.id.formulation)
    TextView formulation;
    @BindView(R.id.registrationCropName)
    TextView registrationCropName;
    @BindView(R.id.preventObjectName)
    TextView preventObjectName;
    @BindView(R.id.dosage)
    TextView dosage;
    @BindView(R.id.applicationMethod)
    TextView applicationMethod;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("农药库详情");
        toolBar.setLeftButtonIcon(ContextCompat.getDrawable(this,R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());
        Lib.ListBean listBean = getIntent().getParcelableExtra("lib");
        registrationNo.setText(listBean.getRegistrationNo());
        name.setText(listBean.getName());
        companyName.setText(listBean.getCompanyName());
        toxicity.setText(listBean.getToxicity());
        compositionAndContent.setText(listBean.getCompositionAndContent());
        validity.setText(listBean.getValidity());
        formulation.setText(listBean.getFormulation());
        registrationCropName.setText(listBean.getRegistrationCropName());
        preventObjectName.setText(listBean.getPreventObjectName());
        dosage.setText(listBean.getDosage());
        applicationMethod.setText(listBean.getApplicationMethod());
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_lib_detail;
    }
}
