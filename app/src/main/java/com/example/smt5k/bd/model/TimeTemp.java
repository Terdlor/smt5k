package com.example.smt5k.bd.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable
public class TimeTemp {

    @DatabaseField(generatedId = true)
    int id;
    @DatabaseField(dataType = DataType.DATE)
    public Date date;

    public TimeTemp(){

    }

    public TimeTemp(Date date){
        this.date = date;
    }
}
