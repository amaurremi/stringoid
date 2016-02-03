package com.jiubang.b.c;

import java.text.SimpleDateFormat;
import java.util.Date;

public class a
{
  private static SimpleDateFormat a = new SimpleDateFormat();
  
  public static String a(long paramLong, String paramString)
  {
    synchronized (a)
    {
      a.applyPattern(paramString);
      paramString = a.format(new Date(paramLong));
      return paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/b/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */