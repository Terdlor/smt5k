package com.example.smt5k.bd.model;

import com.example.smt5k.bd.HelperFactory;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.SQLException;
import java.util.Collection;

@DatabaseTable
public class MonthControl {

    @DatabaseField(generatedId = true)
    int id;
    @DatabaseField
    int year;
    @DatabaseField
    int month;

    public MonthControl(){

    }

    @ForeignCollectionField(eager = true)
    private Collection<DayControl> dayList;

    public void addDayControl(DayControl value) throws SQLException {
        value.setMonthControl(this);
        HelperFactory.getHelper().getDayControlDAO().create(value);
        dayList.add(value);
    }

    public void removeDayControl(DayControl value) throws SQLException{
        dayList.remove(value);
        HelperFactory.getHelper().getDayControlDAO().delete(value);
    }
}
