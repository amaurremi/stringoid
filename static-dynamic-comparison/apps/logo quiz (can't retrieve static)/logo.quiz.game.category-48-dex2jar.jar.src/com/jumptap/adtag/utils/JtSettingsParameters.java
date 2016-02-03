package com.jumptap.adtag.utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import com.jumptap.adtag.JtAdWidgetSettings;

public class JtSettingsParameters
{
  private static final String ADULT_CONTENT_TYPE = "adultContentType";
  private static final String AGE = "age";
  private static final String ALTERNATE_IMAGE = "alternateImage";
  private static final String APP_ID = "applicationId";
  private static final String APP_VER = "applicationVersion";
  private static final String BACKGROUND_COLOR = "alternateColor";
  private static final String COUNTRY = "country";
  private static final String DISMIIS_BUTTON_LABEL = "dismissLabel";
  private static final String GENDER = "gender";
  private static final String HHI = "hhi";
  private static final String HOST = "host";
  private static final String INTERDTITIAL_TIME = "interstitialTime";
  private static final String LANGUAGE = "language";
  private static final String POSTAL_CODE = "postalCode";
  private static final String PUBLISHER_ID = "publisherId";
  private static final String REFRESH_PERIOD = "refreshPeriodInSec";
  private static final String SITE_ID = "siteId";
  private static final String SPOT_ID = "spotId";
  
  public static int getIntValueFromAttributes(AttributeSet paramAttributeSet, String paramString1, String paramString2)
  {
    int i = -1;
    if (paramAttributeSet != null) {
      i = paramAttributeSet.getAttributeIntValue(paramString1, paramString2, -1);
    }
    return i;
  }
  
  public static String getStringValueFromAttributes(AttributeSet paramAttributeSet, String paramString1, String paramString2)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramAttributeSet.getAttributeValue(paramString1, paramString2);
      if ((paramAttributeSet != null) && (!paramAttributeSet.equalsIgnoreCase("")) && (paramAttributeSet.length() > 0)) {
        return paramAttributeSet;
      }
    }
    return null;
  }
  
  public static int getUnsignedIntValueFromAttributes(AttributeSet paramAttributeSet, String paramString1, String paramString2)
  {
    int i = -1;
    if (paramAttributeSet != null) {
      i = paramAttributeSet.getAttributeUnsignedIntValue(paramString1, paramString2, -1);
    }
    return i;
  }
  
  public static void populateSettings(JtAdWidgetSettings paramJtAdWidgetSettings, AttributeSet paramAttributeSet, Context paramContext)
  {
    String str = getStringValueFromAttributes(paramAttributeSet, "http://www.jumptap.com/lib/android", "publisherId");
    if (str != null) {
      paramJtAdWidgetSettings.setPublisherId(str);
    }
    str = getStringValueFromAttributes(paramAttributeSet, "http://www.jumptap.com/lib/android", "siteId");
    if (str != null) {
      paramJtAdWidgetSettings.setSiteId(str);
    }
    str = getStringValueFromAttributes(paramAttributeSet, "http://www.jumptap.com/lib/android", "spotId");
    if (str != null) {
      paramJtAdWidgetSettings.setSpotId(str);
    }
    str = getStringValueFromAttributes(paramAttributeSet, "http://www.jumptap.com/lib/android", "host");
    if (str != null) {
      paramJtAdWidgetSettings.setHostURL(str);
    }
    str = getStringValueFromAttributes(paramAttributeSet, "http://www.jumptap.com/lib/android", "language");
    if (str != null) {
      paramJtAdWidgetSettings.setLanguage(str);
    }
    str = getStringValueFromAttributes(paramAttributeSet, "http://www.jumptap.com/lib/android", "adultContentType");
    if (str != null) {
      paramJtAdWidgetSettings.setAdultContentType(str);
    }
    str = getStringValueFromAttributes(paramAttributeSet, "http://www.jumptap.com/lib/android", "postalCode");
    if (str != null) {
      paramJtAdWidgetSettings.setPostalCode(str);
    }
    str = getStringValueFromAttributes(paramAttributeSet, "http://www.jumptap.com/lib/android", "country");
    if (str != null) {
      paramJtAdWidgetSettings.setCountry(str);
    }
    str = getStringValueFromAttributes(paramAttributeSet, "http://www.jumptap.com/lib/android", "age");
    if (str != null) {
      paramJtAdWidgetSettings.setAge(str);
    }
    str = getStringValueFromAttributes(paramAttributeSet, "http://www.jumptap.com/lib/android", "gender");
    if (str != null) {
      paramJtAdWidgetSettings.setGender(str);
    }
    str = getStringValueFromAttributes(paramAttributeSet, "http://www.jumptap.com/lib/android", "hhi");
    if (str != null) {
      paramJtAdWidgetSettings.setHHI(str);
    }
    str = getStringValueFromAttributes(paramAttributeSet, "http://www.jumptap.com/lib/android", "alternateImage");
    if (str != null) {
      setAlternativeImage(str, paramJtAdWidgetSettings, paramContext);
    }
    paramContext = getStringValueFromAttributes(paramAttributeSet, "http://www.jumptap.com/lib/android", "dismissLabel");
    if (paramContext != null) {
      paramJtAdWidgetSettings.setDismissButtonLabel(paramContext);
    }
    int i = getUnsignedIntValueFromAttributes(paramAttributeSet, "http://www.jumptap.com/lib/android", "alternateColor");
    if (i != -1) {
      paramJtAdWidgetSettings.setBackgroundColor(i);
    }
    i = getIntValueFromAttributes(paramAttributeSet, "http://www.jumptap.com/lib/android", "refreshPeriodInSec");
    if (i != -1) {
      paramJtAdWidgetSettings.setRefreshPeriod(i);
    }
    i = getIntValueFromAttributes(paramAttributeSet, "http://www.jumptap.com/lib/android", "interstitialTime");
    if (i != -1) {
      paramJtAdWidgetSettings.setInterstitialshowTime(i);
    }
    paramContext = getStringValueFromAttributes(paramAttributeSet, "http://www.jumptap.com/lib/android", "applicationId");
    if (paramContext != null) {
      paramJtAdWidgetSettings.setApplicationId(paramContext);
    }
    paramAttributeSet = getStringValueFromAttributes(paramAttributeSet, "http://www.jumptap.com/lib/android", "applicationVersion");
    if (paramAttributeSet != null) {
      paramJtAdWidgetSettings.setApplicationVersion(paramAttributeSet);
    }
  }
  
  private static void setAlternativeImage(String paramString, JtAdWidgetSettings paramJtAdWidgetSettings, Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    paramContext = paramContext.getPackageName();
    Log.d("JtAd", "Here is the parameter: " + paramString + " defaultPackage: " + paramContext);
    int i = localResources.getIdentifier(paramString, null, paramContext);
    if (i != 0) {
      try
      {
        paramJtAdWidgetSettings.setAlternateImage(((BitmapDrawable)localResources.getDrawable(i)).getBitmap());
        return;
      }
      catch (Resources.NotFoundException paramJtAdWidgetSettings)
      {
        Log.e("JtAd", "Cannot found Resource:" + paramString + ". Going to load system alternative image");
        Log.e("JtAd", paramJtAdWidgetSettings.getMessage());
        return;
      }
    }
    Log.e("JtAd", "Cannot found Resource:" + paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/utils/JtSettingsParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */