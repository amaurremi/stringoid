package com.gtp.go.weather.sharephoto.photo;

import android.content.Context;
import android.text.TextUtils;
import com.jiubang.goweather.b.d;
import com.jiubang.goweather.b.e;
import com.jiubang.goweather.b.f;
import com.jiubang.goweather.e.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class ac
{
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("phead", paramString2));
    localArrayList.add(new BasicNameValuePair("userId", paramString3));
    localArrayList.add(new BasicNameValuePair("imageId", String.valueOf(paramLong)));
    return a(paramContext, paramString1, localArrayList, 10000, 10000);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("handle", String.valueOf(0)));
    localArrayList.add(new BasicNameValuePair("phead", paramString2));
    localArrayList.add(new BasicNameValuePair("userId", paramString3));
    localArrayList.add(new BasicNameValuePair("pageNum", String.valueOf(paramInt)));
    if (!TextUtils.isEmpty(paramString4)) {
      localArrayList.add(new BasicNameValuePair("cityId", paramString4));
    }
    localArrayList.add(new BasicNameValuePair("shandle", String.valueOf(0)));
    return a(paramContext, paramString1, localArrayList);
  }
  
  public static String a(Context paramContext, String paramString, List paramList)
  {
    return a(paramContext, paramString, paramList, 0, 0);
  }
  
  public static String a(Context paramContext, String paramString, List paramList, int paramInt1, int paramInt2)
  {
    e locale = null;
    Object localObject2 = null;
    Object localObject1 = locale;
    if (paramList != null)
    {
      localObject1 = locale;
      if (!paramList.isEmpty())
      {
        locale = new e(paramString, "POST");
        locale.a(paramList);
        f localf = new f();
        if (paramInt1 != 0) {
          locale.a(paramInt1);
        }
        if (paramInt2 != 0) {
          locale.b(paramInt2);
        }
        localObject1 = d.a();
        paramList = (List)localObject2;
        if (((com.jiubang.goweather.b.c)localObject1).a(localf, paramContext))
        {
          paramContext = ((com.jiubang.goweather.b.c)localObject1).a(paramString, locale, localf);
          paramList = (List)localObject2;
          if (paramContext == null) {}
        }
      }
    }
    try
    {
      paramList = a.a(paramContext, "UTF-8");
      ((com.jiubang.goweather.b.c)localObject1).a();
      localObject1 = paramList;
      return (String)localObject1;
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        paramList = (List)localObject2;
        if (com.gtp.a.a.b.c.a())
        {
          paramContext.printStackTrace();
          paramList = (List)localObject2;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */