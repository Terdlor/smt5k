package com.example.smt5k.bd.model;

import com.example.smt5k.constant.Colum;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
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

    public MonthControl getMonth(int pYear, int pMonth) throws SQLException{
        QueryBuilder<MonthControl, Integer> queryBuilder = queryBuilder();
        queryBuilder.where().eq(Colum.COLUM_YEAR, pYear).and().eq(Colum.COLUM_MONTH, pMonth);
        PreparedQuery<MonthControl> preparedQuery = queryBuilder.prepare();
        List<MonthControl> goalList =query(preparedQuery);
        if(goalList.isEmpty()){
            return null;
        }
        return goalList.get(0);
    }
}
