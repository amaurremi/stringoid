package mobi.beyondpod.rsscore.helpers;

import java.util.UUID;

public class StringUtils
{
  public static final String Empty = "";
  private static final String TAG = "StringUtils";
  
  public static String DoubleToInvariantCultureString(double paramDouble)
  {
    return Double.valueOf(paramDouble).toString();
  }
  
  public static boolean Equals(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if (paramString1 != null) {
      return paramString1.equals(paramString2);
    }
    return false;
  }
  
  public static boolean EqualsIgnoreCase(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if (paramString1 != null) {
      return paramString1.equalsIgnoreCase(paramString2);
    }
    return false;
  }
  
  public static boolean IsNullOrEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static String LongToInvariantCultureString(long paramLong)
  {
    return Long.valueOf(paramLong).toString();
  }
  
  public static float SafeParseFloat(String paramString, float paramFloat)
  {
    try
    {
      float f = Float.parseFloat(paramString);
      return f;
    }
    catch (Throwable paramString) {}
    return paramFloat;
  }
  
  public static int SafeParseInt(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Throwable paramString) {}
    return paramInt;
  }
  
  public static long SafeParseLong(String paramString, long paramLong)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Throwable paramString) {}
    return paramLong;
  }
  
  public static boolean TryParseBooleanFromString(String paramString, boolean paramBoolean)
  {
    if (IsNullOrEmpty(paramString)) {
      return paramBoolean;
    }
    return paramString.equalsIgnoreCase("1");
  }
  
  public static Double TryParseDoubleFromString(String paramString, Double paramDouble)
  {
    if (IsNullOrEmpty(paramString)) {
      return paramDouble;
    }
    try
    {
      double d = Double.parseDouble(paramString);
      return Double.valueOf(d);
    }
    catch (Throwable paramString) {}
    return paramDouble;
  }
  
  public static Integer TryParseIntFromString(String paramString, Integer paramInteger)
  {
    if (IsNullOrEmpty(paramString)) {
      return paramInteger;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      return Integer.valueOf(i);
    }
    catch (Throwable paramString) {}
    return paramInteger;
  }
  
  public static Long TryParseLongFromString(String paramString, Long paramLong)
  {
    if (IsNullOrEmpty(paramString)) {
      return paramLong;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return Long.valueOf(l);
    }
    catch (Throwable paramString) {}
    return paramLong;
  }
  
  public static String TryParseStringFromString(String paramString1, String paramString2)
  {
    if (IsNullOrEmpty(paramString1)) {
      return paramString2;
    }
    return paramString1;
  }
  
  public static UUID TryParseUUIDFromString(String paramString, UUID paramUUID)
  {
    if (IsNullOrEmpty(paramString)) {
      return paramUUID;
    }
    try
    {
      paramString = UUID.fromString(paramString);
      return paramString;
    }
    catch (Throwable paramString) {}
    return paramUUID;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/helpers/StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */