package com.ideashower.readitlater.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.i.c;
import com.pocket.billing.google.h;
import com.pocket.c.e;

public class ConnectionReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = g.k();
    if (bool)
    {
      if (e.o() == 2) {
        a.a(paramContext, FlushSendBatchService.class);
      }
      if ((com.pocket.m.a.a(false)) && (i.a(com.ideashower.readitlater.h.a.H)) && (!g.l())) {
        com.pocket.m.a.d(true);
      }
      h.a(null);
    }
    for (;;)
    {
      c.a(bool);
      return;
      com.pocket.m.a.d(i.a(com.ideashower.readitlater.h.a.H));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/service/ConnectionReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */