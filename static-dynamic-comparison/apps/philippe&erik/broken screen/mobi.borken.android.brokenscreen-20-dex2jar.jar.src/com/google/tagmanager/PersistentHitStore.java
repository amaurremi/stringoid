package com.google.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class PersistentHitStore
  implements HitStore
{
  private static final String CREATE_HITS_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[] { "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time" });
  private static final String DATABASE_FILENAME = "gtm_urls.db";
  @VisibleForTesting
  static final String HITS_TABLE = "gtm_hits";
  static final long HIT_DISPATCH_RETRY_WINDOW = 14400000L;
  @VisibleForTesting
  static final String HIT_FIRST_DISPATCH_TIME = "hit_first_send_time";
  @VisibleForTesting
  static final String HIT_ID = "hit_id";
  private static final String HIT_ID_WHERE_CLAUSE = "hit_id=?";
  @VisibleForTesting
  static final String HIT_TIME = "hit_time";
  @VisibleForTesting
  static final String HIT_URL = "hit_url";
  private Clock mClock;
  private final Context mContext;
  private final String mDatabaseName;
  private final UrlDatabaseHelper mDbHelper;
  private volatile Dispatcher mDispatcher;
  private long mLastDeleteStaleHitsTime;
  private final HitStoreStateListener mListener;
  
  PersistentHitStore(HitStoreStateListener paramHitStoreStateListener, Context paramContext)
  {
    this(paramHitStoreStateListener, paramContext, "gtm_urls.db");
  }
  
  @VisibleForTesting
  PersistentHitStore(HitStoreStateListener paramHitStoreStateListener, Context paramContext, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mDatabaseName = paramString;
    this.mListener = paramHitStoreStateListener;
    this.mClock = new Clock()
    {
      public long currentTimeMillis()
      {
        return System.currentTimeMillis();
      }
    };
    this.mDbHelper = new UrlDatabaseHelper(this.mContext, this.mDatabaseName);
    this.mDispatcher = new SimpleNetworkDispatcher(new DefaultHttpClient(), this.mContext, new StoreDispatchListener());
    this.mLastDeleteStaleHitsTime = 0L;
  }
  
  private void deleteHit(long paramLong)
  {
    deleteHits(new String[] { String.valueOf(paramLong) });
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
  
  private void setHitFirstDispatchTime(long paramLong1, long paramLong2)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase("Error opening database for getNumStoredHits.");
    if (localSQLiteDatabase == null) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hit_first_send_time", Long.valueOf(paramLong2));
    try
    {
      localSQLiteDatabase.update("gtm_hits", localContentValues, "hit_id=?", new String[] { String.valueOf(paramLong1) });
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.w("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + paramLong1);
      deleteHit(paramLong1);
    }
  }
  
  private void writeHitToDatabase(long paramLong, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase("Error opening database for putHit");
    if (localSQLiteDatabase == null) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hit_time", Long.valueOf(paramLong));
    localContentValues.put("hit_url", paramString);
    localContentValues.put("hit_first_send_time", Integer.valueOf(0));
    try
    {
      localSQLiteDatabase.insert("gtm_hits", null, localContentValues);
      this.mListener.reportStoreIsEmpty(false);
      return;
    }
    catch (SQLiteException paramString)
    {
      Log.w("Error storing hit");
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
  
  void deleteHits(String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      localSQLiteDatabase = getWritableDatabase("Error opening database for deleteHits.");
    } while (localSQLiteDatabase == null);
    String str = String.format("HIT_ID in (%s)", new Object[] { TextUtils.join(",", Collections.nCopies(paramArrayOfString.length, "?")) });
    for (;;)
    {
      try
      {
        localSQLiteDatabase.delete("gtm_hits", str, paramArrayOfString);
        paramArrayOfString = this.mListener;
        if (getNumStoredHits() == 0)
        {
          paramArrayOfString.reportStoreIsEmpty(bool);
          return;
        }
      }
      catch (SQLiteException paramArrayOfString)
      {
        Log.w("Error deleting hits");
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
    int i = ((SQLiteDatabase)localObject).delete("gtm_hits", "HIT_TIME < ?", new String[] { Long.toString(this.mClock.currentTimeMillis() - 2592000000L) });
    Object localObject = this.mListener;
    if (getNumStoredHits() == 0) {}
    for (;;)
    {
      ((HitStoreStateListener)localObject).reportStoreIsEmpty(bool);
      return i;
      bool = false;
    }
  }
  
  public void dispatch()
  {
    Log.v("GTM Dispatch running...");
    if (!this.mDispatcher.okToDispatch()) {}
    do
    {
      return;
      List localList = peekHits(40);
      if (localList.isEmpty())
      {
        Log.v("...nothing to dispatch");
        this.mListener.reportStoreIsEmpty(true);
        return;
      }
      this.mDispatcher.dispatchHits(localList);
    } while (getNumStoredUntriedHits() <= 0);
    ServiceManagerImpl.getInstance().dispatch();
  }
  
  @VisibleForTesting
  public UrlDatabaseHelper getDbHelper()
  {
    return this.mDbHelper;
  }
  
  public Dispatcher getDispatcher()
  {
    return this.mDispatcher;
  }
  
  @VisibleForTesting
  UrlDatabaseHelper getHelper()
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
      localObject5 = ((SQLiteDatabase)localObject5).rawQuery("SELECT COUNT(*) from gtm_hits", null);
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
        break label139;
      }
      ((Cursor)localObject4).close();
    }
    return j;
  }
  
  int getNumStoredUntriedHits()
  {
    j = 0;
    Object localObject5 = getWritableDatabase("Error opening database for getNumStoredHits.");
    if (localObject5 == null) {
      return 0;
    }
    Object localObject3 = null;
    localObject1 = null;
    try
    {
      localObject5 = ((SQLiteDatabase)localObject5).query("gtm_hits", new String[] { "hit_id", "hit_first_send_time" }, "hit_first_send_time=0", null, null, null, null);
      localObject1 = localObject5;
      localObject3 = localObject5;
      i = ((Cursor)localObject5).getCount();
      j = i;
      i = j;
      if (localObject5 != null)
      {
        ((Cursor)localObject5).close();
        i = j;
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        localObject4 = localObject1;
        Log.w("Error getting num untried hits");
        int i = j;
        if (localObject1 != null)
        {
          ((Cursor)localObject1).close();
          i = j;
        }
      }
    }
    finally
    {
      Object localObject4;
      if (localObject4 == null) {
        break label128;
      }
      ((Cursor)localObject4).close();
    }
    return i;
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
        localCursor2 = localSQLiteDatabase.query("gtm_hits", new String[] { "hit_id" }, null, null, null, null, str1, str2);
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
    //   0: new 362	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 363	java/util/ArrayList:<init>	()V
    //   7: astore 7
    //   9: aload_0
    //   10: ldc_w 391
    //   13: invokespecial 195	com/google/tagmanager/PersistentHitStore:getWritableDatabase	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
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
    //   40: ldc_w 369
    //   43: iconst_1
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: ldc 33
    //   51: aastore
    //   52: invokestatic 64	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   55: astore 10
    //   57: aload 4
    //   59: astore 6
    //   61: aload 8
    //   63: astore 5
    //   65: iload_1
    //   66: invokestatic 372	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   69: astore 11
    //   71: aload 4
    //   73: astore 6
    //   75: aload 8
    //   77: astore 5
    //   79: aload 9
    //   81: ldc 22
    //   83: iconst_3
    //   84: anewarray 60	java/lang/String
    //   87: dup
    //   88: iconst_0
    //   89: ldc 33
    //   91: aastore
    //   92: dup
    //   93: iconst_1
    //   94: ldc 39
    //   96: aastore
    //   97: dup
    //   98: iconst_2
    //   99: ldc 30
    //   101: aastore
    //   102: aconst_null
    //   103: aconst_null
    //   104: aconst_null
    //   105: aconst_null
    //   106: aload 10
    //   108: aload 11
    //   110: invokevirtual 375	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   113: astore 4
    //   115: aload 4
    //   117: astore 6
    //   119: aload 4
    //   121: astore 5
    //   123: new 362	java/util/ArrayList
    //   126: dup
    //   127: invokespecial 363	java/util/ArrayList:<init>	()V
    //   130: astore 8
    //   132: aload 4
    //   134: invokeinterface 342 1 0
    //   139: ifeq +54 -> 193
    //   142: aload 8
    //   144: new 393	com/google/tagmanager/Hit
    //   147: dup
    //   148: aload 4
    //   150: iconst_0
    //   151: invokeinterface 346 2 0
    //   156: aload 4
    //   158: iconst_1
    //   159: invokeinterface 346 2 0
    //   164: aload 4
    //   166: iconst_2
    //   167: invokeinterface 346 2 0
    //   172: invokespecial 396	com/google/tagmanager/Hit:<init>	(JJJ)V
    //   175: invokeinterface 379 2 0
    //   180: pop
    //   181: aload 4
    //   183: invokeinterface 382 1 0
    //   188: istore_3
    //   189: iload_3
    //   190: ifne -48 -> 142
    //   193: aload 4
    //   195: ifnull +10 -> 205
    //   198: aload 4
    //   200: invokeinterface 347 1 0
    //   205: iconst_0
    //   206: istore_2
    //   207: aload 4
    //   209: astore 6
    //   211: aload 4
    //   213: astore 5
    //   215: ldc_w 369
    //   218: iconst_1
    //   219: anewarray 4	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: ldc 33
    //   226: aastore
    //   227: invokestatic 64	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   230: astore 7
    //   232: aload 4
    //   234: astore 6
    //   236: aload 4
    //   238: astore 5
    //   240: iload_1
    //   241: invokestatic 372	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   244: astore 10
    //   246: aload 4
    //   248: astore 6
    //   250: aload 4
    //   252: astore 5
    //   254: aload 9
    //   256: ldc 22
    //   258: iconst_2
    //   259: anewarray 60	java/lang/String
    //   262: dup
    //   263: iconst_0
    //   264: ldc 33
    //   266: aastore
    //   267: dup
    //   268: iconst_1
    //   269: ldc 42
    //   271: aastore
    //   272: aconst_null
    //   273: aconst_null
    //   274: aconst_null
    //   275: aconst_null
    //   276: aload 7
    //   278: aload 10
    //   280: invokevirtual 375	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   283: astore 4
    //   285: aload 4
    //   287: astore 6
    //   289: aload 4
    //   291: astore 5
    //   293: aload 4
    //   295: invokeinterface 342 1 0
    //   300: ifeq +81 -> 381
    //   303: iload_2
    //   304: istore_1
    //   305: aload 4
    //   307: astore 6
    //   309: aload 4
    //   311: astore 5
    //   313: aload 4
    //   315: checkcast 398	android/database/sqlite/SQLiteCursor
    //   318: invokevirtual 402	android/database/sqlite/SQLiteCursor:getWindow	()Landroid/database/CursorWindow;
    //   321: invokevirtual 407	android/database/CursorWindow:getNumRows	()I
    //   324: ifle +157 -> 481
    //   327: aload 4
    //   329: astore 6
    //   331: aload 4
    //   333: astore 5
    //   335: aload 8
    //   337: iload_1
    //   338: invokeinterface 411 2 0
    //   343: checkcast 393	com/google/tagmanager/Hit
    //   346: aload 4
    //   348: iconst_1
    //   349: invokeinterface 414 2 0
    //   354: invokevirtual 417	com/google/tagmanager/Hit:setHitUrl	(Ljava/lang/String;)V
    //   357: iload_1
    //   358: iconst_1
    //   359: iadd
    //   360: istore_1
    //   361: aload 4
    //   363: astore 6
    //   365: aload 4
    //   367: astore 5
    //   369: aload 4
    //   371: invokeinterface 382 1 0
    //   376: istore_3
    //   377: iload_3
    //   378: ifne -73 -> 305
    //   381: aload 4
    //   383: ifnull +10 -> 393
    //   386: aload 4
    //   388: invokeinterface 347 1 0
    //   393: aload 8
    //   395: areturn
    //   396: astore 4
    //   398: aload 7
    //   400: astore 8
    //   402: aload 4
    //   404: astore 7
    //   406: aload 6
    //   408: astore 4
    //   410: aload 4
    //   412: astore 5
    //   414: new 162	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 384
    //   424: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload 7
    //   429: invokevirtual 387	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   432: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 151	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   441: aload 4
    //   443: ifnull +10 -> 453
    //   446: aload 4
    //   448: invokeinterface 347 1 0
    //   453: aload 8
    //   455: areturn
    //   456: astore 6
    //   458: aload 5
    //   460: astore 4
    //   462: aload 6
    //   464: astore 5
    //   466: aload 4
    //   468: ifnull +10 -> 478
    //   471: aload 4
    //   473: invokeinterface 347 1 0
    //   478: aload 5
    //   480: athrow
    //   481: aload 4
    //   483: astore 6
    //   485: aload 4
    //   487: astore 5
    //   489: ldc_w 419
    //   492: iconst_1
    //   493: anewarray 4	java/lang/Object
    //   496: dup
    //   497: iconst_0
    //   498: aload 8
    //   500: iload_1
    //   501: invokeinterface 411 2 0
    //   506: checkcast 393	com/google/tagmanager/Hit
    //   509: invokevirtual 422	com/google/tagmanager/Hit:getHitId	()J
    //   512: invokestatic 203	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   515: aastore
    //   516: invokestatic 64	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   519: invokestatic 151	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   522: goto -165 -> 357
    //   525: astore 4
    //   527: aload 6
    //   529: astore 5
    //   531: new 162	java/lang/StringBuilder
    //   534: dup
    //   535: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   538: ldc_w 424
    //   541: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload 4
    //   546: invokevirtual 387	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   549: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokestatic 151	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   558: aload 6
    //   560: astore 5
    //   562: new 362	java/util/ArrayList
    //   565: dup
    //   566: invokespecial 363	java/util/ArrayList:<init>	()V
    //   569: astore 4
    //   571: iconst_0
    //   572: istore_1
    //   573: aload 6
    //   575: astore 5
    //   577: aload 8
    //   579: invokeinterface 428 1 0
    //   584: astore 7
    //   586: aload 6
    //   588: astore 5
    //   590: aload 7
    //   592: invokeinterface 433 1 0
    //   597: ifeq +42 -> 639
    //   600: aload 6
    //   602: astore 5
    //   604: aload 7
    //   606: invokeinterface 437 1 0
    //   611: checkcast 393	com/google/tagmanager/Hit
    //   614: astore 8
    //   616: aload 6
    //   618: astore 5
    //   620: aload 8
    //   622: invokevirtual 440	com/google/tagmanager/Hit:getHitUrl	()Ljava/lang/String;
    //   625: invokestatic 443	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   628: istore_3
    //   629: iload_1
    //   630: istore_2
    //   631: iload_3
    //   632: ifeq +24 -> 656
    //   635: iload_1
    //   636: ifeq +18 -> 654
    //   639: aload 6
    //   641: ifnull +10 -> 651
    //   644: aload 6
    //   646: invokeinterface 347 1 0
    //   651: aload 4
    //   653: areturn
    //   654: iconst_1
    //   655: istore_2
    //   656: aload 6
    //   658: astore 5
    //   660: aload 4
    //   662: aload 8
    //   664: invokeinterface 379 2 0
    //   669: pop
    //   670: iload_2
    //   671: istore_1
    //   672: goto -86 -> 586
    //   675: astore 4
    //   677: aload 5
    //   679: ifnull +10 -> 689
    //   682: aload 5
    //   684: invokeinterface 347 1 0
    //   689: aload 4
    //   691: athrow
    //   692: astore 5
    //   694: goto -228 -> 466
    //   697: astore 7
    //   699: goto -289 -> 410
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	702	0	this	PersistentHitStore
    //   0	702	1	paramInt	int
    //   206	465	2	i	int
    //   188	444	3	bool	boolean
    //   30	357	4	localCursor1	Cursor
    //   396	7	4	localSQLiteException1	SQLiteException
    //   408	78	4	localObject1	Object
    //   525	20	4	localSQLiteException2	SQLiteException
    //   569	92	4	localArrayList	ArrayList
    //   675	15	4	localObject2	Object
    //   38	645	5	localObject3	Object
    //   692	1	5	localObject4	Object
    //   34	373	6	localCursor2	Cursor
    //   456	7	6	localObject5	Object
    //   483	174	6	localObject6	Object
    //   7	598	7	localObject7	Object
    //   697	1	7	localSQLiteException3	SQLiteException
    //   27	636	8	localObject8	Object
    //   16	239	9	localSQLiteDatabase	SQLiteDatabase
    //   55	224	10	str1	String
    //   69	40	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   40	57	396	android/database/sqlite/SQLiteException
    //   65	71	396	android/database/sqlite/SQLiteException
    //   79	115	396	android/database/sqlite/SQLiteException
    //   123	132	396	android/database/sqlite/SQLiteException
    //   40	57	456	finally
    //   65	71	456	finally
    //   79	115	456	finally
    //   123	132	456	finally
    //   414	441	456	finally
    //   215	232	525	android/database/sqlite/SQLiteException
    //   240	246	525	android/database/sqlite/SQLiteException
    //   254	285	525	android/database/sqlite/SQLiteException
    //   293	303	525	android/database/sqlite/SQLiteException
    //   313	327	525	android/database/sqlite/SQLiteException
    //   335	357	525	android/database/sqlite/SQLiteException
    //   369	377	525	android/database/sqlite/SQLiteException
    //   489	522	525	android/database/sqlite/SQLiteException
    //   215	232	675	finally
    //   240	246	675	finally
    //   254	285	675	finally
    //   293	303	675	finally
    //   313	327	675	finally
    //   335	357	675	finally
    //   369	377	675	finally
    //   489	522	675	finally
    //   531	558	675	finally
    //   562	571	675	finally
    //   577	586	675	finally
    //   590	600	675	finally
    //   604	616	675	finally
    //   620	629	675	finally
    //   660	670	675	finally
    //   132	142	692	finally
    //   142	189	692	finally
    //   132	142	697	android/database/sqlite/SQLiteException
    //   142	189	697	android/database/sqlite/SQLiteException
  }
  
  public void putHit(long paramLong, String paramString)
  {
    deleteStaleHits();
    removeOldHitIfFull();
    writeHitToDatabase(paramLong, paramString);
  }
  
  @VisibleForTesting
  public void setClock(Clock paramClock)
  {
    this.mClock = paramClock;
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
  class StoreDispatchListener
    implements SimpleNetworkDispatcher.DispatchListener
  {
    StoreDispatchListener() {}
    
    public void onHitDispatched(Hit paramHit)
    {
      PersistentHitStore.this.deleteHit(paramHit.getHitId());
    }
    
    public void onHitPermanentDispatchFailure(Hit paramHit)
    {
      PersistentHitStore.this.deleteHit(paramHit.getHitId());
      Log.v("Permanent failure dispatching hitId: " + paramHit.getHitId());
    }
    
    public void onHitTransientDispatchFailure(Hit paramHit)
    {
      long l = paramHit.getHitFirstDispatchTime();
      if (l == 0L) {
        PersistentHitStore.this.setHitFirstDispatchTime(paramHit.getHitId(), PersistentHitStore.this.mClock.currentTimeMillis());
      }
      while (14400000L + l >= PersistentHitStore.this.mClock.currentTimeMillis()) {
        return;
      }
      PersistentHitStore.this.deleteHit(paramHit.getHitId());
      Log.v("Giving up on failed hitId: " + paramHit.getHitId());
    }
  }
  
  @VisibleForTesting
  class UrlDatabaseHelper
    extends SQLiteOpenHelper
  {
    private boolean mBadDatabase;
    private long mLastDatabaseCheckTime = 0L;
    
    UrlDatabaseHelper(Context paramContext, String paramString)
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
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
      HashSet localHashSet = new HashSet();
      try
      {
        String[] arrayOfString = paramSQLiteDatabase.getColumnNames();
        int i = 0;
        while (i < arrayOfString.length)
        {
          localHashSet.add(arrayOfString[i]);
          i += 1;
        }
        paramSQLiteDatabase.close();
        if ((!localHashSet.remove("hit_id")) || (!localHashSet.remove("hit_url")) || (!localHashSet.remove("hit_time")) || (!localHashSet.remove("hit_first_send_time"))) {
          throw new SQLiteException("Database column missing");
        }
      }
      finally
      {
        paramSQLiteDatabase.close();
      }
      if (!((Set)localObject).isEmpty()) {
        throw new SQLiteException("Database has extra columns");
      }
    }
    
    public SQLiteDatabase getWritableDatabase()
    {
      if ((this.mBadDatabase) && (this.mLastDatabaseCheckTime + 3600000L > PersistentHitStore.this.mClock.currentTimeMillis())) {
        throw new SQLiteException("Database creation failed");
      }
      Object localObject1 = null;
      this.mBadDatabase = true;
      this.mLastDatabaseCheckTime = PersistentHitStore.this.mClock.currentTimeMillis();
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
          PersistentHitStore.this.mContext.getDatabasePath(PersistentHitStore.this.mDatabaseName).delete();
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
        if (!tablePresent("gtm_hits", paramSQLiteDatabase))
        {
          paramSQLiteDatabase.execSQL(PersistentHitStore.CREATE_HITS_TABLE);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/PersistentHitStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */