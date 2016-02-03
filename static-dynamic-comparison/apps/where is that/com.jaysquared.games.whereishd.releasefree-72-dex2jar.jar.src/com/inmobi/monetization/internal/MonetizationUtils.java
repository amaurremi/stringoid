package com.inmobi.monetization.internal;

import android.view.View;
import com.inmobi.androidsdk.AdRequest;
import com.inmobi.androidsdk.AdRequest.ErrorCode;
import com.inmobi.commons.data.UserInfo;
import com.inmobi.commons.internal.ActivityRecognitionManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.internal.objects.LtvpRuleCache;
import java.util.HashMap;
import java.util.Map;

public class MonetizationUtils
{
  public static Map<String, String> buildLtvpRequestMap(View paramView)
  {
    HashMap localHashMap = new HashMap();
    String str = LtvpRuleCache.getInstance(InternalSDKUtil.getContext()).getLtvpRuleId();
    if (str != null) {
      localHashMap.put("rule-id", str);
    }
    if (paramView != null) {
      localHashMap.put("placement-size", paramView.getWidth() + "x" + paramView.getHeight());
    }
    int i = ActivityRecognitionManager.getDetectedActivity();
    if (i != -1) {
      localHashMap.put("u-activity-type", i + "");
    }
    return localHashMap;
  }
  
  public static IMErrorCode getErrorCode(AdRequest.ErrorCode paramErrorCode)
  {
    switch (a.a[paramErrorCode.ordinal()])
    {
    default: 
      return IMErrorCode.INTERNAL_ERROR;
    case 1: 
      return IMErrorCode.INTERNAL_ERROR;
    case 2: 
      return IMErrorCode.INTERNAL_ERROR;
    case 3: 
      return IMErrorCode.INTERNAL_ERROR;
    case 4: 
      return IMErrorCode.INTERNAL_ERROR;
    case 5: 
      return IMErrorCode.INTERNAL_ERROR;
    case 6: 
      return IMErrorCode.INVALID_REQUEST;
    case 7: 
      return IMErrorCode.INVALID_REQUEST;
    case 8: 
      return IMErrorCode.NETWORK_ERROR;
    }
    return IMErrorCode.NO_FILL;
  }
  
  public static void updateIMAdRequest(AdRequest paramAdRequest)
  {
    UserInfo localUserInfo = UserInfo.getInstance();
    Integer localInteger = localUserInfo.getAge();
    if (localInteger != null) {
      paramAdRequest.setAge(localInteger.intValue());
    }
    paramAdRequest.setAreaCode(localUserInfo.getAreaCode());
    paramAdRequest.setCurrentLocation(localUserInfo.getCurrentLocation());
    paramAdRequest.setDateOfBirth(localUserInfo.getDateOfBirth());
    paramAdRequest.setEducation(localUserInfo.getEducation());
    paramAdRequest.setEthnicity(localUserInfo.getEthnicity());
    paramAdRequest.setGender(localUserInfo.getGender());
    localInteger = localUserInfo.getIncome();
    if (localInteger != null) {
      paramAdRequest.setIncome(localInteger.intValue());
    }
    paramAdRequest.setInterests(localUserInfo.getInterests());
    paramAdRequest.setLocationInquiryAllowed(localUserInfo.isLocationInquiryAllowed());
    paramAdRequest.setLocationOfCityStateAndCountry(localUserInfo.getLocationWithCityStateCountry());
    paramAdRequest.setPostalCode(localUserInfo.getPostalCode());
    paramAdRequest.setSearchString(localUserInfo.getSearchString());
    paramAdRequest.setHasChildren(localUserInfo.getHasChildren());
    paramAdRequest.setLanguage(localUserInfo.getLanguage());
    paramAdRequest.setMaritalStatus(localUserInfo.getMaritalStatus());
    paramAdRequest.setSexualOrientation(localUserInfo.getSexualOrientation());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/internal/MonetizationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */