package com.google.android.gms.analytics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class ab
{
  private final Map<String, Integer> vt = new HashMap();
  private final Map<String, String> vu = new HashMap();
  private final boolean vv;
  private final String vw;
  
  ab(String paramString, boolean paramBoolean)
  {
    this.vv = paramBoolean;
    this.vw = paramString;
  }
  
  void c(String paramString, int paramInt)
  {
    if (!this.vv) {
      return;
    }
    Integer localInteger2 = (Integer)this.vt.get(paramString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    this.vt.put(paramString, Integer.valueOf(localInteger1.intValue() + paramInt));
  }
  
  String cU()
  {
    if (!this.vv) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.vw);
    Iterator localIterator = this.vt.keySet().iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localStringBuilder.append("&").append(str).append("=").append(this.vt.get(str));
    }
    localIterator = this.vu.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localStringBuilder.append("&").append(str).append("=").append((String)this.vu.get(str));
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/analytics/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */