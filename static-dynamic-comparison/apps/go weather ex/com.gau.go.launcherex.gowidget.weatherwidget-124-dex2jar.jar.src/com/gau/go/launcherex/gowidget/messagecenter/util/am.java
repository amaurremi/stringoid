package com.gau.go.launcherex.gowidget.messagecenter.util;

import android.text.format.Time;
import com.gtp.a.a.b.c;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public abstract class am
{
  public static long a(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z", Locale.US);
    try
    {
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT00:00"));
      l = localSimpleDateFormat.parse(paramString).getTime();
      return l;
    }
    catch (ParseException paramString)
    {
      do
      {
        long l = -1L;
      } while (!c.a());
      paramString.printStackTrace();
    }
    return -1L;
  }
  
  public static String a(long paramLong)
  {
    Time localTime = new Time();
    String str = localTime.timezone;
    localTime.set(paramLong);
    localTime.switchTimezone(str);
    return localTime.format("%Y-%m-%d %H:%M");
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool = true;
    paramString2 = new SimpleDateFormat(paramString2, Locale.US);
    try
    {
      paramString2.parse(paramString1);
      return bool;
    }
    catch (ParseException paramString1)
    {
      do
      {
        bool = false;
      } while (!c.a());
      paramString1.printStackTrace();
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */