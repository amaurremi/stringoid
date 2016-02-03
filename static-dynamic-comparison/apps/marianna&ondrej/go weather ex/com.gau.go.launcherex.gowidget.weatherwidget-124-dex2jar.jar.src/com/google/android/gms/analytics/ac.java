package com.google.android.gms.analytics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.ef;
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

class ac
  implements d
{
  private static final String vx = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[] { "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id" });
  private final Context mContext;
  private final e sO;
  private i tg;
  private final String vA;
  private ab vB;
  private long vC;
  private final int vD;
  private final a vy;
  private volatile n vz;
  
  ac(e parame, Context paramContext)
  {
    this(parame, paramContext, "google_analytics_v4.db", 2000);
  }
  
  ac(e parame, Context paramContext, String paramString, int paramInt)
  {
    this.mContext = paramContext.getApplicationContext();
    this.vA = paramString;
    this.sO = parame;
    this.tg = new i()
    {
      public long currentTimeMillis()
      {
        return System.currentTimeMillis();
      }
    };
    this.vy = new a(this.mContext, this.vA);
    this.vz = new ah(new DefaultHttpClient(), this.mContext);
    this.vC = 0L;
    this.vD = paramInt;
  }
  
  private SQLiteDatabase L(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.vy.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      aa.z(paramString);
    }
    return null;
  }
  
  private void a(Map<String, String> paramMap, long paramLong, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = L("Error opening database for putHit");
    if (localSQLiteDatabase == null) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hit_string", w(paramMap));
    localContentValues.put("hit_time", Long.valueOf(paramLong));
    if (paramMap.containsKey("AppUID")) {}
    for (;;)
    {
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
          aa.z("Empty path: not sending hit");
          return;
        }
      }
      catch (NumberFormatException paramMap)
      {
        paramLong = 0L;
        continue;
        localContentValues.put("hit_url", paramMap);
        try
        {
          localSQLiteDatabase.insert("hits2", null, localContentValues);
          this.sO.r(false);
          return;
        }
        catch (SQLiteException paramMap)
        {
          aa.z("Error storing hit");
          return;
        }
      }
      paramLong = 0L;
    }
  }
  
  private void a(Map<String, String> paramMap, Collection<ef> paramCollection)
  {
    String str = "&_v".substring(1);
    if (paramCollection != null)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        ef localef = (ef)paramCollection.next();
        if ("appendVersion".equals(localef.getId())) {
          paramMap.put(str, localef.getValue());
        }
      }
    }
  }
  
  private void cV()
  {
    int i = cX() - this.vD + 1;
    if (i > 0)
    {
      List localList = s(i);
      aa.y("Store full, deleting " + localList.size() + " hits to make room.");
      a((String[])localList.toArray(new String[0]));
    }
  }
  
  static String w(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localArrayList.add(y.encode((String)localEntry.getKey()) + "=" + y.encode((String)localEntry.getValue()));
    }
    return TextUtils.join("&", localArrayList);
  }
  
  public void a(Map<String, String> paramMap, long paramLong, String paramString, Collection<ef> paramCollection)
  {
    cW();
    cV();
    a(paramMap, paramCollection);
    a(paramMap, paramLong, paramString);
  }
  
  void a(String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      aa.z("Empty hitIds passed to deleteHits.");
    }
    Object localObject;
    do
    {
      return;
      localObject = L("Error opening database for deleteHits.");
    } while (localObject == null);
    String str = String.format("HIT_ID in (%s)", new Object[] { TextUtils.join(",", Collections.nCopies(paramArrayOfString.length, "?")) });
    for (;;)
    {
      try
      {
        ((SQLiteDatabase)localObject).delete("hits2", str, paramArrayOfString);
        localObject = this.sO;
        if (cX() == 0)
        {
          ((e)localObject).r(bool);
          return;
        }
      }
      catch (SQLiteException localSQLiteException)
      {
        aa.z("Error deleting hits " + paramArrayOfString);
        return;
      }
      bool = false;
    }
  }
  
  @Deprecated
  void b(Collection<x> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty()))
    {
      aa.z("Empty/Null collection passed to deleteHits.");
      return;
    }
    String[] arrayOfString = new String[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfString[i] = String.valueOf(((x)paramCollection.next()).cP());
      i += 1;
    }
    a(arrayOfString);
  }
  
  public void bW()
  {
    boolean bool = true;
    aa.y("Dispatch running...");
    if (!this.vz.ch()) {
      return;
    }
    List localList = t(40);
    if (localList.isEmpty())
    {
      aa.y("...nothing to dispatch");
      this.sO.r(true);
      return;
    }
    if (this.vB == null) {
      this.vB = new ab("_t=dispatch&_v=ma4.0.1", true);
    }
    if (cX() <= localList.size()) {}
    for (;;)
    {
      int i = this.vz.a(localList, this.vB, bool);
      aa.y("sent " + i + " of " + localList.size() + " hits");
      b(localList.subList(0, Math.min(i, localList.size())));
      if ((i != localList.size()) || (cX() <= 0)) {
        break;
      }
      GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
      return;
      bool = false;
    }
    this.vB = null;
  }
  
  public n bX()
  {
    return this.vz;
  }
  
  int cW()
  {
    boolean bool = true;
    long l = this.tg.currentTimeMillis();
    if (l <= this.vC + 86400000L) {}
    do
    {
      return 0;
      this.vC = l;
      localObject = L("Error opening database for deleteStaleHits.");
    } while (localObject == null);
    int i = ((SQLiteDatabase)localObject).delete("hits2", "HIT_TIME < ?", new String[] { Long.toString(this.tg.currentTimeMillis() - 2592000000L) });
    Object localObject = this.sO;
    if (cX() == 0) {}
    for (;;)
    {
      ((e)localObject).r(bool);
      return i;
      bool = false;
    }
  }
  
  int cX()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    Object localObject5 = L("Error opening database for getNumStoredHits.");
    if (localObject5 == null) {}
    for (;;)
    {
      return j;
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
        return i;
      }
      catch (SQLiteException localSQLiteException)
      {
        localObject4 = localObject1;
        aa.z("Error getting numStoredHits");
        return 0;
      }
      finally
      {
        Object localObject4;
        if (localObject4 != null) {
          ((Cursor)localObject4).close();
        }
      }
    }
  }
  
  public void j(long paramLong)
  {
    boolean bool = true;
    Object localObject = L("Error opening database for clearHits");
    if (localObject != null)
    {
      if (paramLong != 0L) {
        break label54;
      }
      ((SQLiteDatabase)localObject).delete("hits2", null, null);
      localObject = this.sO;
      if (cX() != 0) {
        break label82;
      }
    }
    for (;;)
    {
      ((e)localObject).r(bool);
      return;
      label54:
      ((SQLiteDatabase)localObject).delete("hits2", "hit_app_id = ?", new String[] { Long.valueOf(paramLong).toString() });
      break;
      label82:
      bool = false;
    }
  }
  
  /* Error */
  List<String> s(int paramInt)
  {
    // Byte code:
    //   0: new 272	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 465	java/util/ArrayList:<init>	()V
    //   7: astore 6
    //   9: iload_1
    //   10: ifgt +12 -> 22
    //   13: ldc_w 467
    //   16: invokestatic 114	com/google/android/gms/analytics/aa:z	(Ljava/lang/String;)V
    //   19: aload 6
    //   21: areturn
    //   22: aload_0
    //   23: ldc_w 469
    //   26: invokespecial 122	com/google/android/gms/analytics/ac:L	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore_3
    //   30: aload_3
    //   31: ifnonnull +6 -> 37
    //   34: aload 6
    //   36: areturn
    //   37: ldc_w 471
    //   40: iconst_1
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: ldc 38
    //   48: aastore
    //   49: invokestatic 52	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   52: astore 4
    //   54: iload_1
    //   55: invokestatic 475	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   58: astore 5
    //   60: aload_3
    //   61: ldc 36
    //   63: iconst_1
    //   64: anewarray 48	java/lang/String
    //   67: dup
    //   68: iconst_0
    //   69: ldc 38
    //   71: aastore
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: aconst_null
    //   76: aload 4
    //   78: aload 5
    //   80: invokevirtual 479	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore 4
    //   85: aload 4
    //   87: astore_3
    //   88: aload 4
    //   90: invokeinterface 448 1 0
    //   95: ifeq +40 -> 135
    //   98: aload 4
    //   100: astore_3
    //   101: aload 6
    //   103: aload 4
    //   105: iconst_0
    //   106: invokeinterface 452 2 0
    //   111: invokestatic 363	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   114: invokeinterface 301 2 0
    //   119: pop
    //   120: aload 4
    //   122: astore_3
    //   123: aload 4
    //   125: invokeinterface 482 1 0
    //   130: istore_2
    //   131: iload_2
    //   132: ifne -34 -> 98
    //   135: aload 4
    //   137: ifnull +10 -> 147
    //   140: aload 4
    //   142: invokeinterface 455 1 0
    //   147: aload 6
    //   149: areturn
    //   150: astore 5
    //   152: aconst_null
    //   153: astore 4
    //   155: aload 4
    //   157: astore_3
    //   158: new 237	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 484
    //   168: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload 5
    //   173: invokevirtual 487	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   176: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 114	com/google/android/gms/analytics/aa:z	(Ljava/lang/String;)V
    //   185: aload 4
    //   187: ifnull -40 -> 147
    //   190: aload 4
    //   192: invokeinterface 455 1 0
    //   197: goto -50 -> 147
    //   200: astore 4
    //   202: aconst_null
    //   203: astore_3
    //   204: aload_3
    //   205: ifnull +9 -> 214
    //   208: aload_3
    //   209: invokeinterface 455 1 0
    //   214: aload 4
    //   216: athrow
    //   217: astore 4
    //   219: goto -15 -> 204
    //   222: astore 5
    //   224: goto -69 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	ac
    //   0	227	1	paramInt	int
    //   130	2	2	bool	boolean
    //   29	180	3	localObject1	Object
    //   52	139	4	localObject2	Object
    //   200	15	4	localObject3	Object
    //   217	1	4	localObject4	Object
    //   58	21	5	str	String
    //   150	22	5	localSQLiteException1	SQLiteException
    //   222	1	5	localSQLiteException2	SQLiteException
    //   7	141	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   37	85	150	android/database/sqlite/SQLiteException
    //   37	85	200	finally
    //   88	98	217	finally
    //   101	120	217	finally
    //   123	131	217	finally
    //   158	185	217	finally
    //   88	98	222	android/database/sqlite/SQLiteException
    //   101	120	222	android/database/sqlite/SQLiteException
    //   123	131	222	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public List<x> t(int paramInt)
  {
    // Byte code:
    //   0: new 272	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 465	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: ldc_w 490
    //   13: invokespecial 122	com/google/android/gms/analytics/ac:L	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 8
    //   18: aload 8
    //   20: ifnonnull +10 -> 30
    //   23: aload 5
    //   25: astore 6
    //   27: aload 6
    //   29: areturn
    //   30: aconst_null
    //   31: astore 4
    //   33: ldc_w 471
    //   36: iconst_1
    //   37: anewarray 4	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: ldc 38
    //   44: aastore
    //   45: invokestatic 52	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   48: astore 6
    //   50: iload_1
    //   51: invokestatic 475	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   54: astore 7
    //   56: aload 8
    //   58: ldc 36
    //   60: iconst_2
    //   61: anewarray 48	java/lang/String
    //   64: dup
    //   65: iconst_0
    //   66: ldc 38
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: ldc 40
    //   73: aastore
    //   74: aconst_null
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: aload 6
    //   80: aload 7
    //   82: invokevirtual 479	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   85: astore 6
    //   87: aload 6
    //   89: astore 4
    //   91: new 272	java/util/ArrayList
    //   94: dup
    //   95: invokespecial 465	java/util/ArrayList:<init>	()V
    //   98: astore 7
    //   100: aload 4
    //   102: invokeinterface 448 1 0
    //   107: ifeq +47 -> 154
    //   110: aload 7
    //   112: new 356	com/google/android/gms/analytics/x
    //   115: dup
    //   116: aconst_null
    //   117: aload 4
    //   119: iconst_0
    //   120: invokeinterface 452 2 0
    //   125: aload 4
    //   127: iconst_1
    //   128: invokeinterface 452 2 0
    //   133: invokespecial 493	com/google/android/gms/analytics/x:<init>	(Ljava/lang/String;JJ)V
    //   136: invokeinterface 301 2 0
    //   141: pop
    //   142: aload 4
    //   144: invokeinterface 482 1 0
    //   149: istore_3
    //   150: iload_3
    //   151: ifne -41 -> 110
    //   154: aload 4
    //   156: ifnull +10 -> 166
    //   159: aload 4
    //   161: invokeinterface 455 1 0
    //   166: aload 4
    //   168: astore 5
    //   170: ldc_w 471
    //   173: iconst_1
    //   174: anewarray 4	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: ldc 38
    //   181: aastore
    //   182: invokestatic 52	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   185: astore 6
    //   187: aload 4
    //   189: astore 5
    //   191: iload_1
    //   192: invokestatic 475	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   195: astore 9
    //   197: aload 4
    //   199: astore 5
    //   201: aload 8
    //   203: ldc 36
    //   205: iconst_3
    //   206: anewarray 48	java/lang/String
    //   209: dup
    //   210: iconst_0
    //   211: ldc 38
    //   213: aastore
    //   214: dup
    //   215: iconst_1
    //   216: ldc 44
    //   218: aastore
    //   219: dup
    //   220: iconst_2
    //   221: ldc 42
    //   223: aastore
    //   224: aconst_null
    //   225: aconst_null
    //   226: aconst_null
    //   227: aconst_null
    //   228: aload 6
    //   230: aload 9
    //   232: invokevirtual 479	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   235: astore 6
    //   237: aload 6
    //   239: invokeinterface 448 1 0
    //   244: ifeq +75 -> 319
    //   247: iconst_0
    //   248: istore_1
    //   249: aload 6
    //   251: checkcast 495	android/database/sqlite/SQLiteCursor
    //   254: invokevirtual 499	android/database/sqlite/SQLiteCursor:getWindow	()Landroid/database/CursorWindow;
    //   257: invokevirtual 504	android/database/CursorWindow:getNumRows	()I
    //   260: ifle +158 -> 418
    //   263: aload 7
    //   265: iload_1
    //   266: invokeinterface 507 2 0
    //   271: checkcast 356	com/google/android/gms/analytics/x
    //   274: aload 6
    //   276: iconst_1
    //   277: invokeinterface 510 2 0
    //   282: invokevirtual 512	com/google/android/gms/analytics/x:J	(Ljava/lang/String;)V
    //   285: aload 7
    //   287: iload_1
    //   288: invokeinterface 507 2 0
    //   293: checkcast 356	com/google/android/gms/analytics/x
    //   296: aload 6
    //   298: iconst_2
    //   299: invokeinterface 510 2 0
    //   304: invokevirtual 515	com/google/android/gms/analytics/x:K	(Ljava/lang/String;)V
    //   307: aload 6
    //   309: invokeinterface 482 1 0
    //   314: istore_3
    //   315: iload_3
    //   316: ifne +375 -> 691
    //   319: aload 6
    //   321: ifnull +10 -> 331
    //   324: aload 6
    //   326: invokeinterface 455 1 0
    //   331: aload 7
    //   333: areturn
    //   334: astore 6
    //   336: aconst_null
    //   337: astore 7
    //   339: aload 5
    //   341: astore 4
    //   343: aload 7
    //   345: astore 5
    //   347: new 237	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   354: ldc_w 484
    //   357: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload 6
    //   362: invokevirtual 487	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   365: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 114	com/google/android/gms/analytics/aa:z	(Ljava/lang/String;)V
    //   374: aload 4
    //   376: astore 6
    //   378: aload 5
    //   380: ifnull -353 -> 27
    //   383: aload 5
    //   385: invokeinterface 455 1 0
    //   390: aload 4
    //   392: areturn
    //   393: astore 6
    //   395: aload 4
    //   397: astore 5
    //   399: aload 6
    //   401: astore 4
    //   403: aload 5
    //   405: ifnull +10 -> 415
    //   408: aload 5
    //   410: invokeinterface 455 1 0
    //   415: aload 4
    //   417: athrow
    //   418: ldc_w 517
    //   421: iconst_1
    //   422: anewarray 4	java/lang/Object
    //   425: dup
    //   426: iconst_0
    //   427: aload 7
    //   429: iload_1
    //   430: invokeinterface 507 2 0
    //   435: checkcast 356	com/google/android/gms/analytics/x
    //   438: invokevirtual 360	com/google/android/gms/analytics/x:cP	()J
    //   441: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   444: aastore
    //   445: invokestatic 52	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   448: invokestatic 114	com/google/android/gms/analytics/aa:z	(Ljava/lang/String;)V
    //   451: goto -144 -> 307
    //   454: astore 5
    //   456: aload 6
    //   458: astore 4
    //   460: aload 5
    //   462: astore 6
    //   464: aload 4
    //   466: astore 5
    //   468: new 237	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   475: ldc_w 519
    //   478: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: aload 6
    //   483: invokevirtual 487	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   486: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 114	com/google/android/gms/analytics/aa:z	(Ljava/lang/String;)V
    //   495: aload 4
    //   497: astore 5
    //   499: new 272	java/util/ArrayList
    //   502: dup
    //   503: invokespecial 465	java/util/ArrayList:<init>	()V
    //   506: astore 6
    //   508: iconst_0
    //   509: istore_1
    //   510: aload 4
    //   512: astore 5
    //   514: aload 7
    //   516: invokeinterface 520 1 0
    //   521: astore 7
    //   523: aload 4
    //   525: astore 5
    //   527: aload 7
    //   529: invokeinterface 201 1 0
    //   534: ifeq +42 -> 576
    //   537: aload 4
    //   539: astore 5
    //   541: aload 7
    //   543: invokeinterface 205 1 0
    //   548: checkcast 356	com/google/android/gms/analytics/x
    //   551: astore 8
    //   553: aload 4
    //   555: astore 5
    //   557: aload 8
    //   559: invokevirtual 523	com/google/android/gms/analytics/x:cO	()Ljava/lang/String;
    //   562: invokestatic 526	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   565: istore_3
    //   566: iload_1
    //   567: istore_2
    //   568: iload_3
    //   569: ifeq +24 -> 593
    //   572: iload_1
    //   573: ifeq +18 -> 591
    //   576: aload 4
    //   578: ifnull +10 -> 588
    //   581: aload 4
    //   583: invokeinterface 455 1 0
    //   588: aload 6
    //   590: areturn
    //   591: iconst_1
    //   592: istore_2
    //   593: aload 4
    //   595: astore 5
    //   597: aload 6
    //   599: aload 8
    //   601: invokeinterface 301 2 0
    //   606: pop
    //   607: iload_2
    //   608: istore_1
    //   609: goto -86 -> 523
    //   612: astore 4
    //   614: aload 5
    //   616: ifnull +10 -> 626
    //   619: aload 5
    //   621: invokeinterface 455 1 0
    //   626: aload 4
    //   628: athrow
    //   629: astore 4
    //   631: aload 6
    //   633: astore 5
    //   635: goto -21 -> 614
    //   638: astore 6
    //   640: goto -176 -> 464
    //   643: astore 6
    //   645: aload 4
    //   647: astore 5
    //   649: aload 6
    //   651: astore 4
    //   653: goto -250 -> 403
    //   656: astore 4
    //   658: goto -255 -> 403
    //   661: astore 6
    //   663: aload 4
    //   665: astore 7
    //   667: aload 5
    //   669: astore 4
    //   671: aload 7
    //   673: astore 5
    //   675: goto -328 -> 347
    //   678: astore 6
    //   680: aload 4
    //   682: astore 5
    //   684: aload 7
    //   686: astore 4
    //   688: goto -341 -> 347
    //   691: iload_1
    //   692: iconst_1
    //   693: iadd
    //   694: istore_1
    //   695: goto -446 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	698	0	this	ac
    //   0	698	1	paramInt	int
    //   567	41	2	i	int
    //   149	420	3	bool	boolean
    //   31	563	4	localObject1	Object
    //   612	15	4	localObject2	Object
    //   629	17	4	localObject3	Object
    //   651	1	4	localObject4	Object
    //   656	8	4	localObject5	Object
    //   669	18	4	localObject6	Object
    //   7	402	5	localObject7	Object
    //   454	7	5	localSQLiteException1	SQLiteException
    //   466	217	5	localObject8	Object
    //   25	300	6	localObject9	Object
    //   334	27	6	localSQLiteException2	SQLiteException
    //   376	1	6	localObject10	Object
    //   393	64	6	localObject11	Object
    //   462	170	6	localObject12	Object
    //   638	1	6	localSQLiteException3	SQLiteException
    //   643	7	6	localObject13	Object
    //   661	1	6	localSQLiteException4	SQLiteException
    //   678	1	6	localSQLiteException5	SQLiteException
    //   54	631	7	localObject14	Object
    //   16	584	8	localObject15	Object
    //   195	36	9	str	String
    // Exception table:
    //   from	to	target	type
    //   33	87	334	android/database/sqlite/SQLiteException
    //   33	87	393	finally
    //   237	247	454	android/database/sqlite/SQLiteException
    //   249	307	454	android/database/sqlite/SQLiteException
    //   307	315	454	android/database/sqlite/SQLiteException
    //   418	451	454	android/database/sqlite/SQLiteException
    //   170	187	612	finally
    //   191	197	612	finally
    //   201	237	612	finally
    //   468	495	612	finally
    //   499	508	612	finally
    //   514	523	612	finally
    //   527	537	612	finally
    //   541	553	612	finally
    //   557	566	612	finally
    //   597	607	612	finally
    //   237	247	629	finally
    //   249	307	629	finally
    //   307	315	629	finally
    //   418	451	629	finally
    //   170	187	638	android/database/sqlite/SQLiteException
    //   191	197	638	android/database/sqlite/SQLiteException
    //   201	237	638	android/database/sqlite/SQLiteException
    //   91	100	643	finally
    //   100	110	643	finally
    //   110	150	643	finally
    //   347	374	656	finally
    //   91	100	661	android/database/sqlite/SQLiteException
    //   100	110	678	android/database/sqlite/SQLiteException
    //   110	150	678	android/database/sqlite/SQLiteException
  }
  
  class a
    extends SQLiteOpenHelper
  {
    private boolean vF;
    private long vG = 0L;
    
    a(Context paramContext, String paramString)
    {
      super(paramString, null, 1);
    }
    
    private void a(SQLiteDatabase paramSQLiteDatabase)
    {
      int j = 0;
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
      int i = j;
      if (!localHashSet.remove("hit_app_id")) {
        i = 1;
      }
      if (!localHashSet.isEmpty()) {
        throw new SQLiteException("Database has extra columns");
      }
      if (i != 0) {
        paramSQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
      }
    }
    
    /* Error */
    private boolean a(String paramString, SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: aload_2
      //   4: ldc 86
      //   6: iconst_1
      //   7: anewarray 88	java/lang/String
      //   10: dup
      //   11: iconst_0
      //   12: ldc 90
      //   14: aastore
      //   15: ldc 92
      //   17: iconst_1
      //   18: anewarray 88	java/lang/String
      //   21: dup
      //   22: iconst_0
      //   23: aload_1
      //   24: aastore
      //   25: aconst_null
      //   26: aconst_null
      //   27: aconst_null
      //   28: invokevirtual 96	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   31: astore_2
      //   32: aload_2
      //   33: invokeinterface 99 1 0
      //   38: istore_3
      //   39: aload_2
      //   40: ifnull +9 -> 49
      //   43: aload_2
      //   44: invokeinterface 52 1 0
      //   49: iload_3
      //   50: ireturn
      //   51: astore_2
      //   52: aconst_null
      //   53: astore_2
      //   54: new 101	java/lang/StringBuilder
      //   57: dup
      //   58: invokespecial 102	java/lang/StringBuilder:<init>	()V
      //   61: ldc 104
      //   63: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   66: aload_1
      //   67: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   70: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   73: invokestatic 117	com/google/android/gms/analytics/aa:z	(Ljava/lang/String;)V
      //   76: aload_2
      //   77: ifnull +9 -> 86
      //   80: aload_2
      //   81: invokeinterface 52 1 0
      //   86: iconst_0
      //   87: ireturn
      //   88: astore_1
      //   89: aload 4
      //   91: astore_2
      //   92: aload_2
      //   93: ifnull +9 -> 102
      //   96: aload_2
      //   97: invokeinterface 52 1 0
      //   102: aload_1
      //   103: athrow
      //   104: astore_1
      //   105: goto -13 -> 92
      //   108: astore_1
      //   109: goto -17 -> 92
      //   112: astore 4
      //   114: goto -60 -> 54
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	117	0	this	a
      //   0	117	1	paramString	String
      //   0	117	2	paramSQLiteDatabase	SQLiteDatabase
      //   38	12	3	bool	boolean
      //   1	89	4	localObject	Object
      //   112	1	4	localSQLiteException	SQLiteException
      // Exception table:
      //   from	to	target	type
      //   3	32	51	android/database/sqlite/SQLiteException
      //   3	32	88	finally
      //   32	39	104	finally
      //   54	76	108	finally
      //   32	39	112	android/database/sqlite/SQLiteException
    }
    
    public SQLiteDatabase getWritableDatabase()
    {
      if ((this.vF) && (this.vG + 3600000L > ac.a(ac.this).currentTimeMillis())) {
        throw new SQLiteException("Database creation failed");
      }
      Object localObject1 = null;
      this.vF = true;
      this.vG = ac.a(ac.this).currentTimeMillis();
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
          ac.c(ac.this).getDatabasePath(ac.b(ac.this)).delete();
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = super.getWritableDatabase();
      }
      this.vF = false;
      return (SQLiteDatabase)localObject2;
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      p.G(paramSQLiteDatabase.getPath());
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
        if (!a("hits2", paramSQLiteDatabase))
        {
          paramSQLiteDatabase.execSQL(ac.cY());
          return;
        }
      }
      finally
      {
        localCursor.close();
      }
      a(paramSQLiteDatabase);
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/analytics/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */