package com.loopin.testing.Adapter.SaleAdpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loopin.testing.Models.SaleModel.SaleDetailModel;
import com.loopin.testing.R;

import java.util.ArrayList;
import java.util.List;

public class SaleDetailAdapter extends RecyclerView.Adapter<SaleDetailAdapter.ViewHolder> {

    List<SaleDetailModel> model;
    Context context;
    List<SaleDetailModel> fullList;

    public SaleDetailAdapter(List<SaleDetailModel> model, Context context) {
        this.model = model;
        this.context = context;
        fullList = new ArrayList<>(model);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.new_sale_detail_report_resource,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SaleDetailModel model1 = model.get(position);
        holder.srNo.setText(String.valueOf(position+1));
        holder.shopName.setText(model1.getShopName());
        holder.brandName.setText(model1.getBrandName());
        holder.size.setText(String.valueOf(model1.getSize()));
        holder.liquorType.setText(model1.getType());
        holder.liquorCategory.setText(model1.getCategory());
        holder.quantity.setText(String.valueOf(model1.getQty()));
        holder.mrp.setText(model1.getMrp());
        holder.totalMrp.setText(String.valueOf(model1.getTotalMrpAmount()));
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView srNo,shopName,brandName,size,liquorType,liquorCategory,quantity,mrp,totalMrp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            srNo = itemView.findViewById(R.id.srNo);
            shopName = itemView.findViewById(R.id.shopName);
            brandName = itemView.findViewById(R.id.brandName);
            size = itemView.findViewById(R.id.size);
            liquorType = itemView.findViewById(R.id.liquorType);
            liquorCategory = itemView.findViewById(R.id.liquorCategory);
            quantity = itemView.findViewById(R.id.quantity);
            mrp = itemView.findViewById(R.id.mrp);
            totalMrp = itemView.findViewById(R.id.totalMrp);
        }
    }
}
