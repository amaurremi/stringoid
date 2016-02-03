package com.google.android.gms.drive.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.internal.hn;

public class x<C extends DriveEvent>
  extends ac.a
{
  private final int In;
  private final DriveEvent.Listener<C> Jk;
  private final a<C> Jl;
  
  public x(Looper paramLooper, int paramInt, DriveEvent.Listener<C> paramListener)
  {
    this.In = paramInt;
    this.Jk = paramListener;
    this.Jl = new a(paramLooper, null);
  }
  
  public void a(OnEventResponse paramOnEventResponse)
    throws RemoteException
  {
    if (this.In == paramOnEventResponse.getEventType()) {}
    for (boolean bool = true;; bool = false)
    {
      hn.A(bool);
      switch (paramOnEventResponse.getEventType())
      {
      default: 
        Log.w("EventCallback", "Unexpected event type:" + paramOnEventResponse.getEventType());
        return;
      }
    }
    this.Jl.a(this.Jk, paramOnEventResponse.gr());
    return;
    this.Jl.a(this.Jk, paramOnEventResponse.gs());
  }
  
  private static class a<E extends DriveEvent>
    extends Handler
  {
    private a(Looper paramLooper)
    {
      super();
    }
    
    public void a(DriveEvent.Listener<E> paramListener, E paramE)
    {
      sendMessage(obtainMessage(1, new Pair(paramListener, paramE)));
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
      ((DriveEvent.Listener)paramMessage.first).onEvent((DriveEvent)paramMessage.second);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */