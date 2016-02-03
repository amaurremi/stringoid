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
import cmn.j;
import com.appbrain.ReferrerReceiver;
import com.appbrain.b.c;
import com.appbrain.e.h.a;
import com.appbrain.e.h.a.a;
import java.util.TimeZone;

public final class br
{
  private static Long a = null;
  private final Context b;
  private final boolean c;
  
  private br(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.c = true;
    if (!aa.a().b()) {
      aa.a().a(paramContext, false);
    }
  }
  
  public static br a(Context paramContext)
  {
    return new br(paramContext);
  }
  
  private static long b(Context paramContext)
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
  
  public final h.a a()
  {
    Object localObject2 = j.a(this.b);
    locala = h.a.as();
    locala.a(SystemClock.elapsedRealtime());
    locala.b(System.currentTimeMillis());
    Object localObject1 = d.a(this.b).a();
    int i;
    label243:
    Object localObject3;
    if ((this.c) && (localObject1 != null))
    {
      locala.q(((d.a)localObject1).a());
      if (((d.a)localObject1).b()) {
        locala.b(true);
      }
      locala.b(((j)localObject2).l());
      locala.c(((j)localObject2).f());
      locala.d(((j)localObject2).d());
      locala.e(((j)localObject2).g());
      locala.a(((j)localObject2).k());
      locala.b(((j)localObject2).e());
      locala.h(((j)localObject2).a());
      locala.i(((j)localObject2).b());
      locala.j(((j)localObject2).c());
      locala.m(((j)localObject2).o());
      locala.k(((j)localObject2).n());
      locala.l(((j)localObject2).m());
      locala.o(Build.VERSION.SDK_INT);
      locala.n(TimeZone.getDefault().getOffset(System.currentTimeMillis()));
      localObject1 = aa.a();
      if (!((aa)localObject1).f()) {
        break label578;
      }
      i = 1000;
      locala.c(i + 65);
      localObject3 = ReferrerReceiver.retrieve(((aa)localObject1).i());
      if (localObject3 != null) {
        locala.n((String)localObject3);
      }
      localObject3 = ((aa)localObject1).e();
      locala.d(((SharedPreferences)localObject3).getInt("pingcount", 0));
      locala.e(((SharedPreferences)localObject3).getInt("init_called", 0));
      locala.c(b(this.b) / 1000L);
      locala.f(((j)localObject2).b);
      locala.g(((j)localObject2).c);
      locala.h(((j)localObject2).d);
    }
    for (;;)
    {
      try
      {
        localNetworkInfo = ((ConnectivityManager)this.b.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo != null) {
          continue;
        }
        locala.i(1);
      }
      catch (Exception localException)
      {
        NetworkInfo localNetworkInfo;
        label578:
        locala.i(0);
        continue;
      }
      locala.j(((SharedPreferences)localObject3).getInt("ow_imp", 0));
      locala.k(((SharedPreferences)localObject3).getInt("ow_click", 0));
      locala.l(((SharedPreferences)localObject3).getInt("ow_inst", 0));
      locala.o(((j)localObject2).e);
      locala.m(((j)localObject2).a);
      localObject2 = ((aa)localObject1).a("extra", null);
      if (localObject2 != null) {
        locala.p((String)localObject2);
      }
      localObject2 = de.b();
      if (localObject2 != null) {
        locala.a(c.a((byte[])localObject2));
      }
      localObject2 = de.c();
      if (localObject2 != null) {
        locala.b(c.a((byte[])localObject2));
      }
      locala.d(de.a() / 1000L);
      if (((aa)localObject1).d()) {
        locala.a(true);
      }
      return locala.d();
      locala.a(((j)localObject2).h());
      locala.f(((j)localObject2).j());
      locala.g(((j)localObject2).i());
      break;
      i = 0;
      break label243;
      i = localNetworkInfo.getType();
      locala.i(localNetworkInfo.getSubtype() + (i + 1) * 1000);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */