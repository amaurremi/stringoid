package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Locale;
import java.util.Map;

class ao
  extends t
{
  private static final String a = a.L.toString();
  
  public ao()
  {
    super(a, new String[0]);
  }
  
  public d.a a(Map<String, d.a> paramMap)
  {
    paramMap = Locale.getDefault();
    if (paramMap == null) {
      return de.g();
    }
    paramMap = paramMap.getLanguage();
    if (paramMap == null) {
      return de.g();
    }
    return de.f(paramMap.toLowerCase());
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */