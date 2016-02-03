package com.inmobi.commons.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.ThinICEConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivityRecognitionSampler
{
  static HandlerThread a;
  static Looper b = a.getLooper();
  static Handler c = new a(b);
  static List<ActivitySample> d = new ArrayList();
  
  static
  {
    a = new HandlerThread("ActivityDetectionSampler");
    a.start();
  }
  
  private static void b()
  {
    if (AnalyticsInitializer.getConfigParams().getThinIceConfig().isActivityDetectionEnabled())
    {
      Message localMessage = c.obtainMessage(1);
      c.sendMessageDelayed(localMessage, AnalyticsInitializer.getConfigParams().getThinIceConfig().getActivityDetectionInterval());
    }
  }
  
  public static List<ActivitySample> getCollectedList()
  {
    if (AnalyticsInitializer.getConfigParams().getThinIceConfig().isActivityDetectionEnabled()) {
      return d;
    }
    return Collections.emptyList();
  }
  
  public static void start()
  {
    if (c.hasMessages(1)) {
      return;
    }
    c.sendEmptyMessage(1);
  }
  
  public static void stop()
  {
    c.removeMessages(1);
    d.clear();
  }
  
  public static class ActivitySample
  {
    private long a;
    private int b;
    
    public ActivitySample(int paramInt, long paramLong)
    {
      this.b = paramInt;
      this.a = paramLong;
    }
    
    public int getActivity()
    {
      return this.b;
    }
    
    public long getTimestamp()
    {
      return this.a;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/internal/ActivityRecognitionSampler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */