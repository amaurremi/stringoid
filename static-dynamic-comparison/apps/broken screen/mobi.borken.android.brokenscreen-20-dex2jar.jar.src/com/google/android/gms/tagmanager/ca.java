package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.ik;
import com.google.android.gms.internal.im;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class ca
  implements at
{
  private static final String wM = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[] { "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time" });
  private ik aec;
  private final b agn;
  private volatile ab ago;
  private final au agp;
  private final Context mContext;
  private final String wP;
  private long wR;
  private final int wS;
  
  ca(au paramau, Context paramContext)
  {
    this(paramau, paramContext, "gtm_urls.db", 2000);
  }
  
  ca(au paramau, Context paramContext, String paramString, int paramInt)
  {
    this.mContext = paramContext.getApplicationContext();
    this.wP = paramString;
    this.agp = paramau;
    this.aec = im.fW();
    this.agn = new b(this.mContext, this.wP);
    this.ago = new da(new DefaultHttpClient(), this.mContext, new a());
    this.wR = 0L;
    this.wS = paramInt;
  }
  
  private SQLiteDatabase S(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.agn.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      bh.D(paramString);
    }
    return null;
  }
  
  private void c(long paramLong1, long paramLong2)
  {
    SQLiteDatabase localSQLiteDatabase = S("Error opening database for getNumStoredHits.");
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
      bh.D("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + paramLong1);
      y(paramLong1);
    }
  }
  
  private void dm()
  {
    int i = jdMethod_do() - this.wS + 1;
    if (i > 0)
    {
      List localList = A(i);
      bh.C("Store full, deleting " + localList.size() + " hits to make room.");
      a((String[])localList.toArray(new String[0]));
    }
  }
  
  private void g(long paramLong, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = S("Error opening database for putHit");
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
      this.agp.s(false);
      return;
    }
    catch (SQLiteException paramString)
    {
      bh.D("Error storing hit");
    }
  }
  
  private void y(long paramLong)
  {
    a(new String[] { String.valueOf(paramLong) });
  }
  
  /* Error */
  List<String> A(int paramInt)
  {
    // Byte code:
    //   0: new 237	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 238	java/util/ArrayList:<init>	()V
    //   7: astore 6
    //   9: iload_1
    //   10: ifgt +11 -> 21
    //   13: ldc -16
    //   15: invokestatic 117	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   18: aload 6
    //   20: areturn
    //   21: aload_0
    //   22: ldc -14
    //   24: invokespecial 134	com/google/android/gms/tagmanager/ca:S	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   27: astore_3
    //   28: aload_3
    //   29: ifnonnull +6 -> 35
    //   32: aload 6
    //   34: areturn
    //   35: ldc -12
    //   37: iconst_1
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: ldc 37
    //   45: aastore
    //   46: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   49: astore 4
    //   51: iload_1
    //   52: invokestatic 247	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   55: astore 5
    //   57: aload_3
    //   58: ldc 35
    //   60: iconst_1
    //   61: anewarray 45	java/lang/String
    //   64: dup
    //   65: iconst_0
    //   66: ldc 37
    //   68: aastore
    //   69: aconst_null
    //   70: aconst_null
    //   71: aconst_null
    //   72: aconst_null
    //   73: aload 4
    //   75: aload 5
    //   77: invokevirtual 251	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   80: astore 4
    //   82: aload 4
    //   84: astore_3
    //   85: aload 4
    //   87: invokeinterface 257 1 0
    //   92: ifeq +40 -> 132
    //   95: aload 4
    //   97: astore_3
    //   98: aload 6
    //   100: aload 4
    //   102: iconst_0
    //   103: invokeinterface 261 2 0
    //   108: invokestatic 152	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   111: invokeinterface 265 2 0
    //   116: pop
    //   117: aload 4
    //   119: astore_3
    //   120: aload 4
    //   122: invokeinterface 268 1 0
    //   127: istore_2
    //   128: iload_2
    //   129: ifne -34 -> 95
    //   132: aload 4
    //   134: ifnull +10 -> 144
    //   137: aload 4
    //   139: invokeinterface 271 1 0
    //   144: aload 6
    //   146: areturn
    //   147: astore 5
    //   149: aconst_null
    //   150: astore 4
    //   152: aload 4
    //   154: astore_3
    //   155: new 160	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   162: ldc_w 273
    //   165: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 5
    //   170: invokevirtual 276	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   173: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 117	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   182: aload 4
    //   184: ifnull -40 -> 144
    //   187: aload 4
    //   189: invokeinterface 271 1 0
    //   194: goto -50 -> 144
    //   197: astore 4
    //   199: aconst_null
    //   200: astore_3
    //   201: aload_3
    //   202: ifnull +9 -> 211
    //   205: aload_3
    //   206: invokeinterface 271 1 0
    //   211: aload 4
    //   213: athrow
    //   214: astore 4
    //   216: goto -15 -> 201
    //   219: astore 5
    //   221: goto -69 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	ca
    //   0	224	1	paramInt	int
    //   127	2	2	bool	boolean
    //   27	179	3	localObject1	Object
    //   49	139	4	localObject2	Object
    //   197	15	4	localObject3	Object
    //   214	1	4	localObject4	Object
    //   55	21	5	str	String
    //   147	22	5	localSQLiteException1	SQLiteException
    //   219	1	5	localSQLiteException2	SQLiteException
    //   7	138	6	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   35	82	147	android/database/sqlite/SQLiteException
    //   35	82	197	finally
    //   85	95	214	finally
    //   98	117	214	finally
    //   120	128	214	finally
    //   155	182	214	finally
    //   85	95	219	android/database/sqlite/SQLiteException
    //   98	117	219	android/database/sqlite/SQLiteException
    //   120	128	219	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public List<ap> B(int paramInt)
  {
    // Byte code:
    //   0: new 237	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 238	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: ldc_w 281
    //   13: invokespecial 134	com/google/android/gms/tagmanager/ca:S	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 8
    //   18: aload 8
    //   20: ifnonnull +10 -> 30
    //   23: aload 5
    //   25: astore 6
    //   27: aload 6
    //   29: areturn
    //   30: aconst_null
    //   31: astore 4
    //   33: ldc -12
    //   35: iconst_1
    //   36: anewarray 4	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: ldc 37
    //   43: aastore
    //   44: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   47: astore 6
    //   49: iload_1
    //   50: invokestatic 247	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   53: astore 7
    //   55: aload 8
    //   57: ldc 35
    //   59: iconst_3
    //   60: anewarray 45	java/lang/String
    //   63: dup
    //   64: iconst_0
    //   65: ldc 37
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: ldc 39
    //   72: aastore
    //   73: dup
    //   74: iconst_2
    //   75: ldc 43
    //   77: aastore
    //   78: aconst_null
    //   79: aconst_null
    //   80: aconst_null
    //   81: aconst_null
    //   82: aload 6
    //   84: aload 7
    //   86: invokevirtual 251	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   89: astore 6
    //   91: aload 6
    //   93: astore 4
    //   95: new 237	java/util/ArrayList
    //   98: dup
    //   99: invokespecial 238	java/util/ArrayList:<init>	()V
    //   102: astore 7
    //   104: aload 4
    //   106: invokeinterface 257 1 0
    //   111: ifeq +54 -> 165
    //   114: aload 7
    //   116: new 283	com/google/android/gms/tagmanager/ap
    //   119: dup
    //   120: aload 4
    //   122: iconst_0
    //   123: invokeinterface 261 2 0
    //   128: aload 4
    //   130: iconst_1
    //   131: invokeinterface 261 2 0
    //   136: aload 4
    //   138: iconst_2
    //   139: invokeinterface 261 2 0
    //   144: invokespecial 286	com/google/android/gms/tagmanager/ap:<init>	(JJJ)V
    //   147: invokeinterface 265 2 0
    //   152: pop
    //   153: aload 4
    //   155: invokeinterface 268 1 0
    //   160: istore_3
    //   161: iload_3
    //   162: ifne -48 -> 114
    //   165: aload 4
    //   167: ifnull +10 -> 177
    //   170: aload 4
    //   172: invokeinterface 271 1 0
    //   177: aload 4
    //   179: astore 5
    //   181: ldc -12
    //   183: iconst_1
    //   184: anewarray 4	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: ldc 37
    //   191: aastore
    //   192: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   195: astore 6
    //   197: aload 4
    //   199: astore 5
    //   201: iload_1
    //   202: invokestatic 247	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   205: astore 9
    //   207: aload 4
    //   209: astore 5
    //   211: aload 8
    //   213: ldc 35
    //   215: iconst_2
    //   216: anewarray 45	java/lang/String
    //   219: dup
    //   220: iconst_0
    //   221: ldc 37
    //   223: aastore
    //   224: dup
    //   225: iconst_1
    //   226: ldc 41
    //   228: aastore
    //   229: aconst_null
    //   230: aconst_null
    //   231: aconst_null
    //   232: aconst_null
    //   233: aload 6
    //   235: aload 9
    //   237: invokevirtual 251	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   240: astore 6
    //   242: aload 6
    //   244: invokeinterface 257 1 0
    //   249: ifeq +53 -> 302
    //   252: iconst_0
    //   253: istore_1
    //   254: aload 6
    //   256: checkcast 288	android/database/sqlite/SQLiteCursor
    //   259: invokevirtual 292	android/database/sqlite/SQLiteCursor:getWindow	()Landroid/database/CursorWindow;
    //   262: invokevirtual 297	android/database/CursorWindow:getNumRows	()I
    //   265: ifle +136 -> 401
    //   268: aload 7
    //   270: iload_1
    //   271: invokeinterface 301 2 0
    //   276: checkcast 283	com/google/android/gms/tagmanager/ap
    //   279: aload 6
    //   281: iconst_1
    //   282: invokeinterface 304 2 0
    //   287: invokevirtual 307	com/google/android/gms/tagmanager/ap:R	(Ljava/lang/String;)V
    //   290: aload 6
    //   292: invokeinterface 268 1 0
    //   297: istore_3
    //   298: iload_3
    //   299: ifne +375 -> 674
    //   302: aload 6
    //   304: ifnull +10 -> 314
    //   307: aload 6
    //   309: invokeinterface 271 1 0
    //   314: aload 7
    //   316: areturn
    //   317: astore 6
    //   319: aconst_null
    //   320: astore 7
    //   322: aload 5
    //   324: astore 4
    //   326: aload 7
    //   328: astore 5
    //   330: new 160	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   337: ldc_w 273
    //   340: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload 6
    //   345: invokevirtual 276	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   348: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 117	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   357: aload 4
    //   359: astore 6
    //   361: aload 5
    //   363: ifnull -336 -> 27
    //   366: aload 5
    //   368: invokeinterface 271 1 0
    //   373: aload 4
    //   375: areturn
    //   376: astore 6
    //   378: aload 4
    //   380: astore 5
    //   382: aload 6
    //   384: astore 4
    //   386: aload 5
    //   388: ifnull +10 -> 398
    //   391: aload 5
    //   393: invokeinterface 271 1 0
    //   398: aload 4
    //   400: athrow
    //   401: ldc_w 309
    //   404: iconst_1
    //   405: anewarray 4	java/lang/Object
    //   408: dup
    //   409: iconst_0
    //   410: aload 7
    //   412: iload_1
    //   413: invokeinterface 301 2 0
    //   418: checkcast 283	com/google/android/gms/tagmanager/ap
    //   421: invokevirtual 313	com/google/android/gms/tagmanager/ap:dg	()J
    //   424: invokestatic 143	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   427: aastore
    //   428: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   431: invokestatic 117	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   434: goto -144 -> 290
    //   437: astore 5
    //   439: aload 6
    //   441: astore 4
    //   443: aload 5
    //   445: astore 6
    //   447: aload 4
    //   449: astore 5
    //   451: new 160	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   458: ldc_w 315
    //   461: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload 6
    //   466: invokevirtual 276	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   469: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 117	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   478: aload 4
    //   480: astore 5
    //   482: new 237	java/util/ArrayList
    //   485: dup
    //   486: invokespecial 238	java/util/ArrayList:<init>	()V
    //   489: astore 6
    //   491: iconst_0
    //   492: istore_1
    //   493: aload 4
    //   495: astore 5
    //   497: aload 7
    //   499: invokeinterface 319 1 0
    //   504: astore 7
    //   506: aload 4
    //   508: astore 5
    //   510: aload 7
    //   512: invokeinterface 324 1 0
    //   517: ifeq +42 -> 559
    //   520: aload 4
    //   522: astore 5
    //   524: aload 7
    //   526: invokeinterface 328 1 0
    //   531: checkcast 283	com/google/android/gms/tagmanager/ap
    //   534: astore 8
    //   536: aload 4
    //   538: astore 5
    //   540: aload 8
    //   542: invokevirtual 331	com/google/android/gms/tagmanager/ap:lJ	()Ljava/lang/String;
    //   545: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   548: istore_3
    //   549: iload_1
    //   550: istore_2
    //   551: iload_3
    //   552: ifeq +24 -> 576
    //   555: iload_1
    //   556: ifeq +18 -> 574
    //   559: aload 4
    //   561: ifnull +10 -> 571
    //   564: aload 4
    //   566: invokeinterface 271 1 0
    //   571: aload 6
    //   573: areturn
    //   574: iconst_1
    //   575: istore_2
    //   576: aload 4
    //   578: astore 5
    //   580: aload 6
    //   582: aload 8
    //   584: invokeinterface 265 2 0
    //   589: pop
    //   590: iload_2
    //   591: istore_1
    //   592: goto -86 -> 506
    //   595: astore 4
    //   597: aload 5
    //   599: ifnull +10 -> 609
    //   602: aload 5
    //   604: invokeinterface 271 1 0
    //   609: aload 4
    //   611: athrow
    //   612: astore 4
    //   614: aload 6
    //   616: astore 5
    //   618: goto -21 -> 597
    //   621: astore 6
    //   623: goto -176 -> 447
    //   626: astore 6
    //   628: aload 4
    //   630: astore 5
    //   632: aload 6
    //   634: astore 4
    //   636: goto -250 -> 386
    //   639: astore 4
    //   641: goto -255 -> 386
    //   644: astore 6
    //   646: aload 4
    //   648: astore 7
    //   650: aload 5
    //   652: astore 4
    //   654: aload 7
    //   656: astore 5
    //   658: goto -328 -> 330
    //   661: astore 6
    //   663: aload 4
    //   665: astore 5
    //   667: aload 7
    //   669: astore 4
    //   671: goto -341 -> 330
    //   674: iload_1
    //   675: iconst_1
    //   676: iadd
    //   677: istore_1
    //   678: goto -424 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	681	0	this	ca
    //   0	681	1	paramInt	int
    //   550	41	2	i	int
    //   160	392	3	bool	boolean
    //   31	546	4	localObject1	Object
    //   595	15	4	localObject2	Object
    //   612	17	4	localObject3	Object
    //   634	1	4	localObject4	Object
    //   639	8	4	localObject5	Object
    //   652	18	4	localObject6	Object
    //   7	385	5	localObject7	Object
    //   437	7	5	localSQLiteException1	SQLiteException
    //   449	217	5	localObject8	Object
    //   25	283	6	localObject9	Object
    //   317	27	6	localSQLiteException2	SQLiteException
    //   359	1	6	localObject10	Object
    //   376	64	6	localObject11	Object
    //   445	170	6	localObject12	Object
    //   621	1	6	localSQLiteException3	SQLiteException
    //   626	7	6	localObject13	Object
    //   644	1	6	localSQLiteException4	SQLiteException
    //   661	1	6	localSQLiteException5	SQLiteException
    //   53	615	7	localObject14	Object
    //   16	567	8	localObject15	Object
    //   205	31	9	str	String
    // Exception table:
    //   from	to	target	type
    //   33	91	317	android/database/sqlite/SQLiteException
    //   33	91	376	finally
    //   242	252	437	android/database/sqlite/SQLiteException
    //   254	290	437	android/database/sqlite/SQLiteException
    //   290	298	437	android/database/sqlite/SQLiteException
    //   401	434	437	android/database/sqlite/SQLiteException
    //   181	197	595	finally
    //   201	207	595	finally
    //   211	242	595	finally
    //   451	478	595	finally
    //   482	491	595	finally
    //   497	506	595	finally
    //   510	520	595	finally
    //   524	536	595	finally
    //   540	549	595	finally
    //   580	590	595	finally
    //   242	252	612	finally
    //   254	290	612	finally
    //   290	298	612	finally
    //   401	434	612	finally
    //   181	197	621	android/database/sqlite/SQLiteException
    //   201	207	621	android/database/sqlite/SQLiteException
    //   211	242	621	android/database/sqlite/SQLiteException
    //   95	104	626	finally
    //   104	114	626	finally
    //   114	161	626	finally
    //   330	357	639	finally
    //   95	104	644	android/database/sqlite/SQLiteException
    //   104	114	661	android/database/sqlite/SQLiteException
    //   114	161	661	android/database/sqlite/SQLiteException
  }
  
  void a(String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      localSQLiteDatabase = S("Error opening database for deleteHits.");
    } while (localSQLiteDatabase == null);
    String str = String.format("HIT_ID in (%s)", new Object[] { TextUtils.join(",", Collections.nCopies(paramArrayOfString.length, "?")) });
    for (;;)
    {
      try
      {
        localSQLiteDatabase.delete("gtm_hits", str, paramArrayOfString);
        paramArrayOfString = this.agp;
        if (jdMethod_do() == 0)
        {
          paramArrayOfString.s(bool);
          return;
        }
      }
      catch (SQLiteException paramArrayOfString)
      {
        bh.D("Error deleting hits");
        return;
      }
      bool = false;
    }
  }
  
  public void cl()
  {
    bh.C("GTM Dispatch running...");
    if (!this.ago.cx()) {}
    do
    {
      return;
      List localList = B(40);
      if (localList.isEmpty())
      {
        bh.C("...nothing to dispatch");
        this.agp.s(true);
        return;
      }
      this.ago.g(localList);
    } while (lW() <= 0);
    cx.mL().cl();
  }
  
  int dn()
  {
    boolean bool = true;
    long l = this.aec.currentTimeMillis();
    if (l <= this.wR + 86400000L) {}
    do
    {
      return 0;
      this.wR = l;
      localObject = S("Error opening database for deleteStaleHits.");
    } while (localObject == null);
    int i = ((SQLiteDatabase)localObject).delete("gtm_hits", "HIT_TIME < ?", new String[] { Long.toString(this.aec.currentTimeMillis() - 2592000000L) });
    Object localObject = this.agp;
    if (jdMethod_do() == 0) {}
    for (;;)
    {
      ((au)localObject).s(bool);
      return i;
      bool = false;
    }
  }
  
  int jdMethod_do()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    Object localObject5 = S("Error opening database for getNumStoredHits.");
    if (localObject5 == null) {}
    for (;;)
    {
      return j;
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
        return i;
      }
      catch (SQLiteException localSQLiteException)
      {
        localObject4 = localObject1;
        bh.D("Error getting numStoredHits");
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
  
  public void f(long paramLong, String paramString)
  {
    dn();
    dm();
    g(paramLong, paramString);
  }
  
  /* Error */
  int lW()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ldc -124
    //   6: invokespecial 134	com/google/android/gms/tagmanager/ca:S	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_3
    //   10: aload_3
    //   11: ifnonnull +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_3
    //   17: ldc 35
    //   19: iconst_2
    //   20: anewarray 45	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: ldc 37
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: ldc 43
    //   32: aastore
    //   33: ldc_w 423
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 426	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore_3
    //   44: aload_3
    //   45: invokeinterface 429 1 0
    //   50: istore_2
    //   51: iload_2
    //   52: istore_1
    //   53: aload_3
    //   54: ifnull +11 -> 65
    //   57: aload_3
    //   58: invokeinterface 271 1 0
    //   63: iload_2
    //   64: istore_1
    //   65: iload_1
    //   66: ireturn
    //   67: astore_3
    //   68: aconst_null
    //   69: astore_3
    //   70: ldc_w 431
    //   73: invokestatic 117	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   76: aload_3
    //   77: ifnull +56 -> 133
    //   80: aload_3
    //   81: invokeinterface 271 1 0
    //   86: iconst_0
    //   87: istore_1
    //   88: goto -23 -> 65
    //   91: astore_3
    //   92: aload 4
    //   94: ifnull +10 -> 104
    //   97: aload 4
    //   99: invokeinterface 271 1 0
    //   104: aload_3
    //   105: athrow
    //   106: astore 5
    //   108: aload_3
    //   109: astore 4
    //   111: aload 5
    //   113: astore_3
    //   114: goto -22 -> 92
    //   117: astore 5
    //   119: aload_3
    //   120: astore 4
    //   122: aload 5
    //   124: astore_3
    //   125: goto -33 -> 92
    //   128: astore 4
    //   130: goto -60 -> 70
    //   133: iconst_0
    //   134: istore_1
    //   135: goto -70 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	ca
    //   52	83	1	i	int
    //   50	14	2	j	int
    //   9	49	3	localObject1	Object
    //   67	1	3	localSQLiteException1	SQLiteException
    //   69	12	3	localObject2	Object
    //   91	18	3	localObject3	Object
    //   113	12	3	localObject4	Object
    //   1	120	4	localObject5	Object
    //   128	1	4	localSQLiteException2	SQLiteException
    //   106	6	5	localObject6	Object
    //   117	6	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   16	44	67	android/database/sqlite/SQLiteException
    //   16	44	91	finally
    //   44	51	106	finally
    //   70	76	117	finally
    //   44	51	128	android/database/sqlite/SQLiteException
  }
  
  class a
    implements da.a
  {
    a() {}
    
    public void a(ap paramap)
    {
      ca.a(ca.this, paramap.dg());
    }
    
    public void b(ap paramap)
    {
      ca.a(ca.this, paramap.dg());
      bh.C("Permanent failure dispatching hitId: " + paramap.dg());
    }
    
    public void c(ap paramap)
    {
      long l = paramap.lI();
      if (l == 0L) {
        ca.a(ca.this, paramap.dg(), ca.a(ca.this).currentTimeMillis());
      }
      while (l + 14400000L >= ca.a(ca.this).currentTimeMillis()) {
        return;
      }
      ca.a(ca.this, paramap.dg());
      bh.C("Giving up on failed hitId: " + paramap.dg());
    }
  }
  
  class b
    extends SQLiteOpenHelper
  {
    private boolean wU;
    private long wV = 0L;
    
    b(Context paramContext, String paramString)
    {
      super(paramString, null, 1);
    }
    
    private void a(SQLiteDatabase paramSQLiteDatabase)
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
    
    /* Error */
    private boolean a(String paramString, SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: aload_2
      //   4: ldc 80
      //   6: iconst_1
      //   7: anewarray 82	java/lang/String
      //   10: dup
      //   11: iconst_0
      //   12: ldc 84
      //   14: aastore
      //   15: ldc 86
      //   17: iconst_1
      //   18: anewarray 82	java/lang/String
      //   21: dup
      //   22: iconst_0
      //   23: aload_1
      //   24: aastore
      //   25: aconst_null
      //   26: aconst_null
      //   27: aconst_null
      //   28: invokevirtual 90	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   31: astore_2
      //   32: aload_2
      //   33: invokeinterface 93 1 0
      //   38: istore_3
      //   39: aload_2
      //   40: ifnull +9 -> 49
      //   43: aload_2
      //   44: invokeinterface 53 1 0
      //   49: iload_3
      //   50: ireturn
      //   51: astore_2
      //   52: aconst_null
      //   53: astore_2
      //   54: new 95	java/lang/StringBuilder
      //   57: dup
      //   58: invokespecial 96	java/lang/StringBuilder:<init>	()V
      //   61: ldc 98
      //   63: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   66: aload_1
      //   67: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   70: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   73: invokestatic 111	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
      //   76: aload_2
      //   77: ifnull +9 -> 86
      //   80: aload_2
      //   81: invokeinterface 53 1 0
      //   86: iconst_0
      //   87: ireturn
      //   88: astore_1
      //   89: aload 4
      //   91: astore_2
      //   92: aload_2
      //   93: ifnull +9 -> 102
      //   96: aload_2
      //   97: invokeinterface 53 1 0
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
      //   0	117	0	this	b
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
      if ((this.wU) && (this.wV + 3600000L > ca.a(ca.this).currentTimeMillis())) {
        throw new SQLiteException("Database creation failed");
      }
      Object localObject1 = null;
      this.wU = true;
      this.wV = ca.a(ca.this).currentTimeMillis();
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
          ca.c(ca.this).getDatabasePath(ca.b(ca.this)).delete();
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = super.getWritableDatabase();
      }
      this.wU = false;
      return (SQLiteDatabase)localObject2;
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      ak.N(paramSQLiteDatabase.getPath());
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
        if (!a("gtm_hits", paramSQLiteDatabase))
        {
          paramSQLiteDatabase.execSQL(ca.lX());
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */