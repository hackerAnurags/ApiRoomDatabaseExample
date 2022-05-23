package com.loopin.testing.Room.Entity.SaleEntity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class SaleResponseEntity {
    @PrimaryKey
    @ColumnInfo(name = "totalAmout")
    public Integer totalAmout;

    @ColumnInfo(name = "totalQty")
    public Integer totalQty;

    @ColumnInfo(name = "msg")
    public String msg;

    @ColumnInfo(name = "error")
    public String error;

    public SaleResponseEntity(Integer totalAmout, Integer totalQty, String msg, String error) {
        this.totalAmout = totalAmout;
        this.totalQty = totalQty;
        this.msg = msg;
        this.error = error;
    }
}
