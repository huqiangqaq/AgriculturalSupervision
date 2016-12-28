package agricultural.nxt.agriculturalsupervision.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.entity.Integrity;

/**
 * Created by huqiang on 2016/12/7 17:26.
 */

public class IntegritySearchAdapter extends BaseQuickAdapter<Integrity.ListBean,BaseViewHolder> {
    public IntegritySearchAdapter(List<Integrity.ListBean> data) {
        super(R.layout.item_integrity_search,data);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, Integrity.ListBean integrity) {
        viewHolder.setText(R.id.dtarosedate,integrity.getDtarosedate())
                .setText(R.id.vcillegalprod,integrity.getVcillegalprod())
                .setText(R.id.iproducttype,integrity.getIproducttype())
                .setText(R.id.vcillegalcomp,integrity.getVcillegalcomp())
                .setText(R.id.ownerName,integrity.getOwnerName());
        if("1".equalsIgnoreCase(integrity.getIcheckstatus())){
            viewHolder.setBackgroundRes(R.id.btn_handle,R.drawable.bg_integrity)
                        .setText(R.id.btn_handle,R.string.integrityhandle);
        }else {
            viewHolder.setBackgroundRes(R.id.btn_handle,R.drawable.bg_integrity_red)
                      .setText(R.id.btn_handle,R.string.integritynohandle);
        }
    }
}
