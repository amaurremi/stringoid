package com.inmobi.commons.internal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.RetryMechanism;
import com.inmobi.commons.cache.RetryMechanism.RetryRunnable;
import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;
import com.inmobi.commons.thinICE.icedatacollector.Sample;
import com.inmobi.commons.thinICE.icedatacollector.ThinICEConfigSettings;
import com.inmobi.commons.thinICE.icedatacollector.ThinICEListener;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ThinICE
{
  static Object a = null;
  private static boolean b = false;
  private static ThinICEListener c = new a();
  
  @SuppressLint({"NewApi"})
  private static void a(Activity paramActivity)
  {
    if ((!b) && (paramActivity == null)) {
      throw new NullPointerException();
    }
    if (!b)
    {
      if (Build.VERSION.SDK_INT < 14) {
        break label78;
      }
      a = new b();
      paramActivity.getApplication().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)a);
      IceDataCollector.start(paramActivity.getApplicationContext());
    }
    for (;;)
    {
      b = true;
      label78:
      try
      {
        CacheController.getConfig("commons", InternalSDKUtil.getContext(), null, null);
        return;
      }
      catch (Exception paramActivity) {}
      IceDataCollector.setListener(c);
    }
  }
  
  static void a(ThinICEConfig paramThinICEConfig)
  {
    if (paramThinICEConfig != null)
    {
      ThinICEConfigSettings localThinICEConfigSettings = new ThinICEConfigSettings();
      localThinICEConfigSettings.setEnabled(paramThinICEConfig.h);
      localThinICEConfigSettings.setSampleCellEnabled(paramThinICEConfig.j);
      localThinICEConfigSettings.setSampleCellOperatorEnabled(paramThinICEConfig.i);
      localThinICEConfigSettings.setSampleConnectedWifiEnabled(paramThinICEConfig.k);
      localThinICEConfigSettings.setSampleHistorySize(paramThinICEConfig.e);
      localThinICEConfigSettings.setSampleInterval(paramThinICEConfig.a * 1000L);
      localThinICEConfigSettings.setSampleLocationEnabled(paramThinICEConfig.m);
      localThinICEConfigSettings.setSampleVisibleWifiEnabled(paramThinICEConfig.l);
      localThinICEConfigSettings.setStopRequestTimeout(paramThinICEConfig.b * 1000L);
      localThinICEConfigSettings.setWifiFlags(paramThinICEConfig.f);
      localThinICEConfigSettings.setCellOpFlags(paramThinICEConfig.g);
      IceDataCollector.setConfig(localThinICEConfigSettings);
    }
  }
  
  private static void b()
  {
    List localList = IceDataCollector.getData();
    IceDataCollector.stop();
    b(localList);
  }
  
  private static void b(String paramString)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(InternalSDKUtil.a.getTic().n).openConnection();
    localHttpURLConnection.setDoOutput(true);
    localHttpURLConnection.setDoInput(false);
    OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(localHttpURLConnection.getOutputStream());
    localOutputStreamWriter.write(paramString);
    localOutputStreamWriter.flush();
    localOutputStreamWriter.close();
    localHttpURLConnection.getResponseCode();
  }
  
  private static void b(List<Sample> paramList)
  {
    if (paramList.size() == 0)
    {
      Log.internal("IMCOMMONS_3.7.1", "No ThinICE data is collected. NoOp.");
      return;
    }
    if (!InternalSDKUtil.a.getTic().h)
    {
      Log.internal("IMCOMMONS_3.7.1", "ThisICE disabled. Not sending data. NoOp.");
      return;
    }
    RetryMechanism localRetryMechanism = new RetryMechanism((int)InternalSDKUtil.a.getTic().d, (int)InternalSDKUtil.a.getTic().c * 1000);
    String str = new JSONPayloadCreator().toPayloadString(paramList, InternalSDKUtil.getContext());
    Log.internal("IMCOMMONS_3.7.1", "Sending " + paramList.size() + " ThinICE params to server");
    localRetryMechanism.rescheduleTimer(new a(str));
  }
  
  public static void start(Activity paramActivity)
  {
    a(paramActivity);
    if (Build.VERSION.SDK_INT < 14) {
      IceDataCollector.start(paramActivity);
    }
  }
  
  public static void stop(Activity paramActivity)
  {
    a(paramActivity);
    if (Build.VERSION.SDK_INT < 14) {
      b();
    }
  }
  
  static final class a
    implements RetryMechanism.RetryRunnable
  {
    a(String paramString) {}
    
    public void completed() {}
    
    public void run()
      throws Exception
    {
      if (InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext()))
      {
        ThinICE.a(this.a);
        return;
      }
      throw new Exception("Device not connected.");
    }
  }
  
  static final class b
    implements Application.ActivityLifecycleCallbacks
  {
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityDestroyed(Activity paramActivity) {}
    
    public void onActivityPaused(Activity paramActivity) {}
    
    public void onActivityResumed(Activity paramActivity)
    {
      IceDataCollector.start(InternalSDKUtil.getContext());
    }
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity) {}
    
    public void onActivityStopped(Activity paramActivity) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/commons/internal/ThinICE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */