package com.jiubang.playsdk.a;

import com.android.a.a.i;
import com.jiubang.playsdk.e.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class m
  implements p
{
  private String b;
  private int c;
  private int d;
  
  m(d paramd, String paramString, int paramInt1, int paramInt2)
  {
    this.b = paramString;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public com.android.a.t a(com.android.a.m paramm)
  {
    Object localObject2 = paramm.b;
    Object localObject1 = null;
    try
    {
      localObject2 = d.a(this.a).a((byte[])localObject2, true);
      localObject1 = localObject2;
    }
    catch (y localy)
    {
      for (;;)
      {
        localy.printStackTrace();
      }
    }
    return com.android.a.t.a(localObject1, i.a(paramm));
  }
  
  public Map a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("handle", "0");
    localHashMap.put("data", f.a(this.b, this.c, this.d).toString());
    localHashMap.put("shandle", "1");
    return localHashMap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */