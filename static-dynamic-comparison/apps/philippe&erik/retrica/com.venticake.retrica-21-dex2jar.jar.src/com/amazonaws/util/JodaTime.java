package com.amazonaws.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

public enum JodaTime
{
  private static final boolean expectedBehavior = checkExpectedBehavior();
  
  private static boolean checkAlternateIso8601DateFormat()
  {
    boolean bool2 = false;
    Object localObject3 = new Date();
    Object localObject1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    ((SimpleDateFormat)localObject1).setTimeZone(new SimpleTimeZone(0, "GMT"));
    Object localObject2 = ((SimpleDateFormat)localObject1).format((Date)localObject3);
    localObject3 = DateUtils.alternateIso8601DateFormat.a(((Date)localObject3).getTime());
    boolean bool1 = bool2;
    if (((String)localObject2).equals(localObject3))
    {
      localObject1 = ((SimpleDateFormat)localObject1).parse((String)localObject2);
      localObject2 = DateUtils.alternateIso8601DateFormat.b((String)localObject3);
      bool1 = bool2;
      if (((Date)localObject1).getTime() == ((org.a.a.b)localObject2).a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean checkExpectedBehavior()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (checkTT0031561767())
      {
        bool1 = bool2;
        if (checkFormatIso8601Date())
        {
          bool1 = bool2;
          if (checkFormatRfc822Date())
          {
            bool1 = bool2;
            if (checkAlternateIso8601DateFormat())
            {
              bool1 = bool2;
              if (checkInvalidDate())
              {
                bool1 = bool2;
                if (checkParseCompressedIso8601Date())
                {
                  bool1 = bool2;
                  if (checkParseIso8601Date())
                  {
                    bool1 = bool2;
                    if (checkParseIso8601DateUsingAlternativeFormat())
                    {
                      boolean bool3 = checkParseRfc822Date();
                      bool1 = bool2;
                      if (bool3) {
                        bool1 = true;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static boolean checkFormatIso8601Date()
  {
    boolean bool = false;
    Object localObject = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
    String str = localSimpleDateFormat.format((Date)localObject);
    localObject = DateUtils.iso8601DateFormat.a(((Date)localObject).getTime());
    if (str.equals(localObject)) {
      bool = localSimpleDateFormat.parse(str).equals(DateUtils.doParseISO8601Date((String)localObject));
    }
    return bool;
  }
  
  private static boolean checkFormatRfc822Date()
  {
    boolean bool = false;
    Object localObject = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
    String str = localSimpleDateFormat.format((Date)localObject);
    localObject = DateUtils.rfc822DateFormat.a(((Date)localObject).getTime());
    if (str.equals(localObject)) {
      bool = localSimpleDateFormat.parse(str).equals(new Date(DateUtils.rfc822DateFormat.a((String)localObject)));
    }
    return bool;
  }
  
  private static boolean checkInvalidDate()
  {
    try
    {
      DateUtils.doParseISO8601Date("2014-03-06T14:28:58.000Z.000Z");
      return false;
    }
    catch (RuntimeException localRuntimeException) {}
    return true;
  }
  
  private static boolean checkParseCompressedIso8601Date()
  {
    Object localObject = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
    localObject = localSimpleDateFormat.format((Date)localObject);
    return localSimpleDateFormat.parse((String)localObject).equals(new Date(DateUtils.compressedIso8601DateFormat.a((String)localObject)));
  }
  
  private static boolean checkParseIso8601Date()
  {
    boolean bool = false;
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
    String str = localSimpleDateFormat.format(localDate);
    if (str.equals(DateUtils.iso8601DateFormat.a(localDate.getTime()))) {
      bool = localSimpleDateFormat.parse(str).equals(DateUtils.doParseISO8601Date(str));
    }
    return bool;
  }
  
  private static boolean checkParseIso8601DateUsingAlternativeFormat()
  {
    boolean bool = false;
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
    String str = localSimpleDateFormat.format(localDate);
    if (str.equals(DateUtils.alternateIso8601DateFormat.a(localDate.getTime()))) {
      bool = localSimpleDateFormat.parse(str).equals(DateUtils.parseISO8601Date(str));
    }
    return bool;
  }
  
  private static boolean checkParseRfc822Date()
  {
    Object localObject = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
    localObject = localSimpleDateFormat.format((Date)localObject);
    return localSimpleDateFormat.parse((String)localObject).equals(new Date(DateUtils.rfc822DateFormat.a((String)localObject)));
  }
  
  private static boolean checkTT0031561767()
  {
    Date localDate = new Date(DateUtils.rfc822DateFormat.a("Fri, 16 May 2014 23:56:46 GMT"));
    return "Fri, 16 May 2014 23:56:46 GMT".equals(DateUtils.rfc822DateFormat.a(localDate.getTime()));
  }
  
  public static String getVersion()
  {
    return JodaTime.LazyHolder.version;
  }
  
  public static boolean hasExpectedBehavior()
  {
    return expectedBehavior;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/JodaTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */