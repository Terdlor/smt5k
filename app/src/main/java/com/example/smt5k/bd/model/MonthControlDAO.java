package com.example.smt5k.bd.model;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class MonthControlDAO extends BaseDaoImpl<MonthControl, Integer> {

    public MonthControlDAO(ConnectionSource connectionSource,
                       Class<MonthControl> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<MonthControl> getAll() throws SQLException{
        return this.queryForAll();
    }
}
