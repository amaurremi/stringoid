package com.amazonaws.util;

import java.util.Date;
import java.util.Locale;
import org.a.a.d.a;
import org.a.a.d.b;
import org.a.a.d.u;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public class DateUtils
{
  private static final org.a.a.i GMT = new org.a.a.e.i("GMT", "GMT", 0, 0);
  protected static final b alternateIso8601DateFormat;
  protected static final b compressedIso8601DateFormat = a.a("yyyyMMdd'T'HHmmss'Z'").a(GMT);
  protected static final b iso8601DateFormat = u.d().a(GMT);
  protected static final b rfc822DateFormat;
  
  static
  {
    alternateIso8601DateFormat = a.a("yyyy-MM-dd'T'HH:mm:ss'Z'").a(GMT);
    rfc822DateFormat = a.a("EEE, dd MMM yyyy HH:mm:ss 'GMT'").a(Locale.US).a(GMT);
  }
  
  static Date doParseISO8601Date(String paramString)
  {
    Object localObject = tempDateStringForJodaTime(paramString);
    try
    {
      if (((String)localObject).equals(paramString)) {
        return new Date(iso8601DateFormat.a(paramString));
      }
      l = iso8601DateFormat.a((String)localObject) + 31536000000L;
      if (l < 0L)
      {
        localObject = new Date(iso8601DateFormat.a(paramString));
        return (Date)localObject;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      long l;
      try
      {
        paramString = new Date(alternateIso8601DateFormat.a(paramString));
        return paramString;
      }
      catch (Exception paramString)
      {
        throw localIllegalArgumentException;
      }
      Date localDate = new Date(l);
      return localDate;
    }
  }
  
  public static String formatRFC822Date(Date paramDate)
  {
    try
    {
      paramDate = rfc822DateFormat.a(paramDate.getTime());
      return paramDate;
    }
    catch (RuntimeException paramDate)
    {
      throw handleException(paramDate);
    }
  }
  
  private static <E extends RuntimeException> E handleException(E paramE)
  {
    if (JodaTime.hasExpectedBehavior()) {
      return paramE;
    }
    throw new IllegalStateException("Joda-time 2.2 or later version is required, but found version: " + JodaTime.getVersion(), paramE);
  }
  
  public static Date parseCompressedISO8601Date(String paramString)
  {
    try
    {
      paramString = new Date(compressedIso8601DateFormat.a(paramString));
      return paramString;
    }
    catch (RuntimeException paramString)
    {
      throw handleException(paramString);
    }
  }
  
  public static Date parseISO8601Date(String paramString)
  {
    try
    {
      paramString = doParseISO8601Date(paramString);
      return paramString;
    }
    catch (RuntimeException paramString)
    {
      throw handleException(paramString);
    }
  }
  
  public static Date parseRFC822Date(String paramString)
  {
    try
    {
      paramString = new Date(rfc822DateFormat.a(paramString));
      return paramString;
    }
    catch (RuntimeException paramString)
    {
      throw handleException(paramString);
    }
  }
  
  private static String tempDateStringForJodaTime(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("292278994-")) {
      str = "292278993-" + paramString.substring("292278994-".length());
    }
    return str;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/DateUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */