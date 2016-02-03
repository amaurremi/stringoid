package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class di
  extends t
{
  private static final String a = a.W.toString();
  private static final String b = b.bH.toString();
  private static final String c = b.bK.toString();
  private final Context d;
  
  public di(Context paramContext)
  {
    super(a, new String[] { c });
    this.d = paramContext;
  }
  
  public d.a a(Map<String, d.a> paramMap)
  {
    Object localObject = (d.a)paramMap.get(c);
    if (localObject == null) {
      return de.g();
    }
    localObject = de.a((d.a)localObject);
    paramMap = (d.a)paramMap.get(b);
    if (paramMap != null) {}
    for (paramMap = de.a(paramMap);; paramMap = null)
    {
      paramMap = ai.a(this.d, (String)localObject, paramMap);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */