package com.go.weatherex.city;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class c
{
  private static c a;
  private String b;
  private ArrayList c = new ArrayList();
  
  public static c a()
  {
    if (a == null) {}
    try
    {
      a = new c();
      return a;
    }
    finally {}
  }
  
  public void a(d paramd)
  {
    if (paramd != null) {
      this.c.add(paramd);
    }
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(d paramd)
  {
    if (paramd != null) {
      this.c.remove(paramd);
    }
  }
  
  public void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.b)))
    {
      String str = this.b;
      this.b = paramString;
      paramString = ((ArrayList)this.c.clone()).iterator();
      while (paramString.hasNext()) {
        ((d)paramString.next()).a(str, this.b);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/city/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */