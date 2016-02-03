package com.inmobi.commons.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.inmobi.commons.internal.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public abstract class DatabaseHandler
  extends SQLiteOpenHelper
{
  public static final String DATABASE_NAME = "im.db";
  private static String c = "CREATE TABLE IF NOT EXISTS ";
  private static String d = "DROP TABLE IF EXISTS ";
  private static String e = " PRIMARY KEY ";
  private static String f = " AUTOINCREMENT ";
  private static String g = " NOT NULL ";
  private static String h = "SELECT * FROM ";
  private static String i = " WHERE ";
  private static String j = " ORDER BY ";
  private static String k = "; ";
  private static String l = " Limit ?";
  private ArrayList<TableData> a;
  private SQLiteDatabase b;
  
  protected DatabaseHandler(Context paramContext, ArrayList<TableData> paramArrayList)
  {
    super(paramContext, "im.db", null, 1);
    this.a = paramArrayList;
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject2;
    try
    {
      if ((this.a != null) && (!this.a.isEmpty()))
      {
        Iterator localIterator1 = this.a.iterator();
        if (localIterator1.hasNext())
        {
          localObject1 = (TableData)localIterator1.next();
          localObject2 = ((TableData)localObject1).getmTableName();
          localObject1 = ((TableData)localObject1).getmColumns();
          localObject2 = new StringBuilder(c + (String)localObject2 + " (");
          Iterator localIterator2 = ((LinkedHashMap)localObject1).keySet().iterator();
          while (localIterator2.hasNext())
          {
            String str = (String)localIterator2.next();
            ColumnData localColumnData = (ColumnData)((LinkedHashMap)localObject1).get(str);
            ((StringBuilder)localObject2).append(" " + str + " " + localColumnData.getDataType().toString());
            if (localColumnData.isPrimaryKey()) {
              ((StringBuilder)localObject2).append(e);
            }
            if (localColumnData.isAutoIncrement()) {
              ((StringBuilder)localObject2).append(f);
            }
            if (localColumnData.isMandatory()) {
              ((StringBuilder)localObject2).append(g);
            }
            ((StringBuilder)localObject2).append(",");
          }
        }
      }
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      Log.internal("[InMobi]-4.1.1", "Exception creating table", paramSQLiteDatabase);
    }
    if (',' == ((StringBuilder)localObject2).charAt(((StringBuilder)localObject2).length() - 1)) {}
    for (Object localObject1 = ((StringBuilder)localObject2).substring(0, ((StringBuilder)localObject2).length() - 2);; localObject1 = ((StringBuilder)localObject2).toString())
    {
      localObject1 = ((String)localObject1).concat(" );");
      Log.internal("[InMobi]-4.1.1", "Table: " + (String)localObject1);
      paramSQLiteDatabase.execSQL((String)localObject1);
      break;
    }
  }
  
  public void close()
  {
    try
    {
      this.b.close();
      return;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-4.1.1", "Failed to close  db", localException);
    }
  }
  
  public int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      m = this.b.delete(paramString1, paramString2, paramArrayOfString);
      return m;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.internal("[InMobi]-4.1.1", "Failed to insert to db", paramString1);
        int m = -1;
      }
    }
    finally {}
  }
  
  public Cursor executeQuery(String paramString, String[] paramArrayOfString)
  {
    try
    {
      paramString = this.b.rawQuery(paramString, paramArrayOfString);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.internal("[InMobi]-4.1.1", "Failed to execute db query", paramString);
        paramString = null;
      }
    }
    finally {}
  }
  
  public Cursor getAll(String paramString1, String paramString2)
  {
    localObject = null;
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        if (!"".equals(paramString2.trim())) {
          continue;
        }
        paramString1 = this.b.rawQuery(h + paramString1 + k, null);
        paramString1.moveToFirst();
      }
      catch (Exception paramString1)
      {
        Log.internal("[InMobi]-4.1.1", "Failed to all rows", paramString1);
        paramString1 = (String)localObject;
        continue;
      }
      finally {}
      return paramString1;
      paramString1 = this.b.rawQuery(h + paramString1 + j + paramString2 + k, null);
    }
  }
  
  public Cursor getNRows(String paramString1, String paramString2, int paramInt)
  {
    localObject = null;
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        if (!"".equals(paramString2.trim())) {
          continue;
        }
        paramString1 = this.b.rawQuery(h + paramString1 + k, null);
        paramString1.moveToFirst();
      }
      catch (Exception paramString1)
      {
        Log.internal("[InMobi]-4.1.1", "Failed to all rows", paramString1);
        paramString1 = (String)localObject;
        continue;
      }
      finally {}
      return paramString1;
      paramString1 = this.b.rawQuery(h + paramString1 + j + paramString2 + l + k, new String[] { String.valueOf(paramInt) });
    }
  }
  
  public int getNoOfRows(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        if ("".equals(paramString2.trim())) {
          continue;
        }
        paramString1 = this.b.rawQuery(h + paramString1 + i + paramString2, paramArrayOfString);
        m = paramString1.getCount();
        paramString1.close();
      }
      catch (Exception paramString1)
      {
        Log.internal("[InMobi]-4.1.1", "Failed to get number of rows", paramString1);
        int m = 0;
        continue;
      }
      finally {}
      return m;
      paramString1 = this.b.rawQuery(h + paramString1 + k, null);
    }
  }
  
  public Cursor getRow(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    localObject = null;
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        if (!"".equals(paramString2.trim())) {
          continue;
        }
        paramString1 = this.b.rawQuery(h + paramString1 + k, null);
        paramString1.moveToFirst();
      }
      catch (Exception paramString1)
      {
        Log.internal("[InMobi]-4.1.1", "Failed to all rows", paramString1);
        paramString1 = (String)localObject;
        continue;
      }
      finally {}
      return paramString1;
      paramString1 = this.b.rawQuery(h + paramString1 + i + paramString2 + k, paramArrayOfString);
    }
  }
  
  protected int getTableSize(String paramString)
  {
    try
    {
      paramString = this.b.rawQuery(h + paramString + k, null);
      m = paramString.getCount();
      paramString.close();
      return m;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.internal("[InMobi]-4.1.1", "Failed to table size ", paramString);
        int m = 0;
      }
    }
    finally {}
  }
  
  public long insert(String paramString, ContentValues paramContentValues)
  {
    try
    {
      l1 = this.b.insert(paramString, null, paramContentValues);
      return l1;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.internal("[InMobi]-4.1.1", "Failed to insert to db", paramString);
        long l1 = -1L;
      }
    }
    finally {}
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      a(paramSQLiteDatabase);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      Log.internal("[InMobi]-4.1.1", "Exception Creating table", paramSQLiteDatabase);
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        String str = ((TableData)localIterator.next()).getmTableName();
        paramSQLiteDatabase.execSQL(d + str);
      }
      onCreate(paramSQLiteDatabase);
    }
    catch (Exception paramSQLiteDatabase)
    {
      Log.internal("[InMobi]-4.1.1", "Exception Deleting table", paramSQLiteDatabase);
      return;
    }
  }
  
  public void open()
  {
    try
    {
      this.b = getWritableDatabase();
      return;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-4.1.1", "Failed to open  db", localException);
    }
  }
  
  public long update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      int m = this.b.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      l1 = m;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.internal("[InMobi]-4.1.1", "Failed to insert to db", paramString1);
        long l1 = -1L;
      }
    }
    finally {}
    return l1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/db/DatabaseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */