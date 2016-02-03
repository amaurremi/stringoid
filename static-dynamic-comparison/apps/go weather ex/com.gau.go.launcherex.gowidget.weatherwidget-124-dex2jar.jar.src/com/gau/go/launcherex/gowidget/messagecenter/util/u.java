package com.gau.go.launcherex.gowidget.messagecenter.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.d.g;

class u
  extends BroadcastReceiver
{
  private u(m paramm) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    long l;
    do
    {
      do
      {
        do
        {
          return;
          if (paramContext.equals("android.intent.action.MSGCENTER_SHOWMSG"))
          {
            this.a.c(new v(this));
            return;
          }
          if (!paramContext.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            break;
          }
        } while ((!i.b(m.a(this.a))) || (!g.a(m.a(this.a))));
        this.a.a(1);
        i.a(false, m.a(this.a));
        return;
        if (paramContext.equals("action_update_message"))
        {
          if (g.a(m.a(this.a)))
          {
            this.a.a(1);
            return;
          }
          i.a(true, m.a(this.a));
          return;
        }
      } while ((!paramContext.equals("android.intent.action.TIME_SET")) && (!paramContext.equals("android.intent.action.TIMEZONE_CHANGED")));
      l = i.c(m.a(this.a));
    } while (System.currentTimeMillis() >= l);
    i.a(0L, m.a(this.a));
    this.a.a(1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */