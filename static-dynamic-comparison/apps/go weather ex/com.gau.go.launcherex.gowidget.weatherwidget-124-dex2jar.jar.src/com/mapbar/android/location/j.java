package com.mapbar.android.location;

import android.content.Context;
import android.location.Address;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class j
{
  Context a;
  Locale b;
  
  public j() {}
  
  public j(Context paramContext, Locale paramLocale)
  {
    this.a = paramContext;
    this.b = paramLocale;
    if (!g.b)
    {
      paramContext = this.a.getPackageManager();
      g.e = this.a.getPackageName();
      g.d = g.a(paramContext, g.e);
      g.c = b.d.a(paramContext, g.e);
      g.b = g.a(g.d);
    }
  }
  
  String a()
  {
    char[] arrayOfChar = " lO>_g7L'\027-t^=\026fuZ>\007)j\025-\n%7H+\004:{SaZ/z\006~Wn".toCharArray();
    int k = arrayOfChar.length;
    int j = 0;
    if (j < k)
    {
      int i;
      switch (j % 5)
      {
      default: 
        i = 101;
      }
      for (;;)
      {
        arrayOfChar[j] = ((char)(i ^ arrayOfChar[j]));
        j += 1;
        break;
        i = 72;
        continue;
        i = 24;
        continue;
        i = 59;
        continue;
        i = 78;
      }
    }
    return new String(arrayOfChar);
  }
  
  public final List<Address> a(String paramString, int paramInt)
    throws UnsupportedEncodingException
  {
    ArrayList localArrayList = new ArrayList();
    if (!g.b) {
      return localArrayList;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a()).append("ct=").append(URLEncoder.encode("全国", "utf-8")).append("&ch=UTF-8&fd=5&rn=").append(paramInt).append("&pn=1&tp=1&q=").append(URLEncoder.encode(paramString, "utf-8"));
    paramString = new u(this.a, 3, 0);
    paramString.a(localStringBuilder.toString());
    paramString = (String)paramString.a();
    if (paramString != null)
    {
      paramString = h.b(this.b, paramString);
      if (paramString != null) {
        localArrayList.addAll(paramString);
      }
    }
    return localArrayList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/location/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */