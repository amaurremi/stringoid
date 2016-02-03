package com.inmobi.androidsdk.impl.net;

import android.os.Build.VERSION;
import android.view.MotionEvent;
import com.inmobi.androidsdk.IMAdRequest.EducationType;
import com.inmobi.androidsdk.IMAdRequest.EthnicityType;
import com.inmobi.androidsdk.IMAdRequest.GenderType;
import com.inmobi.androidsdk.ai.container.IMWrapperFunctions;
import com.inmobi.androidsdk.impl.IMUserInfo;
import com.inmobi.commons.internal.IMLog;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class IMHttpRequestBuilder
{
  private static String a(IMUserInfo paramIMUserInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramIMUserInfo.getPostalCode() != null)
    {
      localStringBuilder.append("u-postalCode=");
      localStringBuilder.append(getURLEncoded(paramIMUserInfo.getPostalCode()));
    }
    if (paramIMUserInfo.getRequestParams() != null)
    {
      localObject = paramIMUserInfo.getRequestParams().entrySet().iterator();
      if (((Iterator)localObject).hasNext()) {}
    }
    else
    {
      if (paramIMUserInfo.getAreaCode() != null)
      {
        localStringBuilder.append("&u-areaCode=");
        localStringBuilder.append(getURLEncoded(paramIMUserInfo.getAreaCode()));
      }
      if (paramIMUserInfo.getDateOfBirth() != null)
      {
        localStringBuilder.append("&u-dateOfBirth=");
        localStringBuilder.append(getURLEncoded(paramIMUserInfo.getDateOfBirth()));
      }
      if ((paramIMUserInfo.getGender() != IMAdRequest.GenderType.NONE) && (paramIMUserInfo.getGender() != null))
      {
        localStringBuilder.append("&u-gender=");
        if (paramIMUserInfo.getGender() != IMAdRequest.GenderType.MALE) {
          break label492;
        }
      }
    }
    label492:
    for (Object localObject = "M";; localObject = "F")
    {
      localStringBuilder.append((String)localObject);
      if (paramIMUserInfo.getKeywords() != null)
      {
        localStringBuilder.append("&p-keywords=");
        localStringBuilder.append(getURLEncoded(paramIMUserInfo.getKeywords()));
      }
      if (paramIMUserInfo.getSearchString() != null)
      {
        localStringBuilder.append("&p-type=");
        localStringBuilder.append(getURLEncoded(paramIMUserInfo.getSearchString()));
      }
      if (paramIMUserInfo.getIncome() > 0)
      {
        localStringBuilder.append("&u-income=");
        localStringBuilder.append(paramIMUserInfo.getIncome());
      }
      if ((paramIMUserInfo.getEducation() != IMAdRequest.EducationType.Edu_None) && (paramIMUserInfo.getEducation() != null))
      {
        localStringBuilder.append("&u-education=");
        localStringBuilder.append(paramIMUserInfo.getEducation());
      }
      if ((paramIMUserInfo.getEthnicity() != IMAdRequest.EthnicityType.Eth_None) && (paramIMUserInfo.getEthnicity() != null))
      {
        localStringBuilder.append("&u-ethnicity=");
        localStringBuilder.append(paramIMUserInfo.getEthnicity());
      }
      if (paramIMUserInfo.getAge() > 0)
      {
        localStringBuilder.append("&u-age=");
        localStringBuilder.append(paramIMUserInfo.getAge());
      }
      if (paramIMUserInfo.getInterests() != null)
      {
        localStringBuilder.append("&u-interests=");
        localStringBuilder.append(getURLEncoded(paramIMUserInfo.getInterests()));
      }
      if (paramIMUserInfo.getLocationWithCityStateCountry() != null)
      {
        localStringBuilder.append("&u-location=");
        localStringBuilder.append(getURLEncoded(paramIMUserInfo.getLocationWithCityStateCountry()));
      }
      if (paramIMUserInfo.getRefreshType() != -1)
      {
        localStringBuilder.append("&u-rt=");
        localStringBuilder.append(getURLEncoded(String.valueOf(paramIMUserInfo.getRefreshType())));
      }
      localObject = localStringBuilder.toString();
      paramIMUserInfo = (IMUserInfo)localObject;
      try
      {
        if (((String)localObject).charAt(0) == '&') {
          paramIMUserInfo = ((String)localObject).substring(1);
        }
        return paramIMUserInfo;
      }
      catch (Exception paramIMUserInfo) {}
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localStringBuilder.append("&").append(getURLEncoded(((String)localEntry.getKey()).toString())).append("=").append(getURLEncoded(((String)localEntry.getValue()).toString()));
      break;
    }
    return (String)localObject;
  }
  
  static String a(IMUserInfo paramIMUserInfo, IMRequestResponseManager.ActionType paramActionType)
  {
    localStringBuffer = new StringBuffer();
    for (;;)
    {
      try
      {
        if (IMRequestResponseManager.ActionType.AdRequest != paramActionType) {
          continue;
        }
        paramActionType = a(paramIMUserInfo);
        localStringBuffer.append("requestactivity=AdRequest");
        if ((paramActionType != null) && (!paramActionType.equalsIgnoreCase(""))) {
          localStringBuffer.append("&" + paramActionType);
        }
      }
      catch (Exception paramIMUserInfo)
      {
        IMLog.debug("InMobiAndroidSDK_3.6.1", "Exception occured in an ad request" + paramIMUserInfo);
        continue;
        if (IMRequestResponseManager.ActionType.DeviceInfoUpload != paramActionType) {
          continue;
        }
        localStringBuffer.append("requestactivity=DeviceInfo");
        continue;
        localStringBuffer.append("requestactivity=AdClicked");
        continue;
      }
      localStringBuffer.append(b(paramIMUserInfo));
      localStringBuffer.append("&" + c(paramIMUserInfo));
      return localStringBuffer.toString();
      if (IMRequestResponseManager.ActionType.AdRequest_Interstitial != paramActionType) {
        continue;
      }
      paramActionType = a(paramIMUserInfo);
      localStringBuffer.append("adtype=int");
      if ((paramActionType != null) && (!paramActionType.equalsIgnoreCase(""))) {
        localStringBuffer.append("&" + paramActionType);
      }
    }
  }
  
  public static String appendClickParams(String paramString1, MotionEvent paramMotionEvent, String paramString2)
  {
    Object localObject2 = null;
    Float localFloat = null;
    Object localObject1 = paramString1;
    for (;;)
    {
      float f;
      try
      {
        f = Float.parseFloat("1.0");
        localObject1 = paramString1;
        if (paramMotionEvent == null) {
          break;
        }
        localObject1 = paramString1;
        if (Build.VERSION.SDK_INT < 12) {
          break label504;
        }
        if (paramString2 == null) {
          break label495;
        }
        localObject1 = paramString1;
        localObject3 = Float.valueOf(Float.parseFloat(paramString2));
        localObject1 = paramString1;
        paramString2 = IMWrapperFunctions.getTapLocationX(paramMotionEvent);
        if (paramString2 != null)
        {
          localObject1 = paramString1;
          localObject2 = Float.valueOf(Float.parseFloat(paramString2));
          localObject1 = paramString1;
          String str = IMWrapperFunctions.getTapLocationY(paramMotionEvent);
          if (str != null)
          {
            localObject1 = paramString1;
            localFloat = Float.valueOf(Float.parseFloat(str));
          }
          if (localObject2 != null)
          {
            localObject1 = paramString1;
            paramString2 = Float.toString(((Float)localObject2).floatValue() / ((Float)localObject3).floatValue());
          }
          localObject2 = str;
          if (localFloat != null)
          {
            localObject1 = paramString1;
            localObject2 = Float.toString(localFloat.floatValue() / ((Float)localObject3).floatValue());
          }
          localObject1 = paramString1;
          paramMotionEvent = IMWrapperFunctions.getTapSize(paramMotionEvent);
          localObject3 = paramString2;
          paramString2 = paramMotionEvent;
          localObject1 = paramString1;
          if (paramString1.contains("?"))
          {
            paramMotionEvent = paramString1;
            if (localObject3 != null)
            {
              paramMotionEvent = paramString1;
              if (localObject2 != null)
              {
                localObject1 = paramString1;
                paramMotionEvent = paramString1 + "&" + "u-tap-o" + "=" + getURLEncoded(new StringBuilder(String.valueOf(localObject3)).append(",").append((String)localObject2).toString());
              }
            }
            localObject1 = paramMotionEvent;
            if (paramString2 == null) {
              break;
            }
            localObject1 = paramMotionEvent;
            return paramMotionEvent + "&" + "u-tap-size" + "=" + getURLEncoded(paramString2);
          }
          if ((localObject3 != null) && (localObject2 != null))
          {
            localObject1 = paramString1;
            paramString1 = paramString1 + "?" + "u-tap-o" + "=" + getURLEncoded(new StringBuilder(String.valueOf(localObject3)).append(",").append((String)localObject2).toString());
            localObject1 = paramString1;
            if (paramString2 == null) {
              break;
            }
            localObject1 = paramString1;
            return paramString1 + "&" + "u-tap-size" + "=" + getURLEncoded(paramString2);
          }
          localObject1 = paramString1;
          if (paramString2 == null) {
            break;
          }
          localObject1 = paramString1;
          paramString1 = paramString1 + "?" + "u-tap-size" + "=" + getURLEncoded(paramString2);
          return paramString1;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return (String)localObject1;
      }
      localObject2 = null;
      continue;
      label495:
      Object localObject3 = Float.valueOf(f);
      continue;
      label504:
      paramMotionEvent = null;
      localObject3 = null;
      paramString2 = (String)localObject2;
      localObject2 = paramMotionEvent;
    }
    return (String)localObject1;
  }
  
  private static String b(IMUserInfo paramIMUserInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramIMUserInfo.getScreenDensity() != null) {
      localStringBuilder.append("&d-device-screen-density=").append(getURLEncoded(paramIMUserInfo.getScreenDensity()));
    }
    if (paramIMUserInfo.getScreenSize() != null) {
      localStringBuilder.append("&d-device-screen-size=").append(getURLEncoded(paramIMUserInfo.getScreenSize()));
    }
    return localStringBuilder.toString();
  }
  
  private static String c(IMUserInfo paramIMUserInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramIMUserInfo.getSiteId() != null)
    {
      localStringBuilder.append("mk-siteid=");
      localStringBuilder.append(getURLEncoded(paramIMUserInfo.getSiteId()));
    }
    if (paramIMUserInfo.getUIDMapEncrypted() != null)
    {
      localStringBuilder.append("&u-id-map=");
      localStringBuilder.append(getURLEncoded(paramIMUserInfo.getUIDMapEncrypted()));
      localStringBuilder.append("&u-id-key=");
      localStringBuilder.append(paramIMUserInfo.getRandomKey());
      localStringBuilder.append("&u-key-ver=");
      localStringBuilder.append(paramIMUserInfo.getRsakeyVersion());
    }
    if (paramIMUserInfo.getAid() != null)
    {
      localStringBuilder.append("&aid=");
      localStringBuilder.append(getURLEncoded(paramIMUserInfo.getAid()));
    }
    localStringBuilder.append("&mk-version=");
    localStringBuilder.append(getURLEncoded("pr-SAND-DTGTB-20121104"));
    localStringBuilder.append("&mk-rel-version=");
    localStringBuilder.append(getURLEncoded("pr-SAND-DTGTB-20121104"));
    localStringBuilder.append("&format=xhtml");
    localStringBuilder.append("&mk-ads=1");
    localStringBuilder.append("&h-user-agent=");
    localStringBuilder.append(getURLEncoded(paramIMUserInfo.getPhoneDefaultUserAgent()));
    localStringBuilder.append("&u-appBId=");
    localStringBuilder.append(getURLEncoded(paramIMUserInfo.getAppBId()));
    localStringBuilder.append("&u-appDNM=");
    localStringBuilder.append(getURLEncoded(paramIMUserInfo.getAppDisplayName()));
    localStringBuilder.append("&u-appVer=");
    localStringBuilder.append(getURLEncoded(paramIMUserInfo.getAppVer()));
    localStringBuilder.append("&d-localization=");
    localStringBuilder.append(getURLEncoded(paramIMUserInfo.getLocalization()));
    if (paramIMUserInfo.getNetworkType() != null)
    {
      localStringBuilder.append("&d-netType=");
      localStringBuilder.append(getURLEncoded(paramIMUserInfo.getNetworkType()));
    }
    if (paramIMUserInfo.getOrientation() != 0)
    {
      localStringBuilder.append("&d-orientation=");
      localStringBuilder.append(paramIMUserInfo.getOrientation());
    }
    localStringBuilder.append("&mk-ad-slot=");
    localStringBuilder.append(getURLEncoded(paramIMUserInfo.getAdUnitSlot()));
    if (paramIMUserInfo.getSlotId() != null)
    {
      localStringBuilder.append("&mk-site-slotid=");
      localStringBuilder.append(getURLEncoded(paramIMUserInfo.getSlotId()));
    }
    if (paramIMUserInfo.isValidGeoInfo())
    {
      localStringBuilder.append("&u-latlong-accu=");
      localStringBuilder.append(getURLEncoded(currentLocationStr(paramIMUserInfo)));
    }
    if ((paramIMUserInfo.getRefTagKey() != null) && (paramIMUserInfo.getRefTagValue() != null)) {
      localStringBuilder.append("&").append(getURLEncoded(paramIMUserInfo.getRefTagKey())).append("=").append(getURLEncoded(paramIMUserInfo.getRefTagValue()));
    }
    return localStringBuilder.toString();
  }
  
  public static String currentLocationStr(IMUserInfo paramIMUserInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((localStringBuilder != null) && (paramIMUserInfo.isValidGeoInfo()))
    {
      localStringBuilder.append(paramIMUserInfo.getLat());
      localStringBuilder.append(",");
      localStringBuilder.append(paramIMUserInfo.getLon());
      localStringBuilder.append(",");
      localStringBuilder.append((int)paramIMUserInfo.getLocAccuracy());
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/impl/net/IMHttpRequestBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */