package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class gc
  extends SQLiteOpenHelper
{
  public gc(Context paramContext, String paramString)
  {
    super(paramContext, "flurry_cache_DB_pending" + paramString, null, 1);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table pendingDataTable (primery_key_id integer primary key autoincrement, timestamp long not null, objectsId text not null, objectsLocalId text, collectionName text, key text not null, value text );");
    paramSQLiteDatabase.execSQL("create table serverDataTable (primery_key_id integer primary key autoincrement, timestamp long not null, objectsId text not null, objectsLocalId text, collectionName text, key text not null, value text );");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/gc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */