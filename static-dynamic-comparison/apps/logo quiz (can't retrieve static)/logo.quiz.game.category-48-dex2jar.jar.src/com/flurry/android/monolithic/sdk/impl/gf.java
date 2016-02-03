package com.flurry.android.monolithic.sdk.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

public abstract class gf
  extends ge
{
  protected String c;
  
  public String a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = null;
    Cursor localCursor = this.a.getReadableDatabase().query(this.b, null, "objectsId='" + paramString2 + "'", null, null, null, "objectsId ASC, julianday(timestamp)");
    paramString2 = (String)localObject;
    int j;
    String str;
    if (localCursor.moveToFirst())
    {
      int i = localCursor.getColumnIndex("key");
      j = localCursor.getColumnIndex("value");
      int k = localCursor.getColumnIndex("collectionName");
      paramString2 = localCursor.getString(k);
      str = localCursor.getString(i);
      if ((TextUtils.isEmpty(paramString2)) || (!paramString2.equals(paramString3)) || (!str.equals(paramString1))) {
        break label159;
      }
      paramString2 = localCursor.getString(j);
    }
    for (;;)
    {
      localCursor.close();
      return paramString2;
      label159:
      if ((TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3)) && (str.equals(paramString1)))
      {
        paramString2 = localCursor.getString(j);
      }
      else
      {
        if (localCursor.moveToNext()) {
          break;
        }
        paramString2 = (String)localObject;
      }
    }
  }
  
  void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("objectsId", paramString3);
    localContentValues.put("objectsLocalId", paramString4);
    localContentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    localContentValues.put("collectionName", paramString5);
    localContentValues.put("key", paramString1);
    localContentValues.put("value", paramString2);
    localSQLiteDatabase.update(this.b, localContentValues, "primery_key_id='" + paramInt + "'", null);
  }
  
  public void a(gi paramgi)
  {
    ja.a(4, this.c, "--- Insert in " + this.b + " : ---");
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    String str1 = paramgi.c;
    String str2 = paramgi.d;
    String str3 = paramgi.e;
    String str4 = paramgi.a;
    paramgi = paramgi.b;
    localContentValues.put("objectsId", str1);
    localContentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    localContentValues.put("objectsLocalId", str2);
    localContentValues.put("collectionName", str3);
    localContentValues.put("key", str4);
    localContentValues.put("value", paramgi);
    localSQLiteDatabase.insert(this.b, null, localContentValues);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ja.a(4, this.c, "--- update item in " + this.b + ": ---");
    Cursor localCursor = this.a.getReadableDatabase().query(this.b, null, "objectsId='" + paramString3 + "'", null, null, null, "objectsId ASC, julianday(timestamp)");
    if (localCursor.moveToFirst())
    {
      i = localCursor.getColumnIndex("primery_key_id");
      int j = localCursor.getColumnIndex("key");
      int k = localCursor.getInt(i);
      if (localCursor.getString(j).equals(paramString1)) {
        a(k, paramString1, paramString2, paramString3, null, paramString4);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        a(new gi(paramString1, paramString2, paramString3, null, paramString4));
      }
      localCursor.close();
      return;
      if (localCursor.moveToNext()) {
        break;
      }
    }
  }
  
  public abstract hk b(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/gf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */