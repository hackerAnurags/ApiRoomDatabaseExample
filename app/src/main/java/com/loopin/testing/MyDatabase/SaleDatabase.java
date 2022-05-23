package com.loopin.testing.MyDatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.loopin.testing.Room.Dao.SaleDao.CustomDao;
import com.loopin.testing.Room.Dao.SaleDao.SaleDao;
import com.loopin.testing.Room.Dao.SaleDao.SaleResponseDao;
import com.loopin.testing.Room.Entity.SaleEntity.SaleEntity;
import com.loopin.testing.Room.Entity.SaleEntity.SaleResponseEntity;

@Database(entities = {SaleEntity.class, SaleResponseEntity.class},version = 1)
public abstract class SaleDatabase extends RoomDatabase {

    public abstract SaleDao saleDao();
    public abstract SaleResponseDao responseDao();
    public abstract CustomDao cusDao();
}
