package com.getjar.sdk.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.getjar.sdk.comm.Request;
import com.getjar.sdk.comm.Request.ServiceName;
import com.getjar.sdk.comm.Result;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import java.util.Locale;

public class DBRequestStatistics
  extends SQLiteOpenHelper
{
  private static final String[] DB_CREATE_TABLE_COMMANDS = { "CREATE TABLE IF NOT EXISTS requests (id INTEGER PRIMARY KEY AUTOINCREMENT, serviceName TEXT NOT NULL, requestType TEXT NOT NULL, requestCount INTEGER NOT NULL, responseCount INTEGER NOT NULL, observedSizeSmallest INTEGER NOT NULL, observedSizeLargest INTEGER NOT NULL);", "CREATE TABLE IF NOT EXISTS responses (id INTEGER PRIMARY KEY AUTOINCREMENT, requestId INTEGER NOT NULL, responseTime INTEGER NOT NULL, responseSize INTEGER NOT NULL,responseCode INTEGER NOT NULL DEFAULT 0);" };
  private static final String[] DB_TABLE_NAMES;
  private static final String _DATABASE_NAME = "GetJarStatisticsDB";
  private static final String _DATABASE_TABLE_NAME_REQUESTS = "requests";
  private static final String _DATABASE_TABLE_NAME_RESPONSES = "responses";
  private static final int _DATABASE_VERSION = 4;
  private static final String _DB_CREATE_TABLE_REQUESTS = "CREATE TABLE IF NOT EXISTS requests (id INTEGER PRIMARY KEY AUTOINCREMENT, serviceName TEXT NOT NULL, requestType TEXT NOT NULL, requestCount INTEGER NOT NULL, responseCount INTEGER NOT NULL, observedSizeSmallest INTEGER NOT NULL, observedSizeLargest INTEGER NOT NULL);";
  private static final String _DB_CREATE_TABLE_RESPONSES = "CREATE TABLE IF NOT EXISTS responses (id INTEGER PRIMARY KEY AUTOINCREMENT, requestId INTEGER NOT NULL, responseTime INTEGER NOT NULL, responseSize INTEGER NOT NULL,responseCode INTEGER NOT NULL DEFAULT 0);";
  private static volatile DBRequestStatistics _Instance = null;
  private static final int _MaxResponseRecordsCap = 600;
  private volatile Object _databaseAccessLock = new Object();
  
  static
  {
    DB_TABLE_NAMES = new String[] { "requests", "responses" };
  }
  
  private DBRequestStatistics(Context paramContext)
  {
    super(paramContext, "GetJarStatisticsDB", null, 4);
  }
  
  public static DBRequestStatistics getInstance(Context paramContext)
  {
    try
    {
      if (_Instance == null) {
        _Instance = new DBRequestStatistics(paramContext);
      }
      paramContext = _Instance;
      return paramContext;
    }
    finally {}
  }
  
  private void lruCapResponsesAtMaxRecords()
  {
    Long localLong;
    long l;
    int i;
    synchronized (this._databaseAccessLock)
    {
      if (getResponseRecordCount() < 600L) {
        return;
      }
      localCursor = getWritableDatabase().query("responses", new String[] { "id" }, null, null, null, null, "id DESC");
      localLong = null;
    }
  }
  
  public boolean addResponseRecord(Request paramRequest, Result paramResult)
  {
    if (paramRequest == null) {
      throw new IllegalArgumentException("'request' can not be NULL");
    }
    if (paramResult == null) {
      throw new IllegalArgumentException("'response' can not be NULL");
    }
    if (!checkForRequestEntry(paramRequest)) {
      upsertRequestRecord(paramRequest);
    }
    for (;;)
    {
      synchronized (this._databaseAccessLock)
      {
        Object localObject2 = getWritableDatabase().query("requests", null, "serviceName = ? AND requestType = ?", new String[] { paramRequest.getServiceName().name(), paramRequest.getRequestType() }, null, null, null);
        try
        {
          if (((Cursor)localObject2).moveToNext())
          {
            int i = ((Cursor)localObject2).getInt(0);
            int j = ((Cursor)localObject2).getInt(4);
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("responseCount", Integer.valueOf(j + 1));
            Logger.v(Area.STORAGE.value() | Area.STATS.value(), "DBRequestStatistics: addResponseRecord() Updating request stats record [serviceName:%1$s requestType:%2$s responseCount:%3$d]", new Object[] { paramRequest.getServiceName().name(), paramRequest.getRequestType(), Integer.valueOf(j + 1) });
            getWritableDatabase().update("requests", localContentValues, "id = " + Integer.toString(i), null);
            ((Cursor)localObject2).close();
            j = paramResult.getEstimatedResponseSizeInBytes();
            localObject2 = new ContentValues();
            ((ContentValues)localObject2).put("requestId", Integer.valueOf(i));
            ((ContentValues)localObject2).put("responseTime", Integer.valueOf(paramResult.getResponseTime()));
            ((ContentValues)localObject2).put("responseSize", Integer.valueOf(j));
            ((ContentValues)localObject2).put("responseCode", Integer.valueOf(paramResult.getResponseCode()));
            Logger.v(Area.STORAGE.value() | Area.STATS.value(), "DBRequestStatistics: addResponseRecord() Inserting response stats record [serviceName:%1$s requestType:%2$s responseTime:%3$d responseSize:%4$d responseCode:%5$d]", new Object[] { paramRequest.getServiceName().name(), paramRequest.getRequestType(), Integer.valueOf(paramResult.getResponseTime()), Integer.valueOf(j), Integer.valueOf(paramResult.getResponseCode()) });
            if (getWritableDatabase().insert("responses", null, (ContentValues)localObject2) != -1L)
            {
              bool = true;
              lruCapResponsesAtMaxRecords();
              return bool;
            }
          }
          else
          {
            throw new IllegalStateException("Unable to find or create a request statistics record");
          }
        }
        finally
        {
          ((Cursor)localObject2).close();
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean checkForRequestEntry(Request paramRequest)
  {
    bool = true;
    if (paramRequest == null) {
      throw new IllegalArgumentException("'request' can not be NULL");
    }
    synchronized (this._databaseAccessLock)
    {
      localSQLiteStatement = getReadableDatabase().compileStatement(String.format(Locale.US, "SELECT count(*) FROM %1$s WHERE serviceName = ? AND requestType = ?", new Object[] { "requests" }));
      for (;;)
      {
        try
        {
          localSQLiteStatement.bindString(1, paramRequest.getServiceName().name());
          localSQLiteStatement.bindString(2, paramRequest.getRequestType());
          long l = localSQLiteStatement.simpleQueryForLong();
          if (l <= 0L) {
            continue;
          }
        }
        finally
        {
          try
          {
            localSQLiteStatement.close();
            throw paramRequest;
          }
          catch (Exception localException)
          {
            Logger.e(Area.STORAGE.value() | Area.STATS.value(), localException, "DBRequestStatistics: checkForRequestEntry() SQLiteOpenHelper.close() failed", new Object[0]);
            continue;
          }
          bool = false;
        }
        try
        {
          localSQLiteStatement.close();
          return bool;
        }
        catch (Exception paramRequest)
        {
          Logger.e(Area.STORAGE.value() | Area.STATS.value(), paramRequest, "DBRequestStatistics: checkForRequestEntry() SQLiteOpenHelper.close() failed", new Object[0]);
        }
      }
    }
  }
  
  /* Error */
  public java.util.Map<String, Float> getAnalyticData()
  {
    // Byte code:
    //   0: new 278	java/util/TreeMap
    //   3: dup
    //   4: invokespecial 279	java/util/TreeMap:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 54	com/getjar/sdk/data/DBRequestStatistics:_databaseAccessLock	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: invokevirtual 252	com/getjar/sdk/data/DBRequestStatistics:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   19: getstatic 104	java/util/Locale:US	Ljava/util/Locale;
    //   22: ldc_w 281
    //   25: iconst_1
    //   26: anewarray 50	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: ldc 14
    //   33: aastore
    //   34: invokestatic 110	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   37: invokevirtual 258	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   40: astore_3
    //   41: aload_2
    //   42: ldc_w 283
    //   45: aload_3
    //   46: invokevirtual 267	android/database/sqlite/SQLiteStatement:simpleQueryForLong	()J
    //   49: l2f
    //   50: invokestatic 288	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   53: invokeinterface 293 3 0
    //   58: pop
    //   59: aload_3
    //   60: invokevirtual 268	android/database/sqlite/SQLiteStatement:close	()V
    //   63: aload_0
    //   64: invokevirtual 252	com/getjar/sdk/data/DBRequestStatistics:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   67: getstatic 104	java/util/Locale:US	Ljava/util/Locale;
    //   70: ldc_w 295
    //   73: iconst_1
    //   74: anewarray 50	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: ldc 14
    //   81: aastore
    //   82: invokestatic 110	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   85: invokevirtual 258	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   88: astore_3
    //   89: aload_2
    //   90: ldc_w 297
    //   93: aload_3
    //   94: invokevirtual 267	android/database/sqlite/SQLiteStatement:simpleQueryForLong	()J
    //   97: l2f
    //   98: invokestatic 288	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   101: invokeinterface 293 3 0
    //   106: pop
    //   107: aload_3
    //   108: invokevirtual 268	android/database/sqlite/SQLiteStatement:close	()V
    //   111: aload_0
    //   112: invokevirtual 252	com/getjar/sdk/data/DBRequestStatistics:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   115: ldc 17
    //   117: iconst_2
    //   118: anewarray 38	java/lang/String
    //   121: dup
    //   122: iconst_0
    //   123: ldc -27
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: ldc_w 299
    //   131: aastore
    //   132: aconst_null
    //   133: aconst_null
    //   134: ldc -27
    //   136: aconst_null
    //   137: aconst_null
    //   138: invokevirtual 79	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   141: astore_3
    //   142: aload_3
    //   143: invokeinterface 178 1 0
    //   148: ifeq +78 -> 226
    //   151: aload_2
    //   152: getstatic 104	java/util/Locale:US	Ljava/util/Locale;
    //   155: ldc_w 301
    //   158: iconst_1
    //   159: anewarray 50	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: aload_3
    //   165: iconst_0
    //   166: invokeinterface 182 2 0
    //   171: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: aastore
    //   175: invokestatic 110	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   178: aload_3
    //   179: iconst_1
    //   180: invokeinterface 182 2 0
    //   185: i2f
    //   186: invokestatic 288	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   189: invokeinterface 293 3 0
    //   194: pop
    //   195: goto -53 -> 142
    //   198: astore_2
    //   199: aload_3
    //   200: invokeinterface 98 1 0
    //   205: aload_2
    //   206: athrow
    //   207: astore_2
    //   208: aload_1
    //   209: monitorexit
    //   210: aload_2
    //   211: athrow
    //   212: astore_2
    //   213: aload_3
    //   214: invokevirtual 268	android/database/sqlite/SQLiteStatement:close	()V
    //   217: aload_2
    //   218: athrow
    //   219: astore_2
    //   220: aload_3
    //   221: invokevirtual 268	android/database/sqlite/SQLiteStatement:close	()V
    //   224: aload_2
    //   225: athrow
    //   226: aload_3
    //   227: invokeinterface 98 1 0
    //   232: aload_0
    //   233: invokevirtual 252	com/getjar/sdk/data/DBRequestStatistics:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   236: ldc 17
    //   238: bipush 6
    //   240: anewarray 38	java/lang/String
    //   243: dup
    //   244: iconst_0
    //   245: ldc_w 303
    //   248: aastore
    //   249: dup
    //   250: iconst_1
    //   251: ldc_w 305
    //   254: aastore
    //   255: dup
    //   256: iconst_2
    //   257: ldc_w 307
    //   260: aastore
    //   261: dup
    //   262: iconst_3
    //   263: ldc_w 309
    //   266: aastore
    //   267: dup
    //   268: iconst_4
    //   269: ldc_w 311
    //   272: aastore
    //   273: dup
    //   274: iconst_5
    //   275: ldc_w 313
    //   278: aastore
    //   279: aconst_null
    //   280: aconst_null
    //   281: aconst_null
    //   282: aconst_null
    //   283: aconst_null
    //   284: invokevirtual 79	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   287: astore_3
    //   288: aload_3
    //   289: invokeinterface 178 1 0
    //   294: ifeq +123 -> 417
    //   297: aload_2
    //   298: ldc_w 315
    //   301: aload_3
    //   302: iconst_0
    //   303: invokeinterface 319 2 0
    //   308: invokestatic 288	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   311: invokeinterface 293 3 0
    //   316: pop
    //   317: aload_2
    //   318: ldc_w 321
    //   321: aload_3
    //   322: iconst_1
    //   323: invokeinterface 319 2 0
    //   328: invokestatic 288	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   331: invokeinterface 293 3 0
    //   336: pop
    //   337: aload_2
    //   338: ldc_w 323
    //   341: aload_3
    //   342: iconst_2
    //   343: invokeinterface 319 2 0
    //   348: invokestatic 288	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   351: invokeinterface 293 3 0
    //   356: pop
    //   357: aload_2
    //   358: ldc_w 325
    //   361: aload_3
    //   362: iconst_3
    //   363: invokeinterface 319 2 0
    //   368: invokestatic 288	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   371: invokeinterface 293 3 0
    //   376: pop
    //   377: aload_2
    //   378: ldc_w 327
    //   381: aload_3
    //   382: iconst_4
    //   383: invokeinterface 319 2 0
    //   388: invokestatic 288	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   391: invokeinterface 293 3 0
    //   396: pop
    //   397: aload_2
    //   398: ldc_w 329
    //   401: aload_3
    //   402: iconst_5
    //   403: invokeinterface 319 2 0
    //   408: invokestatic 288	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   411: invokeinterface 293 3 0
    //   416: pop
    //   417: aload_3
    //   418: invokeinterface 98 1 0
    //   423: aload_1
    //   424: monitorexit
    //   425: aload_2
    //   426: areturn
    //   427: astore_2
    //   428: aload_3
    //   429: invokeinterface 98 1 0
    //   434: aload_2
    //   435: athrow
    //   436: astore_3
    //   437: goto -374 -> 63
    //   440: astore_3
    //   441: goto -224 -> 217
    //   444: astore_3
    //   445: goto -334 -> 111
    //   448: astore_3
    //   449: goto -225 -> 224
    //   452: astore_3
    //   453: goto -221 -> 232
    //   456: astore_3
    //   457: goto -252 -> 205
    //   460: astore_3
    //   461: goto -38 -> 423
    //   464: astore_3
    //   465: goto -31 -> 434
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	DBRequestStatistics
    //   12	412	1	localObject1	Object
    //   7	145	2	localTreeMap	java.util.TreeMap
    //   198	8	2	localObject2	Object
    //   207	4	2	localObject3	Object
    //   212	6	2	localObject4	Object
    //   219	207	2	localMap	java.util.Map<String, Float>
    //   427	8	2	localObject5	Object
    //   40	389	3	localObject6	Object
    //   436	1	3	localException1	Exception
    //   440	1	3	localException2	Exception
    //   444	1	3	localException3	Exception
    //   448	1	3	localException4	Exception
    //   452	1	3	localException5	Exception
    //   456	1	3	localException6	Exception
    //   460	1	3	localException7	Exception
    //   464	1	3	localException8	Exception
    // Exception table:
    //   from	to	target	type
    //   142	195	198	finally
    //   15	41	207	finally
    //   59	63	207	finally
    //   63	89	207	finally
    //   107	111	207	finally
    //   111	142	207	finally
    //   199	205	207	finally
    //   205	207	207	finally
    //   208	210	207	finally
    //   213	217	207	finally
    //   217	219	207	finally
    //   220	224	207	finally
    //   224	226	207	finally
    //   226	232	207	finally
    //   232	288	207	finally
    //   417	423	207	finally
    //   423	425	207	finally
    //   428	434	207	finally
    //   434	436	207	finally
    //   41	59	212	finally
    //   89	107	219	finally
    //   288	417	427	finally
    //   59	63	436	java/lang/Exception
    //   213	217	440	java/lang/Exception
    //   107	111	444	java/lang/Exception
    //   220	224	448	java/lang/Exception
    //   226	232	452	java/lang/Exception
    //   199	205	456	java/lang/Exception
    //   417	423	460	java/lang/Exception
    //   428	434	464	java/lang/Exception
  }
  
  /* Error */
  public long getResponseRecordCount()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	com/getjar/sdk/data/DBRequestStatistics:_databaseAccessLock	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 252	com/getjar/sdk/data/DBRequestStatistics:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   11: getstatic 104	java/util/Locale:US	Ljava/util/Locale;
    //   14: ldc_w 333
    //   17: iconst_1
    //   18: anewarray 50	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: ldc 17
    //   25: aastore
    //   26: invokestatic 110	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   29: invokevirtual 258	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   32: astore 5
    //   34: aload 5
    //   36: invokevirtual 267	android/database/sqlite/SQLiteStatement:simpleQueryForLong	()J
    //   39: lstore_1
    //   40: aload 5
    //   42: invokevirtual 268	android/database/sqlite/SQLiteStatement:close	()V
    //   45: aload_3
    //   46: monitorexit
    //   47: lload_1
    //   48: lreturn
    //   49: astore 4
    //   51: aload 5
    //   53: invokevirtual 268	android/database/sqlite/SQLiteStatement:close	()V
    //   56: aload 4
    //   58: athrow
    //   59: astore 4
    //   61: aload_3
    //   62: monitorexit
    //   63: aload 4
    //   65: athrow
    //   66: astore 4
    //   68: goto -23 -> 45
    //   71: astore 5
    //   73: goto -17 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	DBRequestStatistics
    //   39	9	1	l	long
    //   4	58	3	localObject1	Object
    //   49	8	4	localObject2	Object
    //   59	5	4	localObject3	Object
    //   66	1	4	localException1	Exception
    //   32	20	5	localSQLiteStatement	SQLiteStatement
    //   71	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   34	40	49	finally
    //   7	34	59	finally
    //   40	45	59	finally
    //   45	47	59	finally
    //   51	56	59	finally
    //   56	59	59	finally
    //   61	63	59	finally
    //   40	45	66	java/lang/Exception
    //   51	56	71	java/lang/Exception
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    while (i < DB_CREATE_TABLE_COMMANDS.length)
    {
      paramSQLiteDatabase.execSQL(DB_CREATE_TABLE_COMMANDS[i]);
      i += 1;
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Logger.i(Area.STORAGE.value() | Area.STATS.value(), "DBRequestStatistics: onUpgrade() Upgrading DB %1$s from version %2$d to %3$d (deletes all data)", new Object[] { "GetJarStatisticsDB", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramInt1 = 0;
    while (paramInt1 < DB_TABLE_NAMES.length)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_TABLE_NAMES[paramInt1]);
      paramInt1 += 1;
    }
    onCreate(paramSQLiteDatabase);
  }
  
  public boolean upsertRequestRecord(Request paramRequest)
  {
    if (paramRequest == null) {
      throw new IllegalArgumentException("'request' can not be NULL");
    }
    Cursor localCursor;
    synchronized (this._databaseAccessLock)
    {
      localCursor = getWritableDatabase().query("requests", null, "serviceName = ? AND requestType = ?", new String[] { paramRequest.getServiceName().name(), paramRequest.getRequestType() }, null, null, null);
    }
    for (;;)
    {
      int k;
      int m;
      int i;
      try
      {
        ContentValues localContentValues;
        boolean bool;
        if (localCursor.moveToNext())
        {
          int n = localCursor.getInt(0);
          int i1 = localCursor.getInt(3);
          int i2 = localCursor.getInt(4);
          k = localCursor.getInt(5);
          m = localCursor.getInt(6);
          i = paramRequest.getEstimatedRequestSizeInBytes();
          localContentValues = new ContentValues();
          localContentValues.put("requestCount", Integer.valueOf(i1 + 1));
          int j = k;
          if (i < k)
          {
            j = i;
            break label544;
            localContentValues.put("observedSizeSmallest", Integer.valueOf(j));
            localContentValues.put("observedSizeLargest", Integer.valueOf(k));
            Logger.v(Area.STORAGE.value() | Area.STATS.value(), "DBRequestStatistics: upsertRequestRecord() Updating request stats record [serviceName:%1$s requestType:%2$s requestCount:%3$d responseCount:%4$d observedSizeSmallest:%5$d observedSizeLargest:%6$d]", new Object[] { paramRequest.getServiceName().name(), paramRequest.getRequestType(), Integer.valueOf(i1 + 1), Integer.valueOf(i2), Integer.valueOf(j), Integer.valueOf(k) });
            i = getWritableDatabase().update("requests", localContentValues, "id = " + Integer.toString(n), null);
            if (i > 0)
            {
              bool = true;
              localCursor.close();
              return bool;
            }
            bool = false;
            continue;
          }
        }
        else
        {
          i = paramRequest.getEstimatedRequestSizeInBytes();
          localContentValues = new ContentValues();
          localContentValues.put("serviceName", paramRequest.getServiceName().name());
          localContentValues.put("requestType", paramRequest.getRequestType());
          localContentValues.put("requestCount", Integer.valueOf(1));
          localContentValues.put("responseCount", Integer.valueOf(0));
          localContentValues.put("observedSizeSmallest", Integer.valueOf(i));
          localContentValues.put("observedSizeLargest", Integer.valueOf(i));
          Logger.v(Area.STORAGE.value() | Area.STATS.value(), "DBRequestStatistics: upsertRequestRecord() Inserting request stats record [serviceName:%1$s requestType:%2$s requestCount:%3$d responseCount:%4$d observedSizeSmallest:%5$d observedSizeLargest:%6$d]", new Object[] { paramRequest.getServiceName().name(), paramRequest.getRequestType(), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i) });
          long l = getWritableDatabase().insert("requests", null, localContentValues);
          if (l != -1L)
          {
            bool = true;
            localCursor.close();
            return bool;
            paramRequest = finally;
            throw paramRequest;
          }
          bool = false;
          continue;
        }
        k = m;
      }
      finally
      {
        localCursor.close();
      }
      label544:
      if (i > m) {
        k = i;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/DBRequestStatistics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */