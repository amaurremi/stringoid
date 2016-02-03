package com.inmobi.commons.network;

import com.inmobi.commons.EducationType;
import com.inmobi.commons.EthnicityType;
import com.inmobi.commons.GenderType;
import com.inmobi.commons.HasChildren;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.MaritalStatus;
import com.inmobi.commons.SexualOrientation;
import com.inmobi.commons.data.AppInfo;
import com.inmobi.commons.data.DemogInfo;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.data.LocationInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.thinICE.cellular.CellTowerInfo;
import com.inmobi.commons.thinICE.cellular.CellUtil;
import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import com.inmobi.commons.uid.UID;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RequestBuilderUtils {
    public static final String KEY_MK_SITE_ID = "mk-siteid";
    public static final String KEY_MK_SITE_SLOT_ID = "mk-site-slotid";
    public static final String RULE_ID = "rule-id";

    private static String a(Calendar paramCalendar) {
        String str = null;
        if (paramCalendar != null) {
            str = paramCalendar.get(1) + "-" + (paramCalendar.get(2) + 1) + "-" + paramCalendar.get(5);
        }
        return str;
    }

    public static void fillAppInfoMap(Map<String, Object> paramMap) {
        if (AppInfo.getAppBId() != null) {
            paramMap.put("u-appbid", AppInfo.getAppBId());
        }
        if (AppInfo.getAppDisplayName() != null) {
            paramMap.put("u-appDNM", AppInfo.getAppDisplayName());
        }
        if (AppInfo.getAppVer() != null) {
            paramMap.put("u-appver", AppInfo.getAppVer());
        }
    }

    public static void fillDemogMap(Map<String, Object> paramMap) {
        if (paramMap != null) {
            if (DemogInfo.getAge().intValue() > 0) {
                paramMap.put("u-age", DemogInfo.getAge());
            }
            if (DemogInfo.getPostalCode() != null) {
                paramMap.put("u-postalCode", DemogInfo.getPostalCode());
            }
            if (DemogInfo.getAreaCode() != null) {
                paramMap.put("u-areaCode", DemogInfo.getAreaCode());
            }
            if (DemogInfo.getDateOfBirth() != null) {
                paramMap.put("u-dateOfBirth", a(DemogInfo.getDateOfBirth()));
            }
            if (DemogInfo.getEducation() != null) {
                paramMap.put("u-education", DemogInfo.getEducation().toString().toLowerCase(Locale.getDefault()));
            }
            if (DemogInfo.getEthnicity() != null) {
                paramMap.put("u-ethnicity", DemogInfo.getEthnicity().toString().toLowerCase(Locale.getDefault()));
            }
            if (DemogInfo.getGender() != null) {
                paramMap.put("u-gender", DemogInfo.getGender().toString().toLowerCase(Locale.getDefault()));
            }
            if (DemogInfo.getHasChildren() != null) {
                paramMap.put("u-haschildren", DemogInfo.getHasChildren().toString().toLowerCase(Locale.getDefault()));
            }
            if (DemogInfo.getIncome().intValue() > 0) {
                paramMap.put("u-income", DemogInfo.getIncome());
            }
            if (DemogInfo.getInterests() != null) {
                paramMap.put("u-interests", DemogInfo.getInterests());
            }
            if (DemogInfo.getLanguage() != null) {
                paramMap.put("u-language", DemogInfo.getLanguage());
            }
            if (DemogInfo.getLocationWithCityStateCountry() != null) {
                paramMap.put("u-location", DemogInfo.getLocationWithCityStateCountry());
            }
            if (DemogInfo.getMaritalStatus() != null) {
                paramMap.put("u-marital", DemogInfo.getMaritalStatus().toString().toLowerCase(Locale.getDefault()));
            }
            if (DemogInfo.getSexualOrientation() != null) {
                paramMap.put("u-sexualorientation", DemogInfo.getSexualOrientation().toString().toLowerCase(Locale.getDefault()));
            }
        }
    }

    public static void fillDeviceMap(Map<String, Object> paramMap) {
        if (paramMap != null) {
            if (DeviceInfo.getScreenDensity() != null) {
                paramMap.put("d-device-screen-density", DeviceInfo.getScreenDensity());
            }
            if (DeviceInfo.getScreenSize() != null) {
                paramMap.put("d-device-screen-size", DeviceInfo.getScreenSize());
            }
            paramMap.put("d-orientation", Integer.valueOf(DeviceInfo.getOrientation()));
            if (DeviceInfo.getNetworkType() != null) {
                paramMap.put("d-netType", DeviceInfo.getNetworkType());
            }
            if (DeviceInfo.getLocalization() != null) {
                paramMap.put("d-localization", DeviceInfo.getLocalization());
            }
        }
    }

    public static void fillIdentityMap(Map<String, Object> paramMap, Map<String, Boolean> paramMap1, boolean paramBoolean) {
        if (paramMap != null) {
            paramMap.put("mk-siteid", InMobi.getAppId());
            String str = "pr-SAND-" + InternalSDKUtil.getInMobiInternalVersion("4.5.1") + "-" + "20140918";
            paramMap.put("mk-version", str);
            paramMap.put("mk-rel-version", str);
            if ((DeviceInfo.getPhoneDefaultUserAgent() != null) && (!"".equals(DeviceInfo.getPhoneDefaultUserAgent()))) {
                paramMap.put("h-user-agent", DeviceInfo.getPhoneDefaultUserAgent());
            }
            if (!UID.getInstance().isLimitAdTrackingEnabled()) {
                break label232;
            }
            paramMap.put("u-id-adt", Integer.valueOf(1));
            if (!paramBoolean) {
                break label249;
            }
            paramMap1 = UID.getInstance().getMapForEncryption(paramMap1);
            if (paramMap1 != null) {
                paramMap.putAll(paramMap1);
            }
        }
        for (; ; ) {
            paramMap1 = Calendar.getInstance();
            System.currentTimeMillis();
            paramMap.put("ts", Long.valueOf(paramMap1.getTimeInMillis()));
            int i = paramMap1.get(15);
            paramMap.put("tz", Integer.valueOf(paramMap1.get(16) + i));
            if ((InternalSDKUtil.getLtvpSessionId() != null) && (!InternalSDKUtil.getLtvpSessionId().equals(""))) {
                paramMap.put("u-s-id", InternalSDKUtil.getLtvpSessionId());
            }
            return;
            label232:
            paramMap.put("u-id-adt", Integer.valueOf(0));
            break;
            label249:
            paramMap.remove("u-id-key");
            paramMap.remove("u-key-ver");
            paramMap.put("u-id-map", UID.getInstance().getJSON(paramMap1));
        }
    }

    public static void fillLocationMap(Map<String, Object> paramMap) {
        Object localObject;
        if (paramMap != null) {
            localObject = LocationInfo.currentLocationStr();
            if ((localObject != null) && (!"".equals(localObject))) {
                paramMap.put("u-latlong-accu", localObject);
                if (LocationInfo.getGeoTS() > 0L) {
                    paramMap.put("u-ll-ts", Long.valueOf(LocationInfo.getGeoTS()));
                }
                paramMap.put("sdk-collected", Integer.valueOf(LocationInfo.isSDKSetLocation()));
            }
            if (!DemogInfo.isLocationInquiryAllowed()) {
                break label235;
            }
        }
        for (int i = 1; ; i = 0) {
            paramMap.put("loc-allowed", Integer.valueOf(i));
            localObject = null;
            try {
                WifiInfo localWifiInfo = IceDataCollector.getConnectedWifiInfo(InternalSDKUtil.getContext());
                localObject = localWifiInfo;
            } catch (Exception localException3) {
                for (; ; ) {
                    label235:
                    Log.internal("[InMobi]-4.5.1", "No wifi permissions set, unable to send wifi data");
                }
            }
            if (localObject != null) {
                paramMap.put("c-ap-bssid", Long.valueOf(((WifiInfo) localObject).bssid));
            }
            for (; ; ) {
                try {
                    localObject = IceDataCollector.getVisbleWifiInfoBssId(InternalSDKUtil.getContext());
                    if ((localObject != null) && (((List) localObject).size() != 0)) {
                        paramMap.put("v-ap-bssid", InternalSDKUtil.convertListToDelimitedString((List) localObject, ","));
                    }
                } catch (Exception localException1) {
                    Log.internal("[InMobi]-4.5.1", "Couldn't get cell tower info in Request Builder", localException1);
                    continue;
                }
                try {
                    localObject = CellUtil.getVisibleCellTowerIds(InternalSDKUtil.getContext());
                    if ((localObject != null) && (((List) localObject).size() != 0)) {
                        paramMap.put("v-sid", InternalSDKUtil.convertListToDelimitedString((List) localObject, ","));
                    }
                } catch (Exception localException2) {
                    Log.internal("[InMobi]-4.5.1", "Couldn't get cell tower info in Request Builder", localException2);
                    continue;
                }
                try {
                    localObject = CellUtil.getCurrentCellTower(InternalSDKUtil.getContext()).id;
                    if ((localObject != null) && (!"".equals(localObject))) {
                        paramMap.put("c-sid", localObject);
                    }
                    return;
                } catch (Exception paramMap) {
                    Log.internal("[InMobi]-4.5.1", "Couldn't get cell tower info in Request Builder", paramMap);
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/network/RequestBuilderUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */