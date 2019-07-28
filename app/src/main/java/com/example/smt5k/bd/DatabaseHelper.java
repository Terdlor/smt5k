package com.example.smt5k.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.smt5k.bd.model.TimeTemp;
import com.example.smt5k.bd.model.TimeTempDAO;
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

    TimeTempDAO timeTempDao;

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
        TableUtils.createTable(connectionSource, TimeTemp.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
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
}
