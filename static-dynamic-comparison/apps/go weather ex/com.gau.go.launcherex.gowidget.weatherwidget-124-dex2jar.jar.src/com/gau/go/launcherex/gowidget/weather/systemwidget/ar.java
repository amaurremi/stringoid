package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.content.res.Resources;
import java.util.HashMap;

public class ar
{
  public static String a = "";
  public static Resources b = null;
  public static String[] c = new String[10];
  public static String[] d = new String[10];
  public static String[] e = new String[10];
  public static String[] f = new String[10];
  public static String[] g = new String[10];
  private HashMap h = new HashMap();
  
  public static String[] a()
  {
    return d;
  }
  
  public static String[] b()
  {
    return c;
  }
  
  public static String[] c()
  {
    return e;
  }
  
  public static String[] d()
  {
    return f;
  }
  
  public static String[] e()
  {
    return g;
  }
  
  public String a(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(""))) {
      try
      {
        paramString = (String)this.h.get(paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        return "";
      }
    }
    return "";
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.h.put(paramString1, paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */