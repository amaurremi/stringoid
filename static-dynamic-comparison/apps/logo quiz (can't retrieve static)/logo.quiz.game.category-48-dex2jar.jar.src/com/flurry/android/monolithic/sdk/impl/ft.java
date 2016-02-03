package com.flurry.android.monolithic.sdk.impl;

import android.text.TextUtils;
import com.flurry.android.impl.appcloud.AppCloudModule;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class ft
  extends fm
{
  private static ft g = null;
  
  public ft() {}
  
  public ft(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  public static void a(ft paramft)
  {
    g = paramft;
  }
  
  public static void a(String paramString1, String paramString2, hz paramhz)
    throws Exception
  {
    ArrayList localArrayList = new ArrayList();
    if ((TextUtils.equals(paramString1, fy.f())) && (TextUtils.equals(paramString2, fy.g())) && (!TextUtils.isEmpty(fy.d())))
    {
      localArrayList.add(new BasicNameValuePair("userid", fy.d()));
      localArrayList.add(new BasicNameValuePair("password", paramString2));
    }
    for (;;)
    {
      a(localArrayList, paramString2, paramhz);
      return;
      localArrayList.add(new BasicNameValuePair("email", paramString1));
      localArrayList.add(new BasicNameValuePair("password", paramString2));
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, hz paramhz)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      paramhz.a(new hy(400, "User name is not set."));
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      paramhz.a(new hy(400, "Password is not set."));
      return;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      paramhz.a(new hy(400, "Email is not set."));
      return;
    }
    if (!paramBoolean) {
      try
      {
        b(paramString1, paramString2, paramhz);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    b(paramString1, paramString2, new fv(paramhz, paramString1, paramString3, paramString2));
  }
  
  static void a(List<NameValuePair> paramList, String paramString, hz paramhz)
  {
    if (!AppCloudModule.getInstance().e())
    {
      paramhz.a(new hy(400, "Bad response"));
      return;
    }
    try
    {
      gr.c(false, "v1/user/login", paramList, new fu(paramString, paramhz));
      return;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  static void b(String paramString1, String paramString2, hz paramhz)
    throws Exception
  {
    ArrayList localArrayList = new ArrayList();
    if ((TextUtils.equals(paramString1, fy.e())) && (TextUtils.equals(paramString2, fy.g())) && (!TextUtils.isEmpty(fy.d())))
    {
      localArrayList.add(new BasicNameValuePair("userid", fy.d()));
      localArrayList.add(new BasicNameValuePair("password", paramString2));
    }
    for (;;)
    {
      a(localArrayList, paramString2, paramhz);
      return;
      localArrayList.add(new BasicNameValuePair("username", paramString1));
      localArrayList.add(new BasicNameValuePair("password", paramString2));
    }
  }
  
  public static ft e()
  {
    return g;
  }
  
  public static ft f()
  {
    if (e() == null)
    {
      ft localft = fy.c();
      if (localft != null)
      {
        a(localft);
        gr.a = fy.h();
        e().c(e().a);
      }
    }
    return e();
  }
  
  public void a(hw paramhw)
    throws Exception
  {
    super.a(new fx(this, paramhw));
  }
  
  public void a(String paramString, float paramFloat, hx paramhx)
  {
    if (TextUtils.isEmpty(this.a))
    {
      paramhx.a(new hy(400, "Please assign an object id."));
      return;
    }
    super.a(paramString, String.valueOf(paramFloat), paramhx);
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public void e(String paramString)
  {
    this.e = paramString;
  }
  
  public void f(String paramString)
  {
    this.f = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */