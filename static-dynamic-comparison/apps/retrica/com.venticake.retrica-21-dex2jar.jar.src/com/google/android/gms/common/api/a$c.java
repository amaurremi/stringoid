package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;

public class a$c<R extends Result>
  extends Handler
{
  public a$c()
  {
    this(Looper.getMainLooper());
  }
  
  public a$c(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a(ResultCallback<R> paramResultCallback, R paramR)
  {
    sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
  }
  
  public void a(a.a<R> parama, long paramLong)
  {
    sendMessageDelayed(obtainMessage(2, parama), paramLong);
  }
  
  protected void b(ResultCallback<R> paramResultCallback, R paramR)
  {
    try
    {
      paramResultCallback.onResult(paramR);
      return;
    }
    catch (RuntimeException paramResultCallback)
    {
      a.a(paramR);
      throw paramResultCallback;
    }
  }
  
  public void eH()
  {
    removeMessages(2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      Log.wtf("GoogleApi", "Don't know how to handle this message.");
      return;
    case 1: 
      paramMessage = (Pair)paramMessage.obj;
      b((ResultCallback)paramMessage.first, (Result)paramMessage.second);
      return;
    }
    a.a.a((a.a)paramMessage.obj);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/api/a$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */