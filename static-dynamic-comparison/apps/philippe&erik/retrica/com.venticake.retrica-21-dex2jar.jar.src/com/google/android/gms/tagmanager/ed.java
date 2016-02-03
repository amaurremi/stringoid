package com.google.android.gms.tagmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

class ed
  extends SQLiteOpenHelper
{
  ed(ec paramec, Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 1);
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
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
  private boolean a(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_2
    //   4: ldc 70
    //   6: iconst_1
    //   7: anewarray 72	java/lang/String
    //   10: dup
    //   11: iconst_0
    //   12: ldc 74
    //   14: aastore
    //   15: ldc 76
    //   17: iconst_1
    //   18: anewarray 72	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: aload_1
    //   24: aastore
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokevirtual 80	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore_2
    //   32: aload_2
    //   33: invokeinterface 83 1 0
    //   38: istore_3
    //   39: aload_2
    //   40: ifnull +9 -> 49
    //   43: aload_2
    //   44: invokeinterface 43 1 0
    //   49: iload_3
    //   50: ireturn
    //   51: astore_2
    //   52: aconst_null
    //   53: astore_2
    //   54: new 85	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   61: ldc 88
    //   63: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 101	com/google/android/gms/tagmanager/as:b	(Ljava/lang/String;)V
    //   76: aload_2
    //   77: ifnull +9 -> 86
    //   80: aload_2
    //   81: invokeinterface 43 1 0
    //   86: iconst_0
    //   87: ireturn
    //   88: astore_1
    //   89: aload 4
    //   91: astore_2
    //   92: aload_2
    //   93: ifnull +9 -> 102
    //   96: aload_2
    //   97: invokeinterface 43 1 0
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
    //   0	117	0	this	ed
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
        ec.b(this.a).getDatabasePath("google_tagmanager.db").delete();
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
      if (!a("datalayer", paramSQLiteDatabase))
      {
        paramSQLiteDatabase.execSQL(ec.a());
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/ed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */