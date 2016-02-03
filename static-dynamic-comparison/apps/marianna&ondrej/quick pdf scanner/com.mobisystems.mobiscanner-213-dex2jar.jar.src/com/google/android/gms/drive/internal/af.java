package com.google.android.gms.drive.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.a;
import com.google.android.gms.internal.dc;

public class af<C extends DriveEvent>
  extends aj.a
{
  private final DriveEvent.a<C> tQ;
  private final a<C> tR;
  private final int ta;
  
  public af(Looper paramLooper, int paramInt, DriveEvent.a<C> parama)
  {
    this.ta = paramInt;
    this.tQ = parama;
    this.tR = new a(paramLooper, null);
  }
  
  public void a(OnEventResponse paramOnEventResponse)
  {
    if (this.ta == paramOnEventResponse.getEventType()) {}
    for (boolean bool = true;; bool = false)
    {
      dc.G(bool);
      switch (paramOnEventResponse.getEventType())
      {
      default: 
        Log.w("EventCallback", "Unexpected event type:" + paramOnEventResponse.getEventType());
        return;
      }
    }
    this.tR.a(this.tQ, paramOnEventResponse.nh());
    return;
    this.tR.a(this.tQ, paramOnEventResponse.ni());
  }
  
  private static class a<E extends DriveEvent>
    extends Handler
  {
    private a(Looper paramLooper)
    {
      super();
    }
    
    public void a(DriveEvent.a<E> parama, E paramE)
    {
      sendMessage(obtainMessage(1, new Pair(parama, paramE)));
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Log.wtf("EventCallback", "Don't know how to handle this event");
        return;
      }
      paramMessage = (Pair)paramMessage.obj;
      ((DriveEvent.a)paramMessage.first).a((DriveEvent)paramMessage.second);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/internal/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */