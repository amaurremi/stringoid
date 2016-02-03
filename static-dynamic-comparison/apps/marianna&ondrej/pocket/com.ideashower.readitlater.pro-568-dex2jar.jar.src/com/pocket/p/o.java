package com.pocket.p;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class o
{
  public static List a(Context paramContext)
  {
    return a(new Intent("android.intent.action.VIEW", Uri.parse("http://getpocket.com")), paramContext);
  }
  
  public static List a(Intent paramIntent, Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = localPackageManager.queryIntentActivities(paramIntent, 65536);
    if (paramContext.size() > 1)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = paramContext.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramIntent = (ResolveInfo)localIterator.next();
        localArrayList1.clear();
        localArrayList2.clear();
        localPackageManager.getPreferredActivities(localArrayList1, localArrayList2, paramIntent.activityInfo.packageName);
      } while (localArrayList2.size() <= 0);
    }
    for (;;)
    {
      if (paramIntent != null)
      {
        paramContext.remove(paramIntent);
        paramContext.add(0, paramIntent);
      }
      return paramContext;
      paramIntent = null;
    }
  }
  
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536);
    return (paramContext != null) && (paramContext.size() > 0);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString, 0);
      if (paramContext != null) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  public static boolean b(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = false;
    paramContext = paramContext.getPackageManager().queryIntentServices(paramIntent, 0);
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean c(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = false;
    paramContext = paramContext.getPackageManager().queryBroadcastReceivers(paramIntent, 0);
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/p/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */