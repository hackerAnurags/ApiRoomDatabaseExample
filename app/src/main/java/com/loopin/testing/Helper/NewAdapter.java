package com.loopin.testing.Helper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loopin.testing.R;

import java.util.List;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.ViewHolder> {
    List<ResponseModel> list;
    List<AddressModel> addList;

    public NewAdapter(List<ResponseModel> list) {
        this.list = list;
        //this.addList = addList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_resource
                ,parent,false);
        return new NewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ResponseModel model = list.get(position);
        //AddressModel addressModel = addList.get(position);
        holder.id.setText(model.getId().toString());
        holder.name.setText(model.getName().toString());
        holder.email.setText(model.getEmail().toString());
        holder.userName.setText(model.getUsername().toString());
        holder.phone.setText(model.getPhone().toString());
        holder.website.setText(model.getWebsite().toString());
        holder.street.setText(model.getAddress().getStreet());
        holder.suit.setText(model.getAddress().getSuite().toString());
        holder.city.setText(model.getAddress().getCity());
        holder.zipCode.setText(model.getAddress().getZipcode());
        holder.lat.setText(model.getAddress().getGeo().getLat());
        holder.lng.setText(model.getAddress().getGeo().getLng());
        holder.cName.setText(model.getCompany().getName());
        holder.phrase.setText(model.getCompany().getCatchPhrase());
        holder.bs.setText(model.getCompany().getBs());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView id, name, userName, email,phone,website,street,suit,city,zipCode,lat,lng,cName,
        phrase,bs;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            userName = itemView.findViewById(R.id.userName);
            email = itemView.findViewById(R.id.emailAddress);
            phone = itemView.findViewById(R.id.phone);
            website = itemView.findViewById(R.id.website);
            street = itemView.findViewById(R.id.street);
            suit = itemView.findViewById(R.id.suite);
            city = itemView.findViewById(R.id.city);
            zipCode = itemView.findViewById(R.id.zipCode);
            lat = itemView.findViewById(R.id.lat);
            lng = itemView.findViewById(R.id.lng);
            cName = itemView.findViewById(R.id.cName);
            phrase = itemView.findViewById(R.id.phrase);
            bs = itemView.findViewById(R.id.bs);
        }
    }
}
