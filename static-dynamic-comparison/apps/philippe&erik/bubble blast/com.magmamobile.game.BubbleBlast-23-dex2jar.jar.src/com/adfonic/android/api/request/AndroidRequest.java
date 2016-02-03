package com.adfonic.android.api.request;

import com.adfonic.android.api.Request;

public class AndroidRequest
  extends Request
{
  private String adfonicSdkVersion;
  private String androidDeviceId;
  private int androidSdkVersion;
  private String deviceName;
  private String hardwareVersion;
  private String latitude;
  private String locale;
  private String longitude;
  private String networkCode;
  private String networkName;
  private String networkType;
  private String operator;
  private String osName;
  private String osVersion;
  private String roaming;
  private String screenSize;
  private String simName;
  private String timeZone;
  private String userAgent;
  
  public AndroidRequest() {}
  
  public AndroidRequest(Request paramRequest)
  {
    setAge(paramRequest.getAge());
    setAgeHigh(paramRequest.getAgeHigh());
    setAgeLow(paramRequest.getAgeLow());
    setDateOfBirth(paramRequest.getDateOfBirth());
    setLanguage(paramRequest.getLanguage());
    setLocation(paramRequest.getLocation());
    setRefreshTime(paramRequest.getRefreshTime());
    setSlotId(paramRequest.getSlotId());
    setMale(paramRequest.isMale());
    setHasGender(paramRequest.hasGender());
    setAllowLocation(paramRequest.isAllowLocation());
  }
  
  public String getAdfonicSdkVersion()
  {
    return this.adfonicSdkVersion;
  }
  
  public String getAndroidDeviceId()
  {
    return this.androidDeviceId;
  }
  
  public int getAndroidSdkVersion()
  {
    return this.androidSdkVersion;
  }
  
  public String getDeviceName()
  {
    return this.deviceName;
  }
  
  public String getHardwareVersion()
  {
    return this.hardwareVersion;
  }
  
  public String getLatitude()
  {
    return this.latitude;
  }
  
  public String getLocale()
  {
    return this.locale;
  }
  
  public String getLongitude()
  {
    return this.longitude;
  }
  
  public String getNetworkCode()
  {
    return this.networkCode;
  }
  
  public String getNetworkName()
  {
    return this.networkName;
  }
  
  public String getNetworkType()
  {
    return this.networkType;
  }
  
  public String getOperator()
  {
    return this.operator;
  }
  
  public String getOsName()
  {
    return this.osName;
  }
  
  public String getOsVersion()
  {
    return this.osVersion;
  }
  
  public String getRoaming()
  {
    return this.roaming;
  }
  
  public String getScreenSize()
  {
    return this.screenSize;
  }
  
  public String getSimName()
  {
    return this.simName;
  }
  
  public String getTimeZone()
  {
    return this.timeZone;
  }
  
  public String getUserAgent()
  {
    return this.userAgent;
  }
  
  public void setAdfonicSdkVersion(String paramString)
  {
    this.adfonicSdkVersion = paramString;
  }
  
  public void setAndroidDeviceId(String paramString)
  {
    this.androidDeviceId = paramString;
  }
  
  public void setAndroidSdkVersion(int paramInt)
  {
    this.androidSdkVersion = paramInt;
  }
  
  public void setDeviceName(String paramString)
  {
    this.deviceName = paramString;
  }
  
  public void setHardwareVersion(String paramString)
  {
    this.hardwareVersion = paramString;
  }
  
  public void setLatitude(String paramString)
  {
    this.latitude = paramString;
  }
  
  public void setLocale(String paramString)
  {
    this.locale = paramString;
  }
  
  public void setLongitude(String paramString)
  {
    this.longitude = paramString;
  }
  
  public void setNetworkCode(String paramString)
  {
    this.networkCode = paramString;
  }
  
  public void setNetworkName(String paramString)
  {
    this.networkName = paramString;
  }
  
  public void setNetworkType(String paramString)
  {
    this.networkType = paramString;
  }
  
  public void setOperator(String paramString)
  {
    this.operator = paramString;
  }
  
  public void setOsName(String paramString)
  {
    this.osName = paramString;
  }
  
  public void setOsVersion(String paramString)
  {
    this.osVersion = paramString;
  }
  
  public void setRoaming(String paramString)
  {
    this.roaming = paramString;
  }
  
  public void setScreenSize(String paramString)
  {
    this.screenSize = paramString;
  }
  
  public void setSimName(String paramString)
  {
    this.simName = paramString;
  }
  
  public void setTimeZone(String paramString)
  {
    this.timeZone = paramString;
  }
  
  public void setUserAgent(String paramString)
  {
    this.userAgent = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/api/request/AndroidRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */