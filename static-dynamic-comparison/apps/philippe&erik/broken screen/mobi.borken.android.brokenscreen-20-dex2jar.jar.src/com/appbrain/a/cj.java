package com.appbrain.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cmn.a;
import com.appbrain.RemoteSettings;
import com.appbrain.e.a.g;
import com.appbrain.e.a.i;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class cj
  implements RemoteSettings
{
  private static RemoteSettings b = null;
  private static RemoteSettings c = null;
  private final SharedPreferences a;
  
  private cj(SharedPreferences paramSharedPreferences)
  {
    this.a = paramSharedPreferences;
  }
  
  public static RemoteSettings a(Context paramContext, boolean paramBoolean)
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
      Object localObject2 = new cj(paramContext.getSharedPreferences((String)localObject1, 0));
      if (paramBoolean)
      {
        b = (RemoteSettings)localObject2;
        return (RemoteSettings)localObject2;
        localObject1 = c;
      }
      else
      {
        c = (RemoteSettings)localObject2;
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
  
  public static void a(Context paramContext, a.g paramg)
  {
    Object localObject1;
    if (((paramg.m()) && (paramg.n())) || (paramg.j() > 0))
    {
      Object localObject2 = paramContext.getSharedPreferences("ab_pref_ext", 0);
      localObject1 = ((SharedPreferences)localObject2).edit();
      if ((paramg.m()) && (paramg.n()))
      {
        localObject2 = ((SharedPreferences)localObject2).getAll().keySet().iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((SharedPreferences.Editor)localObject1).remove((String)((Iterator)localObject2).next());
        }
      }
      a(paramg.i(), (SharedPreferences.Editor)localObject1);
      a.a().a((SharedPreferences.Editor)localObject1);
    }
    if (((paramg.k()) && (paramg.l())) || (paramg.h() > 0))
    {
      localObject1 = paramContext.getSharedPreferences("ab_pref_int", 0);
      paramContext = ((SharedPreferences)localObject1).edit();
      if ((paramg.k()) && (paramg.l()))
      {
        localObject1 = ((SharedPreferences)localObject1).getAll().keySet().iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramContext.remove((String)((Iterator)localObject1).next());
        }
      }
      a(paramg.g(), paramContext);
      a.a().a(paramContext);
    }
  }
  
  private static void a(List paramList, SharedPreferences.Editor paramEditor)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a.i locali = (a.i)paramList.next();
      if ((locali.k()) && (locali.l())) {
        paramEditor.remove(locali.h());
      } else {
        paramEditor.putString(locali.h(), locali.j());
      }
    }
  }
  
  public final String get(String paramString)
  {
    return get(paramString, null);
  }
  
  public final String get(String paramString1, String paramString2)
  {
    return this.a.getString(paramString1, paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */