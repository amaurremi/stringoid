package com.jiubang.ggheart.uninstallcheck;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import com.gtp.a.a.b.c;

public class UninstallCheck
{
  private static boolean a = false;
  
  static
  {
    try
    {
      Log.d("myunistall_init", "load jni lib init");
      System.loadLibrary("uninstalled");
      a = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        a = false;
        c.a("myunistall_init", "can not load libunistalled");
      } while (!c.a());
      localThrowable.printStackTrace();
    }
  }
  
  public static int a(Context paramContext)
  {
    if (a)
    {
      paramContext = "/data/data/" + paramContext.getPackageName();
      return check(paramContext + "/lockfile");
    }
    return -2;
  }
  
  public static int a(Context paramContext, String paramString)
  {
    if (a)
    {
      String str1 = "/data/data/" + paramContext.getPackageName();
      String str2 = str1 + "/obserfile";
      String str3 = str1 + "/lockfile";
      return init(paramContext.getPackageCodePath(), str1, paramString, str2, str3, Build.VERSION.SDK_INT);
    }
    return 0;
  }
  
  public static native int check(String paramString);
  
  public static native int init(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/ggheart/uninstallcheck/UninstallCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */