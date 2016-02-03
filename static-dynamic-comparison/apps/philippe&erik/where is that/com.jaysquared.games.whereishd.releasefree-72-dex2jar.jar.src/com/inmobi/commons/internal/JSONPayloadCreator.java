package com.inmobi.commons.internal;

import android.content.Context;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.ThinICEConfig;
import com.inmobi.commons.data.LocationInfo;
import com.inmobi.commons.thinICE.cellular.CellOperatorInfo;
import com.inmobi.commons.thinICE.cellular.CellTowerInfo;
import com.inmobi.commons.thinICE.cellular.CellUtil;
import com.inmobi.commons.thinICE.icedatacollector.Sample;
import com.inmobi.commons.thinICE.icedatacollector.ThinICEConfigSettings;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import com.inmobi.commons.uid.UIDUtil;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONPayloadCreator
  implements PayloadCreator
{
  private JSONObject a()
  {
    JSONArray localJSONArray = AppDetectionManager.getInstalledApps();
    if ((localJSONArray == null) || (localJSONArray.length() == 0)) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("t", 2);
      localJSONObject.put("ts", System.currentTimeMillis());
      localJSONObject.put("a-meta", localJSONArray);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private JSONObject a(ActivityRecognitionSampler.ActivitySample paramActivitySample)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("t", 3);
      localJSONObject.put("ts", paramActivitySample.getTimestamp());
      localJSONObject.put("a", paramActivitySample.getActivity());
      return localJSONObject;
    }
    catch (Exception paramActivitySample) {}
    return null;
  }
  
  private JSONObject a(CellTowerInfo paramCellTowerInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramCellTowerInfo.id);
      if (paramCellTowerInfo.signalStrength != 0) {
        localJSONObject.put("ss", paramCellTowerInfo.signalStrength);
      }
      return localJSONObject;
    }
    catch (Exception paramCellTowerInfo) {}
    return null;
  }
  
  private JSONObject a(Sample paramSample, ThinICEConfig paramThinICEConfig)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("t", 1);
      if (paramThinICEConfig.isConnectedWifiEnabled()) {
        localJSONObject1.put("c-ap", a(paramSample.connectedWifiAp));
      }
      if (paramThinICEConfig.isCellEnabled()) {
        localJSONObject1.put("c-sc", a(paramSample.connectedCellTowerInfo));
      }
      if (paramThinICEConfig.isVisibleWifiEnabled())
      {
        paramThinICEConfig = new JSONArray();
        if (paramSample.visibleWifiAp != null)
        {
          Iterator localIterator = paramSample.visibleWifiAp.iterator();
          while (localIterator.hasNext())
          {
            JSONObject localJSONObject2 = a((WifiInfo)localIterator.next());
            if (localJSONObject2 != null) {
              paramThinICEConfig.put(localJSONObject2);
            }
          }
        }
        if (paramThinICEConfig.length() > 0) {
          localJSONObject1.put("v-ap", paramThinICEConfig);
        }
      }
      if (localJSONObject1.length() > 1)
      {
        localJSONObject1.put("ts", paramSample.utc);
        return localJSONObject1;
      }
      return null;
    }
    catch (JSONException paramSample) {}
    return null;
  }
  
  private JSONObject a(WifiInfo paramWifiInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bssid", paramWifiInfo.bssid);
      localJSONObject.put("essid", paramWifiInfo.ssid);
      return localJSONObject;
    }
    catch (Exception paramWifiInfo) {}
    return null;
  }
  
  public static String currentLocationStr()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((localStringBuilder != null) && (LocationInfo.isValidGeoInfo()))
    {
      localStringBuilder.append(LocationInfo.getLat());
      localStringBuilder.append(",");
      localStringBuilder.append(LocationInfo.getLon());
      localStringBuilder.append(",");
      localStringBuilder.append((int)LocationInfo.getLocAccuracy());
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public String toPayloadString(List<Sample> paramList, List<ActivityRecognitionSampler.ActivitySample> paramList1, Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    ThinICEConfig localThinICEConfig = AnalyticsInitializer.getConfigParams().getThinIceConfig();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (Sample)paramList.next();
      if (localObject != null)
      {
        localObject = a((Sample)localObject, localThinICEConfig);
        if (localObject != null) {
          localJSONArray.put(localObject);
        }
      }
    }
    paramList = paramList1.iterator();
    while (paramList.hasNext())
    {
      paramList1 = (ActivityRecognitionSampler.ActivitySample)paramList.next();
      if (paramList1 != null)
      {
        paramList1 = a(paramList1);
        if (paramList1 != null) {
          localJSONArray.put(paramList1);
        }
      }
    }
    paramList = a();
    if (paramList != null) {
      localJSONArray.put(paramList);
    }
    try
    {
      if (localJSONArray.length() > 0) {
        localJSONObject.put("payload", localJSONArray);
      }
      paramList = CellUtil.getCellNetworkInfo(paramContext);
      if (localThinICEConfig.isOperatorEnabled())
      {
        if ((!ThinICEConfigSettings.bitTest(localThinICEConfig.getCellOpsFlag(), 1)) && ((paramList.simMcc != -1) || (paramList.simMnc != -1))) {
          localJSONObject.put("s-ho", paramList.simMcc + "_" + paramList.simMnc);
        }
        if ((!ThinICEConfigSettings.bitTest(localThinICEConfig.getCellOpsFlag(), 2)) && ((paramList.currentMcc != -1) || (paramList.currentMnc != -1))) {
          localJSONObject.put("s-co", paramList.currentMcc + "_" + paramList.currentMnc);
        }
      }
      paramList = Calendar.getInstance();
      System.currentTimeMillis();
      localJSONObject.put("tz", paramList.get(15) + paramList.get(16));
      localJSONObject.put("ts", paramList.getTimeInMillis());
      localJSONObject.put("mk-version", "pr-SAND-" + InternalSDKUtil.getInMobiInternalVersion("4.1.1") + "-" + "20140131");
      paramList = currentLocationStr();
      if ((paramList != null) && (!"".equals(paramList))) {
        localJSONObject.put("u-latlong-accu", paramList);
      }
      paramList = UIDUtil.getMap(paramContext, null);
      paramList.remove("ua");
      paramList.remove("s-ver");
      UIDUtil.bindToJSON(paramList, localJSONObject);
      return localJSONObject.toString();
    }
    catch (JSONException paramList)
    {
      Log.internal("[InMobi]-4.1.1", "Unable to create payload for sending ThinICE params");
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/internal/JSONPayloadCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */