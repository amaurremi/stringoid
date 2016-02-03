package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class eb
  extends t
{
  private static final String a = a.C.toString();
  private static final String b = b.dc.toString();
  private static final String c = b.cb.toString();
  private final DataLayer d;
  
  public eb(DataLayer paramDataLayer)
  {
    super(a, new String[] { b });
    this.d = paramDataLayer;
  }
  
  public d.a a(Map<String, d.a> paramMap)
  {
    Object localObject = this.d.get(de.a((d.a)paramMap.get(b)));
    if (localObject == null)
    {
      paramMap = (d.a)paramMap.get(c);
      if (paramMap != null) {
        return paramMap;
      }
      return de.g();
    }
    return de.f(localObject);
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/eb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */