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
  private static final String CREATE_CUSTOM_VAR_CACHE_TABLE;
  private static final String CREATE_EVENTS_TABLE = "CREATE TABLE events (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[] { "event_id" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "user_id" }) + String.format(" '%s' CHAR(256) NOT NULL,", new Object[] { "account_id" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "random_val" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "timestamp_first" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "timestamp_previous" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "timestamp_current" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "visits" }) + String.format(" '%s' CHAR(256) NOT NULL,", new Object[] { "category" }) + String.format(" '%s' CHAR(256) NOT NULL,", new Object[] { "action" }) + String.format(" '%s' CHAR(256), ", new Object[] { "label" }) + String.format(" '%s' INTEGER,", new Object[] { "value" }) + String.format(" '%s' INTEGER,", new Object[] { "screen_width" }) + String.format(" '%s' INTEGER);", new Object[] { "screen_height" });
  private static final String CREATE_HITS_TABLE = "CREATE TABLE IF NOT EXISTS hits (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[] { "hit_id" }) + String.format(" '%s' TEXT NOT NULL,", new Object[] { "hit_string" }) + String.format(" '%s' INTEGER NOT NULL);", new Object[] { "hit_time" });
  private static final String CREATE_INSTALL_REFERRER_TABLE = "CREATE TABLE install_referrer (referrer TEXT PRIMARY KEY NOT NULL);";
  private static final String CREATE_ITEM_EVENTS_TABLE;
  private static final String CREATE_REFERRER_TABLE = "CREATE TABLE IF NOT EXISTS referrer (referrer TEXT PRIMARY KEY NOT NULL,timestamp_referrer INTEGER NOT NULL,referrer_visit INTEGER NOT NULL DEFAULT 1,referrer_index INTEGER NOT NULL DEFAULT 1);";
  private static final String CREATE_SESSION_TABLE = "CREATE TABLE IF NOT EXISTS session (" + String.format(" '%s' INTEGER PRIMARY KEY,", new Object[] { "timestamp_first" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "timestamp_previous" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "timestamp_current" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "visits" }) + String.format(" '%s' INTEGER NOT NULL);", new Object[] { "store_id" });
  private static final String CREATE_TRANSACTION_EVENTS_TABLE;
  private static final String CUSTOMVAR_ID = "cv_id";
  private static final String CUSTOMVAR_INDEX = "cv_index";
  private static final String CUSTOMVAR_NAME = "cv_name";
  private static final String CUSTOMVAR_SCOPE = "cv_scope";
  private static final String CUSTOMVAR_VALUE = "cv_value";
  private static final String CUSTOM_VARIABLE_COLUMN_TYPE = "CHAR(64) NOT NULL";
  private static final String DATABASE_NAME = "google_analytics.db";
  private static final int DATABASE_VERSION = 5;
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
    CREATE_CUSTOM_VAR_CACHE_TABLE = "CREATE TABLE IF NOT EXISTS custom_var_cache (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[] { "cv_id" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "event_id" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "cv_index" }) + String.format(" '%s' CHAR(64) NOT NULL,", new Object[] { "cv_name" }) + String.format(" '%s' CHAR(64) NOT NULL,", new Object[] { "cv_value" }) + String.format(" '%s' INTEGER NOT NULL);", new Object[] { "cv_scope" });
    CREATE_TRANSACTION_EVENTS_TABLE = "CREATE TABLE transaction_events (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[] { "tran_id" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "event_id" }) + String.format(" '%s' TEXT NOT NULL,", new Object[] { "order_id" }) + String.format(" '%s' TEXT,", new Object[] { "tran_storename" }) + String.format(" '%s' TEXT NOT NULL,", new Object[] { "tran_totalcost" }) + String.format(" '%s' TEXT,", new Object[] { "tran_totaltax" }) + String.format(" '%s' TEXT);", new Object[] { "tran_shippingcost" });
    CREATE_ITEM_EVENTS_TABLE = "CREATE TABLE item_events (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[] { "item_id" }) + String.format(" '%s' INTEGER NOT NULL,", new Object[] { "event_id" }) + String.format(" '%s' TEXT NOT NULL,", new Object[] { "order_id" }) + String.format(" '%s' TEXT NOT NULL,", new Object[] { "item_sku" }) + String.format(" '%s' TEXT,", new Object[] { "item_name" }) + String.format(" '%s' TEXT,", new Object[] { "item_category" }) + String.format(" '%s' TEXT NOT NULL,", new Object[] { "item_price" }) + String.format(" '%s' TEXT NOT NULL);", new Object[] { "item_count" });
  }
  
  PersistentHitStore(Context paramContext)
  {
    this(paramContext, "google_analytics.db", 5);
  }
  
  PersistentHitStore(Context paramContext, String paramString)
  {
    this(paramContext, paramString, 5);
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
    //   0: new 546	com/google/android/apps/analytics/CustomVariableBuffer
    //   3: dup
    //   4: invokespecial 547	com/google/android/apps/analytics/CustomVariableBuffer:<init>	()V
    //   7: astore 6
    //   9: aload_3
    //   10: ldc_w 549
    //   13: aconst_null
    //   14: ldc_w 551
    //   17: iconst_1
    //   18: anewarray 186	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: lload_1
    //   24: invokestatic 542	java/lang/Long:toString	(J)Ljava/lang/String;
    //   27: aastore
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: invokevirtual 555	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore 4
    //   36: aload 4
    //   38: astore_3
    //   39: aload 4
    //   41: invokeinterface 560 1 0
    //   46: ifeq +117 -> 163
    //   49: aload 4
    //   51: astore_3
    //   52: aload 6
    //   54: new 562	com/google/android/apps/analytics/CustomVariable
    //   57: dup
    //   58: aload 4
    //   60: aload 4
    //   62: ldc 38
    //   64: invokeinterface 566 2 0
    //   69: invokeinterface 569 2 0
    //   74: aload 4
    //   76: aload 4
    //   78: ldc 41
    //   80: invokeinterface 566 2 0
    //   85: invokeinterface 573 2 0
    //   90: aload 4
    //   92: aload 4
    //   94: ldc 47
    //   96: invokeinterface 566 2 0
    //   101: invokeinterface 573 2 0
    //   106: aload 4
    //   108: aload 4
    //   110: ldc 44
    //   112: invokeinterface 566 2 0
    //   117: invokeinterface 569 2 0
    //   122: invokespecial 576	com/google/android/apps/analytics/CustomVariable:<init>	(ILjava/lang/String;Ljava/lang/String;I)V
    //   125: invokevirtual 580	com/google/android/apps/analytics/CustomVariableBuffer:setCustomVariable	(Lcom/google/android/apps/analytics/CustomVariable;)V
    //   128: goto -92 -> 36
    //   131: astore 5
    //   133: aload 4
    //   135: astore_3
    //   136: ldc_w 301
    //   139: aload 5
    //   141: invokevirtual 304	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   144: invokestatic 310	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   147: pop
    //   148: aload 4
    //   150: ifnull +10 -> 160
    //   153: aload 4
    //   155: invokeinterface 583 1 0
    //   160: aload 6
    //   162: areturn
    //   163: aload 4
    //   165: ifnull -5 -> 160
    //   168: aload 4
    //   170: invokeinterface 583 1 0
    //   175: aload 6
    //   177: areturn
    //   178: astore 4
    //   180: aconst_null
    //   181: astore_3
    //   182: aload_3
    //   183: ifnull +9 -> 192
    //   186: aload_3
    //   187: invokeinterface 583 1 0
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
    //   1: ldc_w 589
    //   4: aconst_null
    //   5: ldc_w 551
    //   8: iconst_1
    //   9: anewarray 186	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: lload_1
    //   15: invokestatic 542	java/lang/Long:toString	(J)Ljava/lang/String;
    //   18: aastore
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: invokevirtual 555	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore_3
    //   26: aload_3
    //   27: invokeinterface 592 1 0
    //   32: ifeq +118 -> 150
    //   35: new 594	com/google/android/apps/analytics/Item$Builder
    //   38: dup
    //   39: aload_3
    //   40: aload_3
    //   41: ldc 94
    //   43: invokeinterface 566 2 0
    //   48: invokeinterface 573 2 0
    //   53: aload_3
    //   54: aload_3
    //   55: ldc 86
    //   57: invokeinterface 566 2 0
    //   62: invokeinterface 573 2 0
    //   67: aload_3
    //   68: aload_3
    //   69: ldc 83
    //   71: invokeinterface 566 2 0
    //   76: invokeinterface 598 2 0
    //   81: aload_3
    //   82: aload_3
    //   83: ldc 74
    //   85: invokeinterface 566 2 0
    //   90: invokeinterface 602 2 0
    //   95: invokespecial 605	com/google/android/apps/analytics/Item$Builder:<init>	(Ljava/lang/String;Ljava/lang/String;DJ)V
    //   98: aload_3
    //   99: aload_3
    //   100: ldc 80
    //   102: invokeinterface 566 2 0
    //   107: invokeinterface 573 2 0
    //   112: invokevirtual 609	com/google/android/apps/analytics/Item$Builder:setItemName	(Ljava/lang/String;)Lcom/google/android/apps/analytics/Item$Builder;
    //   115: aload_3
    //   116: aload_3
    //   117: ldc 71
    //   119: invokeinterface 566 2 0
    //   124: invokeinterface 573 2 0
    //   129: invokevirtual 612	com/google/android/apps/analytics/Item$Builder:setItemCategory	(Ljava/lang/String;)Lcom/google/android/apps/analytics/Item$Builder;
    //   132: invokevirtual 616	com/google/android/apps/analytics/Item$Builder:build	()Lcom/google/android/apps/analytics/Item;
    //   135: astore 4
    //   137: aload_3
    //   138: ifnull +9 -> 147
    //   141: aload_3
    //   142: invokeinterface 583 1 0
    //   147: aload 4
    //   149: areturn
    //   150: aload_3
    //   151: ifnull +9 -> 160
    //   154: aload_3
    //   155: invokeinterface 583 1 0
    //   160: aconst_null
    //   161: areturn
    //   162: astore 4
    //   164: aconst_null
    //   165: astore_3
    //   166: ldc_w 301
    //   169: aload 4
    //   171: invokevirtual 304	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   174: invokestatic 310	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   177: pop
    //   178: aload_3
    //   179: ifnull -19 -> 160
    //   182: aload_3
    //   183: invokeinterface 583 1 0
    //   188: goto -28 -> 160
    //   191: astore 4
    //   193: aconst_null
    //   194: astore_3
    //   195: aload_3
    //   196: ifnull +9 -> 205
    //   199: aload_3
    //   200: invokeinterface 583 1 0
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
    //   1: ldc_w 642
    //   4: aconst_null
    //   5: ldc_w 551
    //   8: iconst_1
    //   9: anewarray 186	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: lload_1
    //   15: invokestatic 542	java/lang/Long:toString	(J)Ljava/lang/String;
    //   18: aastore
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: invokevirtual 555	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore 4
    //   27: aload 4
    //   29: astore_3
    //   30: aload 4
    //   32: invokeinterface 592 1 0
    //   37: ifeq +122 -> 159
    //   40: aload 4
    //   42: astore_3
    //   43: new 644	com/google/android/apps/analytics/Transaction$Builder
    //   46: dup
    //   47: aload 4
    //   49: aload 4
    //   51: ldc 94
    //   53: invokeinterface 566 2 0
    //   58: invokeinterface 573 2 0
    //   63: aload 4
    //   65: aload 4
    //   67: ldc -119
    //   69: invokeinterface 566 2 0
    //   74: invokeinterface 598 2 0
    //   79: invokespecial 647	com/google/android/apps/analytics/Transaction$Builder:<init>	(Ljava/lang/String;D)V
    //   82: aload 4
    //   84: aload 4
    //   86: ldc 122
    //   88: invokeinterface 566 2 0
    //   93: invokeinterface 573 2 0
    //   98: invokevirtual 651	com/google/android/apps/analytics/Transaction$Builder:setStoreName	(Ljava/lang/String;)Lcom/google/android/apps/analytics/Transaction$Builder;
    //   101: aload 4
    //   103: aload 4
    //   105: ldc -116
    //   107: invokeinterface 566 2 0
    //   112: invokeinterface 598 2 0
    //   117: invokevirtual 655	com/google/android/apps/analytics/Transaction$Builder:setTotalTax	(D)Lcom/google/android/apps/analytics/Transaction$Builder;
    //   120: aload 4
    //   122: aload 4
    //   124: ldc 116
    //   126: invokeinterface 566 2 0
    //   131: invokeinterface 598 2 0
    //   136: invokevirtual 658	com/google/android/apps/analytics/Transaction$Builder:setShippingCost	(D)Lcom/google/android/apps/analytics/Transaction$Builder;
    //   139: invokevirtual 661	com/google/android/apps/analytics/Transaction$Builder:build	()Lcom/google/android/apps/analytics/Transaction;
    //   142: astore 5
    //   144: aload 4
    //   146: ifnull +10 -> 156
    //   149: aload 4
    //   151: invokeinterface 583 1 0
    //   156: aload 5
    //   158: areturn
    //   159: aload 4
    //   161: ifnull +10 -> 171
    //   164: aload 4
    //   166: invokeinterface 583 1 0
    //   171: aconst_null
    //   172: areturn
    //   173: astore 5
    //   175: aconst_null
    //   176: astore 4
    //   178: aload 4
    //   180: astore_3
    //   181: ldc_w 301
    //   184: aload 5
    //   186: invokevirtual 304	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   189: invokestatic 310	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   192: pop
    //   193: aload 4
    //   195: ifnull -24 -> 171
    //   198: aload 4
    //   200: invokeinterface 583 1 0
    //   205: goto -34 -> 171
    //   208: astore 4
    //   210: aconst_null
    //   211: astore_3
    //   212: aload_3
    //   213: ifnull +9 -> 222
    //   216: aload_3
    //   217: invokeinterface 583 1 0
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
    //   0: new 546	com/google/android/apps/analytics/CustomVariableBuffer
    //   3: dup
    //   4: invokespecial 547	com/google/android/apps/analytics/CustomVariableBuffer:<init>	()V
    //   7: astore 4
    //   9: aload_1
    //   10: ldc_w 680
    //   13: aconst_null
    //   14: ldc_w 682
    //   17: iconst_1
    //   18: anewarray 186	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: iconst_1
    //   24: invokestatic 634	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   27: aastore
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: invokevirtual 555	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore_2
    //   35: aload_2
    //   36: astore_1
    //   37: aload_2
    //   38: invokeinterface 560 1 0
    //   43: ifeq +103 -> 146
    //   46: aload_2
    //   47: astore_1
    //   48: aload 4
    //   50: new 562	com/google/android/apps/analytics/CustomVariable
    //   53: dup
    //   54: aload_2
    //   55: aload_2
    //   56: ldc 38
    //   58: invokeinterface 566 2 0
    //   63: invokeinterface 569 2 0
    //   68: aload_2
    //   69: aload_2
    //   70: ldc 41
    //   72: invokeinterface 566 2 0
    //   77: invokeinterface 573 2 0
    //   82: aload_2
    //   83: aload_2
    //   84: ldc 47
    //   86: invokeinterface 566 2 0
    //   91: invokeinterface 573 2 0
    //   96: aload_2
    //   97: aload_2
    //   98: ldc 44
    //   100: invokeinterface 566 2 0
    //   105: invokeinterface 569 2 0
    //   110: invokespecial 576	com/google/android/apps/analytics/CustomVariable:<init>	(ILjava/lang/String;Ljava/lang/String;I)V
    //   113: invokevirtual 580	com/google/android/apps/analytics/CustomVariableBuffer:setCustomVariable	(Lcom/google/android/apps/analytics/CustomVariable;)V
    //   116: goto -81 -> 35
    //   119: astore_3
    //   120: aload_2
    //   121: astore_1
    //   122: ldc_w 301
    //   125: aload_3
    //   126: invokevirtual 304	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   129: invokestatic 310	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   132: pop
    //   133: aload_2
    //   134: ifnull +9 -> 143
    //   137: aload_2
    //   138: invokeinterface 583 1 0
    //   143: aload 4
    //   145: areturn
    //   146: aload_2
    //   147: ifnull -4 -> 143
    //   150: aload_2
    //   151: invokeinterface 583 1 0
    //   156: aload 4
    //   158: areturn
    //   159: astore_2
    //   160: aconst_null
    //   161: astore_1
    //   162: aload_1
    //   163: ifnull +9 -> 172
    //   166: aload_1
    //   167: invokeinterface 583 1 0
    //   172: aload_2
    //   173: athrow
    //   174: astore_2
    //   175: goto -13 -> 162
    //   178: astore_3
    //   179: aconst_null
    //   180: astore_2
    //   181: goto -61 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	PersistentHitStore
    //   0	184	1	paramSQLiteDatabase	SQLiteDatabase
    //   34	117	2	localCursor	Cursor
    //   159	14	2	localObject1	Object
    //   174	1	2	localObject2	Object
    //   180	1	2	localObject3	Object
    //   119	7	3	localSQLiteException1	SQLiteException
    //   178	1	3	localSQLiteException2	SQLiteException
    //   7	150	4	localCustomVariableBuffer	CustomVariableBuffer
    // Exception table:
    //   from	to	target	type
    //   37	46	119	android/database/sqlite/SQLiteException
    //   48	116	119	android/database/sqlite/SQLiteException
    //   9	35	159	finally
    //   37	46	174	finally
    //   48	116	174	finally
    //   122	133	174	finally
    //   9	35	178	android/database/sqlite/SQLiteException
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
    //   1: ldc_w 688
    //   4: aconst_null
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: aconst_null
    //   9: aconst_null
    //   10: invokevirtual 555	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   13: astore_3
    //   14: aload_3
    //   15: astore 4
    //   17: aload_3
    //   18: invokeinterface 592 1 0
    //   23: ifeq +137 -> 160
    //   26: aload_3
    //   27: astore 4
    //   29: aload_0
    //   30: aload_3
    //   31: iconst_0
    //   32: invokeinterface 602 2 0
    //   37: putfield 459	com/google/android/apps/analytics/PersistentHitStore:timestampFirst	J
    //   40: aload_3
    //   41: astore 4
    //   43: aload_0
    //   44: aload_3
    //   45: iconst_1
    //   46: invokeinterface 602 2 0
    //   51: putfield 464	com/google/android/apps/analytics/PersistentHitStore:timestampPrevious	J
    //   54: aload_3
    //   55: astore 4
    //   57: aload_0
    //   58: aload_3
    //   59: iconst_2
    //   60: invokeinterface 602 2 0
    //   65: putfield 416	com/google/android/apps/analytics/PersistentHitStore:timestampCurrent	J
    //   68: aload_3
    //   69: astore 4
    //   71: aload_0
    //   72: aload_3
    //   73: iconst_3
    //   74: invokeinterface 569 2 0
    //   79: putfield 427	com/google/android/apps/analytics/PersistentHitStore:visits	I
    //   82: aload_3
    //   83: astore 4
    //   85: aload_0
    //   86: aload_3
    //   87: iconst_4
    //   88: invokeinterface 569 2 0
    //   93: putfield 484	com/google/android/apps/analytics/PersistentHitStore:storeId	I
    //   96: aload_3
    //   97: astore 4
    //   99: aload_0
    //   100: aload_1
    //   101: invokevirtual 394	com/google/android/apps/analytics/PersistentHitStore:readCurrentReferrer	(Landroid/database/sqlite/SQLiteDatabase;)Lcom/google/android/apps/analytics/Referrer;
    //   104: astore_1
    //   105: aload_3
    //   106: astore 4
    //   108: aload_0
    //   109: getfield 459	com/google/android/apps/analytics/PersistentHitStore:timestampFirst	J
    //   112: lconst_0
    //   113: lcmp
    //   114: ifeq +41 -> 155
    //   117: aload_1
    //   118: ifnull +218 -> 336
    //   121: aload_3
    //   122: astore 4
    //   124: aload_1
    //   125: invokevirtual 400	com/google/android/apps/analytics/Referrer:getTimeStamp	()J
    //   128: lconst_0
    //   129: lcmp
    //   130: ifeq +25 -> 155
    //   133: goto +203 -> 336
    //   136: aload_3
    //   137: astore 4
    //   139: aload_0
    //   140: iload_2
    //   141: putfield 632	com/google/android/apps/analytics/PersistentHitStore:sessionStarted	Z
    //   144: aload_3
    //   145: ifnull +9 -> 154
    //   148: aload_3
    //   149: invokeinterface 583 1 0
    //   154: return
    //   155: iconst_0
    //   156: istore_2
    //   157: goto -21 -> 136
    //   160: aload_3
    //   161: astore 4
    //   163: aload_0
    //   164: iconst_0
    //   165: putfield 632	com/google/android/apps/analytics/PersistentHitStore:sessionStarted	Z
    //   168: aload_3
    //   169: astore 4
    //   171: aload_0
    //   172: iconst_1
    //   173: putfield 690	com/google/android/apps/analytics/PersistentHitStore:useStoredVisitorVars	Z
    //   176: aload_3
    //   177: astore 4
    //   179: aload_0
    //   180: new 692	java/security/SecureRandom
    //   183: dup
    //   184: invokespecial 693	java/security/SecureRandom:<init>	()V
    //   187: invokevirtual 695	java/security/SecureRandom:nextInt	()I
    //   190: ldc_w 449
    //   193: iand
    //   194: putfield 484	com/google/android/apps/analytics/PersistentHitStore:storeId	I
    //   197: aload_3
    //   198: astore 4
    //   200: aload_3
    //   201: invokeinterface 583 1 0
    //   206: new 409	android/content/ContentValues
    //   209: dup
    //   210: invokespecial 410	android/content/ContentValues:<init>	()V
    //   213: astore_3
    //   214: aload_3
    //   215: ldc -128
    //   217: lconst_0
    //   218: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   221: invokevirtual 425	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   224: aload_3
    //   225: ldc -125
    //   227: lconst_0
    //   228: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   231: invokevirtual 425	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   234: aload_3
    //   235: ldc 125
    //   237: lconst_0
    //   238: invokestatic 422	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   241: invokevirtual 425	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   244: aload_3
    //   245: ldc -104
    //   247: iconst_0
    //   248: invokestatic 432	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: invokevirtual 435	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   254: aload_3
    //   255: ldc 119
    //   257: aload_0
    //   258: getfield 484	com/google/android/apps/analytics/PersistentHitStore:storeId	I
    //   261: invokestatic 432	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   264: invokevirtual 435	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   267: aload_1
    //   268: ldc_w 688
    //   271: aconst_null
    //   272: aload_3
    //   273: invokevirtual 520	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   276: pop2
    //   277: aconst_null
    //   278: astore_3
    //   279: goto -135 -> 144
    //   282: astore_1
    //   283: aconst_null
    //   284: astore_3
    //   285: aload_3
    //   286: astore 4
    //   288: ldc_w 301
    //   291: aload_1
    //   292: invokevirtual 304	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   295: invokestatic 310	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   298: pop
    //   299: aload_3
    //   300: ifnull -146 -> 154
    //   303: aload_3
    //   304: invokeinterface 583 1 0
    //   309: return
    //   310: astore_1
    //   311: aconst_null
    //   312: astore 4
    //   314: aload 4
    //   316: ifnull +10 -> 326
    //   319: aload 4
    //   321: invokeinterface 583 1 0
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
    //   0: new 699	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 700	java/util/ArrayList:<init>	()V
    //   7: astore 8
    //   9: aload_2
    //   10: ldc_w 702
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: ldc 59
    //   20: iload_1
    //   21: invokestatic 634	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   24: invokevirtual 705	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore 6
    //   29: aload 6
    //   31: invokeinterface 560 1 0
    //   36: ifeq +384 -> 420
    //   39: new 444	com/google/android/apps/analytics/Event
    //   42: dup
    //   43: aload 6
    //   45: iconst_0
    //   46: invokeinterface 602 2 0
    //   51: aload 6
    //   53: iconst_2
    //   54: invokeinterface 573 2 0
    //   59: aload 6
    //   61: iconst_3
    //   62: invokeinterface 569 2 0
    //   67: aload 6
    //   69: iconst_4
    //   70: invokeinterface 569 2 0
    //   75: aload 6
    //   77: iconst_5
    //   78: invokeinterface 569 2 0
    //   83: aload 6
    //   85: bipush 6
    //   87: invokeinterface 569 2 0
    //   92: aload 6
    //   94: bipush 7
    //   96: invokeinterface 569 2 0
    //   101: aload 6
    //   103: bipush 8
    //   105: invokeinterface 573 2 0
    //   110: aload 6
    //   112: bipush 9
    //   114: invokeinterface 573 2 0
    //   119: aload 6
    //   121: bipush 10
    //   123: invokeinterface 573 2 0
    //   128: aload 6
    //   130: bipush 11
    //   132: invokeinterface 569 2 0
    //   137: aload 6
    //   139: bipush 12
    //   141: invokeinterface 569 2 0
    //   146: aload 6
    //   148: bipush 13
    //   150: invokeinterface 569 2 0
    //   155: invokespecial 708	com/google/android/apps/analytics/Event:<init>	(JLjava/lang/String;IIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V
    //   158: astore 9
    //   160: aload 9
    //   162: aload 6
    //   164: iconst_1
    //   165: invokeinterface 569 2 0
    //   170: invokevirtual 487	com/google/android/apps/analytics/Event:setUserId	(I)V
    //   173: aload 6
    //   175: aload 6
    //   177: ldc 59
    //   179: invokeinterface 566 2 0
    //   184: invokeinterface 602 2 0
    //   189: lstore 4
    //   191: ldc_w 710
    //   194: aload 9
    //   196: getfield 712	com/google/android/apps/analytics/Event:category	Ljava/lang/String;
    //   199: invokevirtual 716	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   202: ifeq +101 -> 303
    //   205: aload_0
    //   206: lload 4
    //   208: aload_2
    //   209: invokevirtual 718	com/google/android/apps/analytics/PersistentHitStore:getTransaction	(JLandroid/database/sqlite/SQLiteDatabase;)Lcom/google/android/apps/analytics/Transaction;
    //   212: astore 7
    //   214: aload 7
    //   216: ifnonnull +31 -> 247
    //   219: ldc_w 301
    //   222: new 173	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 720
    //   232: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: lload 4
    //   237: invokevirtual 723	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   240: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 345	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   246: pop
    //   247: aload 9
    //   249: aload 7
    //   251: invokevirtual 727	com/google/android/apps/analytics/Event:setTransaction	(Lcom/google/android/apps/analytics/Transaction;)V
    //   254: aload 8
    //   256: aload 9
    //   258: invokeinterface 732 2 0
    //   263: pop
    //   264: goto -235 -> 29
    //   267: astore 7
    //   269: aload 6
    //   271: astore_2
    //   272: aload 7
    //   274: astore 6
    //   276: ldc_w 301
    //   279: aload 6
    //   281: invokevirtual 304	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   284: invokestatic 310	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   287: pop
    //   288: aload_2
    //   289: ifnull +9 -> 298
    //   292: aload_2
    //   293: invokeinterface 583 1 0
    //   298: iconst_0
    //   299: anewarray 444	com/google/android/apps/analytics/Event
    //   302: areturn
    //   303: ldc_w 734
    //   306: aload 9
    //   308: getfield 712	com/google/android/apps/analytics/Event:category	Ljava/lang/String;
    //   311: invokevirtual 716	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   314: ifeq +70 -> 384
    //   317: aload_0
    //   318: lload 4
    //   320: aload_2
    //   321: invokevirtual 736	com/google/android/apps/analytics/PersistentHitStore:getItem	(JLandroid/database/sqlite/SQLiteDatabase;)Lcom/google/android/apps/analytics/Item;
    //   324: astore 7
    //   326: aload 7
    //   328: ifnonnull +31 -> 359
    //   331: ldc_w 301
    //   334: new 173	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   341: ldc_w 738
    //   344: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: lload 4
    //   349: invokevirtual 723	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   352: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokestatic 345	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   358: pop
    //   359: aload 9
    //   361: aload 7
    //   363: invokevirtual 742	com/google/android/apps/analytics/Event:setItem	(Lcom/google/android/apps/analytics/Item;)V
    //   366: goto -112 -> 254
    //   369: astore_2
    //   370: aload 6
    //   372: ifnull +10 -> 382
    //   375: aload 6
    //   377: invokeinterface 583 1 0
    //   382: aload_2
    //   383: athrow
    //   384: iload_3
    //   385: iconst_1
    //   386: if_icmple +22 -> 408
    //   389: aload_0
    //   390: lload 4
    //   392: aload_2
    //   393: invokevirtual 744	com/google/android/apps/analytics/PersistentHitStore:getCustomVariables	(JLandroid/database/sqlite/SQLiteDatabase;)Lcom/google/android/apps/analytics/CustomVariableBuffer;
    //   396: astore 7
    //   398: aload 9
    //   400: aload 7
    //   402: invokevirtual 748	com/google/android/apps/analytics/Event:setCustomVariableBuffer	(Lcom/google/android/apps/analytics/CustomVariableBuffer;)V
    //   405: goto -151 -> 254
    //   408: new 546	com/google/android/apps/analytics/CustomVariableBuffer
    //   411: dup
    //   412: invokespecial 547	com/google/android/apps/analytics/CustomVariableBuffer:<init>	()V
    //   415: astore 7
    //   417: goto -19 -> 398
    //   420: aload 6
    //   422: ifnull +10 -> 432
    //   425: aload 6
    //   427: invokeinterface 583 1 0
    //   432: aload 8
    //   434: aload 8
    //   436: invokeinterface 751 1 0
    //   441: anewarray 444	com/google/android/apps/analytics/Event
    //   444: invokeinterface 755 2 0
    //   449: checkcast 757	[Lcom/google/android/apps/analytics/Event;
    //   452: areturn
    //   453: astore_2
    //   454: aconst_null
    //   455: astore 6
    //   457: goto -87 -> 370
    //   460: astore 7
    //   462: aload_2
    //   463: astore 6
    //   465: aload 7
    //   467: astore_2
    //   468: goto -98 -> 370
    //   471: astore 6
    //   473: aconst_null
    //   474: astore_2
    //   475: goto -199 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	this	PersistentHitStore
    //   0	478	1	paramInt1	int
    //   0	478	2	paramSQLiteDatabase	SQLiteDatabase
    //   0	478	3	paramInt2	int
    //   189	202	4	l	long
    //   27	437	6	localObject1	Object
    //   471	1	6	localSQLiteException1	SQLiteException
    //   212	38	7	localTransaction	Transaction
    //   267	6	7	localSQLiteException2	SQLiteException
    //   324	92	7	localObject2	Object
    //   460	6	7	localObject3	Object
    //   7	428	8	localArrayList	java.util.ArrayList
    //   158	241	9	localEvent	Event
    // Exception table:
    //   from	to	target	type
    //   29	214	267	android/database/sqlite/SQLiteException
    //   219	247	267	android/database/sqlite/SQLiteException
    //   247	254	267	android/database/sqlite/SQLiteException
    //   254	264	267	android/database/sqlite/SQLiteException
    //   303	326	267	android/database/sqlite/SQLiteException
    //   331	359	267	android/database/sqlite/SQLiteException
    //   359	366	267	android/database/sqlite/SQLiteException
    //   389	398	267	android/database/sqlite/SQLiteException
    //   398	405	267	android/database/sqlite/SQLiteException
    //   408	417	267	android/database/sqlite/SQLiteException
    //   29	214	369	finally
    //   219	247	369	finally
    //   247	254	369	finally
    //   254	264	369	finally
    //   303	326	369	finally
    //   331	359	369	finally
    //   359	366	369	finally
    //   389	398	369	finally
    //   398	405	369	finally
    //   408	417	369	finally
    //   9	29	453	finally
    //   276	288	460	finally
    //   9	29	471	android/database/sqlite/SQLiteException
  }
  
  public Hit[] peekHits()
  {
    return peekHits(1000);
  }
  
  /* Error */
  public Hit[] peekHits(int paramInt)
  {
    // Byte code:
    //   0: new 699	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 700	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 263	com/google/android/apps/analytics/PersistentHitStore:databaseHelper	Lcom/google/android/apps/analytics/PersistentHitStore$DataBaseHelper;
    //   13: invokevirtual 621	com/google/android/apps/analytics/PersistentHitStore$DataBaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: ldc_w 537
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: ldc 62
    //   26: iload_1
    //   27: invokestatic 634	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   30: invokevirtual 705	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore_3
    //   34: aload_3
    //   35: astore_2
    //   36: aload_3
    //   37: invokeinterface 560 1 0
    //   42: ifeq +68 -> 110
    //   45: aload_3
    //   46: astore_2
    //   47: aload 4
    //   49: new 764	com/google/android/apps/analytics/Hit
    //   52: dup
    //   53: aload_3
    //   54: iconst_1
    //   55: invokeinterface 573 2 0
    //   60: aload_3
    //   61: iconst_0
    //   62: invokeinterface 602 2 0
    //   67: invokespecial 767	com/google/android/apps/analytics/Hit:<init>	(Ljava/lang/String;J)V
    //   70: invokeinterface 732 2 0
    //   75: pop
    //   76: goto -42 -> 34
    //   79: astore 4
    //   81: aload_3
    //   82: astore_2
    //   83: ldc_w 301
    //   86: aload 4
    //   88: invokevirtual 304	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   91: invokestatic 310	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   94: pop
    //   95: aload_3
    //   96: ifnull +9 -> 105
    //   99: aload_3
    //   100: invokeinterface 583 1 0
    //   105: iconst_0
    //   106: anewarray 764	com/google/android/apps/analytics/Hit
    //   109: areturn
    //   110: aload_3
    //   111: ifnull +9 -> 120
    //   114: aload_3
    //   115: invokeinterface 583 1 0
    //   120: aload 4
    //   122: aload 4
    //   124: invokeinterface 751 1 0
    //   129: anewarray 764	com/google/android/apps/analytics/Hit
    //   132: invokeinterface 755 2 0
    //   137: checkcast 769	[Lcom/google/android/apps/analytics/Hit;
    //   140: areturn
    //   141: astore_3
    //   142: aconst_null
    //   143: astore_2
    //   144: aload_2
    //   145: ifnull +9 -> 154
    //   148: aload_2
    //   149: invokeinterface 583 1 0
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
    label67:
    label289:
    label295:
    label307:
    label316:
    label321:
    for (;;)
    {
      return;
      Object localObject2;
      int i;
      try
      {
        localObject2 = paramEvent.getCustomVariableBuffer();
        if (!this.useStoredVisitorVars) {
          break label289;
        }
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label295;
        }
        localObject1 = new CustomVariableBuffer();
        paramEvent.setCustomVariableBuffer((CustomVariableBuffer)localObject1);
      }
      catch (SQLiteException paramEvent)
      {
        Object localObject1;
        Log.e("GoogleAnalyticsTracker", paramEvent.toString());
        return;
      }
      if (i <= 5)
      {
        paramEvent = this.visitorCVCache.getCustomVariableAt(i);
        localObject2 = ((CustomVariableBuffer)localObject1).getCustomVariableAt(i);
        if ((paramEvent != null) && (localObject2 == null)) {
          ((CustomVariableBuffer)localObject1).setCustomVariable(paramEvent);
        }
      }
      else
      {
        this.useStoredVisitorVars = false;
        paramEvent = (Event)localObject1;
        break label307;
      }
      for (;;)
      {
        if (i > 5) {
          break label321;
        }
        if (!paramEvent.isIndexAvailable(i))
        {
          localObject1 = paramEvent.getCustomVariableAt(i);
          localObject2 = new ContentValues();
          ((ContentValues)localObject2).put("event_id", Integer.valueOf(0));
          ((ContentValues)localObject2).put("cv_index", Integer.valueOf(((CustomVariable)localObject1).getIndex()));
          ((ContentValues)localObject2).put("cv_name", ((CustomVariable)localObject1).getName());
          ((ContentValues)localObject2).put("cv_scope", Integer.valueOf(((CustomVariable)localObject1).getScope()));
          ((ContentValues)localObject2).put("cv_value", ((CustomVariable)localObject1).getValue());
          paramSQLiteDatabase.update("custom_var_cache", (ContentValues)localObject2, "cv_index = ?", new String[] { Integer.toString(((CustomVariable)localObject1).getIndex()) });
          if (((CustomVariable)localObject1).getScope() == 1)
          {
            this.visitorCVCache.setCustomVariable((CustomVariable)localObject1);
          }
          else
          {
            this.visitorCVCache.clearCustomVariableAt(((CustomVariable)localObject1).getIndex());
            break label316;
            paramEvent = (Event)localObject2;
            break label307;
            i = 1;
            break label67;
            i += 1;
            break label67;
            if (paramEvent == null) {
              break;
            }
            i = 1;
            continue;
          }
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  public void putEvent(Event paramEvent)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 535	com/google/android/apps/analytics/PersistentHitStore:numStoredHits	I
    //   4: sipush 1000
    //   7: if_icmplt +14 -> 21
    //   10: ldc_w 301
    //   13: ldc_w 792
    //   16: invokestatic 345	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   19: pop
    //   20: return
    //   21: aload_0
    //   22: getfield 253	com/google/android/apps/analytics/PersistentHitStore:sampleRate	I
    //   25: bipush 100
    //   27: if_icmpeq +59 -> 86
    //   30: aload_1
    //   31: invokevirtual 482	com/google/android/apps/analytics/Event:getUserId	()I
    //   34: iconst_m1
    //   35: if_icmpne +43 -> 78
    //   38: aload_0
    //   39: getfield 484	com/google/android/apps/analytics/PersistentHitStore:storeId	I
    //   42: istore_2
    //   43: iload_2
    //   44: sipush 10000
    //   47: irem
    //   48: aload_0
    //   49: getfield 253	com/google/android/apps/analytics/PersistentHitStore:sampleRate	I
    //   52: bipush 100
    //   54: imul
    //   55: if_icmplt +31 -> 86
    //   58: invokestatic 798	com/google/android/apps/analytics/GoogleAnalyticsTracker:getInstance	()Lcom/google/android/apps/analytics/GoogleAnalyticsTracker;
    //   61: invokevirtual 801	com/google/android/apps/analytics/GoogleAnalyticsTracker:getDebug	()Z
    //   64: ifeq -44 -> 20
    //   67: ldc_w 301
    //   70: ldc_w 803
    //   73: invokestatic 806	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   76: pop
    //   77: return
    //   78: aload_1
    //   79: invokevirtual 482	com/google/android/apps/analytics/Event:getUserId	()I
    //   82: istore_2
    //   83: goto -40 -> 43
    //   86: aload_0
    //   87: monitorenter
    //   88: aload_0
    //   89: getfield 263	com/google/android/apps/analytics/PersistentHitStore:databaseHelper	Lcom/google/android/apps/analytics/PersistentHitStore$DataBaseHelper;
    //   92: invokevirtual 531	com/google/android/apps/analytics/PersistentHitStore$DataBaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   95: astore_3
    //   96: aload_3
    //   97: invokevirtual 512	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   100: aload_0
    //   101: getfield 632	com/google/android/apps/analytics/PersistentHitStore:sessionStarted	Z
    //   104: ifne +8 -> 112
    //   107: aload_0
    //   108: aload_3
    //   109: invokevirtual 809	com/google/android/apps/analytics/PersistentHitStore:storeUpdatedSession	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   112: aload_0
    //   113: aload_1
    //   114: aload_3
    //   115: iconst_1
    //   116: invokespecial 288	com/google/android/apps/analytics/PersistentHitStore:putEvent	(Lcom/google/android/apps/analytics/Event;Landroid/database/sqlite/SQLiteDatabase;Z)V
    //   119: aload_3
    //   120: invokevirtual 523	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   123: aload_3
    //   124: invokevirtual 526	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   127: ifeq +8 -> 135
    //   130: aload_3
    //   131: invokestatic 293	com/google/android/apps/analytics/PersistentHitStore:endTransaction	(Landroid/database/sqlite/SQLiteDatabase;)Z
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
    //   144: ldc_w 301
    //   147: new 173	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 811
    //   157: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_1
    //   161: invokevirtual 304	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   164: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 310	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   173: pop
    //   174: aload_0
    //   175: monitorexit
    //   176: return
    //   177: astore_1
    //   178: ldc_w 301
    //   181: new 173	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   188: ldc_w 813
    //   191: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_1
    //   195: invokevirtual 304	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   198: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 310	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   207: pop
    //   208: aload_3
    //   209: invokevirtual 526	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   212: ifeq -77 -> 135
    //   215: aload_3
    //   216: invokestatic 293	com/google/android/apps/analytics/PersistentHitStore:endTransaction	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   219: pop
    //   220: goto -85 -> 135
    //   223: astore_1
    //   224: aload_3
    //   225: invokevirtual 526	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   228: ifeq +8 -> 236
    //   231: aload_3
    //   232: invokestatic 293	com/google/android/apps/analytics/PersistentHitStore:endTransaction	(Landroid/database/sqlite/SQLiteDatabase;)Z
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
    //   1: ldc 100
    //   3: iconst_4
    //   4: anewarray 186	java/lang/String
    //   7: dup
    //   8: iconst_0
    //   9: ldc 100
    //   11: aastore
    //   12: dup
    //   13: iconst_1
    //   14: ldc -122
    //   16: aastore
    //   17: dup
    //   18: iconst_2
    //   19: ldc 107
    //   21: aastore
    //   22: dup
    //   23: iconst_3
    //   24: ldc 104
    //   26: aastore
    //   27: aconst_null
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: invokevirtual 555	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   35: astore_1
    //   36: aload_1
    //   37: invokeinterface 592 1 0
    //   42: ifeq +149 -> 191
    //   45: aload_1
    //   46: aload_1
    //   47: ldc -122
    //   49: invokeinterface 566 2 0
    //   54: invokeinterface 602 2 0
    //   59: lstore 4
    //   61: aload_1
    //   62: aload_1
    //   63: ldc 107
    //   65: invokeinterface 566 2 0
    //   70: invokeinterface 569 2 0
    //   75: istore_2
    //   76: aload_1
    //   77: aload_1
    //   78: ldc 104
    //   80: invokeinterface 566 2 0
    //   85: invokeinterface 569 2 0
    //   90: istore_3
    //   91: new 396	com/google/android/apps/analytics/Referrer
    //   94: dup
    //   95: aload_1
    //   96: aload_1
    //   97: ldc 100
    //   99: invokeinterface 566 2 0
    //   104: invokeinterface 573 2 0
    //   109: lload 4
    //   111: iload_2
    //   112: iload_3
    //   113: invokespecial 442	com/google/android/apps/analytics/Referrer:<init>	(Ljava/lang/String;JII)V
    //   116: astore 6
    //   118: aload_1
    //   119: ifnull +9 -> 128
    //   122: aload_1
    //   123: invokeinterface 583 1 0
    //   128: aload 6
    //   130: areturn
    //   131: astore 6
    //   133: aconst_null
    //   134: astore_1
    //   135: ldc_w 301
    //   138: aload 6
    //   140: invokevirtual 304	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   143: invokestatic 310	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   146: pop
    //   147: aload_1
    //   148: ifnull +9 -> 157
    //   151: aload_1
    //   152: invokeinterface 583 1 0
    //   157: aconst_null
    //   158: areturn
    //   159: astore 6
    //   161: aconst_null
    //   162: astore_1
    //   163: aload_1
    //   164: ifnull +9 -> 173
    //   167: aload_1
    //   168: invokeinterface 583 1 0
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
      this(paramContext, "google_analytics.db", 5, paramPersistentHitStore);
    }
    
    DataBaseHelper(Context paramContext, String paramString, int paramInt, PersistentHitStore paramPersistentHitStore)
    {
      super(paramString, null, paramInt);
      this.databaseVersion = paramInt;
      this.store = paramPersistentHitStore;
    }
    
    public DataBaseHelper(Context paramContext, String paramString, PersistentHitStore paramPersistentHitStore)
    {
      this(paramContext, paramString, 5, paramPersistentHitStore);
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
    
    /* Error */
    private void fixReferrerTable(SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: aload_1
      //   1: ldc 62
      //   3: aconst_null
      //   4: aconst_null
      //   5: aconst_null
      //   6: aconst_null
      //   7: aconst_null
      //   8: aconst_null
      //   9: invokevirtual 66	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   12: astore 8
      //   14: aload 8
      //   16: invokeinterface 72 1 0
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
      //   41: ldc 74
      //   43: invokevirtual 80	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   46: ifeq +9 -> 55
      //   49: iconst_1
      //   50: istore 5
      //   52: goto +355 -> 407
      //   55: iload_3
      //   56: istore 5
      //   58: aload 9
      //   60: iload_2
      //   61: aaload
      //   62: ldc 82
      //   64: invokevirtual 80	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   67: ifeq +340 -> 407
      //   70: iconst_1
      //   71: istore 4
      //   73: iload_3
      //   74: istore 5
      //   76: goto +331 -> 407
      //   79: aload 8
      //   81: invokeinterface 86 1 0
      //   86: ifeq +315 -> 401
      //   89: aload 8
      //   91: ldc 82
      //   93: invokeinterface 90 2 0
      //   98: istore_2
      //   99: aload 8
      //   101: ldc 74
      //   103: invokeinterface 90 2 0
      //   108: istore_3
      //   109: aload 8
      //   111: aload 8
      //   113: ldc 62
      //   115: invokeinterface 90 2 0
      //   120: invokeinterface 94 2 0
      //   125: astore 9
      //   127: aload 8
      //   129: aload 8
      //   131: ldc 96
      //   133: invokeinterface 90 2 0
      //   138: invokeinterface 100 2 0
      //   143: lstore 6
      //   145: iload_2
      //   146: iconst_m1
      //   147: if_icmpne +142 -> 289
      //   150: iconst_1
      //   151: istore_2
      //   152: goto +277 -> 429
      //   155: new 102	com/google/android/apps/analytics/Referrer
      //   158: dup
      //   159: aload 9
      //   161: lload 6
      //   163: iload_2
      //   164: iload_3
      //   165: invokespecial 105	com/google/android/apps/analytics/Referrer:<init>	(Ljava/lang/String;JII)V
      //   168: astore 9
      //   170: aload_1
      //   171: invokevirtual 109	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
      //   174: aload_0
      //   175: aload_1
      //   176: invokespecial 111	com/google/android/apps/analytics/PersistentHitStore$DataBaseHelper:createReferrerTable	(Landroid/database/sqlite/SQLiteDatabase;)V
      //   179: aload 9
      //   181: ifnull +79 -> 260
      //   184: new 113	android/content/ContentValues
      //   187: dup
      //   188: invokespecial 115	android/content/ContentValues:<init>	()V
      //   191: astore 10
      //   193: aload 10
      //   195: ldc 62
      //   197: aload 9
      //   199: invokevirtual 118	com/google/android/apps/analytics/Referrer:getReferrerString	()Ljava/lang/String;
      //   202: invokevirtual 122	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
      //   205: aload 10
      //   207: ldc 96
      //   209: aload 9
      //   211: invokevirtual 126	com/google/android/apps/analytics/Referrer:getTimeStamp	()J
      //   214: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   217: invokevirtual 135	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
      //   220: aload 10
      //   222: ldc 82
      //   224: aload 9
      //   226: invokevirtual 139	com/google/android/apps/analytics/Referrer:getVisit	()I
      //   229: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   232: invokevirtual 147	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   235: aload 10
      //   237: ldc 74
      //   239: aload 9
      //   241: invokevirtual 150	com/google/android/apps/analytics/Referrer:getIndex	()I
      //   244: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   247: invokevirtual 147	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   250: aload_1
      //   251: ldc 62
      //   253: aconst_null
      //   254: aload 10
      //   256: invokevirtual 154	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
      //   259: pop2
      //   260: aload_1
      //   261: invokevirtual 157	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
      //   264: aload 8
      //   266: ifnull +10 -> 276
      //   269: aload 8
      //   271: invokeinterface 160 1 0
      //   276: aload_1
      //   277: invokevirtual 163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
      //   280: ifeq +8 -> 288
      //   283: aload_1
      //   284: invokestatic 167	com/google/android/apps/analytics/PersistentHitStore:access$900	(Landroid/database/sqlite/SQLiteDatabase;)Z
      //   287: pop
      //   288: return
      //   289: aload 8
      //   291: iload_2
      //   292: invokeinterface 171 2 0
      //   297: istore_2
      //   298: goto +131 -> 429
      //   301: aload 8
      //   303: iload_3
      //   304: invokeinterface 171 2 0
      //   309: istore_3
      //   310: goto -155 -> 155
      //   313: astore 9
      //   315: aconst_null
      //   316: astore 8
      //   318: ldc -83
      //   320: aload 9
      //   322: invokevirtual 176	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
      //   325: invokestatic 182	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   328: pop
      //   329: aload 8
      //   331: ifnull +10 -> 341
      //   334: aload 8
      //   336: invokeinterface 160 1 0
      //   341: aload_1
      //   342: invokevirtual 163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
      //   345: ifeq -57 -> 288
      //   348: aload_1
      //   349: invokestatic 167	com/google/android/apps/analytics/PersistentHitStore:access$900	(Landroid/database/sqlite/SQLiteDatabase;)Z
      //   352: pop
      //   353: return
      //   354: astore 9
      //   356: aconst_null
      //   357: astore 8
      //   359: aload 8
      //   361: ifnull +10 -> 371
      //   364: aload 8
      //   366: invokeinterface 160 1 0
      //   371: aload_1
      //   372: invokevirtual 163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
      //   375: ifeq +8 -> 383
      //   378: aload_1
      //   379: invokestatic 167	com/google/android/apps/analytics/PersistentHitStore:access$900	(Landroid/database/sqlite/SQLiteDatabase;)Z
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
      PersistentHitStore.access$702(this.store, this.store.getVisitorVarBuffer(paramSQLiteDatabase));
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
      //   4: ldc -42
      //   6: iconst_1
      //   7: anewarray 76	java/lang/String
      //   10: dup
      //   11: iconst_0
      //   12: ldc 62
      //   14: aastore
      //   15: aconst_null
      //   16: aconst_null
      //   17: aconst_null
      //   18: aconst_null
      //   19: aconst_null
      //   20: invokevirtual 66	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   23: astore 5
      //   25: aload 5
      //   27: astore 4
      //   29: aload 4
      //   31: invokeinterface 86 1 0
      //   36: ifeq +265 -> 301
      //   39: aload 4
      //   41: iconst_0
      //   42: invokeinterface 94 2 0
      //   47: astore 6
      //   49: aload_1
      //   50: ldc -40
      //   52: aconst_null
      //   53: aconst_null
      //   54: aconst_null
      //   55: aconst_null
      //   56: aconst_null
      //   57: aconst_null
      //   58: invokevirtual 66	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   61: astore 5
      //   63: aload 5
      //   65: invokeinterface 86 1 0
      //   70: ifeq +226 -> 296
      //   73: aload 5
      //   75: iconst_0
      //   76: invokeinterface 100 2 0
      //   81: lstore_2
      //   82: new 113	android/content/ContentValues
      //   85: dup
      //   86: invokespecial 115	android/content/ContentValues:<init>	()V
      //   89: astore 7
      //   91: aload 7
      //   93: ldc 62
      //   95: aload 6
      //   97: invokevirtual 122	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
      //   100: aload 7
      //   102: ldc 96
      //   104: lload_2
      //   105: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   108: invokevirtual 135	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
      //   111: aload 7
      //   113: ldc 82
      //   115: iconst_1
      //   116: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   119: invokevirtual 147	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   122: aload 7
      //   124: ldc 74
      //   126: iconst_1
      //   127: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   130: invokevirtual 147	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   133: aload_1
      //   134: ldc 62
      //   136: aconst_null
      //   137: aload 7
      //   139: invokevirtual 154	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
      //   142: pop2
      //   143: aload 4
      //   145: ifnull +10 -> 155
      //   148: aload 4
      //   150: invokeinterface 160 1 0
      //   155: aload 5
      //   157: ifnull +10 -> 167
      //   160: aload 5
      //   162: invokeinterface 160 1 0
      //   167: return
      //   168: astore 6
      //   170: aconst_null
      //   171: astore 5
      //   173: aload 4
      //   175: astore_1
      //   176: aload 6
      //   178: astore 4
      //   180: ldc -83
      //   182: aload 4
      //   184: invokevirtual 176	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
      //   187: invokestatic 182	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   190: pop
      //   191: aload_1
      //   192: ifnull +9 -> 201
      //   195: aload_1
      //   196: invokeinterface 160 1 0
      //   201: aload 5
      //   203: ifnull -36 -> 167
      //   206: aload 5
      //   208: invokeinterface 160 1 0
      //   213: return
      //   214: astore_1
      //   215: aconst_null
      //   216: astore 5
      //   218: aconst_null
      //   219: astore 4
      //   221: aload 4
      //   223: ifnull +10 -> 233
      //   226: aload 4
      //   228: invokeinterface 160 1 0
      //   233: aload 5
      //   235: ifnull +10 -> 245
      //   238: aload 5
      //   240: invokeinterface 160 1 0
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
    
    void createCustomVariableTables(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS custom_variables;");
      paramSQLiteDatabase.execSQL(PersistentHitStore.CREATE_CUSTOM_VARIABLES_TABLE);
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS custom_var_cache;");
      paramSQLiteDatabase.execSQL(PersistentHitStore.CREATE_CUSTOM_VAR_CACHE_TABLE);
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
    
    /* Error */
    public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      // Byte code:
      //   0: ldc -83
      //   2: new 266	java/lang/StringBuilder
      //   5: dup
      //   6: invokespecial 267	java/lang/StringBuilder:<init>	()V
      //   9: ldc_w 269
      //   12: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   15: iload_2
      //   16: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   19: ldc_w 278
      //   22: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   25: iload_3
      //   26: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   29: ldc_w 280
      //   32: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   35: invokevirtual 281	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   38: invokestatic 284	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   41: pop
      //   42: aload_1
      //   43: ldc 57
      //   45: invokevirtual 37	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   48: aload_1
      //   49: invokestatic 52	com/google/android/apps/analytics/PersistentHitStore:access$600	()Ljava/lang/String;
      //   52: invokevirtual 37	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   55: aload_1
      //   56: invokestatic 227	com/google/android/apps/analytics/PersistentHitStore:access$300	()Ljava/lang/String;
      //   59: invokevirtual 37	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   62: aload_1
      //   63: invokestatic 256	com/google/android/apps/analytics/PersistentHitStore:access$100	()Ljava/lang/String;
      //   66: invokevirtual 37	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   69: new 286	java/util/HashSet
      //   72: dup
      //   73: invokespecial 287	java/util/HashSet:<init>	()V
      //   76: astore 4
      //   78: aload_1
      //   79: ldc -15
      //   81: aconst_null
      //   82: aconst_null
      //   83: aconst_null
      //   84: aconst_null
      //   85: aconst_null
      //   86: aconst_null
      //   87: aconst_null
      //   88: invokevirtual 290	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   91: astore 5
      //   93: aload 5
      //   95: invokeinterface 293 1 0
      //   100: ifeq +171 -> 271
      //   103: aload 4
      //   105: aload 5
      //   107: aload 5
      //   109: ldc -25
      //   111: invokeinterface 90 2 0
      //   116: invokeinterface 171 2 0
      //   121: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   124: invokeinterface 298 2 0
      //   129: pop
      //   130: goto -37 -> 93
      //   133: astore 6
      //   135: ldc -83
      //   137: new 266	java/lang/StringBuilder
      //   140: dup
      //   141: invokespecial 267	java/lang/StringBuilder:<init>	()V
      //   144: ldc_w 300
      //   147: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   150: aload 6
      //   152: invokevirtual 176	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
      //   155: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   158: invokevirtual 281	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   161: invokestatic 182	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   164: pop
      //   165: aload 5
      //   167: invokeinterface 160 1 0
      //   172: iconst_1
      //   173: istore_2
      //   174: iload_2
      //   175: iconst_5
      //   176: if_icmpgt +150 -> 326
      //   179: aload 4
      //   181: iload_2
      //   182: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   185: invokeinterface 303 2 0
      //   190: ifne +74 -> 264
      //   193: new 113	android/content/ContentValues
      //   196: dup
      //   197: invokespecial 115	android/content/ContentValues:<init>	()V
      //   200: astore 5
      //   202: aload 5
      //   204: ldc -27
      //   206: iconst_0
      //   207: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   210: invokevirtual 147	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   213: aload 5
      //   215: ldc -25
      //   217: iload_2
      //   218: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   221: invokevirtual 147	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   224: aload 5
      //   226: ldc -23
      //   228: ldc -21
      //   230: invokevirtual 122	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
      //   233: aload 5
      //   235: ldc -19
      //   237: iconst_3
      //   238: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   241: invokevirtual 147	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   244: aload 5
      //   246: ldc -17
      //   248: ldc -21
      //   250: invokevirtual 122	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
      //   253: aload_1
      //   254: ldc -15
      //   256: ldc -27
      //   258: aload 5
      //   260: invokevirtual 154	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
      //   263: pop2
      //   264: iload_2
      //   265: iconst_1
      //   266: iadd
      //   267: istore_2
      //   268: goto -94 -> 174
      //   271: aload 5
      //   273: invokeinterface 160 1 0
      //   278: goto -106 -> 172
      //   281: astore_1
      //   282: aload 5
      //   284: invokeinterface 160 1 0
      //   289: aload_1
      //   290: athrow
      //   291: astore 5
      //   293: ldc -83
      //   295: new 266	java/lang/StringBuilder
      //   298: dup
      //   299: invokespecial 267	java/lang/StringBuilder:<init>	()V
      //   302: ldc_w 305
      //   305: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   308: aload 5
      //   310: invokevirtual 176	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
      //   313: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   316: invokevirtual 281	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   319: invokestatic 182	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   322: pop
      //   323: goto -59 -> 264
      //   326: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	327	0	this	DataBaseHelper
      //   0	327	1	paramSQLiteDatabase	SQLiteDatabase
      //   0	327	2	paramInt1	int
      //   0	327	3	paramInt2	int
      //   76	104	4	localHashSet	java.util.HashSet
      //   91	192	5	localObject	Object
      //   291	18	5	localSQLiteException1	SQLiteException
      //   133	18	6	localSQLiteException2	SQLiteException
      // Exception table:
      //   from	to	target	type
      //   93	130	133	android/database/sqlite/SQLiteException
      //   93	130	281	finally
      //   135	165	281	finally
      //   179	264	291	android/database/sqlite/SQLiteException
    }
    
    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      if (paramSQLiteDatabase.isReadOnly())
      {
        Log.w("GoogleAnalyticsTracker", "Warning: Need to update database, but it's read only.");
        return;
      }
      fixReferrerTable(paramSQLiteDatabase);
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
      } while ((paramInt1 >= 4) || (paramInt2 <= 3));
      createHitTable(paramSQLiteDatabase);
      createReferrerTable(paramSQLiteDatabase);
      migrateEventsToHits(paramSQLiteDatabase, paramInt1);
      migratePreV4Referrer(paramSQLiteDatabase);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/google/android/apps/analytics/PersistentHitStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */