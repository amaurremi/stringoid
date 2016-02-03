package com.inmobi.androidsdk.impl.net;

import com.inmobi.androidsdk.IMAdRequest.EducationType;
import com.inmobi.androidsdk.IMAdRequest.EthnicityType;
import com.inmobi.androidsdk.IMAdRequest.GenderType;
import com.inmobi.androidsdk.impl.SDKUtil;
import com.inmobi.androidsdk.impl.UserInfo;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class HttpRequestBuilder
{
  private static String a(UserInfo paramUserInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramUserInfo.getScreenDensity() != null) {
      localStringBuilder.append("&d-device-screen-density=").append(getURLEncoded(paramUserInfo.getScreenDensity()));
    }
    if (paramUserInfo.getScreenSize() != null) {
      localStringBuilder.append("&d-device-screen-size=").append(getURLEncoded(paramUserInfo.getScreenSize()));
    }
    return localStringBuilder.toString();
  }
  
  private static String a(UserInfo paramUserInfo, WifiInfo paramWifiInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramUserInfo.getPostalCode() != null)
    {
      localStringBuilder.append("u-postalCode=");
      localStringBuilder.append(getURLEncoded(paramUserInfo.getPostalCode()));
    }
    if (SDKUtil.getQAMode())
    {
      localStringBuilder.append("&mk-carrier=117.97.87.6");
      localStringBuilder.append("&x-real-ip=117.97.87.6");
    }
    if (paramUserInfo.getRequestParams() != null)
    {
      localObject = paramUserInfo.getRequestParams().entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localStringBuilder.append("&").append(getURLEncoded(((String)localEntry.getKey()).toString())).append("=").append(getURLEncoded(((String)localEntry.getValue()).toString()));
      }
    }
    if (paramUserInfo.getAreaCode() != null)
    {
      localStringBuilder.append("&u-areaCode=");
      localStringBuilder.append(getURLEncoded(paramUserInfo.getAreaCode()));
    }
    if (paramUserInfo.getDateOfBirth() != null)
    {
      localStringBuilder.append("&u-dateOfBirth=");
      localStringBuilder.append(getURLEncoded(paramUserInfo.getDateOfBirth()));
    }
    if ((paramUserInfo.getGender() != IMAdRequest.GenderType.NONE) && (paramUserInfo.getGender() != null))
    {
      localStringBuilder.append("&u-gender=");
      if (paramUserInfo.getGender() != IMAdRequest.GenderType.MALE) {
        break label610;
      }
    }
    for (Object localObject = "M";; localObject = "F")
    {
      localStringBuilder.append((String)localObject);
      if (paramUserInfo.getKeywords() != null)
      {
        localStringBuilder.append("&p-keywords=");
        localStringBuilder.append(getURLEncoded(paramUserInfo.getKeywords()));
      }
      if (paramUserInfo.getSearchString() != null)
      {
        localStringBuilder.append("&p-type=");
        localStringBuilder.append(getURLEncoded(paramUserInfo.getSearchString()));
      }
      if (paramUserInfo.getIncome() > 0)
      {
        localStringBuilder.append("&u-income=");
        localStringBuilder.append(paramUserInfo.getIncome());
      }
      if ((paramUserInfo.getEducation() != IMAdRequest.EducationType.Edu_None) && (paramUserInfo.getEducation() != null))
      {
        localStringBuilder.append("&u-education=");
        localStringBuilder.append(paramUserInfo.getEducation());
      }
      if ((paramUserInfo.getEthnicity() != IMAdRequest.EthnicityType.Eth_None) && (paramUserInfo.getEthnicity() != null))
      {
        localStringBuilder.append("&u-ethnicity=");
        localStringBuilder.append(paramUserInfo.getEthnicity());
      }
      if (paramUserInfo.getAge() > 0)
      {
        localStringBuilder.append("&u-age=");
        localStringBuilder.append(paramUserInfo.getAge());
      }
      if (paramUserInfo.getInterests() != null)
      {
        localStringBuilder.append("&u-interests=");
        localStringBuilder.append(getURLEncoded(paramUserInfo.getInterests()));
      }
      if (paramUserInfo.getLocationWithCityStateCountry() != null)
      {
        localStringBuilder.append("&u-location=");
        localStringBuilder.append(getURLEncoded(paramUserInfo.getLocationWithCityStateCountry()));
      }
      if (paramUserInfo.getRefreshType() != -1)
      {
        localStringBuilder.append("&u-rt=");
        localStringBuilder.append(getURLEncoded(String.valueOf(paramUserInfo.getRefreshType())));
      }
      paramUserInfo = Calendar.getInstance();
      System.currentTimeMillis();
      localStringBuilder.append("&ts=" + paramUserInfo.getTimeInMillis());
      localStringBuilder.append("&tz=" + paramUserInfo.get(15));
      if (paramWifiInfo != null) {
        localStringBuilder.append("&c-ap-bssid=" + paramWifiInfo.bssid);
      }
      paramWifiInfo = localStringBuilder.toString();
      paramUserInfo = paramWifiInfo;
      try
      {
        if (paramWifiInfo.charAt(0) == '&') {
          paramUserInfo = paramWifiInfo.substring(1);
        }
        return paramUserInfo;
      }
      catch (Exception paramUserInfo)
      {
        label610:
        Log.debug("InMobiAndroidSDK_3.7.1", "Couldn't build post string in IMHttpRequestBuilder", paramUserInfo);
      }
    }
    return paramWifiInfo;
  }
  
  static String a(UserInfo paramUserInfo, WifiInfo paramWifiInfo, RequestResponseManager.ActionType paramActionType)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      try
      {
        paramWifiInfo = a(paramUserInfo, paramWifiInfo);
        if (RequestResponseManager.ActionType.AdRequest != paramActionType) {
          continue;
        }
        localStringBuffer.append("requestactivity=AdRequest");
        if ((paramWifiInfo != null) && (!paramWifiInfo.equalsIgnoreCase(""))) {
          localStringBuffer.append("&" + paramWifiInfo);
        }
        localStringBuffer.append(a(paramUserInfo));
        localStringBuffer.append("&" + b(paramUserInfo));
      }
      catch (Exception paramUserInfo)
      {
        Log.debug("InMobiAndroidSDK_3.7.1", "Exception occured in an ad request" + paramUserInfo);
        continue;
      }
      return localStringBuffer.toString();
      if (RequestResponseManager.ActionType.AdRequest_Interstitial == paramActionType) {
        localStringBuffer.append("adtype=int");
      }
    }
  }
  
  private static String b(UserInfo paramUserInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramUserInfo.getSiteId() != null)
    {
      localStringBuilder.append("mk-siteid=");
      localStringBuilder.append(getURLEncoded(paramUserInfo.getSiteId()));
    }
    if (paramUserInfo.getUIDMapEncrypted() != null)
    {
      localStringBuilder.append("&u-id-map=");
      localStringBuilder.append(getURLEncoded(paramUserInfo.getUIDMapEncrypted()));
      localStringBuilder.append("&u-id-key=");
      localStringBuilder.append(paramUserInfo.getRandomKey());
      localStringBuilder.append("&u-key-ver=");
      localStringBuilder.append(paramUserInfo.getRsakeyVersion());
    }
    if (paramUserInfo.getAid() != null)
    {
      localStringBuilder.append("&aid=");
      localStringBuilder.append(getURLEncoded(paramUserInfo.getAid()));
    }
    localStringBuilder.append("&mk-version=");
    localStringBuilder.append(getURLEncoded("pr-SAND-DTHTB-20132006"));
    localStringBuilder.append("&mk-rel-version=");
    localStringBuilder.append(getURLEncoded("pr-SAND-DTHTB-20132006"));
    localStringBuilder.append("&format=imai");
    localStringBuilder.append("&mk-ads=1");
    localStringBuilder.append("&h-user-agent=");
    localStringBuilder.append(getURLEncoded(paramUserInfo.getPhoneDefaultUserAgent()));
    localStringBuilder.append("&u-appBId=");
    localStringBuilder.append(getURLEncoded(paramUserInfo.getAppBId()));
    localStringBuilder.append("&u-appDNM=");
    localStringBuilder.append(getURLEncoded(paramUserInfo.getAppDisplayName()));
    localStringBuilder.append("&u-appVer=");
    localStringBuilder.append(getURLEncoded(paramUserInfo.getAppVer()));
    localStringBuilder.append("&d-localization=");
    localStringBuilder.append(getURLEncoded(paramUserInfo.getLocalization()));
    if (paramUserInfo.getNetworkType() != null)
    {
      localStringBuilder.append("&d-netType=");
      localStringBuilder.append(getURLEncoded(paramUserInfo.getNetworkType()));
    }
    if (paramUserInfo.getOrientation() != 0)
    {
      localStringBuilder.append("&d-orientation=");
      localStringBuilder.append(paramUserInfo.getOrientation());
    }
    localStringBuilder.append("&mk-ad-slot=");
    localStringBuilder.append(getURLEncoded(paramUserInfo.getAdUnitSlot()));
    if (paramUserInfo.getSlotId() != null)
    {
      localStringBuilder.append("&mk-site-slotid=");
      localStringBuilder.append(getURLEncoded(paramUserInfo.getSlotId()));
    }
    if (paramUserInfo.isValidGeoInfo())
    {
      localStringBuilder.append("&u-latlong-accu=");
      localStringBuilder.append(getURLEncoded(currentLocationStr(paramUserInfo)));
      localStringBuilder.append("&u-ll-ts=");
      localStringBuilder.append(paramUserInfo.getGeoTS());
    }
    if ((paramUserInfo.getRefTagKey() != null) && (paramUserInfo.getRefTagValue() != null)) {
      localStringBuilder.append("&").append(getURLEncoded(paramUserInfo.getRefTagKey())).append("=").append(getURLEncoded(paramUserInfo.getRefTagValue()));
    }
    return localStringBuilder.toString();
  }
  
  public static String currentLocationStr(UserInfo paramUserInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((localStringBuilder != null) && (paramUserInfo.isValidGeoInfo()))
    {
      localStringBuilder.append(paramUserInfo.getLat());
      localStringBuilder.append(",");
      localStringBuilder.append(paramUserInfo.getLon());
      localStringBuilder.append(",");
      localStringBuilder.append((int)paramUserInfo.getLocAccuracy());
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static String getURLDecoded(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = URLDecoder.decode(paramString1, paramString2);
      return paramString1;
    }
    catch (Exception paramString1) {}
    return "";
  }
  
  public static String getURLEncoded(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/impl/net/HttpRequestBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */