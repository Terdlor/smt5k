package com.example.smt5k.bd.model;

import com.example.smt5k.bd.HelperFactory;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.SQLException;
import java.util.Collection;

@DatabaseTable
public class DayControl {

    @DatabaseField(generatedId = true)
    int id;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private MonthControl month;

    @DatabaseField
    int day;
    @DatabaseField
    double hour;

    public DayControl(){

    }

    @ForeignCollectionField(eager = true)
    private Collection<TimeControl> timeList;

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
