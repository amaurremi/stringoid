package com.inmobi.commons.analytics.net;

import android.os.Handler;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.internal.Log;

final class a
  implements AnalyticsConnectivityReceiver.a
{
  public void a()
  {
    Log.internal("[InMobi]-[Analytics]-4.1.1", "Connectivity gone");
  }
  
  public void b()
  {
    Log.internal("[InMobi]-[Analytics]-4.1.1", "Connectivity came");
    if ((AnalyticsNetworkManager.a() != null) && (!AnalyticsUtils.getStartHandle()))
    {
      AnalyticsUtils.setStartHandle(true);
      AnalyticsNetworkManager.a().sendEmptyMessageDelayed(1001, AnalyticsUtils.getTimeinterval());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/net/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */