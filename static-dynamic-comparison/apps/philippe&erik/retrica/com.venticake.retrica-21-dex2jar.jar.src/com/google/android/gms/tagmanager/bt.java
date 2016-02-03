package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class bt
  extends t
{
  private static final String a = a.O.toString();
  private static final String b = b.da.toString();
  private static final String c = b.cZ.toString();
  
  public bt()
  {
    super(a, new String[0]);
  }
  
  public d.a a(Map<String, d.a> paramMap)
  {
    Object localObject = (d.a)paramMap.get(b);
    paramMap = (d.a)paramMap.get(c);
    double d2;
    double d1;
    if ((localObject != null) && (localObject != de.g()) && (paramMap != null) && (paramMap != de.g()))
    {
      localObject = de.b((d.a)localObject);
      paramMap = de.b(paramMap);
      if ((localObject != de.e()) && (paramMap != de.e()))
      {
        d2 = ((dd)localObject).doubleValue();
        d1 = paramMap.doubleValue();
        if (d2 > d1) {}
      }
    }
    for (;;)
    {
      return de.f(Long.valueOf(Math.round((d1 - d2) * Math.random() + d2)));
      d1 = 2.147483647E9D;
      d2 = 0.0D;
    }
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */