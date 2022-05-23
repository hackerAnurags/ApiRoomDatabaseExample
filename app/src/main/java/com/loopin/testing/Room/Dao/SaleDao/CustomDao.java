package com.loopin.testing.Room.Dao.SaleDao;

import androidx.room.Dao;
import androidx.room.Query;

import com.loopin.testing.Room.Entity.SaleEntity.SaleEntity;

import java.util.List;

@Dao
public interface CustomDao {
    @Query("SELECT * FROM SaleEntity")
    List<SaleEntity> getAll();

    @Query("SELECT shopName From SaleEntity")
    List<String> allShop();

    @Query("SELECT * FROm SaleEntity WHERE id==1")
    SaleEntity getRow();
}
