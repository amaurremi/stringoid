package com.ideashower.readitlater.db.operation;

import android.database.sqlite.SQLiteStatement;

public class x
{
  private final SQLiteStatement a;
  private int b = 1;
  
  private x(SQLiteStatement paramSQLiteStatement)
  {
    this.a = paramSQLiteStatement;
  }
  
  public x a()
  {
    this.b = 1;
    return this;
  }
  
  public x a(int paramInt)
  {
    SQLiteStatement localSQLiteStatement = this.a;
    int i = this.b;
    this.b = (i + 1);
    localSQLiteStatement.bindLong(i, paramInt);
    return this;
  }
  
  public x a(long paramLong)
  {
    SQLiteStatement localSQLiteStatement = this.a;
    int i = this.b;
    this.b = (i + 1);
    localSQLiteStatement.bindLong(i, paramLong);
    return this;
  }
  
  public x a(Long paramLong)
  {
    if (paramLong == null) {
      return b();
    }
    return a(paramLong.longValue());
  }
  
  public x a(String paramString)
  {
    if (paramString == null) {
      return b();
    }
    SQLiteStatement localSQLiteStatement = this.a;
    int i = this.b;
    this.b = (i + 1);
    localSQLiteStatement.bindString(i, paramString);
    return this;
  }
  
  public x b()
  {
    SQLiteStatement localSQLiteStatement = this.a;
    int i = this.b;
    this.b = (i + 1);
    localSQLiteStatement.bindNull(i);
    return this;
  }
  
  public void c()
  {
    this.a.execute();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */