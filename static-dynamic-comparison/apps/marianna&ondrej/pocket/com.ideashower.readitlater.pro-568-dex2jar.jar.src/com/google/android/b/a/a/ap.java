package com.google.android.b.a.a;

import android.os.Handler;
import android.os.Message;
import com.google.android.b.a.b;
import java.util.ArrayList;

final class ap
  extends Handler
{
  ap(ao paramao) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 3) {
      this.a.a((b)paramMessage.obj);
    }
    do
    {
      return;
      if (paramMessage.what == 4) {
        synchronized (ao.a(this.a))
        {
          if ((ao.b(this.a)) && (this.a.f()) && (ao.a(this.a).contains(paramMessage.obj))) {
            ((aw)paramMessage.obj).a();
          }
          return;
        }
      }
    } while (((paramMessage.what == 2) && (!this.a.f())) || ((paramMessage.what != 2) && (paramMessage.what != 1)));
    ((aq)paramMessage.obj).a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/a/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */