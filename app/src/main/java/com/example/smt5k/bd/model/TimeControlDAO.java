package com.example.smt5k.bd.model;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class TimeControlDAO extends BaseDaoImpl<TimeControl, Integer> {

    public TimeControlDAO(ConnectionSource connectionSource,
                         Class<TimeControl> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<TimeControl> getAll() throws SQLException{
        return this.queryForAll();
    }
}
