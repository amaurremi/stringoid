package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class dk
  extends t
{
  private static final String a = a.x.toString();
  private final Context b;
  
  public dk(Context paramContext)
  {
    super(a, new String[0]);
    this.b = paramContext;
  }
  
  public d.a a(Map<String, d.a> paramMap)
  {
    try
    {
      paramMap = this.b.getPackageManager();
      paramMap = de.f(paramMap.getApplicationLabel(paramMap.getApplicationInfo(this.b.getPackageName(), 0)).toString());
      return paramMap;
    }
    catch (PackageManager.NameNotFoundException paramMap)
    {
      as.a("App name is not found.", paramMap);
    }
    return de.g();
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */