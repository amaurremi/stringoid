package com.mopub.nativeads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.GpsHelper;
import com.mopub.common.LocationService;
import com.mopub.common.LocationService.LocationAwareness;

class NativeUrlGenerator
  extends AdUrlGenerator
{
  private static LocationService.LocationAwareness sLocationAwareness = LocationService.LocationAwareness.NORMAL;
  private static int sLocationPrecision = 6;
  
  NativeUrlGenerator(Context paramContext)
  {
    super(paramContext);
  }
  
  public String generateUrlString(String paramString)
  {
    initUrlString(paramString, "/m/ad");
    setAdUnitId(this.mAdUnitId);
    setSdkVersion("2.0");
    setDeviceInfo(new String[] { Build.MANUFACTURER, Build.MODEL, Build.PRODUCT });
    setUdid(getUdidFromContext(this.mContext));
    setDoNotTrack(GpsHelper.isLimitAdTrackingEnabled(this.mContext));
    setKeywords(this.mKeywords);
    Location localLocation = this.mLocation;
    paramString = localLocation;
    if (localLocation == null) {
      paramString = LocationService.getLastKnownLocation(this.mContext, sLocationPrecision, sLocationAwareness);
    }
    setLocation(paramString);
    setTimezone(getTimeZoneOffsetString());
    setOrientation(this.mContext.getResources().getConfiguration().orientation);
    setDensity(this.mContext.getResources().getDisplayMetrics().density);
    paramString = getNetworkOperator();
    setMccCode(paramString);
    setMncCode(paramString);
    setIsoCountryCode(this.mTelephonyManager.getNetworkCountryIso());
    setCarrierName(this.mTelephonyManager.getNetworkOperatorName());
    setNetworkType(getActiveNetworkType());
    setAppVersion(getAppVersionFromContext(this.mContext));
    setTwitterAppInstalledFlag();
    return getFinalUrlString();
  }
  
  protected void setSdkVersion(String paramString)
  {
    addParam("nsv", paramString);
  }
  
  public NativeUrlGenerator withAdUnitId(String paramString)
  {
    this.mAdUnitId = paramString;
    return this;
  }
  
  NativeUrlGenerator withRequest(RequestParameters paramRequestParameters)
  {
    if (paramRequestParameters != null)
    {
      this.mKeywords = paramRequestParameters.getKeywords();
      this.mLocation = paramRequestParameters.getLocation();
    }
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/nativeads/NativeUrlGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */