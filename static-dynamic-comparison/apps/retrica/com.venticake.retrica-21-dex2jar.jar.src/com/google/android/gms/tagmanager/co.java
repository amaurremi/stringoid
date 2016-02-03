package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class co
  extends t
{
  private static final String a = a.S.toString();
  
  public co()
  {
    super(a, new String[0]);
  }
  
  public d.a a(Map<String, d.a> paramMap)
  {
    return de.f(Integer.valueOf(Build.VERSION.SDK_INT));
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */