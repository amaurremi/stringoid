package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class q
  extends t
{
  private static final String a = a.I.toString();
  private final cj b;
  
  public q(cj paramcj)
  {
    super(a, new String[0]);
    this.b = paramcj;
  }
  
  public d.a a(Map<String, d.a> paramMap)
  {
    paramMap = this.b.a();
    if (paramMap == null) {
      return de.g();
    }
    return de.f(paramMap);
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */