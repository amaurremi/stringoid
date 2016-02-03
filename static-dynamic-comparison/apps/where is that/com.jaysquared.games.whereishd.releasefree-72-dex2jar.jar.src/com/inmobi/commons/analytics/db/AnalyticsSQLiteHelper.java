package com.inmobi.commons.analytics.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.inmobi.commons.internal.Log;

public class AnalyticsSQLiteHelper
  extends SQLiteOpenHelper
{
  public static final String ATTEMPT_DATA_BEGIN_TIME = "begintime";
  public static final String ATTEMPT_DATA_LEVEL_ID = "levelid";
  public static final String ATTEMPT_DATA_TOTAL_COUNT = "totalcount";
  public static final String ATTEMPT_DATA_TOTAL_TIME = "totaltime";
  public static final String CUSTOM_EVENT_EVENT_NAME = "eventname";
  public static final String DATABASE_NAME = "ltvp.db";
  public static final String EVENT_LIST_AM = "am";
  public static final String EVENT_LIST_EVENT_ID = "eventid";
  public static final String EVENT_LIST_SID = "sid";
  public static final String EVENT_LIST_SSTS = "ssts";
  public static final String EVENT_LIST_TS = "ts";
  public static final String EVENT_LIST_TYPE = "type";
  public static final String GENERAL_ID = "_id";
  public static final String LEVEL_BEGIN_LEVEL_ID = "levelid";
  public static final String LEVEL_BEGIN_LEVEL_NAME = "levelname";
  public static final String LEVEL_END_ATTEMPT_COUNT = "attemptcount";
  public static final String LEVEL_END_ATTEMPT_TIME = "attempttime";
  public static final String LEVEL_END_LEVEL_ID = "levelid";
  public static final String LEVEL_END_LEVEL_NAME = "levelname";
  public static final String LEVEL_END_LEVEL_STATUS = "levelstatus";
  public static final String LEVEL_END_TIME_TAKEN = "timetaken";
  public static final String OLD_DATABASE_NAME = "appengage.db";
  public static final String TABLE_ATTEMPT_DATA = "attemptdata";
  public static final String TABLE_CUSTOM_EVENT = "customevent";
  public static final String TABLE_EVENT_LIST = "eventlist";
  public static final String TABLE_LEVEL_BEGIN = "levelbegin";
  public static final String TABLE_LEVEL_END = "levelend";
  public static final String TABLE_SESSION_LIST = "sessionlist";
  public static final String TABLE_TRANSACTION = "transactiondetail";
  public static final String TRANSACTION_ID = "transactionId";
  public static final String TRANSACTION_ITEM_COUNT = "itemCount";
  public static final String TRANSACTION_ITEM_CURRENCY_CODE = "currencyCode";
  public static final String TRANSACTION_ITEM_DESCRIPTION = "itemDescription";
  public static final String TRANSACTION_ITEM_ITEM_PRICE = "itemPrice";
  public static final String TRANSACTION_ITEM_NAME = "itemName";
  public static final String TRANSACTION_ITEM_TYPE = "itemType";
  public static final String TRANSACTION_PRODUCT_ID = "productId";
  public static final String TRANSACTION_STATUS = "transactionStatus";
  
  public AnalyticsSQLiteHelper(Context paramContext)
  {
    super(paramContext, "ltvp.db", null, 1);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS eventlist (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, eventid INTEGER NOT NULL, type VARCHAR NOT NULL, sid VARCHAR NOT NULL, ts VARCHAR NOT NULL, ssts VARCHAR NOT NULL, am VARCHAR)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sessionlist (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, start INTEGER NOT NULL, end INTEGER NOT NULL)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS levelbegin (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, levelid VARCHAR, levelname VARCHAR)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS levelend (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, levelid VARCHAR, levelname VARCHAR, levelstatus VARCHAR, timetaken VARCHAR, attemptcount VARCHAR, attempttime VARCHAR)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS transactiondetail (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, itemName VARCHAR, itemType INTEGER, itemCount INTEGER, itemDescription VARCHAR, itemPrice REAL, currencyCode VARCHAR, productId VARCHAR, transactionId VARCHAR, transactionStatus INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS customevent (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, eventname VARCHAR)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS attemptdata (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, levelid VARCHAR, begintime VARCHAR NOT NULL, totalcount VARCHAR NOT NULL, totaltime VARCHAR NOT NULL)");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Log.debug(AnalyticsSQLiteHelper.class.getName(), "Upgrading database from version " + paramInt1 + " to " + paramInt2 + ", which will destroy all old data");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS eventlist");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS sessionlist");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS levelbegin");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS levelend");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS transactiondetail");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS customevent");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS attemptdata");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/db/AnalyticsSQLiteHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */