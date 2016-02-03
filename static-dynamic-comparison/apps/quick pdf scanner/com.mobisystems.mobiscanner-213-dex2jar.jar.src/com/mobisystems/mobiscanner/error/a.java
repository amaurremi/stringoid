package com.mobisystems.mobiscanner.error;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.mobisystems.mobiscanner.common.d;

public class a
  implements Thread.UncaughtExceptionHandler
{
  private static a aGZ = null;
  private Context ZB;
  
  private a(Context paramContext)
  {
    this.ZB = paramContext;
  }
  
  public static void ay(Context paramContext)
  {
    if ((d.DD()) && (aGZ == null))
    {
      aGZ = new a(paramContext);
      Thread.setDefaultUncaughtExceptionHandler(aGZ);
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Log.e("ErrorHandler", "UncaughtException", paramThrowable);
    b.a(this.ZB, paramThrowable);
    Process.killProcess(Process.myPid());
    System.exit(10);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/error/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */