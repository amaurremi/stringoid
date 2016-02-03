package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class dp
  extends Handler
{
  private final ContainerHolder.ContainerAvailableListener b;
  
  public dp(n paramn, ContainerHolder.ContainerAvailableListener paramContainerAvailableListener, Looper paramLooper)
  {
    super(paramLooper);
    this.b = paramContainerAvailableListener;
  }
  
  public void a(String paramString)
  {
    sendMessage(obtainMessage(1, paramString));
  }
  
  protected void b(String paramString)
  {
    this.b.onContainerAvailable(this.a, paramString);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      as.a("Don't know how to handle this message.");
      return;
    }
    b((String)paramMessage.obj);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/dp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */