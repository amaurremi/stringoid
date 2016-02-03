package com.inmobi.commons.network;

import com.inmobi.commons.InMobi;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.data.AppInfo;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.data.LocationInfo;
import com.inmobi.commons.data.UserInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import com.inmobi.commons.uid.UIDHelper;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RequestBuilder
{
  private String a(Calendar paramCalendar)
  {
    String str = null;
    if (paramCalendar != null) {
      str = paramCalendar.get(1) + "-" + (paramCalendar.get(2) + 1) + "-" + paramCalendar.get(5);
    }
    return str;
  }
  
  public static String currentLocationStr()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((localStringBuilder != null) && (LocationInfo.isValidGeoInfo()))
    {
      localStringBuilder.append(LocationInfo.getLat());
      localStringBuilder.append(",");
      localStringBuilder.append(LocationInfo.getLon());
      localStringBuilder.append(",");
      localStringBuilder.append((int)LocationInfo.getLocAccuracy());
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
  
  public String buildPostBody()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      String str1 = getSDKDelegatePostBody();
      String str2 = getDevicePostBody();
      String str3 = getApplicationPostBody();
      String str4 = getPublisherPostBody();
      String str5 = getAdFormatPostBody();
      String str6 = getUidMapPostBody();
      if ((str1 != null) && (!"".equals(str1.trim()))) {
        localStringBuffer.append(str1);
      }
      if ((str2 != null) && (!"".equals(str2.trim()))) {
        localStringBuffer.append("&" + str2);
      }
      if ((str3 != null) && (!"".equals(str3.trim()))) {
        localStringBuffer.append("&" + str3);
      }
      if ((str4 != null) && (!"".equals(str4.trim()))) {
        localStringBuffer.append("&" + str4);
      }
      if ((str5 != null) && (!"".equals(str5.trim()))) {
        localStringBuffer.append("&" + str5);
      }
      if ((str6 != null) && (!"".equals(str6.trim()))) {
        localStringBuffer.append("&" + str6);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.debug("[InMobi]-4.1.1", "Exception occured in an ad request" + localException);
      }
    }
    return localStringBuffer.toString();
  }
  
  protected String getAdFormatPostBody()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("format=imai");
    localStringBuilder.append("&mk-ads=1");
    return localStringBuilder.toString();
  }
  
  protected String getApplicationPostBody()
  {
    for (;;)
    {
      try
      {
        localObject1 = new StringBuilder();
        if (AppInfo.getAppId() != null)
        {
          ((StringBuilder)localObject1).append("mk-siteid=");
          ((StringBuilder)localObject1).append(getURLEncoded(AppInfo.getAppId()));
          ((StringBuilder)localObject1).append("&mk-version=");
          localObject2 = "pr-SAND-" + InternalSDKUtil.getInMobiInternalVersion("4.1.1") + "-" + "20140131";
          ((StringBuilder)localObject1).append(getURLEncoded((String)localObject2));
          ((StringBuilder)localObject1).append("&mk-rel-version=");
          ((StringBuilder)localObject1).append(getURLEncoded((String)localObject2));
          ((StringBuilder)localObject1).append("&h-user-agent=");
          ((StringBuilder)localObject1).append(getURLEncoded(DeviceInfo.getPhoneDefaultUserAgent()));
          ((StringBuilder)localObject1).append("&u-appbid=");
          ((StringBuilder)localObject1).append(getURLEncoded(AppInfo.getAppBId()));
          ((StringBuilder)localObject1).append("&u-appDNM=");
          ((StringBuilder)localObject1).append(getURLEncoded(AppInfo.getAppDisplayName()));
          ((StringBuilder)localObject1).append("&u-appver=");
          ((StringBuilder)localObject1).append(getURLEncoded(AppInfo.getAppVer()));
          localObject1 = ((StringBuilder)localObject1).toString();
          localObject2 = localObject1;
        }
      }
      catch (Exception localException1)
      {
        Object localObject1;
        Object localObject2;
        Log.internal("[InMobi]-4.1.1", "Couldn't build post string in Request Builder", localException1);
        return null;
      }
      try
      {
        if (((String)localObject1).charAt(0) == '&') {
          localObject2 = ((String)localObject1).substring(1);
        }
        return (String)localObject2;
      }
      catch (Exception localException2)
      {
        Log.internal("[InMobi]-4.1.1", "Couldn't build post string in Request Builder", localException2);
      }
      ((StringBuilder)localObject1).append("mk-siteid=");
      ((StringBuilder)localObject1).append(getURLEncoded(InMobi.getAppId()));
    }
    return localException1;
  }
  
  protected String getDevicePostBody()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      if (DeviceInfo.getScreenDensity() != null) {
        ((StringBuilder)localObject1).append("d-device-screen-density=").append(getURLEncoded(DeviceInfo.getScreenDensity()));
      }
      if (DeviceInfo.getScreenSize() != null) {
        ((StringBuilder)localObject1).append("&d-device-screen-size=").append(getURLEncoded(DeviceInfo.getScreenSize()));
      }
      if (DeviceInfo.getOrientation() != 0)
      {
        ((StringBuilder)localObject1).append("&d-orientation=");
        ((StringBuilder)localObject1).append(DeviceInfo.getOrientation());
      }
      if (DeviceInfo.getAid() != null)
      {
        ((StringBuilder)localObject1).append("&aid=");
        ((StringBuilder)localObject1).append(getURLEncoded(DeviceInfo.getAid()));
      }
      if (DeviceInfo.getNetworkType() != null)
      {
        ((StringBuilder)localObject1).append("&d-netType=");
        ((StringBuilder)localObject1).append(getURLEncoded(DeviceInfo.getNetworkType()));
      }
      ((StringBuilder)localObject1).append("&d-localization=");
      ((StringBuilder)localObject1).append(getURLEncoded(DeviceInfo.getLocalization()));
      if (LocationInfo.isValidGeoInfo())
      {
        ((StringBuilder)localObject1).append("&u-latlong-accu=");
        ((StringBuilder)localObject1).append(getURLEncoded(currentLocationStr()));
        ((StringBuilder)localObject1).append("&u-ll-ts=");
        ((StringBuilder)localObject1).append(LocationInfo.getGeoTS());
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = localObject1;
      try
      {
        if (((String)localObject1).charAt(0) == '&') {
          localObject2 = ((String)localObject1).substring(1);
        }
        return (String)localObject2;
      }
      catch (Exception localException2)
      {
        Log.internal("[InMobi]-4.1.1", "Couldn't build post string in Request Builder", localException2);
        return (String)localObject1;
      }
      return null;
    }
    catch (Exception localException1)
    {
      Log.internal("[InMobi]-4.1.1", "Couldn't build post string in Request Builder", localException1);
    }
  }
  
  protected String getPublisherPostBody()
  {
    return null;
  }
  
  /* Error */
  protected String getSDKDelegatePostBody()
  {
    // Byte code:
    //   0: new 13	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: invokestatic 242	com/inmobi/commons/data/UserInfo:getInstance	()Lcom/inmobi/commons/data/UserInfo;
    //   11: astore 4
    //   13: invokestatic 246	com/inmobi/commons/internal/InternalSDKUtil:getContext	()Landroid/content/Context;
    //   16: invokestatic 252	com/inmobi/commons/thinICE/icedatacollector/IceDataCollector:getConnectedWifiInfo	(Landroid/content/Context;)Lcom/inmobi/commons/thinICE/wifi/WifiInfo;
    //   19: astore_2
    //   20: aload 4
    //   22: invokevirtual 255	com/inmobi/commons/data/UserInfo:getPostalCode	()Ljava/lang/String;
    //   25: ifnull +24 -> 49
    //   28: aload_3
    //   29: ldc_w 257
    //   32: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_3
    //   37: aload 4
    //   39: invokevirtual 255	com/inmobi/commons/data/UserInfo:getPostalCode	()Ljava/lang/String;
    //   42: invokestatic 138	com/inmobi/commons/network/RequestBuilder:getURLEncoded	(Ljava/lang/String;)Ljava/lang/String;
    //   45: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 4
    //   51: invokevirtual 260	com/inmobi/commons/data/UserInfo:getAreaCode	()Ljava/lang/String;
    //   54: ifnull +24 -> 78
    //   57: aload_3
    //   58: ldc_w 262
    //   61: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_3
    //   66: aload 4
    //   68: invokevirtual 260	com/inmobi/commons/data/UserInfo:getAreaCode	()Ljava/lang/String;
    //   71: invokestatic 138	com/inmobi/commons/network/RequestBuilder:getURLEncoded	(Ljava/lang/String;)Ljava/lang/String;
    //   74: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_0
    //   79: aload 4
    //   81: invokevirtual 266	com/inmobi/commons/data/UserInfo:getDateOfBirth	()Ljava/util/Calendar;
    //   84: invokespecial 268	com/inmobi/commons/network/RequestBuilder:a	(Ljava/util/Calendar;)Ljava/lang/String;
    //   87: astore 5
    //   89: aload 5
    //   91: ifnull +21 -> 112
    //   94: aload_3
    //   95: ldc_w 270
    //   98: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_3
    //   103: aload 5
    //   105: invokestatic 138	com/inmobi/commons/network/RequestBuilder:getURLEncoded	(Ljava/lang/String;)Ljava/lang/String;
    //   108: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 4
    //   114: invokevirtual 274	com/inmobi/commons/data/UserInfo:getGender	()Lcom/inmobi/commons/GenderType;
    //   117: ifnull +27 -> 144
    //   120: aload_3
    //   121: ldc_w 276
    //   124: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_3
    //   129: aload 4
    //   131: invokevirtual 274	com/inmobi/commons/data/UserInfo:getGender	()Lcom/inmobi/commons/GenderType;
    //   134: invokevirtual 279	com/inmobi/commons/GenderType:toString	()Ljava/lang/String;
    //   137: invokevirtual 282	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   140: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 4
    //   146: invokevirtual 285	com/inmobi/commons/data/UserInfo:getSearchString	()Ljava/lang/String;
    //   149: ifnull +24 -> 173
    //   152: aload_3
    //   153: ldc_w 287
    //   156: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_3
    //   161: aload 4
    //   163: invokevirtual 285	com/inmobi/commons/data/UserInfo:getSearchString	()Ljava/lang/String;
    //   166: invokestatic 138	com/inmobi/commons/network/RequestBuilder:getURLEncoded	(Ljava/lang/String;)Ljava/lang/String;
    //   169: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 4
    //   175: invokevirtual 291	com/inmobi/commons/data/UserInfo:getIncome	()Ljava/lang/Integer;
    //   178: invokevirtual 296	java/lang/Integer:intValue	()I
    //   181: ifle +21 -> 202
    //   184: aload_3
    //   185: ldc_w 298
    //   188: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_3
    //   193: aload 4
    //   195: invokevirtual 291	com/inmobi/commons/data/UserInfo:getIncome	()Ljava/lang/Integer;
    //   198: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload 4
    //   204: invokevirtual 302	com/inmobi/commons/data/UserInfo:getEducation	()Lcom/inmobi/commons/EducationType;
    //   207: ifnull +27 -> 234
    //   210: aload_3
    //   211: ldc_w 304
    //   214: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload_3
    //   219: aload 4
    //   221: invokevirtual 302	com/inmobi/commons/data/UserInfo:getEducation	()Lcom/inmobi/commons/EducationType;
    //   224: invokevirtual 307	com/inmobi/commons/EducationType:toString	()Ljava/lang/String;
    //   227: invokevirtual 282	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   230: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 4
    //   236: invokevirtual 311	com/inmobi/commons/data/UserInfo:getEthnicity	()Lcom/inmobi/commons/EthnicityType;
    //   239: ifnull +27 -> 266
    //   242: aload_3
    //   243: ldc_w 313
    //   246: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_3
    //   251: aload 4
    //   253: invokevirtual 311	com/inmobi/commons/data/UserInfo:getEthnicity	()Lcom/inmobi/commons/EthnicityType;
    //   256: invokevirtual 316	com/inmobi/commons/EthnicityType:toString	()Ljava/lang/String;
    //   259: invokevirtual 282	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   262: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 4
    //   268: invokevirtual 319	com/inmobi/commons/data/UserInfo:getAge	()Ljava/lang/Integer;
    //   271: invokevirtual 296	java/lang/Integer:intValue	()I
    //   274: ifle +21 -> 295
    //   277: aload_3
    //   278: ldc_w 321
    //   281: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_3
    //   286: aload 4
    //   288: invokevirtual 319	com/inmobi/commons/data/UserInfo:getAge	()Ljava/lang/Integer;
    //   291: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 4
    //   297: invokevirtual 324	com/inmobi/commons/data/UserInfo:getInterests	()Ljava/lang/String;
    //   300: ifnull +24 -> 324
    //   303: aload_3
    //   304: ldc_w 326
    //   307: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload_3
    //   312: aload 4
    //   314: invokevirtual 324	com/inmobi/commons/data/UserInfo:getInterests	()Ljava/lang/String;
    //   317: invokestatic 138	com/inmobi/commons/network/RequestBuilder:getURLEncoded	(Ljava/lang/String;)Ljava/lang/String;
    //   320: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload 4
    //   326: invokevirtual 329	com/inmobi/commons/data/UserInfo:getLocationWithCityStateCountry	()Ljava/lang/String;
    //   329: ifnull +24 -> 353
    //   332: aload_3
    //   333: ldc_w 331
    //   336: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload_3
    //   341: aload 4
    //   343: invokevirtual 329	com/inmobi/commons/data/UserInfo:getLocationWithCityStateCountry	()Ljava/lang/String;
    //   346: invokestatic 138	com/inmobi/commons/network/RequestBuilder:getURLEncoded	(Ljava/lang/String;)Ljava/lang/String;
    //   349: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 4
    //   355: invokevirtual 335	com/inmobi/commons/data/UserInfo:getMaritalStatus	()Lcom/inmobi/commons/MaritalStatus;
    //   358: ifnull +27 -> 385
    //   361: aload_3
    //   362: ldc_w 337
    //   365: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload_3
    //   370: aload 4
    //   372: invokevirtual 335	com/inmobi/commons/data/UserInfo:getMaritalStatus	()Lcom/inmobi/commons/MaritalStatus;
    //   375: invokevirtual 340	com/inmobi/commons/MaritalStatus:toString	()Ljava/lang/String;
    //   378: invokevirtual 282	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   381: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload 4
    //   387: invokevirtual 344	com/inmobi/commons/data/UserInfo:getHasChildren	()Lcom/inmobi/commons/HasChildren;
    //   390: ifnull +27 -> 417
    //   393: aload_3
    //   394: ldc_w 346
    //   397: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload_3
    //   402: aload 4
    //   404: invokevirtual 344	com/inmobi/commons/data/UserInfo:getHasChildren	()Lcom/inmobi/commons/HasChildren;
    //   407: invokevirtual 349	com/inmobi/commons/HasChildren:toString	()Ljava/lang/String;
    //   410: invokevirtual 282	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   413: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload 4
    //   419: invokevirtual 352	com/inmobi/commons/data/UserInfo:getLanguage	()Ljava/lang/String;
    //   422: ifnull +24 -> 446
    //   425: aload_3
    //   426: ldc_w 354
    //   429: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload_3
    //   434: aload 4
    //   436: invokevirtual 352	com/inmobi/commons/data/UserInfo:getLanguage	()Ljava/lang/String;
    //   439: invokestatic 138	com/inmobi/commons/network/RequestBuilder:getURLEncoded	(Ljava/lang/String;)Ljava/lang/String;
    //   442: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload 4
    //   448: invokevirtual 358	com/inmobi/commons/data/UserInfo:getSexualOrientation	()Lcom/inmobi/commons/SexualOrientation;
    //   451: ifnull +27 -> 478
    //   454: aload_3
    //   455: ldc_w 360
    //   458: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: aload_3
    //   463: aload 4
    //   465: invokevirtual 358	com/inmobi/commons/data/UserInfo:getSexualOrientation	()Lcom/inmobi/commons/SexualOrientation;
    //   468: invokevirtual 363	com/inmobi/commons/SexualOrientation:toString	()Ljava/lang/String;
    //   471: invokevirtual 282	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   474: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: invokestatic 365	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   481: astore 4
    //   483: invokestatic 370	java/lang/System:currentTimeMillis	()J
    //   486: pop2
    //   487: aload_3
    //   488: new 13	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   495: ldc_w 372
    //   498: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: aload 4
    //   503: invokevirtual 375	java/util/Calendar:getTimeInMillis	()J
    //   506: invokevirtual 236	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   509: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload_3
    //   517: ldc_w 377
    //   520: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: astore 5
    //   525: aload 4
    //   527: bipush 15
    //   529: invokevirtual 20	java/util/Calendar:get	(I)I
    //   532: istore_1
    //   533: aload 5
    //   535: aload 4
    //   537: bipush 16
    //   539: invokevirtual 20	java/util/Calendar:get	(I)I
    //   542: iload_1
    //   543: iadd
    //   544: invokevirtual 24	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: aload_2
    //   549: ifnull +31 -> 580
    //   552: aload_3
    //   553: new 13	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   560: ldc_w 379
    //   563: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: aload_2
    //   567: getfield 385	com/inmobi/commons/thinICE/wifi/WifiInfo:bssid	J
    //   570: invokevirtual 236	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   573: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: invokestatic 246	com/inmobi/commons/internal/InternalSDKUtil:getContext	()Landroid/content/Context;
    //   583: invokestatic 391	com/inmobi/commons/thinICE/cellular/CellUtil:getCurrentCellTower	(Landroid/content/Context;)Lcom/inmobi/commons/thinICE/cellular/CellTowerInfo;
    //   586: getfield 397	com/inmobi/commons/thinICE/cellular/CellTowerInfo:id	Ljava/lang/String;
    //   589: astore_2
    //   590: aload_2
    //   591: ifnull +37 -> 628
    //   594: ldc 57
    //   596: aload_2
    //   597: invokevirtual 106	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   600: ifne +28 -> 628
    //   603: aload_3
    //   604: new 13	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   611: ldc_w 399
    //   614: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload_2
    //   618: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload_3
    //   629: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: astore_2
    //   633: aload_2
    //   634: astore_3
    //   635: aload_2
    //   636: iconst_0
    //   637: invokevirtual 179	java/lang/String:charAt	(I)C
    //   640: bipush 38
    //   642: if_icmpne +9 -> 651
    //   645: aload_2
    //   646: iconst_1
    //   647: invokevirtual 183	java/lang/String:substring	(I)Ljava/lang/String;
    //   650: astore_3
    //   651: aload_3
    //   652: areturn
    //   653: astore_2
    //   654: ldc 114
    //   656: ldc_w 401
    //   659: invokestatic 403	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   662: aconst_null
    //   663: astore_2
    //   664: goto -644 -> 20
    //   667: astore_2
    //   668: ldc 114
    //   670: ldc_w 405
    //   673: aload_2
    //   674: invokestatic 192	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   677: goto -49 -> 628
    //   680: astore_2
    //   681: ldc 114
    //   683: ldc -68
    //   685: aload_2
    //   686: invokestatic 192	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   689: aconst_null
    //   690: areturn
    //   691: astore_3
    //   692: ldc 114
    //   694: ldc -68
    //   696: aload_3
    //   697: invokestatic 192	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   700: aload_2
    //   701: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	702	0	this	RequestBuilder
    //   532	12	1	i	int
    //   19	627	2	localObject1	Object
    //   653	1	2	localException1	Exception
    //   663	1	2	localObject2	Object
    //   667	7	2	localException2	Exception
    //   680	21	2	localException3	Exception
    //   7	645	3	localObject3	Object
    //   691	6	3	localException4	Exception
    //   11	525	4	localObject4	Object
    //   87	447	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   13	20	653	java/lang/Exception
    //   580	590	667	java/lang/Exception
    //   594	628	667	java/lang/Exception
    //   0	13	680	java/lang/Exception
    //   20	49	680	java/lang/Exception
    //   49	78	680	java/lang/Exception
    //   78	89	680	java/lang/Exception
    //   94	112	680	java/lang/Exception
    //   112	144	680	java/lang/Exception
    //   144	173	680	java/lang/Exception
    //   173	202	680	java/lang/Exception
    //   202	234	680	java/lang/Exception
    //   234	266	680	java/lang/Exception
    //   266	295	680	java/lang/Exception
    //   295	324	680	java/lang/Exception
    //   324	353	680	java/lang/Exception
    //   353	385	680	java/lang/Exception
    //   385	417	680	java/lang/Exception
    //   417	446	680	java/lang/Exception
    //   446	478	680	java/lang/Exception
    //   478	548	680	java/lang/Exception
    //   552	580	680	java/lang/Exception
    //   628	633	680	java/lang/Exception
    //   654	662	680	java/lang/Exception
    //   668	677	680	java/lang/Exception
    //   692	700	680	java/lang/Exception
    //   635	651	691	java/lang/Exception
  }
  
  protected String getUidMapPostBody()
  {
    String str1 = null;
    Object localObject3 = new HashMap();
    try
    {
      localObject1 = AnalyticsInitializer.getConfigParams().getLTVId();
      if (localObject1 != null) {
        ((Map)localObject3).put("LTVID", localObject1 + "");
      }
      String str2 = Integer.toString(new Random().nextInt());
      localObject3 = UID.getCommonsUid().getUidMap(UserInfo.getInstance().getDeviceIDMask(), str2, (Map)localObject3);
      StringBuilder localStringBuilder = new StringBuilder();
      localObject1 = str1;
      if (localObject3 != null)
      {
        localStringBuilder.append("u-id-map=");
        localStringBuilder.append(getURLEncoded((String)localObject3));
        localStringBuilder.append("&u-id-key=");
        localStringBuilder.append(str2);
        localStringBuilder.append("&u-key-ver=");
        localStringBuilder.append(UIDHelper.getRSAKeyVersion());
        str1 = localStringBuilder.toString();
        localObject1 = str1;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject1;
          if (str1.charAt(0) == '&') {
            localObject1 = str1.substring(1);
          }
          return (String)localObject1;
        }
        catch (Exception localException2)
        {
          Object localObject2;
          Log.internal("[InMobi]-4.1.1", "Couldn't build post string in Request Builder", localException2);
        }
        localException1 = localException1;
        Log.internal("[InMobi]-4.1.1", "LTVID not available yet in configs");
        localObject2 = null;
      }
    }
    return str1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/network/RequestBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */