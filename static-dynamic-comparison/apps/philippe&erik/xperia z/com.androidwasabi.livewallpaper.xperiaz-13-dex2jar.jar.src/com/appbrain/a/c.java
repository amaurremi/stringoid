package com.appbrain.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.SystemClock;
import cmn.a;
import cmn.z;
import com.appbrain.ReferrerReceiver;
import com.appbrain.b.d;
import com.appbrain.e.aa;
import com.appbrain.e.ab;
import java.util.TimeZone;

public final class c
{
  private static Long a = null;
  private final Context b;
  
  public c(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    if (!aw.a().b()) {
      aw.a().a(paramContext, false);
    }
  }
  
  private static long a(Context paramContext)
  {
    if (a == null) {}
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
        if (paramContext == null) {
          continue;
        }
        a = Long.valueOf(a.a().a(paramContext, paramContext.applicationInfo));
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        a = Long.valueOf(0L);
        continue;
      }
      return a.longValue();
      a = Long.valueOf(0L);
    }
  }
  
  public final aa a()
  {
    Object localObject1 = z.a(this.b);
    localab = aa.an();
    localab.a(SystemClock.elapsedRealtime());
    localab.b(System.currentTimeMillis());
    localab.a(((z)localObject1).h());
    localab.b(((z)localObject1).l());
    localab.c(((z)localObject1).f());
    localab.d(((z)localObject1).d());
    localab.e(((z)localObject1).g());
    localab.f(((z)localObject1).j());
    localab.g(((z)localObject1).i());
    localab.a(((z)localObject1).k());
    localab.b(((z)localObject1).e());
    localab.h(((z)localObject1).a());
    localab.i(((z)localObject1).b());
    localab.j(((z)localObject1).c());
    localab.m(((z)localObject1).o());
    localab.k(((z)localObject1).n());
    localab.l(((z)localObject1).m());
    localab.o(Build.VERSION.SDK_INT);
    localab.n(TimeZone.getDefault().getOffset(System.currentTimeMillis()));
    aw localaw = aw.a();
    int i;
    Object localObject2;
    if (localaw.e())
    {
      i = 1000;
      localab.c(i + 60);
      localObject2 = ReferrerReceiver.a(localaw.h());
      if (localObject2 != null) {
        localab.n((String)localObject2);
      }
      localObject2 = localaw.d();
      localab.d(((SharedPreferences)localObject2).getInt("pingcount", 0));
      localab.e(((SharedPreferences)localObject2).getInt("init_called", 0));
      localab.c(a(this.b) / 1000L);
      localab.f(((z)localObject1).b);
      localab.g(((z)localObject1).c);
      localab.h(((z)localObject1).d);
    }
    for (;;)
    {
      try
      {
        localNetworkInfo = ((ConnectivityManager)this.b.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo != null) {
          continue;
        }
        localab.i(1);
      }
      catch (Exception localException)
      {
        NetworkInfo localNetworkInfo;
        localab.i(0);
        continue;
      }
      localab.j(((SharedPreferences)localObject2).getInt("ow_imp", 0));
      localab.k(((SharedPreferences)localObject2).getInt("ow_click", 0));
      localab.l(((SharedPreferences)localObject2).getInt("ow_inst", 0));
      localab.o(((z)localObject1).e);
      localab.m(((z)localObject1).a);
      localObject1 = localaw.a("extra", null);
      if (localObject1 != null) {
        localab.p((String)localObject1);
      }
      localObject1 = aq.b();
      if (localObject1 != null) {
        localab.a(d.a((byte[])localObject1));
      }
      localObject1 = aq.c();
      if (localObject1 != null) {
        localab.b(d.a((byte[])localObject1));
      }
      localab.d(aq.a() / 1000L);
      return localab.d();
      i = 0;
      break;
      i = localNetworkInfo.getType();
      localab.i(localNetworkInfo.getSubtype() + (i + 1) * 1000);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */