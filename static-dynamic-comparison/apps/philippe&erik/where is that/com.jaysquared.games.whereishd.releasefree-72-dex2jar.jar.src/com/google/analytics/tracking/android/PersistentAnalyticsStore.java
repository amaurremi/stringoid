package com.google.analytics.tracking.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class PersistentAnalyticsStore
  implements AnalyticsStore
{
  private static final String CREATE_HITS_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[] { "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id" });
  private static final String DATABASE_FILENAME = "google_analytics_v2.db";
  @VisibleForTesting
  static final String HITS_TABLE = "hits2";
  @VisibleForTesting
  static final String HIT_APP_ID = "hit_app_id";
  @VisibleForTesting
  static final String HIT_ID = "hit_id";
  @VisibleForTesting
  static final String HIT_STRING = "hit_string";
  @VisibleForTesting
  static final String HIT_TIME = "hit_time";
  @VisibleForTesting
  static final String HIT_URL = "hit_url";
  private Clock mClock;
  private final Context mContext;
  private final String mDatabaseName;
  private final AnalyticsDatabaseHelper mDbHelper;
  private volatile Dispatcher mDispatcher;
  private long mLastDeleteStaleHitsTime;
  private final AnalyticsStoreStateListener mListener;
  
  PersistentAnalyticsStore(AnalyticsStoreStateListener paramAnalyticsStoreStateListener, Context paramContext)
  {
    this(paramAnalyticsStoreStateListener, paramContext, "google_analytics_v2.db");
  }
  
  @VisibleForTesting
  PersistentAnalyticsStore(AnalyticsStoreStateListener paramAnalyticsStoreStateListener, Context paramContext, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mDatabaseName = paramString;
    this.mListener = paramAnalyticsStoreStateListener;
    this.mClock = new Clock()
    {
      public long currentTimeMillis()
      {
        return System.currentTimeMillis();
      }
    };
    this.mDbHelper = new AnalyticsDatabaseHelper(this.mContext, this.mDatabaseName);
    this.mDispatcher = new SimpleNetworkDispatcher(new DefaultHttpClient(), this.mContext);
    this.mLastDeleteStaleHitsTime = 0L;
  }
  
  private void fillVersionParameter(Map<String, String> paramMap, Collection<Command> paramCollection)
  {
    String str = "&_v".substring(1);
    if (paramCollection != null)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Command localCommand = (Command)paramCollection.next();
        if ("appendVersion".equals(localCommand.getId())) {
          paramMap.put(str, localCommand.getValue());
        }
      }
    }
  }
  
  static String generateHitString(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localArrayList.add(HitBuilder.encode((String)localEntry.getKey()) + "=" + HitBuilder.encode((String)localEntry.getValue()));
    }
    return TextUtils.join("&", localArrayList);
  }
  
  private SQLiteDatabase getWritableDatabase(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.mDbHelper.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.w(paramString);
    }
    return null;
  }
  
  private void removeOldHitIfFull()
  {
    int i = getNumStoredHits() - 2000 + 1;
    if (i > 0)
    {
      List localList = peekHitIds(i);
      Log.v("Store full, deleting " + localList.size() + " hits to make room.");
      deleteHits((String[])localList.toArray(new String[0]));
    }
  }
  
  private void writeHitToDatabase(Map<String, String> paramMap, long paramLong, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase("Error opening database for putHit");
    if (localSQLiteDatabase == null) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hit_string", generateHitString(paramMap));
    localContentValues.put("hit_time", Long.valueOf(paramLong));
    long l = 0L;
    paramLong = l;
    if (paramMap.containsKey("AppUID")) {}
    try
    {
      paramLong = Long.parseLong((String)paramMap.get("AppUID"));
      localContentValues.put("hit_app_id", Long.valueOf(paramLong));
      paramMap = paramString;
      if (paramString == null) {
        paramMap = "http://www.google-analytics.com/collect";
      }
      if (paramMap.length() == 0)
      {
        Log.w("Empty path: not sending hit");
        return;
      }
      localContentValues.put("hit_url", paramMap);
      try
      {
        localSQLiteDatabase.insert("hits2", null, localContentValues);
        this.mListener.reportStoreIsEmpty(false);
        return;
      }
      catch (SQLiteException paramMap)
      {
        Log.w("Error storing hit");
        return;
      }
    }
    catch (NumberFormatException paramMap)
    {
      for (;;)
      {
        paramLong = l;
      }
    }
  }
  
  public void clearHits(long paramLong)
  {
    boolean bool = true;
    Object localObject = getWritableDatabase("Error opening database for clearHits");
    if (localObject != null)
    {
      if (paramLong != 0L) {
        break label54;
      }
      ((SQLiteDatabase)localObject).delete("hits2", null, null);
      localObject = this.mListener;
      if (getNumStoredHits() != 0) {
        break label82;
      }
    }
    for (;;)
    {
      ((AnalyticsStoreStateListener)localObject).reportStoreIsEmpty(bool);
      return;
      label54:
      ((SQLiteDatabase)localObject).delete("hits2", "hit_app_id = ?", new String[] { Long.valueOf(paramLong).toString() });
      break;
      label82:
      bool = false;
    }
  }
  
  public void close()
  {
    try
    {
      this.mDbHelper.getWritableDatabase().close();
      this.mDispatcher.close();
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.w("Error opening database for close");
    }
  }
  
  @Deprecated
  void deleteHits(Collection<Hit> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty()))
    {
      Log.w("Empty/Null collection passed to deleteHits.");
      return;
    }
    String[] arrayOfString = new String[paramCollection.size()];
    int i = 0;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      arrayOfString[i] = String.valueOf(((Hit)paramCollection.next()).getHitId());
      i += 1;
    }
    deleteHits(arrayOfString);
  }
  
  void deleteHits(String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      Log.w("Empty hitIds passed to deleteHits.");
    }
    Object localObject;
    do
    {
      return;
      localObject = getWritableDatabase("Error opening database for deleteHits.");
    } while (localObject == null);
    String str = String.format("HIT_ID in (%s)", new Object[] { TextUtils.join(",", Collections.nCopies(paramArrayOfString.length, "?")) });
    for (;;)
    {
      try
      {
        ((SQLiteDatabase)localObject).delete("hits2", str, paramArrayOfString);
        localObject = this.mListener;
        if (getNumStoredHits() == 0)
        {
          ((AnalyticsStoreStateListener)localObject).reportStoreIsEmpty(bool);
          return;
        }
      }
      catch (SQLiteException localSQLiteException)
      {
        Log.w("Error deleting hits " + paramArrayOfString);
        return;
      }
      bool = false;
    }
  }
  
  int deleteStaleHits()
  {
    boolean bool = true;
    long l = this.mClock.currentTimeMillis();
    if (l <= this.mLastDeleteStaleHitsTime + 86400000L) {}
    do
    {
      return 0;
      this.mLastDeleteStaleHitsTime = l;
      localObject = getWritableDatabase("Error opening database for deleteStaleHits.");
    } while (localObject == null);
    int i = ((SQLiteDatabase)localObject).delete("hits2", "HIT_TIME < ?", new String[] { Long.toString(this.mClock.currentTimeMillis() - 2592000000L) });
    Object localObject = this.mListener;
    if (getNumStoredHits() == 0) {}
    for (;;)
    {
      ((AnalyticsStoreStateListener)localObject).reportStoreIsEmpty(bool);
      return i;
      bool = false;
    }
  }
  
  public void dispatch()
  {
    Log.v("Dispatch running...");
    if (!this.mDispatcher.okToDispatch()) {}
    List localList;
    int i;
    do
    {
      return;
      localList = peekHits(40);
      if (localList.isEmpty())
      {
        Log.v("...nothing to dispatch");
        this.mListener.reportStoreIsEmpty(true);
        return;
      }
      i = this.mDispatcher.dispatchHits(localList);
      Log.v("sent " + i + " of " + localList.size() + " hits");
      deleteHits(localList.subList(0, Math.min(i, localList.size())));
    } while ((i != localList.size()) || (getNumStoredHits() <= 0));
    GAServiceManager.getInstance().dispatchLocalHits();
  }
  
  @VisibleForTesting
  public AnalyticsDatabaseHelper getDbHelper()
  {
    return this.mDbHelper;
  }
  
  public Dispatcher getDispatcher()
  {
    return this.mDispatcher;
  }
  
  @VisibleForTesting
  AnalyticsDatabaseHelper getHelper()
  {
    return this.mDbHelper;
  }
  
  int getNumStoredHits()
  {
    k = 0;
    int i = 0;
    Object localObject5 = getWritableDatabase("Error opening database for getNumStoredHits.");
    if (localObject5 == null) {
      return 0;
    }
    Object localObject3 = null;
    localObject1 = null;
    try
    {
      localObject5 = ((SQLiteDatabase)localObject5).rawQuery("SELECT COUNT(*) from hits2", null);
      localObject1 = localObject5;
      localObject3 = localObject5;
      if (((Cursor)localObject5).moveToFirst())
      {
        localObject1 = localObject5;
        localObject3 = localObject5;
        long l = ((Cursor)localObject5).getLong(0);
        i = (int)l;
      }
      j = i;
      if (localObject5 != null)
      {
        ((Cursor)localObject5).close();
        j = i;
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        localObject4 = localObject1;
        Log.w("Error getting numStoredHits");
        int j = k;
        if (localObject1 != null)
        {
          ((Cursor)localObject1).close();
          j = k;
        }
      }
    }
    finally
    {
      Object localObject4;
      if (localObject4 == null) {
        break label140;
      }
      ((Cursor)localObject4).close();
    }
    return j;
  }
  
  List<String> peekHitIds(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt <= 0) {
      Log.w("Invalid maxHits specified. Skipping");
    }
    for (;;)
    {
      return localArrayList;
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase("Error opening database for peekHitIds.");
      if (localSQLiteDatabase == null) {
        continue;
      }
      Object localObject3 = null;
      Cursor localCursor2 = null;
      Cursor localCursor1 = localCursor2;
      Object localObject1 = localObject3;
      try
      {
        String str1 = String.format("%s ASC", new Object[] { "hit_id" });
        localCursor1 = localCursor2;
        localObject1 = localObject3;
        String str2 = Integer.toString(paramInt);
        localCursor1 = localCursor2;
        localObject1 = localObject3;
        localCursor2 = localSQLiteDatabase.query("hits2", new String[] { "hit_id" }, null, null, null, null, str1, str2);
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        if (localCursor2.moveToFirst())
        {
          boolean bool;
          do
          {
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            localArrayList.add(String.valueOf(localCursor2.getLong(0)));
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            bool = localCursor2.moveToNext();
          } while (bool);
        }
        if (localCursor2 == null) {
          continue;
        }
        localCursor2.close();
        return localArrayList;
      }
      catch (SQLiteException localSQLiteException)
      {
        localObject1 = localCursor1;
        Log.w("Error in peekHits fetching hitIds: " + localSQLiteException.getMessage());
        if (localCursor1 == null) {
          continue;
        }
        localCursor1.close();
        return localArrayList;
      }
      finally
      {
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
  }
  
  /* Error */
  public List<Hit> peekHits(int paramInt)
  {
    // Byte code:
    //   0: new 161	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 460	java/util/ArrayList:<init>	()V
    //   7: astore 7
    //   9: aload_0
    //   10: ldc_w 485
    //   13: invokespecial 264	com/google/analytics/tracking/android/PersistentAnalyticsStore:getWritableDatabase	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 9
    //   18: aload 9
    //   20: ifnonnull +6 -> 26
    //   23: aload 7
    //   25: areturn
    //   26: aconst_null
    //   27: astore 8
    //   29: aconst_null
    //   30: astore 4
    //   32: aload 4
    //   34: astore 6
    //   36: aload 8
    //   38: astore 5
    //   40: ldc_w 466
    //   43: iconst_1
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: ldc 26
    //   51: aastore
    //   52: invokestatic 58	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   55: astore 10
    //   57: aload 4
    //   59: astore 6
    //   61: aload 8
    //   63: astore 5
    //   65: iload_1
    //   66: invokestatic 470	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   69: astore 11
    //   71: aload 4
    //   73: astore 6
    //   75: aload 8
    //   77: astore 5
    //   79: aload 9
    //   81: ldc 19
    //   83: iconst_2
    //   84: anewarray 54	java/lang/String
    //   87: dup
    //   88: iconst_0
    //   89: ldc 26
    //   91: aastore
    //   92: dup
    //   93: iconst_1
    //   94: ldc 32
    //   96: aastore
    //   97: aconst_null
    //   98: aconst_null
    //   99: aconst_null
    //   100: aconst_null
    //   101: aload 10
    //   103: aload 11
    //   105: invokevirtual 474	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   108: astore 4
    //   110: aload 4
    //   112: astore 6
    //   114: aload 4
    //   116: astore 5
    //   118: new 161	java/util/ArrayList
    //   121: dup
    //   122: invokespecial 460	java/util/ArrayList:<init>	()V
    //   125: astore 8
    //   127: aload 4
    //   129: invokeinterface 452 1 0
    //   134: ifeq +47 -> 181
    //   137: aload 8
    //   139: new 345	com/google/analytics/tracking/android/Hit
    //   142: dup
    //   143: aconst_null
    //   144: aload 4
    //   146: iconst_0
    //   147: invokeinterface 456 2 0
    //   152: aload 4
    //   154: iconst_1
    //   155: invokeinterface 456 2 0
    //   160: invokespecial 488	com/google/analytics/tracking/android/Hit:<init>	(Ljava/lang/String;JJ)V
    //   163: invokeinterface 205 2 0
    //   168: pop
    //   169: aload 4
    //   171: invokeinterface 477 1 0
    //   176: istore_3
    //   177: iload_3
    //   178: ifne -41 -> 137
    //   181: aload 4
    //   183: ifnull +10 -> 193
    //   186: aload 4
    //   188: invokeinterface 457 1 0
    //   193: iconst_0
    //   194: istore_2
    //   195: aload 4
    //   197: astore 6
    //   199: aload 4
    //   201: astore 5
    //   203: ldc_w 466
    //   206: iconst_1
    //   207: anewarray 4	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: ldc 26
    //   214: aastore
    //   215: invokestatic 58	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   218: astore 7
    //   220: aload 4
    //   222: astore 6
    //   224: aload 4
    //   226: astore 5
    //   228: iload_1
    //   229: invokestatic 470	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   232: astore 10
    //   234: aload 4
    //   236: astore 6
    //   238: aload 4
    //   240: astore 5
    //   242: aload 9
    //   244: ldc 19
    //   246: iconst_3
    //   247: anewarray 54	java/lang/String
    //   250: dup
    //   251: iconst_0
    //   252: ldc 26
    //   254: aastore
    //   255: dup
    //   256: iconst_1
    //   257: ldc 29
    //   259: aastore
    //   260: dup
    //   261: iconst_2
    //   262: ldc 35
    //   264: aastore
    //   265: aconst_null
    //   266: aconst_null
    //   267: aconst_null
    //   268: aconst_null
    //   269: aload 7
    //   271: aload 10
    //   273: invokevirtual 474	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   276: astore 4
    //   278: aload 4
    //   280: astore 6
    //   282: aload 4
    //   284: astore 5
    //   286: aload 4
    //   288: invokeinterface 452 1 0
    //   293: ifeq +111 -> 404
    //   296: iload_2
    //   297: istore_1
    //   298: aload 4
    //   300: astore 6
    //   302: aload 4
    //   304: astore 5
    //   306: aload 4
    //   308: checkcast 490	android/database/sqlite/SQLiteCursor
    //   311: invokevirtual 494	android/database/sqlite/SQLiteCursor:getWindow	()Landroid/database/CursorWindow;
    //   314: invokevirtual 499	android/database/CursorWindow:getNumRows	()I
    //   317: ifle +187 -> 504
    //   320: aload 4
    //   322: astore 6
    //   324: aload 4
    //   326: astore 5
    //   328: aload 8
    //   330: iload_1
    //   331: invokeinterface 502 2 0
    //   336: checkcast 345	com/google/analytics/tracking/android/Hit
    //   339: aload 4
    //   341: iconst_1
    //   342: invokeinterface 505 2 0
    //   347: invokevirtual 508	com/google/analytics/tracking/android/Hit:setHitString	(Ljava/lang/String;)V
    //   350: aload 4
    //   352: astore 6
    //   354: aload 4
    //   356: astore 5
    //   358: aload 8
    //   360: iload_1
    //   361: invokeinterface 502 2 0
    //   366: checkcast 345	com/google/analytics/tracking/android/Hit
    //   369: aload 4
    //   371: iconst_2
    //   372: invokeinterface 505 2 0
    //   377: invokevirtual 511	com/google/analytics/tracking/android/Hit:setHitUrl	(Ljava/lang/String;)V
    //   380: iload_1
    //   381: iconst_1
    //   382: iadd
    //   383: istore_1
    //   384: aload 4
    //   386: astore 6
    //   388: aload 4
    //   390: astore 5
    //   392: aload 4
    //   394: invokeinterface 477 1 0
    //   399: istore_3
    //   400: iload_3
    //   401: ifne -103 -> 298
    //   404: aload 4
    //   406: ifnull +10 -> 416
    //   409: aload 4
    //   411: invokeinterface 457 1 0
    //   416: aload 8
    //   418: areturn
    //   419: astore 4
    //   421: aload 7
    //   423: astore 8
    //   425: aload 4
    //   427: astore 7
    //   429: aload 6
    //   431: astore 4
    //   433: aload 4
    //   435: astore 5
    //   437: new 179	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   444: ldc_w 479
    //   447: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload 7
    //   452: invokevirtual 482	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   455: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 227	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)V
    //   464: aload 4
    //   466: ifnull +10 -> 476
    //   469: aload 4
    //   471: invokeinterface 457 1 0
    //   476: aload 8
    //   478: areturn
    //   479: astore 6
    //   481: aload 5
    //   483: astore 4
    //   485: aload 6
    //   487: astore 5
    //   489: aload 4
    //   491: ifnull +10 -> 501
    //   494: aload 4
    //   496: invokeinterface 457 1 0
    //   501: aload 5
    //   503: athrow
    //   504: aload 4
    //   506: astore 6
    //   508: aload 4
    //   510: astore 5
    //   512: ldc_w 513
    //   515: iconst_1
    //   516: anewarray 4	java/lang/Object
    //   519: dup
    //   520: iconst_0
    //   521: aload 8
    //   523: iload_1
    //   524: invokeinterface 502 2 0
    //   529: checkcast 345	com/google/analytics/tracking/android/Hit
    //   532: invokevirtual 349	com/google/analytics/tracking/android/Hit:getHitId	()J
    //   535: invokestatic 278	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   538: aastore
    //   539: invokestatic 58	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   542: invokestatic 227	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)V
    //   545: goto -165 -> 380
    //   548: astore 4
    //   550: aload 6
    //   552: astore 5
    //   554: new 179	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   561: ldc_w 515
    //   564: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: aload 4
    //   569: invokevirtual 482	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   572: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   578: invokestatic 227	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)V
    //   581: aload 6
    //   583: astore 5
    //   585: new 161	java/util/ArrayList
    //   588: dup
    //   589: invokespecial 460	java/util/ArrayList:<init>	()V
    //   592: astore 4
    //   594: iconst_0
    //   595: istore_1
    //   596: aload 6
    //   598: astore 5
    //   600: aload 8
    //   602: invokeinterface 516 1 0
    //   607: astore 7
    //   609: aload 6
    //   611: astore 5
    //   613: aload 7
    //   615: invokeinterface 131 1 0
    //   620: ifeq +42 -> 662
    //   623: aload 6
    //   625: astore 5
    //   627: aload 7
    //   629: invokeinterface 135 1 0
    //   634: checkcast 345	com/google/analytics/tracking/android/Hit
    //   637: astore 8
    //   639: aload 6
    //   641: astore 5
    //   643: aload 8
    //   645: invokevirtual 519	com/google/analytics/tracking/android/Hit:getHitParams	()Ljava/lang/String;
    //   648: invokestatic 522	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   651: istore_3
    //   652: iload_1
    //   653: istore_2
    //   654: iload_3
    //   655: ifeq +24 -> 679
    //   658: iload_1
    //   659: ifeq +18 -> 677
    //   662: aload 6
    //   664: ifnull +10 -> 674
    //   667: aload 6
    //   669: invokeinterface 457 1 0
    //   674: aload 4
    //   676: areturn
    //   677: iconst_1
    //   678: istore_2
    //   679: aload 6
    //   681: astore 5
    //   683: aload 4
    //   685: aload 8
    //   687: invokeinterface 205 2 0
    //   692: pop
    //   693: iload_2
    //   694: istore_1
    //   695: goto -86 -> 609
    //   698: astore 4
    //   700: aload 5
    //   702: ifnull +10 -> 712
    //   705: aload 5
    //   707: invokeinterface 457 1 0
    //   712: aload 4
    //   714: athrow
    //   715: astore 5
    //   717: goto -228 -> 489
    //   720: astore 7
    //   722: goto -289 -> 433
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	725	0	this	PersistentAnalyticsStore
    //   0	725	1	paramInt	int
    //   194	500	2	i	int
    //   176	479	3	bool	boolean
    //   30	380	4	localCursor1	Cursor
    //   419	7	4	localSQLiteException1	SQLiteException
    //   431	78	4	localObject1	Object
    //   548	20	4	localSQLiteException2	SQLiteException
    //   592	92	4	localArrayList	ArrayList
    //   698	15	4	localObject2	Object
    //   38	668	5	localObject3	Object
    //   715	1	5	localObject4	Object
    //   34	396	6	localCursor2	Cursor
    //   479	7	6	localObject5	Object
    //   506	174	6	localObject6	Object
    //   7	621	7	localObject7	Object
    //   720	1	7	localSQLiteException3	SQLiteException
    //   27	659	8	localObject8	Object
    //   16	227	9	localSQLiteDatabase	SQLiteDatabase
    //   55	217	10	str1	String
    //   69	35	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   40	57	419	android/database/sqlite/SQLiteException
    //   65	71	419	android/database/sqlite/SQLiteException
    //   79	110	419	android/database/sqlite/SQLiteException
    //   118	127	419	android/database/sqlite/SQLiteException
    //   40	57	479	finally
    //   65	71	479	finally
    //   79	110	479	finally
    //   118	127	479	finally
    //   437	464	479	finally
    //   203	220	548	android/database/sqlite/SQLiteException
    //   228	234	548	android/database/sqlite/SQLiteException
    //   242	278	548	android/database/sqlite/SQLiteException
    //   286	296	548	android/database/sqlite/SQLiteException
    //   306	320	548	android/database/sqlite/SQLiteException
    //   328	350	548	android/database/sqlite/SQLiteException
    //   358	380	548	android/database/sqlite/SQLiteException
    //   392	400	548	android/database/sqlite/SQLiteException
    //   512	545	548	android/database/sqlite/SQLiteException
    //   203	220	698	finally
    //   228	234	698	finally
    //   242	278	698	finally
    //   286	296	698	finally
    //   306	320	698	finally
    //   328	350	698	finally
    //   358	380	698	finally
    //   392	400	698	finally
    //   512	545	698	finally
    //   554	581	698	finally
    //   585	594	698	finally
    //   600	609	698	finally
    //   613	623	698	finally
    //   627	639	698	finally
    //   643	652	698	finally
    //   683	693	698	finally
    //   127	137	715	finally
    //   137	177	715	finally
    //   127	137	720	android/database/sqlite/SQLiteException
    //   137	177	720	android/database/sqlite/SQLiteException
  }
  
  public void putHit(Map<String, String> paramMap, long paramLong, String paramString, Collection<Command> paramCollection)
  {
    deleteStaleHits();
    removeOldHitIfFull();
    fillVersionParameter(paramMap, paramCollection);
    writeHitToDatabase(paramMap, paramLong, paramString);
  }
  
  @VisibleForTesting
  public void setClock(Clock paramClock)
  {
    this.mClock = paramClock;
  }
  
  public void setDispatch(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = new SimpleNetworkDispatcher(new DefaultHttpClient(), this.mContext);; localObject = new NoopDispatcher())
    {
      this.mDispatcher = ((Dispatcher)localObject);
      return;
    }
  }
  
  @VisibleForTesting
  void setDispatcher(Dispatcher paramDispatcher)
  {
    this.mDispatcher = paramDispatcher;
  }
  
  @VisibleForTesting
  void setLastDeleteStaleHitsTime(long paramLong)
  {
    this.mLastDeleteStaleHitsTime = paramLong;
  }
  
  @VisibleForTesting
  class AnalyticsDatabaseHelper
    extends SQLiteOpenHelper
  {
    private boolean mBadDatabase;
    private long mLastDatabaseCheckTime = 0L;
    
    AnalyticsDatabaseHelper(Context paramContext, String paramString)
    {
      super(paramString, null, 1);
    }
    
    private boolean tablePresent(String paramString, SQLiteDatabase paramSQLiteDatabase)
    {
      Object localObject = null;
      SQLiteDatabase localSQLiteDatabase = null;
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.query("SQLITE_MASTER", new String[] { "name" }, "name=?", new String[] { paramString }, null, null, null);
        localSQLiteDatabase = paramSQLiteDatabase;
        localObject = paramSQLiteDatabase;
        boolean bool = paramSQLiteDatabase.moveToFirst();
        if (paramSQLiteDatabase != null) {
          paramSQLiteDatabase.close();
        }
        return bool;
      }
      catch (SQLiteException paramSQLiteDatabase)
      {
        localObject = localSQLiteDatabase;
        Log.w("Error querying for table " + paramString);
        if (localSQLiteDatabase != null) {
          localSQLiteDatabase.close();
        }
        return false;
      }
      finally
      {
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
    
    private void validateColumnsPresent(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
      HashSet localHashSet = new HashSet();
      try
      {
        String[] arrayOfString = localCursor.getColumnNames();
        i = 0;
        while (i < arrayOfString.length)
        {
          localHashSet.add(arrayOfString[i]);
          i += 1;
        }
        localCursor.close();
        if ((!localHashSet.remove("hit_id")) || (!localHashSet.remove("hit_url")) || (!localHashSet.remove("hit_string")) || (!localHashSet.remove("hit_time"))) {
          throw new SQLiteException("Database column missing");
        }
      }
      finally
      {
        localCursor.close();
      }
      if (!localHashSet.remove("hit_app_id")) {}
      for (int i = 1; !localHashSet.isEmpty(); i = 0) {
        throw new SQLiteException("Database has extra columns");
      }
      if (i != 0) {
        paramSQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
      }
    }
    
    public SQLiteDatabase getWritableDatabase()
    {
      if ((this.mBadDatabase) && (this.mLastDatabaseCheckTime + 3600000L > PersistentAnalyticsStore.this.mClock.currentTimeMillis())) {
        throw new SQLiteException("Database creation failed");
      }
      Object localObject1 = null;
      this.mBadDatabase = true;
      this.mLastDatabaseCheckTime = PersistentAnalyticsStore.this.mClock.currentTimeMillis();
      try
      {
        localObject2 = super.getWritableDatabase();
        localObject1 = localObject2;
      }
      catch (SQLiteException localSQLiteException)
      {
        for (;;)
        {
          Object localObject2;
          PersistentAnalyticsStore.this.mContext.getDatabasePath(PersistentAnalyticsStore.this.mDatabaseName).delete();
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = super.getWritableDatabase();
      }
      this.mBadDatabase = false;
      return (SQLiteDatabase)localObject2;
    }
    
    boolean isBadDatabase()
    {
      return this.mBadDatabase;
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      FutureApis.setOwnerOnlyReadWrite(paramSQLiteDatabase.getPath());
    }
    
    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor;
      if (Build.VERSION.SDK_INT < 15) {
        localCursor = paramSQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
      }
      try
      {
        localCursor.moveToFirst();
        localCursor.close();
        if (!tablePresent("hits2", paramSQLiteDatabase))
        {
          paramSQLiteDatabase.execSQL(PersistentAnalyticsStore.CREATE_HITS_TABLE);
          return;
        }
      }
      finally
      {
        localCursor.close();
      }
      validateColumnsPresent(paramSQLiteDatabase);
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
    
    void setBadDatabase(boolean paramBoolean)
    {
      this.mBadDatabase = paramBoolean;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/analytics/tracking/android/PersistentAnalyticsStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */