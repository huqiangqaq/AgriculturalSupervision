package agricultural.nxt.agriculturalsupervision.Activity.pesticideLib;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import java.util.Arrays;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.Widget.NiceSpinner;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.textinput)
    TextInputLayout registrationNo;
    @BindView(R.id.textinput2)
    TextInputLayout name;
    @BindView(R.id.textinput3)
    TextInputLayout companyName;
    @BindView(R.id.sp_toxicity)
    NiceSpinner sp_toxicity;
    @BindView(R.id.btn_search)
    Button btn_search;
    private String[] datasets = new String[]{"高毒","中等毒(原药剧毒)","剧毒","微毒","低毒(原药高毒)","中等毒(原药高毒)","中等毒","低毒"};
    private String toxicity;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("农药库管理");
        toolBar.setLeftButtonIcon(ContextCompat.getDrawable(this,R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());
        sp_toxicity.attachDataSource(Arrays.asList(datasets));
        registrationNo.setHint("填写登记证号");
        name.setHint("填写产品名称");
        companyName.setHint("填写生产厂家");
        sp_toxicity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toxicity = datasets[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_search;
    }

    @OnClick(R.id.btn_search) void Search(){
        Intent intent = new Intent();
        intent.putExtra("param1",registrationNo.getEditText().getText().toString().trim());
        intent.putExtra("param2",name.getEditText().getText().toString().trim());
        intent.putExtra("param3",companyName.getEditText().getText().toString().trim());
        intent.putExtra("param4",toxicity);
        this.setResult(RESULT_OK,intent);
        this.finish();
    }
}
