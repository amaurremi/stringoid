package com.inmobi.commons.internal;

import android.content.Context;
import com.inmobi.commons.thinICE.cellular.CellOperatorInfo;
import com.inmobi.commons.thinICE.cellular.CellUtil;
import com.inmobi.commons.thinICE.icedatacollector.Sample;
import com.inmobi.commons.thinICE.icedatacollector.ThinICEConfigSettings;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import com.inmobi.commons.uid.UIDUtil;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONPayloadCreator
  implements PayloadCreator
{
  private JSONObject a(Sample paramSample, ThinICEConfig paramThinICEConfig)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      if (paramThinICEConfig.k) {
        localJSONObject1.put("c-ap", a(paramSample.connectedWifiAp));
      }
      if (paramThinICEConfig.j) {
        localJSONObject1.put("c-sid", paramSample.servingCellId);
      }
      if (paramThinICEConfig.l)
      {
        paramThinICEConfig = new JSONArray();
        if (paramSample.visibleWifiAp != null) {
          break label106;
        }
      }
      for (;;)
      {
        if (paramThinICEConfig.length() > 0) {
          localJSONObject1.put("v-ap", paramThinICEConfig);
        }
        if (localJSONObject1.length() <= 1) {
          break;
        }
        localJSONObject1.put("ts", paramSample.utc);
        return localJSONObject1;
        label106:
        Iterator localIterator = paramSample.visibleWifiAp.iterator();
        while (localIterator.hasNext())
        {
          JSONObject localJSONObject2 = a((WifiInfo)localIterator.next());
          if (localJSONObject2 != null) {
            paramThinICEConfig.put(localJSONObject2);
          }
        }
      }
      return null;
    }
    catch (JSONException paramSample)
    {
      return null;
    }
  }
  
  private JSONObject a(WifiInfo paramWifiInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bssid", String.format("0x%012x", new Object[] { Long.valueOf(paramWifiInfo.bssid) }));
      localJSONObject.put("essid", paramWifiInfo.ssid);
      localJSONObject.put("rssi", paramWifiInfo.rssi);
      return localJSONObject;
    }
    catch (Exception paramWifiInfo) {}
    return null;
  }
  
  public String toPayloadString(List<Sample> paramList, Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    ThinICEConfig localThinICEConfig = InternalSDKUtil.a.getTic();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localJSONArray.put(a((Sample)paramList.next(), localThinICEConfig));
    }
    try
    {
      if (localJSONArray.length() > 0) {
        localJSONObject.put("payload", localJSONArray);
      }
      paramList = CellUtil.getCellNetworkInfo(paramContext);
      if ((!ThinICEConfigSettings.bitTest(localThinICEConfig.g, 1)) && ((paramList.simMcc != -1) || (paramList.simMnc != -1))) {
        localJSONObject.put("s-ho", paramList.simMcc + "_" + paramList.simMnc);
      }
      if ((!ThinICEConfigSettings.bitTest(localThinICEConfig.g, 2)) && ((paramList.currentMcc != -1) || (paramList.currentMnc != -1))) {
        localJSONObject.put("s-co", paramList.currentMcc + "_" + paramList.currentMnc);
      }
      paramList = Calendar.getInstance();
      System.currentTimeMillis();
      localJSONObject.put("tz", paramList.get(15));
      localJSONObject.put("ts", paramList.getTimeInMillis());
      UIDUtil.bindToJSON(UIDUtil.getMap(paramContext, null), localJSONObject);
      return localJSONObject.toString();
    }
    catch (JSONException paramList)
    {
      Log.debug("IMCOMMONS_3.7.1", "Unable to create payload for sending ThinICE params");
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/commons/internal/JSONPayloadCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */