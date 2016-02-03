package com.flurry.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

final class bp
{
  private static final String d = bp.class.getSimpleName();
  
  public static Bundle p(Context paramContext)
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramContext != null) {}
    try
    {
      localObject1 = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if ((localObject1 != null) && (((ApplicationInfo)localObject1).metaData != null)) {
        return ((ApplicationInfo)localObject1).metaData;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        db.c(d, "Cannot find meta data for package: " + paramContext.getPackageName());
        Object localObject2 = localObject3;
      }
    }
    return Bundle.EMPTY;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */