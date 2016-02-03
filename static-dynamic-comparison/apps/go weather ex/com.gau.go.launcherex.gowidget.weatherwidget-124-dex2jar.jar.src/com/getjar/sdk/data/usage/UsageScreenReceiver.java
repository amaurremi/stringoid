package com.getjar.sdk.data.usage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.getjar.sdk.data.earning.EarningMonitor;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;

public class UsageScreenReceiver
  extends BroadcastReceiver
{
  private static volatile UsageScreenReceiver _Instance = null;
  private boolean _isRegistered = false;
  
  public static UsageScreenReceiver getInstance()
  {
    try
    {
      if (_Instance == null) {
        _Instance = new UsageScreenReceiver();
      }
      UsageScreenReceiver localUsageScreenReceiver = _Instance;
      return localUsageScreenReceiver;
    }
    finally {}
  }
  
  public static boolean isScreenOn(Context paramContext)
  {
    try
    {
      boolean bool = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
      return bool;
    }
    catch (NoSuchMethodError paramContext)
    {
      Logger.e(Area.USAGE.value(), paramContext, "Usage: UsageScreenReceiver: isScreenOn() failed", new Object[0]);
    }
    return true;
  }
  
  public void doOnReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
    {
      Logger.i(Area.USAGE.value(), "Usage: UsageScreenReceiver: screen off", new Object[0]);
      UsageMonitor.getInstance(paramContext).stopMonitoring();
      EarningMonitor.getInstance(paramContext).stopMonitoring();
    }
    while (!paramIntent.getAction().equals("android.intent.action.SCREEN_ON")) {
      return;
    }
    Logger.i(Area.USAGE.value(), "Usage: UsageScreenReceiver: screen on", new Object[0]);
    UsageMonitor.getInstance(paramContext).startMonitoring();
    EarningMonitor.getInstance(paramContext).startMonitoring();
  }
  
  public void onReceive(final Context paramContext, final Intent paramIntent)
  {
    try
    {
      Logger.d(Area.OS_ENTRY_POINT.value(), "UsageScreenReceiver onReceive start()", new Object[0]);
      new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            UsageScreenReceiver.this.doOnReceive(paramContext, paramIntent);
            return;
          }
          catch (Exception localException)
          {
            Logger.e(Area.USAGE.value() | Area.OS_ENTRY_POINT.value(), localException, "UsageScreenReceiver: onReceive() failed", new Object[0]);
          }
        }
      }, "UsageScreenReceiver Worker Thread").start();
      return;
    }
    catch (Exception paramContext)
    {
      Logger.e(Area.USAGE.value() | Area.OS_ENTRY_POINT.value(), paramContext, "UsageScreenReceiver: onReceive() failed", new Object[0]);
    }
  }
  
  public void registerReceiver(Context paramContext)
  {
    try
    {
      if (!this._isRegistered)
      {
        IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        paramContext.getApplicationContext().registerReceiver(this, localIntentFilter);
        this._isRegistered = true;
        Logger.v(Area.USAGE.value(), "Usage: UsageScreenReceiver: screen monitor registered", new Object[0]);
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  protected void unregisterReceiver(Context paramContext)
  {
    try
    {
      if (this._isRegistered)
      {
        paramContext.getApplicationContext().unregisterReceiver(this);
        this._isRegistered = false;
        Logger.v(Area.USAGE.value(), "Usage: UsageScreenReceiver: screen monitor unregistered", new Object[0]);
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/usage/UsageScreenReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */