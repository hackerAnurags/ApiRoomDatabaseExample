package com.loopin.testing.Room.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class GeoEntity {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "lat")
    public String lat;

    @ColumnInfo(name = "lng")
    public String lng;

    public GeoEntity(int uid, String lat, String lng) {
        this.uid = uid;
        this.lat = lat;
        this.lng = lng;
    }
}
