package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

abstract class cc
  extends aj
{
  private static final String XQ = b.bi.toString();
  private static final String YN = b.bj.toString();
  
  public cc(String paramString)
  {
    super(paramString, new String[] { XQ, YN });
  }
  
  protected abstract boolean a(d.a parama1, d.a parama2, Map<String, d.a> paramMap);
  
  public boolean jX()
  {
    return true;
  }
  
  public d.a x(Map<String, d.a> paramMap)
  {
    Object localObject = paramMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((d.a)((Iterator)localObject).next() == dh.lT()) {
        return dh.r(Boolean.valueOf(false));
      }
    }
    localObject = (d.a)paramMap.get(XQ);
    d.a locala = (d.a)paramMap.get(YN);
    if ((localObject == null) || (locala == null)) {}
    for (boolean bool = false;; bool = a((d.a)localObject, locala, paramMap)) {
      return dh.r(Boolean.valueOf(bool));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */