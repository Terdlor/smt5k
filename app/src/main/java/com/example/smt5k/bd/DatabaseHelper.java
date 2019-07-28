package com.example.smt5k.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.smt5k.bd.model.*;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "smt5k.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    //рудимент
    TimeTempDAO timeTempDao;

    MonthControlDAO monthControlDao;
    DayControlDAO dayControlDao;
    TimeControlDAO timeControlDao;

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, MonthControl.class);
            TableUtils.createTable(connectionSource, DayControl.class);
            TableUtils.createTable(connectionSource, TimeControl.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            //пока пусть будет рудимент
            TableUtils.dropTable(connectionSource, TimeTemp.class, true);
            TableUtils.createTable(connectionSource, TimeTemp.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//------------------------------------------------------------Singlton
    public TimeTempDAO getTimeTempDAO() throws SQLException{
        if(timeTempDao == null){
            timeTempDao = new TimeTempDAO(getConnectionSource(), TimeTemp.class);
        }
        return timeTempDao;
    }

    public MonthControlDAO getMonthControlDAO() throws SQLException{
        if(monthControlDao == null){
            monthControlDao = new MonthControlDAO(getConnectionSource(), MonthControl.class);
        }
        return monthControlDao;
    }

    public DayControlDAO getDayControlDAO() throws SQLException{
        if(dayControlDao == null){
            dayControlDao = new DayControlDAO(getConnectionSource(), DayControl.class);
        }
        return dayControlDao;
    }

    public TimeControlDAO getTimeControlDAO() throws SQLException{
        if(timeControlDao == null){
            timeControlDao = new TimeControlDAO(getConnectionSource(), TimeControl.class);
        }
        return timeControlDao;
    }
}
