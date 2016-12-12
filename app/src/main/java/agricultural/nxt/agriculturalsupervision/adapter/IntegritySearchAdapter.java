package agricultural.nxt.agriculturalsupervision.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.entity.IntegritySearch;

/**
 * Created by huqiang on 2016/12/7 17:26.
 */

public class IntegritySearchAdapter extends BaseQuickAdapter<IntegritySearch,BaseViewHolder> {
    public IntegritySearchAdapter(List<IntegritySearch> data) {
        super(R.layout.item_integrity_search,data);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, IntegritySearch integritySearch) {
        viewHolder.setText(R.id.recodeNum,integritySearch.getRecodeNum()+"")
                .setText(R.id.unitNum,integritySearch.getUnitNum()+"")
                .setText(R.id.productName,integritySearch.getProductName())
                .setText(R.id.companyName,integritySearch.getCompanyName());
        if(viewHolder.getLayoutPosition()==2){
            viewHolder.setBackgroundRes(R.id.btn_handle,R.drawable.bg_integrity)
                        .setText(R.id.btn_handle,R.string.integrityhandle);
        }else {
            viewHolder.setBackgroundRes(R.id.btn_handle,R.drawable.bg_integrity_red)
                      .setText(R.id.btn_handle,R.string.integritynohandle);
        }
    }
}
