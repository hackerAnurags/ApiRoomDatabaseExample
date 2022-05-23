package com.loopin.testing.Room.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.loopin.testing.Room.Entity.ResponseEntity;

import java.util.List;

@Dao
public interface ResponseDao {


    @Query("SELECT * FROM ResponseEntity")
    List<ResponseEntity> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertResponse(ResponseEntity varargs);
}
