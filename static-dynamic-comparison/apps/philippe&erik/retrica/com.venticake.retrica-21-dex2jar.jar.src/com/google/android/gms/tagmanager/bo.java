package com.google.android.gms.tagmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.google.android.gms.internal.ij;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

class bo
  extends SQLiteOpenHelper
{
  private boolean b;
  private long c = 0L;
  
  bo(bm parambm, Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 1);
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
    //   4: ldc 76
    //   6: iconst_1
    //   7: anewarray 78	java/lang/String
    //   10: dup
    //   11: iconst_0
    //   12: ldc 80
    //   14: aastore
    //   15: ldc 82
    //   17: iconst_1
    //   18: anewarray 78	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: aload_1
    //   24: aastore
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokevirtual 86	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore_2
    //   32: aload_2
    //   33: invokeinterface 89 1 0
    //   38: istore_3
    //   39: aload_2
    //   40: ifnull +9 -> 49
    //   43: aload_2
    //   44: invokeinterface 49 1 0
    //   49: iload_3
    //   50: ireturn
    //   51: astore_2
    //   52: aconst_null
    //   53: astore_2
    //   54: new 91	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   61: ldc 94
    //   63: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 106	com/google/android/gms/tagmanager/as:b	(Ljava/lang/String;)V
    //   76: aload_2
    //   77: ifnull +9 -> 86
    //   80: aload_2
    //   81: invokeinterface 49 1 0
    //   86: iconst_0
    //   87: ireturn
    //   88: astore_1
    //   89: aload 4
    //   91: astore_2
    //   92: aload_2
    //   93: ifnull +9 -> 102
    //   96: aload_2
    //   97: invokeinterface 49 1 0
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
    //   0	117	0	this	bo
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
    if ((this.b) && (this.c + 3600000L > bm.a(this.a).currentTimeMillis())) {
      throw new SQLiteException("Database creation failed");
    }
    Object localObject1 = null;
    this.b = true;
    this.c = bm.a(this.a).currentTimeMillis();
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
        bm.c(this.a).getDatabasePath(bm.b(this.a)).delete();
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = super.getWritableDatabase();
    }
    this.b = false;
    return (SQLiteDatabase)localObject2;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    u.a(paramSQLiteDatabase.getPath());
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
        paramSQLiteDatabase.execSQL(bm.e());
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */