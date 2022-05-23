package com.loopin.testing.Room.Dao.SaleDao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.loopin.testing.Room.Entity.SaleEntity.SaleResponseEntity;

@Dao
public interface SaleResponseDao {

    @Query("SELECT * FROM SaleResponseEntity")
    SaleResponseEntity getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertResponse(SaleResponseEntity entity);
}
