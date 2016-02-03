package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.ArrayList;

final class or
  extends Handler
{
  public or(hc paramhc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      synchronized (hc.a(this.a))
      {
        if ((hc.b(this.a).eO()) && (hc.b(this.a).isConnected()) && (hc.a(this.a).contains(paramMessage.obj)))
        {
          Bundle localBundle = hc.b(this.a).ef();
          ((GoogleApiClient.ConnectionCallbacks)paramMessage.obj).onConnected(localBundle);
        }
        return;
      }
    }
    Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/or.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */