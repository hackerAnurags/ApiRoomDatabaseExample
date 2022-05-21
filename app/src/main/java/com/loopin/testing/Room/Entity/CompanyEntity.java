package com.loopin.testing.Room.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CompanyEntity {
    @PrimaryKey
    public int uid ;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "catchPhrase")
    public String catchPhrase;

    @ColumnInfo(name = "bs")
    public String bs;

    public CompanyEntity(int uid, String name, String catchPhrase, String bs) {
        this.uid = uid;
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }
}
