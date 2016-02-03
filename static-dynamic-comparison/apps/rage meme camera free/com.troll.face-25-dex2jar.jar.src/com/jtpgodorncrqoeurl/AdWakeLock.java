package com.jtpgodorncrqoeurl;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public abstract class AdWakeLock
{
  private static PowerManager.WakeLock a;
  
  public static void acquire(Context paramContext)
  {
    AdLog.d("LBAdController", "AdLock going to be acquired..");
    if (a != null) {
      a.release();
    }
    try
    {
      AdLog.d("LBAdController", "trying to acquire wake lock");
      paramContext = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(805306394, "AdControllerWakeLock");
      a = paramContext;
      paramContext.acquire();
      return;
    }
    catch (Exception paramContext)
    {
      AdLog.e("LBAdController", "Error acquiring Wake Lock - " + paramContext.getMessage());
      AdLog.printStackTrace("LBAdController", paramContext);
    }
  }
  
  public static void release()
  {
    AdLog.d("LBAdController", "going to release wake lock");
    try
    {
      if (a != null) {
        a.release();
      }
      a = null;
      return;
    }
    catch (Exception localException)
    {
      AdLog.e("LBAdController", "Error releasing Wake Lock - " + localException.getMessage());
      AdLog.printStackTrace("LBAdController", localException);
      a = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdWakeLock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */