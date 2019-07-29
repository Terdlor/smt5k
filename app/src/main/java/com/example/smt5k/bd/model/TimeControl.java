package com.example.smt5k.bd.model;

import com.example.smt5k.constant.Colum;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable
public class TimeControl {

    @DatabaseField(generatedId = true, columnName = Colum.COLUM_ID)
    int id;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = Colum.COLUM_DAY)
    private DayControl dayControl;

    @DatabaseField(dataType = DataType.DATE, columnName = Colum.COLUM_DATE_START)
    public Date begin;
    @DatabaseField(dataType = DataType.DATE, columnName = Colum.COLUM_DATE_END)
    public Date end;
    @DatabaseField(columnName = Colum.COLUM_DELTA)
    public double delta;

    public TimeControl(){

    }

    public DayControl getDayControl() {
        return dayControl;
    }

    public void setDayControl(DayControl dayControl) {
        this.dayControl = dayControl;
    }
}
