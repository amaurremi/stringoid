package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class dx
  extends t
{
  private static final String a = a.D.toString();
  private final String b;
  
  public dx(String paramString)
  {
    super(a, new String[0]);
    this.b = paramString;
  }
  
  public d.a a(Map<String, d.a> paramMap)
  {
    if (this.b == null) {
      return de.g();
    }
    return de.f(this.b);
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/dx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */