package com.loopin.testing.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.loopin.testing.MyDatabase.SaleDatabase;
import com.loopin.testing.R;
import com.loopin.testing.Room.Entity.SaleEntity.SaleEntity;

import java.util.List;

public class RoomQueryTest extends AppCompatActivity {
    ListView listView;
    List<String> list;
    SaleDatabase db;
    TextView brandName;
    SaleEntity entity;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_query_test);

        listView = findViewById(R.id.listView);
        brandName = findViewById(R.id.bName);

        db = Room.databaseBuilder(this,SaleDatabase.class,"Sale_Detail_Report").allowMainThreadQueries().build();
        list = db.cusDao().allShop();
        entity = db.cusDao().getRow();

        ArrayAdapter adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list);
        listView.setAdapter(adapter);
        brandName.setText(entity.totalMrpAmount.toString());


    }
}