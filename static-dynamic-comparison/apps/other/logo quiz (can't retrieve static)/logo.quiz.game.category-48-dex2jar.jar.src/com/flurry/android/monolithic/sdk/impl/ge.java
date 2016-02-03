package com.flurry.android.monolithic.sdk.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public abstract class ge
{
  protected gc a;
  protected String b = "";
  
  public boolean a(String paramString)
  {
    paramString = this.a.getReadableDatabase().query(this.b, null, "objectsId='" + paramString + "'", null, null, null, "objectsId ASC, julianday(timestamp)");
    if (paramString.moveToFirst()) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.close();
      return bool;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */