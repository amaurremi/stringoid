package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class ah
  extends t
{
  private static final String a = a.ab.toString();
  private static final String b = b.bH.toString();
  private final Context c;
  
  public ah(Context paramContext)
  {
    super(a, new String[0]);
    this.c = paramContext;
  }
  
  public d.a a(Map<String, d.a> paramMap)
  {
    if ((d.a)paramMap.get(b) != null) {}
    for (paramMap = de.a((d.a)paramMap.get(b));; paramMap = null)
    {
      paramMap = ai.b(this.c, paramMap);
      if (paramMap == null) {
        break;
      }
      return de.f(paramMap);
    }
    return de.g();
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */