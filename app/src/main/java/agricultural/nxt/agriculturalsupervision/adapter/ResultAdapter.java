package agricultural.nxt.agriculturalsupervision.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.entity.SeachResult;

/**
 * Created by huqiang on 2016/12/7 16:21.
 */

public class ResultAdapter extends BaseQuickAdapter<SeachResult, BaseViewHolder> {


    public ResultAdapter(List<SeachResult> data) {
        super(R.layout.item_product_sold_result, data);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, SeachResult seachResult) {
        viewHolder.setText(R.id.tv_id, seachResult.getId() + "")
                .setText(R.id.tv_name, seachResult.getName())
                .setText(R.id.tv_specie, seachResult.getSpecies())
                .setText(R.id.tv_unit, seachResult.getUnit());

    }
}
