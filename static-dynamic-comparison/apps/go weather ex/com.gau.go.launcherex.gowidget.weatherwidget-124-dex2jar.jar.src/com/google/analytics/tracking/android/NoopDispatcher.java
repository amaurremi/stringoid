package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.List;

class NoopDispatcher
  implements Dispatcher
{
  public int dispatchHits(List<Hit> paramList)
  {
    int i;
    if (paramList == null) {
      i = 0;
    }
    int k;
    int j;
    do
    {
      return i;
      Log.iDebug("Hits not actually being sent as dispatch is false...");
      k = Math.min(paramList.size(), 40);
      j = 0;
      i = k;
    } while (j >= k);
    String str2;
    label67:
    String str1;
    if (Log.debugEnabled())
    {
      if (!TextUtils.isEmpty(((Hit)paramList.get(j)).getHitParams())) {
        break label110;
      }
      str2 = "";
      if (!TextUtils.isEmpty(str2)) {
        break label131;
      }
      str1 = "Hit couldn't be read, wouldn't be sent:";
    }
    for (;;)
    {
      Log.iDebug(str1 + str2);
      j += 1;
      break;
      label110:
      str2 = HitBuilder.postProcessHit((Hit)paramList.get(j), System.currentTimeMillis());
      break label67;
      label131:
      if (str2.length() <= 2036) {
        str1 = "GET would be sent:";
      } else if (str2.length() > 8192) {
        str1 = "Would be too big:";
      } else {
        str1 = "POST would be sent:";
      }
    }
  }
  
  public boolean okToDispatch()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/analytics/tracking/android/NoopDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */