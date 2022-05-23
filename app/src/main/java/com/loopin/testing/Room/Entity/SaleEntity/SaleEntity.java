package com.loopin.testing.Room.Entity.SaleEntity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SaleEntity {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "brandName")
    public String brandName;

    @ColumnInfo(name = "shopName")
    public String shopName;

    @ColumnInfo(name = "size")
    public Integer size;

    @ColumnInfo(name = "type")
    public String type;

    @ColumnInfo(name = "category")
    public String category;

    @ColumnInfo(name = "qty")
    public Integer qty;

    @ColumnInfo(name = "mrp")
    public String mrp;

    @ColumnInfo(name = "totalMrpAmount")
    public Integer totalMrpAmount;

    public SaleEntity(int id, String brandName, String shopName, Integer size, String type, String category, Integer qty, String mrp, Integer totalMrpAmount) {
        this.id = id;
        this.brandName = brandName;
        this.shopName = shopName;
        this.size = size;
        this.type = type;
        this.category = category;
        this.qty = qty;
        this.mrp = mrp;
        this.totalMrpAmount = totalMrpAmount;
    }
}
