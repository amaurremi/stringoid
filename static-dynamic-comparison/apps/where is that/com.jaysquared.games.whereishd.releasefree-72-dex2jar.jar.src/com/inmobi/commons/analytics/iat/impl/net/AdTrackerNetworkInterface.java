package com.inmobi.commons.analytics.iat.impl.net;

import android.os.Handler;
import com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.Goal;
import com.inmobi.commons.analytics.iat.impl.GoalList;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerConfigParams;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerEventType;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerGoalRetryParams;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerInitializer;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.Logger;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

public class AdTrackerNetworkInterface
{
  private static GoalList a;
  private static AtomicBoolean b = null;
  private static AtomicBoolean c;
  private static Thread d;
  private static Handler e;
  private static AtomicBoolean f = null;
  private static AtomicBoolean g = null;
  private static AdTrackerWebViewLoader h;
  private static boolean i = false;
  private static int j = 0;
  private static String k = "https://d.appsdt.com/download/tracker/?";
  private static String l = "https://d.appsdt.com/sdkdwnldbeacon.html";
  private static String m = "https://d.appsdt.com/download/tracker/iatsdkconfs?";
  private static Timer n = new Timer();
  
  static String a()
  {
    return k;
  }
  
  private static void a(Goal arg0)
  {
    for (;;)
    {
      long l2;
      int i1;
      long l1;
      try
      {
        String str = ???.getGoalName();
        l2 = ???.getRetryTime();
        i1 = AdTrackerInitializer.getConfigParams().getRetryParams().getMaxWaitTime();
        if (true == f.get())
        {
          l1 = 0L;
          if (l1 > 0L) {
            Log.debug("[InMobi]-[AdTracker]-4.1.1", "Retrying goalname: " + str + " after " + l1 / 1000L + " secs");
          }
          synchronized (d)
          {
            Thread.sleep(l1);
            return;
          }
        }
        l1 = l2;
      }
      catch (Exception ???)
      {
        Log.internal("[InMobi]-[AdTracker]-4.1.1", "Failed to reduce wait time exception", ???);
        return;
      }
      if (l2 > i1) {
        l1 = i1;
      }
    }
  }
  
  private static void a(String paramString, Goal paramGoal)
  {
    boolean bool = paramGoal.isDuplicateGoal();
    int i1 = paramGoal.getGoalCount();
    String str = paramGoal.getGoalName();
    if (!g()) {}
    for (paramString = Boolean.valueOf(reportUsingWebview(paramString, paramGoal)); paramString.booleanValue(); paramString = Boolean.valueOf(reportUsingNetwork(paramString, paramGoal)))
    {
      FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "goalPingSuccess", true);
      a.removeGoal(str, i1);
      if ("download".equals(str)) {
        AdTrackerUtils.updateStatus();
      }
      return;
    }
    a.increaseRetryTime(str, i1, bool);
  }
  
  static String b()
  {
    return l;
  }
  
  private static void b(String paramString)
  {
    try
    {
      a.saveGoals();
      i = AdTrackerInitializer.getLogger().startNewSample();
      Goal localGoal = (Goal)a.get(0);
      if (!InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext()))
      {
        Log.debug("[InMobi]-[AdTracker]-4.1.1", "Network Unavailable");
        j = 1;
        deinit();
        return;
      }
      a(localGoal);
      f();
      a(paramString, localGoal);
      FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "waitForReferrer", true);
      j = 0;
      return;
    }
    catch (Exception paramString)
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Failed to process IAT goals", paramString);
    }
  }
  
  public static void deinit()
  {
    if (b != null) {
      b.set(false);
    }
    if ((a != null) && (!a.isEmpty())) {
      a.saveGoals();
    }
    c.set(false);
    a = null;
  }
  
  private static void f()
  {
    try
    {
      if (!h())
      {
        String str = AdTrackerUtils.getReferrerFromLogs();
        if (str != null)
        {
          Log.internal("[InMobi]-[AdTracker]-4.1.1", "Saving referrer from logs: " + str);
          AdTrackerUtils.setReferrerFromLogs(InternalSDKUtil.getContext(), str);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Failed to set referrer", localException);
    }
  }
  
  private static boolean g()
  {
    try
    {
      String str = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "timetoLive");
      Object localObject = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "iat_ids");
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(new Date());
      localCalendar.getTime().toString();
      if (str != null)
      {
        if (localObject == null) {
          return false;
        }
        localObject = localCalendar.getTime();
        localCalendar.add(11, Integer.parseInt(str));
        boolean bool = localCalendar.getTime().after((Date)localObject);
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Error parsing ttl", localException);
    }
    return false;
  }
  
  public static GoalList getGoalList()
  {
    return a;
  }
  
  public static Thread getNetworkThread()
  {
    return d;
  }
  
  public static Handler getUIHandler()
  {
    return e;
  }
  
  public static AtomicBoolean getWebviewUploadStatus()
  {
    return g;
  }
  
  private static boolean h()
  {
    return FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrer") != null;
  }
  
  public static void init()
  {
    if (a == null) {
      a = GoalList.getLoggedGoals();
    }
    if (b == null) {
      b = new AtomicBoolean(false);
    }
    c = new AtomicBoolean(false);
    if (e == null) {
      e = new Handler();
    }
    f = new AtomicBoolean(true);
    g = new AtomicBoolean(false);
  }
  
  public static boolean isMetricSample()
  {
    return i;
  }
  
  public static boolean isSynced()
  {
    return c.get();
  }
  
  public static int isUnstableNetwork()
  {
    return j;
  }
  
  public static void notifyThread()
  {
    try
    {
      synchronized (d)
      {
        d.notify();
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Failed to notify thread", localException);
    }
  }
  
  public static AdTrackerConstants.StatusCode reportToServer(String paramString)
  {
    try
    {
      if (b.compareAndSet(false, true))
      {
        d = new Thread(new a(paramString));
        d.setPriority(1);
        d.start();
      }
      paramString = AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_SUCCESS;
      return paramString;
    }
    finally {}
  }
  
  protected static boolean reportUsingNetwork(String paramString, Goal paramGoal)
  {
    String str1 = paramGoal.getGoalName();
    try
    {
      String str2 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "iat_ids");
      AdTrackerConstants.StatusCode localStatusCode = AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_FAILURE;
      paramString = AdTrackerRequestResponseBuilder.sendHTTPRequest(paramString, paramGoal, str2);
      if (AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_SUCCESS == paramString)
      {
        f.set(true);
        Log.debug("[InMobi]-[AdTracker]-4.1.1", "Successfully uploaded goal: " + str1);
      }
      for (;;)
      {
        return f.get();
        if (AdTrackerConstants.StatusCode.RELOAD_WEBVIEW_ERROR != paramString) {
          break;
        }
        f.set(false);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        f.set(false);
        Log.debug("[InMobi]-[AdTracker]-4.1.1", "Failed to upload goal: " + str1);
        Log.internal("[InMobi]-[AdTracker]-4.1.1", "Failed to report goal: ", paramString);
        continue;
        f.set(false);
        Log.debug("[InMobi]-[AdTracker]-4.1.1", "Failed to upload goal: " + str1);
      }
    }
  }
  
  protected static boolean reportUsingWebview(String arg0, Goal paramGoal)
  {
    for (;;)
    {
      try
      {
        i1 = AdTrackerInitializer.getConfigParams().getWebviewTimeout();
        h = new AdTrackerWebViewLoader();
        AdTrackerRequestResponseBuilder.saveWebviewRequestParam(???, paramGoal);
        h.loadWebview(paramGoal);
      }
      catch (Exception ???)
      {
        int i1;
        f.set(false);
        Log.internal("[InMobi]-[AdTracker]-4.1.1", "Failed to load webview Exception", ???);
        continue;
        f.set(true);
        Log.debug("[InMobi]-[AdTracker]-4.1.1", "Uploaded goal successfully: " + paramGoal.getGoalName());
        continue;
      }
      synchronized (d)
      {
        d.wait(i1);
        if (true == AdTrackerWebViewLoader.isWebviewLoading()) {
          AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, paramGoal, 0, 0L, 408, null);
        }
        if (!g.get())
        {
          f.set(false);
          Log.debug("[InMobi]-[AdTracker]-4.1.1", "Failed to upload goal: " + paramGoal.getGoalName());
          h.deinit(i1);
          return g.get();
        }
      }
    }
  }
  
  public static void setSynced(boolean paramBoolean)
  {
    c.set(paramBoolean);
  }
  
  public static void setWebviewUploadStatus(boolean paramBoolean)
  {
    g.set(paramBoolean);
  }
  
  public static void waitThread(int paramInt)
  {
    try
    {
      synchronized (d)
      {
        d.wait(paramInt);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Failed to notify thread", localException);
    }
  }
  
  static final class a
    implements Runnable
  {
    a(String paramString) {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: invokestatic 28	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:c	()Ljava/util/concurrent/atomic/AtomicBoolean;
      //   3: invokevirtual 34	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   6: ifne +86 -> 92
      //   9: invokestatic 38	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:d	()Lcom/inmobi/commons/analytics/iat/impl/GoalList;
      //   12: invokevirtual 43	com/inmobi/commons/analytics/iat/impl/GoalList:saveGoals	()V
      //   15: invokestatic 28	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:c	()Ljava/util/concurrent/atomic/AtomicBoolean;
      //   18: iconst_1
      //   19: invokevirtual 47	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   22: invokestatic 38	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:d	()Lcom/inmobi/commons/analytics/iat/impl/GoalList;
      //   25: ifnull +12 -> 37
      //   28: invokestatic 38	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:d	()Lcom/inmobi/commons/analytics/iat/impl/GoalList;
      //   31: invokevirtual 50	com/inmobi/commons/analytics/iat/impl/GoalList:isEmpty	()Z
      //   34: ifeq +14 -> 48
      //   37: ldc 52
      //   39: ldc 54
      //   41: invokestatic 60	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
      //   44: invokestatic 63	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:deinit	()V
      //   47: return
      //   48: invokestatic 38	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:d	()Lcom/inmobi/commons/analytics/iat/impl/GoalList;
      //   51: invokevirtual 50	com/inmobi/commons/analytics/iat/impl/GoalList:isEmpty	()Z
      //   54: ifne +28 -> 82
      //   57: aload_0
      //   58: getfield 17	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface$a:a	Ljava/lang/String;
      //   61: invokestatic 65	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:a	(Ljava/lang/String;)V
      //   64: goto -16 -> 48
      //   67: astore_1
      //   68: invokestatic 63	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:deinit	()V
      //   71: return
      //   72: astore_1
      //   73: ldc 52
      //   75: ldc 67
      //   77: aload_1
      //   78: invokestatic 70	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   81: return
      //   82: invokestatic 73	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:e	()Ljava/util/concurrent/atomic/AtomicBoolean;
      //   85: iconst_0
      //   86: invokevirtual 47	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   89: goto -89 -> 0
      //   92: invokestatic 63	com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface:deinit	()V
      //   95: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	96	0	this	a
      //   67	1	1	localException1	Exception
      //   72	6	1	localException2	Exception
      // Exception table:
      //   from	to	target	type
      //   48	64	67	java/lang/Exception
      //   0	37	72	java/lang/Exception
      //   37	47	72	java/lang/Exception
      //   68	71	72	java/lang/Exception
      //   82	89	72	java/lang/Exception
      //   92	95	72	java/lang/Exception
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */