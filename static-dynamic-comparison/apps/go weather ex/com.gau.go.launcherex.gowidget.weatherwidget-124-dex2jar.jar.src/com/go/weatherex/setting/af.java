package com.go.weatherex.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.CheckBox;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.d.f;

class af
  extends BroadcastReceiver
{
  private af(z paramz) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    while ((!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE")) || (!GoWidgetApplication.b(this.a.getActivity().getApplicationContext()).b()) || (z.g(this.a) == null) || (z.h(this.a) == null)) {
      return;
    }
    if (!z.h(this.a).isChecked())
    {
      z.h(this.a).setEnabled(true);
      z.h(this.a).setClickable(true);
      z.h(this.a).setChecked(true);
    }
    z.i(this.a).setVisibility(8);
    z.h(this.a).setVisibility(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */