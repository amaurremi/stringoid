package com.jiubang.playsdk.a;

import com.android.a.m;
import com.jiubang.playsdk.e.f;
import com.jiubang.playsdk.e.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class i
  implements p
{
  private String b;
  private h c;
  
  i(d paramd, String paramString, h paramh)
  {
    this.b = paramString;
    this.c = paramh;
  }
  
  public com.android.a.t a(m paramm)
  {
    Object localObject2 = paramm.b;
    Object localObject1 = null;
    if (localObject2 != null)
    {
      try
      {
        localObject1 = (Map)d.a(this.a).b((byte[])localObject2, true, this.c.a(), this.c.b(), this.c.c(), this.c.d());
        if ((localObject1 == null) || ((((Map)localObject1).get(this.b) == null) && (this.c.c() == 0)))
        {
          d.b(this.a).a(this.b, true);
          throw new y("该请求无内容,mCacheKey=" + this.b + ",resultObject = " + localObject1);
        }
      }
      catch (y paramm)
      {
        paramm.printStackTrace();
        return com.android.a.t.a(paramm);
      }
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        com.jiubang.playsdk.e.d locald = (com.jiubang.playsdk.e.d)((Map.Entry)localObject2).getValue();
        if ((locald != null) && (locald.d())) {
          d.b(this.a).a((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
        }
      }
      localObject1 = d.b(this.a).c(this.b);
    }
    return com.android.a.t.a(localObject1, com.android.a.a.i.a(paramm));
  }
  
  public Map a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("handle", "0");
    localHashMap.put("data", f.a(this.c));
    localHashMap.put("shandle", "1");
    return localHashMap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */