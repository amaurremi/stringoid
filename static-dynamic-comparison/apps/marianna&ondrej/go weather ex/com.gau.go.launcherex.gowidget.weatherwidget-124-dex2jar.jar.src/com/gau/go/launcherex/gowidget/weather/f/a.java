package com.gau.go.launcherex.gowidget.weather.f;

import android.content.res.Resources;
import java.util.HashMap;

public class a
{
  public String a = "";
  public Resources b = null;
  public String[] c = new String[10];
  public String[] d = new String[10];
  public String[] e = new String[10];
  public String[] f = new String[8];
  private HashMap g = new HashMap();
  
  public String a(String paramString)
  {
    return (String)this.g.get(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.g.put(paramString1, paramString2);
  }
  
  public void a(HashMap paramHashMap)
  {
    this.g = paramHashMap;
  }
  
  public String[] a()
  {
    return this.f;
  }
  
  public String[] b()
  {
    return this.c;
  }
  
  public String[] c()
  {
    return this.d;
  }
  
  public String[] d()
  {
    return this.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */