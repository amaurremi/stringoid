package com.j256.ormlite.android;

import android.database.Cursor;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.support.DatabaseResults;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AndroidDatabaseResults
  implements DatabaseResults
{
  private static final int MIN_NUM_COLUMN_NAMES_MAP = 8;
  private static final DatabaseType databaseType = new SqliteAndroidDatabaseType();
  private final Map<String, Integer> columnNameMap;
  private final String[] columnNames;
  private final Cursor cursor;
  private final ObjectCache objectCache;
  
  public AndroidDatabaseResults(Cursor paramCursor, ObjectCache paramObjectCache)
  {
    this.cursor = paramCursor;
    this.columnNames = paramCursor.getColumnNames();
    if (this.columnNames.length >= 8)
    {
      this.columnNameMap = new HashMap();
      int i = 0;
      while (i < this.columnNames.length)
      {
        this.columnNameMap.put(this.columnNames[i], Integer.valueOf(i));
        i += 1;
      }
    }
    this.columnNameMap = null;
    this.objectCache = paramObjectCache;
  }
  
  @Deprecated
  public AndroidDatabaseResults(Cursor paramCursor, boolean paramBoolean, ObjectCache paramObjectCache)
  {
    this(paramCursor, paramObjectCache);
  }
  
  private int lookupColumn(String paramString)
  {
    if (this.columnNameMap == null)
    {
      int i = 0;
      while (i < this.columnNames.length)
      {
        if (this.columnNames[i].equals(paramString)) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    paramString = (Integer)this.columnNameMap.get(paramString);
    if (paramString == null) {
      return -1;
    }
    return paramString.intValue();
  }
  
  public void close()
  {
    this.cursor.close();
  }
  
  public void closeQuietly()
  {
    close();
  }
  
  public int findColumn(String paramString)
    throws SQLException
  {
    int i = lookupColumn(paramString);
    if (i >= 0) {
      return i;
    }
    Object localObject = new StringBuilder(paramString.length() + 4);
    databaseType.appendEscapedEntityName((StringBuilder)localObject, paramString);
    i = lookupColumn(((StringBuilder)localObject).toString());
    if (i >= 0) {
      return i;
    }
    localObject = this.cursor.getColumnNames();
    throw new SQLException("Unknown field '" + paramString + "' from the Android sqlite cursor, not in:" + Arrays.toString((Object[])localObject));
  }
  
  public boolean first()
  {
    return this.cursor.moveToFirst();
  }
  
  public BigDecimal getBigDecimal(int paramInt)
    throws SQLException
  {
    throw new SQLException("Android does not support BigDecimal type.  Use BIG_DECIMAL or BIG_DECIMAL_STRING types");
  }
  
  public InputStream getBlobStream(int paramInt)
  {
    return new ByteArrayInputStream(this.cursor.getBlob(paramInt));
  }
  
  public boolean getBoolean(int paramInt)
  {
    return (!this.cursor.isNull(paramInt)) && (this.cursor.getShort(paramInt) != 0);
  }
  
  public byte getByte(int paramInt)
  {
    return (byte)getShort(paramInt);
  }
  
  public byte[] getBytes(int paramInt)
  {
    return this.cursor.getBlob(paramInt);
  }
  
  public char getChar(int paramInt)
    throws SQLException
  {
    String str = this.cursor.getString(paramInt);
    if ((str == null) || (str.length() == 0)) {
      return '\000';
    }
    if (str.length() == 1) {
      return str.charAt(0);
    }
    throw new SQLException("More than 1 character stored in database column: " + paramInt);
  }
  
  public int getColumnCount()
  {
    return this.cursor.getColumnCount();
  }
  
  public String[] getColumnNames()
  {
    int j = getColumnCount();
    String[] arrayOfString = new String[j];
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = this.cursor.getColumnName(i);
      i += 1;
    }
    return arrayOfString;
  }
  
  public int getCount()
  {
    return this.cursor.getCount();
  }
  
  public double getDouble(int paramInt)
  {
    return this.cursor.getDouble(paramInt);
  }
  
  public float getFloat(int paramInt)
  {
    return this.cursor.getFloat(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    return this.cursor.getInt(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    return this.cursor.getLong(paramInt);
  }
  
  public ObjectCache getObjectCache()
  {
    return this.objectCache;
  }
  
  public int getPosition()
  {
    return this.cursor.getPosition();
  }
  
  public Cursor getRawCursor()
  {
    return this.cursor;
  }
  
  public short getShort(int paramInt)
  {
    return this.cursor.getShort(paramInt);
  }
  
  public String getString(int paramInt)
  {
    return this.cursor.getString(paramInt);
  }
  
  public Timestamp getTimestamp(int paramInt)
    throws SQLException
  {
    throw new SQLException("Android does not support timestamp.  Use JAVA_DATE_LONG or JAVA_DATE_STRING types");
  }
  
  public boolean last()
  {
    return this.cursor.moveToLast();
  }
  
  public boolean moveAbsolute(int paramInt)
  {
    return this.cursor.moveToPosition(paramInt);
  }
  
  public boolean moveRelative(int paramInt)
  {
    return this.cursor.move(paramInt);
  }
  
  public boolean next()
  {
    return this.cursor.moveToNext();
  }
  
  public boolean previous()
  {
    return this.cursor.moveToPrevious();
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "@" + Integer.toHexString(super.hashCode());
  }
  
  public boolean wasNull(int paramInt)
  {
    return this.cursor.isNull(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/android/AndroidDatabaseResults.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */