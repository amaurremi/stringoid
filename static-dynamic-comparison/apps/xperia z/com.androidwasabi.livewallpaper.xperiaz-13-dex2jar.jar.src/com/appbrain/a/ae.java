package com.appbrain.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cmn.a;
import com.appbrain.e.k;
import com.appbrain.e.n;
import com.appbrain.g;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ae
  implements g
{
  private static g b = null;
  private static g c = null;
  private final SharedPreferences a;
  
  private ae(SharedPreferences paramSharedPreferences)
  {
    this.a = paramSharedPreferences;
  }
  
  public static g a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = b;
      }
      finally {}
      Object localObject2 = new ae(paramContext.getSharedPreferences((String)localObject1, 0));
      if (paramBoolean)
      {
        b = (g)localObject2;
        return (g)localObject2;
        localObject1 = c;
      }
      else
      {
        c = (g)localObject2;
        continue;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        if (paramBoolean) {
          localObject1 = "ab_pref_int";
        } else {
          localObject1 = "ab_pref_ext";
        }
      }
    }
  }
  
  public static void a(Context paramContext, k paramk)
  {
    Object localObject1;
    if (((paramk.m()) && (paramk.n())) || (paramk.j() > 0))
    {
      Object localObject2 = paramContext.getSharedPreferences("ab_pref_ext", 0);
      localObject1 = ((SharedPreferences)localObject2).edit();
      if ((paramk.m()) && (paramk.n()))
      {
        localObject2 = ((SharedPreferences)localObject2).getAll().keySet().iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((SharedPreferences.Editor)localObject1).remove((String)((Iterator)localObject2).next());
        }
      }
      a(paramk.i(), (SharedPreferences.Editor)localObject1);
      a.a().a((SharedPreferences.Editor)localObject1);
    }
    if (((paramk.k()) && (paramk.l())) || (paramk.h() > 0))
    {
      localObject1 = paramContext.getSharedPreferences("ab_pref_int", 0);
      paramContext = ((SharedPreferences)localObject1).edit();
      if ((paramk.k()) && (paramk.l()))
      {
        localObject1 = ((SharedPreferences)localObject1).getAll().keySet().iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramContext.remove((String)((Iterator)localObject1).next());
        }
      }
      a(paramk.g(), paramContext);
      a.a().a(paramContext);
    }
  }
  
  private static void a(List paramList, SharedPreferences.Editor paramEditor)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      n localn = (n)paramList.next();
      if ((localn.k()) && (localn.l())) {
        paramEditor.remove(localn.h());
      } else {
        paramEditor.putString(localn.h(), localn.j());
      }
    }
  }
  
  public final String a(String paramString)
  {
    return a(paramString, null);
  }
  
  public final String a(String paramString1, String paramString2)
  {
    return this.a.getString(paramString1, paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */