package com.appbrain.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Base64;
import cmn.a;
import com.appbrain.AppBrainActivity;
import com.appbrain.e.j.i;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public final class t
{
  private static j.i a;
  private static LinkedHashSet b;
  
  private static j.i a()
  {
    int j = 1;
    Object localObject1;
    if (a == null)
    {
      localObject1 = aa.a().a("app_alert", null);
      if (localObject1 == null) {}
    }
    try
    {
      localObject1 = j.i.a(Base64.decode((String)localObject1, 0));
      if (localObject1 != null)
      {
        b();
        if (!b.contains(Integer.valueOf(((j.i)localObject1).h()))) {
          if (!((j.i)localObject1).w())
          {
            i = 1;
            if (i == 0) {
              break label140;
            }
            i = j;
            if (i != 0) {
              a = (j.i)localObject1;
            }
            return a;
          }
        }
      }
    }
    catch (com.appbrain.b.i locali)
    {
      for (;;)
      {
        int i;
        Object localObject2 = null;
        continue;
        long l = aa.a().e().getLong("last_app_alert_discard", 0L);
        if ((int)((System.currentTimeMillis() - l) / 1000L) > ((j.i)localObject2).x())
        {
          i = 1;
        }
        else
        {
          i = 0;
          continue;
          label140:
          i = 0;
        }
      }
    }
  }
  
  static void a(int paramInt, SharedPreferences.Editor paramEditor)
  {
    b();
    b.add(Integer.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    int i = b.size();
    Iterator localIterator = b.iterator();
    paramInt = 0;
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (paramInt >= i - 100)
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(',');
        }
        localStringBuilder.append(localInteger);
      }
      paramInt += 1;
    }
    paramEditor.putString("discarded_app_alert_ids", localStringBuilder.toString());
  }
  
  static void a(Context paramContext)
  {
    if ((!(paramContext instanceof Activity)) || ((paramContext instanceof AppBrainActivity))) {}
    j.i locali;
    do
    {
      do
      {
        return;
        paramContext = (Activity)paramContext;
      } while (paramContext.isFinishing());
      locali = a();
    } while (locali == null);
    if (locali.z())
    {
      Object localObject = new Intent("android.intent.action.MAIN");
      ((Intent)localObject).addCategory("android.intent.category.LAUNCHER");
      ((Intent)localObject).setPackage(paramContext.getPackageName());
      localObject = paramContext.getPackageManager().queryIntentActivities((Intent)localObject, 0).iterator();
      ResolveInfo localResolveInfo;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localResolveInfo = (ResolveInfo)((Iterator)localObject).next();
      } while ((localResolveInfo.activityInfo == null) || (localResolveInfo.activityInfo.name == null) || (!localResolveInfo.activityInfo.name.equals(paramContext.getClass().getName())));
    }
    for (int i = 1; i != 0; i = 0) {
      switch (1.a[locali.r().ordinal()])
      {
      default: 
        return;
      case 1: 
        m.a(paramContext, locali);
        return;
      }
    }
    u.a(paramContext, locali);
    return;
    i.a(paramContext, locali);
    return;
    r.a(paramContext, locali);
  }
  
  static void a(boolean paramBoolean)
  {
    if (a != null)
    {
      SharedPreferences.Editor localEditor = aa.a().e().edit();
      if ((!a.w()) || ((paramBoolean) && (a.v()))) {
        a(a.h(), localEditor);
      }
      localEditor.putLong("last_app_alert_discard", System.currentTimeMillis());
      a.a().a(localEditor);
      a = null;
    }
  }
  
  static boolean a(j.i parami)
  {
    return (a != null) && (a.h() == parami.h());
  }
  
  private static void b()
  {
    String[] arrayOfString;
    int j;
    int i;
    if (b == null)
    {
      b = new LinkedHashSet();
      arrayOfString = aa.a().e().getString("discarded_app_alert_ids", "").split(",");
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      String str;
      if (i < j) {
        str = arrayOfString[i];
      }
      try
      {
        b.add(Integer.valueOf(Integer.parseInt(str)));
        i += 1;
        continue;
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */