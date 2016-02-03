package com.adfonic.android.api.request;

import com.adfonic.android.utils.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

public class UriRequestAdapter
{
  private static final String DATE_OF_BIRTH_FORMAT = "yyyyMMdd";
  private static final String DEFAULT_BEACON_TYPE = "metadata";
  private static final String DEFAULT_T_FORMAT = "json";
  private static final String DEFAULT_T_MARKUP = "1";
  private static final String D_DPID = "d.dpid";
  private static final String D_NAME = "d.name";
  private static final String D_ODIN1 = "d.odin-1";
  private static final String D_OSNAME = "d.osname";
  private static final String D_OSVER = "d.osver";
  private static final String D_SCREENSIZE = "d.screensize";
  private static final String ENCODING = "UTF-8";
  private static final String H_USER_AGENT = "h.user-agent";
  private static final String IS_TEST = "s.test";
  private static final String PROD_URL = "http://adfonic.net/ad/";
  private static final String R_CLIENT = "r.client";
  private static final String R_HW = "r.hw";
  private static final String R_MCCMNC = "r.mccmnc";
  private static final String R_NETCODE = "r.netcode";
  private static final String R_NETNAME = "r.netname";
  private static final String R_NETTYPE = "r.nettype";
  public static final String R_NETTYPE_MOBILE = "mobile";
  public static final String R_NETTYPE_WIFI = "wifi";
  private static final String R_ROAMING = "r.roaming";
  private static final String R_SIMNAME = "r.simname";
  private static final String T_BEACONS = "t.beacons";
  private static final String T_FORMAT = "t.format";
  private static final String T_MARKUP = "t.markup";
  private static final String U_AGE = "u.age";
  private static final String U_AGE_HIGH = "u.ageHigh";
  private static final String U_AGE_LOW = "u.ageLow";
  private static final String U_DOB = "u.dob";
  private static final String U_GENDER = "u.gender";
  private static final String U_LANG = "u.lang";
  private static final String U_LATITUDE = "u.latitude";
  private static final String U_LOCALE = "u.locale";
  private static final String U_LONGITUDE = "u.longitude";
  private static final String U_TZ = "u.tz";
  private StringBuilder builder;
  private AndroidRequest request;
  
  public UriRequestAdapter(AndroidRequest paramAndroidRequest)
  {
    if (paramAndroidRequest.getSlotId() == null) {
      throw new IllegalStateException("Request is invalid, slot id must be defined");
    }
    this.request = paramAndroidRequest;
    this.builder = new StringBuilder("http://adfonic.net/ad/");
  }
  
  private void append(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return;
    }
    Log.adRequestDetails("Adfonic Request Parameter: " + paramString1 + " = " + paramString2);
    this.builder.append(paramString1).append("=").append(encodeParameter(paramString2)).append("&");
  }
  
  private void appendSlotId()
  {
    this.builder.append(this.request.getSlotId());
  }
  
  private String convertToString(int paramInt)
  {
    if (paramInt <= 0) {
      return null;
    }
    return "" + paramInt;
  }
  
  private String encodeParameter(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return "";
  }
  
  private String getDateOfBirth()
  {
    if (this.request.getDateOfBirth() == null) {
      return null;
    }
    try
    {
      new SimpleDateFormat("yyyyMMdd").parse(this.request.getDateOfBirth());
      String str = this.request.getDateOfBirth();
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private String getGender()
  {
    if (!this.request.hasGender()) {
      return null;
    }
    if (this.request.isMale()) {
      return "m";
    }
    return "f";
  }
  
  private String getTestValue()
  {
    if (!this.request.isTest()) {
      return null;
    }
    return "1";
  }
  
  public String toUrl()
  {
    appendSlotId();
    this.builder.append("?");
    append("t.markup", "1");
    append("t.format", "json");
    append("t.beacons", "metadata");
    append("r.client", this.request.getAdfonicSdkVersion());
    append("d.dpid", this.request.getAndroidDeviceId());
    append("d.odin-1", this.request.getAndroidDeviceId());
    append("r.hw", this.request.getHardwareVersion());
    append("u.longitude", this.request.getLongitude());
    append("u.latitude", this.request.getLatitude());
    append("u.lang", this.request.getLanguage());
    append("u.ageHigh", convertToString(this.request.getAgeHigh()));
    append("u.ageLow", convertToString(this.request.getAgeLow()));
    append("u.age", convertToString(this.request.getAge()));
    append("u.dob", getDateOfBirth());
    append("u.tz", this.request.getTimeZone());
    append("u.locale", this.request.getLocale());
    append("u.gender", getGender());
    append("s.test", getTestValue());
    append("d.screensize", this.request.getScreenSize());
    append("d.name", this.request.getDeviceName());
    append("d.osname", this.request.getOsName());
    append("d.osver", this.request.getOsVersion());
    append("r.mccmnc", this.request.getOperator());
    append("r.nettype", this.request.getNetworkType());
    append("r.netcode", this.request.getNetworkCode());
    append("r.netname", this.request.getNetworkName());
    append("r.simname", this.request.getSimName());
    append("r.roaming", this.request.getRoaming());
    append("h.user-agent", this.request.getUserAgent());
    return this.builder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/api/request/UriRequestAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */