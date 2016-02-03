package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class al
  extends t
{
  private static final String a = com.google.android.gms.internal.a.u.toString();
  private final a b;
  
  public al(Context paramContext)
  {
    this(a.a(paramContext));
  }
  
  al(a parama)
  {
    super(a, new String[0]);
    this.b = parama;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */