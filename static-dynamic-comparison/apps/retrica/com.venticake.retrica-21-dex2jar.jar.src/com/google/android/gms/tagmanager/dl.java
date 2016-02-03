package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class dl
  extends t
{
  private static final String a = a.y.toString();
  private final Context b;
  
  public dl(Context paramContext)
  {
    super(a, new String[0]);
    this.b = paramContext;
  }
  
  public d.a a(Map<String, d.a> paramMap)
  {
    try
    {
      paramMap = de.f(Integer.valueOf(this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 0).versionCode));
      return paramMap;
    }
    catch (PackageManager.NameNotFoundException paramMap)
    {
      as.a("Package name " + this.b.getPackageName() + " not found. " + paramMap.getMessage());
    }
    return de.g();
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */