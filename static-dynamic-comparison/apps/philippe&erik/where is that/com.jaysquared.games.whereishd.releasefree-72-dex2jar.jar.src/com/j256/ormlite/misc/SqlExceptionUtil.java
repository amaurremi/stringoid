package com.j256.ormlite.misc;

import java.sql.SQLException;

public class SqlExceptionUtil
{
  public static SQLException create(String paramString, Throwable paramThrowable)
  {
    paramString = new SQLException(paramString);
    paramString.initCause(paramThrowable);
    return paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/misc/SqlExceptionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */