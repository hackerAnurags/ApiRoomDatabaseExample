package com.loopin.testing.Room.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.loopin.testing.Room.Entity.GeoEntity;
import com.loopin.testing.Room.Entity.ResponseEntity;

import java.util.List;
@Dao
public interface GeoDao {

    @Query("SELECT * FROM GeoEntity")
    List<GeoEntity> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertGeo(GeoEntity varargs);
}
