package com.mocoplex.adlib;

import java.util.ArrayList;
import org.json.JSONArray;

public final class e
{
  private static e c = null;
  ArrayList<String> a = new ArrayList();
  int b = 0;
  
  public static e a()
  {
    try
    {
      if (c == null) {
        c = new e();
      }
      e locale = c;
      return locale;
    }
    finally {}
  }
  
  public static void b()
  {
    c = null;
  }
  
  protected final void c()
  {
    Object localObject = AdlibConfig.getInstance().c("smart");
    try
    {
      localObject = new JSONArray((String)localObject);
      this.a.clear();
      int i = 0;
      for (;;)
      {
        if (i >= ((JSONArray)localObject).length()) {
          return;
        }
        String str = (String)((JSONArray)localObject).get(i);
        this.a.add(str);
        i += 1;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public final int d()
  {
    return this.a.size();
  }
  
  public final String e()
  {
    if (this.a.size() <= 0) {
      return null;
    }
    int i = this.b;
    if (this.a.size() <= i) {
      i = 0;
    }
    for (;;)
    {
      String str;
      if (this.a.size() > i)
      {
        str = (String)this.a.get(i);
        i += 1;
        if (this.a.size() > i) {
          this.b = i;
        }
      }
      for (;;)
      {
        return str;
        this.b = 0;
        continue;
        this.b = 0;
        str = null;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */