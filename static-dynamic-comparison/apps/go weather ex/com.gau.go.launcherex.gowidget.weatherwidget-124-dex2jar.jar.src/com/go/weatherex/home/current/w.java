package com.go.weatherex.home.current;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.gtp.a.a.b.c;

class w
  extends BroadcastReceiver
{
  w(PollenIndex paramPollenIndex) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      paramContext = paramIntent.getAction();
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA"))
      {
        PollenIndex.a(this.a);
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DOWNLOAD_PHOTO"))
      {
        paramContext = paramIntent.getStringExtra("extra_photo_path");
        c.a("PollenIndex", "download done: " + paramContext);
        if ((paramContext != null) && (!TextUtils.isEmpty(paramContext)))
        {
          int i = 0;
          while (i < 2)
          {
            if (paramContext.equalsIgnoreCase((String)PollenIndex.b(this.a)[i].getTag())) {
              try
              {
                PollenIndex.b(this.a)[i].setImageBitmap(BitmapFactory.decodeFile(paramContext, null));
                PollenIndex.c(this.a).setVisibility(0);
                PollenIndex.d(this.a)[i].setVisibility(0);
                c.a("PollenIndex", "show: " + paramContext);
                return;
              }
              catch (Exception paramContext)
              {
                return;
              }
            }
            i += 1;
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */