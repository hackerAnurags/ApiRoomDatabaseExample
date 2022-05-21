package com.loopin.testing.Room.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.loopin.testing.Room.Entity.AddressEntity;

import java.util.List;

@Dao
public interface AddressDao {

    @Query("SELECT * FROM AddressEntity")
    List<AddressEntity> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAddress(AddressEntity varargs);

    @Query("SELECT street FROM AddressEntity WHERE zipCode=:zCode")
    String getZipCode(String zCode);

    @Query("UPDATE AddressEntity SET street=:newStreet WHERE zipCode=:zCode")
    void updateStreet(String newStreet, String zCode);
}
