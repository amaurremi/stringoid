package com.venticake.retrica.b;

import android.app.Activity;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class a
{
  private static PowerManager.WakeLock a;
  
  public static void a()
  {
    if ((a != null) && (a.isHeld()))
    {
      a.release();
      a = null;
    }
  }
  
  public static void a(Activity paramActivity)
  {
    if ((a != null) && (a.isHeld())) {
      a.release();
    }
    try
    {
      a = ((PowerManager)paramActivity.getSystemService("power")).newWakeLock(1, "EnsureProcessing");
      a.acquire();
      return;
    }
    catch (Exception paramActivity) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */