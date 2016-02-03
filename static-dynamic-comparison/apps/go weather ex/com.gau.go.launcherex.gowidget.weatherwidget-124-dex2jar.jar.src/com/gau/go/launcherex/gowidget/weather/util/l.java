package com.gau.go.launcherex.gowidget.weather.util;

import android.util.SparseArray;

public class l
{
  private String a;
  private SparseArray b = new SparseArray();
  
  public static final int b(int paramInt1, int paramInt2)
  {
    int j = -1;
    int i = j;
    if (paramInt1 != -1)
    {
      i = j;
      if (paramInt2 != -1)
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(paramInt1).append("#").append(paramInt2);
        i = localStringBuffer.toString().hashCode();
      }
    }
    return i;
  }
  
  public m a(int paramInt)
  {
    return a(paramInt, 0);
  }
  
  public m a(int paramInt1, int paramInt2)
  {
    paramInt1 = b(paramInt1, paramInt2);
    if (paramInt1 != -1) {
      return (m)this.b.get(paramInt1);
    }
    return null;
  }
  
  public void a(m paramm)
  {
    int i = b(paramm.a, paramm.b);
    if (i != -1) {
      this.b.put(i, paramm);
    }
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public String b(int paramInt)
  {
    String str = null;
    m localm = a(paramInt);
    if (localm != null) {
      str = localm.d;
    }
    return str;
  }
  
  public String c(int paramInt)
  {
    String str = null;
    m localm = a(paramInt);
    if (localm != null) {
      str = localm.c;
    }
    return str;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/util/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */