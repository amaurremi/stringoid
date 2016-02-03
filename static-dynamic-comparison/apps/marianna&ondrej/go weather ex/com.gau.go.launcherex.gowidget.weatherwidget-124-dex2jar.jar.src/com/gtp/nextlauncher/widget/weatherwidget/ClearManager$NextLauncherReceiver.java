package com.gtp.nextlauncher.widget.weatherwidget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

public class ClearManager$NextLauncherReceiver
  extends BroadcastReceiver
{
  private void a(String paramString)
  {
    if (paramString.equals("com.gtp.nextlauncher")) {
      ClearManager.b(this.a);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.PACKAGE_REMOVED"))
    {
      paramContext = paramIntent.getDataString().replace("package:", "");
      boolean bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
      if ((!TextUtils.isEmpty(paramContext)) && (!bool)) {
        a(paramContext);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/ClearManager$NextLauncherReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */