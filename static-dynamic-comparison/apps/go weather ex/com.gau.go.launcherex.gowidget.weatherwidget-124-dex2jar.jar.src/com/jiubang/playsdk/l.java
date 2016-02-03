package com.jiubang.playsdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import com.android.a.a.a;
import com.android.a.a.d;
import com.android.a.a.g;
import com.android.a.a.j;
import com.android.a.a.k;
import com.android.a.s;
import com.jiubang.playsdk.main.b;
import java.io.File;

public class l
{
  private static s a;
  
  public static s a()
  {
    if (a != null) {
      return a;
    }
    throw new IllegalStateException("Not initialized");
  }
  
  private static s a(Context paramContext, j paramj)
  {
    File localFile = new File(b.d);
    Object localObject = "volley/0";
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0);
      paramContext = str + "/" + paramContext.versionCode;
      localObject = paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label117:
      for (;;) {}
    }
    paramContext = paramj;
    if (paramj == null) {
      if (Build.VERSION.SDK_INT < 9) {
        break label117;
      }
    }
    for (paramContext = new k();; paramContext = new g(AndroidHttpClient.newInstance((String)localObject)))
    {
      paramContext = new a(paramContext);
      paramContext = new s(new d(localFile, 5242880), paramContext);
      paramContext.a();
      return paramContext;
    }
  }
  
  public static void a(Context paramContext)
  {
    a = b(paramContext);
  }
  
  private static s b(Context paramContext)
  {
    return a(paramContext, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */