package com.android.a.a;

import com.android.a.c;
import com.android.a.m;
import java.util.Date;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class i
{
  public static long a(String paramString)
  {
    try
    {
      long l = DateUtils.parseDate(paramString).getTime();
      return l;
    }
    catch (DateParseException paramString) {}
    return 0L;
  }
  
  public static c a(m paramm)
  {
    long l5 = System.currentTimeMillis();
    Map localMap = paramm.c;
    localMap.put("Cache-Control", "max-age=345600000");
    long l2 = 0L;
    long l4 = 0L;
    long l1 = 0L;
    int i = 0;
    Object localObject1 = (String)localMap.get("Date");
    if (localObject1 != null) {
      l2 = a((String)localObject1);
    }
    localObject1 = (String)localMap.get("Cache-Control");
    long l3 = l1;
    if (localObject1 != null)
    {
      int j = 1;
      localObject1 = ((String)localObject1).split(",");
      i = 0;
      if (i >= localObject1.length)
      {
        i = j;
        l3 = l1;
      }
    }
    else
    {
      localObject1 = (String)localMap.get("Expires");
      l1 = l4;
      if (localObject1 != null) {
        l1 = a((String)localObject1);
      }
      localObject1 = (String)localMap.get("ETag");
      if (i == 0) {
        break label308;
      }
      l1 = l3 * 1000L + l5;
    }
    for (;;)
    {
      label162:
      Object localObject2 = new c();
      ((c)localObject2).a = paramm.b;
      ((c)localObject2).b = ((String)localObject1);
      ((c)localObject2).e = l1;
      ((c)localObject2).d = ((c)localObject2).e;
      ((c)localObject2).c = l2;
      ((c)localObject2).f = localMap;
      return (c)localObject2;
      localObject2 = localObject1[i].trim();
      if ((((String)localObject2).equals("no-cache")) || (((String)localObject2).equals("no-store"))) {
        return null;
      }
      if (((String)localObject2).startsWith("max-age=")) {}
      for (;;)
      {
        try
        {
          l3 = Long.parseLong(((String)localObject2).substring(8));
          l1 = l3;
        }
        catch (Exception localException)
        {
          label308:
          continue;
          l1 = 0L;
        }
        i += 1;
        break;
        if ((((String)localObject2).equals("must-revalidate")) || (((String)localObject2).equals("proxy-revalidate")))
        {
          l1 = 0L;
          continue;
          if ((l2 > 0L) && (l1 >= l2))
          {
            l1 = l1 - l2 + l5;
            break label162;
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */