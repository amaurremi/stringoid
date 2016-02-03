package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

abstract class bq
  extends t
{
  private static final String a = b.bi.toString();
  private static final String b = b.bj.toString();
  
  public bq(String paramString)
  {
    super(paramString, new String[] { a, b });
  }
  
  public d.a a(Map<String, d.a> paramMap)
  {
    Object localObject = paramMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((d.a)((Iterator)localObject).next() == de.g()) {
        return de.f(Boolean.valueOf(false));
      }
    }
    localObject = (d.a)paramMap.get(a);
    d.a locala = (d.a)paramMap.get(b);
    if ((localObject == null) || (locala == null)) {}
    for (boolean bool = false;; bool = a((d.a)localObject, locala, paramMap)) {
      return de.f(Boolean.valueOf(bool));
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected abstract boolean a(d.a parama1, d.a parama2, Map<String, d.a> paramMap);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */