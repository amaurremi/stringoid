package com.google.android.gms.drive.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.internal.hm;

public class x<C extends DriveEvent>
  extends ac.a
{
  private final int Iq;
  private final DriveEvent.Listener<C> Jn;
  private final cc<C> Jo;
  
  public x(Looper paramLooper, int paramInt, DriveEvent.Listener<C> paramListener)
  {
    this.Iq = paramInt;
    this.Jn = paramListener;
    this.Jo = new cc(paramLooper, null);
  }
  
  public void a(OnEventResponse paramOnEventResponse)
  {
    if (this.Iq == paramOnEventResponse.getEventType()) {}
    for (boolean bool = true;; bool = false)
    {
      hm.A(bool);
      switch (paramOnEventResponse.getEventType())
      {
      default: 
        Log.w("EventCallback", "Unexpected event type:" + paramOnEventResponse.getEventType());
        return;
      }
    }
    this.Jo.a(this.Jn, paramOnEventResponse.gw());
    return;
    this.Jo.a(this.Jn, paramOnEventResponse.gx());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */