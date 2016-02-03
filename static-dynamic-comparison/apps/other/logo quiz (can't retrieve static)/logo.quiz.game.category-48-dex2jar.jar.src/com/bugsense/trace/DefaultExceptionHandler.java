package com.bugsense.trace;

import android.app.ActivityManager.MemoryInfo;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class DefaultExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  private Thread.UncaughtExceptionHandler defaultExceptionHandler;
  
  public DefaultExceptionHandler(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.defaultExceptionHandler = paramUncaughtExceptionHandler;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    long l1 = 0L;
    try
    {
      long l2 = System.currentTimeMillis();
      long l3 = G.TIMESTAMP;
      l1 = l2 - l3;
    }
    catch (Exception localException2)
    {
      Object localObject;
      Runtime localRuntime;
      HashMap localHashMap;
      for (;;) {}
    }
    localObject = new ActivityManager.MemoryInfo();
    localRuntime = Runtime.getRuntime();
    localHashMap = new HashMap(6);
    localHashMap.put("sysMemAvail", String.valueOf(((ActivityManager.MemoryInfo)localObject).availMem / 1048576.0D));
    localHashMap.put("sysMemLow", String.valueOf(((ActivityManager.MemoryInfo)localObject).lowMemory));
    localHashMap.put("sysMemThreshold", String.valueOf(((ActivityManager.MemoryInfo)localObject).threshold / 1048576.0D));
    localHashMap.put("appMemAvail", String.valueOf(localRuntime.freeMemory() / 1048576.0D));
    localHashMap.put("appMemMax", String.valueOf(localRuntime.maxMemory() / 1048576.0D));
    localHashMap.put("appMemTotal", String.valueOf(localRuntime.totalMemory() / 1048576.0D));
    try
    {
      localObject = CrashMechanism.createJSONFromCrash(localStringWriter.toString(), G.IS_WIFI_ON, G.IS_MOBILENET_ON, G.IS_GPS_ON, G.SCREEN_PROPS, Utils.getTime(), BugSenseHandler.getCrashExtraData(), null, 1, l1, localHashMap);
      CrashMechanism.transmitCrashASync((String)localObject, 1);
      if (BugSenseHandler.I_WANT_TO_DEBUG) {
        Log.d(G.TAG, localStringWriter.toString());
      }
      Utils.saveCrashCounter();
      if (BugSenseHandler.getCallback() != null) {
        BugSenseHandler.getCallback().lastBreath(new Exception(paramThrowable));
      }
    }
    catch (Exception localException1)
    {
      try
      {
        Thread.sleep(3000L);
        this.defaultExceptionHandler.uncaughtException(paramThread, paramThrowable);
        return;
        localException1 = localException1;
        localException1.printStackTrace();
        String str = "";
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bugsense/trace/DefaultExceptionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */