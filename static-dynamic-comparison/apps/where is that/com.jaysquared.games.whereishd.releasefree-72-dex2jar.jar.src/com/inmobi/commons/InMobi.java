package com.inmobi.commons;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import com.inmobi.commons.analytics.androidsdk.IMAdTracker;
import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper;
import com.inmobi.commons.data.UserInfo;
import com.inmobi.commons.internal.ActivityRecognitionManager;
import com.inmobi.commons.internal.ApplicationFocusManager;
import com.inmobi.commons.internal.ApplicationFocusManager.FocusChangedListener;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.Log.INTERNAL_LOG_LEVEL;
import com.inmobi.commons.internal.ThinICE;
import java.util.Calendar;

public final class InMobi
{
  public static final int EXCLUDE_FB_ID = 4;
  public static final int EXCLUDE_ODIN1 = 2;
  public static final int EXCLUDE_UM5_ID = 8;
  public static final int ID_DEVICE_NONE = 0;
  public static final int INCLUDE_DEFAULT = 1;
  private static String a = null;
  
  public static void addIDType(IMIDType paramIMIDType, String paramString)
  {
    UserInfo.getInstance().addIDType(paramIMIDType, paramString);
  }
  
  public static String getAppId()
  {
    return a;
  }
  
  public static String getVersion()
  {
    return "4.1.1";
  }
  
  public static void initialize(Activity paramActivity, String paramString)
  {
    if (paramActivity != null) {}
    try
    {
      InternalSDKUtil.getUserAgent(paramActivity.getApplicationContext());
      if (a != null)
      {
        ThinICE.start(paramActivity);
        return;
      }
      if (paramActivity == null)
      {
        Log.debug("[InMobi]-4.1.1", "Application Context NULL");
        Log.debug("[InMobi]-4.1.1", "context cannot be null");
        return;
      }
    }
    catch (Exception paramString) {}
    for (;;)
    {
      ActivityRecognitionManager.init(paramActivity.getApplicationContext());
      UserInfo.getInstance().setActivity(paramActivity);
      UserInfo.getInstance().updateInfo();
      return;
      if (paramString == null)
      {
        Log.debug("[InMobi]-4.1.1", "APP ID Cannot be NULL");
        Log.debug("[InMobi]-4.1.1", "appId cannot be null");
        return;
      }
      if ((paramString == null) || ("".equals(paramString.trim())))
      {
        Log.debug("[InMobi]-4.1.1", "appId cannot be blank");
        return;
      }
      Context localContext = paramActivity.getApplicationContext();
      InternalSDKUtil.setContext(localContext);
      Log.debug("[InMobi]-4.1.1", "InMobi init successful");
      a = paramString.trim();
      ThinICE.start(paramActivity);
      IMAdTracker.getInstance().init(localContext, paramString);
      IMAdTracker.getInstance().reportAppDownloadGoal();
      ApplicationFocusManager.init(paramActivity);
      ApplicationFocusManager.addFocusChangedListener(new a());
      AnalyticsEventsWrapper.getInstance().startSession(a, null);
    }
  }
  
  public static void removeIDType(IMIDType paramIMIDType)
  {
    UserInfo.getInstance().removeIDType(paramIMIDType);
  }
  
  public static void setAge(int paramInt)
  {
    UserInfo.getInstance().setAge(Integer.valueOf(paramInt));
  }
  
  public static void setAreaCode(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString.trim())))
    {
      UserInfo.getInstance().setAreaCode(paramString);
      return;
    }
    Log.debug("[InMobi]-4.1.1", "Area code cannot be null");
  }
  
  public static void setCurrentLocation(Location paramLocation)
  {
    if (paramLocation != null)
    {
      UserInfo.getInstance().setCurrentLocation(paramLocation);
      return;
    }
    Log.debug("[InMobi]-4.1.1", "Location cannot be null");
  }
  
  public static void setDateOfBirth(Calendar paramCalendar)
  {
    if (paramCalendar != null)
    {
      UserInfo.getInstance().setDateOfBirth(paramCalendar);
      return;
    }
    Log.debug("[InMobi]-4.1.1", "Date Of Birth cannot be null");
  }
  
  public static void setDeviceIDMask(int paramInt)
  {
    UserInfo.getInstance().setDeviceIDMask(paramInt);
  }
  
  public static void setEducation(EducationType paramEducationType)
  {
    if (paramEducationType != null) {
      UserInfo.getInstance().setEducation(paramEducationType);
    }
  }
  
  public static void setEthnicity(EthnicityType paramEthnicityType)
  {
    if (paramEthnicityType != null) {
      UserInfo.getInstance().setEthnicity(paramEthnicityType);
    }
  }
  
  public static void setGender(GenderType paramGenderType)
  {
    if (paramGenderType != null) {
      UserInfo.getInstance().setGender(paramGenderType);
    }
  }
  
  public static void setHasChildren(HasChildren paramHasChildren)
  {
    if (paramHasChildren != null) {
      UserInfo.getInstance().setHasChildren(paramHasChildren);
    }
  }
  
  public static void setIncome(int paramInt)
  {
    UserInfo.getInstance().setIncome(Integer.valueOf(paramInt));
  }
  
  public static void setInterests(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString.trim())))
    {
      UserInfo.getInstance().setInterests(paramString);
      return;
    }
    Log.debug("[InMobi]-4.1.1", "Interests cannot be null");
  }
  
  public static void setLanguage(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString.trim())))
    {
      UserInfo.getInstance().setLanguage(paramString);
      return;
    }
    Log.debug("[InMobi]-4.1.1", "Language cannot be null");
  }
  
  public static void setLocationInquiryAllowed(boolean paramBoolean)
  {
    UserInfo.getInstance().setLocationInquiryAllowed(paramBoolean);
  }
  
  public static void setLocationWithCityStateCountry(String paramString1, String paramString2, String paramString3)
  {
    UserInfo.getInstance().setLocationWithCityStateCountry(paramString1, paramString2, paramString3);
  }
  
  public static void setLogLevel(LOG_LEVEL paramLOG_LEVEL)
  {
    if (paramLOG_LEVEL == LOG_LEVEL.NONE)
    {
      Log.setInternalLogLevel(Log.INTERNAL_LOG_LEVEL.NONE);
      return;
    }
    if (paramLOG_LEVEL == LOG_LEVEL.DEBUG)
    {
      Log.setInternalLogLevel(Log.INTERNAL_LOG_LEVEL.DEBUG);
      return;
    }
    Log.setInternalLogLevel(Log.INTERNAL_LOG_LEVEL.INTERNAL);
  }
  
  public static void setMaritalStatus(MaritalStatus paramMaritalStatus)
  {
    if (paramMaritalStatus != null) {
      UserInfo.getInstance().setMaritalStatus(paramMaritalStatus);
    }
  }
  
  public static void setPostalCode(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString.trim())))
    {
      UserInfo.getInstance().setPostalCode(paramString);
      return;
    }
    Log.debug("[InMobi]-4.1.1", "Postal Code cannot be null");
  }
  
  public static void setSexualOrientation(SexualOrientation paramSexualOrientation)
  {
    if (paramSexualOrientation != null) {
      UserInfo.getInstance().setSexualOrientation(paramSexualOrientation);
    }
  }
  
  public static enum LOG_LEVEL
  {
    private final int a;
    
    private LOG_LEVEL(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int getValue()
    {
      return this.a;
    }
  }
  
  static final class a
    implements ApplicationFocusManager.FocusChangedListener
  {
    public void onFocusChanged(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        AnalyticsEventsWrapper.getInstance().startSession(InMobi.a(), null);
        return;
      }
      AnalyticsEventsWrapper.getInstance().endSession(null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/InMobi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */