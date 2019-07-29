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
public class MonthControl {

    @DatabaseField(generatedId = true, columnName = Colum.COLUM_ID)
    int id;
    @DatabaseField(columnName = Colum.COLUM_YEAR)
    public int year;
    @DatabaseField(columnName = Colum.COLUM_MONTH)
    public int month;
    @ForeignCollectionField(eager = true, columnName = Colum.COLUM_DAY)
    private List<DayControl> dayList;

    public MonthControl(){

    }

    public MonthControl(int pYaar, int pMonth){
        this.year = pYaar;
        this.month = pMonth;
    }

    public List<DayControl> getDayList() {
        return dayList;
    }

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
