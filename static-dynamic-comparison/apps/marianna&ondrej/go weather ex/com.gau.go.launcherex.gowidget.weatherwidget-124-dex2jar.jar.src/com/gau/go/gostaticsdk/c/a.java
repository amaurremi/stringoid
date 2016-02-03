package com.gau.go.gostaticsdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class a
  extends SQLiteOpenHelper
{
  public static String a = "statistics";
  public static String b = "funid";
  public static String c = "id";
  public static String d = "channel";
  @Deprecated
  public static String e = "ispay";
  @Deprecated
  public static String f = "productid";
  public static String g = "data";
  @Deprecated
  public static String h = "functionid";
  @Deprecated
  public static String i = "sender";
  @Deprecated
  public static String j = "optioncode";
  @Deprecated
  public static String k = "optionresult";
  @Deprecated
  public static String l = "entrance";
  @Deprecated
  public static String m = "typeid";
  @Deprecated
  public static String n = "position";
  public static String o = "url";
  public static String p = "opcode";
  @Deprecated
  public static String q = "nrootinfo";
  @Deprecated
  public static String r = "isnew";
  @Deprecated
  public static String s = "key";
  private static String t = "create table " + a + "(" + "id numeric, " + "funid numeric, " + "channel text, " + "ispay numeric, " + "productid text, " + "data text, " + "functionid numeric, " + "sender text, " + "optioncode text, " + "optionresult numeric, " + "entrance text, " + "typeid text, " + "position numeric, " + "url text, " + "opcode numeric," + "nrootinfo numeric," + "isnew numeric, " + "key text" + ")";
  private boolean u = true;
  
  public a(Context paramContext)
  {
    super(paramContext, "gostatistics_sdk.db", null, 4);
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      if (!this.u)
      {
        if (localSQLiteDatabase != null) {
          localSQLiteDatabase.close();
        }
        paramContext.deleteDatabase("gostatistics_sdk.db");
        getWritableDatabase();
      }
      return;
    }
    catch (Exception localException)
    {
      paramContext.deleteDatabase("gostatistics_sdk.db");
    }
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!a(paramSQLiteDatabase, paramString1, paramString2)) {
      paramSQLiteDatabase.beginTransaction();
    }
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE " + paramString1 + " ADD COLUMN " + paramString2 + " " + paramString3 + ";");
      if (paramString4 != null)
      {
        String str = paramString4;
        if (paramString3.equals("text")) {
          str = "'" + paramString4 + "'";
        }
        paramSQLiteDatabase.execSQL("update " + paramString1 + " set " + paramString2 + " = " + str);
      }
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  private boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.beginTransaction();
    try
    {
      a(paramSQLiteDatabase, a, o, "text", null);
      a(paramSQLiteDatabase, a, p, "numeric", String.valueOf(3));
      paramSQLiteDatabase.setTransactionSuccessful();
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return false;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  /* Error */
  private boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: aload_2
    //   5: iconst_1
    //   6: anewarray 212	java/lang/String
    //   9: dup
    //   10: iconst_0
    //   11: aload_3
    //   12: aastore
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: invokevirtual 246	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   21: astore_1
    //   22: aload_1
    //   23: ifnull +94 -> 117
    //   26: aload_1
    //   27: aload_3
    //   28: invokeinterface 252 2 0
    //   33: istore 4
    //   35: iload 4
    //   37: iflt +80 -> 117
    //   40: iconst_1
    //   41: istore 5
    //   43: aload_1
    //   44: ifnull +9 -> 53
    //   47: aload_1
    //   48: invokeinterface 253 1 0
    //   53: iload 5
    //   55: ireturn
    //   56: astore_1
    //   57: aconst_null
    //   58: astore_1
    //   59: ldc -1
    //   61: ldc_w 257
    //   64: invokestatic 262	com/gau/go/gostaticsdk/f/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_1
    //   68: ifnull +47 -> 115
    //   71: aload_1
    //   72: invokeinterface 253 1 0
    //   77: iconst_0
    //   78: ireturn
    //   79: astore_1
    //   80: aload 6
    //   82: astore_2
    //   83: aload_2
    //   84: ifnull +9 -> 93
    //   87: aload_2
    //   88: invokeinterface 253 1 0
    //   93: aload_1
    //   94: athrow
    //   95: astore_3
    //   96: aload_1
    //   97: astore_2
    //   98: aload_3
    //   99: astore_1
    //   100: goto -17 -> 83
    //   103: astore_3
    //   104: aload_1
    //   105: astore_2
    //   106: aload_3
    //   107: astore_1
    //   108: goto -25 -> 83
    //   111: astore_2
    //   112: goto -53 -> 59
    //   115: iconst_0
    //   116: ireturn
    //   117: iconst_0
    //   118: istore 5
    //   120: goto -77 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	a
    //   0	123	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	123	2	paramString1	String
    //   0	123	3	paramString2	String
    //   33	3	4	i1	int
    //   41	78	5	bool	boolean
    //   1	80	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	22	56	java/lang/Exception
    //   3	22	79	finally
    //   26	35	95	finally
    //   59	67	103	finally
    //   26	35	111	java/lang/Exception
  }
  
  private boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.beginTransaction();
    try
    {
      a(paramSQLiteDatabase, a, q, "numeric", String.valueOf(0));
      paramSQLiteDatabase.setTransactionSuccessful();
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return false;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  private boolean c(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.beginTransaction();
    try
    {
      a(paramSQLiteDatabase, a, r, "numeric", String.valueOf(0));
      a(paramSQLiteDatabase, a, s, "text", String.valueOf(-1));
      paramSQLiteDatabase.setTransactionSuccessful();
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return false;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public int a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    try
    {
      int i1 = localSQLiteDatabase.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      return i1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return 0;
  }
  
  public int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    try
    {
      int i1 = localSQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString);
      return i1;
    }
    catch (Exception paramString1) {}
    return 0;
  }
  
  public long a(String paramString, ContentValues paramContentValues)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    try
    {
      long l1 = localSQLiteDatabase.insert(paramString, null, paramContentValues);
      return l1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3)
  {
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    try
    {
      paramString1 = localSQLiteDatabase.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, paramString3);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.beginTransaction();
    try
    {
      paramSQLiteDatabase.execSQL(t);
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 1) || (paramInt1 > paramInt2) || (paramInt2 > 4))
    {
      com.gau.go.gostaticsdk.f.d.a("StatisticsManager", "onUpgrade() false oldVersion = " + paramInt1 + ", newVersion = " + paramInt2);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new c(this));
    localArrayList.add(new e(this));
    localArrayList.add(new d(this));
    paramInt1 -= 1;
    for (;;)
    {
      if (paramInt1 < paramInt2 - 1)
      {
        this.u = ((b)localArrayList.get(paramInt1)).a(paramSQLiteDatabase);
        if (this.u) {}
      }
      else
      {
        localArrayList.clear();
        return;
      }
      paramInt1 += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/gostaticsdk/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */