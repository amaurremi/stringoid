package com.jiubang.playsdk.e;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.gau.go.gostaticsdk.d;
import com.jiubang.playsdk.g.a;
import com.jiubang.playsdk.g.e;
import org.json.JSONException;
import org.json.JSONObject;

public class i
{
  public static JSONObject a(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    int i = 0;
    JSONObject localJSONObject = new JSONObject();
    String str = e.b(paramContext);
    try
    {
      localJSONObject.put("launcherid", str);
      localJSONObject.put("imsi", e.c(paramContext));
      localJSONObject.put("imei", e.b(paramContext));
      if (a.d(paramContext, "com.android.vending")) {
        i = 1;
      }
      localJSONObject.put("hasmarket", i);
      localJSONObject.put("lang", e.d(paramContext));
      localJSONObject.put("local", e.e(paramContext));
      localJSONObject.put("channel", e.f(paramContext));
      localJSONObject.put("sys", Build.MODEL);
      localJSONObject.put("sdk", Build.VERSION.SDK_INT);
      localJSONObject.put("dpi", e.g(paramContext));
      localJSONObject.put("pversion", paramString1);
      localJSONObject.put("netlog", paramInt2);
      localJSONObject.put("net", e.k(paramContext));
      localJSONObject.put("clientid", paramInt1);
      localJSONObject.put("androidid", e.h(paramContext));
      localJSONObject.put("cversion", e.i(paramContext));
      localJSONObject.put("sbuy", 0);
      localJSONObject.put("official", 0);
      localJSONObject.put("curthemes", a.a(paramContext));
      localJSONObject.put("goid", d.b(paramContext));
      localJSONObject.put("gadid", paramString2);
      return localJSONObject;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
    return localJSONObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/e/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */