package com.skplanet.tad.common;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

public class e
{
  private static final e a = new e();
  
  public static final e a()
  {
    return a;
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase != null) {
      paramSQLiteDatabase.close();
    }
  }
  
  private boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    if (!b(paramSQLiteDatabase)) {
      return false;
    }
    try
    {
      paramSQLiteDatabase.beginTransaction();
      paramSQLiteDatabase.execSQL(paramString);
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
      return true;
    }
    catch (Throwable paramSQLiteDatabase) {}
    return false;
  }
  
  private SQLiteDatabase b(int paramInt)
  {
    if (!c()) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return null;
      Object localObject = new File(Environment.getExternalStorageDirectory(), "inappad");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      localObject = new StringBuffer(((File)localObject).getAbsolutePath());
      ((StringBuffer)localObject).append("/").append("shared").append("3.0").append('.').append("db");
      if (paramInt == 268435456) {
        try
        {
          localObject = SQLiteDatabase.openDatabase(((StringBuffer)localObject).toString(), null, paramInt);
          if (a((SQLiteDatabase)localObject, "CREATE TABLE IF NOT EXISTS " + "TadTable" + " (" + "Key" + " TEXT PRIMARY KEY  NOT NULL, " + "Value" + " TEXT" + " )")) {
            break;
          }
          a((SQLiteDatabase)localObject);
          return null;
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            a(null);
            localSQLiteDatabase = null;
          }
        }
      }
    } while ((paramInt != 1) || (!new File(localSQLiteDatabase.toString()).exists()));
    try
    {
      localSQLiteDatabase = SQLiteDatabase.openDatabase(localSQLiteDatabase.toString(), null, paramInt);
      return localSQLiteDatabase;
    }
    catch (Throwable localThrowable2)
    {
      a(null);
      return null;
    }
    return localThrowable2;
  }
  
  private boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    if ((paramSQLiteDatabase == null) || (!c()))
    {
      a.d("AdSdkSettingManaget.canDatabaseUse()");
      return false;
    }
    return true;
  }
  
  /* Error */
  public boolean a(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: ldc 90
    //   9: invokespecial 129	com/skplanet/tad/common/e:b	(I)Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore 5
    //   14: aload_0
    //   15: aload 5
    //   17: invokespecial 29	com/skplanet/tad/common/e:b	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   20: istore 4
    //   22: iload 4
    //   24: ifeq +102 -> 126
    //   27: iload_1
    //   28: ifge +9 -> 37
    //   31: iload_3
    //   32: istore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: iload_2
    //   36: ireturn
    //   37: new 68	java/lang/StringBuffer
    //   40: dup
    //   41: invokespecial 98	java/lang/StringBuffer:<init>	()V
    //   44: astore 6
    //   46: aload 6
    //   48: ldc -125
    //   50: invokevirtual 80	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   53: pop
    //   54: aload 6
    //   56: ldc -123
    //   58: invokevirtual 80	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   61: ldc -121
    //   63: invokevirtual 80	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   66: iload_1
    //   67: invokevirtual 138	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   70: ldc -116
    //   72: invokevirtual 80	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   75: pop
    //   76: new 142	java/lang/StringBuilder
    //   79: dup
    //   80: ldc -112
    //   82: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   85: aload 6
    //   87: invokevirtual 93	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   90: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 151	com/skplanet/tad/common/a:c	(Ljava/lang/String;)V
    //   99: aload 5
    //   101: invokevirtual 32	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   104: aload 5
    //   106: aload 6
    //   108: invokevirtual 93	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   111: invokevirtual 36	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   114: aload 5
    //   116: invokevirtual 39	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   119: aload 5
    //   121: invokevirtual 42	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   124: iconst_1
    //   125: istore_2
    //   126: aload_0
    //   127: aload 5
    //   129: invokespecial 118	com/skplanet/tad/common/e:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   132: goto -99 -> 33
    //   135: astore 5
    //   137: aload_0
    //   138: monitorexit
    //   139: aload 5
    //   141: athrow
    //   142: astore 6
    //   144: ldc -103
    //   146: invokestatic 151	com/skplanet/tad/common/a:c	(Ljava/lang/String;)V
    //   149: aload_0
    //   150: aload 5
    //   152: invokespecial 118	com/skplanet/tad/common/e:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   155: iload_3
    //   156: istore_2
    //   157: goto -124 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	e
    //   0	160	1	paramInt	int
    //   1	156	2	bool1	boolean
    //   3	153	3	bool2	boolean
    //   20	3	4	bool3	boolean
    //   12	116	5	localSQLiteDatabase1	SQLiteDatabase
    //   135	16	5	localSQLiteDatabase2	SQLiteDatabase
    //   44	63	6	localStringBuffer	StringBuffer
    //   142	1	6	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   6	22	135	finally
    //   37	99	135	finally
    //   99	124	135	finally
    //   126	132	135	finally
    //   144	155	135	finally
    //   99	124	142	java/lang/Throwable
  }
  
  public c b()
  {
    Object localObject4 = null;
    String str2 = null;
    Object localObject3 = null;
    SQLiteDatabase localSQLiteDatabase;
    Cursor localCursor;
    try
    {
      localSQLiteDatabase = b(1);
      Object localObject1 = localObject4;
      if (b(localSQLiteDatabase))
      {
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append("select ").append("Key").append(" ,").append("Value").append(" from ").append("TadTable");
      }
      try
      {
        localCursor = localSQLiteDatabase.rawQuery(((StringBuffer)localObject1).toString(), null);
        localObject1 = localObject4;
        if (localCursor != null)
        {
          localObject1 = localObject3;
          if (localCursor.moveToFirst())
          {
            localObject1 = new c();
            if (!localCursor.isAfterLast()) {
              break label157;
            }
          }
          localCursor.close();
        }
        a(localSQLiteDatabase);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          a(localSQLiteDatabase);
          a.d("Exception in readFlagFromDb");
          String str1 = str2;
        }
      }
      return (c)localObject1;
    }
    finally {}
    label157:
    str2 = localCursor.getString(1);
    if (str2 != null)
    {
      if (!localCursor.getString(0).equals("TermsFlag")) {
        break label202;
      }
      ((c)localObject2).a(str2);
    }
    for (;;)
    {
      localCursor.moveToNext();
      break;
      label202:
      if (localCursor.getString(0).equals("DebugFlag")) {
        ((c)localObject2).b(str2);
      } else if (localCursor.getString(0).equals("AdRequestURL"))
      {
        if (!TextUtils.isEmpty(str2)) {
          ((c)localObject2).c(str2);
        }
      }
      else if ((localCursor.getString(0).equals("AdEventURL")) && (!TextUtils.isEmpty(str2))) {
        ((c)localObject2).d(str2);
      }
    }
  }
  
  public boolean c()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/common/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */