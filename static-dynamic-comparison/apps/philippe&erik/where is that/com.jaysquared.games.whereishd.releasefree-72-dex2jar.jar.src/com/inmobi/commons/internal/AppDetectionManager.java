package com.inmobi.commons.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.ThinICEConfig;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppDetectionManager
{
  public static JSONArray getInstalledApps()
  {
    Object localObject;
    for (;;)
    {
      try
      {
        if ((!AnalyticsInitializer.getConfigParams().getThinIceConfig().isAppDetectionEnabled()) || (FileOperations.getLongPreferences(InternalSDKUtil.getContext(), "AppDetectionPrefs", "AppDetectionCollectionTimestamp") + AnalyticsInitializer.getConfigParams().getThinIceConfig().getAppDetectionInterval() >= System.currentTimeMillis())) {
          break label192;
        }
        localObject = InternalSDKUtil.getContext().getPackageManager();
        JSONArray localJSONArray1 = new JSONArray();
        localObject = ((PackageManager)localObject).getInstalledApplications(128).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        ApplicationInfo localApplicationInfo = (ApplicationInfo)((Iterator)localObject).next();
        JSONObject localJSONObject = new JSONObject();
        String str = localApplicationInfo.packageName;
        boolean bool;
        if ((localApplicationInfo.flags & 0x1) != 0)
        {
          bool = true;
          localJSONObject.put("a-bid", str);
          localJSONObject.put("a-system", bool);
          localJSONArray1.put(localJSONObject);
        }
        else
        {
          bool = false;
        }
      }
      catch (Exception localException)
      {
        Log.internal("[InMobi]-4.1.1", "Exception fetching app meta data", localException);
        localObject = null;
        return (JSONArray)localObject;
      }
    }
    JSONArray localJSONArray2;
    if (localException.length() == 0) {
      localJSONArray2 = null;
    }
    for (;;)
    {
      localObject = localJSONArray2;
      if (localJSONArray2 == null) {
        break;
      }
      FileOperations.setPreferences(InternalSDKUtil.getContext(), "AppDetectionPrefs", "AppDetectionCollectionTimestamp", System.currentTimeMillis());
      return localJSONArray2;
    }
    label192:
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/internal/AppDetectionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */