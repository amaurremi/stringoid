package com.jiubang.playsdk.a;

import com.jiubang.playsdk.e.c;
import com.jiubang.playsdk.e.d;
import com.jiubang.playsdk.e.f;
import com.jiubang.playsdk.e.g;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b
  implements s
{
  private Map a = new HashMap();
  private r b;
  
  b(r paramr)
  {
    this.b = paramr;
  }
  
  public x a(String paramString, x paramx)
  {
    int m = 0;
    d locald = b(paramString);
    int k;
    int j;
    int i;
    if (locald != null)
    {
      paramString = f.a(paramString);
      if (paramString == null) {
        break label151;
      }
      k = paramString.b();
      j = paramString.c();
      i = paramString.a();
    }
    for (;;)
    {
      if (paramx.b() == 1)
      {
        paramx.b(locald.a());
        paramx.a(i);
      }
      paramx.b(paramx.b() + 1);
      if (locald.g()) {
        while (m < locald.a.size())
        {
          paramString = (c)locald.a.get(m);
          if (paramString != null) {
            a(f.b(paramString.a(), i, k, j), paramx);
          }
          m += 1;
        }
      }
      paramx.a(locald);
      return paramx;
      label151:
      i = 0;
      j = 0;
      k = 0;
    }
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(String paramString, d paramd)
  {
    this.a.put(paramString, paramd);
    this.b.a(paramString, paramd);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.a.remove(paramString);
    if (paramBoolean) {
      this.b.b(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    return this.a.containsKey(paramString);
  }
  
  public d b(String paramString)
  {
    d locald2 = (d)this.a.get(paramString);
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = this.b.a(paramString);
      this.a.put(paramString, locald1);
    }
    return locald1;
  }
  
  public x c(String paramString)
  {
    return a(paramString, new x());
  }
  
  public boolean d(String paramString)
  {
    return this.b.c(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */