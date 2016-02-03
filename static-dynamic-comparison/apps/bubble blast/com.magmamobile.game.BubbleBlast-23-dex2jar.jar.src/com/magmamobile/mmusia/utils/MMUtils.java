package com.magmamobile.mmusia.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.magmamobile.mmusia.parser.data.ItemMoreGames;
import java.util.ArrayList;
import java.util.List;

public class MMUtils
{
  private static List<ResolveInfo> list;
  
  private static String getCname(Context paramContext, String paramString)
  {
    if (list == null)
    {
      Intent localIntent = new Intent("android.intent.action.MAIN", null);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      list = paramContext.getPackageManager().queryIntentActivities(localIntent, 0);
    }
    int i = 0;
    if (i >= list.size()) {
      return "";
    }
    if (isSystemPackage((ResolveInfo)list.get(i))) {
      list.remove(i);
    }
    while (!((ResolveInfo)list.get(i)).activityInfo.packageName.equals(paramString))
    {
      i += 1;
      break;
    }
    return ((ResolveInfo)list.get(i)).activityInfo.name;
  }
  
  public static ItemMoreGames[] getMoreGamesForExit(Context paramContext, ItemMoreGames[] paramArrayOfItemMoreGames)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i >= paramArrayOfItemMoreGames.length)
    {
      paramContext = new ItemMoreGames[localArrayList.size()];
      i = 0;
    }
    for (;;)
    {
      if (i >= localArrayList.size())
      {
        return paramContext;
        if (isPackageNameInDevice(paramContext, paramArrayOfItemMoreGames[i].pname))
        {
          paramArrayOfItemMoreGames[i].isLocal = true;
          paramArrayOfItemMoreGames[i].cname = getCname(paramContext, paramArrayOfItemMoreGames[i].pname);
          localArrayList.add(paramArrayOfItemMoreGames[i]);
        }
        for (;;)
        {
          i += 1;
          break;
          paramArrayOfItemMoreGames[i].isLocal = false;
          localArrayList.add(j, paramArrayOfItemMoreGames[i]);
          j += 1;
        }
      }
      paramContext[i] = ((ItemMoreGames)localArrayList.get(i));
      i += 1;
    }
  }
  
  public static boolean isPackageNameInDevice(Context paramContext, String paramString)
  {
    if (list == null)
    {
      Intent localIntent = new Intent("android.intent.action.MAIN", null);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      list = paramContext.getPackageManager().queryIntentActivities(localIntent, 0);
    }
    int i = 0;
    if (i >= list.size()) {
      return false;
    }
    if (isSystemPackage((ResolveInfo)list.get(i))) {
      list.remove(i);
    }
    while (!((ResolveInfo)list.get(i)).activityInfo.packageName.equals(paramString))
    {
      i += 1;
      break;
    }
    return true;
  }
  
  private static boolean isSystemPackage(ResolveInfo paramResolveInfo)
  {
    return (paramResolveInfo.activityInfo.applicationInfo.flags & 0x1) != 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/utils/MMUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */