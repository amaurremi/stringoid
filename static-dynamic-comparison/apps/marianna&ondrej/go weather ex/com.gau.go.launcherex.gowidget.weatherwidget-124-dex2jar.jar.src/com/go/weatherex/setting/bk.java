package com.go.weatherex.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.d.f;

class bk
  extends BroadcastReceiver
{
  private bk(bb parambb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    while ((!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE")) || (!GoWidgetApplication.b(this.a.getActivity().getApplicationContext()).b())) {
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */