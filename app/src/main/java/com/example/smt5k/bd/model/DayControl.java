package com.example.smt5k.bd.model;

import com.example.smt5k.bd.HelperFactory;
import com.example.smt5k.constant.Colum;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@DatabaseTable
public class DayControl {

    @DatabaseField(generatedId = true, columnName = Colum.COLUM_ID)
    int id;
    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = Colum.COLUM_MONTH)
    private MonthControl month;
    @DatabaseField(columnName = Colum.COLUM_DAY)
    public int day;
    @DatabaseField(columnName = Colum.COLUM_HOUR)
    public double hour;
    @ForeignCollectionField(eager = true, columnName = Colum.COLUM_TIME)
    private List<TimeControl> timeList;

    public DayControl(){

    }



    public List<TimeControl> getTimeList() {
        return timeList;
    }

    public void addTimeControl(TimeControl value) throws SQLException {
        value.setDayControl(this);
        HelperFactory.getHelper().getTimeControlDAO().create(value);
        timeList.add(value);
    }

    public void removeRole(TimeControl value) throws SQLException{
        timeList.remove(value);
        HelperFactory.getHelper().getTimeControlDAO().delete(value);
    }

    public MonthControl getMonthControl() {
        return month;
    }

    public void setMonthControl(MonthControl month) {
        this.month = month;
    }
}
