package com.pocket.tts;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class n
{
  private static o a(ResolveInfo paramResolveInfo, PackageManager paramPackageManager)
  {
    ServiceInfo localServiceInfo = paramResolveInfo.serviceInfo;
    if (localServiceInfo != null)
    {
      paramPackageManager = localServiceInfo.loadLabel(paramPackageManager);
      String str = localServiceInfo.packageName;
      if (TextUtils.isEmpty(paramPackageManager)) {}
      for (paramPackageManager = localServiceInfo.packageName;; paramPackageManager = paramPackageManager.toString()) {
        return new o(str, paramPackageManager, localServiceInfo.getIconResource(), paramResolveInfo.priority, a(localServiceInfo), null);
      }
    }
    return null;
  }
  
  public static List a(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    Object localObject = paramContext.queryIntentServices(new Intent("android.intent.action.TTS_SERVICE"), 65536);
    if (localObject == null) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      o localo = a((ResolveInfo)((Iterator)localObject).next(), paramContext);
      if (localo != null) {
        localArrayList.add(localo);
      }
    }
    Collections.sort(localArrayList);
    return localArrayList;
  }
  
  private static boolean a(ServiceInfo paramServiceInfo)
  {
    paramServiceInfo = paramServiceInfo.applicationInfo;
    return (paramServiceInfo != null) && ((paramServiceInfo.flags & 0x1) != 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/tts/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */