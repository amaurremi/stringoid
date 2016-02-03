package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

final class op
  extends Handler
{
  public op(hb paramhb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (!this.a.isConnecting()))
    {
      paramMessage = (hb.b)paramMessage.obj;
      paramMessage.fu();
      paramMessage.unregister();
      return;
    }
    if (paramMessage.what == 3)
    {
      hb.a(this.a).a(new ConnectionResult(((Integer)paramMessage.obj).intValue(), null));
      return;
    }
    if (paramMessage.what == 4)
    {
      hb.a(this.a, 1);
      hb.a(this.a, null);
      hb.a(this.a).ao(((Integer)paramMessage.obj).intValue());
      return;
    }
    if ((paramMessage.what == 2) && (!this.a.isConnected()))
    {
      paramMessage = (hb.b)paramMessage.obj;
      paramMessage.fu();
      paramMessage.unregister();
      return;
    }
    if ((paramMessage.what == 2) || (paramMessage.what == 1))
    {
      ((hb.b)paramMessage.obj).fv();
      return;
    }
    Log.wtf("GmsClient", "Don't know how to handle this message.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/op.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */