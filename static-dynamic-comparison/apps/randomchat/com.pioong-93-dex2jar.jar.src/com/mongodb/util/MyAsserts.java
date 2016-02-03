package com.mongodb.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyAsserts
{
  private static Pattern _whiteSpace = Pattern.compile("\\s+", 40);
  
  public static void _assertEquals(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      if (paramObject2 != null) {}
    }
    while (paramObject1.equals(paramObject2))
    {
      return;
      throw new MyAssert("left null, right not");
    }
    throw new MyAssert("[" + paramObject1 + "] != [" + paramObject2 + "] ");
  }
  
  private static String _simplify(String paramString)
  {
    paramString = paramString.trim();
    return _whiteSpace.matcher(paramString).replaceAll("");
  }
  
  public static void assertArrayEquals(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (Arrays.equals(paramArrayOfByte1, paramArrayOfByte2)) {
      return;
    }
    throw new MyAssert("These arrays are different, but they might be big so not printing them here");
  }
  
  public static void assertArrayEquals(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    if (Arrays.equals(paramArrayOfChar1, paramArrayOfChar2)) {
      return;
    }
    throw new MyAssert("These arrays are different, but they might be big so not printing them here");
  }
  
  public static void assertClose(String paramString, Object paramObject)
  {
    if (paramObject == null) {}
    for (paramObject = "null";; paramObject = paramObject.toString())
    {
      assertClose(paramString, (String)paramObject);
      return;
    }
  }
  
  public static void assertClose(String paramString1, String paramString2)
  {
    assertClose(paramString1, paramString2, "");
  }
  
  public static void assertClose(String paramString1, String paramString2, String paramString3)
  {
    if (isClose(paramString1, paramString2)) {
      return;
    }
    throw new MyAssert(paramString3 + "[" + paramString1 + "] != [" + paramString2 + "]");
  }
  
  public static void assertEmptyString(String paramString)
  {
    if (!paramString.equals("")) {
      throw new MyAssert(paramString);
    }
  }
  
  public static void assertEquals(byte paramByte1, byte paramByte2)
  {
    if (paramByte1 != paramByte2) {
      throw new MyAssert("" + paramByte1 + " != " + paramByte2);
    }
  }
  
  public static void assertEquals(char paramChar1, char paramChar2)
  {
    if (paramChar1 != paramChar2) {
      throw new MyAssert("" + paramChar1 + " != " + paramChar2);
    }
  }
  
  public static void assertEquals(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (Math.abs(paramDouble1 - paramDouble2) > paramDouble3) {
      throw new MyAssert("" + paramDouble1 + " != " + paramDouble2);
    }
  }
  
  public static void assertEquals(int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2) {
      throw new MyAssert("" + paramInt1 + " != " + paramInt2);
    }
  }
  
  public static void assertEquals(long paramLong1, long paramLong2)
  {
    if (paramLong1 != paramLong2) {
      throw new MyAssert("" + paramLong1 + " != " + paramLong2);
    }
  }
  
  public static void assertEquals(Object paramObject1, Object paramObject2)
  {
    _assertEquals(paramObject1, paramObject2);
  }
  
  public static void assertEquals(String paramString, Object paramObject)
  {
    if (paramObject == null) {}
    for (paramObject = null;; paramObject = paramObject.toString())
    {
      _assertEquals(paramString, paramObject);
      return;
    }
  }
  
  public static void assertEquals(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1.equals(paramString2)) {
      return;
    }
    throw new MyAssert("[" + paramString1 + "] != [" + paramString2 + "] " + paramString3);
  }
  
  public static void assertEquals(short paramShort1, short paramShort2)
  {
    if (paramShort1 != paramShort2) {
      throw new MyAssert("" + paramShort1 + " != " + paramShort2);
    }
  }
  
  public static void assertFalse(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new MyAssert("true");
    }
  }
  
  public static void assertLess(double paramDouble1, double paramDouble2)
  {
    if (paramDouble1 < paramDouble2) {
      return;
    }
    throw new MyAssert(paramDouble1 + " is higher than " + paramDouble2);
  }
  
  public static void assertLess(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return;
    }
    throw new MyAssert(paramLong1 + " is higher than " + paramLong2);
  }
  
  public static void assertNotEquals(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      if (paramObject2 == null) {}
    }
    while (!paramObject1.equals(paramObject2))
    {
      return;
      throw new MyAssert("left null, right null");
    }
    throw new MyAssert("[" + paramObject1 + "] == [" + paramObject2 + "] ");
  }
  
  public static void assertNotNull(Object paramObject)
  {
    if (paramObject != null) {
      return;
    }
    throw new MyAssert("null");
  }
  
  public static void assertNull(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    throw new MyAssert("not null [" + paramObject + "]");
  }
  
  public static void assertSame(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != paramObject2) {
      throw new MyAssert(paramObject1 + " != " + paramObject2);
    }
  }
  
  public static void assertTrue(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new MyAssert("false");
    }
  }
  
  public static void assertTrue(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new MyAssert("false : " + paramString);
    }
  }
  
  public static void fail(String paramString)
  {
    throw new MyAssert(paramString);
  }
  
  public static boolean isClose(String paramString1, String paramString2)
  {
    return _simplify(paramString1).equalsIgnoreCase(_simplify(paramString2));
  }
  
  public static class MyAssert
    extends RuntimeException
  {
    private static final long serialVersionUID = -4415279469780082174L;
    final String _s;
    
    MyAssert(String paramString)
    {
      super();
      this._s = paramString;
    }
    
    public String toString()
    {
      return this._s;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/MyAsserts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */