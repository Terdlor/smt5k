package com.example.smt5k.bd.model;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

public class TimeTempDAO extends BaseDaoImpl<TimeTemp, Integer> {

    public TimeTempDAO(ConnectionSource connectionSource,
                          Class<TimeTemp> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<TimeTemp> getAll() throws SQLException{
        return this.queryForAll();
    }

    public  void clearTable() throws SQLException{
        TableUtils.clearTable(connectionSource, TimeTemp.class);
    }
}
