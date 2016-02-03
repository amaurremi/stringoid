package com.venticake.retrica;

import android.os.Build.VERSION;
import com.venticake.retrica.engine.RetricaEngine;

public class n
{
  public static long a = 0L;
  public static long b = 0L;
  private static int c = -1;
  private static int d = -1;
  
  public static void a()
  {
    Runtime localRuntime = Runtime.getRuntime();
    a = localRuntime.maxMemory();
    b = localRuntime.freeMemory();
  }
  
  public static int b()
  {
    if (c < 0) {
      if (a >= 68000000L) {
        break label28;
      }
    }
    label28:
    for (int i = 2500;; i = 4000)
    {
      c = i;
      return c;
    }
  }
  
  public static int c()
  {
    if (d < 0)
    {
      int i = 0;
      if (Build.VERSION.SDK_INT >= 14) {
        i = 1;
      }
      int j = i;
      if (a > 250000000L) {
        j = i + 1;
      }
      d = j;
    }
    return d;
  }
  
  public static boolean d()
  {
    if (Build.VERSION.SDK_INT < 14) {}
    int i;
    do
    {
      do
      {
        return false;
      } while (a < 120000000L);
      i = RetricaEngine.getGlMaxTextureSize();
    } while ((i > 0) && (i < 2050));
    return true;
  }
  
  public static boolean e()
  {
    return Build.VERSION.SDK_INT < 11;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */