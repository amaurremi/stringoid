package com.appflood;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.appflood.c.d;
import com.appflood.c.g;
import com.appflood.e.a;
import com.appflood.e.j;

public class AFReferralReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("referrer");
    j.d("onReceive: " + paramIntent.getAction() + " data " + str);
    if (!j.a(str))
    {
      com.appflood.e.c.z = str;
      a.a(paramContext, "google_refer", str);
      if ((AppFlood.isConnected()) && (!j.a(d.w))) {
        g.a().a(paramContext);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/AFReferralReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */