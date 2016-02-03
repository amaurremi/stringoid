package com.appbrain.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

final class df
  implements Callable
{
  df(Context paramContext, de.a parama) {}
  
  private List a()
  {
    ArrayList localArrayList = new ArrayList();
    PackageManager localPackageManager;
    Iterator localIterator;
    Object localObject;
    try
    {
      localPackageManager = this.a.getPackageManager();
      localIterator = ((ActivityManager)this.a.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if ((((ActivityManager.RunningAppProcessInfo)localObject).pkgList.length > 0) && ("com.android.vending".equals(localPackageManager.getInstallerPackageName(localObject.pkgList[0])))) {
          localArrayList.add(localObject);
        }
      }
      localIterator = localPackageManager.getInstalledPackages(0).iterator();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return null;
    }
    while (localIterator.hasNext())
    {
      localObject = (PackageInfo)localIterator.next();
      this.b.a((PackageInfo)localObject, localPackageManager.getInstallerPackageName(((PackageInfo)localObject).packageName));
    }
    return localThrowable;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */