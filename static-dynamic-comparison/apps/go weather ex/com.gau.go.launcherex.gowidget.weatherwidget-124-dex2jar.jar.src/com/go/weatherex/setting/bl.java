package com.go.weatherex.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.q;

class bl
  extends BroadcastReceiver
{
  bl(bb parambb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bb.c(this.a, bb.a(this.a, bb.a(this.a).a().C));
    bb.g(this.a).setText(bb.j(this.a)[bb.k(this.a)]);
    this.a.getActivity().unregisterReceiver(this);
    bb.a(this.a, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */