package com.skplanet.tad.common;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.util.Enumeration;
import java.util.Hashtable;

public final class d
{
  private static final d a = new d();
  
  private Cursor a(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(paramString, paramArrayOfString);
      return paramSQLiteDatabase;
    }
    catch (Throwable paramSQLiteDatabase)
    {
      if (0 != 0) {
        throw new NullPointerException();
      }
      a.d("Throwable in select");
    }
    return null;
  }
  
  private SQLiteDatabase a(int paramInt)
  {
    if (!b()) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return null;
      Object localObject = new File(Environment.getExternalStorageDirectory(), "inappad");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      localObject = new StringBuffer(((File)localObject).getAbsolutePath());
      ((StringBuffer)localObject).append("/").append("shared").append("2.0").append('.').append("db");
      if ((paramInt & 0x1) != 1) {
        try
        {
          localObject = SQLiteDatabase.openDatabase(((StringBuffer)localObject).toString(), null, paramInt);
          if (a((SQLiteDatabase)localObject, "CREATE TABLE IF NOT EXISTS " + "TblAdSharedData" + " (" + "ColAdSetKey" + " TEXT PRIMARY KEY  NOT NULL, " + "ColAdSetText" + " TEXT, " + "ColAdSetInt" + " INTEGER NOT NULL  DEFAULT 0, " + "ColAdSetFloat" + " REAL NOT NULL  DEFAULT 0.0)")) {
            break;
          }
          b((SQLiteDatabase)localObject);
          return null;
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            a.d("open db");
            b(null);
            localSQLiteDatabase = null;
          }
        }
      }
    } while (!new File(localSQLiteDatabase.toString()).exists());
    try
    {
      localSQLiteDatabase = SQLiteDatabase.openDatabase(localSQLiteDatabase.toString(), null, paramInt);
      return localSQLiteDatabase;
    }
    catch (Throwable localThrowable2)
    {
      a.d("Throwable in openDataBase");
      b(null);
      return null;
    }
    return localThrowable2;
  }
  
  public static final d a()
  {
    return a;
  }
  
  private Hashtable a(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1)) {
      return null;
    }
    Hashtable localHashtable = new Hashtable(paramArrayOfString.length);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("select ").append("ColAdSetKey").append(", ").append("ColAdSetText").append(" from ").append("TblAdSharedData").append(" where");
    int i = 0;
    if (i >= paramArrayOfString.length)
    {
      paramSQLiteDatabase = a(paramSQLiteDatabase, localStringBuffer.toString(), paramArrayOfString);
      if (paramSQLiteDatabase != null) {
        if (!paramSQLiteDatabase.moveToFirst()) {}
      }
    }
    for (;;)
    {
      if (paramSQLiteDatabase.isAfterLast())
      {
        paramSQLiteDatabase.close();
        return localHashtable;
        if (i > 0) {
          localStringBuffer.append(" ").append("OR");
        }
        localStringBuffer.append(" ").append("ColAdSetKey").append(" = ? ");
        i += 1;
        break;
      }
      paramArrayOfString = paramSQLiteDatabase.getString(1);
      if (paramArrayOfString != null) {
        localHashtable.put(paramSQLiteDatabase.getString(0), paramArrayOfString);
      }
      paramSQLiteDatabase.moveToNext();
    }
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, Context paramContext, Hashtable paramHashtable)
  {
    if (paramHashtable == null) {
      return;
    }
    paramContext = paramHashtable.keys();
    label10:
    String str1;
    String str2;
    StringBuffer localStringBuffer;
    if (paramContext.hasMoreElements())
    {
      str1 = (String)paramContext.nextElement();
      str2 = (String)paramHashtable.get(str1);
      localStringBuffer = new StringBuffer();
      if (!TextUtils.isEmpty(str2)) {
        break label127;
      }
      localStringBuffer.append("insert or replace into TblAdSharedData(ColAdSetKey, ColAdSetText) values('");
      localStringBuffer.append(str1).append("', NULL);");
    }
    for (;;)
    {
      boolean bool = b(paramSQLiteDatabase, localStringBuffer.toString());
      a.c("putDbKeysString in AdSdkSettingManagerV2 db:" + bool + ":" + localStringBuffer.toString());
      break label10;
      break;
      label127:
      localStringBuffer.append("insert or replace into TblAdSharedData(ColAdSetKey, ColAdSetText) values('");
      localStringBuffer.append(str1).append("', '").append(str2).append("');");
    }
  }
  
  private boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    if ((paramSQLiteDatabase == null) || (!b()))
    {
      a.c("There is no DB, isAvailableSdcard : " + b());
      return false;
    }
    return true;
  }
  
  private boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    if (!a(paramSQLiteDatabase)) {
      return false;
    }
    try
    {
      paramSQLiteDatabase.beginTransaction();
      paramSQLiteDatabase.execSQL(paramString);
      paramSQLiteDatabase.setTransactionSuccessful();
      return true;
    }
    catch (Throwable paramString)
    {
      a.d("Throwable in makeNewTable");
      return false;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase != null) {
      paramSQLiteDatabase.close();
    }
  }
  
  private boolean b(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    if (!a(paramSQLiteDatabase)) {
      return false;
    }
    try
    {
      paramSQLiteDatabase.beginTransaction();
      paramSQLiteDatabase.execSQL(paramString);
      paramSQLiteDatabase.setTransactionSuccessful();
      return true;
    }
    catch (Throwable paramString)
    {
      a.d("Throwable in modify");
      return false;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  private SQLiteDatabase c()
  {
    return a(268435456);
  }
  
  public Hashtable a(Context paramContext)
  {
    paramContext = null;
    SQLiteDatabase localSQLiteDatabase = a(1);
    String[] arrayOfString;
    int i;
    if (a(localSQLiteDatabase))
    {
      paramContext = a.values();
      arrayOfString = new String[paramContext.length];
      i = 0;
    }
    for (;;)
    {
      if (i >= arrayOfString.length)
      {
        paramContext = a(localSQLiteDatabase, arrayOfString);
        b(localSQLiteDatabase);
        return paramContext;
      }
      arrayOfString[i] = paramContext[i].name();
      i += 1;
    }
  }
  
  public boolean a(Context paramContext, Hashtable paramHashtable)
  {
    boolean bool = false;
    SQLiteDatabase localSQLiteDatabase = c();
    if (a(localSQLiteDatabase))
    {
      a(localSQLiteDatabase, paramContext, paramHashtable);
      bool = true;
    }
    b(localSQLiteDatabase);
    return bool;
  }
  
  public boolean b()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static enum a {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/common/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */