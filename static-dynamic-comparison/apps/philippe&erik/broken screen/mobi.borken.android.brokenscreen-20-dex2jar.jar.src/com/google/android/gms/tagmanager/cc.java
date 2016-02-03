package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

abstract class cc
  extends aj
{
  private static final String afv = b.bi.toString();
  private static final String ags = b.bj.toString();
  
  public cc(String paramString)
  {
    super(paramString, new String[] { afv, ags });
  }
  
  protected abstract boolean a(d.a parama1, d.a parama2, Map<String, d.a> paramMap);
  
  public boolean lc()
  {
    return true;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    Object localObject = paramMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((d.a)((Iterator)localObject).next() == dh.mY()) {
        return dh.r(Boolean.valueOf(false));
      }
    }
    localObject = (d.a)paramMap.get(afv);
    d.a locala = (d.a)paramMap.get(ags);
    if ((localObject == null) || (locala == null)) {}
    for (boolean bool = false;; bool = a((d.a)localObject, locala, paramMap)) {
      return dh.r(Boolean.valueOf(bool));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */