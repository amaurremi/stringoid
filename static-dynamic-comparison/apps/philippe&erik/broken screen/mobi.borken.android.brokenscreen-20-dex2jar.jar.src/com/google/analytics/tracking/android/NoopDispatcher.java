package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.List;

class NoopDispatcher
  implements Dispatcher
{
  public void close() {}
  
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
      do
      {
        return i;
        k = Math.min(paramList.size(), 40);
        i = k;
      } while (!Log.isVerbose());
      Log.v("Hits not actually being sent as dispatch is false...");
      j = 0;
      i = k;
    } while (j >= k);
    String str2;
    label69:
    String str1;
    if (TextUtils.isEmpty(((Hit)paramList.get(j)).getHitParams()))
    {
      str2 = "";
      if (!TextUtils.isEmpty(str2)) {
        break label132;
      }
      str1 = "Hit couldn't be read, wouldn't be sent:";
    }
    for (;;)
    {
      Log.v(str1 + str2);
      j += 1;
      break;
      str2 = HitBuilder.postProcessHit((Hit)paramList.get(j), System.currentTimeMillis());
      break label69;
      label132:
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
  
  public void overrideHostUrl(String paramString) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/analytics/tracking/android/NoopDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */