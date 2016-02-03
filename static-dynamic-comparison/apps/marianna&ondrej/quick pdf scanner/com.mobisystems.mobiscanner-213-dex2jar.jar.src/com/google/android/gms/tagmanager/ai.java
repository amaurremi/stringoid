package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.du;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class ai
  implements c.c
{
  private static final String Ye = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[] { "datalayer", "ID", "key", "value", "expires" });
  private final Executor Yf;
  private a Yg;
  private dt Yh;
  private int Yi;
  private final Context mContext;
  
  public ai(Context paramContext)
  {
    this(paramContext, du.qX(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
  }
  
  ai(Context paramContext, dt paramdt, String paramString, int paramInt, Executor paramExecutor)
  {
    this.mContext = paramContext;
    this.Yh = paramdt;
    this.Yi = paramInt;
    this.Yf = paramExecutor;
    this.Yg = new a(this.mContext, paramString);
  }
  
  /* Error */
  private byte[] V(Object paramObject)
  {
    // Byte code:
    //   0: new 91	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 92	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: new 94	java/io/ObjectOutputStream
    //   11: dup
    //   12: aload_3
    //   13: invokespecial 97	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_1
    //   19: invokevirtual 101	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   22: aload_3
    //   23: invokevirtual 105	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   26: astore_1
    //   27: aload_2
    //   28: ifnull +7 -> 35
    //   31: aload_2
    //   32: invokevirtual 108	java/io/ObjectOutputStream:close	()V
    //   35: aload_3
    //   36: invokevirtual 109	java/io/ByteArrayOutputStream:close	()V
    //   39: aload_1
    //   40: areturn
    //   41: astore_1
    //   42: aconst_null
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull +7 -> 52
    //   48: aload_2
    //   49: invokevirtual 108	java/io/ObjectOutputStream:close	()V
    //   52: aload_3
    //   53: invokevirtual 109	java/io/ByteArrayOutputStream:close	()V
    //   56: aconst_null
    //   57: areturn
    //   58: astore_1
    //   59: aconst_null
    //   60: areturn
    //   61: astore_1
    //   62: aconst_null
    //   63: astore_2
    //   64: aload_2
    //   65: ifnull +7 -> 72
    //   68: aload_2
    //   69: invokevirtual 108	java/io/ObjectOutputStream:close	()V
    //   72: aload_3
    //   73: invokevirtual 109	java/io/ByteArrayOutputStream:close	()V
    //   76: aload_1
    //   77: athrow
    //   78: astore_2
    //   79: goto -3 -> 76
    //   82: astore_1
    //   83: goto -19 -> 64
    //   86: astore_1
    //   87: goto -43 -> 44
    //   90: astore_2
    //   91: aload_1
    //   92: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	ai
    //   0	93	1	paramObject	Object
    //   16	53	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   78	1	2	localIOException1	java.io.IOException
    //   90	1	2	localIOException2	java.io.IOException
    //   7	66	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   8	17	41	java/io/IOException
    //   48	52	58	java/io/IOException
    //   52	56	58	java/io/IOException
    //   8	17	61	finally
    //   68	72	78	java/io/IOException
    //   72	76	78	java/io/IOException
    //   17	27	82	finally
    //   17	27	86	java/io/IOException
    //   31	35	90	java/io/IOException
    //   35	39	90	java/io/IOException
  }
  
  private SQLiteDatabase ab(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.Yg.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      j.D(paramString);
    }
    return null;
  }
  
  /* Error */
  private void b(List<b> paramList, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 76	com/google/android/gms/tagmanager/ai:Yh	Lcom/google/android/gms/internal/dt;
    //   6: invokeinterface 139 1 0
    //   11: lstore 4
    //   13: aload_0
    //   14: lload 4
    //   16: invokespecial 143	com/google/android/gms/tagmanager/ai:x	(J)V
    //   19: aload_0
    //   20: aload_1
    //   21: invokeinterface 149 1 0
    //   26: invokespecial 153	com/google/android/gms/tagmanager/ai:en	(I)V
    //   29: aload_0
    //   30: aload_1
    //   31: lload 4
    //   33: lload_2
    //   34: ladd
    //   35: invokespecial 156	com/google/android/gms/tagmanager/ai:c	(Ljava/util/List;J)V
    //   38: aload_0
    //   39: invokespecial 159	com/google/android/gms/tagmanager/ai:wE	()V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: invokespecial 159	com/google/android/gms/tagmanager/ai:wE	()V
    //   50: aload_1
    //   51: athrow
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	ai
    //   0	57	1	paramList	List<b>
    //   0	57	2	paramLong	long
    //   11	21	4	l	long
    // Exception table:
    //   from	to	target	type
    //   2	38	45	finally
    //   38	42	52	finally
    //   46	52	52	finally
  }
  
  private void c(List<b> paramList, long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = ab("Error opening database for writeEntryToDatabase.");
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        b localb = (b)paramList.next();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("expires", Long.valueOf(paramLong));
        localContentValues.put("key", localb.WC);
        localContentValues.put("value", localb.Yn);
        localSQLiteDatabase.insert("datalayer", null, localContentValues);
      }
    }
  }
  
  private void en(int paramInt)
  {
    paramInt = wD() - this.Yi + paramInt;
    if (paramInt > 0)
    {
      List localList = eo(paramInt);
      j.aa("DataLayer store full, deleting " + localList.size() + " entries to make room.");
      g((String[])localList.toArray(new String[0]));
    }
  }
  
  /* Error */
  private List<String> eo(int paramInt)
  {
    // Byte code:
    //   0: new 251	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 252	java/util/ArrayList:<init>	()V
    //   7: astore 6
    //   9: iload_1
    //   10: ifgt +11 -> 21
    //   13: ldc -2
    //   15: invokestatic 132	com/google/android/gms/tagmanager/j:D	(Ljava/lang/String;)V
    //   18: aload 6
    //   20: areturn
    //   21: aload_0
    //   22: ldc_w 256
    //   25: invokespecial 165	com/google/android/gms/tagmanager/ai:ab	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnonnull +6 -> 36
    //   33: aload 6
    //   35: areturn
    //   36: ldc_w 258
    //   39: iconst_1
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: ldc 36
    //   47: aastore
    //   48: invokestatic 48	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   51: astore 4
    //   53: iload_1
    //   54: invokestatic 263	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   57: astore 5
    //   59: aload_3
    //   60: ldc 34
    //   62: iconst_1
    //   63: anewarray 44	java/lang/String
    //   66: dup
    //   67: iconst_0
    //   68: ldc 36
    //   70: aastore
    //   71: aconst_null
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: aload 4
    //   77: aload 5
    //   79: invokevirtual 267	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   82: astore 4
    //   84: aload 4
    //   86: astore_3
    //   87: aload 4
    //   89: invokeinterface 272 1 0
    //   94: ifeq +40 -> 134
    //   97: aload 4
    //   99: astore_3
    //   100: aload 6
    //   102: aload 4
    //   104: iconst_0
    //   105: invokeinterface 276 2 0
    //   110: invokestatic 279	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   113: invokeinterface 283 2 0
    //   118: pop
    //   119: aload 4
    //   121: astore_3
    //   122: aload 4
    //   124: invokeinterface 286 1 0
    //   129: istore_2
    //   130: iload_2
    //   131: ifne -34 -> 97
    //   134: aload 4
    //   136: ifnull +10 -> 146
    //   139: aload 4
    //   141: invokeinterface 287 1 0
    //   146: aload 6
    //   148: areturn
    //   149: astore 5
    //   151: aconst_null
    //   152: astore 4
    //   154: aload 4
    //   156: astore_3
    //   157: new 220	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   164: ldc_w 289
    //   167: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 5
    //   172: invokevirtual 292	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   175: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 132	com/google/android/gms/tagmanager/j:D	(Ljava/lang/String;)V
    //   184: aload 4
    //   186: ifnull -40 -> 146
    //   189: aload 4
    //   191: invokeinterface 287 1 0
    //   196: goto -50 -> 146
    //   199: astore 4
    //   201: aconst_null
    //   202: astore_3
    //   203: aload_3
    //   204: ifnull +9 -> 213
    //   207: aload_3
    //   208: invokeinterface 287 1 0
    //   213: aload 4
    //   215: athrow
    //   216: astore 4
    //   218: goto -15 -> 203
    //   221: astore 5
    //   223: goto -69 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	ai
    //   0	226	1	paramInt	int
    //   129	2	2	bool	boolean
    //   28	180	3	localObject1	Object
    //   51	139	4	localObject2	Object
    //   199	15	4	localObject3	Object
    //   216	1	4	localObject4	Object
    //   57	21	5	str	String
    //   149	22	5	localSQLiteException1	SQLiteException
    //   221	1	5	localSQLiteException2	SQLiteException
    //   7	140	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   36	84	149	android/database/sqlite/SQLiteException
    //   36	84	199	finally
    //   87	97	216	finally
    //   100	119	216	finally
    //   122	130	216	finally
    //   157	184	216	finally
    //   87	97	221	android/database/sqlite/SQLiteException
    //   100	119	221	android/database/sqlite/SQLiteException
    //   122	130	221	android/database/sqlite/SQLiteException
  }
  
  private List<c.a> f(List<b> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      localArrayList.add(new c.a(localb.WC, h(localb.Yn)));
    }
    return localArrayList;
  }
  
  private List<b> g(List<c.a> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      c.a locala = (c.a)paramList.next();
      localArrayList.add(new b(locala.WC, V(locala.WD)));
    }
    return localArrayList;
  }
  
  private void g(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      localSQLiteDatabase = ab("Error opening database for deleteEntries.");
    } while (localSQLiteDatabase == null);
    String str = String.format("%s in (%s)", new Object[] { "ID", TextUtils.join(",", Collections.nCopies(paramArrayOfString.length, "?")) });
    try
    {
      localSQLiteDatabase.delete("datalayer", str, paramArrayOfString);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      j.D("Error deleting entries " + Arrays.toString(paramArrayOfString));
    }
  }
  
  /* Error */
  private Object h(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 350	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 353	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_3
    //   9: new 355	java/io/ObjectInputStream
    //   12: dup
    //   13: aload_3
    //   14: invokespecial 358	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_1
    //   18: aload_1
    //   19: invokevirtual 361	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   22: astore_2
    //   23: aload_1
    //   24: ifnull +7 -> 31
    //   27: aload_1
    //   28: invokevirtual 362	java/io/ObjectInputStream:close	()V
    //   31: aload_3
    //   32: invokevirtual 363	java/io/ByteArrayInputStream:close	()V
    //   35: aload_2
    //   36: areturn
    //   37: astore_1
    //   38: aconst_null
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +7 -> 48
    //   44: aload_1
    //   45: invokevirtual 362	java/io/ObjectInputStream:close	()V
    //   48: aload_3
    //   49: invokevirtual 363	java/io/ByteArrayInputStream:close	()V
    //   52: aconst_null
    //   53: areturn
    //   54: astore_1
    //   55: aconst_null
    //   56: areturn
    //   57: astore_1
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +7 -> 68
    //   64: aload_1
    //   65: invokevirtual 362	java/io/ObjectInputStream:close	()V
    //   68: aload_3
    //   69: invokevirtual 363	java/io/ByteArrayInputStream:close	()V
    //   72: aconst_null
    //   73: areturn
    //   74: astore_1
    //   75: aconst_null
    //   76: areturn
    //   77: astore_2
    //   78: aconst_null
    //   79: astore_1
    //   80: aload_1
    //   81: ifnull +7 -> 88
    //   84: aload_1
    //   85: invokevirtual 362	java/io/ObjectInputStream:close	()V
    //   88: aload_3
    //   89: invokevirtual 363	java/io/ByteArrayInputStream:close	()V
    //   92: aload_2
    //   93: athrow
    //   94: astore_1
    //   95: goto -3 -> 92
    //   98: astore_2
    //   99: goto -19 -> 80
    //   102: astore_2
    //   103: goto -43 -> 60
    //   106: astore_2
    //   107: goto -67 -> 40
    //   110: astore_1
    //   111: aload_2
    //   112: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	ai
    //   0	113	1	paramArrayOfByte	byte[]
    //   22	14	2	localObject1	Object
    //   77	16	2	localObject2	Object
    //   98	1	2	localObject3	Object
    //   102	1	2	localClassNotFoundException	ClassNotFoundException
    //   106	6	2	localIOException	java.io.IOException
    //   8	81	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   9	18	37	java/io/IOException
    //   44	48	54	java/io/IOException
    //   48	52	54	java/io/IOException
    //   9	18	57	java/lang/ClassNotFoundException
    //   64	68	74	java/io/IOException
    //   68	72	74	java/io/IOException
    //   9	18	77	finally
    //   84	88	94	java/io/IOException
    //   88	92	94	java/io/IOException
    //   18	23	98	finally
    //   18	23	102	java/lang/ClassNotFoundException
    //   18	23	106	java/io/IOException
    //   27	31	110	java/io/IOException
    //   31	35	110	java/io/IOException
  }
  
  private List<c.a> wB()
  {
    try
    {
      x(this.Yh.currentTimeMillis());
      List localList = f(wC());
      return localList;
    }
    finally
    {
      wE();
    }
  }
  
  private List<b> wC()
  {
    Object localObject = ab("Error opening database for loadSerialized.");
    ArrayList localArrayList = new ArrayList();
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((SQLiteDatabase)localObject).query("datalayer", new String[] { "key", "value" }, null, null, null, null, "ID", null);
    try
    {
      if (((Cursor)localObject).moveToNext()) {
        localArrayList.add(new b(((Cursor)localObject).getString(0), ((Cursor)localObject).getBlob(1)));
      }
      return localList;
    }
    finally
    {
      ((Cursor)localObject).close();
    }
  }
  
  private int wD()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    Object localObject5 = ab("Error opening database for getNumStoredEntries.");
    if (localObject5 == null) {}
    for (;;)
    {
      return j;
      try
      {
        localObject5 = ((SQLiteDatabase)localObject5).rawQuery("SELECT COUNT(*) from datalayer", null);
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
        j.D("Error getting numStoredEntries");
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
  
  private void wE()
  {
    try
    {
      this.Yg.close();
      return;
    }
    catch (SQLiteException localSQLiteException) {}
  }
  
  private void x(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = ab("Error opening database for deleteOlderThan.");
    if (localSQLiteDatabase == null) {
      return;
    }
    try
    {
      int i = localSQLiteDatabase.delete("datalayer", "expires <= ?", new String[] { Long.toString(paramLong) });
      j.C("Deleted " + i + " expired items");
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      j.D("Error deleting old entries.");
    }
  }
  
  public void a(final c.c.a parama)
  {
    this.Yf.execute(new Runnable()
    {
      public void run()
      {
        parama.e(ai.a(ai.this));
      }
    });
  }
  
  public void a(final List<c.a> paramList, final long paramLong)
  {
    paramList = g(paramList);
    this.Yf.execute(new Runnable()
    {
      public void run()
      {
        ai.a(ai.this, paramList, paramLong);
      }
    });
  }
  
  class a
    extends SQLiteOpenHelper
  {
    a(Context paramContext, String paramString)
    {
      super(paramString, null, 1);
    }
    
    private void b(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
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
        if ((!localHashSet.remove("key")) || (!localHashSet.remove("value")) || (!localHashSet.remove("ID")) || (!localHashSet.remove("expires"))) {
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
    private boolean b(String paramString, SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: aload_2
      //   4: ldc 74
      //   6: iconst_1
      //   7: anewarray 76	java/lang/String
      //   10: dup
      //   11: iconst_0
      //   12: ldc 78
      //   14: aastore
      //   15: ldc 80
      //   17: iconst_1
      //   18: anewarray 76	java/lang/String
      //   21: dup
      //   22: iconst_0
      //   23: aload_1
      //   24: aastore
      //   25: aconst_null
      //   26: aconst_null
      //   27: aconst_null
      //   28: invokevirtual 84	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   31: astore_2
      //   32: aload_2
      //   33: invokeinterface 87 1 0
      //   38: istore_3
      //   39: aload_2
      //   40: ifnull +9 -> 49
      //   43: aload_2
      //   44: invokeinterface 47 1 0
      //   49: iload_3
      //   50: ireturn
      //   51: astore_2
      //   52: aconst_null
      //   53: astore_2
      //   54: new 89	java/lang/StringBuilder
      //   57: dup
      //   58: invokespecial 90	java/lang/StringBuilder:<init>	()V
      //   61: ldc 92
      //   63: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   66: aload_1
      //   67: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   70: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   73: invokestatic 105	com/google/android/gms/tagmanager/j:D	(Ljava/lang/String;)V
      //   76: aload_2
      //   77: ifnull +9 -> 86
      //   80: aload_2
      //   81: invokeinterface 47 1 0
      //   86: iconst_0
      //   87: ireturn
      //   88: astore_1
      //   89: aload 4
      //   91: astore_2
      //   92: aload_2
      //   93: ifnull +9 -> 102
      //   96: aload_2
      //   97: invokeinterface 47 1 0
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
      Object localObject1 = null;
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
          ai.b(ai.this).getDatabasePath("google_tagmanager.db").delete();
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = super.getWritableDatabase();
      }
      return (SQLiteDatabase)localObject2;
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      h.ah(paramSQLiteDatabase.getPath());
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
        if (!b("datalayer", paramSQLiteDatabase))
        {
          paramSQLiteDatabase.execSQL(ai.wF());
          return;
        }
      }
      finally
      {
        localCursor.close();
      }
      b(paramSQLiteDatabase);
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  }
  
  private static class b
  {
    final String WC;
    final byte[] Yn;
    
    b(String paramString, byte[] paramArrayOfByte)
    {
      this.WC = paramString;
      this.Yn = paramArrayOfByte;
    }
    
    public String toString()
    {
      return "KeyAndSerialized: key = " + this.WC + " serialized hash = " + Arrays.hashCode(this.Yn);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/tagmanager/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */