package com.loopin.testing.Adapter.SaleAdpater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loopin.testing.Models.SaleModel.SaleDetailModel;
import com.loopin.testing.R;
import com.loopin.testing.Room.Entity.SaleEntity.SaleEntity;

import java.util.List;

public class SaleRoomAdapter extends RecyclerView.Adapter<SaleRoomAdapter.ViewHolder> {

    List<SaleEntity> list;

    public SaleRoomAdapter(List<SaleEntity> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.new_sale_detail_report_resource,parent,false);
        return new SaleRoomAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SaleEntity model = list.get(position);
        holder.srNo.setText(String.valueOf(position+1));
        holder.shopName.setText(model.shopName);
        holder.brandName.setText(model.brandName);
        holder.size.setText(String.valueOf(model.size));
        holder.liquorType.setText(model.type);
        holder.liquorCategory.setText(model.category);
        holder.quantity.setText(String.valueOf(model.qty));
        holder.mrp.setText(model.mrp);
        holder.totalMrp.setText(String.valueOf(model.totalMrpAmount));
    }

    @Override
    public int getItemCount() {
        return list.size();
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
