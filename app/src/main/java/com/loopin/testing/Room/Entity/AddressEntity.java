package com.loopin.testing.Room.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class AddressEntity {

    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "street")
    public String street;

    @ColumnInfo(name = "suit")
    public String suit;

    @ColumnInfo(name = "city")
    public String city;

    @ColumnInfo(name = "zipCode")
    public String zipCode;

    public AddressEntity(int uid, String street, String suit, String city, String zipCode) {
        this.uid = uid;
        this.street = street;
        this.suit = suit;
        this.city = city;
        this.zipCode = zipCode;
    }
}
