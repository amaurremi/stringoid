package com.vungle.sdk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.vungle.sdk.ak;
import com.vungle.sdk.ba;
import com.vungle.sdk.e;

public final class a
  extends BroadcastReceiver
{
  private static final IntentFilter a = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
  private static final a b = new a();
  private boolean c;
  
  public static a a()
  {
    return b;
  }
  
  private void a(boolean paramBoolean)
  {
    Context localContext;
    String str;
    if (this.c != paramBoolean)
    {
      localContext = ak.e();
      if (!this.c) {
        break label34;
      }
      str = e.t;
      localContext.unregisterReceiver(this);
    }
    for (;;)
    {
      this.c = paramBoolean;
      return;
      label34:
      str = e.t;
      localContext.registerReceiver(this, a);
    }
  }
  
  public final void b()
  {
    if (!ba.e(ak.e())) {
      Thread.currentThread().getName();
    }
    try
    {
      if ((!this.c) && (!ba.e(ak.e()))) {
        a(true);
      }
      for (;;)
      {
        boolean bool = this.c;
        if (!bool) {
          break;
        }
        try
        {
          wait();
        }
        catch (InterruptedException localInterruptedException) {}
      }
      return;
    }
    finally {}
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction())) && (!paramIntent.getBooleanExtra("noConnectivity", false)) && (!paramIntent.getBooleanExtra("isFailover", false))) {
      paramContext = e.t;
    }
    try
    {
      a(false);
      notifyAll();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */