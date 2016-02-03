package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

public class gh
  extends gf
{
  public gh(Context paramContext, String paramString)
  {
    this.a = gd.a(paramContext, paramString);
    this.c = "CacheServerOperationsDB";
    this.b = "serverDataTable";
  }
  
  public hk b(String paramString)
  {
    Cursor localCursor = this.a.getReadableDatabase().query(this.b, null, null, null, null, null, null);
    String str3;
    String str4;
    Object localObject1;
    if (localCursor.moveToFirst())
    {
      int i = localCursor.getColumnIndex("objectsId");
      int j = localCursor.getColumnIndex("objectsLocalId");
      int k = localCursor.getColumnIndex("collectionName");
      int m = localCursor.getColumnIndex("key");
      int n = localCursor.getColumnIndex("value");
      Object localObject2 = null;
      do
      {
        str3 = localCursor.getString(i);
        String str5 = localCursor.getString(j);
        str4 = localCursor.getString(k);
        String str1 = localCursor.getString(m);
        String str2 = localCursor.getString(n);
        if (!paramString.equals(str3))
        {
          localObject1 = localObject2;
          if (!paramString.equals(str5)) {}
        }
        else
        {
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            if (!TextUtils.isEmpty(str4)) {
              break;
            }
            localObject1 = new hk(str3);
          }
          ((hk)localObject1).a(str1, str2);
        }
        localObject2 = localObject1;
      } while (localCursor.moveToNext());
    }
    for (;;)
    {
      localCursor.close();
      return (hk)localObject1;
      localObject1 = new hk(str3, str4);
      break;
      localObject1 = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/gh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */