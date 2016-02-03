package com.jiubang.goweather.b;

import a.a.a.a.a.h;
import android.content.Context;
import android.os.Build.VERSION;
import com.gau.go.launcherex.gowidget.language.d;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class e
{
  private final String a;
  private final ArrayList b;
  private byte[] c;
  private List d;
  private h e;
  private String f;
  private final int g;
  private boolean h;
  private int i = 25000;
  private int j = 25000;
  private final HashMap k;
  private int l = 1;
  
  public e(String paramString)
  {
    this.a = paramString;
    this.f = "GET";
    this.b = new ArrayList();
    this.g = -1;
    this.h = false;
    this.k = new HashMap();
  }
  
  public e(String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramString;
    this.f = "GET";
    this.b = new ArrayList();
    this.g = -1;
    this.h = false;
    if (paramInt1 > 0) {
      this.i = paramInt1;
    }
    if (paramInt2 > 0) {
      this.j = paramInt2;
    }
    this.k = new HashMap();
  }
  
  public e(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.f = paramString2;
    this.b = new ArrayList();
    this.g = -1;
    this.h = false;
    this.k = new HashMap();
  }
  
  public a a(String paramString1, String paramString2)
  {
    paramString1 = new a(paramString1, paramString2);
    this.b.add(paramString1);
    return paramString1;
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(h paramh)
  {
    this.e = paramh;
  }
  
  public void a(Context paramContext)
  {
    a("lang", d.a(paramContext).d());
    a("sys", Build.VERSION.RELEASE);
    a("ps", "2.0");
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void a(List paramList)
  {
    this.d = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
  }
  
  public boolean a()
  {
    return this.h;
  }
  
  public int b()
  {
    return this.i;
  }
  
  public void b(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.k.put(paramString1, paramString2);
  }
  
  public int c()
  {
    return this.j;
  }
  
  public void c(int paramInt)
  {
    this.l = paramInt;
    this.b.add(new a("refleshTime", String.valueOf(this.l)));
  }
  
  public HashMap d()
  {
    return this.k;
  }
  
  public byte[] e()
  {
    return this.c;
  }
  
  public List f()
  {
    return this.d;
  }
  
  public h g()
  {
    return this.e;
  }
  
  public String h()
  {
    return this.f;
  }
  
  public String i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    int n = this.b.size();
    if (n > 0) {
      localStringBuilder.append("?");
    }
    int m = 0;
    while (m < n)
    {
      a locala = (a)this.b.get(m);
      localStringBuilder.append(URLEncoder.encode(locala.a(), "utf-8"));
      localStringBuilder.append("=");
      localStringBuilder.append(URLEncoder.encode(locala.b(), "utf-8"));
      if (m + 1 < n) {
        localStringBuilder.append("&");
      }
      m += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */