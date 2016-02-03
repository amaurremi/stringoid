package com.jiubang.core.c.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gtp.a.a.b.c;
import com.gtp.a.a.c.d;

class e
  extends BroadcastReceiver
{
  e(b paramb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getAction();
      if (!TextUtils.isEmpty(paramIntent)) {
        break label22;
      }
    }
    label22:
    do
    {
      return;
      paramIntent = null;
      break;
      c.a("DownloadManager", "action = " + paramIntent);
    } while (!"android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent));
    b.a(this.a, d.b(paramContext));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/c/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */