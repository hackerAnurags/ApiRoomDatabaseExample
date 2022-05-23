package com.loopin.testing.Room.Dao.SaleDao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.loopin.testing.Room.Entity.SaleEntity.SaleEntity;

import java.util.List;

@Dao
public interface SaleDao {

    @Query("SELECT * FROM SaleEntity")
    List<SaleEntity> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSaleData(SaleEntity saleEntity);
}
