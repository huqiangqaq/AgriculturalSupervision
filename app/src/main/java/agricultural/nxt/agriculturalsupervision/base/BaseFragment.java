package agricultural.nxt.agriculturalsupervision.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by huqiang on 2016/12/16 9:00.
 */

public abstract class BaseFragment extends Fragment {
    private View mView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView!=null){
            ViewGroup parent = (ViewGroup) mView.getParent();
            if (parent!=null){
                parent.removeView(mView);
            }
        }else {
            mView = inflater.inflate(getLayoutId(),container,false);
        }
        ButterKnife.bind(mView);
        return mView;
    }

    /**
     * 初始化界面
     *
     * @since 1.0
     */
    protected abstract void initView(View view);

    /**
     * @return 布局文件资源ID
     * @since 1.0
     */
    protected abstract int getLayoutId();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
