package com.google.android.gms.internal;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.location.LocationListener;

class pf
  extends Handler
{
  private final LocationListener a;
  
  public pf(LocationListener paramLocationListener)
  {
    this.a = paramLocationListener;
  }
  
  public pf(LocationListener paramLocationListener, Looper paramLooper)
  {
    super(paramLooper);
    this.a = paramLocationListener;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
      return;
    }
    paramMessage = new Location((Location)paramMessage.obj);
    this.a.onLocationChanged(paramMessage);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/pf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */