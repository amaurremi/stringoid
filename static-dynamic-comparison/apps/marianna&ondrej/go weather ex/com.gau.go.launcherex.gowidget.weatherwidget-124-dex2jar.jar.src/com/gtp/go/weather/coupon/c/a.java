package com.gtp.go.weather.coupon.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.ClipboardManager;
import android.text.TextUtils;
import com.gtp.go.weather.sharephoto.d.h;
import com.jiubang.goweather.b.d;
import com.jiubang.goweather.b.e;
import com.jiubang.goweather.b.f;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class a
{
  public static final String a = com.gtp.a.a.c.c.a() + "/download/coupons";
  
  public static String a(Context paramContext, String paramString1, long paramLong, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("couponId", String.valueOf(paramLong)));
    localArrayList.add(new BasicNameValuePair("email", paramString2));
    return b(paramContext, paramString1, localArrayList, 0, 0);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("phead", paramString2));
    localArrayList.add(new BasicNameValuePair("pageNum", paramInt + ""));
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
      paramList = com.jiubang.goweather.e.a.a(paramContext, "UTF-8");
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
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = h.a(paramString);
    return a + File.separator + paramString + ".png";
  }
  
  public static void a(Context paramContext, String paramString)
  {
    ((ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramString.trim());
  }
  
  @SuppressLint({"SimpleDateFormat"})
  public static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    for (;;)
    {
      return false;
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      try
      {
        long l1 = localSimpleDateFormat.parse(paramString1).getTime();
        long l2 = localSimpleDateFormat.parse(paramString2).getTime();
        if (l1 < l2) {
          return true;
        }
      }
      catch (ParseException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return false;
  }
  
  public static String b(Context paramContext, String paramString, List paramList, int paramInt1, int paramInt2)
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
        locale.a(true);
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
      paramList = com.jiubang.goweather.e.a.a(paramContext, "UTF-8");
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
  
  public static boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.matches("^[^(@|\\.|\\+|\\s)][\\S^@]*[^(\\.|\\+|\\s|@)]{1}@[^(\\.|\\s|@)]{1}[\\S^@]*$"));
  }
  
  @SuppressLint({"SimpleDateFormat"})
  public static boolean c(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    for (;;)
    {
      return false;
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      try
      {
        long l1 = localSimpleDateFormat.parse(paramString).getTime();
        long l2 = System.currentTimeMillis();
        if (l1 < l2) {
          return true;
        }
      }
      catch (ParseException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */