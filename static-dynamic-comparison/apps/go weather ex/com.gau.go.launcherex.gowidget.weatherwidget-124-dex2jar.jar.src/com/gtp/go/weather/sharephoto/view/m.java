package com.gtp.go.weather.sharephoto.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gtp.go.weather.sharephoto.b.h;
import com.gtp.go.weather.sharephoto.b.p;
import java.util.Iterator;
import java.util.List;

class m
  extends BroadcastReceiver
{
  m(g paramg) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i;
    if (paramIntent != null)
    {
      long l = paramIntent.getLongExtra("extra_change_photo_id", -1L);
      i = paramIntent.getIntExtra("extra_change_type", 1);
      int j = paramIntent.getIntExtra("extra_change_value", -1);
      if (i != 1) {
        break label113;
      }
      paramContext = g.a(this.a).iterator();
      while (paramContext.hasNext())
      {
        paramIntent = ((h)paramContext.next()).b(l);
        if (paramIntent != null)
        {
          if (j != 1) {
            break label107;
          }
          bool = true;
          paramIntent.a(bool);
          paramIntent.a(j);
          this.a.notifyDataSetChanged();
        }
      }
    }
    label107:
    label113:
    while (i != 2) {
      for (;;)
      {
        return;
        boolean bool = false;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/view/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */