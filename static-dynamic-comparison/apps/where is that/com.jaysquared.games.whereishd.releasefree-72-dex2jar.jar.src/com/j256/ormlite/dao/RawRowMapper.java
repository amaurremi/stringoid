package com.j256.ormlite.dao;

import java.sql.SQLException;

public abstract interface RawRowMapper<T>
{
  public abstract T mapRow(String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws SQLException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/dao/RawRowMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */