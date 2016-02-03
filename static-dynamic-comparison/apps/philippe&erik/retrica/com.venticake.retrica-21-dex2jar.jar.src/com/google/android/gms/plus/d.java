package com.google.android.gms.plus;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class d
  implements f
{
  private Context a;
  
  private d(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public Drawable a(int paramInt)
  {
    for (;;)
    {
      try
      {
        Resources localResources = this.a.createPackageContext("com.google.android.gms", 4).getResources();
        switch (paramInt)
        {
        case 2: 
          return localResources.getDrawable(localResources.getIdentifier(str1, "drawable", "com.google.android.gms"));
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        String str1;
        return null;
      }
      str1 = "ic_plusone_tall";
      continue;
      String str2 = "ic_plusone_standard";
      continue;
      str2 = "ic_plusone_small";
      continue;
      str2 = "ic_plusone_medium";
    }
  }
  
  public boolean a()
  {
    try
    {
      this.a.createPackageContext("com.google.android.gms", 4).getResources();
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */