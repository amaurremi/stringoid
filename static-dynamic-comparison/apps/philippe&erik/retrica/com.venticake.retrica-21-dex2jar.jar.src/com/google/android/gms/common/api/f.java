package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.concurrent.locks.Lock;

class f
  extends Handler
{
  f(c paramc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      c.a(this.a).lock();
      try
      {
        if ((!this.a.isConnected()) && (!this.a.isConnecting())) {
          this.a.connect();
        }
        return;
      }
      finally
      {
        c.a(this.a).unlock();
      }
    }
    Log.wtf("GoogleApiClientImpl", "Don't know how to handle this message.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/api/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */