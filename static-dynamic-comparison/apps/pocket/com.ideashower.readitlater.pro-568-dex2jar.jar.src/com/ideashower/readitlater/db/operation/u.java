package com.ideashower.readitlater.db.operation;

import android.database.sqlite.SQLiteDatabase;

public class u
  extends j
{
  public u()
  {
    this.b = true;
  }
  
  protected void c_()
  {
    Object[] arrayOfObject = f(2);
    arrayOfObject[0] = Integer.valueOf(0);
    arrayOfObject[1] = Integer.valueOf(0);
    this.h.execSQL("UPDATE items SET offline_text = ?, offline_web = ? ", arrayOfObject);
    this.h.execSQL("DELETE FROM assets_users");
    this.h.execSQL("DELETE FROM assets");
    w();
    y();
    this.d = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */