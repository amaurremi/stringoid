package com.adfonic.android.api.request;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.adfonic.android.api.Request;
import com.adfonic.android.utils.Log;

public class XmlAttributeRequestReader
{
  private static final String MAP_KEY_AD_HEIGHT = "ad_height";
  private static final String MAP_KEY_AD_WIDTH = "ad_width";
  private static final String MAP_KEY_ALLOW_LOCATION = "allow_location";
  private static final String MAP_KEY_LANGUAGE = "language";
  private static final String MAP_KEY_REFRESH_AD = "refresh_ad";
  private static final String MAP_KEY_REFRESH_TIME = "refresh_time";
  private static final String MAP_KEY_SLOT_ID = "adfonic_adslot_id";
  private static final String MAP_KEY_TEST_MODE = "test_mode";
  private static final String NS = "http://schemas.android.com/apk/lib/com.adfonic.android";
  
  private String getString(Resources paramResources, AttributeSet paramAttributeSet, String paramString1, String paramString2)
  {
    int i = paramAttributeSet.getAttributeResourceValue(paramString1, paramString2, -1);
    if (i != -1) {
      return paramResources.getString(i);
    }
    return paramAttributeSet.getAttributeValue(paramString1, paramString2);
  }
  
  private void setAdHeight(AttributeSet paramAttributeSet, Resources paramResources, Request paramRequest)
  {
    try
    {
      paramRequest.setAdHeight(Float.valueOf(getString(paramResources, paramAttributeSet, "http://schemas.android.com/apk/lib/com.adfonic.android", "ad_height")).floatValue());
      return;
    }
    catch (Exception paramAttributeSet)
    {
      Log.w("Please provide a values for attribute : ad_height");
    }
  }
  
  private void setAdWidth(AttributeSet paramAttributeSet, Resources paramResources, Request paramRequest)
  {
    try
    {
      paramRequest.setAdWidth(Float.valueOf(getString(paramResources, paramAttributeSet, "http://schemas.android.com/apk/lib/com.adfonic.android", "ad_width")).floatValue());
      return;
    }
    catch (Exception paramAttributeSet)
    {
      Log.w("Please provide a values for attribute : ad_width");
    }
  }
  
  private void setAllowLocation(AttributeSet paramAttributeSet, Request paramRequest)
  {
    try
    {
      paramRequest.setAllowLocation(paramAttributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/lib/com.adfonic.android", "allow_location", true));
      return;
    }
    catch (Exception paramAttributeSet)
    {
      Log.w("Problem reading allow_location value");
    }
  }
  
  private void setLanguage(AttributeSet paramAttributeSet, Resources paramResources, Request paramRequest)
  {
    try
    {
      paramRequest.setLanguage(getString(paramResources, paramAttributeSet, "http://schemas.android.com/apk/lib/com.adfonic.android", "language"));
      return;
    }
    catch (Exception paramAttributeSet)
    {
      Log.w("Problem reading refresh_time value");
    }
  }
  
  private void setRefreshAd(AttributeSet paramAttributeSet, Request paramRequest)
  {
    try
    {
      paramRequest.setRefreshAd(paramAttributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/lib/com.adfonic.android", "refresh_ad", true));
      return;
    }
    catch (Exception paramAttributeSet)
    {
      Log.w("Problem reading refresh_ad value");
    }
  }
  
  private void setRefreshTime(AttributeSet paramAttributeSet, Request paramRequest)
  {
    try
    {
      paramRequest.setRefreshTime(paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/lib/com.adfonic.android", "refresh_time", 20));
      return;
    }
    catch (Exception paramAttributeSet)
    {
      Log.w("Problem reading refresh_time value");
    }
  }
  
  private void setSlotId(AttributeSet paramAttributeSet, Resources paramResources, Request paramRequest)
  {
    try
    {
      paramRequest.setSlotId(getString(paramResources, paramAttributeSet, "http://schemas.android.com/apk/lib/com.adfonic.android", "adfonic_adslot_id"));
      return;
    }
    catch (Exception paramAttributeSet)
    {
      Log.w("Problem reading adfonic_adslot_id value");
    }
  }
  
  private void setTest(AttributeSet paramAttributeSet, Request paramRequest)
  {
    try
    {
      paramRequest.setTest(paramAttributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/lib/com.adfonic.android", "test_mode", false));
      return;
    }
    catch (Exception paramAttributeSet)
    {
      Log.w("Problem reading test_mode value");
    }
  }
  
  public Request convertToRequest(AttributeSet paramAttributeSet, Context paramContext)
  {
    paramContext = paramContext.getResources();
    Request localRequest = new Request();
    setSlotId(paramAttributeSet, paramContext, localRequest);
    setTest(paramAttributeSet, localRequest);
    setAllowLocation(paramAttributeSet, localRequest);
    setRefreshAd(paramAttributeSet, localRequest);
    setRefreshTime(paramAttributeSet, localRequest);
    setLanguage(paramAttributeSet, paramContext, localRequest);
    setAdWidth(paramAttributeSet, paramContext, localRequest);
    setAdHeight(paramAttributeSet, paramContext, localRequest);
    return localRequest;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/api/request/XmlAttributeRequestReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */