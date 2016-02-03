package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.a;
import com.google.android.gms.common.c;
import java.util.ArrayList;

final class t
  extends Handler
{
  public t(s params, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (!this.a.e()))
    {
      paramMessage = (u)paramMessage.obj;
      paramMessage.a();
      paramMessage.c();
      return;
    }
    synchronized (s.a(this.a))
    {
      this.a.d = false;
      if (paramMessage.what == 3)
      {
        this.a.a(new a(((Integer)paramMessage.obj).intValue(), null));
        return;
      }
    }
    if (paramMessage.what == 4) {
      synchronized (s.b(this.a))
      {
        if ((this.a.c) && (this.a.d()) && (s.b(this.a).contains(paramMessage.obj))) {
          ((c)paramMessage.obj).a(this.a.i());
        }
        return;
      }
    }
    if ((paramMessage.what == 2) && (!this.a.d()))
    {
      paramMessage = (u)paramMessage.obj;
      paramMessage.a();
      paramMessage.c();
      return;
    }
    if ((paramMessage.what == 2) || (paramMessage.what == 1))
    {
      ((u)paramMessage.obj).b();
      return;
    }
    Log.wtf("GmsClient", "Don't know how to handle this message.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */