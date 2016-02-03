package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.n;

public final class c<L>
{
  private final c<L>.a Jl;
  private volatile L mListener;
  
  c(Looper paramLooper, L paramL)
  {
    this.Jl = new a(paramLooper);
    this.mListener = n.b(paramL, "Listener must not be null");
  }
  
  public void a(b<L> paramb)
  {
    n.b(paramb, "Notifier must not be null");
    paramb = this.Jl.obtainMessage(1, paramb);
    this.Jl.sendMessage(paramb);
  }
  
  void b(b<L> paramb)
  {
    Object localObject = this.mListener;
    if (localObject == null)
    {
      paramb.gs();
      return;
    }
    try
    {
      paramb.d(localObject);
      return;
    }
    catch (Exception localException)
    {
      Log.w("ListenerHolder", "Notifying listener failed", localException);
      paramb.gs();
    }
  }
  
  public void clear()
  {
    this.mListener = null;
  }
  
  private final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      boolean bool = true;
      if (paramMessage.what == 1) {}
      for (;;)
      {
        n.K(bool);
        c.this.b((c.b)paramMessage.obj);
        return;
        bool = false;
      }
    }
  }
  
  public static abstract interface b<L>
  {
    public abstract void d(L paramL);
    
    public abstract void gs();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/api/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */