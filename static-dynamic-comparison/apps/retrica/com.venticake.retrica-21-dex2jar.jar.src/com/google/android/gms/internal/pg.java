package com.google.android.gms.internal;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.a.a;

class pg
  extends a.a
{
  private Handler a;
  
  pg(LocationListener paramLocationListener, Looper paramLooper)
  {
    if (paramLooper == null) {}
    for (paramLocationListener = new pf(paramLocationListener);; paramLocationListener = new pf(paramLocationListener, paramLooper))
    {
      this.a = paramLocationListener;
      return;
    }
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    if (this.a == null)
    {
      Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramLocation;
    this.a.sendMessage(localMessage);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/pg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */