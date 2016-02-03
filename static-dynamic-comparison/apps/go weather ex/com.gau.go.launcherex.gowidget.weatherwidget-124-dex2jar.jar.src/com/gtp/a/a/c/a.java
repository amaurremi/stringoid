package com.gtp.a.a.c;

import android.os.Build.VERSION;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class a
{
  private static int a = -1;
  
  public static int a()
  {
    if (a != -1) {
      return a;
    }
    int i = b();
    int j = c();
    if (i + j <= 2) {
      a = 1;
    }
    for (;;)
    {
      return a;
      if ((i <= 2) && (j <= 2)) {
        a = 2;
      } else {
        a = 3;
      }
    }
  }
  
  private static int b()
  {
    try
    {
      Integer localInteger = Integer.valueOf(b.a());
      if (localInteger.intValue() >= 1200000) {
        return 1;
      }
      int i = localInteger.intValue();
      if (i < 900000) {
        return 3;
      }
    }
    catch (Exception localException) {}
    return 2;
  }
  
  private static int c()
  {
    long l3 = Runtime.getRuntime().maxMemory() / 1024L / 1024L;
    long l1;
    if (Build.VERSION.SDK_INT >= 14)
    {
      l1 = 128L;
      if (Build.VERSION.SDK_INT < 14) {
        break label74;
      }
    }
    long l4;
    label74:
    for (long l2 = 64L;; l2 = 28L)
    {
      l4 = d() / 1024L;
      if ((l4 < 680L) || (l3 < l1)) {
        break label81;
      }
      return 1;
      l1 = 48L;
      break;
    }
    label81:
    if ((l4 >= 500L) && (l3 >= l2)) {
      return 2;
    }
    return 3;
  }
  
  private static long d()
  {
    long l2 = 0L;
    try
    {
      Object localObject = new BufferedReader(new FileReader("/proc/meminfo"), 4096);
      String str = ((BufferedReader)localObject).readLine();
      ((BufferedReader)localObject).close();
      long l1 = l2;
      if (str != null)
      {
        localObject = str.split("\\s+");
        l1 = l2;
        if (localObject != null)
        {
          l1 = l2;
          if (localObject.length >= 1) {
            l1 = Long.parseLong(localObject[1]);
          }
        }
      }
      return l1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Log.e("taskManager", "getTotalMemory error");
      return 0L;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Log.e("taskManager", "getTotalMemory error");
      return 0L;
    }
    catch (IOException localIOException)
    {
      Log.e("taskManager", "getTotalMemory error");
    }
    return 0L;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/a/a/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */