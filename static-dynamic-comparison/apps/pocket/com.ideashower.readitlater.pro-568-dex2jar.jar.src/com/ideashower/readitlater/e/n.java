package com.ideashower.readitlater.e;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class n
{
  private final String a;
  private final Integer[] b;
  private boolean c = false;
  private int d = 0;
  
  public n(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt)
  {
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT var_value FROM vars WHERE var_key = '" + paramString + "'", null);
    if (localCursor.moveToFirst()) {
      this.d = localCursor.getInt(0);
    }
    for (int i = 0;; i = 1)
    {
      localCursor.close();
      if (i != 0) {
        paramSQLiteDatabase.execSQL("INSERT INTO vars (var_key,var_value) VALUES (?,?)", new String[] { paramString, String.valueOf(paramInt) });
      }
      this.b = new Integer[1];
      this.a = ("UPDATE vars SET var_value = ?  WHERE var_key = '" + paramString + "'");
      return;
      this.d = paramInt;
    }
  }
  
  public int a()
  {
    this.d += 1;
    this.c = true;
    return this.d;
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    if (this.c)
    {
      this.b[0] = Integer.valueOf(this.d);
      paramSQLiteDatabase.execSQL(this.a, this.b);
      this.c = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/e/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */