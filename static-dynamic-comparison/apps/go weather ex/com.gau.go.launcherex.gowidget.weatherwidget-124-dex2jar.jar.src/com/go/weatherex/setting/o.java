package com.go.weatherex.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class o
  extends BroadcastReceiver
{
  private o(m paramm) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext.equals("android.intent.action.PACKAGE_ADDED")) || (paramContext.equals("android.intent.action.PACKAGE_REMOVED")) || (paramContext.equals("android.intent.action.PACKAGE_REPLACED")))
    {
      paramContext = paramIntent.getDataString();
      if ((paramContext != null) && (paramContext.startsWith("package:com.gau.go.weatherex.language.")))
      {
        m.b(this.a);
        m.c(this.a);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */