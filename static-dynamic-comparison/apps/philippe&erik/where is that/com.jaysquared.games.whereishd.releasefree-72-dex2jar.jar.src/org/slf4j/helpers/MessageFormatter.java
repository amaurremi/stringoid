package org.slf4j.helpers;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public final class MessageFormatter
{
  static final char DELIM_START = '{';
  static final char DELIM_STOP = '}';
  static final String DELIM_STR = "{}";
  private static final char ESCAPE_CHAR = '\\';
  
  public static final String arrayFormat(String paramString, Object[] paramArrayOfObject)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    int i;
    StringBuffer localStringBuffer;
    int j;
    int k;
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (paramArrayOfObject == null);
      i = 0;
      localStringBuffer = new StringBuffer(paramString.length() + 50);
      j = 0;
      if (j >= paramArrayOfObject.length) {
        break label217;
      }
      k = paramString.indexOf("{}", i);
      if (k != -1) {
        break;
      }
      str = paramString;
    } while (i == 0);
    localStringBuffer.append(paramString.substring(i, paramString.length()));
    return localStringBuffer.toString();
    if (isEscapedDelimeter(paramString, k)) {
      if (!isDoubleEscaped(paramString, k))
      {
        j -= 1;
        localStringBuffer.append(paramString.substring(i, k - 1));
        localStringBuffer.append('{');
        i = k + 1;
      }
    }
    for (;;)
    {
      j += 1;
      break;
      localStringBuffer.append(paramString.substring(i, k - 1));
      deeplyAppendParameter(localStringBuffer, paramArrayOfObject[j], new HashMap());
      i = k + 2;
      continue;
      localStringBuffer.append(paramString.substring(i, k));
      deeplyAppendParameter(localStringBuffer, paramArrayOfObject[j], new HashMap());
      i = k + 2;
    }
    label217:
    localStringBuffer.append(paramString.substring(i, paramString.length()));
    return localStringBuffer.toString();
  }
  
  private static void booleanArrayAppend(StringBuffer paramStringBuffer, boolean[] paramArrayOfBoolean)
  {
    paramStringBuffer.append('[');
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuffer.append(paramArrayOfBoolean[i]);
      if (i != j - 1) {
        paramStringBuffer.append(", ");
      }
      i += 1;
    }
    paramStringBuffer.append(']');
  }
  
  private static void byteArrayAppend(StringBuffer paramStringBuffer, byte[] paramArrayOfByte)
  {
    paramStringBuffer.append('[');
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuffer.append(paramArrayOfByte[i]);
      if (i != j - 1) {
        paramStringBuffer.append(", ");
      }
      i += 1;
    }
    paramStringBuffer.append(']');
  }
  
  private static void charArrayAppend(StringBuffer paramStringBuffer, char[] paramArrayOfChar)
  {
    paramStringBuffer.append('[');
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuffer.append(paramArrayOfChar[i]);
      if (i != j - 1) {
        paramStringBuffer.append(", ");
      }
      i += 1;
    }
    paramStringBuffer.append(']');
  }
  
  private static void deeplyAppendParameter(StringBuffer paramStringBuffer, Object paramObject, Map paramMap)
  {
    if (paramObject == null)
    {
      paramStringBuffer.append("null");
      return;
    }
    if (!paramObject.getClass().isArray())
    {
      safeObjectAppend(paramStringBuffer, paramObject);
      return;
    }
    if ((paramObject instanceof boolean[]))
    {
      booleanArrayAppend(paramStringBuffer, (boolean[])paramObject);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      byteArrayAppend(paramStringBuffer, (byte[])paramObject);
      return;
    }
    if ((paramObject instanceof char[]))
    {
      charArrayAppend(paramStringBuffer, (char[])paramObject);
      return;
    }
    if ((paramObject instanceof short[]))
    {
      shortArrayAppend(paramStringBuffer, (short[])paramObject);
      return;
    }
    if ((paramObject instanceof int[]))
    {
      intArrayAppend(paramStringBuffer, (int[])paramObject);
      return;
    }
    if ((paramObject instanceof long[]))
    {
      longArrayAppend(paramStringBuffer, (long[])paramObject);
      return;
    }
    if ((paramObject instanceof float[]))
    {
      floatArrayAppend(paramStringBuffer, (float[])paramObject);
      return;
    }
    if ((paramObject instanceof double[]))
    {
      doubleArrayAppend(paramStringBuffer, (double[])paramObject);
      return;
    }
    objectArrayAppend(paramStringBuffer, (Object[])paramObject, paramMap);
  }
  
  private static void doubleArrayAppend(StringBuffer paramStringBuffer, double[] paramArrayOfDouble)
  {
    paramStringBuffer.append('[');
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuffer.append(paramArrayOfDouble[i]);
      if (i != j - 1) {
        paramStringBuffer.append(", ");
      }
      i += 1;
    }
    paramStringBuffer.append(']');
  }
  
  private static void floatArrayAppend(StringBuffer paramStringBuffer, float[] paramArrayOfFloat)
  {
    paramStringBuffer.append('[');
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuffer.append(paramArrayOfFloat[i]);
      if (i != j - 1) {
        paramStringBuffer.append(", ");
      }
      i += 1;
    }
    paramStringBuffer.append(']');
  }
  
  public static final String format(String paramString, Object paramObject)
  {
    return arrayFormat(paramString, new Object[] { paramObject });
  }
  
  public static final String format(String paramString, Object paramObject1, Object paramObject2)
  {
    return arrayFormat(paramString, new Object[] { paramObject1, paramObject2 });
  }
  
  private static void intArrayAppend(StringBuffer paramStringBuffer, int[] paramArrayOfInt)
  {
    paramStringBuffer.append('[');
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuffer.append(paramArrayOfInt[i]);
      if (i != j - 1) {
        paramStringBuffer.append(", ");
      }
      i += 1;
    }
    paramStringBuffer.append(']');
  }
  
  static final boolean isDoubleEscaped(String paramString, int paramInt)
  {
    return (paramInt >= 2) && (paramString.charAt(paramInt - 2) == '\\');
  }
  
  static final boolean isEscapedDelimeter(String paramString, int paramInt)
  {
    if (paramInt == 0) {}
    while (paramString.charAt(paramInt - 1) != '\\') {
      return false;
    }
    return true;
  }
  
  private static void longArrayAppend(StringBuffer paramStringBuffer, long[] paramArrayOfLong)
  {
    paramStringBuffer.append('[');
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuffer.append(paramArrayOfLong[i]);
      if (i != j - 1) {
        paramStringBuffer.append(", ");
      }
      i += 1;
    }
    paramStringBuffer.append(']');
  }
  
  private static void objectArrayAppend(StringBuffer paramStringBuffer, Object[] paramArrayOfObject, Map paramMap)
  {
    paramStringBuffer.append('[');
    if (!paramMap.containsKey(paramArrayOfObject))
    {
      paramMap.put(paramArrayOfObject, null);
      int j = paramArrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        deeplyAppendParameter(paramStringBuffer, paramArrayOfObject[i], paramMap);
        if (i != j - 1) {
          paramStringBuffer.append(", ");
        }
        i += 1;
      }
      paramMap.remove(paramArrayOfObject);
    }
    for (;;)
    {
      paramStringBuffer.append(']');
      return;
      paramStringBuffer.append("...");
    }
  }
  
  private static void safeObjectAppend(StringBuffer paramStringBuffer, Object paramObject)
  {
    try
    {
      paramStringBuffer.append(paramObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      System.err.println("SLF4J: Failed toString() invocation on an object of type [" + paramObject.getClass().getName() + "]");
      localThrowable.printStackTrace();
      paramStringBuffer.append("[FAILED toString()]");
    }
  }
  
  private static void shortArrayAppend(StringBuffer paramStringBuffer, short[] paramArrayOfShort)
  {
    paramStringBuffer.append('[');
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuffer.append(paramArrayOfShort[i]);
      if (i != j - 1) {
        paramStringBuffer.append(", ");
      }
      i += 1;
    }
    paramStringBuffer.append(']');
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/slf4j/helpers/MessageFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */