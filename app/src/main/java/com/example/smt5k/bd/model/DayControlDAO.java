package com.example.smt5k.bd.model;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class DayControlDAO extends BaseDaoImpl<DayControl, Integer> {

    public DayControlDAO(ConnectionSource connectionSource,
                           Class<DayControl> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<DayControl> getAll() throws SQLException{
        return this.queryForAll();
    }
}
