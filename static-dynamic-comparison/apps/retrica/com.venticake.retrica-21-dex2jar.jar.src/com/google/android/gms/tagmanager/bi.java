package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.util.Map;

abstract class bi
  extends bq
{
  public bi(String paramString)
  {
    super(paramString);
  }
  
  protected boolean a(d.a parama1, d.a parama2, Map<String, d.a> paramMap)
  {
    parama1 = de.b(parama1);
    parama2 = de.b(parama2);
    if ((parama1 == de.e()) || (parama2 == de.e())) {
      return false;
    }
    return a(parama1, parama2, paramMap);
  }
  
  protected abstract boolean a(dd paramdd1, dd paramdd2, Map<String, d.a> paramMap);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */