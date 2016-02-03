package com.google.android.apps.analytics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Random;

class PersistentHitStore
  implements HitStore
{
  private static final String ACCOUNT_ID = "account_id";
  private static final String ACTION = "action";
  private static final String CATEGORY = "category";
  private static final String CREATE_CUSTOM_VARIABLES_TABLE;
  private static final String CREATE_CUSTOM_VAR_VISITOR_CACHE_TABLE;
  private static final String CREATE_EVENTS_TABLE = "CREATE TABLE events (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[] { "event_id" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "user_id" }) + String.format(" '%s' CHAR(256) NOT NULL,", new Object[] { "account_id" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "random_val" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "timestamp_first" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "timestamp_previous" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "timestamp_current" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "visits" }) + String.format(" '%s' CHAR(256) NOT NULL,", new Object[] { "category" }) + String.format(" '%s' CHAR(256) NOT NULL,", new Object[] { "action" }) + String.format(" '%s' CHAR(256), ", new Object[] { "label" }) + String.format(" '%s' INTEGER,", new Object[] { "value" }) + String.format(" '%s' INTEGER,", new Object[] { "screen_width" }) + String.format(" '%s' INTEGER);", new Object[] { "screen_height" });
  private static final String CREATE_HITS_TABLE = "CREATE TABLE IF NOT EXISTS hits (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[] { "hit_id" }) + String.format(" '%s' TEXT NOT NULL,", new Object[] { "hit_string" }) + String.format(" '%s' INTEGER NOT NULL);", new Object[] { "hit_time" });
  private static final String CREATE_INSTALL_REFERRER_TABLE = "CREATE TABLE install_referrer (referrer TEXT PRIMARY KEY NOT NULL);";
  private static final String CREATE_ITEM_EVENTS_TABLE;
  private static final String CREATE_OLD_CUSTOM_VAR_CACHE_TABLE;
  private static final String CREATE_REFERRER_TABLE = "CREATE TABLE IF NOT EXISTS referrer (referrer TEXT PRIMARY KEY NOT NULL,timestamp_referrer INTEGER NOT NULL,referrer_visit INTEGER NOT NULL DEFAULT 1,referrer_index INTEGER NOT NULL DEFAULT 1);";
  private static final String CREATE_SESSION_TABLE = "CREATE TABLE IF NOT EXISTS session (" + String.format(" '%s' INTEGER PRIMARY KEY,", new Object[] { "timestamp_first" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "timestamp_previous" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "timestamp_current" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "visits" }) + String.format(" '%s' INTEGER NOT NULL);", new Object[] { "store_id" });
  private static final String CREATE_TRANSACTION_EVENTS_TABLE;
  private static final String CUSTOMVAR_ID = "cv_id";
  private static final String CUSTOMVAR_INDEX = "cv_index";
  private static final String CUSTOMVAR_NAME = "cv_name";
  private static final String CUSTOMVAR_SCOPE = "cv_scope";
  private static final String CUSTOMVAR_VALUE = "cv_value";
  private static final String CUSTOM_VARIABLE_COLUMN_TYPE = "CHAR(64) NOT NULL";
  static final String CUSTOM_VAR_VISITOR_CACHE_NAME = "custom_var_visitor_cache";
  private static final String DATABASE_NAME = "google_analytics.db";
  private static final int DATABASE_VERSION = 6;
  private static final String EVENT_ID = "event_id";
  private static final String HIT_ID = "hit_id";
  private static final String HIT_STRING = "hit_string";
  private static final String HIT_TIMESTAMP = "hit_time";
  private static final String ITEM_CATEGORY = "item_category";
  private static final String ITEM_COUNT = "item_count";
  private static final String ITEM_ID = "item_id";
  private static final String ITEM_NAME = "item_name";
  private static final String ITEM_PRICE = "item_price";
  private static final String ITEM_SKU = "item_sku";
  private static final String LABEL = "label";
  private static final int MAX_HITS = 1000;
  private static final String OLD_CUSTOM_VAR_CACHE_NAME = "custom_var_cache";
  private static final String ORDER_ID = "order_id";
  private static final String RANDOM_VAL = "random_val";
  static final String REFERRER = "referrer";
  static final String REFERRER_COLUMN = "referrer";
  static final String REFERRER_INDEX = "referrer_index";
  static final String REFERRER_VISIT = "referrer_visit";
  private static final String SCREEN_HEIGHT = "screen_height";
  private static final String SCREEN_WIDTH = "screen_width";
  private static final String SHIPPING_COST = "tran_shippingcost";
  private static final String STORE_ID = "store_id";
  private static final String STORE_NAME = "tran_storename";
  private static final String TIMESTAMP_CURRENT = "timestamp_current";
  private static final String TIMESTAMP_FIRST = "timestamp_first";
  private static final String TIMESTAMP_PREVIOUS = "timestamp_previous";
  static final String TIMESTAMP_REFERRER = "timestamp_referrer";
  private static final String TOTAL_COST = "tran_totalcost";
  private static final String TOTAL_TAX = "tran_totaltax";
  private static final String TRANSACTION_ID = "tran_id";
  private static final String USER_ID = "user_id";
  private static final String VALUE = "value";
  private static final String VISITS = "visits";
  private boolean anonymizeIp;
  private DataBaseHelper databaseHelper;
  private volatile int numStoredHits;
  private Random random = new Random();
  private int sampleRate = 100;
  private boolean sessionStarted;
  private int storeId;
  private long timestampCurrent;
  private long timestampFirst;
  private long timestampPrevious;
  private boolean useStoredVisitorVars;
  private CustomVariableBuffer visitorCVCache;
  private int visits;
  
  static
  {
    CREATE_CUSTOM_VARIABLES_TABLE = "CREATE TABLE custom_variables (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[] { "cv_id" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "event_id" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "cv_index" }) + String.format(" '%s' CHAR(64) NOT NULL,", new Object[] { "cv_name" }) + String.format(" '%s' CHAR(64) NOT NULL,", new Object[] { "cv_value" }) + String.format(" '%s' INTEGER NOT NULL);", new Object[] { "cv_scope" });
    CREATE_OLD_CUSTOM_VAR_CACHE_TABLE = "CREATE TABLE IF NOT EXISTS custom_var_cache (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[] { "cv_id" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "event_id" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "cv_index" }) + String.format(" '%s' CHAR(64) NOT NULL,", new Object[] { "cv_name" }) + String.format(" '%s' CHAR(64) NOT NULL,", new Object[] { "cv_value" }) + String.format(" '%s' INTEGER NOT NULL);", new Object[] { "cv_scope" });
    CREATE_CUSTOM_VAR_VISITOR_CACHE_TABLE = "CREATE TABLE IF NOT EXISTS custom_var_visitor_cache (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[] { "cv_id" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "cv_index" }) + String.format(" '%s' %s,", new Object[] { "cv_name", "CHAR(64) NOT NULL" }) + String.format(" '%s' %s);", new Object[] { "cv_value", "CHAR(64) NOT NULL" });
    CREATE_TRANSACTION_EVENTS_TABLE = "CREATE TABLE transaction_events (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[] { "tran_id" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "event_id" }) + String.format(" '%s' TEXT NOT NULL,", new Object[] { "order_id" }) + String.format(" '%s' TEXT,", new Object[] { "tran_storename" }) + String.format(" '%s' TEXT NOT NULL,", new Object[] { "tran_totalcost" }) + String.format(" '%s' TEXT,", new Object[] { "tran_totaltax" }) + String.format(" '%s' TEXT);", new Object[] { "tran_shippingcost" });
    CREATE_ITEM_EVENTS_TABLE = "CREATE TABLE item_events (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[] { "item_id" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "event_id" }) + String.format(" '%s' TEXT NOT NULL,", new Object[] { "order_id" }) + String.format(" '%s' TEXT NOT NULL,", new Object[] { "item_sku" }) + String.format(" '%s' TEXT,", new Object[] { "item_name" }) + String.format(" '%s' TEXT,", new Object[] { "item_category" }) + String.format(" '%s' TEXT NOT NULL,", new Object[] { "item_price" }) + String.format(" '%s' TEXT NOT NULL);", new Object[] { "item_count" });
  }
  
  PersistentHitStore(Context paramContext)
  {
    this(paramContext, "google_analytics.db", 6);
  }
  
  PersistentHitStore(Context paramContext, String paramString)
  {
    this(paramContext, paramString, 6);
  }
  
  PersistentHitStore(Context paramContext, String paramString, int paramInt)
  {
    this.databaseHelper = new DataBaseHelper(paramContext, paramString, paramInt, this);
    loadExistingSession();
    this.visitorCVCache = getVisitorVarBuffer();
  }
  
  PersistentHitStore(DataBaseHelper paramDataBaseHelper)
  {
    this.databaseHelper = paramDataBaseHelper;
    loadExistingSession();
    this.visitorCVCache = getVisitorVarBuffer();
  }
  
  private static boolean endTransaction(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.endTransaction();
      return true;
    }
    catch (SQLiteException paramSQLiteDatabase)
    {
      Log.e("GoogleAnalyticsTracker", "exception ending transaction:" + paramSQLiteDatabase.toString());
    }
    return false;
  }
  
  static String formatReferrer(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    label37:
    label52:
    int k;
    if (paramString.contains("="))
    {
      localObject = Utils.parseURLParameters(paramString);
      if (((Map)localObject).get("utm_campaign") == null) {
        break label138;
      }
      i = 1;
      if (((Map)localObject).get("utm_medium") == null) {
        break label143;
      }
      j = 1;
      if (((Map)localObject).get("utm_source") == null) {
        break label148;
      }
      k = 1;
      label67:
      if (((Map)localObject).get("gclid") == null) {
        break label153;
      }
    }
    label138:
    label143:
    label148:
    label153:
    for (int m = 1;; m = 0)
    {
      if ((m != 0) || ((i != 0) && (j != 0) && (k != 0))) {
        break label159;
      }
      Log.w("GoogleAnalyticsTracker", "Badly formatted referrer missing campaign, medium and source or click ID");
      return null;
      if (paramString.contains("%3D")) {
        try
        {
          paramString = URLDecoder.decode(paramString, "UTF-8");
        }
        catch (UnsupportedEncodingException paramString)
        {
          return null;
        }
      }
      return null;
      i = 0;
      break label37;
      j = 0;
      break label52;
      k = 0;
      break label67;
    }
    label159:
    paramString = new String[7][];
    paramString[0] = { "utmcid", (String)((Map)localObject).get("utm_id") };
    paramString[1] = { "utmcsr", (String)((Map)localObject).get("utm_source") };
    paramString[2] = { "utmgclid", (String)((Map)localObject).get("gclid") };
    paramString[3] = { "utmccn", (String)((Map)localObject).get("utm_campaign") };
    paramString[4] = { "utmcmd", (String)((Map)localObject).get("utm_medium") };
    paramString[5] = { "utmctr", (String)((Map)localObject).get("utm_term") };
    paramString[6] = { "utmcct", (String)((Map)localObject).get("utm_content") };
    Object localObject = new StringBuilder();
    int j = 0;
    int i = 1;
    if (j < paramString.length)
    {
      k = i;
      String str;
      if (paramString[j][1] != null)
      {
        str = paramString[j][1].replace("+", "%20").replace(" ", "%20");
        if (i == 0) {
          break label462;
        }
        i = 0;
      }
      for (;;)
      {
        ((StringBuilder)localObject).append(paramString[j][0]).append("=").append(str);
        k = i;
        j += 1;
        i = k;
        break;
        label462:
        ((StringBuilder)localObject).append("|");
      }
    }
    return ((StringBuilder)localObject).toString();
  }
  
  private Referrer getAndUpdateReferrer(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = readCurrentReferrer(paramSQLiteDatabase);
    if (localObject == null) {}
    int i;
    ContentValues localContentValues;
    do
    {
      return null;
      if (((Referrer)localObject).getTimeStamp() != 0L) {
        return (Referrer)localObject;
      }
      i = ((Referrer)localObject).getIndex();
      localObject = ((Referrer)localObject).getReferrerString();
      localContentValues = new ContentValues();
      localContentValues.put("referrer", (String)localObject);
      localContentValues.put("timestamp_referrer", Long.valueOf(this.timestampCurrent));
      localContentValues.put("referrer_visit", Integer.valueOf(this.visits));
      localContentValues.put("referrer_index", Integer.valueOf(i));
    } while (!setReferrerDatabase(paramSQLiteDatabase, localContentValues));
    return new Referrer((String)localObject, this.timestampCurrent, this.visits, i);
  }
  
  private void putEvent(Event paramEvent, SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (!paramEvent.isSessionInitialized())
    {
      paramEvent.setRandomVal(this.random.nextInt(Integer.MAX_VALUE));
      paramEvent.setTimestampFirst((int)this.timestampFirst);
      paramEvent.setTimestampPrevious((int)this.timestampPrevious);
      paramEvent.setTimestampCurrent((int)this.timestampCurrent);
      paramEvent.setVisits(this.visits);
    }
    paramEvent.setAnonymizeIp(this.anonymizeIp);
    if (paramEvent.getUserId() == -1) {
      paramEvent.setUserId(this.storeId);
    }
    putCustomVariables(paramEvent, paramSQLiteDatabase);
    Referrer localReferrer = getAndUpdateReferrer(paramSQLiteDatabase);
    String[] arrayOfString = paramEvent.accountId.split(",");
    if (arrayOfString.length == 1) {
      writeEventToDatabase(paramEvent, localReferrer, paramSQLiteDatabase, paramBoolean);
    }
    for (;;)
    {
      return;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        writeEventToDatabase(new Event(paramEvent, arrayOfString[i]), localReferrer, paramSQLiteDatabase, paramBoolean);
        i += 1;
      }
    }
  }
  
  private boolean setReferrerDatabase(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues)
  {
    try
    {
      paramSQLiteDatabase.beginTransaction();
      paramSQLiteDatabase.delete("referrer", null, null);
      paramSQLiteDatabase.insert("referrer", null, paramContentValues);
      paramSQLiteDatabase.setTransactionSuccessful();
      if ((!paramSQLiteDatabase.inTransaction()) || (endTransaction(paramSQLiteDatabase))) {
        break label87;
      }
    }
    catch (SQLiteException paramContentValues)
    {
      do
      {
        Log.e("GoogleAnalyticsTracker", paramContentValues.toString());
      } while ((!paramSQLiteDatabase.inTransaction()) || (endTransaction(paramSQLiteDatabase)));
      return false;
    }
    finally
    {
      do
      {
        if (!paramSQLiteDatabase.inTransaction()) {
          break;
        }
      } while (!endTransaction(paramSQLiteDatabase));
    }
    return false;
    label87:
    return true;
  }
  
  public void clearReferrer()
  {
    try
    {
      this.databaseHelper.getWritableDatabase().delete("referrer", null, null);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.e("GoogleAnalyticsTracker", localSQLiteException.toString());
    }
  }
  
  public void deleteHit(long paramLong)
  {
    try
    {
      this.numStoredHits -= this.databaseHelper.getWritableDatabase().delete("hits", "hit_id = ?", new String[] { Long.toString(paramLong) });
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        Log.e("GoogleAnalyticsTracker", localSQLiteException.toString());
      }
    }
    finally {}
  }
  
  /* Error */
  CustomVariableBuffer getCustomVariables(long paramLong, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: new 562	com/google/android/apps/analytics/CustomVariableBuffer
    //   3: dup
    //   4: invokespecial 563	com/google/android/apps/analytics/CustomVariableBuffer:<init>	()V
    //   7: astore 6
    //   9: aload_3
    //   10: ldc_w 565
    //   13: aconst_null
    //   14: ldc_w 567
    //   17: iconst_1
    //   18: anewarray 193	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: lload_1
    //   24: invokestatic 558	java/lang/Long:toString	(J)Ljava/lang/String;
    //   27: aastore
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: invokevirtual 571	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore 4
    //   36: aload 4
    //   38: astore_3
    //   39: aload 4
    //   41: invokeinterface 576 1 0
    //   46: ifeq +117 -> 163
    //   49: aload 4
    //   51: astore_3
    //   52: aload 6
    //   54: new 578	com/google/android/apps/analytics/CustomVariable
    //   57: dup
    //   58: aload 4
    //   60: aload 4
    //   62: ldc 39
    //   64: invokeinterface 582 2 0
    //   69: invokeinterface 585 2 0
    //   74: aload 4
    //   76: aload 4
    //   78: ldc 42
    //   80: invokeinterface 582 2 0
    //   85: invokeinterface 589 2 0
    //   90: aload 4
    //   92: aload 4
    //   94: ldc 48
    //   96: invokeinterface 582 2 0
    //   101: invokeinterface 589 2 0
    //   106: aload 4
    //   108: aload 4
    //   110: ldc 45
    //   112: invokeinterface 582 2 0
    //   117: invokeinterface 585 2 0
    //   122: invokespecial 592	com/google/android/apps/analytics/CustomVariable:<init>	(ILjava/lang/String;Ljava/lang/String;I)V
    //   125: invokevirtual 596	com/google/android/apps/analytics/CustomVariableBuffer:setCustomVariable	(Lcom/google/android/apps/analytics/CustomVariable;)V
    //   128: goto -92 -> 36
    //   131: astore 5
    //   133: aload 4
    //   135: astore_3
    //   136: ldc_w 317
    //   139: aload 5
    //   141: invokevirtual 320	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   144: invokestatic 326	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   147: pop
    //   148: aload 4
    //   150: ifnull +10 -> 160
    //   153: aload 4
    //   155: invokeinterface 599 1 0
    //   160: aload 6
    //   162: areturn
    //   163: aload 4
    //   165: ifnull -5 -> 160
    //   168: aload 4
    //   170: invokeinterface 599 1 0
    //   175: aload 6
    //   177: areturn
    //   178: astore 4
    //   180: aconst_null
    //   181: astore_3
    //   182: aload_3
    //   183: ifnull +9 -> 192
    //   186: aload_3
    //   187: invokeinterface 599 1 0
    //   192: aload 4
    //   194: athrow
    //   195: astore 4
    //   197: goto -15 -> 182
    //   200: astore 5
    //   202: aconst_null
    //   203: astore 4
    //   205: goto -72 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	PersistentHitStore
    //   0	208	1	paramLong	long
    //   0	208	3	paramSQLiteDatabase	SQLiteDatabase
    //   34	135	4	localCursor	Cursor
    //   178	15	4	localObject1	Object
    //   195	1	4	localObject2	Object
    //   203	1	4	localObject3	Object
    //   131	9	5	localSQLiteException1	SQLiteException
    //   200	1	5	localSQLiteException2	SQLiteException
    //   7	169	6	localCustomVariableBuffer	CustomVariableBuffer
    // Exception table:
    //   from	to	target	type
    //   39	49	131	android/database/sqlite/SQLiteException
    //   52	128	131	android/database/sqlite/SQLiteException
    //   9	36	178	finally
    //   39	49	195	finally
    //   52	128	195	finally
    //   136	148	195	finally
    //   9	36	200	android/database/sqlite/SQLiteException
  }
  
  DataBaseHelper getDatabaseHelper()
  {
    return this.databaseHelper;
  }
  
  /* Error */
  Item getItem(long paramLong, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_3
    //   1: ldc_w 605
    //   4: aconst_null
    //   5: ldc_w 567
    //   8: iconst_1
    //   9: anewarray 193	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: lload_1
    //   15: invokestatic 558	java/lang/Long:toString	(J)Ljava/lang/String;
    //   18: aastore
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: invokevirtual 571	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore_3
    //   26: aload_3
    //   27: invokeinterface 608 1 0
    //   32: ifeq +118 -> 150
    //   35: new 610	com/google/android/apps/analytics/Item$Builder
    //   38: dup
    //   39: aload_3
    //   40: aload_3
    //   41: ldc 101
    //   43: invokeinterface 582 2 0
    //   48: invokeinterface 589 2 0
    //   53: aload_3
    //   54: aload_3
    //   55: ldc 90
    //   57: invokeinterface 582 2 0
    //   62: invokeinterface 589 2 0
    //   67: aload_3
    //   68: aload_3
    //   69: ldc 87
    //   71: invokeinterface 582 2 0
    //   76: invokeinterface 614 2 0
    //   81: aload_3
    //   82: aload_3
    //   83: ldc 78
    //   85: invokeinterface 582 2 0
    //   90: invokeinterface 618 2 0
    //   95: invokespecial 621	com/google/android/apps/analytics/Item$Builder:<init>	(Ljava/lang/String;Ljava/lang/String;DJ)V
    //   98: aload_3
    //   99: aload_3
    //   100: ldc 84
    //   102: invokeinterface 582 2 0
    //   107: invokeinterface 589 2 0
    //   112: invokevirtual 625	com/google/android/apps/analytics/Item$Builder:setItemName	(Ljava/lang/String;)Lcom/google/android/apps/analytics/Item$Builder;
    //   115: aload_3
    //   116: aload_3
    //   117: ldc 75
    //   119: invokeinterface 582 2 0
    //   124: invokeinterface 589 2 0
    //   129: invokevirtual 628	com/google/android/apps/analytics/Item$Builder:setItemCategory	(Ljava/lang/String;)Lcom/google/android/apps/analytics/Item$Builder;
    //   132: invokevirtual 632	com/google/android/apps/analytics/Item$Builder:build	()Lcom/google/android/apps/analytics/Item;
    //   135: astore 4
    //   137: aload_3
    //   138: ifnull +9 -> 147
    //   141: aload_3
    //   142: invokeinterface 599 1 0
    //   147: aload 4
    //   149: areturn
    //   150: aload_3
    //   151: ifnull +9 -> 160
    //   154: aload_3
    //   155: invokeinterface 599 1 0
    //   160: aconst_null
    //   161: areturn
    //   162: astore 4
    //   164: aconst_null
    //   165: astore_3
    //   166: ldc_w 317
    //   169: aload 4
    //   171: invokevirtual 320	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   174: invokestatic 326	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   177: pop
    //   178: aload_3
    //   179: ifnull -19 -> 160
    //   182: aload_3
    //   183: invokeinterface 599 1 0
    //   188: goto -28 -> 160
    //   191: astore 4
    //   193: aconst_null
    //   194: astore_3
    //   195: aload_3
    //   196: ifnull +9 -> 205
    //   199: aload_3
    //   200: invokeinterface 599 1 0
    //   205: aload 4
    //   207: athrow
    //   208: astore 4
    //   210: goto -15 -> 195
    //   213: astore 4
    //   215: goto -20 -> 195
    //   218: astore 4
    //   220: goto -54 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	PersistentHitStore
    //   0	223	1	paramLong	long
    //   0	223	3	paramSQLiteDatabase	SQLiteDatabase
    //   135	13	4	localItem	Item
    //   162	8	4	localSQLiteException1	SQLiteException
    //   191	15	4	localObject1	Object
    //   208	1	4	localObject2	Object
    //   213	1	4	localObject3	Object
    //   218	1	4	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   0	26	162	android/database/sqlite/SQLiteException
    //   0	26	191	finally
    //   26	137	208	finally
    //   166	178	213	finally
    //   26	137	218	android/database/sqlite/SQLiteException
  }
  
  public int getNumStoredHits()
  {
    return this.numStoredHits;
  }
  
  public int getNumStoredHitsFromDb()
  {
    localObject3 = null;
    localObject1 = null;
    int j = 0;
    int i = 0;
    try
    {
      Cursor localCursor = this.databaseHelper.getReadableDatabase().rawQuery("SELECT COUNT(*) from hits", null);
      localObject1 = localCursor;
      localObject3 = localCursor;
      if (localCursor.moveToFirst())
      {
        localObject1 = localCursor;
        localObject3 = localCursor;
        long l = localCursor.getLong(0);
        i = (int)l;
      }
      j = i;
      if (localCursor != null)
      {
        localCursor.close();
        j = i;
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      localObject3 = localObject1;
      Log.e("GoogleAnalyticsTracker", localSQLiteException.toString());
      return 0;
    }
    finally
    {
      if (localObject3 == null) {
        break label128;
      }
      ((Cursor)localObject3).close();
    }
    return j;
  }
  
  public Referrer getReferrer()
  {
    try
    {
      Referrer localReferrer = readCurrentReferrer(this.databaseHelper.getReadableDatabase());
      return localReferrer;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.e("GoogleAnalyticsTracker", localSQLiteException.toString());
    }
    return null;
  }
  
  public String getSessionId()
  {
    if (!this.sessionStarted) {
      return null;
    }
    return Integer.toString((int)this.timestampCurrent);
  }
  
  public int getStoreId()
  {
    return this.storeId;
  }
  
  long getTimestampCurrent()
  {
    return this.timestampCurrent;
  }
  
  long getTimestampFirst()
  {
    return this.timestampFirst;
  }
  
  long getTimestampPrevious()
  {
    return this.timestampPrevious;
  }
  
  /* Error */
  Transaction getTransaction(long paramLong, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_3
    //   1: ldc_w 658
    //   4: aconst_null
    //   5: ldc_w 567
    //   8: iconst_1
    //   9: anewarray 193	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: lload_1
    //   15: invokestatic 558	java/lang/Long:toString	(J)Ljava/lang/String;
    //   18: aastore
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: invokevirtual 571	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore 4
    //   27: aload 4
    //   29: astore_3
    //   30: aload 4
    //   32: invokeinterface 608 1 0
    //   37: ifeq +122 -> 159
    //   40: aload 4
    //   42: astore_3
    //   43: new 660	com/google/android/apps/analytics/Transaction$Builder
    //   46: dup
    //   47: aload 4
    //   49: aload 4
    //   51: ldc 101
    //   53: invokeinterface 582 2 0
    //   58: invokeinterface 589 2 0
    //   63: aload 4
    //   65: aload 4
    //   67: ldc -112
    //   69: invokeinterface 582 2 0
    //   74: invokeinterface 614 2 0
    //   79: invokespecial 663	com/google/android/apps/analytics/Transaction$Builder:<init>	(Ljava/lang/String;D)V
    //   82: aload 4
    //   84: aload 4
    //   86: ldc -127
    //   88: invokeinterface 582 2 0
    //   93: invokeinterface 589 2 0
    //   98: invokevirtual 667	com/google/android/apps/analytics/Transaction$Builder:setStoreName	(Ljava/lang/String;)Lcom/google/android/apps/analytics/Transaction$Builder;
    //   101: aload 4
    //   103: aload 4
    //   105: ldc -109
    //   107: invokeinterface 582 2 0
    //   112: invokeinterface 614 2 0
    //   117: invokevirtual 671	com/google/android/apps/analytics/Transaction$Builder:setTotalTax	(D)Lcom/google/android/apps/analytics/Transaction$Builder;
    //   120: aload 4
    //   122: aload 4
    //   124: ldc 123
    //   126: invokeinterface 582 2 0
    //   131: invokeinterface 614 2 0
    //   136: invokevirtual 674	com/google/android/apps/analytics/Transaction$Builder:setShippingCost	(D)Lcom/google/android/apps/analytics/Transaction$Builder;
    //   139: invokevirtual 677	com/google/android/apps/analytics/Transaction$Builder:build	()Lcom/google/android/apps/analytics/Transaction;
    //   142: astore 5
    //   144: aload 4
    //   146: ifnull +10 -> 156
    //   149: aload 4
    //   151: invokeinterface 599 1 0
    //   156: aload 5
    //   158: areturn
    //   159: aload 4
    //   161: ifnull +10 -> 171
    //   164: aload 4
    //   166: invokeinterface 599 1 0
    //   171: aconst_null
    //   172: areturn
    //   173: astore 5
    //   175: aconst_null
    //   176: astore 4
    //   178: aload 4
    //   180: astore_3
    //   181: ldc_w 317
    //   184: aload 5
    //   186: invokevirtual 320	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   189: invokestatic 326	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   192: pop
    //   193: aload 4
    //   195: ifnull -24 -> 171
    //   198: aload 4
    //   200: invokeinterface 599 1 0
    //   205: goto -34 -> 171
    //   208: astore 4
    //   210: aconst_null
    //   211: astore_3
    //   212: aload_3
    //   213: ifnull +9 -> 222
    //   216: aload_3
    //   217: invokeinterface 599 1 0
    //   222: aload 4
    //   224: athrow
    //   225: astore 4
    //   227: goto -15 -> 212
    //   230: astore 5
    //   232: goto -54 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	PersistentHitStore
    //   0	235	1	paramLong	long
    //   0	235	3	paramSQLiteDatabase	SQLiteDatabase
    //   25	174	4	localCursor	Cursor
    //   208	15	4	localObject1	Object
    //   225	1	4	localObject2	Object
    //   142	15	5	localTransaction	Transaction
    //   173	12	5	localSQLiteException1	SQLiteException
    //   230	1	5	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   0	27	173	android/database/sqlite/SQLiteException
    //   0	27	208	finally
    //   30	40	225	finally
    //   43	144	225	finally
    //   181	193	225	finally
    //   30	40	230	android/database/sqlite/SQLiteException
    //   43	144	230	android/database/sqlite/SQLiteException
  }
  
  public String getVisitorCustomVar(int paramInt)
  {
    CustomVariable localCustomVariable = this.visitorCVCache.getCustomVariableAt(paramInt);
    if ((localCustomVariable == null) || (localCustomVariable.getScope() != 1)) {
      return null;
    }
    return localCustomVariable.getValue();
  }
  
  public String getVisitorId()
  {
    if (!this.sessionStarted) {
      return null;
    }
    return String.format("%d.%d", new Object[] { Integer.valueOf(this.storeId), Long.valueOf(this.timestampFirst) });
  }
  
  CustomVariableBuffer getVisitorVarBuffer()
  {
    try
    {
      CustomVariableBuffer localCustomVariableBuffer = getVisitorVarBuffer(this.databaseHelper.getReadableDatabase());
      return localCustomVariableBuffer;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.e("GoogleAnalyticsTracker", localSQLiteException.toString());
    }
    return new CustomVariableBuffer();
  }
  
  /* Error */
  CustomVariableBuffer getVisitorVarBuffer(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: new 562	com/google/android/apps/analytics/CustomVariableBuffer
    //   3: dup
    //   4: invokespecial 563	com/google/android/apps/analytics/CustomVariableBuffer:<init>	()V
    //   7: astore 4
    //   9: aload_1
    //   10: ldc 54
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: invokevirtual 571	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   21: astore_2
    //   22: aload_2
    //   23: astore_1
    //   24: aload_2
    //   25: invokeinterface 576 1 0
    //   30: ifeq +118 -> 148
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: ldc 39
    //   38: invokeinterface 582 2 0
    //   43: ifle -21 -> 22
    //   46: aload_2
    //   47: astore_1
    //   48: aload_2
    //   49: ldc 39
    //   51: invokeinterface 582 2 0
    //   56: bipush 50
    //   58: if_icmpgt -36 -> 22
    //   61: aload_2
    //   62: astore_1
    //   63: aload 4
    //   65: new 578	com/google/android/apps/analytics/CustomVariable
    //   68: dup
    //   69: aload_2
    //   70: aload_2
    //   71: ldc 39
    //   73: invokeinterface 582 2 0
    //   78: invokeinterface 585 2 0
    //   83: aload_2
    //   84: aload_2
    //   85: ldc 42
    //   87: invokeinterface 582 2 0
    //   92: invokeinterface 589 2 0
    //   97: aload_2
    //   98: aload_2
    //   99: ldc 48
    //   101: invokeinterface 582 2 0
    //   106: invokeinterface 589 2 0
    //   111: iconst_1
    //   112: invokespecial 592	com/google/android/apps/analytics/CustomVariable:<init>	(ILjava/lang/String;Ljava/lang/String;I)V
    //   115: invokevirtual 596	com/google/android/apps/analytics/CustomVariableBuffer:setCustomVariable	(Lcom/google/android/apps/analytics/CustomVariable;)V
    //   118: goto -96 -> 22
    //   121: astore_3
    //   122: aload_2
    //   123: astore_1
    //   124: ldc_w 317
    //   127: aload_3
    //   128: invokevirtual 320	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   131: invokestatic 326	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   134: pop
    //   135: aload_2
    //   136: ifnull +9 -> 145
    //   139: aload_2
    //   140: invokeinterface 599 1 0
    //   145: aload 4
    //   147: areturn
    //   148: aload_2
    //   149: ifnull -4 -> 145
    //   152: aload_2
    //   153: invokeinterface 599 1 0
    //   158: aload 4
    //   160: areturn
    //   161: astore_2
    //   162: aconst_null
    //   163: astore_1
    //   164: aload_1
    //   165: ifnull +9 -> 174
    //   168: aload_1
    //   169: invokeinterface 599 1 0
    //   174: aload_2
    //   175: athrow
    //   176: astore_2
    //   177: goto -13 -> 164
    //   180: astore_3
    //   181: aconst_null
    //   182: astore_2
    //   183: goto -61 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	PersistentHitStore
    //   0	186	1	paramSQLiteDatabase	SQLiteDatabase
    //   21	132	2	localCursor	Cursor
    //   161	14	2	localObject1	Object
    //   176	1	2	localObject2	Object
    //   182	1	2	localObject3	Object
    //   121	7	3	localSQLiteException1	SQLiteException
    //   180	1	3	localSQLiteException2	SQLiteException
    //   7	152	4	localCustomVariableBuffer	CustomVariableBuffer
    // Exception table:
    //   from	to	target	type
    //   24	33	121	android/database/sqlite/SQLiteException
    //   35	46	121	android/database/sqlite/SQLiteException
    //   48	61	121	android/database/sqlite/SQLiteException
    //   63	118	121	android/database/sqlite/SQLiteException
    //   9	22	161	finally
    //   24	33	176	finally
    //   35	46	176	finally
    //   48	61	176	finally
    //   63	118	176	finally
    //   124	135	176	finally
    //   9	22	180	android/database/sqlite/SQLiteException
  }
  
  int getVisits()
  {
    return this.visits;
  }
  
  public void loadExistingSession()
  {
    try
    {
      loadExistingSession(this.databaseHelper.getWritableDatabase());
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.e("GoogleAnalyticsTracker", localSQLiteException.toString());
    }
  }
  
  /* Error */
  public void loadExistingSession(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 700
    //   4: aconst_null
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: aconst_null
    //   9: aconst_null
    //   10: invokevirtual 571	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   13: astore_3
    //   14: aload_3
    //   15: astore 4
    //   17: aload_3
    //   18: invokeinterface 608 1 0
    //   23: ifeq +137 -> 160
    //   26: aload_3
    //   27: astore 4
    //   29: aload_0
    //   30: aload_3
    //   31: iconst_0
    //   32: invokeinterface 618 2 0
    //   37: putfield 475	com/google/android/apps/analytics/PersistentHitStore:timestampFirst	J
    //   40: aload_3
    //   41: astore 4
    //   43: aload_0
    //   44: aload_3
    //   45: iconst_1
    //   46: invokeinterface 618 2 0
    //   51: putfield 480	com/google/android/apps/analytics/PersistentHitStore:timestampPrevious	J
    //   54: aload_3
    //   55: astore 4
    //   57: aload_0
    //   58: aload_3
    //   59: iconst_2
    //   60: invokeinterface 618 2 0
    //   65: putfield 432	com/google/android/apps/analytics/PersistentHitStore:timestampCurrent	J
    //   68: aload_3
    //   69: astore 4
    //   71: aload_0
    //   72: aload_3
    //   73: iconst_3
    //   74: invokeinterface 585 2 0
    //   79: putfield 443	com/google/android/apps/analytics/PersistentHitStore:visits	I
    //   82: aload_3
    //   83: astore 4
    //   85: aload_0
    //   86: aload_3
    //   87: iconst_4
    //   88: invokeinterface 585 2 0
    //   93: putfield 500	com/google/android/apps/analytics/PersistentHitStore:storeId	I
    //   96: aload_3
    //   97: astore 4
    //   99: aload_0
    //   100: aload_1
    //   101: invokevirtual 410	com/google/android/apps/analytics/PersistentHitStore:readCurrentReferrer	(Landroid/database/sqlite/SQLiteDatabase;)Lcom/google/android/apps/analytics/Referrer;
    //   104: astore_1
    //   105: aload_3
    //   106: astore 4
    //   108: aload_0
    //   109: getfield 475	com/google/android/apps/analytics/PersistentHitStore:timestampFirst	J
    //   112: lconst_0
    //   113: lcmp
    //   114: ifeq +41 -> 155
    //   117: aload_1
    //   118: ifnull +218 -> 336
    //   121: aload_3
    //   122: astore 4
    //   124: aload_1
    //   125: invokevirtual 416	com/google/android/apps/analytics/Referrer:getTimeStamp	()J
    //   128: lconst_0
    //   129: lcmp
    //   130: ifeq +25 -> 155
    //   133: goto +203 -> 336
    //   136: aload_3
    //   137: astore 4
    //   139: aload_0
    //   140: iload_2
    //   141: putfield 648	com/google/android/apps/analytics/PersistentHitStore:sessionStarted	Z
    //   144: aload_3
    //   145: ifnull +9 -> 154
    //   148: aload_3
    //   149: invokeinterface 599 1 0
    //   154: return
    //   155: iconst_0
    //   156: istore_2
    //   157: goto -21 -> 136
    //   160: aload_3
    //   161: astore 4
    //   163: aload_0
    //   164: iconst_0
    //   165: putfield 648	com/google/android/apps/analytics/PersistentHitStore:sessionStarted	Z
    //   168: aload_3
    //   169: astore 4
    //   171: aload_0
    //   172: iconst_1
    //   173: putfield 702	com/google/android/apps/analytics/PersistentHitStore:useStoredVisitorVars	Z
    //   176: aload_3
    //   177: astore 4
    //   179: aload_0
    //   180: new 704	java/security/SecureRandom
    //   183: dup
    //   184: invokespecial 705	java/security/SecureRandom:<init>	()V
    //   187: invokevirtual 707	java/security/SecureRandom:nextInt	()I
    //   190: ldc_w 465
    //   193: iand
    //   194: putfield 500	com/google/android/apps/analytics/PersistentHitStore:storeId	I
    //   197: aload_3
    //   198: astore 4
    //   200: aload_3
    //   201: invokeinterface 599 1 0
    //   206: new 425	android/content/ContentValues
    //   209: dup
    //   210: invokespecial 426	android/content/ContentValues:<init>	()V
    //   213: astore_3
    //   214: aload_3
    //   215: ldc -121
    //   217: lconst_0
    //   218: invokestatic 438	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   221: invokevirtual 441	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   224: aload_3
    //   225: ldc -118
    //   227: lconst_0
    //   228: invokestatic 438	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   231: invokevirtual 441	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   234: aload_3
    //   235: ldc -124
    //   237: lconst_0
    //   238: invokestatic 438	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   241: invokevirtual 441	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   244: aload_3
    //   245: ldc -97
    //   247: iconst_0
    //   248: invokestatic 448	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: invokevirtual 451	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   254: aload_3
    //   255: ldc 126
    //   257: aload_0
    //   258: getfield 500	com/google/android/apps/analytics/PersistentHitStore:storeId	I
    //   261: invokestatic 448	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   264: invokevirtual 451	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   267: aload_1
    //   268: ldc_w 700
    //   271: aconst_null
    //   272: aload_3
    //   273: invokevirtual 536	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   276: pop2
    //   277: aconst_null
    //   278: astore_3
    //   279: goto -135 -> 144
    //   282: astore_1
    //   283: aconst_null
    //   284: astore_3
    //   285: aload_3
    //   286: astore 4
    //   288: ldc_w 317
    //   291: aload_1
    //   292: invokevirtual 320	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   295: invokestatic 326	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   298: pop
    //   299: aload_3
    //   300: ifnull -146 -> 154
    //   303: aload_3
    //   304: invokeinterface 599 1 0
    //   309: return
    //   310: astore_1
    //   311: aconst_null
    //   312: astore 4
    //   314: aload 4
    //   316: ifnull +10 -> 326
    //   319: aload 4
    //   321: invokeinterface 599 1 0
    //   326: aload_1
    //   327: athrow
    //   328: astore_1
    //   329: goto -15 -> 314
    //   332: astore_1
    //   333: goto -48 -> 285
    //   336: iconst_1
    //   337: istore_2
    //   338: goto -202 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	this	PersistentHitStore
    //   0	341	1	paramSQLiteDatabase	SQLiteDatabase
    //   140	198	2	bool	boolean
    //   13	291	3	localObject1	Object
    //   15	305	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	14	282	android/database/sqlite/SQLiteException
    //   206	277	282	android/database/sqlite/SQLiteException
    //   0	14	310	finally
    //   206	277	310	finally
    //   17	26	328	finally
    //   29	40	328	finally
    //   43	54	328	finally
    //   57	68	328	finally
    //   71	82	328	finally
    //   85	96	328	finally
    //   99	105	328	finally
    //   108	117	328	finally
    //   124	133	328	finally
    //   139	144	328	finally
    //   163	168	328	finally
    //   171	176	328	finally
    //   179	197	328	finally
    //   200	206	328	finally
    //   288	299	328	finally
    //   17	26	332	android/database/sqlite/SQLiteException
    //   29	40	332	android/database/sqlite/SQLiteException
    //   43	54	332	android/database/sqlite/SQLiteException
    //   57	68	332	android/database/sqlite/SQLiteException
    //   71	82	332	android/database/sqlite/SQLiteException
    //   85	96	332	android/database/sqlite/SQLiteException
    //   99	105	332	android/database/sqlite/SQLiteException
    //   108	117	332	android/database/sqlite/SQLiteException
    //   124	133	332	android/database/sqlite/SQLiteException
    //   139	144	332	android/database/sqlite/SQLiteException
    //   163	168	332	android/database/sqlite/SQLiteException
    //   171	176	332	android/database/sqlite/SQLiteException
    //   179	197	332	android/database/sqlite/SQLiteException
    //   200	206	332	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public Event[] peekEvents(int paramInt1, SQLiteDatabase paramSQLiteDatabase, int paramInt2)
  {
    // Byte code:
    //   0: new 711	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 712	java/util/ArrayList:<init>	()V
    //   7: astore 9
    //   9: aload_2
    //   10: ldc_w 714
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: ldc 63
    //   20: iload_1
    //   21: invokestatic 650	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   24: invokevirtual 717	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore 6
    //   29: aload 6
    //   31: invokeinterface 576 1 0
    //   36: ifeq +408 -> 444
    //   39: aload 6
    //   41: bipush 8
    //   43: invokeinterface 589 2 0
    //   48: astore 10
    //   50: aload 6
    //   52: bipush 9
    //   54: invokeinterface 589 2 0
    //   59: astore 7
    //   61: ldc_w 719
    //   64: aload 10
    //   66: invokevirtual 723	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ifeq +433 -> 502
    //   72: aconst_null
    //   73: astore 8
    //   75: new 460	com/google/android/apps/analytics/Event
    //   78: dup
    //   79: aload 6
    //   81: iconst_0
    //   82: invokeinterface 618 2 0
    //   87: aload 6
    //   89: iconst_2
    //   90: invokeinterface 589 2 0
    //   95: aload 6
    //   97: iconst_3
    //   98: invokeinterface 585 2 0
    //   103: aload 6
    //   105: iconst_4
    //   106: invokeinterface 585 2 0
    //   111: aload 6
    //   113: iconst_5
    //   114: invokeinterface 585 2 0
    //   119: aload 6
    //   121: bipush 6
    //   123: invokeinterface 585 2 0
    //   128: aload 6
    //   130: bipush 7
    //   132: invokeinterface 585 2 0
    //   137: aload 7
    //   139: aload 10
    //   141: aload 8
    //   143: aload 6
    //   145: bipush 10
    //   147: invokeinterface 589 2 0
    //   152: aload 6
    //   154: bipush 11
    //   156: invokeinterface 585 2 0
    //   161: aload 6
    //   163: bipush 12
    //   165: invokeinterface 585 2 0
    //   170: aload 6
    //   172: bipush 13
    //   174: invokeinterface 585 2 0
    //   179: invokespecial 726	com/google/android/apps/analytics/Event:<init>	(JLjava/lang/String;IIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V
    //   182: astore 8
    //   184: aload 8
    //   186: aload 6
    //   188: iconst_1
    //   189: invokeinterface 585 2 0
    //   194: invokevirtual 503	com/google/android/apps/analytics/Event:setUserId	(I)V
    //   197: aload 6
    //   199: aload 6
    //   201: ldc 63
    //   203: invokeinterface 582 2 0
    //   208: invokeinterface 618 2 0
    //   213: lstore 4
    //   215: ldc_w 728
    //   218: aload 8
    //   220: getfield 730	com/google/android/apps/analytics/Event:category	Ljava/lang/String;
    //   223: invokevirtual 723	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   226: ifeq +101 -> 327
    //   229: aload_0
    //   230: lload 4
    //   232: aload_2
    //   233: invokevirtual 732	com/google/android/apps/analytics/PersistentHitStore:getTransaction	(JLandroid/database/sqlite/SQLiteDatabase;)Lcom/google/android/apps/analytics/Transaction;
    //   236: astore 7
    //   238: aload 7
    //   240: ifnonnull +31 -> 271
    //   243: ldc_w 317
    //   246: new 180	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   253: ldc_w 734
    //   256: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: lload 4
    //   261: invokevirtual 737	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   264: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 361	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   270: pop
    //   271: aload 8
    //   273: aload 7
    //   275: invokevirtual 741	com/google/android/apps/analytics/Event:setTransaction	(Lcom/google/android/apps/analytics/Transaction;)V
    //   278: aload 9
    //   280: aload 8
    //   282: invokeinterface 746 2 0
    //   287: pop
    //   288: goto -259 -> 29
    //   291: astore 7
    //   293: aload 6
    //   295: astore_2
    //   296: aload 7
    //   298: astore 6
    //   300: ldc_w 317
    //   303: aload 6
    //   305: invokevirtual 320	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   308: invokestatic 326	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   311: pop
    //   312: aload_2
    //   313: ifnull +9 -> 322
    //   316: aload_2
    //   317: invokeinterface 599 1 0
    //   322: iconst_0
    //   323: anewarray 460	com/google/android/apps/analytics/Event
    //   326: areturn
    //   327: ldc_w 748
    //   330: aload 8
    //   332: getfield 730	com/google/android/apps/analytics/Event:category	Ljava/lang/String;
    //   335: invokevirtual 723	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   338: ifeq +70 -> 408
    //   341: aload_0
    //   342: lload 4
    //   344: aload_2
    //   345: invokevirtual 750	com/google/android/apps/analytics/PersistentHitStore:getItem	(JLandroid/database/sqlite/SQLiteDatabase;)Lcom/google/android/apps/analytics/Item;
    //   348: astore 7
    //   350: aload 7
    //   352: ifnonnull +31 -> 383
    //   355: ldc_w 317
    //   358: new 180	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   365: ldc_w 752
    //   368: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: lload 4
    //   373: invokevirtual 737	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   376: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 361	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   382: pop
    //   383: aload 8
    //   385: aload 7
    //   387: invokevirtual 756	com/google/android/apps/analytics/Event:setItem	(Lcom/google/android/apps/analytics/Item;)V
    //   390: goto -112 -> 278
    //   393: astore_2
    //   394: aload 6
    //   396: ifnull +10 -> 406
    //   399: aload 6
    //   401: invokeinterface 599 1 0
    //   406: aload_2
    //   407: athrow
    //   408: iload_3
    //   409: iconst_1
    //   410: if_icmple +22 -> 432
    //   413: aload_0
    //   414: lload 4
    //   416: aload_2
    //   417: invokevirtual 758	com/google/android/apps/analytics/PersistentHitStore:getCustomVariables	(JLandroid/database/sqlite/SQLiteDatabase;)Lcom/google/android/apps/analytics/CustomVariableBuffer;
    //   420: astore 7
    //   422: aload 8
    //   424: aload 7
    //   426: invokevirtual 762	com/google/android/apps/analytics/Event:setCustomVariableBuffer	(Lcom/google/android/apps/analytics/CustomVariableBuffer;)V
    //   429: goto -151 -> 278
    //   432: new 562	com/google/android/apps/analytics/CustomVariableBuffer
    //   435: dup
    //   436: invokespecial 563	com/google/android/apps/analytics/CustomVariableBuffer:<init>	()V
    //   439: astore 7
    //   441: goto -19 -> 422
    //   444: aload 6
    //   446: ifnull +10 -> 456
    //   449: aload 6
    //   451: invokeinterface 599 1 0
    //   456: aload 9
    //   458: aload 9
    //   460: invokeinterface 765 1 0
    //   465: anewarray 460	com/google/android/apps/analytics/Event
    //   468: invokeinterface 769 2 0
    //   473: checkcast 771	[Lcom/google/android/apps/analytics/Event;
    //   476: areturn
    //   477: astore_2
    //   478: aconst_null
    //   479: astore 6
    //   481: goto -87 -> 394
    //   484: astore 7
    //   486: aload_2
    //   487: astore 6
    //   489: aload 7
    //   491: astore_2
    //   492: goto -98 -> 394
    //   495: astore 6
    //   497: aconst_null
    //   498: astore_2
    //   499: goto -199 -> 300
    //   502: aload 7
    //   504: astore 8
    //   506: aconst_null
    //   507: astore 7
    //   509: goto -434 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	512	0	this	PersistentHitStore
    //   0	512	1	paramInt1	int
    //   0	512	2	paramSQLiteDatabase	SQLiteDatabase
    //   0	512	3	paramInt2	int
    //   213	202	4	l	long
    //   27	461	6	localObject1	Object
    //   495	1	6	localSQLiteException1	SQLiteException
    //   59	215	7	localObject2	Object
    //   291	6	7	localSQLiteException2	SQLiteException
    //   348	92	7	localObject3	Object
    //   484	19	7	localObject4	Object
    //   507	1	7	localObject5	Object
    //   73	432	8	localObject6	Object
    //   7	452	9	localArrayList	java.util.ArrayList
    //   48	92	10	str	String
    // Exception table:
    //   from	to	target	type
    //   29	72	291	android/database/sqlite/SQLiteException
    //   75	238	291	android/database/sqlite/SQLiteException
    //   243	271	291	android/database/sqlite/SQLiteException
    //   271	278	291	android/database/sqlite/SQLiteException
    //   278	288	291	android/database/sqlite/SQLiteException
    //   327	350	291	android/database/sqlite/SQLiteException
    //   355	383	291	android/database/sqlite/SQLiteException
    //   383	390	291	android/database/sqlite/SQLiteException
    //   413	422	291	android/database/sqlite/SQLiteException
    //   422	429	291	android/database/sqlite/SQLiteException
    //   432	441	291	android/database/sqlite/SQLiteException
    //   29	72	393	finally
    //   75	238	393	finally
    //   243	271	393	finally
    //   271	278	393	finally
    //   278	288	393	finally
    //   327	350	393	finally
    //   355	383	393	finally
    //   383	390	393	finally
    //   413	422	393	finally
    //   422	429	393	finally
    //   432	441	393	finally
    //   9	29	477	finally
    //   300	312	484	finally
    //   9	29	495	android/database/sqlite/SQLiteException
  }
  
  public Hit[] peekHits()
  {
    return peekHits(1000);
  }
  
  /* Error */
  public Hit[] peekHits(int paramInt)
  {
    // Byte code:
    //   0: new 711	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 712	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 278	com/google/android/apps/analytics/PersistentHitStore:databaseHelper	Lcom/google/android/apps/analytics/PersistentHitStore$DataBaseHelper;
    //   13: invokevirtual 637	com/google/android/apps/analytics/PersistentHitStore$DataBaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: ldc_w 553
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: ldc 66
    //   26: iload_1
    //   27: invokestatic 650	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   30: invokevirtual 717	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore_3
    //   34: aload_3
    //   35: astore_2
    //   36: aload_3
    //   37: invokeinterface 576 1 0
    //   42: ifeq +68 -> 110
    //   45: aload_3
    //   46: astore_2
    //   47: aload 4
    //   49: new 778	com/google/android/apps/analytics/Hit
    //   52: dup
    //   53: aload_3
    //   54: iconst_1
    //   55: invokeinterface 589 2 0
    //   60: aload_3
    //   61: iconst_0
    //   62: invokeinterface 618 2 0
    //   67: invokespecial 781	com/google/android/apps/analytics/Hit:<init>	(Ljava/lang/String;J)V
    //   70: invokeinterface 746 2 0
    //   75: pop
    //   76: goto -42 -> 34
    //   79: astore 4
    //   81: aload_3
    //   82: astore_2
    //   83: ldc_w 317
    //   86: aload 4
    //   88: invokevirtual 320	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   91: invokestatic 326	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   94: pop
    //   95: aload_3
    //   96: ifnull +9 -> 105
    //   99: aload_3
    //   100: invokeinterface 599 1 0
    //   105: iconst_0
    //   106: anewarray 778	com/google/android/apps/analytics/Hit
    //   109: areturn
    //   110: aload_3
    //   111: ifnull +9 -> 120
    //   114: aload_3
    //   115: invokeinterface 599 1 0
    //   120: aload 4
    //   122: aload 4
    //   124: invokeinterface 765 1 0
    //   129: anewarray 778	com/google/android/apps/analytics/Hit
    //   132: invokeinterface 769 2 0
    //   137: checkcast 783	[Lcom/google/android/apps/analytics/Hit;
    //   140: areturn
    //   141: astore_3
    //   142: aconst_null
    //   143: astore_2
    //   144: aload_2
    //   145: ifnull +9 -> 154
    //   148: aload_2
    //   149: invokeinterface 599 1 0
    //   154: aload_3
    //   155: athrow
    //   156: astore_3
    //   157: goto -13 -> 144
    //   160: astore 4
    //   162: aconst_null
    //   163: astore_3
    //   164: goto -83 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	PersistentHitStore
    //   0	167	1	paramInt	int
    //   35	114	2	localCursor1	Cursor
    //   33	82	3	localCursor2	Cursor
    //   141	14	3	localObject1	Object
    //   156	1	3	localObject2	Object
    //   163	1	3	localObject3	Object
    //   7	41	4	localArrayList	java.util.ArrayList
    //   79	44	4	localSQLiteException1	SQLiteException
    //   160	1	4	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   36	45	79	android/database/sqlite/SQLiteException
    //   47	76	79	android/database/sqlite/SQLiteException
    //   9	34	141	finally
    //   36	45	156	finally
    //   47	76	156	finally
    //   83	95	156	finally
    //   9	34	160	android/database/sqlite/SQLiteException
  }
  
  void putCustomVariables(Event paramEvent, SQLiteDatabase paramSQLiteDatabase)
  {
    if (("__##GOOGLEITEM##__".equals(paramEvent.category)) || ("__##GOOGLETRANSACTION##__".equals(paramEvent.category))) {}
    label125:
    label254:
    label273:
    for (;;)
    {
      return;
      Object localObject2 = paramEvent.getCustomVariableBuffer();
      Object localObject1;
      int i;
      if (this.useStoredVisitorVars)
      {
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new CustomVariableBuffer();
          paramEvent.setCustomVariableBuffer((CustomVariableBuffer)localObject1);
        }
        i = 1;
        while (i <= 50)
        {
          paramEvent = this.visitorCVCache.getCustomVariableAt(i);
          localObject2 = ((CustomVariableBuffer)localObject1).getCustomVariableAt(i);
          if ((paramEvent != null) && (localObject2 == null)) {
            ((CustomVariableBuffer)localObject1).setCustomVariable(paramEvent);
          }
          i += 1;
        }
        this.useStoredVisitorVars = false;
      }
      for (paramEvent = (Event)localObject1;; paramEvent = (Event)localObject2)
      {
        if (paramEvent == null) {
          break label273;
        }
        i = 1;
        if (i <= 50) {
          if (!paramEvent.isIndexAvailable(i))
          {
            localObject1 = paramEvent.getCustomVariableAt(i);
            paramSQLiteDatabase.delete("custom_var_visitor_cache", "cv_index = ?", new String[] { Integer.toString(((CustomVariable)localObject1).getIndex()) });
            if (((CustomVariable)localObject1).getScope() != 1) {
              break label254;
            }
            localObject2 = new ContentValues();
            ((ContentValues)localObject2).put("cv_index", Integer.valueOf(((CustomVariable)localObject1).getIndex()));
            ((ContentValues)localObject2).put("cv_name", ((CustomVariable)localObject1).getName());
            ((ContentValues)localObject2).put("cv_value", ((CustomVariable)localObject1).getValue());
            paramSQLiteDatabase.insert("custom_var_visitor_cache", null, (ContentValues)localObject2);
            this.visitorCVCache.setCustomVariable((CustomVariable)localObject1);
          }
        }
        for (;;)
        {
          i += 1;
          break label125;
          break;
          this.visitorCVCache.clearCustomVariableAt(((CustomVariable)localObject1).getIndex());
        }
      }
    }
  }
  
  /* Error */
  public void putEvent(Event paramEvent)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 551	com/google/android/apps/analytics/PersistentHitStore:numStoredHits	I
    //   4: sipush 1000
    //   7: if_icmplt +14 -> 21
    //   10: ldc_w 317
    //   13: ldc_w 802
    //   16: invokestatic 361	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   19: pop
    //   20: return
    //   21: aload_0
    //   22: getfield 268	com/google/android/apps/analytics/PersistentHitStore:sampleRate	I
    //   25: bipush 100
    //   27: if_icmpeq +59 -> 86
    //   30: aload_1
    //   31: invokevirtual 498	com/google/android/apps/analytics/Event:getUserId	()I
    //   34: iconst_m1
    //   35: if_icmpne +43 -> 78
    //   38: aload_0
    //   39: getfield 500	com/google/android/apps/analytics/PersistentHitStore:storeId	I
    //   42: istore_2
    //   43: iload_2
    //   44: sipush 10000
    //   47: irem
    //   48: aload_0
    //   49: getfield 268	com/google/android/apps/analytics/PersistentHitStore:sampleRate	I
    //   52: bipush 100
    //   54: imul
    //   55: if_icmplt +31 -> 86
    //   58: invokestatic 808	com/google/android/apps/analytics/GoogleAnalyticsTracker:getInstance	()Lcom/google/android/apps/analytics/GoogleAnalyticsTracker;
    //   61: invokevirtual 811	com/google/android/apps/analytics/GoogleAnalyticsTracker:getDebug	()Z
    //   64: ifeq -44 -> 20
    //   67: ldc_w 317
    //   70: ldc_w 813
    //   73: invokestatic 816	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   76: pop
    //   77: return
    //   78: aload_1
    //   79: invokevirtual 498	com/google/android/apps/analytics/Event:getUserId	()I
    //   82: istore_2
    //   83: goto -40 -> 43
    //   86: aload_0
    //   87: monitorenter
    //   88: aload_0
    //   89: getfield 278	com/google/android/apps/analytics/PersistentHitStore:databaseHelper	Lcom/google/android/apps/analytics/PersistentHitStore$DataBaseHelper;
    //   92: invokevirtual 547	com/google/android/apps/analytics/PersistentHitStore$DataBaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   95: astore_3
    //   96: aload_3
    //   97: invokevirtual 528	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   100: aload_0
    //   101: getfield 648	com/google/android/apps/analytics/PersistentHitStore:sessionStarted	Z
    //   104: ifne +8 -> 112
    //   107: aload_0
    //   108: aload_3
    //   109: invokevirtual 819	com/google/android/apps/analytics/PersistentHitStore:storeUpdatedSession	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   112: aload_0
    //   113: aload_1
    //   114: aload_3
    //   115: iconst_1
    //   116: invokespecial 309	com/google/android/apps/analytics/PersistentHitStore:putEvent	(Lcom/google/android/apps/analytics/Event;Landroid/database/sqlite/SQLiteDatabase;Z)V
    //   119: aload_3
    //   120: invokevirtual 539	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   123: aload_3
    //   124: invokevirtual 542	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   127: ifeq +8 -> 135
    //   130: aload_3
    //   131: invokestatic 295	com/google/android/apps/analytics/PersistentHitStore:endTransaction	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   134: pop
    //   135: aload_0
    //   136: monitorexit
    //   137: return
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    //   143: astore_1
    //   144: ldc_w 317
    //   147: new 180	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 821
    //   157: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_1
    //   161: invokevirtual 320	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   164: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 326	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   173: pop
    //   174: aload_0
    //   175: monitorexit
    //   176: return
    //   177: astore_1
    //   178: ldc_w 317
    //   181: new 180	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   188: ldc_w 823
    //   191: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_1
    //   195: invokevirtual 320	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   198: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 326	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   207: pop
    //   208: aload_3
    //   209: invokevirtual 542	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   212: ifeq -77 -> 135
    //   215: aload_3
    //   216: invokestatic 295	com/google/android/apps/analytics/PersistentHitStore:endTransaction	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   219: pop
    //   220: goto -85 -> 135
    //   223: astore_1
    //   224: aload_3
    //   225: invokevirtual 542	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   228: ifeq +8 -> 236
    //   231: aload_3
    //   232: invokestatic 295	com/google/android/apps/analytics/PersistentHitStore:endTransaction	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   235: pop
    //   236: aload_1
    //   237: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	PersistentHitStore
    //   0	238	1	paramEvent	Event
    //   42	41	2	i	int
    //   95	137	3	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   88	96	138	finally
    //   123	135	138	finally
    //   135	137	138	finally
    //   139	141	138	finally
    //   144	176	138	finally
    //   208	220	138	finally
    //   224	236	138	finally
    //   236	238	138	finally
    //   88	96	143	android/database/sqlite/SQLiteException
    //   96	112	177	android/database/sqlite/SQLiteException
    //   112	123	177	android/database/sqlite/SQLiteException
    //   96	112	223	finally
    //   112	123	223	finally
    //   178	208	223	finally
  }
  
  /* Error */
  Referrer readCurrentReferrer(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 107
    //   3: iconst_4
    //   4: anewarray 193	java/lang/String
    //   7: dup
    //   8: iconst_0
    //   9: ldc 107
    //   11: aastore
    //   12: dup
    //   13: iconst_1
    //   14: ldc -115
    //   16: aastore
    //   17: dup
    //   18: iconst_2
    //   19: ldc 114
    //   21: aastore
    //   22: dup
    //   23: iconst_3
    //   24: ldc 111
    //   26: aastore
    //   27: aconst_null
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: invokevirtual 571	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   35: astore_1
    //   36: aload_1
    //   37: invokeinterface 608 1 0
    //   42: ifeq +149 -> 191
    //   45: aload_1
    //   46: aload_1
    //   47: ldc -115
    //   49: invokeinterface 582 2 0
    //   54: invokeinterface 618 2 0
    //   59: lstore 4
    //   61: aload_1
    //   62: aload_1
    //   63: ldc 114
    //   65: invokeinterface 582 2 0
    //   70: invokeinterface 585 2 0
    //   75: istore_2
    //   76: aload_1
    //   77: aload_1
    //   78: ldc 111
    //   80: invokeinterface 582 2 0
    //   85: invokeinterface 585 2 0
    //   90: istore_3
    //   91: new 412	com/google/android/apps/analytics/Referrer
    //   94: dup
    //   95: aload_1
    //   96: aload_1
    //   97: ldc 107
    //   99: invokeinterface 582 2 0
    //   104: invokeinterface 589 2 0
    //   109: lload 4
    //   111: iload_2
    //   112: iload_3
    //   113: invokespecial 458	com/google/android/apps/analytics/Referrer:<init>	(Ljava/lang/String;JII)V
    //   116: astore 6
    //   118: aload_1
    //   119: ifnull +9 -> 128
    //   122: aload_1
    //   123: invokeinterface 599 1 0
    //   128: aload 6
    //   130: areturn
    //   131: astore 6
    //   133: aconst_null
    //   134: astore_1
    //   135: ldc_w 317
    //   138: aload 6
    //   140: invokevirtual 320	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   143: invokestatic 326	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   146: pop
    //   147: aload_1
    //   148: ifnull +9 -> 157
    //   151: aload_1
    //   152: invokeinterface 599 1 0
    //   157: aconst_null
    //   158: areturn
    //   159: astore 6
    //   161: aconst_null
    //   162: astore_1
    //   163: aload_1
    //   164: ifnull +9 -> 173
    //   167: aload_1
    //   168: invokeinterface 599 1 0
    //   173: aload 6
    //   175: athrow
    //   176: astore 6
    //   178: goto -15 -> 163
    //   181: astore 6
    //   183: goto -20 -> 163
    //   186: astore 6
    //   188: goto -53 -> 135
    //   191: aconst_null
    //   192: astore 6
    //   194: goto -76 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	PersistentHitStore
    //   0	197	1	paramSQLiteDatabase	SQLiteDatabase
    //   75	37	2	i	int
    //   90	23	3	j	int
    //   59	51	4	l	long
    //   116	13	6	localReferrer	Referrer
    //   131	8	6	localSQLiteException1	SQLiteException
    //   159	15	6	localObject1	Object
    //   176	1	6	localObject2	Object
    //   181	1	6	localObject3	Object
    //   186	1	6	localSQLiteException2	SQLiteException
    //   192	1	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   0	36	131	android/database/sqlite/SQLiteException
    //   0	36	159	finally
    //   36	118	176	finally
    //   135	147	181	finally
    //   36	118	186	android/database/sqlite/SQLiteException
  }
  
  public void setAnonymizeIp(boolean paramBoolean)
  {
    this.anonymizeIp = paramBoolean;
  }
  
  public boolean setReferrer(String paramString)
  {
    paramString = formatReferrer(paramString);
    if (paramString == null) {
      return false;
    }
    for (;;)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = this.databaseHelper.getWritableDatabase();
        Referrer localReferrer = readCurrentReferrer(localSQLiteDatabase);
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("referrer", paramString);
        localContentValues.put("timestamp_referrer", Long.valueOf(0L));
        localContentValues.put("referrer_visit", Integer.valueOf(0));
        if (localReferrer == null) {
          break label142;
        }
        long l2 = localReferrer.getIndex();
        l1 = l2;
        if (localReferrer.getTimeStamp() > 0L) {
          l1 = l2 + 1L;
        }
        localContentValues.put("referrer_index", Long.valueOf(l1));
        if (setReferrerDatabase(localSQLiteDatabase, localContentValues))
        {
          startNewVisit();
          return true;
        }
      }
      catch (SQLiteException paramString)
      {
        Log.e("GoogleAnalyticsTracker", paramString.toString());
        return false;
      }
      return false;
      label142:
      long l1 = 1L;
    }
  }
  
  public void setSampleRate(int paramInt)
  {
    this.sampleRate = paramInt;
  }
  
  public void startNewVisit()
  {
    try
    {
      this.sessionStarted = false;
      this.useStoredVisitorVars = true;
      this.numStoredHits = getNumStoredHitsFromDb();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void storeUpdatedSession(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase = this.databaseHelper.getWritableDatabase();
    paramSQLiteDatabase.delete("session", null, null);
    if (this.timestampFirst == 0L)
    {
      long l = System.currentTimeMillis() / 1000L;
      this.timestampFirst = l;
      this.timestampPrevious = l;
      this.timestampCurrent = l;
    }
    for (this.visits = 1;; this.visits += 1)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("timestamp_first", Long.valueOf(this.timestampFirst));
      localContentValues.put("timestamp_previous", Long.valueOf(this.timestampPrevious));
      localContentValues.put("timestamp_current", Long.valueOf(this.timestampCurrent));
      localContentValues.put("visits", Integer.valueOf(this.visits));
      localContentValues.put("store_id", Integer.valueOf(this.storeId));
      paramSQLiteDatabase.insert("session", null, localContentValues);
      this.sessionStarted = true;
      return;
      this.timestampPrevious = this.timestampCurrent;
      this.timestampCurrent = (System.currentTimeMillis() / 1000L);
      if (this.timestampCurrent == this.timestampPrevious) {
        this.timestampCurrent += 1L;
      }
    }
  }
  
  void writeEventToDatabase(Event paramEvent, Referrer paramReferrer, SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
    throws SQLiteException
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hit_string", HitBuilder.constructHitRequestPath(paramEvent, paramReferrer));
    if (paramBoolean) {}
    for (long l = System.currentTimeMillis();; l = 0L)
    {
      localContentValues.put("hit_time", Long.valueOf(l));
      paramSQLiteDatabase.insert("hits", null, localContentValues);
      this.numStoredHits += 1;
      return;
    }
  }
  
  static class DataBaseHelper
    extends SQLiteOpenHelper
  {
    private final int databaseVersion;
    private final PersistentHitStore store;
    
    public DataBaseHelper(Context paramContext, PersistentHitStore paramPersistentHitStore)
    {
      this(paramContext, "google_analytics.db", 6, paramPersistentHitStore);
    }
    
    DataBaseHelper(Context paramContext, String paramString, int paramInt, PersistentHitStore paramPersistentHitStore)
    {
      super(paramString, null, paramInt);
      this.databaseVersion = paramInt;
      this.store = paramPersistentHitStore;
    }
    
    public DataBaseHelper(Context paramContext, String paramString, PersistentHitStore paramPersistentHitStore)
    {
      this(paramContext, paramString, 6, paramPersistentHitStore);
    }
    
    private void createECommerceTables(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS transaction_events;");
      paramSQLiteDatabase.execSQL(PersistentHitStore.CREATE_TRANSACTION_EVENTS_TABLE);
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS item_events;");
      paramSQLiteDatabase.execSQL(PersistentHitStore.CREATE_ITEM_EVENTS_TABLE);
    }
    
    private void createHitTable(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS hits;");
      paramSQLiteDatabase.execSQL(PersistentHitStore.CREATE_HITS_TABLE);
    }
    
    private void createReferrerTable(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS referrer;");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS referrer (referrer TEXT PRIMARY KEY NOT NULL,timestamp_referrer INTEGER NOT NULL,referrer_visit INTEGER NOT NULL DEFAULT 1,referrer_index INTEGER NOT NULL DEFAULT 1);");
    }
    
    private void fixCVTables(SQLiteDatabase paramSQLiteDatabase)
    {
      if (!tablePresent(PersistentHitStore.CREATE_CUSTOM_VAR_VISITOR_CACHE_TABLE, paramSQLiteDatabase)) {
        paramSQLiteDatabase.execSQL(PersistentHitStore.CREATE_CUSTOM_VAR_VISITOR_CACHE_TABLE);
      }
    }
    
    /* Error */
    private void fixReferrerTable(SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: aload_1
      //   1: ldc 70
      //   3: aconst_null
      //   4: aconst_null
      //   5: aconst_null
      //   6: aconst_null
      //   7: aconst_null
      //   8: aconst_null
      //   9: invokevirtual 74	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   12: astore 8
      //   14: aload 8
      //   16: invokeinterface 80 1 0
      //   21: astore 9
      //   23: iconst_0
      //   24: istore_2
      //   25: iconst_0
      //   26: istore 4
      //   28: iconst_0
      //   29: istore_3
      //   30: iload_2
      //   31: aload 9
      //   33: arraylength
      //   34: if_icmpge +383 -> 417
      //   37: aload 9
      //   39: iload_2
      //   40: aaload
      //   41: ldc 82
      //   43: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   46: ifeq +9 -> 55
      //   49: iconst_1
      //   50: istore 5
      //   52: goto +355 -> 407
      //   55: iload_3
      //   56: istore 5
      //   58: aload 9
      //   60: iload_2
      //   61: aaload
      //   62: ldc 90
      //   64: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   67: ifeq +340 -> 407
      //   70: iconst_1
      //   71: istore 4
      //   73: iload_3
      //   74: istore 5
      //   76: goto +331 -> 407
      //   79: aload 8
      //   81: invokeinterface 94 1 0
      //   86: ifeq +315 -> 401
      //   89: aload 8
      //   91: ldc 90
      //   93: invokeinterface 98 2 0
      //   98: istore_2
      //   99: aload 8
      //   101: ldc 82
      //   103: invokeinterface 98 2 0
      //   108: istore_3
      //   109: aload 8
      //   111: aload 8
      //   113: ldc 70
      //   115: invokeinterface 98 2 0
      //   120: invokeinterface 102 2 0
      //   125: astore 9
      //   127: aload 8
      //   129: aload 8
      //   131: ldc 104
      //   133: invokeinterface 98 2 0
      //   138: invokeinterface 108 2 0
      //   143: lstore 6
      //   145: iload_2
      //   146: iconst_m1
      //   147: if_icmpne +142 -> 289
      //   150: iconst_1
      //   151: istore_2
      //   152: goto +277 -> 429
      //   155: new 110	com/google/android/apps/analytics/Referrer
      //   158: dup
      //   159: aload 9
      //   161: lload 6
      //   163: iload_2
      //   164: iload_3
      //   165: invokespecial 113	com/google/android/apps/analytics/Referrer:<init>	(Ljava/lang/String;JII)V
      //   168: astore 9
      //   170: aload_1
      //   171: invokevirtual 117	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
      //   174: aload_0
      //   175: aload_1
      //   176: invokespecial 119	com/google/android/apps/analytics/PersistentHitStore$DataBaseHelper:createReferrerTable	(Landroid/database/sqlite/SQLiteDatabase;)V
      //   179: aload 9
      //   181: ifnull +79 -> 260
      //   184: new 121	android/content/ContentValues
      //   187: dup
      //   188: invokespecial 123	android/content/ContentValues:<init>	()V
      //   191: astore 10
      //   193: aload 10
      //   195: ldc 70
      //   197: aload 9
      //   199: invokevirtual 126	com/google/android/apps/analytics/Referrer:getReferrerString	()Ljava/lang/String;
      //   202: invokevirtual 130	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
      //   205: aload 10
      //   207: ldc 104
      //   209: aload 9
      //   211: invokevirtual 134	com/google/android/apps/analytics/Referrer:getTimeStamp	()J
      //   214: invokestatic 140	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   217: invokevirtual 143	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
      //   220: aload 10
      //   222: ldc 90
      //   224: aload 9
      //   226: invokevirtual 147	com/google/android/apps/analytics/Referrer:getVisit	()I
      //   229: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   232: invokevirtual 155	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   235: aload 10
      //   237: ldc 82
      //   239: aload 9
      //   241: invokevirtual 158	com/google/android/apps/analytics/Referrer:getIndex	()I
      //   244: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   247: invokevirtual 155	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   250: aload_1
      //   251: ldc 70
      //   253: aconst_null
      //   254: aload 10
      //   256: invokevirtual 162	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
      //   259: pop2
      //   260: aload_1
      //   261: invokevirtual 165	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
      //   264: aload 8
      //   266: ifnull +10 -> 276
      //   269: aload 8
      //   271: invokeinterface 168 1 0
      //   276: aload_1
      //   277: invokevirtual 171	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
      //   280: ifeq +8 -> 288
      //   283: aload_1
      //   284: invokestatic 175	com/google/android/apps/analytics/PersistentHitStore:access$1000	(Landroid/database/sqlite/SQLiteDatabase;)Z
      //   287: pop
      //   288: return
      //   289: aload 8
      //   291: iload_2
      //   292: invokeinterface 179 2 0
      //   297: istore_2
      //   298: goto +131 -> 429
      //   301: aload 8
      //   303: iload_3
      //   304: invokeinterface 179 2 0
      //   309: istore_3
      //   310: goto -155 -> 155
      //   313: astore 9
      //   315: aconst_null
      //   316: astore 8
      //   318: ldc -75
      //   320: aload 9
      //   322: invokevirtual 184	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
      //   325: invokestatic 190	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   328: pop
      //   329: aload 8
      //   331: ifnull +10 -> 341
      //   334: aload 8
      //   336: invokeinterface 168 1 0
      //   341: aload_1
      //   342: invokevirtual 171	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
      //   345: ifeq -57 -> 288
      //   348: aload_1
      //   349: invokestatic 175	com/google/android/apps/analytics/PersistentHitStore:access$1000	(Landroid/database/sqlite/SQLiteDatabase;)Z
      //   352: pop
      //   353: return
      //   354: astore 9
      //   356: aconst_null
      //   357: astore 8
      //   359: aload 8
      //   361: ifnull +10 -> 371
      //   364: aload 8
      //   366: invokeinterface 168 1 0
      //   371: aload_1
      //   372: invokevirtual 171	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
      //   375: ifeq +8 -> 383
      //   378: aload_1
      //   379: invokestatic 175	com/google/android/apps/analytics/PersistentHitStore:access$1000	(Landroid/database/sqlite/SQLiteDatabase;)Z
      //   382: pop
      //   383: aload 9
      //   385: athrow
      //   386: astore 9
      //   388: goto -29 -> 359
      //   391: astore 9
      //   393: goto -34 -> 359
      //   396: astore 9
      //   398: goto -80 -> 318
      //   401: aconst_null
      //   402: astore 9
      //   404: goto -234 -> 170
      //   407: iload_2
      //   408: iconst_1
      //   409: iadd
      //   410: istore_2
      //   411: iload 5
      //   413: istore_3
      //   414: goto -384 -> 30
      //   417: iload_3
      //   418: ifeq -339 -> 79
      //   421: iload 4
      //   423: ifne -159 -> 264
      //   426: goto -347 -> 79
      //   429: iload_3
      //   430: iconst_m1
      //   431: if_icmpne -130 -> 301
      //   434: iconst_1
      //   435: istore_3
      //   436: goto -281 -> 155
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	439	0	this	DataBaseHelper
      //   0	439	1	paramSQLiteDatabase	SQLiteDatabase
      //   24	387	2	i	int
      //   29	407	3	j	int
      //   26	396	4	k	int
      //   50	362	5	m	int
      //   143	19	6	l	long
      //   12	353	8	localCursor	Cursor
      //   21	219	9	localObject1	Object
      //   313	8	9	localSQLiteException1	SQLiteException
      //   354	30	9	localObject2	Object
      //   386	1	9	localObject3	Object
      //   391	1	9	localObject4	Object
      //   396	1	9	localSQLiteException2	SQLiteException
      //   402	1	9	localObject5	Object
      //   191	64	10	localContentValues	ContentValues
      // Exception table:
      //   from	to	target	type
      //   0	14	313	android/database/sqlite/SQLiteException
      //   0	14	354	finally
      //   14	23	386	finally
      //   30	49	386	finally
      //   58	70	386	finally
      //   79	145	386	finally
      //   155	170	386	finally
      //   170	179	386	finally
      //   184	260	386	finally
      //   260	264	386	finally
      //   289	298	386	finally
      //   301	310	386	finally
      //   318	329	391	finally
      //   14	23	396	android/database/sqlite/SQLiteException
      //   30	49	396	android/database/sqlite/SQLiteException
      //   58	70	396	android/database/sqlite/SQLiteException
      //   79	145	396	android/database/sqlite/SQLiteException
      //   155	170	396	android/database/sqlite/SQLiteException
      //   170	179	396	android/database/sqlite/SQLiteException
      //   184	260	396	android/database/sqlite/SQLiteException
      //   260	264	396	android/database/sqlite/SQLiteException
      //   289	298	396	android/database/sqlite/SQLiteException
      //   301	310	396	android/database/sqlite/SQLiteException
    }
    
    private void migrateEventsToHits(SQLiteDatabase paramSQLiteDatabase, int paramInt)
    {
      this.store.loadExistingSession(paramSQLiteDatabase);
      PersistentHitStore.access$802(this.store, this.store.getVisitorVarBuffer(paramSQLiteDatabase));
      Event[] arrayOfEvent = this.store.peekEvents(1000, paramSQLiteDatabase, paramInt);
      paramInt = 0;
      while (paramInt < arrayOfEvent.length)
      {
        this.store.putEvent(arrayOfEvent[paramInt], paramSQLiteDatabase, false);
        paramInt += 1;
      }
      paramSQLiteDatabase.execSQL("DELETE from events;");
      paramSQLiteDatabase.execSQL("DELETE from item_events;");
      paramSQLiteDatabase.execSQL("DELETE from transaction_events;");
      paramSQLiteDatabase.execSQL("DELETE from custom_variables;");
    }
    
    /* Error */
    private void migratePreV4Referrer(SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: aload_1
      //   4: ldc -34
      //   6: iconst_1
      //   7: anewarray 84	java/lang/String
      //   10: dup
      //   11: iconst_0
      //   12: ldc 70
      //   14: aastore
      //   15: aconst_null
      //   16: aconst_null
      //   17: aconst_null
      //   18: aconst_null
      //   19: aconst_null
      //   20: invokevirtual 74	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   23: astore 5
      //   25: aload 5
      //   27: astore 4
      //   29: aload 4
      //   31: invokeinterface 94 1 0
      //   36: ifeq +265 -> 301
      //   39: aload 4
      //   41: iconst_0
      //   42: invokeinterface 102 2 0
      //   47: astore 6
      //   49: aload_1
      //   50: ldc -32
      //   52: aconst_null
      //   53: aconst_null
      //   54: aconst_null
      //   55: aconst_null
      //   56: aconst_null
      //   57: aconst_null
      //   58: invokevirtual 74	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   61: astore 5
      //   63: aload 5
      //   65: invokeinterface 94 1 0
      //   70: ifeq +226 -> 296
      //   73: aload 5
      //   75: iconst_0
      //   76: invokeinterface 108 2 0
      //   81: lstore_2
      //   82: new 121	android/content/ContentValues
      //   85: dup
      //   86: invokespecial 123	android/content/ContentValues:<init>	()V
      //   89: astore 7
      //   91: aload 7
      //   93: ldc 70
      //   95: aload 6
      //   97: invokevirtual 130	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
      //   100: aload 7
      //   102: ldc 104
      //   104: lload_2
      //   105: invokestatic 140	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   108: invokevirtual 143	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
      //   111: aload 7
      //   113: ldc 90
      //   115: iconst_1
      //   116: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   119: invokevirtual 155	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   122: aload 7
      //   124: ldc 82
      //   126: iconst_1
      //   127: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   130: invokevirtual 155	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   133: aload_1
      //   134: ldc 70
      //   136: aconst_null
      //   137: aload 7
      //   139: invokevirtual 162	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
      //   142: pop2
      //   143: aload 4
      //   145: ifnull +10 -> 155
      //   148: aload 4
      //   150: invokeinterface 168 1 0
      //   155: aload 5
      //   157: ifnull +10 -> 167
      //   160: aload 5
      //   162: invokeinterface 168 1 0
      //   167: return
      //   168: astore 6
      //   170: aconst_null
      //   171: astore 5
      //   173: aload 4
      //   175: astore_1
      //   176: aload 6
      //   178: astore 4
      //   180: ldc -75
      //   182: aload 4
      //   184: invokevirtual 184	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
      //   187: invokestatic 190	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   190: pop
      //   191: aload_1
      //   192: ifnull +9 -> 201
      //   195: aload_1
      //   196: invokeinterface 168 1 0
      //   201: aload 5
      //   203: ifnull -36 -> 167
      //   206: aload 5
      //   208: invokeinterface 168 1 0
      //   213: return
      //   214: astore_1
      //   215: aconst_null
      //   216: astore 5
      //   218: aconst_null
      //   219: astore 4
      //   221: aload 4
      //   223: ifnull +10 -> 233
      //   226: aload 4
      //   228: invokeinterface 168 1 0
      //   233: aload 5
      //   235: ifnull +10 -> 245
      //   238: aload 5
      //   240: invokeinterface 168 1 0
      //   245: aload_1
      //   246: athrow
      //   247: astore_1
      //   248: aconst_null
      //   249: astore 5
      //   251: goto -30 -> 221
      //   254: astore_1
      //   255: goto -34 -> 221
      //   258: astore 6
      //   260: aload_1
      //   261: astore 4
      //   263: aload 6
      //   265: astore_1
      //   266: goto -45 -> 221
      //   269: astore 6
      //   271: aconst_null
      //   272: astore 5
      //   274: aload 4
      //   276: astore_1
      //   277: aload 6
      //   279: astore 4
      //   281: goto -101 -> 180
      //   284: astore 6
      //   286: aload 4
      //   288: astore_1
      //   289: aload 6
      //   291: astore 4
      //   293: goto -113 -> 180
      //   296: lconst_0
      //   297: lstore_2
      //   298: goto -216 -> 82
      //   301: aconst_null
      //   302: astore 5
      //   304: goto -161 -> 143
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	307	0	this	DataBaseHelper
      //   0	307	1	paramSQLiteDatabase	SQLiteDatabase
      //   81	217	2	l	long
      //   1	291	4	localObject1	Object
      //   23	280	5	localCursor	Cursor
      //   47	49	6	str	String
      //   168	9	6	localSQLiteException1	SQLiteException
      //   258	6	6	localObject2	Object
      //   269	9	6	localSQLiteException2	SQLiteException
      //   284	6	6	localSQLiteException3	SQLiteException
      //   89	49	7	localContentValues	ContentValues
      // Exception table:
      //   from	to	target	type
      //   3	25	168	android/database/sqlite/SQLiteException
      //   3	25	214	finally
      //   29	63	247	finally
      //   63	82	254	finally
      //   82	143	254	finally
      //   180	191	258	finally
      //   29	63	269	android/database/sqlite/SQLiteException
      //   63	82	284	android/database/sqlite/SQLiteException
      //   82	143	284	android/database/sqlite/SQLiteException
    }
    
    private void migrateVisitorLevelCustomVars(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor = paramSQLiteDatabase.query("custom_var_cache", null, "cv_scope= ?", new String[] { Integer.toString(1) }, null, null, null);
      while (localCursor.moveToNext())
      {
        int i = localCursor.getInt(localCursor.getColumnIndex("cv_index"));
        String str1 = localCursor.getString(localCursor.getColumnIndex("cv_name"));
        String str2 = localCursor.getString(localCursor.getColumnIndex("cv_value"));
        if ((i > 0) && (i <= 50))
        {
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("cv_index", Integer.valueOf(i));
          localContentValues.put("cv_name", str1);
          localContentValues.put("cv_value", str2);
          paramSQLiteDatabase.insert("custom_var_visitor_cache", null, localContentValues);
        }
      }
      if (localCursor != null) {
        localCursor.close();
      }
    }
    
    /* Error */
    private boolean tablePresent(String paramString, SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: aload_2
      //   4: ldc -12
      //   6: iconst_1
      //   7: anewarray 84	java/lang/String
      //   10: dup
      //   11: iconst_0
      //   12: ldc -10
      //   14: aastore
      //   15: ldc -8
      //   17: iconst_1
      //   18: anewarray 84	java/lang/String
      //   21: dup
      //   22: iconst_0
      //   23: aload_1
      //   24: aastore
      //   25: aconst_null
      //   26: aconst_null
      //   27: aconst_null
      //   28: invokevirtual 74	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   31: astore_2
      //   32: aload_2
      //   33: invokeinterface 94 1 0
      //   38: istore_3
      //   39: aload_2
      //   40: ifnull +9 -> 49
      //   43: aload_2
      //   44: invokeinterface 168 1 0
      //   49: iload_3
      //   50: ireturn
      //   51: astore_2
      //   52: aconst_null
      //   53: astore_2
      //   54: ldc -75
      //   56: new 250	java/lang/StringBuilder
      //   59: dup
      //   60: invokespecial 251	java/lang/StringBuilder:<init>	()V
      //   63: ldc -3
      //   65: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   68: aload_1
      //   69: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   72: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   75: invokestatic 261	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   78: pop
      //   79: aload_2
      //   80: ifnull +9 -> 89
      //   83: aload_2
      //   84: invokeinterface 168 1 0
      //   89: iconst_0
      //   90: ireturn
      //   91: astore_1
      //   92: aload 4
      //   94: astore_2
      //   95: aload_2
      //   96: ifnull +9 -> 105
      //   99: aload_2
      //   100: invokeinterface 168 1 0
      //   105: aload_1
      //   106: athrow
      //   107: astore_1
      //   108: goto -13 -> 95
      //   111: astore_1
      //   112: goto -17 -> 95
      //   115: astore 4
      //   117: goto -63 -> 54
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	120	0	this	DataBaseHelper
      //   0	120	1	paramString	String
      //   0	120	2	paramSQLiteDatabase	SQLiteDatabase
      //   38	12	3	bool	boolean
      //   1	92	4	localObject	Object
      //   115	1	4	localSQLiteException	SQLiteException
      // Exception table:
      //   from	to	target	type
      //   3	32	51	android/database/sqlite/SQLiteException
      //   3	32	91	finally
      //   32	39	107	finally
      //   54	79	111	finally
      //   32	39	115	android/database/sqlite/SQLiteException
    }
    
    void createCustomVariableTables(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS custom_variables;");
      paramSQLiteDatabase.execSQL(PersistentHitStore.CREATE_CUSTOM_VARIABLES_TABLE);
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS custom_var_cache;");
      paramSQLiteDatabase.execSQL(PersistentHitStore.CREATE_OLD_CUSTOM_VAR_CACHE_TABLE);
      int i = 1;
      while (i <= 5)
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("event_id", Integer.valueOf(0));
        localContentValues.put("cv_index", Integer.valueOf(i));
        localContentValues.put("cv_name", "");
        localContentValues.put("cv_scope", Integer.valueOf(3));
        localContentValues.put("cv_value", "");
        paramSQLiteDatabase.insert("custom_var_cache", "event_id", localContentValues);
        i += 1;
      }
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS custom_var_visitor_cache;");
      paramSQLiteDatabase.execSQL(PersistentHitStore.CREATE_CUSTOM_VAR_VISITOR_CACHE_TABLE);
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS events;");
      paramSQLiteDatabase.execSQL(PersistentHitStore.CREATE_EVENTS_TABLE);
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS install_referrer;");
      paramSQLiteDatabase.execSQL("CREATE TABLE install_referrer (referrer TEXT PRIMARY KEY NOT NULL);");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS session;");
      paramSQLiteDatabase.execSQL(PersistentHitStore.CREATE_SESSION_TABLE);
      if (this.databaseVersion > 1) {
        createCustomVariableTables(paramSQLiteDatabase);
      }
      if (this.databaseVersion > 2) {
        createECommerceTables(paramSQLiteDatabase);
      }
      if (this.databaseVersion > 3)
      {
        createHitTable(paramSQLiteDatabase);
        createReferrerTable(paramSQLiteDatabase);
      }
    }
    
    public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      Log.w("GoogleAnalyticsTracker", "Downgrading database version from " + paramInt1 + " to " + paramInt2 + " not recommended.");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS referrer (referrer TEXT PRIMARY KEY NOT NULL,timestamp_referrer INTEGER NOT NULL,referrer_visit INTEGER NOT NULL DEFAULT 1,referrer_index INTEGER NOT NULL DEFAULT 1);");
      paramSQLiteDatabase.execSQL(PersistentHitStore.CREATE_HITS_TABLE);
      paramSQLiteDatabase.execSQL(PersistentHitStore.CREATE_CUSTOM_VAR_VISITOR_CACHE_TABLE);
      paramSQLiteDatabase.execSQL(PersistentHitStore.CREATE_SESSION_TABLE);
    }
    
    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      if (paramSQLiteDatabase.isReadOnly())
      {
        Log.w("GoogleAnalyticsTracker", "Warning: Need to update database, but it's read only.");
        return;
      }
      fixReferrerTable(paramSQLiteDatabase);
      fixCVTables(paramSQLiteDatabase);
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      if (paramInt1 > paramInt2) {
        onDowngrade(paramSQLiteDatabase, paramInt1, paramInt2);
      }
      do
      {
        return;
        if ((paramInt1 < 2) && (paramInt2 > 1)) {
          createCustomVariableTables(paramSQLiteDatabase);
        }
        if ((paramInt1 < 3) && (paramInt2 > 2)) {
          createECommerceTables(paramSQLiteDatabase);
        }
        if ((paramInt1 < 4) && (paramInt2 > 3))
        {
          createHitTable(paramSQLiteDatabase);
          createReferrerTable(paramSQLiteDatabase);
          migrateEventsToHits(paramSQLiteDatabase, paramInt1);
          migratePreV4Referrer(paramSQLiteDatabase);
        }
      } while ((paramInt1 >= 6) || (paramInt2 <= 5));
      paramSQLiteDatabase.execSQL(PersistentHitStore.CREATE_CUSTOM_VAR_VISITOR_CACHE_TABLE);
      migrateVisitorLevelCustomVars(paramSQLiteDatabase);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/android/apps/analytics/PersistentHitStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */