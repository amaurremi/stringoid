package com.flurry.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class InstallReceiver
  extends BroadcastReceiver
{
  private final Handler a;
  private File b = null;
  
  private InstallReceiver()
  {
    HandlerThread localHandlerThread = new HandlerThread("InstallReceiver");
    localHandlerThread.start();
    this.a = new Handler(localHandlerThread.getLooper());
  }
  
  private static Map a(String paramString)
  {
    if ((paramString == null) || (paramString.trim().equals(""))) {
      throw new IllegalArgumentException("Referrer is null or empty");
    }
    HashMap localHashMap = new HashMap();
    String[] arrayOfString1 = paramString.split("&");
    int j = arrayOfString1.length;
    int i = 0;
    if (i < j)
    {
      String[] arrayOfString2 = arrayOfString1[i].split("=");
      if (arrayOfString2.length != 2) {
        ah.a("InstallReceiver", "Invalid referrer Element: " + arrayOfString1[i] + " in referrer tag " + paramString);
      }
      for (;;)
      {
        i += 1;
        break;
        localHashMap.put(arrayOfString2[0], arrayOfString2[1]);
      }
    }
    paramString = new StringBuilder();
    if (localHashMap.get("utm_source") == null) {
      paramString.append("Campaign Source is missing.\n");
    }
    if (localHashMap.get("utm_medium") == null) {
      paramString.append("Campaign Medium is missing.\n");
    }
    if (localHashMap.get("utm_campaign") == null) {
      paramString.append("Campaign Name is missing.\n");
    }
    if (paramString.length() > 0) {
      throw new IllegalArgumentException(paramString.toString());
    }
    return localHashMap;
  }
  
  private void a(Map paramMap)
  {
    try
    {
      paramMap = new t(this, paramMap);
      this.a.post(paramMap);
      return;
    }
    finally
    {
      paramMap = finally;
      throw paramMap;
    }
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    this.b = paramContext.getFileStreamPath(".flurryinstallreceiver." + Integer.toString(FlurryAgent.e().hashCode(), 16));
    if (FlurryAgent.isCaptureUncaughtExceptions()) {
      Thread.setDefaultUncaughtExceptionHandler(new FlurryAgent.FlurryDefaultExceptionHandler());
    }
    paramContext = paramIntent.getStringExtra("referrer");
    if ((paramContext == null) || (!"com.android.vending.INSTALL_REFERRER".equals(paramIntent.getAction()))) {
      return;
    }
    try
    {
      a(a(paramContext));
      return;
    }
    catch (IllegalArgumentException paramContext)
    {
      ah.c("InstallReceiver", "Invalid referrer Tag: " + paramContext.getMessage());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/InstallReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */