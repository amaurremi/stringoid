package com.getjar.sdk.comm.auth;

import android.content.Context;
import com.getjar.sdk.data.MetadataValue;
import com.getjar.sdk.data.MetadataValue.MetadataReliability;
import com.getjar.sdk.rewards.AdvertisingIdHelper;
import java.util.Map;

public final class AuthMetadataUtility
{
  private static final String KEY_SDK_LEVEL = "sdk.level";
  private static final String KEY_SDK_NAME = "sdk.name";
  private static final String KEY_SDK_VERSION = "sdk.version";
  public static final String SDK_LEVEL = Integer.toString(19);
  public static final int SDK_LEVEL_INT = 19;
  
  public static void addSDKMetadataValues(Map<String, MetadataValue> paramMap, Context paramContext)
  {
    if (paramMap == null) {
      throw new IllegalArgumentException("'providerData' cannot be NULL");
    }
    paramMap.put("sdk.name", new MetadataValue("GetJarSDK", MetadataValue.MetadataReliability.AVAILABLE));
    paramMap.put("sdk.version", new MetadataValue("20140923.02", MetadataValue.MetadataReliability.AVAILABLE));
    paramMap.put("sdk.level", new MetadataValue(SDK_LEVEL, MetadataValue.MetadataReliability.AVAILABLE));
    AdvertisingIdHelper localAdvertisingIdHelper = AdvertisingIdHelper.getInstance(paramContext);
    if (localAdvertisingIdHelper.hasError()) {}
    for (paramContext = MetadataValue.MetadataReliability.NOT_AVAILABLE;; paramContext = MetadataValue.MetadataReliability.AVAILABLE)
    {
      paramMap.put("android.device.google_play.ads.advertising_id", new MetadataValue(localAdvertisingIdHelper.getId(), paramContext));
      paramMap.put("android.device.google_play.ads.limit_tracking_enabled", new MetadataValue(Boolean.toString(localAdvertisingIdHelper.isLimitAdTrackingEnabled()), paramContext));
      paramMap.put("android.device.google_play.ads.retrieve_error", new MetadataValue(Boolean.toString(localAdvertisingIdHelper.hasError()), MetadataValue.MetadataReliability.AVAILABLE));
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/auth/AuthMetadataUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */