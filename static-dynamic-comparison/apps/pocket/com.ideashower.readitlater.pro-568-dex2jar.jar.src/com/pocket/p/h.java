package com.pocket.p;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class h
{
  public static int a(String paramString, String[] paramArrayOfString, SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    paramString = paramSQLiteDatabase.rawQuery("SELECT COUNT(1) FROM " + paramString, null);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    return i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/p/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */