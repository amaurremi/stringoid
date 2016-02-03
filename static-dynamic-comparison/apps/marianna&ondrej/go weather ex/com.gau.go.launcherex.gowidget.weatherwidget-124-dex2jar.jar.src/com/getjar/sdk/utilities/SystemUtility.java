package com.getjar.sdk.utilities;

import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import com.getjar.sdk.data.usage.UsageManager;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class SystemUtility
{
  public static List<String> getRecentlyRunAppsFromOS(Context paramContext)
    throws PackageManager.NameNotFoundException, IllegalArgumentException, IllegalAccessException
  {
    if (RewardUtility.checkPermission(paramContext, "android.permission.GET_TASKS"))
    {
      Object localObject1 = (ActivityManager)paramContext.getSystemService("activity");
      PackageManager localPackageManager = paramContext.getPackageManager();
      localObject1 = ((ActivityManager)localObject1).getRecentTasks(100, 1);
      HashSet localHashSet = new HashSet();
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        try
        {
          Object localObject2 = (ActivityManager.RecentTaskInfo)((List)localObject1).get(i);
          Intent localIntent = new Intent(((ActivityManager.RecentTaskInfo)localObject2).baseIntent);
          if (((ActivityManager.RecentTaskInfo)localObject2).origActivity != null) {
            localIntent.setComponent(((ActivityManager.RecentTaskInfo)localObject2).origActivity);
          }
          localIntent.setFlags(localIntent.getFlags() & 0xFFDFFFFF | 0x10000000);
          localObject2 = localPackageManager.resolveActivity(localIntent, 0);
          if (localObject2 != null)
          {
            localObject2 = ((ResolveInfo)localObject2).activityInfo.packageName;
            if ((!StringUtility.isNullOrEmpty((String)localObject2)) && (!((String)localObject2).equalsIgnoreCase(paramContext.getPackageName())) && (!UsageManager.getInstance(paramContext).shouldFilterFromUsage((String)localObject2))) {
              localHashSet.add(localObject2);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Logger.e(Area.USAGE.value(), localException, "_getRecentlyRunAppsFromOS() failed", new Object[0]);
          }
        }
        i += 1;
      }
      return new ArrayList(localHashSet);
    }
    return new ArrayList();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/utilities/SystemUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */