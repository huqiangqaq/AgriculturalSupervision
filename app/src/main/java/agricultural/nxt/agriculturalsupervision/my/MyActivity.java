package agricultural.nxt.agriculturalsupervision.my;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;

public class MyActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        OkhttpHelper.Get(Constants.MYINFO, new OkhttpHelper.GetCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
            }

            @Override
            public void onFailed(String error, int tag) {

            }
        },1);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_my;
    }

    public static void actionStart(Context mcontext){
        Intent intent =new Intent(mcontext,MyActivity.class);
        mcontext.startActivity(intent);
    }
}
