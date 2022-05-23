package com.loopin.testing.MyDatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.loopin.testing.Room.Dao.AddressDao;
import com.loopin.testing.Room.Dao.CompanyDao;
import com.loopin.testing.Room.Dao.GeoDao;
import com.loopin.testing.Room.Dao.ResponseDao;
import com.loopin.testing.Room.Entity.AddressEntity;
import com.loopin.testing.Room.Entity.CompanyEntity;
import com.loopin.testing.Room.Entity.GeoEntity;
import com.loopin.testing.Room.Entity.ResponseEntity;


@Database(entities = {AddressEntity.class, CompanyEntity.class, ResponseEntity.class
, GeoEntity.class}, version = 4)
public abstract class MyRoomDB extends RoomDatabase {
    public abstract AddressDao addressDao();
    public abstract CompanyDao compDao();
    public abstract ResponseDao responseDao();
    public abstract GeoDao geoDao();

}
