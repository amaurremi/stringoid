package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class av
  extends t
{
  private static final String a = a.ad.toString();
  private final Context b;
  
  public av(Context paramContext)
  {
    super(a, new String[0]);
    this.b = paramContext;
  }
  
  public d.a a(Map<String, d.a> paramMap)
  {
    paramMap = a(this.b);
    if (paramMap == null) {
      return de.g();
    }
    return de.f(paramMap);
  }
  
  protected String a(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */