package com.appbrain.a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cmn.a;
import cmn.k;
import com.appbrain.AppBrainService;
import com.appbrain.e.j.a;
import com.appbrain.e.j.k;
import com.appbrain.e.j.o;
import com.appbrain.e.j.o.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class cq
{
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, AppBrainService.class);
    localIntent.setAction("com.appbrain.CHECK");
    paramContext.startService(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, j.o paramo)
  {
    Intent localIntent = new Intent(paramContext, AppBrainService.class);
    localIntent.putExtra("event", k.a(paramo.b()));
    localIntent.putExtra("key", paramString);
    paramContext.startService(localIntent);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject = aa.a().e();
    if (((SharedPreferences)localObject).getString(paramString1, null) == null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
      a.a().a((SharedPreferences.Editor)localObject);
    }
  }
  
  public static boolean b(Context paramContext)
  {
    SharedPreferences localSharedPreferences = aa.a().e();
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
        if ((!str.startsWith(j.a.c.toString())) && (!str.startsWith(j.a.d.toString())) && (!str.startsWith(j.a.e.toString())) && (!str.startsWith(j.a.f.toString()))) {
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
            localObject2 = j.o.a(k.a((String)localObject2));
            if (System.currentTimeMillis() <= ((j.o)localObject2).h().n() + 1.296E8D) {
              break label229;
            }
            i = 1;
            if (!((j.o)localObject2).j()) {
              break label234;
            }
            if ((i == 0) || ((str.startsWith(j.a.c.toString())) && (((j.o)localObject2).l() != 3))) {
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
          if (c.a(paramContext).a(localException1.h()) != null) {
            if ((localException1.h().l() == j.a.c) && (i == 0))
            {
              j.o.a locala = localException1.n();
              locala.a(true);
              localEditor.putString(str, k.a(locala.d().b()));
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */