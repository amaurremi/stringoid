package com.appbrain.a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cmn.a;
import cmn.aa;
import com.appbrain.AppBrainService;
import com.appbrain.e.af;
import com.appbrain.e.aq;
import com.appbrain.e.ax;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class al
{
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, AppBrainService.class);
    localIntent.setAction("com.appbrain.CHECK");
    paramContext.startService(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, com.appbrain.e.aw paramaw)
  {
    Intent localIntent = new Intent(paramContext, AppBrainService.class);
    localIntent.putExtra("event", aa.a(paramaw.b()));
    localIntent.putExtra("key", paramString);
    paramContext.startService(localIntent);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject = aw.a().d();
    if (((SharedPreferences)localObject).getString(paramString1, null) == null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
      a.a().a((SharedPreferences.Editor)localObject);
    }
  }
  
  public static boolean b(Context paramContext)
  {
    SharedPreferences localSharedPreferences = aw.a().d();
    Object localObject1 = localSharedPreferences.getAll();
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localObject1 = ((Map)localObject1).keySet().iterator();
    String str;
    int i;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        str = (String)((Iterator)localObject1).next();
        if ((!str.startsWith(af.c.toString())) && (!str.startsWith(af.d.toString())) && (!str.startsWith(af.e.toString())) && (!str.startsWith(af.f.toString()))) {
          continue;
        }
        Object localObject2 = localSharedPreferences.getString(str, null);
        if (localObject2 == null) {
          continue;
        }
        for (;;)
        {
          try
          {
            localObject2 = com.appbrain.e.aw.a(aa.a((String)localObject2));
            if (System.currentTimeMillis() <= ((com.appbrain.e.aw)localObject2).h().n() + 1.296E8D) {
              break label229;
            }
            i = 1;
            if (!((com.appbrain.e.aw)localObject2).j()) {
              break label234;
            }
            if ((i == 0) || ((str.startsWith(af.c.toString())) && (((com.appbrain.e.aw)localObject2).l() != 3))) {
              break;
            }
            localEditor.remove(str);
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            localEditor.remove(str);
          }
          break;
          label229:
          i = 0;
        }
        try
        {
          label234:
          if (av.a(paramContext).a(localException1.h()) != null) {
            if ((localException1.h().l() == af.c) && (i == 0))
            {
              ax localax = localException1.n();
              localax.a(true);
              localEditor.putString(str, aa.a(localax.d().b()));
            }
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          i = 1;
        }
      }
    }
    for (;;)
    {
      a.a().a(localEditor);
      if (i == 0)
      {
        return true;
        localEditor.remove(str);
        break;
      }
      return false;
      i = 0;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */