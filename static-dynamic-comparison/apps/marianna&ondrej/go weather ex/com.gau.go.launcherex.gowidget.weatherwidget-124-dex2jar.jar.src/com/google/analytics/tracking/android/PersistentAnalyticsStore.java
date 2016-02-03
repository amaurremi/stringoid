package com.google.analytics.tracking.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

class PersistentAnalyticsStore
  implements AnalyticsStore
{
  static final String BACKEND_LIBRARY_VERSION = "-s1";
  private static final String CREATE_HITS_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL);", new Object[] { "hits2", "hit_id", "hit_time", "hit_url", "hit_string" });
  private static final String DATABASE_FILENAME = "google_analytics_v2.db";
  private static final String HITS_TABLE = "hits2";
  private static final String HIT_ID = "hit_id";
  private static final String HIT_STRING = "hit_string";
  private static final String HIT_TIME = "hit_time";
  private static final String HIT_URL = "hit_url";
  static final long MAX_TOKENS = 120000L;
  static final long TIME_PER_TOKEN_MILLIS = 2000L;
  private final Context context;
  private final String databaseName;
  private final AnalyticsDatabaseHelper dbHelper;
  private volatile Dispatcher dispatcher;
  private long lastDeleteStaleHitsTime;
  private long lastTrackTime;
  private final AnalyticsStoreStateListener listener;
  private boolean throttlingEnabled = true;
  private long tokens = 120000L;
  
  PersistentAnalyticsStore(AnalyticsStoreStateListener paramAnalyticsStoreStateListener, Context paramContext)
  {
    this(paramAnalyticsStoreStateListener, paramContext, "google_analytics_v2.db");
  }
  
  PersistentAnalyticsStore(AnalyticsStoreStateListener paramAnalyticsStoreStateListener, Context paramContext, String paramString)
  {
    this.context = paramContext.getApplicationContext();
    this.databaseName = paramString;
    this.listener = paramAnalyticsStoreStateListener;
    this.dbHelper = new AnalyticsDatabaseHelper(this.context, this.databaseName);
    this.dispatcher = new SimpleNetworkDispatcher(this, createDefaultHttpClientFactory(), this.context);
    this.lastDeleteStaleHitsTime = 0L;
  }
  
  private HttpClientFactory createDefaultHttpClientFactory()
  {
    new HttpClientFactory()
    {
      public HttpClient newInstance()
      {
        return new DefaultHttpClient();
      }
    };
  }
  
  private void fillVersionParametersIfNecessary(Map<String, String> paramMap, Collection<Command> paramCollection)
  {
    Object localObject = paramCollection.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramCollection = (Command)((Iterator)localObject).next();
      if (paramCollection.getId().equals("appendVersion"))
      {
        localObject = paramCollection.getValue();
        storeVersion(paramMap, paramCollection.getUrlParam(), (String)localObject);
      }
    }
  }
  
  public static String generateHitString(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localArrayList.add((String)localEntry.getKey() + "=" + HitBuilder.encode((String)localEntry.getValue()));
    }
    return TextUtils.join("&", localArrayList);
  }
  
  private SQLiteDatabase getWritableDatabase(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.dbHelper.getWritableDatabase();
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
      List localList = peekHits(i);
      Log.wDebug("Store full, deleting " + localList.size() + " hits to make room");
      deleteHits(localList);
    }
  }
  
  private void storeVersion(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      paramString2 = "-s1";
    }
    for (;;)
    {
      if (paramString1 != null) {
        paramMap.put(paramString1, paramString2);
      }
      return;
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
    paramMap = paramString;
    if (paramString == null) {
      paramMap = "http://www.google-analytics.com/collect";
    }
    if (paramMap.length() == 0)
    {
      Log.w("empty path: not sending hit");
      return;
    }
    localContentValues.put("hit_url", paramMap);
    try
    {
      localSQLiteDatabase.insert("hits2", null, localContentValues);
      this.listener.reportStoreIsEmpty(false);
      return;
    }
    catch (SQLiteException paramMap)
    {
      Log.w("Error storing hit");
    }
  }
  
  public void clearHits()
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase("Error opening database for clearHits");
    if (localSQLiteDatabase != null)
    {
      localSQLiteDatabase.delete("hits2", null, null);
      this.listener.reportStoreIsEmpty(true);
    }
  }
  
  public void close()
  {
    try
    {
      this.dbHelper.getWritableDatabase().close();
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.w("Error opening database for close");
    }
  }
  
  public void deleteHits(Collection<Hit> paramCollection)
  {
    if (paramCollection == null) {
      throw new NullPointerException("hits cannot be null");
    }
    if (paramCollection.isEmpty()) {}
    Object localObject;
    do
    {
      return;
      localObject = getWritableDatabase("Error opening database for deleteHit");
    } while (localObject == null);
    String[] arrayOfString = new String[paramCollection.size()];
    String str = String.format("HIT_ID in (%s)", new Object[] { TextUtils.join(",", Collections.nCopies(arrayOfString.length, "?")) });
    int i = 0;
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      arrayOfString[i] = Long.toString(((Hit)localIterator.next()).getHitId());
      i += 1;
    }
    for (;;)
    {
      try
      {
        ((SQLiteDatabase)localObject).delete("hits2", str, arrayOfString);
        localObject = this.listener;
        if (getNumStoredHits() == 0)
        {
          bool = true;
          ((AnalyticsStoreStateListener)localObject).reportStoreIsEmpty(bool);
          return;
        }
      }
      catch (SQLiteException localSQLiteException)
      {
        Log.w("Error deleting hit " + paramCollection);
        return;
      }
      boolean bool = false;
    }
  }
  
  int deleteStaleHits()
  {
    boolean bool = true;
    long l = System.currentTimeMillis();
    if (l <= this.lastDeleteStaleHitsTime + 86400000L) {}
    do
    {
      return 0;
      this.lastDeleteStaleHitsTime = l;
      localObject = getWritableDatabase("Error opening database for deleteStaleHits");
    } while (localObject == null);
    int i = ((SQLiteDatabase)localObject).delete("hits2", "HIT_TIME < ?", new String[] { Long.toString(System.currentTimeMillis() - 2592000000L) });
    Object localObject = this.listener;
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
    Log.vDebug("dispatch running...");
    if (!this.dispatcher.okToDispatch()) {}
    List localList;
    int i;
    do
    {
      return;
      localList = peekHits(40);
      if (localList.isEmpty())
      {
        Log.vDebug("...nothing to dispatch");
        this.listener.reportStoreIsEmpty(true);
        return;
      }
      i = this.dispatcher.dispatchHits(localList);
      Log.vDebug("sent " + i + " of " + localList.size() + " hits");
      deleteHits(localList.subList(0, Math.min(i, localList.size())));
    } while ((i != localList.size()) || (getNumStoredHits() <= 0));
    GAServiceManager.getInstance().dispatch();
  }
  
  AnalyticsDatabaseHelper getHelper()
  {
    return this.dbHelper;
  }
  
  int getNumStoredHits()
  {
    k = 0;
    int i = 0;
    Object localObject5 = getWritableDatabase("Error opening database for requestNumHitsPending");
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
        break label141;
      }
      ((Cursor)localObject4).close();
    }
    return j;
  }
  
  /* Error */
  public List<Hit> peekHits(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 432
    //   4: invokespecial 261	com/google/analytics/tracking/android/PersistentAnalyticsStore:getWritableDatabase	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore 8
    //   9: aload 8
    //   11: ifnonnull +15 -> 26
    //   14: new 159	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 433	java/util/ArrayList:<init>	()V
    //   21: astore 5
    //   23: aload 5
    //   25: areturn
    //   26: aconst_null
    //   27: astore 7
    //   29: aconst_null
    //   30: astore 4
    //   32: new 159	java/util/ArrayList
    //   35: dup
    //   36: invokespecial 433	java/util/ArrayList:<init>	()V
    //   39: pop
    //   40: aload 4
    //   42: astore 6
    //   44: aload 7
    //   46: astore 5
    //   48: ldc_w 435
    //   51: iconst_2
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: ldc 34
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: ldc 25
    //   64: aastore
    //   65: invokestatic 65	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   68: astore 9
    //   70: aload 4
    //   72: astore 6
    //   74: aload 7
    //   76: astore 5
    //   78: iload_1
    //   79: invokestatic 440	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   82: astore 10
    //   84: aload 4
    //   86: astore 6
    //   88: aload 7
    //   90: astore 5
    //   92: aload 8
    //   94: ldc 22
    //   96: iconst_3
    //   97: anewarray 61	java/lang/String
    //   100: dup
    //   101: iconst_0
    //   102: ldc 25
    //   104: aastore
    //   105: dup
    //   106: iconst_1
    //   107: ldc 31
    //   109: aastore
    //   110: dup
    //   111: iconst_2
    //   112: ldc 34
    //   114: aastore
    //   115: aconst_null
    //   116: aconst_null
    //   117: aconst_null
    //   118: aconst_null
    //   119: aload 9
    //   121: aload 10
    //   123: invokevirtual 444	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   126: astore 4
    //   128: aload 4
    //   130: astore 6
    //   132: aload 4
    //   134: astore 5
    //   136: new 159	java/util/ArrayList
    //   139: dup
    //   140: invokespecial 433	java/util/ArrayList:<init>	()V
    //   143: astore 7
    //   145: aload 4
    //   147: invokeinterface 423 1 0
    //   152: ifeq +64 -> 216
    //   155: new 339	com/google/analytics/tracking/android/Hit
    //   158: dup
    //   159: aconst_null
    //   160: aload 4
    //   162: iconst_0
    //   163: invokeinterface 427 2 0
    //   168: aload 4
    //   170: iconst_1
    //   171: invokeinterface 427 2 0
    //   176: invokespecial 447	com/google/analytics/tracking/android/Hit:<init>	(Ljava/lang/String;JJ)V
    //   179: astore 5
    //   181: aload 5
    //   183: aload 4
    //   185: iconst_2
    //   186: invokeinterface 450 2 0
    //   191: invokevirtual 453	com/google/analytics/tracking/android/Hit:setHitUrl	(Ljava/lang/String;)V
    //   194: aload 7
    //   196: aload 5
    //   198: invokeinterface 205 2 0
    //   203: pop
    //   204: aload 4
    //   206: invokeinterface 456 1 0
    //   211: istore_3
    //   212: iload_3
    //   213: ifne -58 -> 155
    //   216: aload 4
    //   218: ifnull +10 -> 228
    //   221: aload 4
    //   223: invokeinterface 428 1 0
    //   228: iconst_0
    //   229: istore_2
    //   230: aload 4
    //   232: astore 6
    //   234: aload 4
    //   236: astore 5
    //   238: ldc_w 458
    //   241: iconst_1
    //   242: anewarray 4	java/lang/Object
    //   245: dup
    //   246: iconst_0
    //   247: ldc 25
    //   249: aastore
    //   250: invokestatic 65	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   253: astore 9
    //   255: aload 4
    //   257: astore 6
    //   259: aload 4
    //   261: astore 5
    //   263: iload_1
    //   264: invokestatic 440	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   267: astore 10
    //   269: aload 4
    //   271: astore 6
    //   273: aload 4
    //   275: astore 5
    //   277: aload 8
    //   279: ldc 22
    //   281: iconst_2
    //   282: anewarray 61	java/lang/String
    //   285: dup
    //   286: iconst_0
    //   287: ldc 25
    //   289: aastore
    //   290: dup
    //   291: iconst_1
    //   292: ldc 28
    //   294: aastore
    //   295: aconst_null
    //   296: aconst_null
    //   297: aconst_null
    //   298: aconst_null
    //   299: aload 9
    //   301: aload 10
    //   303: invokevirtual 444	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   306: astore 4
    //   308: aload 4
    //   310: astore 6
    //   312: aload 4
    //   314: astore 5
    //   316: aload 4
    //   318: invokeinterface 423 1 0
    //   323: ifeq +97 -> 420
    //   326: iload_2
    //   327: istore_1
    //   328: aload 4
    //   330: astore 6
    //   332: aload 4
    //   334: astore 5
    //   336: aload 4
    //   338: instanceof 460
    //   341: ifeq +377 -> 718
    //   344: aload 4
    //   346: astore 6
    //   348: aload 4
    //   350: astore 5
    //   352: aload 4
    //   354: checkcast 460	android/database/sqlite/SQLiteCursor
    //   357: invokevirtual 464	android/database/sqlite/SQLiteCursor:getWindow	()Landroid/database/CursorWindow;
    //   360: invokevirtual 469	android/database/CursorWindow:getNumRows	()I
    //   363: ifle +171 -> 534
    //   366: aload 4
    //   368: astore 6
    //   370: aload 4
    //   372: astore 5
    //   374: aload 7
    //   376: iload_1
    //   377: invokeinterface 473 2 0
    //   382: checkcast 339	com/google/analytics/tracking/android/Hit
    //   385: aload 4
    //   387: iconst_1
    //   388: invokeinterface 450 2 0
    //   393: invokevirtual 476	com/google/analytics/tracking/android/Hit:setHitString	(Ljava/lang/String;)V
    //   396: iload_1
    //   397: iconst_1
    //   398: iadd
    //   399: istore_1
    //   400: aload 4
    //   402: astore 6
    //   404: aload 4
    //   406: astore 5
    //   408: aload 4
    //   410: invokeinterface 456 1 0
    //   415: istore_3
    //   416: iload_3
    //   417: ifne -89 -> 328
    //   420: aload 7
    //   422: astore 5
    //   424: aload 4
    //   426: ifnull -403 -> 23
    //   429: aload 4
    //   431: invokeinterface 428 1 0
    //   436: aload 7
    //   438: areturn
    //   439: astore 7
    //   441: aload 6
    //   443: astore 4
    //   445: aload 4
    //   447: astore 5
    //   449: new 179	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   456: ldc_w 478
    //   459: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload 7
    //   464: invokevirtual 481	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   467: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 227	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)I
    //   476: pop
    //   477: aload 4
    //   479: astore 5
    //   481: new 159	java/util/ArrayList
    //   484: dup
    //   485: invokespecial 433	java/util/ArrayList:<init>	()V
    //   488: astore 6
    //   490: aload 6
    //   492: astore 5
    //   494: aload 4
    //   496: ifnull -473 -> 23
    //   499: aload 4
    //   501: invokeinterface 428 1 0
    //   506: aload 6
    //   508: areturn
    //   509: astore 6
    //   511: aload 5
    //   513: astore 4
    //   515: aload 6
    //   517: astore 5
    //   519: aload 4
    //   521: ifnull +10 -> 531
    //   524: aload 4
    //   526: invokeinterface 428 1 0
    //   531: aload 5
    //   533: athrow
    //   534: aload 4
    //   536: astore 6
    //   538: aload 4
    //   540: astore 5
    //   542: new 179	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 483
    //   552: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload 7
    //   557: iload_1
    //   558: invokeinterface 473 2 0
    //   563: checkcast 339	com/google/analytics/tracking/android/Hit
    //   566: invokevirtual 343	com/google/analytics/tracking/android/Hit:getHitId	()J
    //   569: invokevirtual 486	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   572: ldc_w 488
    //   575: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokestatic 227	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)I
    //   584: pop
    //   585: goto -189 -> 396
    //   588: astore 4
    //   590: aload 6
    //   592: astore 5
    //   594: new 179	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   601: ldc_w 490
    //   604: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: aload 4
    //   609: invokevirtual 481	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   612: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   618: invokestatic 227	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)I
    //   621: pop
    //   622: aload 6
    //   624: astore 5
    //   626: new 159	java/util/ArrayList
    //   629: dup
    //   630: invokespecial 433	java/util/ArrayList:<init>	()V
    //   633: astore 4
    //   635: iconst_0
    //   636: istore_1
    //   637: aload 6
    //   639: astore 5
    //   641: aload 7
    //   643: invokeinterface 491 1 0
    //   648: astore 7
    //   650: aload 6
    //   652: astore 5
    //   654: aload 7
    //   656: invokeinterface 128 1 0
    //   661: ifeq +42 -> 703
    //   664: aload 6
    //   666: astore 5
    //   668: aload 7
    //   670: invokeinterface 132 1 0
    //   675: checkcast 339	com/google/analytics/tracking/android/Hit
    //   678: astore 8
    //   680: aload 6
    //   682: astore 5
    //   684: aload 8
    //   686: invokevirtual 494	com/google/analytics/tracking/android/Hit:getHitParams	()Ljava/lang/String;
    //   689: invokestatic 497	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   692: istore_3
    //   693: iload_1
    //   694: istore_2
    //   695: iload_3
    //   696: ifeq +74 -> 770
    //   699: iload_1
    //   700: ifeq +68 -> 768
    //   703: aload 6
    //   705: ifnull +10 -> 715
    //   708: aload 6
    //   710: invokeinterface 428 1 0
    //   715: aload 4
    //   717: areturn
    //   718: aload 4
    //   720: astore 6
    //   722: aload 4
    //   724: astore 5
    //   726: aload 7
    //   728: iload_1
    //   729: invokeinterface 473 2 0
    //   734: checkcast 339	com/google/analytics/tracking/android/Hit
    //   737: aload 4
    //   739: iconst_1
    //   740: invokeinterface 450 2 0
    //   745: invokevirtual 476	com/google/analytics/tracking/android/Hit:setHitString	(Ljava/lang/String;)V
    //   748: goto -352 -> 396
    //   751: astore 4
    //   753: aload 5
    //   755: ifnull +10 -> 765
    //   758: aload 5
    //   760: invokeinterface 428 1 0
    //   765: aload 4
    //   767: athrow
    //   768: iconst_1
    //   769: istore_2
    //   770: aload 6
    //   772: astore 5
    //   774: aload 4
    //   776: aload 8
    //   778: invokeinterface 205 2 0
    //   783: pop
    //   784: iload_2
    //   785: istore_1
    //   786: goto -136 -> 650
    //   789: astore 5
    //   791: goto -272 -> 519
    //   794: astore 7
    //   796: goto -351 -> 445
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	799	0	this	PersistentAnalyticsStore
    //   0	799	1	paramInt	int
    //   229	556	2	i	int
    //   211	485	3	bool	boolean
    //   30	509	4	localObject1	Object
    //   588	20	4	localSQLiteException1	SQLiteException
    //   633	105	4	localArrayList1	ArrayList
    //   751	24	4	localObject2	Object
    //   21	752	5	localObject3	Object
    //   789	1	5	localObject4	Object
    //   42	465	6	localObject5	Object
    //   509	7	6	localObject6	Object
    //   536	235	6	localObject7	Object
    //   27	410	7	localArrayList2	ArrayList
    //   439	203	7	localSQLiteException2	SQLiteException
    //   648	79	7	localIterator	Iterator
    //   794	1	7	localSQLiteException3	SQLiteException
    //   7	770	8	localObject8	Object
    //   68	232	9	str1	String
    //   82	220	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   48	70	439	android/database/sqlite/SQLiteException
    //   78	84	439	android/database/sqlite/SQLiteException
    //   92	128	439	android/database/sqlite/SQLiteException
    //   136	145	439	android/database/sqlite/SQLiteException
    //   48	70	509	finally
    //   78	84	509	finally
    //   92	128	509	finally
    //   136	145	509	finally
    //   449	477	509	finally
    //   481	490	509	finally
    //   238	255	588	android/database/sqlite/SQLiteException
    //   263	269	588	android/database/sqlite/SQLiteException
    //   277	308	588	android/database/sqlite/SQLiteException
    //   316	326	588	android/database/sqlite/SQLiteException
    //   336	344	588	android/database/sqlite/SQLiteException
    //   352	366	588	android/database/sqlite/SQLiteException
    //   374	396	588	android/database/sqlite/SQLiteException
    //   408	416	588	android/database/sqlite/SQLiteException
    //   542	585	588	android/database/sqlite/SQLiteException
    //   726	748	588	android/database/sqlite/SQLiteException
    //   238	255	751	finally
    //   263	269	751	finally
    //   277	308	751	finally
    //   316	326	751	finally
    //   336	344	751	finally
    //   352	366	751	finally
    //   374	396	751	finally
    //   408	416	751	finally
    //   542	585	751	finally
    //   594	622	751	finally
    //   626	635	751	finally
    //   641	650	751	finally
    //   654	664	751	finally
    //   668	680	751	finally
    //   684	693	751	finally
    //   726	748	751	finally
    //   774	784	751	finally
    //   145	155	789	finally
    //   155	212	789	finally
    //   145	155	794	android/database/sqlite/SQLiteException
    //   155	212	794	android/database/sqlite/SQLiteException
  }
  
  public void putHit(Map<String, String> paramMap, long paramLong, String paramString, Collection<Command> paramCollection)
  {
    deleteStaleHits();
    if (!tokensAvailable()) {
      return;
    }
    fillVersionParametersIfNecessary(paramMap, paramCollection);
    removeOldHitIfFull();
    writeHitToDatabase(paramMap, paramLong, paramString);
  }
  
  public void setDispatch(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = new SimpleNetworkDispatcher(this, createDefaultHttpClientFactory(), this.context);; localObject = new NoopDispatcher())
    {
      this.dispatcher = ((Dispatcher)localObject);
      return;
    }
  }
  
  void setDispatcher(Dispatcher paramDispatcher)
  {
    this.dispatcher = paramDispatcher;
  }
  
  void setLastDeleteStaleHitsTime(long paramLong)
  {
    this.lastDeleteStaleHitsTime = paramLong;
  }
  
  void setLastTrackTime(long paramLong)
  {
    this.lastTrackTime = paramLong;
  }
  
  public void setThrottlingEnabled(boolean paramBoolean)
  {
    this.throttlingEnabled = paramBoolean;
  }
  
  void setTokens(long paramLong)
  {
    this.tokens = paramLong;
  }
  
  boolean tokensAvailable()
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        boolean bool2 = this.throttlingEnabled;
        if (!bool2) {
          return bool1;
        }
        long l1 = System.currentTimeMillis();
        if (this.tokens < 120000L)
        {
          long l2 = l1 - this.lastTrackTime;
          if (l2 > 0L) {
            this.tokens = Math.min(120000L, this.tokens + l2);
          }
        }
        this.lastTrackTime = l1;
        if (this.tokens >= 2000L)
        {
          this.tokens -= 2000L;
          continue;
        }
        Log.wDebug("Excessive tracking detected.  Tracking call ignored.");
      }
      finally {}
      bool1 = false;
    }
  }
  
  class AnalyticsDatabaseHelper
    extends SQLiteOpenHelper
  {
    private boolean badDatabase;
    
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
        Log.w("error querying for table " + paramString);
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
    
    public SQLiteDatabase getWritableDatabase()
    {
      if (this.badDatabase) {
        throw new SQLiteException("Database creation failed");
      }
      return super.getWritableDatabase();
    }
    
    boolean isBadDatabase()
    {
      return this.badDatabase;
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      FutureApis.setOwnerOnlyReadWrite(paramSQLiteDatabase.getPath());
    }
    
    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      try
      {
        if (!tablePresent("hits2", paramSQLiteDatabase)) {
          paramSQLiteDatabase.execSQL(PersistentAnalyticsStore.CREATE_HITS_TABLE);
        }
        return;
      }
      catch (SQLiteException paramSQLiteDatabase)
      {
        Log.w("Error on database open");
        this.badDatabase = true;
      }
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/analytics/tracking/android/PersistentAnalyticsStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */