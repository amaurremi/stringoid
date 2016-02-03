package com.inmobi.androidsdk.impl.net;

import com.inmobi.androidsdk.impl.SDKUtil;
import com.inmobi.androidsdk.impl.UserInfo;
import com.inmobi.commons.EducationType;
import com.inmobi.commons.EthnicityType;
import com.inmobi.commons.GenderType;
import com.inmobi.commons.HasChildren;
import com.inmobi.commons.MaritalStatus;
import com.inmobi.commons.SexualOrientation;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.thinICE.cellular.CellTowerInfo;
import com.inmobi.commons.thinICE.cellular.CellUtil;
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
    try
    {
      Object localObject = new StringBuilder();
      if (paramUserInfo.getScreenDensity() != null) {
        ((StringBuilder)localObject).append("d-device-screen-density=").append(getURLEncoded(paramUserInfo.getScreenDensity()));
      }
      if (paramUserInfo.getScreenSize() != null) {
        ((StringBuilder)localObject).append("&d-device-screen-size=").append(getURLEncoded(paramUserInfo.getScreenSize()));
      }
      localObject = ((StringBuilder)localObject).toString();
      paramUserInfo = (UserInfo)localObject;
      if (((String)localObject).charAt(0) == '&') {
        paramUserInfo = ((String)localObject).substring(1);
      }
      return paramUserInfo;
    }
    catch (Exception paramUserInfo)
    {
      Log.internal("[InMobi]-[Network]-4.1.1", "Couldn't build post string in IMHttpRequestBuilder", paramUserInfo);
    }
    return null;
  }
  
  private static String a(UserInfo paramUserInfo, WifiInfo paramWifiInfo)
  {
    StringBuilder localStringBuilder;
    Object localObject;
    try
    {
      localStringBuilder = new StringBuilder();
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
          continue;
          return paramUserInfo;
        }
      }
    }
    catch (Exception paramUserInfo)
    {
      Log.internal("[InMobi]-[Network]-4.1.1", "Couldn't build post string in IMHttpRequestBuilder", paramUserInfo);
      paramUserInfo = null;
    }
    do
    {
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
      if (paramUserInfo.getGender() != null)
      {
        localStringBuilder.append("&u-gender=");
        localStringBuilder.append(paramUserInfo.getGender().toString().toLowerCase());
      }
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
      if (paramUserInfo.getEducation() != null)
      {
        localStringBuilder.append("&u-education=");
        localStringBuilder.append(paramUserInfo.getEducation().toString().toLowerCase());
      }
      if (paramUserInfo.getEthnicity() != null)
      {
        localStringBuilder.append("&u-ethnicity=");
        localStringBuilder.append(paramUserInfo.getEthnicity().toString().toLowerCase());
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
      if (paramUserInfo.getMaritalStatus() != null)
      {
        localStringBuilder.append("&u-marital=");
        localStringBuilder.append(paramUserInfo.getMaritalStatus().toString().toLowerCase());
      }
      if (paramUserInfo.getHasChildren() != null)
      {
        localStringBuilder.append("&u-haschildren=");
        localStringBuilder.append(paramUserInfo.getHasChildren().toString().toLowerCase());
      }
      if (paramUserInfo.getLanguage() != null)
      {
        localStringBuilder.append("&u-language=");
        localStringBuilder.append(getURLEncoded(paramUserInfo.getLanguage()));
      }
      if (paramUserInfo.getSexualOrientation() != null)
      {
        localStringBuilder.append("&u-sexualorientation=");
        localStringBuilder.append(paramUserInfo.getSexualOrientation().toString().toLowerCase());
      }
      paramUserInfo = Calendar.getInstance();
      System.currentTimeMillis();
      localStringBuilder.append("&ts=" + paramUserInfo.getTimeInMillis());
      localObject = localStringBuilder.append("&tz=");
      int i = paramUserInfo.get(15);
      ((StringBuilder)localObject).append(paramUserInfo.get(16) + i);
      if (paramWifiInfo != null) {
        localStringBuilder.append("&c-ap-bssid=" + paramWifiInfo.bssid);
      }
      try
      {
        paramUserInfo = CellUtil.getCurrentCellTower(InternalSDKUtil.getContext()).id;
        if ((paramUserInfo != null) && (!"".equals(paramUserInfo))) {
          localStringBuilder.append("&c-sid=" + paramUserInfo);
        }
      }
      catch (Exception paramUserInfo)
      {
        for (;;)
        {
          Log.internal("[InMobi]-[Network]-4.1.1", "Exception getting cell tower id", paramUserInfo);
        }
      }
      paramWifiInfo = localStringBuilder.toString();
      paramUserInfo = paramWifiInfo;
    } while (paramWifiInfo.charAt(0) != '&');
    return paramWifiInfo.substring(1);
  }
  
  private static String b(UserInfo paramUserInfo)
  {
    try
    {
      Object localObject = new StringBuilder();
      if (paramUserInfo.getSiteId() != null)
      {
        ((StringBuilder)localObject).append("mk-siteid=");
        ((StringBuilder)localObject).append(getURLEncoded(paramUserInfo.getSiteId()));
      }
      if (paramUserInfo.getUIDMapEncrypted() != null)
      {
        ((StringBuilder)localObject).append("&u-id-map=");
        ((StringBuilder)localObject).append(getURLEncoded(paramUserInfo.getUIDMapEncrypted()));
        ((StringBuilder)localObject).append("&u-id-key=");
        ((StringBuilder)localObject).append(paramUserInfo.getRandomKey());
        ((StringBuilder)localObject).append("&u-key-ver=");
        ((StringBuilder)localObject).append(paramUserInfo.getRsakeyVersion());
      }
      if (paramUserInfo.getAid() != null)
      {
        ((StringBuilder)localObject).append("&aid=");
        ((StringBuilder)localObject).append(getURLEncoded(paramUserInfo.getAid()));
      }
      ((StringBuilder)localObject).append("&mk-version=");
      String str = "pr-SAND-" + InternalSDKUtil.getInMobiInternalVersion("4.1.1") + "-" + "20140131";
      ((StringBuilder)localObject).append(getURLEncoded(str));
      ((StringBuilder)localObject).append("&mk-rel-version=");
      ((StringBuilder)localObject).append(getURLEncoded(str));
      ((StringBuilder)localObject).append("&format=imai");
      ((StringBuilder)localObject).append("&mk-ads=1");
      ((StringBuilder)localObject).append("&h-user-agent=");
      ((StringBuilder)localObject).append(getURLEncoded(paramUserInfo.getPhoneDefaultUserAgent()));
      ((StringBuilder)localObject).append("&u-appbid=");
      ((StringBuilder)localObject).append(getURLEncoded(paramUserInfo.getAppBId()));
      ((StringBuilder)localObject).append("&u-appDNM=");
      ((StringBuilder)localObject).append(getURLEncoded(paramUserInfo.getAppDisplayName()));
      ((StringBuilder)localObject).append("&u-appver=");
      ((StringBuilder)localObject).append(getURLEncoded(paramUserInfo.getAppVer()));
      ((StringBuilder)localObject).append("&d-localization=");
      ((StringBuilder)localObject).append(getURLEncoded(paramUserInfo.getLocalization()));
      if (paramUserInfo.getNetworkType() != null)
      {
        ((StringBuilder)localObject).append("&d-netType=");
        ((StringBuilder)localObject).append(getURLEncoded(paramUserInfo.getNetworkType()));
      }
      if (paramUserInfo.getOrientation() != 0)
      {
        ((StringBuilder)localObject).append("&d-orientation=");
        ((StringBuilder)localObject).append(paramUserInfo.getOrientation());
      }
      ((StringBuilder)localObject).append("&mk-ad-slot=");
      ((StringBuilder)localObject).append(getURLEncoded(paramUserInfo.getAdUnitSlot()));
      if (paramUserInfo.getSlotId() != null)
      {
        ((StringBuilder)localObject).append("&mk-site-slotid=");
        ((StringBuilder)localObject).append(getURLEncoded(paramUserInfo.getSlotId()));
      }
      if (paramUserInfo.isValidGeoInfo())
      {
        ((StringBuilder)localObject).append("&u-latlong-accu=");
        ((StringBuilder)localObject).append(getURLEncoded(currentLocationStr(paramUserInfo)));
        ((StringBuilder)localObject).append("&u-ll-ts=");
        ((StringBuilder)localObject).append(paramUserInfo.getGeoTS());
      }
      if ((paramUserInfo.getRefTagKey() != null) && (paramUserInfo.getRefTagValue() != null)) {
        ((StringBuilder)localObject).append("&").append(getURLEncoded(paramUserInfo.getRefTagKey())).append("=").append(getURLEncoded(paramUserInfo.getRefTagValue()));
      }
      localObject = ((StringBuilder)localObject).toString();
      paramUserInfo = (UserInfo)localObject;
      if (((String)localObject).charAt(0) == '&') {
        paramUserInfo = ((String)localObject).substring(1);
      }
      return paramUserInfo;
    }
    catch (Exception paramUserInfo)
    {
      Log.internal("[InMobi]-[Network]-4.1.1", "Couldn't build post string in IMHttpRequestBuilder", paramUserInfo);
    }
    return null;
  }
  
  public static String buildPostBody(UserInfo paramUserInfo, WifiInfo paramWifiInfo, RequestResponseManager.ActionType paramActionType)
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
        paramWifiInfo = a(paramUserInfo);
        if ((paramWifiInfo != null) && (!"".equals(paramWifiInfo))) {
          localStringBuffer.append("&" + paramWifiInfo);
        }
        paramUserInfo = b(paramUserInfo);
        if ((paramUserInfo != null) && (!"".equals(paramUserInfo))) {
          localStringBuffer.append("&" + paramUserInfo);
        }
      }
      catch (Exception paramUserInfo)
      {
        Log.debug("[InMobi]-[Network]-4.1.1", "Exception occured in an ad request" + paramUserInfo);
        continue;
      }
      return localStringBuffer.toString();
      if (RequestResponseManager.ActionType.AdRequest_Interstitial == paramActionType) {
        localStringBuffer.append("adtype=int");
      }
    }
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/androidsdk/impl/net/HttpRequestBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */