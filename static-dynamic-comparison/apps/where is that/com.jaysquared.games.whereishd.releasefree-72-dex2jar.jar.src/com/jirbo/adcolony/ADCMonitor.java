package com.jirbo.adcolony;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import java.io.PrintStream;

class ADCMonitor
  implements Runnable
{
  public static final int SECONDS_BEFORE_IDLE = 5;
  public static final int SECONDS_BEFORE_SUSPEND = 10;
  static volatile long last_ping_ms;
  static String monitor_mutex = "MONITOR_MUTEX";
  static volatile ADCMonitor singleton;
  
  static void ping()
  {
    synchronized (monitor_mutex)
    {
      last_ping_ms = System.currentTimeMillis();
      if (singleton == null)
      {
        ADC.log_dev("Creating ADC Monitor singleton.");
        singleton = new ADCMonitor();
        new Thread(singleton).start();
      }
      return;
    }
  }
  
  public void run()
  {
    ADC.set_log_level(ADC.log_level);
    ADCLog.dev.println("ADC Monitor Started.");
    ADC.controller.on_resume();
    int j = 0;
    for (;;)
    {
      long l2;
      long l1;
      int k;
      if (!AdColony.activity().isFinishing())
      {
        l2 = System.currentTimeMillis();
        ADC.active = false;
        ADC.controller.update();
        if (!ADC.active) {
          break label139;
        }
        l1 = 50L;
        k = (int)((System.currentTimeMillis() - last_ping_ms) / 1000L);
        ADC.controller.update();
        if ((j != 0) && (k < 10)) {
          break label161;
        }
      }
      synchronized (monitor_mutex)
      {
        singleton = null;
        if (j == 0) {
          ADC.controller.on_suspend();
        }
        if (AdColony.activity().isFinishing())
        {
          ADC.controller.on_stop();
          ADCThreadPool.reset();
        }
        System.out.println("Exiting monitor");
        return;
        label139:
        if (j != 0) {}
        for (int i = 2000;; i = 250)
        {
          l1 = i;
          break;
        }
        label161:
        i = j;
        if (k < 5)
        {
          i = 0;
          ADC.controller.on_resume();
          ADC.log_dev("AdColony is active.");
        }
        do
        {
          sleep(l1);
          l1 = System.currentTimeMillis();
          j = i;
          if (l1 - l2 > 3000L) {
            break;
          }
          j = i;
          if (l1 - l2 <= 0L) {
            break;
          }
          ??? = ADC.controller.session_manager;
          ((ADCSessionManager)???).session_time += (l1 - l2) / 1000.0D;
          j = i;
          break;
          i = j;
        } while (k < 5);
        ADC.log_dev("AdColony is idle.");
        i = 1;
        ADC.controller.on_suspend();
      }
    }
  }
  
  void sleep(long paramLong)
  {
    try
    {
      Thread.sleep(paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  static class Pinger
    extends Handler
  {
    Pinger()
    {
      sendMessageDelayed(obtainMessage(), 1000L);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (ADC.activity().isFinishing())
      {
        ADC.log_dev("Monitor pinger exiting.");
        return;
      }
      if (ADC.activity().hasWindowFocus()) {
        ADCMonitor.ping();
      }
      sendMessageDelayed(obtainMessage(), 1000L);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */