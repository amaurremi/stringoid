package com.gtp.go.weather.sharephoto.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.jiubang.goweather.b.e;
import com.jiubang.goweather.e.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  public static String a(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    e locale = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = paramString2;
    if (paramInt1 == 1) {}
    try
    {
      localObject1 = com.gau.go.launcherex.gowidget.d.f.a(paramString2, "UTF-8", "ISO-8859-1");
      paramString2 = locale;
      if (localObject1 != null)
      {
        locale = new e(paramString1, "POST");
        paramString2 = new ArrayList();
        paramString2.add(new BasicNameValuePair("handle", paramInt1 + ""));
        paramString2.add(new BasicNameValuePair("phead", (String)localObject1));
        paramString2.add(new BasicNameValuePair("userInfo", paramString3));
        paramString2.add(new BasicNameValuePair("shandle", paramInt2 + ""));
        locale.a(paramString2);
        localObject1 = new com.jiubang.goweather.b.f();
        paramString3 = com.jiubang.goweather.b.d.a();
        paramString2 = (String)localObject2;
        if (paramString3.a((com.jiubang.goweather.b.f)localObject1, paramContext))
        {
          paramString1 = paramString3.a(paramString1, locale, (com.jiubang.goweather.b.f)localObject1);
          paramString2 = (String)localObject2;
          if (paramString1 != null) {
            paramContext = (Context)localObject3;
          }
        }
      }
      try
      {
        paramString1 = a.a(paramString1, "ISO-8859-1");
        paramString2 = paramString1;
        if (paramInt1 == 1)
        {
          paramContext = paramString1;
          paramString2 = com.gau.go.launcherex.gowidget.d.f.b(paramString1, "ISO-8859-1", "UTF-8");
        }
      }
      catch (IOException paramString1)
      {
        for (;;)
        {
          paramString2 = paramContext;
          if (com.gtp.a.a.b.c.a())
          {
            paramString1.printStackTrace();
            paramString2 = paramContext;
          }
        }
      }
      paramString3.a();
      return paramString2;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        if (com.gtp.a.a.b.c.a()) {
          paramString2.printStackTrace();
        }
        localObject1 = null;
      }
    }
  }
  
  public static JSONObject a(Context paramContext)
  {
    return a(paramContext, y.m(paramContext));
  }
  
  public static JSONObject a(Context paramContext, String paramString)
  {
    localJSONObject = new JSONObject();
    try
    {
      a(localJSONObject, "pversion", 3);
      a(localJSONObject, "aid", y.v(paramContext));
      a(localJSONObject, "goid", com.gau.go.gostaticsdk.d.b(paramContext));
      a(localJSONObject, "uid", y.d(paramContext));
      a(localJSONObject, "cid", 1);
      a(localJSONObject, "cversionname", y.c(paramContext));
      try
      {
        i = Integer.valueOf(y.f(paramContext)).intValue();
        a(localJSONObject, "channel", i);
        a(localJSONObject, "local", paramString);
        a(localJSONObject, "lang", y.l(paramContext));
        a(localJSONObject, "sdk", Build.VERSION.SDK_INT);
        a(localJSONObject, "imsi", y.r(paramContext));
        a(localJSONObject, "dpi", y.y(paramContext));
        a(localJSONObject, "cversion", 1);
        if (y.h(paramContext))
        {
          i = 1;
          a(localJSONObject, "official", i);
          if (!y.s(paramContext)) {
            break label184;
          }
          i = 1;
          a(localJSONObject, "hasmarket", i);
          return localJSONObject;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          int i = 0;
          continue;
          i = 0;
          continue;
          label184:
          i = 0;
        }
      }
      return localJSONObject;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static final void a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramString))) {
      paramJSONObject.put(paramString, paramInt);
    }
  }
  
  public static final void a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      paramJSONObject.put(paramString1, paramString2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */