package com.jiubang.playsdk.a;

import android.text.TextUtils;
import com.android.a.m;
import com.android.a.t;
import com.jiubang.playsdk.e.a;
import com.jiubang.playsdk.e.e;
import com.jiubang.playsdk.e.j;
import com.jiubang.playsdk.g.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class g
  implements p
{
  private long b;
  
  public g(d paramd, long paramLong)
  {
    this.b = paramLong;
  }
  
  public t a(m paramm)
  {
    Object localObject = l.a(paramm.b);
    e locale = new e();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject((String)localObject);
      localObject = localJSONObject.optJSONObject("result");
      localJSONObject = localJSONObject.optJSONObject("appinfo");
      if ((localObject != null) && (localJSONObject != null))
      {
        j localj = new j();
        localj.a(((JSONObject)localObject).toString());
        if (localj.a() == 1)
        {
          localObject = new a();
          ((a)localObject).a(localJSONObject.toString());
          locale.a(((a)localObject).d());
          locale.a((a)localObject);
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    return t.a(locale, com.android.a.a.i.a(paramm));
  }
  
  public Map a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("handle", "0");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", this.b);
      localJSONObject.put("pkgname", "");
      localJSONObject.put("must", 1);
      localJSONObject.put("phead", com.jiubang.playsdk.e.i.a(aa.a().d(), "6.3", aa.a().e(), 0, aa.a().b(aa.a().d())));
      localHashMap.put("data", localJSONObject.toString());
      localHashMap.put("shandle", "1");
      return localHashMap;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */