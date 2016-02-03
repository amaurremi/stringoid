package com.inmobi.commons.internal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build.VERSION;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.ThinICEConfig;
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
import java.util.Timer;

public final class ThinICE
{
  private static boolean a = false;
  private static ThinICEListener b = new b();
  private static Timer c = new Timer();
  
  @SuppressLint({"NewApi"})
  private static void a(Activity paramActivity)
    throws CommonsException
  {
    if ((!a) && (paramActivity == null)) {
      throw new CommonsException(1);
    }
    if (!a)
    {
      if (Build.VERSION.SDK_INT < 14) {
        break label66;
      }
      ApplicationFocusManager.init(paramActivity);
      ApplicationFocusManager.addFocusChangedListener(new a());
      IceDataCollector.start(paramActivity.getApplicationContext());
    }
    for (;;)
    {
      a = true;
      InternalSDKUtil.initialize(paramActivity.getApplicationContext());
      return;
      label66:
      IceDataCollector.setListener(b);
    }
  }
  
  private static void b()
  {
    List localList = IceDataCollector.getData();
    IceDataCollector.stop();
    b(localList);
    ActivityRecognitionSampler.stop();
  }
  
  private static void b(String paramString)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(AnalyticsInitializer.getConfigParams().getThinIceConfig().getEndpointUrl()).openConnection();
    InternalSDKUtil.addCommonPropertiesToConnection(localHttpURLConnection);
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
    if ((paramList.size() == 0) && (ActivityRecognitionSampler.getCollectedList().size() == 0))
    {
      Log.internal("[InMobi]-4.1.1", "No ThinICE data is collected. NoOp.");
      return;
    }
    if (!AnalyticsInitializer.getConfigParams().getThinIceConfig().isEnabled())
    {
      Log.internal("[InMobi]-4.1.1", "ThisICE disabled. Not sending data. NoOp.");
      return;
    }
    RetryMechanism localRetryMechanism = new RetryMechanism((int)AnalyticsInitializer.getConfigParams().getThinIceConfig().getMaxRetry(), (int)AnalyticsInitializer.getConfigParams().getThinIceConfig().getRetryInterval() * 1000, c);
    String str = new JSONPayloadCreator().toPayloadString(paramList, ActivityRecognitionSampler.getCollectedList(), InternalSDKUtil.getContext());
    Log.internal("[InMobi]-4.1.1", "Sending " + paramList.size() + " ThinICE params to server " + str);
    localRetryMechanism.rescheduleTimer(new b(str));
  }
  
  public static void setConfig(ThinICEConfig paramThinICEConfig)
  {
    if (paramThinICEConfig != null)
    {
      ThinICEConfigSettings localThinICEConfigSettings = new ThinICEConfigSettings();
      localThinICEConfigSettings.setEnabled(paramThinICEConfig.isEnabled());
      localThinICEConfigSettings.setSampleCellEnabled(paramThinICEConfig.isCellEnabled());
      localThinICEConfigSettings.setSampleCellOperatorEnabled(paramThinICEConfig.isOperatorEnabled());
      localThinICEConfigSettings.setSampleConnectedWifiEnabled(paramThinICEConfig.isConnectedWifiEnabled());
      localThinICEConfigSettings.setSampleHistorySize(paramThinICEConfig.getSampleHistorySize());
      localThinICEConfigSettings.setSampleInterval(paramThinICEConfig.getSampleInterval() * 1000L);
      localThinICEConfigSettings.setSampleLocationEnabled(true);
      localThinICEConfigSettings.setSampleVisibleWifiEnabled(paramThinICEConfig.isVisibleWifiEnabled());
      localThinICEConfigSettings.setStopRequestTimeout(paramThinICEConfig.getStopRequestTimeout() * 1000L);
      localThinICEConfigSettings.setWifiFlags(paramThinICEConfig.getWifiFlags());
      localThinICEConfigSettings.setCellOpFlags(paramThinICEConfig.getCellOpsFlag());
      IceDataCollector.setConfig(localThinICEConfigSettings);
    }
  }
  
  public static void start(Activity paramActivity)
    throws CommonsException
  {
    if (!InternalSDKUtil.isInitializedSuccessfully(false)) {
      return;
    }
    a(paramActivity);
    if (Build.VERSION.SDK_INT < 14) {
      IceDataCollector.start(paramActivity);
    }
    ActivityRecognitionSampler.start();
  }
  
  public static void stop(Activity paramActivity)
    throws CommonsException
  {
    a(paramActivity);
    if (Build.VERSION.SDK_INT < 14) {
      b();
    }
  }
  
  static final class a
    implements ApplicationFocusManager.FocusChangedListener
  {
    public void onFocusChanged(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        IceDataCollector.start(InternalSDKUtil.getContext());
        return;
      }
      ThinICE.a();
    }
  }
  
  static final class b
    implements RetryMechanism.RetryRunnable
  {
    b(String paramString) {}
    
    public void completed() {}
    
    public void run()
      throws Exception
    {
      Log.internal("[InMobi]-4.1.1", "Sending ThinICE data to server " + AnalyticsInitializer.getConfigParams().getThinIceConfig().getEndpointUrl());
      if (InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext()))
      {
        ThinICE.a(this.a);
        return;
      }
      throw new Exception("Device not connected.");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/internal/ThinICE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */