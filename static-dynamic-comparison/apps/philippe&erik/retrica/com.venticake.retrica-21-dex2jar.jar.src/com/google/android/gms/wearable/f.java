package com.google.android.gms.wearable;

import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.ac.a;
import com.google.android.gms.wearable.internal.af;
import com.google.android.gms.wearable.internal.ai;

class f
  extends ac.a
{
  private f(WearableListenerService paramWearableListenerService) {}
  
  public void Y(final DataHolder paramDataHolder)
  {
    if (Log.isLoggable("WearableLS", 3)) {
      Log.d("WearableLS", "onDataItemChanged: " + WearableListenerService.a(this.a) + ": " + paramDataHolder);
    }
    WearableListenerService.b(this.a);
    synchronized (WearableListenerService.c(this.a))
    {
      if (WearableListenerService.d(this.a))
      {
        paramDataHolder.close();
        return;
      }
      WearableListenerService.e(this.a).post(new Runnable()
      {
        public void run()
        {
          DataEventBuffer localDataEventBuffer = new DataEventBuffer(paramDataHolder);
          try
          {
            f.this.a.onDataChanged(localDataEventBuffer);
            return;
          }
          finally
          {
            localDataEventBuffer.release();
          }
        }
      });
      return;
    }
  }
  
  public void a(final af paramaf)
  {
    if (Log.isLoggable("WearableLS", 3)) {
      Log.d("WearableLS", "onMessageReceived: " + paramaf);
    }
    WearableListenerService.b(this.a);
    synchronized (WearableListenerService.c(this.a))
    {
      if (WearableListenerService.d(this.a)) {
        return;
      }
      WearableListenerService.e(this.a).post(new Runnable()
      {
        public void run()
        {
          f.this.a.onMessageReceived(paramaf);
        }
      });
      return;
    }
  }
  
  public void a(final ai paramai)
  {
    if (Log.isLoggable("WearableLS", 3)) {
      Log.d("WearableLS", "onPeerConnected: " + WearableListenerService.a(this.a) + ": " + paramai);
    }
    WearableListenerService.b(this.a);
    synchronized (WearableListenerService.c(this.a))
    {
      if (WearableListenerService.d(this.a)) {
        return;
      }
      WearableListenerService.e(this.a).post(new Runnable()
      {
        public void run()
        {
          f.this.a.onPeerConnected(paramai);
        }
      });
      return;
    }
  }
  
  public void b(final ai paramai)
  {
    if (Log.isLoggable("WearableLS", 3)) {
      Log.d("WearableLS", "onPeerDisconnected: " + WearableListenerService.a(this.a) + ": " + paramai);
    }
    WearableListenerService.b(this.a);
    synchronized (WearableListenerService.c(this.a))
    {
      if (WearableListenerService.d(this.a)) {
        return;
      }
      WearableListenerService.e(this.a).post(new Runnable()
      {
        public void run()
        {
          f.this.a.onPeerDisconnected(paramai);
        }
      });
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */