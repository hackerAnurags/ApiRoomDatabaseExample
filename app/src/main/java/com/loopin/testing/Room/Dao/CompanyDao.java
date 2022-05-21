package com.loopin.testing.Room.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.loopin.testing.Room.Entity.CompanyEntity;

import java.util.List;
@Dao
public interface CompanyDao {

    @Query("SELECT * FROM CompanyEntity")
    List<CompanyEntity> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCompany(CompanyEntity varargs);
}
