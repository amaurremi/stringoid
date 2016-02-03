package com.google.android.gms.drive.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;

class cc<E extends DriveEvent>
  extends Handler
{
  private cc(Looper paramLooper)
  {
    super(paramLooper);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */