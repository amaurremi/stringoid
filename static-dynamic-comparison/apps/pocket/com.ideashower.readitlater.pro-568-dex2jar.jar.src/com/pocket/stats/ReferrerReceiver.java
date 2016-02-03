package com.pocket.stats;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.i;
import org.apache.a.c.k;

public class ReferrerReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (!k.a(paramIntent.getAction(), "com.android.vending.INSTALL_REFERRER"))) {}
    do
    {
      return;
      paramContext = paramIntent.getStringExtra("referrer");
    } while ((paramContext == null) || (paramContext.length() == 0));
    i.a(a.cl, paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/stats/ReferrerReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */