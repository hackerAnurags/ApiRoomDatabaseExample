package com.loopin.testing.Helper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loopin.testing.R;
import com.loopin.testing.Room.Entity.AddressEntity;
import com.loopin.testing.Room.Entity.CompanyEntity;
import com.loopin.testing.Room.Entity.GeoEntity;
import com.loopin.testing.Room.Entity.ResponseEntity;

import java.util.List;


public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomHolder> {
    List<ResponseEntity> response;
    List<AddressEntity> address;
    List<GeoEntity> geo;
    List<CompanyEntity> company;

    public RoomAdapter(List<ResponseEntity> response, List<AddressEntity> address, List<GeoEntity> geo, List<CompanyEntity> company) {
        this.response = response;
        this.address = address;
        this.geo = geo;
        this.company = company;
    }

    @NonNull
    @Override
    public RoomAdapter.RoomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_resource
                ,parent,false);
        return new RoomAdapter.RoomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomAdapter.RoomHolder holder, int position) {
        ResponseEntity resEntity = response.get(position);
        AddressEntity addEntity = address.get(position);
        GeoEntity geoEntity = geo.get(position);
        CompanyEntity comEntity = company.get(position);
        holder.id.setText(resEntity.id);
        holder.name.setText(resEntity.name);
        holder.userName.setText(resEntity.userName);
        holder.email.setText(resEntity.email);
        holder.phone.setText(resEntity.phone);
        holder.website.setText(resEntity.website);
        holder.street.setText(addEntity.street);
        holder.suit.setText(addEntity.suit);
        holder.city.setText(addEntity.city);
        holder.zipCode.setText(addEntity.zipCode);
        holder.lat.setText(geoEntity.lat);
        holder.lng.setText(geoEntity.lng);
        holder.cName.setText(comEntity.name);
        holder.phrase.setText(comEntity.catchPhrase);
        holder.bs.setText(comEntity.bs);
    }

    @Override
    public int getItemCount() {
        return response.size();
    }

    public class RoomHolder extends RecyclerView.ViewHolder {
        TextView id, name, userName, email,phone,website,street,suit,city,zipCode,lat,lng,cName,
                phrase,bs;
        public RoomHolder(@NonNull View itemView) {
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
