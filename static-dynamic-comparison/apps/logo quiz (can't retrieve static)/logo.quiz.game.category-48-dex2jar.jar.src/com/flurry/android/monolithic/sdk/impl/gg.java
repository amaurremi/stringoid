package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

public class gg
  extends gf
{
  public gg(Context paramContext, String paramString)
  {
    this.a = gd.a(paramContext, paramString);
    this.c = "PendingOperationsDB";
    this.b = "pendingDataTable";
  }
  
  public hk b(String paramString)
  {
    Cursor localCursor = this.a.getReadableDatabase().query(this.b, null, "objectsId='" + paramString + "'", null, null, null, "objectsId ASC, julianday(timestamp)");
    String str4;
    String str5;
    if (localCursor.moveToFirst())
    {
      int i = localCursor.getColumnIndex("objectsId");
      int j = localCursor.getColumnIndex("collectionName");
      int k = localCursor.getColumnIndex("key");
      int m = localCursor.getColumnIndex("value");
      String str1 = null;
      do
      {
        str4 = localCursor.getString(i);
        str5 = localCursor.getString(j);
        String str2 = localCursor.getString(k);
        String str3 = localCursor.getString(m);
        paramString = str1;
        if (str1 == null)
        {
          if (!TextUtils.isEmpty(str5)) {
            break;
          }
          paramString = new hk(str4);
        }
        paramString.a(str2, str3);
        str1 = paramString;
      } while (localCursor.moveToNext());
    }
    for (;;)
    {
      localCursor.close();
      return paramString;
      paramString = new hk(str4, str5);
      break;
      paramString = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/gg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */