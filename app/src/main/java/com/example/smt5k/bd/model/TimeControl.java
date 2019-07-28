package com.example.smt5k.bd.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable
public class TimeControl {

    @DatabaseField(generatedId = true)
    int id;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private DayControl dayControl;

    @DatabaseField(dataType = DataType.DATE)
    Date begin;
    @DatabaseField(dataType = DataType.DATE)
    Date end;
    @DatabaseField
    double delta;

    public TimeControl(){

    }

    public DayControl getDayControl() {
        return dayControl;
    }

    public void setDayControl(DayControl dayControl) {
        this.dayControl = dayControl;
    }
}
