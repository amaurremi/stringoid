package com.inmobi.commons.internal;

import android.content.Context;
import android.telephony.NeighboringCellInfo;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.ThinICEConfig;
import com.inmobi.commons.data.DemogInfo;
import com.inmobi.commons.data.LocationInfo;
import com.inmobi.commons.thinICE.cellular.CellOperatorInfo;
import com.inmobi.commons.thinICE.cellular.CellTowerInfo;
import com.inmobi.commons.thinICE.cellular.CellUtil;
import com.inmobi.commons.thinICE.icedatacollector.Sample;
import com.inmobi.commons.thinICE.icedatacollector.ThinICEConfigSettings;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import com.inmobi.commons.uid.UID;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONPayloadCreator
        implements PayloadCreator {
    private JSONObject a(NeighboringCellInfo paramNeighboringCellInfo) {
        JSONObject localJSONObject = new JSONObject();
        try {
            localJSONObject.put("id", paramNeighboringCellInfo.getCid());
            if (paramNeighboringCellInfo.getRssi() != 0) {
                localJSONObject.put("ss", paramNeighboringCellInfo.getRssi());
            }
            return localJSONObject;
        } catch (JSONException paramNeighboringCellInfo) {
        }
        return null;
    }

    private JSONObject a(ActivityRecognitionSampler.ActivitySample paramActivitySample) {
        try {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("t", 3);
            localJSONObject.put("ts", paramActivitySample.getTimestamp());
            localJSONObject.put("a", paramActivitySample.getActivity());
            return localJSONObject;
        } catch (Exception paramActivitySample) {
        }
        return null;
    }

    private JSONObject a(CellTowerInfo paramCellTowerInfo) {
        JSONObject localJSONObject = new JSONObject();
        try {
            localJSONObject.put("id", paramCellTowerInfo.id);
            if (paramCellTowerInfo.signalStrength != 0) {
                localJSONObject.put("ss", paramCellTowerInfo.signalStrength);
            }
            return localJSONObject;
        } catch (Exception paramCellTowerInfo) {
        }
        return null;
    }

    private JSONObject a(Sample paramSample, ThinICEConfig paramThinICEConfig) {
        try {
            JSONObject localJSONObject1 = new JSONObject();
            localJSONObject1.put("t", 1);
            if (paramThinICEConfig.isConnectedWifiEnabled()) {
                localJSONObject1.put("c-ap", a(paramSample.connectedWifiAp));
            }
            if (paramThinICEConfig.isCellEnabled()) {
                localJSONObject1.put("c-sc", a(paramSample.connectedCellTowerInfo));
            }
            Object localObject1;
            Object localObject2;
            if (paramThinICEConfig.isVisibleCellTowerEnabled()) {
                localObject1 = new JSONArray();
                if (paramSample.visibleCellTowerInfo != null) {
                    localObject2 = paramSample.visibleCellTowerInfo.iterator();
                    while (((Iterator) localObject2).hasNext()) {
                        JSONObject localJSONObject2 = a((NeighboringCellInfo) ((Iterator) localObject2).next());
                        if (localJSONObject2 != null) {
                            ((JSONArray) localObject1).put(localJSONObject2);
                        }
                    }
                    if (((JSONArray) localObject1).length() > 0) {
                        localJSONObject1.put("v-sc", localObject1);
                    }
                }
            }
            if (paramThinICEConfig.isVisibleWifiEnabled()) {
                paramThinICEConfig = new JSONArray();
                if (paramSample.visibleWifiAp != null) {
                    localObject1 = paramSample.visibleWifiAp.iterator();
                    while (((Iterator) localObject1).hasNext()) {
                        localObject2 = a((WifiInfo) ((Iterator) localObject1).next());
                        if (localObject2 != null) {
                            paramThinICEConfig.put(localObject2);
                        }
                    }
                }
                if (paramThinICEConfig.length() > 0) {
                    localJSONObject1.put("v-ap", paramThinICEConfig);
                }
            }
            if (localJSONObject1.length() > 1) {
                localJSONObject1.put("ts", paramSample.utc);
                return localJSONObject1;
            }
            return null;
        } catch (JSONException paramSample) {
        }
        return null;
    }

    private JSONObject a(WifiInfo paramWifiInfo) {
        JSONObject localJSONObject = new JSONObject();
        try {
            localJSONObject.put("bssid", paramWifiInfo.bssid);
            localJSONObject.put("essid", paramWifiInfo.ssid);
            return localJSONObject;
        } catch (Exception paramWifiInfo) {
        }
        return null;
    }

    public String toPayloadString(List<Sample> paramList, List<ActivityRecognitionSampler.ActivitySample> paramList1, Context paramContext) {
        Object localObject1 = AnalyticsInitializer.getConfigParams().getDeviceIdMaskMap();
        localObject1 = new JSONObject(InternalSDKUtil.getEncodedMap(UID.getInstance().getMapForEncryption((Map) localObject1)));
        JSONArray localJSONArray = new JSONArray();
        ThinICEConfig localThinICEConfig = AnalyticsInitializer.getConfigParams().getThinIceConfig();
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            Object localObject2 = (Sample) paramList.next();
            if (localObject2 != null) {
                localObject2 = a((Sample) localObject2, localThinICEConfig);
                if (localObject2 != null) {
                    localJSONArray.put(localObject2);
                }
            }
        }
        paramList = paramList1.iterator();
        while (paramList.hasNext()) {
            paramList1 = (ActivityRecognitionSampler.ActivitySample) paramList.next();
            if (paramList1 != null) {
                paramList1 = a(paramList1);
                if (paramList1 != null) {
                    localJSONArray.put(paramList1);
                }
            }
        }
        try {
            if (localJSONArray.length() > 0) {
                ((JSONObject) localObject1).put("payload", localJSONArray);
            }
            paramList = CellUtil.getCellNetworkInfo(paramContext);
            if (localThinICEConfig.isOperatorEnabled()) {
                if ((!ThinICEConfigSettings.bitTest(localThinICEConfig.getCellOpsFlag(), 1)) && ((paramList.simMcc != -1) || (paramList.simMnc != -1))) {
                    ((JSONObject) localObject1).put("s-ho", paramList.simMcc + "_" + paramList.simMnc);
                }
                if ((!ThinICEConfigSettings.bitTest(localThinICEConfig.getCellOpsFlag(), 2)) && ((paramList.currentMcc != -1) || (paramList.currentMnc != -1))) {
                    ((JSONObject) localObject1).put("s-co", paramList.currentMcc + "_" + paramList.currentMnc);
                }
            }
            paramList = Calendar.getInstance();
            System.currentTimeMillis();
            ((JSONObject) localObject1).put("tz", paramList.get(15) + paramList.get(16));
            ((JSONObject) localObject1).put("ts", paramList.getTimeInMillis());
            ((JSONObject) localObject1).put("mk-version", "pr-SAND-" + InternalSDKUtil.getInMobiInternalVersion("4.5.1") + "-" + "20140918");
            paramList = LocationInfo.currentLocationStr();
            if ((paramList != null) && (!"".equals(paramList))) {
                ((JSONObject) localObject1).put("u-latlong-accu", paramList);
                if (LocationInfo.isValidGeoInfo()) {
                    long l = LocationInfo.getGeoTS();
                    if (l != 0L) {
                        ((JSONObject) localObject1).put("u-ll-ts", l);
                    }
                }
            }
            if ((InternalSDKUtil.getLtvpSessionId() != null) && (!InternalSDKUtil.getLtvpSessionId().equals(""))) {
                ((JSONObject) localObject1).put("u-s-id", InternalSDKUtil.getLtvpSessionId());
            }
            if (DemogInfo.isLocationInquiryAllowed()) {
            }
            for (int i = 1; ; i = 0) {
                ((JSONObject) localObject1).put("loc-allowed", i);
                ((JSONObject) localObject1).put("sdk-collected", LocationInfo.isSDKSetLocation());
                return ((JSONObject) localObject1).toString();
            }
            return null;
        } catch (JSONException paramList) {
            Log.internal("[InMobi]-4.5.1", "Unable to create payload for sending ThinICE params");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/internal/JSONPayloadCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */