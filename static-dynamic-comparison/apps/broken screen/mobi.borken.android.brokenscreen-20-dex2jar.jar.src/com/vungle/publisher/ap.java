package com.vungle.publisher;

import android.database.Cursor;
import android.database.SQLException;

public final class ap
{
  public static Boolean a(Cursor paramCursor, String paramString)
    throws SQLException
  {
    Object localObject = null;
    Integer localInteger = c(paramCursor, paramString);
    paramCursor = (Cursor)localObject;
    if (localInteger != null) {}
    switch (localInteger.intValue())
    {
    default: 
      throw new SQLException("invalid boolean value " + localInteger + " for column " + paramString);
    case 0: 
      paramCursor = Boolean.FALSE;
      return paramCursor;
    }
    return Boolean.TRUE;
  }
  
  private static <E extends Enum<E>> E a(Cursor paramCursor, int paramInt, Class<E> paramClass)
    throws SQLException
  {
    String str = paramCursor.getString(paramInt);
    try
    {
      if (paramCursor.isNull(paramInt)) {
        return null;
      }
      paramCursor = Enum.valueOf(paramClass, str);
      return paramCursor;
    }
    catch (IllegalArgumentException paramCursor)
    {
      throw new SQLException("invalid enum: " + str);
    }
  }
  
  public static <E extends Enum<E>> E a(Cursor paramCursor, String paramString, Class<E> paramClass)
    throws SQLException
  {
    try
    {
      paramCursor = a(paramCursor, paramCursor.getColumnIndexOrThrow(paramString), paramClass);
      return paramCursor;
    }
    catch (IllegalArgumentException paramCursor)
    {
      throw new SQLException("invalid column name: " + paramString);
    }
  }
  
  private static Integer a(Cursor paramCursor, int paramInt)
    throws SQLException
  {
    if (paramCursor.isNull(paramInt)) {
      return null;
    }
    return Integer.valueOf(paramCursor.getInt(paramInt));
  }
  
  public static String a(int paramInt)
  {
    if (paramInt <= 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder((paramInt << 1) - 1);
    localStringBuilder.append("?");
    int i = 1;
    while (i < paramInt)
    {
      localStringBuilder.append(",?");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static Float b(Cursor paramCursor, String paramString)
    throws SQLException
  {
    try
    {
      int i = paramCursor.getColumnIndexOrThrow(paramString);
      if (paramCursor.isNull(i)) {
        return null;
      }
      float f = paramCursor.getFloat(i);
      return Float.valueOf(f);
    }
    catch (IllegalArgumentException paramCursor)
    {
      throw new SQLException("invalid column name: " + paramString);
    }
  }
  
  public static Integer c(Cursor paramCursor, String paramString)
    throws SQLException
  {
    try
    {
      paramCursor = a(paramCursor, paramCursor.getColumnIndexOrThrow(paramString));
      return paramCursor;
    }
    catch (IllegalArgumentException paramCursor)
    {
      throw new SQLException("invalid column name: " + paramString);
    }
  }
  
  /* Error */
  public static Integer d(Cursor paramCursor, String paramString)
    throws SQLException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: aload_1
    //   3: invokeinterface 79 2 0
    //   8: invokestatic 114	com/vungle/publisher/ap:a	(Landroid/database/Cursor;I)Ljava/lang/Integer;
    //   11: astore_0
    //   12: aload_0
    //   13: ifnonnull +10 -> 23
    //   16: iconst_0
    //   17: istore_2
    //   18: iload_2
    //   19: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   22: areturn
    //   23: aload_0
    //   24: invokevirtual 18	java/lang/Integer:intValue	()I
    //   27: istore_2
    //   28: goto -10 -> 18
    //   31: astore_0
    //   32: new 8	android/database/SQLException
    //   35: dup
    //   36: new 20	java/lang/StringBuilder
    //   39: dup
    //   40: ldc 83
    //   42: invokespecial 26	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   45: aload_1
    //   46: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokespecial 40	android/database/SQLException:<init>	(Ljava/lang/String;)V
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	paramCursor	Cursor
    //   0	56	1	paramString	String
    //   17	11	2	i	int
    // Exception table:
    //   from	to	target	type
    //   0	12	31	java/lang/IllegalArgumentException
    //   18	23	31	java/lang/IllegalArgumentException
    //   23	28	31	java/lang/IllegalArgumentException
  }
  
  public static Long e(Cursor paramCursor, String paramString)
    throws SQLException
  {
    try
    {
      int i = paramCursor.getColumnIndexOrThrow(paramString);
      if (paramCursor.isNull(i)) {
        return null;
      }
      long l = paramCursor.getLong(i);
      return Long.valueOf(l);
    }
    catch (IllegalArgumentException paramCursor)
    {
      throw new SQLException("invalid column name: " + paramString);
    }
  }
  
  public static String f(Cursor paramCursor, String paramString)
    throws SQLException
  {
    try
    {
      paramCursor = paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString));
      return paramCursor;
    }
    catch (IllegalArgumentException paramCursor)
    {
      throw new SQLException("invalid column name: " + paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */