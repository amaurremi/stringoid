package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.kh.a;
import com.google.android.gms.internal.ki;
import com.google.android.gms.internal.kk;

public abstract class WearableListenerService
  extends Service
{
  public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
  private IBinder DB;
  private volatile int adu = -1;
  private String adv;
  private Handler adw;
  
  private boolean cM(int paramInt)
  {
    boolean bool2 = false;
    String[] arrayOfString = getPackageManager().getPackagesForUid(paramInt);
    boolean bool1 = bool2;
    if (arrayOfString != null) {
      paramInt = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (paramInt < arrayOfString.length)
      {
        if ("com.google.android.gms".equals(arrayOfString[paramInt])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      paramInt += 1;
    }
  }
  
  private void md()
    throws SecurityException
  {
    int i = Binder.getCallingUid();
    if (i == this.adu) {
      return;
    }
    if ((GooglePlayServicesUtil.b(getPackageManager(), "com.google.android.gms")) && (cM(i)))
    {
      this.adu = i;
      return;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.wearable.BIND_LISTENER".equals(paramIntent.getAction())) {
      return this.DB;
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (Log.isLoggable("WearableLS", 3)) {
      Log.d("WearableLS", "onCreate: " + getPackageName());
    }
    this.adv = getPackageName();
    HandlerThread localHandlerThread = new HandlerThread("WearableListenerService");
    localHandlerThread.start();
    this.adw = new Handler(localHandlerThread.getLooper());
    this.DB = new a(null);
  }
  
  public void onDataChanged(b paramb) {}
  
  public void onDestroy()
  {
    this.adw.getLooper().quit();
    super.onDestroy();
  }
  
  public void onMessageReceived(e parame) {}
  
  public void onPeerConnected(f paramf) {}
  
  public void onPeerDisconnected(f paramf) {}
  
  private class a
    extends kh.a
  {
    private a() {}
    
    public void M(final DataHolder paramDataHolder)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onDataItemChanged: " + WearableListenerService.a(WearableListenerService.this) + ": " + paramDataHolder);
      }
      WearableListenerService.b(WearableListenerService.this);
      WearableListenerService.c(WearableListenerService.this).post(new Runnable()
      {
        public void run()
        {
          b localb = new b(paramDataHolder);
          try
          {
            WearableListenerService.this.onDataChanged(localb);
            return;
          }
          finally
          {
            localb.close();
          }
        }
      });
    }
    
    public void a(final ki paramki)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onMessageReceived: " + paramki);
      }
      WearableListenerService.b(WearableListenerService.this);
      WearableListenerService.c(WearableListenerService.this).post(new Runnable()
      {
        public void run()
        {
          WearableListenerService.this.onMessageReceived(paramki);
        }
      });
    }
    
    public void a(final kk paramkk)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onPeerConnected: " + WearableListenerService.a(WearableListenerService.this) + ": " + paramkk);
      }
      WearableListenerService.b(WearableListenerService.this);
      WearableListenerService.c(WearableListenerService.this).post(new Runnable()
      {
        public void run()
        {
          WearableListenerService.this.onPeerConnected(paramkk);
        }
      });
    }
    
    public void b(final kk paramkk)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onPeerDisconnected: " + WearableListenerService.a(WearableListenerService.this) + ": " + paramkk);
      }
      WearableListenerService.b(WearableListenerService.this);
      WearableListenerService.c(WearableListenerService.this).post(new Runnable()
      {
        public void run()
        {
          WearableListenerService.this.onPeerDisconnected(paramkk);
        }
      });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/wearable/WearableListenerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */